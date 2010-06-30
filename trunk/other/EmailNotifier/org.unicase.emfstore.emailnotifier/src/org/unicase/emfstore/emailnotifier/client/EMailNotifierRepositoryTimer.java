/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Status;
import org.unicase.emfstore.emailnotifier.Activator;
import org.unicase.emfstore.emailnotifier.client.util.Helper;
import org.unicase.emfstore.emailnotifier.email.MailerInfo;
import org.unicase.emfstore.emailnotifier.exception.NoNextSendingException;
import org.unicase.emfstore.emailnotifier.exception.NotificationGroupNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.ProjectNotFoundException;
import org.unicase.emfstore.emailnotifier.store.EMailNotifierStore;
import org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup;
import org.unicase.emfstore.emailnotifier.store.ENSNotificationProject;
import org.unicase.emfstore.emailnotifier.store.ENSUser;
import org.unicase.emfstore.emailnotifier.store.SendOption;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.notification.NotificationProvider;

/**
 * This class checks periodically the email notifier store. Only aggregated notification groups will 
 * be taken in consideration by this class. If the sending option is set to immediately, this option will be ignored.
 * If a notification group should be send immediately, this action will be triggered directly by the BackchannelListener.
 * 
 * @author staudta
 */
public class EMailNotifierRepositoryTimer implements Runnable {
	
	private boolean isENSDirty;
	
	private final EMailNotifierStore emailNotifierStore;
	private final Usersession usersession;
	private final MailerInfo mailerInfo;
	
	/**
	 * Constructor.
	 * 
	 * @param emailNotifierStore email notifier store
	 * @param usersession the usersession of the server admin
	 * @param mailerInfo info for the mail service
	 */
	public EMailNotifierRepositoryTimer(EMailNotifierStore emailNotifierStore, Usersession usersession, MailerInfo mailerInfo) {
		this.emailNotifierStore = emailNotifierStore;
		this.usersession = usersession;
		this.mailerInfo = mailerInfo;
	}
	
	/**
	 * Will execute this to run this class in an extra thread.
	 * The NPC storage will be locked while it is inspected. This is only done periodically and not the whole execution time.
	 */
	public void run() {
		while (true) {
			try {
				long maxWaitTime = 0;
				synchronized (emailNotifierStore) {
					reRun();
					
					// create new NotificationGroups if necessary - synchronization will do this if necessary
					List<ACUser> acUsers = usersession.getAdminBroker().getUsers();
					for(ProjectInfo remoteProjectInfo: usersession.getRemoteProjectList() ) {
						// check if project is local also available
						try {
							Helper.getLocalProject(remoteProjectInfo.getProjectId());
						} catch(ProjectNotFoundException e) {
							// checkout
							Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
							ProjectInfo remoteProject = Helper.getRemoteProject(usersession, remoteProjectInfo.getProjectId());
							Helper.checkout(workspace, usersession, remoteProject);
						}
							
						for(ACUser acUser: acUsers) {
							ProjectId projectId = remoteProjectInfo.getProjectId();
							new SynchronizeEMailNotifierStore(emailNotifierStore, acUser, projectId).synchronize();
						}
					}
					
					// get max sleeping time
					Date now = new Date();
					try {
						Date overallNextSending = getOverallNextSending();
						
						maxWaitTime = overallNextSending.getTime() - now.getTime();
						if( maxWaitTime < 0 ) {
							maxWaitTime = 1;
						}
						
					} catch(NoNextSendingException e) {
						maxWaitTime = -1;
					}
				}
				
				// wait for next notification group time overflow
				synchronized(Thread.currentThread()) {
					
					try {
						if( maxWaitTime == -1 ) { // nothing to send yet
							Thread.currentThread().wait();
							
						} else {
							Thread.currentThread().wait(maxWaitTime + 1000); // 1 second for assured time overflow
						}
						
					} catch (InterruptedException e) {
						Activator.logException(e);
					}
				}

			} catch (Exception e) {
				// Try to keep running. Throwing here an exception will terminate this thread.
				// Write this error to the log.
				Activator.logException(e);
			}
		}

	}
	
	/**
	 * The ENS storage will be inspected if there is something to send.
	 * 
	 * @throws EmfStoreException 
	 * @throws IOException 
	 * @throws EmfStoreException 
	 * @throws ProjectNotFoundException 
	 * @throws NotificationGroupNotFoundException 
	 */
	private void reRun() throws EmfStoreException {
		List<ENSNotificationProject> ensNotificationProjectToBeDeleted = new ArrayList<ENSNotificationProject>();
		
		for (ENSNotificationProject ensNotificationProject: emailNotifierStore.getProjects()) {
			final ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();
			projectId.setId(ensNotificationProject.getId());
			ProjectSpace projectSpace = null;
			try {
				projectSpace = Helper.getLocalProject(projectId);
			
			} catch (ProjectNotFoundException e) {
				// project is in email notifier store still existent, but the project has been deleted on the server.
				// delete all ensNotificationProject, no more notifications
				ensNotificationProjectToBeDeleted.add( ensNotificationProject );
			}
			
			List<ENSUser> ensUserToBeDeleted = new ArrayList<ENSUser>();
			for(ENSUser ensUser: ensNotificationProject.getUsers()) {
				if( ensUser.getGroups().isEmpty() ) {
					ensUserToBeDeleted.add( ensUser );
				}
				
				handleENSUser(projectSpace, projectId, ensNotificationProject, ensUser);
			}
			
			if( !ensUserToBeDeleted.isEmpty() ) {
				ensNotificationProject.getUsers().removeAll( ensUserToBeDeleted );
				isENSDirty = true;
			}
		}
		
		if( !ensNotificationProjectToBeDeleted.isEmpty() ) {
			emailNotifierStore.getProjects().removeAll( ensNotificationProjectToBeDeleted );
			isENSDirty = true;
		}
		
		try {
			if( isENSDirty ) {
				emailNotifierStore.eResource().save(Collections.EMPTY_MAP);
				isENSDirty = false;
			}
			
		} catch(IOException e) {
			Activator.logException(e);
		}
	}
	
	/**
	 * Identifies for a ensUser if notification emails must be send. Only aggregated ENSNotificationGroups will be considered.
	 * 
	 * @param projectSpace the projectSpace for the current inspected ENSNotificationProject
	 * @param projectId the corresponding projectId
	 * @param ensNotificationProject the corresponding ensNotificationProject
	 * @param ensUser a ensUser for that the ENSNotificationGroups will be inspected.
	 * @throws EmfStoreException can be thrown if the generation of notifications fails
	 */
	private void handleENSUser(ProjectSpace projectSpace, ProjectId projectId, ENSNotificationProject ensNotificationProject, ENSUser ensUser) throws EmfStoreException {
		final Date now = new Date();
		
		List<ENSNotificationGroup> ensNotificationGroupToBeDeleted = new ArrayList<ENSNotificationGroup>();
		for(ENSNotificationGroup ensNotificationGroup: ensUser.getGroups()) {
			// handle only aggregated NGs
			if( !ensNotificationGroup.getSendOption().equals(SendOption.AGGREGATED) ) {
				continue;
			}
			
			Date nextSending = ensNotificationGroup.getNextSendingDate();
			if(nextSending.after(now)) {
				// no time overflow yet
				continue;
			}
			
			try {
				EMailNotifierMailerPreparer mailerPreparer = new EMailNotifierMailerPreparer(projectSpace, ensUser, mailerInfo);
				Map<NotificationProvider, List<ESNotification>> generateNotifications = mailerPreparer.generateNotifications(ensNotificationGroup.getBaseVersion(), ensNotificationProject.getLatestVersion());
				List<ESNotification> relevantNotifications = mailerPreparer.getRelevantNotifications(usersession, ensNotificationGroup, generateNotifications);
				
				if( relevantNotifications.isEmpty() ) {
					// nothing was gathered for this periode
					ensNotificationGroupToBeDeleted.add( ensNotificationGroup );
					continue;
				}
				
				// there are notifications, send an email
				boolean sended = mailerPreparer.sendEMail(ensNotificationGroup, relevantNotifications);
				if( sended ) {
					// remove from store
					ensNotificationGroupToBeDeleted.add( ensNotificationGroup );
					
				} else {
					// else, don't remove sending was unsuccessful
					Activator.log(Status.ERROR, "E-Mail sending error with notification group "+ ensNotificationGroup.getName() +".");
				}
				
			} catch(NotificationGroupNotFoundException e) {
				// A User has changed some properties, but no ProjectUpdate occurred yet.
				// TODO: This issue should be solved with an PropertyChangedServerEvent for the backchannel
				ensNotificationGroupToBeDeleted.add( ensNotificationGroup );
			}
		}
		
		if( !ensNotificationGroupToBeDeleted.isEmpty() ) {
			ensUser.getGroups().removeAll( ensNotificationGroupToBeDeleted );
			isENSDirty = true;
		}
	}
	
	/**
	 * Calculates the next sending time for this ENS. From this date it is possible to calculate the sleeping interval for this thread.
	 * Only aggregated ENSNotificationGroups are take into consideration. 
	 * 
	 * @return the next sending time.
	 * @throws NoNextSendingException if no aggregated ENSNotificationGroup is contained in the ENS
	 */
	private Date getOverallNextSending() throws NoNextSendingException {
		Date nextSending = null;
		
		for(ENSNotificationProject ensNotificationProject: emailNotifierStore.getProjects()) {
			for(ENSUser ensUser: ensNotificationProject.getUsers()) {
				for(ENSNotificationGroup ensNotificationGroup: ensUser.getGroups()) {
					if( ensNotificationGroup.getSendOption().equals( SendOption.AGGREGATED ) ) {
						if( nextSending == null || ensNotificationGroup.getNextSendingDate().before(nextSending)) {
							nextSending = ensNotificationGroup.getNextSendingDate();
						}
					}
				}
			}
		}
		
		if( nextSending == null ) {
			throw new NoNextSendingException();
		} else {
			return nextSending;
		}
	}
}

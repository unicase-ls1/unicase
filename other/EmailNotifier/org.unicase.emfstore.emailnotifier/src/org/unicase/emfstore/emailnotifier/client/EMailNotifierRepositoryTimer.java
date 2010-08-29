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
import org.unicase.emfstore.emailnotifier.email.MailNotSendException;
import org.unicase.emfstore.emailnotifier.email.MailerInfo;
import org.unicase.emfstore.emailnotifier.exception.EMailNotifierException;
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
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
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
//		try {
//			// I don't know really why this is necessary, but without the session is not initialized.
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			Activator.logException(e);
//		}
		
		while (true) {
			try {
				long maxWaitTime = 0;
				synchronized (emailNotifierStore) {
					// checks if there are NotificationGroups that must be send now, 
					// if so they will be also send and on success removed from the ENS.
					checkEmailNotifierStore();
					
					// create new NotificationGroups if necessary - synchronization will do this if necessary
					List<ACUser> acUsers = usersession.getAdminBroker().getUsers();
					for(ProjectInfo remoteProjectInfo: usersession.getRemoteProjectList() ) {
						// check if project is also locally available
						try {
							Helper.getLocalProject(usersession, remoteProjectInfo.getProjectId());
						
						} catch(ProjectNotFoundException e) {
							try {
								// checkout
								ProjectInfo remoteProject = Helper.getRemoteProject(usersession, remoteProjectInfo.getProjectId());
								Helper.checkout(usersession, remoteProject);
							} catch(ProjectNotFoundException ex) {
								// can only happen if the project has been created and than immediately deleted
								Activator.logException(ex);
							}
						}
						
						for(ACUser acUser: acUsers) {
							ProjectId projectId = remoteProjectInfo.getProjectId();
							PrimaryVersionSpec version = remoteProjectInfo.getVersion();
							boolean madeDirty = PropertySychronizer.synchronize(emailNotifierStore, acUser, projectId, version);
							if( madeDirty ) {
								isENSDirty = true;
							}
						}
					}
					
					// save state
					try {
						if( isENSDirty ) {
							save();
							isENSDirty = false;
						}
						
					} catch(IOException e) {
						Activator.logException(e);
					}
					
					// get max sleeping time
					maxWaitTime = getMaxSleepTime();
				}
				
				// wait for next notification group time overflow
				waitForExecution(maxWaitTime);

			} catch (EMailNotifierException e) {
				Activator.logException(e);
				Thread.currentThread().interrupt();
			
			} catch (AccessControlException e) {
				Activator.logException(e);
				Thread.currentThread().interrupt();
			
			} catch (EmfStoreException e) {
				Activator.logException(e);
				Thread.currentThread().interrupt();
			}
		}

	}
	
	
	/**
	 * Calculates the time for sending the next aggregated NotificationGroup.
	 * 
	 * @return -1 if there is no next sending
	 */
	private long getMaxSleepTime() {
		long maxWaitTime = 0;
		Date now = new Date();
		try {
			Date overallNextSending = getOverallNextSending();
			maxWaitTime = overallNextSending.getTime() - now.getTime();
			
		} catch(NoNextSendingException e) {
			maxWaitTime = -1;
		}
		
		return maxWaitTime;
	}
	
	/**
	 * This thread will wait as long as maxWaitTime.
	 * 
	 * @param maxWaitTime time to wait
	 */
	private void waitForExecution(long maxWaitTime) {
		synchronized(Thread.currentThread()) {
			
			try {
				// Thread.currentThread().wait(0) -> will wait till notify
				// Thread.currentThread().wait(1) -> will wait 1ms and will then continue processing
				// Thread.sleep(0) -> will continue processing immediately
				if( maxWaitTime == -1 ) { // nothing to send yet
					Thread.currentThread().wait();
					
				} else if(maxWaitTime <= 0) {
					Thread.currentThread().wait(1);
				} else {
					Thread.currentThread().wait(maxWaitTime);
				}
				
			} catch (InterruptedException e) {
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
	private void checkEmailNotifierStore() throws EmfStoreException {
		// check if all projects are also locally available
		List<ENSNotificationProject> ensNotificationProjectToBeDeleted = new ArrayList<ENSNotificationProject>();
		for (ENSNotificationProject ensNotificationProject: emailNotifierStore.getProjects()) {
			final ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();
			projectId.setId(ensNotificationProject.getId());
			try {
				Helper.getLocalProject(usersession, projectId);
			
			} catch (ProjectNotFoundException e) {
				// project is in email notifier store still existent, but the project has been deleted on the server.
				// delete all ensNotificationProject, no more notifications
				ensNotificationProjectToBeDeleted.add( ensNotificationProject );
			}
		}
		
		List<ENSNotificationGroup> sendNotificationGroup = sendNotificationGroup();
		cleanEmailNotifierStore(ensNotificationProjectToBeDeleted, sendNotificationGroup);
	}
	
	/**
	 * Will check whole ENS, if there are some aggregated ENSNotificationGroups that must be sent now.
	 * 
	 * @return This list returns all ENSNotificationGroups that have been sent
	 * @throws EmfStoreException can happen while generation notifications
	 */
	private List<ENSNotificationGroup> sendNotificationGroup() throws EmfStoreException {
		final Date now = new Date();
		List<ENSNotificationGroup> sentENSNotificationGroups = new ArrayList<ENSNotificationGroup>();
		
		for(ENSNotificationProject ensNotificationProject: emailNotifierStore.getProjects()) {
			final ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();
			projectId.setId(ensNotificationProject.getId());
			try {
				ProjectSpace projectSpace = Helper.getLocalProject(usersession, projectId);
				
				for(ENSUser ensUser: ensNotificationProject.getUsers()) {
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
							EMailNotifierMailHelper mailHelper = new EMailNotifierMailHelper(projectSpace, ensUser, mailerInfo);
							Map<NotificationProvider, List<ESNotification>> generateNotifications = mailHelper.generateNotifications(ensNotificationGroup.getBaseVersion(), ensNotificationProject.getLatestVersion());
							List<ESNotification> relevantNotifications = mailHelper.getRelevantNotifications(usersession, ensNotificationGroup, generateNotifications);
							
							if( relevantNotifications.isEmpty() ) {
								// nothing was gathered for this period
								sentENSNotificationGroups.add( ensNotificationGroup );
								continue;
							}
							
							
							// there are notifications, send an email
							try {
								mailHelper.sendEMail(ensNotificationGroup, relevantNotifications);
								// remove from store
								sentENSNotificationGroups.add( ensNotificationGroup );
								
							} catch (MailNotSendException e) {
								// else, don't remove sending was unsuccessful
								Activator.log(Status.ERROR, "E-Mail sending error with notification group "+ ensNotificationGroup.getName() +".");
								Activator.logException(e);
							}
							
						} catch(NotificationGroupNotFoundException e) {
							// A User has changed some properties, but no ProjectUpdate occurred yet.
							// TODO: This issue should be solved with an PropertyChangedServerEvent for the backchannel
							sentENSNotificationGroups.add( ensNotificationGroup );
						}
					}
				}
				
			} catch (ProjectNotFoundException e) {
				// project must be at this point available.
				// If it is not, the project has been deleted from the EMFStore, therefore no notification must be send.
				// can be ignored
			}
		}
		
		return sentENSNotificationGroups;
	}
	
	/**
	 * Will clean the ENS. ENSUser without NotificationGroups will be deleted, and ENSProjects without ENSUsers will be also deleted.
	 * Running only once, this method will probably not clean everything. But this behavior is okay and expected.
	 * It is not necessary enforce to delete all ENSProjects, since the PropertySynchronizer will recreate these projects with a high probability. Same for ENSUser
	 * If they weren't recreated by the PropertySynchronizer, they will be deleted in the next or two executions next to this execution.
	 * 
	 * @param ensNotificationProjectToBeDeleted projects that exist in the ENS but no longer on the EMFStore
	 * @param sendNotificationGroup groups that have been sucessfully sent
	 */
	private void cleanEmailNotifierStore(List<ENSNotificationProject> ensNotificationProjectToBeDeleted, List<ENSNotificationGroup> sendNotificationGroup) {
		for(ENSNotificationProject ensNotificationProject: emailNotifierStore.getProjects()) {
			if( ensNotificationProject.getUsers().isEmpty() ) {
				if( !ensNotificationProjectToBeDeleted.contains(ensNotificationProject) ) {
					ensNotificationProjectToBeDeleted.add(ensNotificationProject);
				}
			} else {
				List<ENSUser> ensUserToBeDeleted = new ArrayList<ENSUser>();
				for(ENSUser ensUser: ensNotificationProject.getUsers()) {
					if( ensUser.getGroups().isEmpty() ) {
						ensUserToBeDeleted.add(ensUser);
					} else {
						List<ENSNotificationGroup> ensNotificationGroupToBeDeleted = new ArrayList<ENSNotificationGroup>();
						for(ENSNotificationGroup ensNotificationGroup: ensUser.getGroups()) {
							if( sendNotificationGroup.contains(ensNotificationGroup) ) {
								ensNotificationGroupToBeDeleted.add(ensNotificationGroup);
							}
						}
						
						if( !ensNotificationGroupToBeDeleted.isEmpty() ) {
							ensUser.getGroups().removeAll( ensNotificationGroupToBeDeleted );
							isENSDirty = true;
						}
					}
				}
				
				if( !ensUserToBeDeleted.isEmpty() ) {
					ensNotificationProject.getUsers().removeAll( ensUserToBeDeleted );
					isENSDirty = true;
				}
			}
		}
		
		if( !ensNotificationProjectToBeDeleted.isEmpty() ) {
			emailNotifierStore.getProjects().removeAll( ensNotificationProjectToBeDeleted );
			isENSDirty = true;
		}
		
		try {
			if( isENSDirty ) {
				save();
				isENSDirty = false;
			}
			
		} catch(IOException e) {
			Activator.logException(e);
		}
		
	}
	
	private void save() throws IOException {
		emailNotifierStore.eResource().save(Collections.EMPTY_MAP);
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

/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.client;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Status;
import org.unicase.emfstore.emailnotifier.Activator;
import org.unicase.emfstore.emailnotifier.client.util.Helper;
import org.unicase.emfstore.emailnotifier.email.MailNotSendException;
import org.unicase.emfstore.emailnotifier.email.MailerInfo;
import org.unicase.emfstore.emailnotifier.exception.EMailNotifierException;
import org.unicase.emfstore.emailnotifier.exception.ENSUserNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.NotificationGroupNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.ProjectNotFoundException;
import org.unicase.emfstore.emailnotifier.store.EMailNotifierStore;
import org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup;
import org.unicase.emfstore.emailnotifier.store.ENSNotificationProject;
import org.unicase.emfstore.emailnotifier.store.ENSUser;
import org.unicase.emfstore.emailnotifier.store.SendOption;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.events.server.ProjectUpdatedEvent;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Class will handle incoming server events.
 * 
 * @author staudta
 */
public class EMailNotifierProjectListener implements EMFStoreEventListener {
	
	private final EMailNotifierStore emailNotifierStore;
	private final MailerInfo mailerInfo;
	private final Usersession usersession;
	private final Thread notifierProxyClientRepositoryTimerThread;
	
	/**
	 * Constructor. projectInfoMap and projectSpaceMap have the same size. For both maps the key attribute is the ProjectId.
	 * 
	 * @param emailNotifierStore email notifier store
	 * @param usersession usersession of the admin
	 * @param mailerInfo properties that contains the information for sending an email
	 * @param notifierProxyClientRepositoryTimerThread the thread that observes a certain repository
	 */
	public EMailNotifierProjectListener(EMailNotifierStore emailNotifierStore, Usersession usersession, MailerInfo mailerInfo, Thread notifierProxyClientRepositoryTimerThread) {
		this.emailNotifierStore = emailNotifierStore;
		this.usersession = usersession;
		this.mailerInfo = mailerInfo;
		this.notifierProxyClientRepositoryTimerThread = notifierProxyClientRepositoryTimerThread;
	}
	
	/**
	 * This method will be called from the backchannel.
	 * 
	 * @param event the server event
	 * @return event if the event has been handled
	 */
	public boolean handleEvent(ServerEvent event) {
		try {
			if( event instanceof ProjectUpdatedEvent ) {
				ProjectUpdatedEvent projectUpdatedEvent = (ProjectUpdatedEvent) event;
				final ProjectId projectId = projectUpdatedEvent.getProjectId();
				ProjectSpace projectSpaceTmp;
				try {
					projectSpaceTmp = Helper.getLocalProject(usersession, projectId);
				} catch(ProjectNotFoundException e) {
					// checkout
					ProjectInfo remoteProject = Helper.getRemoteProject(usersession, projectId);
					projectSpaceTmp = Helper.checkout(usersession, remoteProject);
				}
				final ProjectSpace projectSpace = projectSpaceTmp;
				
				// update local projectSpace. Is needed for e-mail check
				new UnicaseCommand() {
					
					@Override
					protected void doRun() {
						try {
							projectSpace.update();
						} catch (EmfStoreException e) {
							Activator.logException(e);
						}
						
					}
				}.run();
				
				// set new version to ENSNotificationProject
				ENSNotificationProject ensNotificationProject = Helper.obtainENSNotificationProject(emailNotifierStore, projectId, null); // was made dirty is here uninteresting, it will be dirty anyway
				ensNotificationProject.setLatestVersion( projectUpdatedEvent.getNewVersion().getIdentifier() );
				
				List<ACUser> acUsers = projectSpace.getUsersession().getAdminBroker().getUsers();
				for(ACUser acUser: acUsers) {
					// synchronize acUser properties with the ENS state.
					// the ENS Project must exist at this point, so the synchronize method will not create a new ENS Project.
					// The parameter remoteProjectVersion is in this case unneeded.
					PropertySychronizer.synchronize(emailNotifierStore, acUser, projectId, null);
					
					ENSUser ensUser;
					try {
						ensUser = Helper.getENSUser(ensNotificationProject, acUser.getName());
					
					} catch (ENSUserNotFoundException e) {
						// there are no notification groups for this user at all,
						// especially no one for immediately sending
						continue;
					}
					
					// send emails for immediately configured notification groups
					EMailNotifierMailHelper mailHelper = new EMailNotifierMailHelper(projectSpace, ensUser, mailerInfo);
					List<ENSNotificationGroup> ensNotificationGroupsImmediately = getENSNotificationGroupsMarkedAsImmediately(ensUser);
					for(ENSNotificationGroup ensNotificationGroupImmediately: ensNotificationGroupsImmediately) {
						Map<NotificationProvider, List<ESNotification>> generateNotifications = mailHelper.generateNotifications(ensNotificationGroupImmediately.getBaseVersion(), ensNotificationProject.getLatestVersion());
						
						List<ESNotification> relevantNotifications = mailHelper.getRelevantNotifications(usersession, ensNotificationGroupImmediately, generateNotifications);
						
						if( relevantNotifications.isEmpty() ) {
							// nothing was gathered for this period
							// recycle notification group. reset base version to latest project version
							ensNotificationGroupImmediately.setBaseVersion( ensNotificationProject.getLatestVersion() );
							continue;
						}
						
						// there are notifications, send an email
						try {
							mailHelper.sendEMail(ensNotificationGroupImmediately, relevantNotifications);
							// recycle notification group. reset base version to latest project version
							ensNotificationGroupImmediately.setBaseVersion( ensNotificationProject.getLatestVersion() );
							
						} catch (MailNotSendException e) {
							// else, don't remove sending was unsuccessful
							Activator.log(Status.ERROR, "E-Mail sending error with notification group "+ ensNotificationGroupImmediately.getName() +".");
							Activator.logException(e);
						}
					}
				}
				
				emailNotifierStore.eResource().save(Collections.EMPTY_MAP);
				
				// wake up notifierProxyClientRepositoryTimerThread, maybe a aggregated groups has been changed
				synchronized (notifierProxyClientRepositoryTimerThread) {
					notifierProxyClientRepositoryTimerThread.notify();
				}
				
				return true;
			}
		
		} catch(EmfStoreException e) {
			// unexpected error
			Activator.logException(e);
		} catch (IOException e) {
			// unexpected error
			Activator.logException(e);
		} catch (ProjectNotFoundException e) {
			// unexpected error
			Activator.logException(e);
		} catch (NotificationGroupNotFoundException e) {
			// unexpected error
			Activator.logException(e);
		} catch (EMailNotifierException e) {
			// unexpected error
			Activator.logException(e);
		}
		
		return false;
	}
	
	/**
	 * Returns a list of ENSNotificationGroup for a certain ensUser, but only these that are marked for immediately sending.
	 * 
	 * @param ensUser the ensUser that is examined
	 * @return a list of ENSNotificationGroup with immediately sending
	 */
	private static List<ENSNotificationGroup> getENSNotificationGroupsMarkedAsImmediately(ENSUser ensUser) {
		List<ENSNotificationGroup> ensNotificationGroups = new LinkedList<ENSNotificationGroup>();
		
		for(ENSNotificationGroup ensNotificationGroup: ensUser.getGroups()) {
			if( ensNotificationGroup.getSendOption().equals( SendOption.IMMEDIATELY ) ) {
				ensNotificationGroups.add( ensNotificationGroup );
			}
		}
		
		return ensNotificationGroups;
	}
}

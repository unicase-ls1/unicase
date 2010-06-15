/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.proxyclient.notifier.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.model.organization.User;
import org.unicase.proxyclient.notifier.Activator;
import org.unicase.proxyclient.notifier.email.Mailer;
import org.unicase.proxyclient.notifier.email.MailerInfo;
import org.unicase.proxyclient.notifier.store.model.NotificationEntry;
import org.unicase.proxyclient.notifier.store.model.NotificationGroup;
import org.unicase.proxyclient.notifier.store.model.NotificationProject;
import org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore;
import org.unicase.ui.common.util.CannotMatchUserInProjectException;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.workspace.ProjectSpace;

/**
 * @author staudta
 */
public class NotifierProxyClientRepositoryTimer implements Runnable {
	
	private boolean isNPCStoreDirty;
	
	private final NotifierProxyClientStore npcStore;
	private final Map<ProjectId, ProjectSpace> projectSpaceMap;
	private final MailerInfo mailerInfo;
	
	/**
	 * Constructor.
	 * 
	 * @param npcStore notification proxy client storage
	 * @param projectSpaceMap map of project space objects
	 * @param mailerInfo info for the mail service
	 */
	public NotifierProxyClientRepositoryTimer(NotifierProxyClientStore npcStore, Map<ProjectId, ProjectSpace> projectSpaceMap, MailerInfo mailerInfo) {
		this.npcStore = npcStore;
		this.projectSpaceMap = projectSpaceMap;
		this.mailerInfo = mailerInfo;
	}
	
	/**
	 * Will execute this to run this class in an extra thread.
	 * The NPC storage will be locked while it is inspected. This is only done periodically and not the whole execution time.
	 */
	public void run() {
		while (true) {
			try {
				synchronized (npcStore) {
					reRun();
				}
				Thread.sleep(20000); // for testing, every 20 seconds

			} catch (Exception e) {
				// Try to keep running. Throwing here an exception will terminate this thread.
				// Write this error to the log.
				Activator.logException(e);
			}
		}

	}
	
	/**
	 * The NPC storage will be inspected if there is something to send.
	 * @throws IOException 
	 */
	private void reRun() throws IOException {
		final Date currentDate = new Date();
		
		List<NotificationProject> notificationProjectPerUserToBeDeleted = new ArrayList<NotificationProject>();
		for (NotificationProject notificationProjectPerUser: npcStore.getProjects()) {
			if( notificationProjectPerUser.getGroups().isEmpty() ) {
				notificationProjectPerUserToBeDeleted.add( notificationProjectPerUser );
				continue;
			}
			
			final ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();
			projectId.setId(notificationProjectPerUser.getId());
			final String toUserName = notificationProjectPerUser.getUserName();
			final ProjectSpace projectSpace = projectSpaceMap.get(projectId);
			
			if( projectSpace == null ) {
				// project is in proxy client still stored, but the project has been deleted.
				// set next sending for all included notification groups to now
				Date now = new Date( currentDate.getTime() - 100 );
				for (NotificationGroup notificationGroup : notificationProjectPerUser.getGroups()) {
					isNPCStoreDirty = true;
					notificationGroup.setNextSending( now );
				}
				
			} else {
				// get users current email (if available)
				try {
					User user = OrgUnitHelper.getUser(projectSpace, toUserName);
					if (user.getEmail() != null && !user.getEmail().trim().equals("") && !notificationProjectPerUser.getLastSeenEMail().equals(user.getEmail())) {
						isNPCStoreDirty = true;
						notificationProjectPerUser.setLastSeenEMail(user.getEmail());
					}
				} catch (CannotMatchUserInProjectException e) {
					// user is not longer a part of the project. No OrgUser was found.
				}
				
			}
			String userEMail = notificationProjectPerUser.getLastSeenEMail();
			
			List<NotificationGroup> notificationGroupsToBeDeleted = new ArrayList<NotificationGroup>();
			for (NotificationGroup notificationGroup : notificationProjectPerUser.getGroups()) {
				Date nextSending = notificationGroup.getNextSending();
				if (nextSending.before(currentDate)) {
					// send now, time overflow, but only if notifications are contained
					if( notificationGroup.getNotifications().isEmpty() ) {
						notificationGroupsToBeDeleted.add( notificationGroup );
						continue;
					}
					
					// there are notifications, build email
					EList<NotificationEntry> notifications = notificationGroup.getNotifications();
					StringBuilder messageBody = new StringBuilder();
					for (NotificationEntry notificationEntry : notifications) {
						String notificationText = notificationEntry.getText();
						String[] notificationTextLines = notificationText.split("\n");
						boolean first = true;
						for(String notificationTextLine: notificationTextLines) {
							messageBody.append( notificationTextLine );
							if( !first ) {
								messageBody.append("<br>");
							}
							first = false;
						}
						messageBody.append("<br><br>");
					}

					Mailer mailer = new Mailer(mailerInfo);
					String subject = "Notifications for "+notificationProjectPerUser.getName() +" project. (NotificationGroup "  +notificationGroup.getName() +")";
					boolean send = mailer.send(toUserName + " <" + userEMail + ">", subject, messageBody.toString());
					if (send) {
						// remove this group from storage
						isNPCStoreDirty = true;
						notificationGroupsToBeDeleted.add( notificationGroup );
					} else {
						// else, don't remove sending was unsuccessful
						Activator.log(Status.ERROR, "E-Mail sending error with notification group "+ notificationGroup.getName() +".");
					}
				}
			}
			
			for(NotificationGroup notificationGroup: notificationGroupsToBeDeleted) {
				isNPCStoreDirty = true;
				notificationProjectPerUser.getGroups().remove(notificationGroup);
			}
		}
		
		for(NotificationProject notificationProject: notificationProjectPerUserToBeDeleted) {
			isNPCStoreDirty = true;
			npcStore.getProjects().remove( notificationProject );
		}
		
		if( isNPCStoreDirty ) {
			npcStore.eResource().save(Collections.EMPTY_MAP);
			isNPCStoreDirty = false;
		}
	}

}

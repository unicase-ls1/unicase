package org.unicase.proxyclient.notifier.client;

import java.util.Date;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.proxyclient.notifier.email.Mailer;
import org.unicase.proxyclient.notifier.email.MailerInfo;
import org.unicase.proxyclient.notifier.store.model.NotificationEntry;
import org.unicase.proxyclient.notifier.store.model.NotificationGroup;
import org.unicase.proxyclient.notifier.store.model.NotificationProject;
import org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore;
import org.unicase.workspace.ProjectSpace;

/**
 * @author Adrian Staudt <staudta@in.tum.de>
 */
public class NotifierProxyClientRepositoryTimer implements Runnable {

	private final NotifierProxyClientStore createNPCStore;
private final Map<ProjectId, ProjectInfo> projectInfoMap;
	private final Map<ProjectId, ProjectSpace> projectSpaceMap;
	private final MailerInfo mailerInfo;
	
	public NotifierProxyClientRepositoryTimer(NotifierProxyClientStore createNPCStore, Map<ProjectId, ProjectInfo> projectInfoMap, Map<ProjectId, ProjectSpace> projectSpaceMap, MailerInfo mailerInfo) {
		this.createNPCStore = createNPCStore;
		this.projectInfoMap = projectInfoMap;
		this.projectSpaceMap = projectSpaceMap;
		this.mailerInfo = mailerInfo;
	}

	public void run() {
		while( true ) {
			try {
				reRun();
				Thread.sleep(5000); // for testing, every 5 seconds
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void reRun() {
		// assume everything is set to daily sending
		Date currentData = new Date();
		
		for(NotificationProject notificationProject: createNPCStore.getProjects() ) {
			final String toUserName = notificationProject.getUserName();
			// TODO, das ist zu pesimistisch, evt. hat user eine neuere email eingetragen.
			final String toUserEMail = notificationProject.getLastSeenEMail();
			
			for(NotificationGroup notificationGroup: notificationProject.getGroups() ) {
				Date nextSending = notificationGroup.getNextSending();
				if( nextSending.after(currentData) ) {
					// send now, time overflow
					EList<NotificationEntry> notifications = notificationGroup.getNotifications();
					if( notifications.size() > 0 ) {
						// ok, there is something to send
						StringBuilder messageBody = new StringBuilder();
						for(NotificationEntry notificationEntry: notifications) {
							messageBody.append( notificationEntry.getText() );
						}
						
						Mailer mailer = new Mailer(mailerInfo);
						boolean send = mailer.send(toUserName + "<"+ toUserEMail +">", "Notifications", messageBody.toString());
						if( send ) {
							// remove this group from storage
							notificationProject.getGroups().remove( notificationGroup );
						}
						// else, don't remove sending was unsuccessful
						// TODO Better error handling, should be discussed
					}
				}
				

			}
		}
	}

}

package org.unicase.proxyclient.notifier.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.model.organization.User;
import org.unicase.proxyclient.notifier.store.model.NPCFactory;
import org.unicase.proxyclient.notifier.store.model.NotificationEntry;
import org.unicase.proxyclient.notifier.store.model.NotificationGroup;
import org.unicase.proxyclient.notifier.store.model.NotificationProject;
import org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.notification.NotificationProvider;

/**
 * @author Adrian Staudt <staudta@in.tum.de>
 */
public class Notifications2Storage {
	
	private final NotifierProxyClientStore npcStore;
	private final Map<NotificationProvider, List<ESNotification>> newNotifications;
	private final ProjectSpace projectSpace;
	private final User user;
	
	public Notifications2Storage(NotifierProxyClientStore npcStore, Map<NotificationProvider, List<ESNotification>> newNotifications, ProjectSpace projectSpace, User user) {
		this.npcStore = npcStore;
		this.newNotifications = newNotifications;
		this.projectSpace = projectSpace;
		this.user = user;
		
		// add to storage
		appendToStorage();
		
		// which group notifications should be sended now
		List<NotificationGroup> notificationGroups4Sending = identifyGroupsForSending();
		
		// send group notifications
		for(NotificationGroup notificationGroup: notificationGroups4Sending) {
			send( notificationGroup );
		}
		
	}

	/**
	 * append new Notifications to NPC-Storage
	 */
	private void appendToStorage() {
		for(NotificationProvider notificationProvider: newNotifications.keySet()) {
			System.out.println( "notificationProvider: "+ notificationProvider.getName() );
			
			// get NotificationProject
			NotificationProject notificationProject = null;
			String projectID = projectSpace.getProjectId().getId();
			for(NotificationProject project: npcStore.getProjects() ) {
				if( project.getId().equals( projectID ) && project.getUserName() != null && project.getUserName().equals( user.getName() )  ) {
					notificationProject = project;
					break;
				}
			}
			
			// NotificationProject is not included in NPC-Store. Create new NotificationProject.
			if( notificationProject == null ) {
				notificationProject = NPCFactory.eINSTANCE.createNotificationProject();
				notificationProject.setId( projectID );
				notificationProject.setUserName( user.getName() );
				if( !user.getEmail().trim().equals("") ) {
					notificationProject.setLastSeenEMail( user.getEmail() );
				}
				
				npcStore.getProjects().add(notificationProject);
			}
			
			// get NotificationGroups inside of NotificationProject
			NotificationGroup notifactionGroup = null;
			for(NotificationGroup group: notificationProject.getGroups()) {
				if( group.getName().equals( notificationProvider.getName() ) ) {
					notifactionGroup = group;
					break;
				}
			}
			
			// NotificationGroup is not included in NPC-Store. Create new Group.
			if( notifactionGroup == null ) {
				notifactionGroup = NPCFactory.eINSTANCE.createNotificationGroup();
				notifactionGroup.setName( notificationProvider.getName() );
				
				// TODO, Property must be read out
				notifactionGroup.setNextSending( new Date() );
				
				notificationProject.getGroups().add(notifactionGroup);
			}
			
			// add notifications to NotificationGroup
			for(ESNotification notification: newNotifications.get(notificationProvider)) {
				if (!sanityCheck(notification, projectSpace)) {
					continue;
				}

				if (notification.getRelatedModelElements().size() > 0) {
					ModelElementId modelElementId = notification.getRelatedModelElements().get(0);
					ModelElement modelElement = projectSpace.getProject().getModelElement(modelElementId);
					
					NotificationEntry notificationEntry = NPCFactory.eINSTANCE.createNotificationEntry();
					notificationEntry.setText( notification.getMessage() + " \n " + modelElement  );
					notifactionGroup.getNotifications().add( notificationEntry );
				}
				
			}
		}
		
		try {
			npcStore.eResource().save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Identify which groups should be now sended
	 * @return
	 */
	private List<NotificationGroup> identifyGroupsForSending() {
		List<NotificationGroup> notificationGroups4Sending = new ArrayList<NotificationGroup>();
		
//		for(NotificationGroup group: npcStore.getGroups()) {
//			Date lastSending = group.getLastSending();
//			
//			// TODO, Keys needed
//			
//			notificationGroups4Sending.add( group );
//		}
		
		return notificationGroups4Sending;
	}
	
	// send Group
	private void send(NotificationGroup notificationGroup) {
		String body = "";
		
		EList<NotificationEntry> notifications = notificationGroup.getNotifications();
		for(NotificationEntry notificationEntry: notifications) {
			if( body.equals("") )
				body += notificationEntry.getText();
			else
				body += "\n"+ notificationEntry.getText();
		}
		
		// TODO email package is missing
		
	}
	
	// geklaut von der DashboardPage
	private boolean sanityCheck(ESNotification n, ProjectSpace projectSpace) {
		if (n == null) {
			return false;
		}
		if (n.getProject() == null || n.getProvider() == null
				|| n.getCreationDate() == null || n.getMessage() == null
				|| n.getName() == null) {
			return false;
		}
		if (n.getRelatedModelElements().size() > 0) {
			ModelElementId modelElementId = n.getRelatedModelElements().get(0);
			ModelElement firstModelElement = projectSpace.getProject()
					.getModelElement(modelElementId);
			if (firstModelElement == null) {
				return false;
			}
		}

		return true;
	}
}

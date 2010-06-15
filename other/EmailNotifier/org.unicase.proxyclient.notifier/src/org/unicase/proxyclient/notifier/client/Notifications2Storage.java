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

import org.eclipse.emf.common.util.EList;
import org.unicase.emailnotifierpreferences.properties.EMailNotifierKey;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.emailnotificationgroup.AggregatedSettings;
import org.unicase.model.emailnotificationgroup.EmailnotificationgroupFactory;
import org.unicase.model.emailnotificationgroup.SendSettings;
import org.unicase.model.emailnotificationgroup.Weekdays;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Comment;
import org.unicase.proxyclient.notifier.Activator;
import org.unicase.proxyclient.notifier.store.model.NPCFactory;
import org.unicase.proxyclient.notifier.store.model.NotificationEntry;
import org.unicase.proxyclient.notifier.store.model.NotificationGroup;
import org.unicase.proxyclient.notifier.store.model.NotificationProject;
import org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore;
import org.unicase.ui.common.util.CannotMatchUserInProjectException;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.notification.NotificationProvider;

/**
 * New generated notifications will be stored in the npc store. Notifications must be placed into the NotificationsGroups,
 * that the user has previously specified.
 * 
 * @author staudta
 */
public class Notifications2Storage {
	
	private boolean isNPCStoreDirty;
	private final NotifierProxyClientStore npcStore;
	
	/**
	 * Constructor.
	 * 
	 * @param npcStore the NPC storage
	 * @param newNotifications new generated notifications that must be sorted in the user configured notification groups.
	 * @param projectSpace project space of the related generated notifications
	 * @param acUser the user for that this notifications should be considered
	 * @throws NotificationProxyClientException exception
	 */
	public Notifications2Storage(final NotifierProxyClientStore npcStore, final Map<NotificationProvider, List<ESNotification>> newNotifications, final ProjectSpace projectSpace, final ACUser acUser) throws NotificationProxyClientException {
		this.npcStore = npcStore;
		
		try {
			User user = OrgUnitHelper.getUser(projectSpace, acUser.getName());
			// add to storage
			synchronized (npcStore) {
				// get NotificationProject
				NotificationProject notificationProject = getNotificationProject(projectSpace, user);
				List<org.unicase.model.emailnotificationgroup.NotificationGroup> bundlesFromProperty = getBundlesFromProperty(projectSpace.getProjectId(), acUser);
				for(org.unicase.model.emailnotificationgroup.NotificationGroup bundle: bundlesFromProperty) {
					NotificationGroup notificationGroup = getNotificationGroup(notificationProject, bundle);
					EList<Object> providers = bundle.getProviders();
					appendToStorage(notificationGroup, providers, newNotifications, projectSpace);
				}
				
				try {
					if( isNPCStoreDirty ) {
						npcStore.eResource().save(Collections.EMPTY_MAP);
						isNPCStoreDirty = false;
					}
				} catch (IOException e) {
					Activator.logException(e);
				}
			}
			
		} catch(CannotMatchUserInProjectException e) {
			// We don't need to generate Notifications for this user. This is not a OrgUser.
			return;
		}
	}
	
	private NotificationProject getNotificationProject(final ProjectSpace projectSpace, final User user) throws NotificationProxyClientException {
		final String projectName = projectSpace.getProjectName();
		
		NotificationProject notificationProject = null;
		String projectID = projectSpace.getProjectId().getId();
		for(NotificationProject project: npcStore.getProjects() ) {
			if( project.getId().equals( projectID ) && project.getUserName() != null && project.getUserName().equals( user.getName() )  ) {
				notificationProject = project;
				break;
			}
		}
		
		// notificationProject doesn't exist yet in the NPC-Store. Create a new one.
		if( notificationProject == null ) {
			isNPCStoreDirty = true;
			notificationProject = NPCFactory.eINSTANCE.createNotificationProject();
			notificationProject.setId( projectID );
			notificationProject.setName( projectName );
			notificationProject.setUserName( user.getName() );
			
			if( user.getEmail() == null || user.getEmail().trim().equals("") ) {
				// Hard Error, email should be set at this point
				throw new NotificationProxyClientException("User "+ user.getName() +" hasn't set an email adress.");
			}
			
			notificationProject.setLastSeenEMail( user.getEmail() );
			npcStore.getProjects().add(notificationProject);
		}
		
		return notificationProject;
	}
	
	private List<org.unicase.model.emailnotificationgroup.NotificationGroup> getBundlesFromProperty(ProjectId projectId, ACUser acUser) {
		List<org.unicase.model.emailnotificationgroup.NotificationGroup> bundles = new ArrayList<org.unicase.model.emailnotificationgroup.NotificationGroup>();
		
		for(OrgUnitProperty property: acUser.getProperties() ) {
			if( !property.getProject().getId().equals( projectId.getId() ) ) {
				// projectId doesn't match, step over
				continue;
			}
			
			if( property.getName().equals( EMailNotifierKey.NOTIFICATIONGROUPS.toString() ) ) {
				// entry found.
				property.getEObjectListProperty(bundles);
				return bundles;
			}
		}
		
		// Dummy can be afterwards deleted.
		
		// dummy bundle 1
		{
			org.unicase.model.emailnotificationgroup.NotificationGroup newBundle = EmailnotificationgroupFactory.eINSTANCE.createNotificationGroup();
			newBundle.setNotificationGroupName( "Comment Bundle" );
			newBundle.setSendOption( SendSettings.AGGREGATED );
			newBundle.setAggregatedOption( AggregatedSettings.DAYS );
			newBundle.setDaysCount( 1 );
			newBundle.getProviders().add(EMailNotifierKey.COMMENTS_PROVIDER);
			newBundle.getProviders().add(EMailNotifierKey.SUBSCRIPTION_PROVIDER);
			
			bundles.add( newBundle );
		}
		
		// dummy bundle 2
		{
			org.unicase.model.emailnotificationgroup.NotificationGroup newBundle = EmailnotificationgroupFactory.eINSTANCE.createNotificationGroup();
			newBundle.setNotificationGroupName( "Task Bundle" );
			newBundle.setSendOption( SendSettings.AGGREGATED );
			newBundle.setAggregatedOption( AggregatedSettings.DAYS );
			newBundle.setDaysCount( 1 );
			newBundle.getProviders().add(EMailNotifierKey.TASK_CHANGE_PROVIDER);
			newBundle.getProviders().add(EMailNotifierKey.TASK_PROVIDER);
			newBundle.getProviders().add(EMailNotifierKey.TASK_REVIEW_PROVIDER);
			newBundle.getProviders().add(EMailNotifierKey.TASK_TRACE_PROVIDER);
			
			bundles.add( newBundle );
		}
		
		// dummy bundle 3
		{
			org.unicase.model.emailnotificationgroup.NotificationGroup newBundle = EmailnotificationgroupFactory.eINSTANCE.createNotificationGroup();
			newBundle.setNotificationGroupName( "Task Bundle Imm" );
			newBundle.setSendOption( SendSettings.IMMEDIATELY );
			newBundle.getProviders().add(EMailNotifierKey.TASK_CHANGE_PROVIDER);
			newBundle.getProviders().add(EMailNotifierKey.TASK_PROVIDER);
			newBundle.getProviders().add(EMailNotifierKey.TASK_REVIEW_PROVIDER);
			newBundle.getProviders().add(EMailNotifierKey.TASK_TRACE_PROVIDER);
			
			bundles.add( newBundle );
		}
		
		return bundles;
	}
	
	private NotificationGroup getNotificationGroup(NotificationProject notificationProject, org.unicase.model.emailnotificationgroup.NotificationGroup bundle) {
		NotificationGroup notificationGroup = null;
		for(NotificationGroup group: notificationProject.getGroups() ) {
			if( group.getName().equals( bundle.getNotificationGroupName() ) ) {
				notificationGroup = group;
				break;
			}
		}
		
		// notificationGroup does not exist yet. Create a new one.
		if( notificationGroup == null ) {
			isNPCStoreDirty = true;
			notificationGroup = NPCFactory.eINSTANCE.createNotificationGroup();
			notificationGroup.setName( bundle.getNotificationGroupName() );
			
			// calc next Sending
			Date nextSending = null;
			if( bundle.getSendOption() == SendSettings.IMMEDIATELY ) {
				nextSending = new Date();
			} else if( bundle.getSendOption() == SendSettings.AGGREGATED ) {
				if( bundle.getAggregatedOption() == AggregatedSettings.DAYS ) {
					int days = bundle.getDaysCount();
					nextSending = org.unicase.proxyclient.notifier.client.util.Helper.addDays(new Date(), days);
					
				} else if( bundle.getAggregatedOption() == AggregatedSettings.WEEKDAY ) {
					Weekdays weekday = bundle.getWeekdayOption();
					nextSending = org.unicase.proxyclient.notifier.client.util.Helper.nextWeekday(new Date(), weekday);
				}
			}
			
			
			notificationGroup.setNextSending( nextSending );
			
			// add to project
			notificationProject.getGroups().add(notificationGroup);
		}
		
		return notificationGroup;
	}
	
	/**
	 * Append new Notifications to NPC storage. Will be called for each bundle.
	 * 
	 * @param notificationGroup
	 * @param providers
	 * @param newNotifications
	 * @param projectSpace
	 */
	private void appendToStorage(final NotificationGroup notificationGroup, final EList<Object> providers, final Map<NotificationProvider, List<ESNotification>> newNotifications, final ProjectSpace projectSpace) {
		List<EMailNotifierKey> providerList = new ArrayList<EMailNotifierKey>();
		for(Object provider: providers) {
			if( provider instanceof EMailNotifierKey ) {
				EMailNotifierKey eMailNotifierKey = (EMailNotifierKey) provider;
				providerList.add( eMailNotifierKey );
			}
		}
		
		for(NotificationProvider notificationProvider: newNotifications.keySet()) {
			boolean notificationIsContainedInBundle = isESNotificationContainedInBundle(notificationProvider, providerList);
			if( notificationIsContainedInBundle ) {
				addNotificationsFromNotificationProvider2Storage(notificationGroup, notificationProvider, newNotifications, projectSpace);
			}
		}
	}
	
	private boolean isESNotificationContainedInBundle(NotificationProvider notificationProvider, List<EMailNotifierKey> providerList) {
		for(EMailNotifierKey eMailNotifierKey: providerList) {
			if( notificationProvider.getKey().toString().equals( eMailNotifierKey.toString() ) ) {
				return true;
			}
		}
		
		return false;
	}
	
	private void addNotificationsFromNotificationProvider2Storage(final NotificationGroup notificationGroup, NotificationProvider notificationProvider, final Map<NotificationProvider, List<ESNotification>> newNotifications, final ProjectSpace projectSpace) {
		// add notification to storage
		for(ESNotification notification: newNotifications.get(notificationProvider)) {
			if (!sanityCheck(notification, projectSpace)) {
				continue;
			}

			if (notification.getRelatedModelElements().size() > 0) {
				isNPCStoreDirty = true;
				StringBuilder notificationEntryStringBuilder = new StringBuilder();
				notificationEntryStringBuilder.append(notification.getMessage() + "\n\n");
				
				for(ModelElementId modelElementId: notification.getRelatedModelElements()) {
					ModelElement modelElement = projectSpace.getProject().getModelElement(modelElementId);
					if( modelElement instanceof Comment ) {
						Comment comment = (Comment) modelElement;
						notificationEntryStringBuilder.append( "  Time: "+ comment.getCreationDate() +" \n" );
						notificationEntryStringBuilder.append( "  Creator: "+ comment.getCreator() + "\n" );
						notificationEntryStringBuilder.append( "  "+ comment.getDescription() + "\n" );
						
						
					} else if( modelElement instanceof UnicaseModelElement ) {
						UnicaseModelElement unicaseModelElement = (UnicaseModelElement) modelElement;
						notificationEntryStringBuilder.append( "Name: "+ unicaseModelElement.getName() + "\n" );
						notificationEntryStringBuilder.append( "Creator: "+ unicaseModelElement.getCreator() + "\n" );
						notificationEntryStringBuilder.append( "Time: "+ unicaseModelElement.getCreationDate() + "\n" );
						notificationEntryStringBuilder.append( "Description: "+ unicaseModelElement.getDescription() + "\n" );
						notificationEntryStringBuilder.append( "\n" );
					}
				}
				
				NotificationEntry notificationEntry = NPCFactory.eINSTANCE.createNotificationEntry();
				notificationEntry.setText( notificationEntryStringBuilder.toString()  );
				notificationGroup.getNotifications().add( notificationEntry );
			}
		}
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

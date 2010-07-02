/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.client;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.unicase.emailnotifierpreferences.properties.EMailNotifierKey;
import org.unicase.emfstore.emailnotifier.client.util.Helper;
import org.unicase.emfstore.emailnotifier.email.Mailer;
import org.unicase.emfstore.emailnotifier.email.MailerInfo;
import org.unicase.emfstore.emailnotifier.exception.ACUserNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.NotificationGroupNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.PropertyNotFoundException;
import org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup;
import org.unicase.emfstore.emailnotifier.store.ENSUser;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.emailnotificationgroup.NotificationGroup;
import org.unicase.model.rationale.Comment;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.notification.NotificationGenerator;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.preferences.DashboardKey;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * Prepares and sends an email with notifications to a certain user.
 * 
 * @author staudta
 *
 */
public class EMailNotifierMailHelper {
	
	private final String username;
	private final String useremail;
	private final MailerInfo mailerInfo;
	private final ProjectSpace projectSpace;
	
	/**
	 * Constructor.
	 * 
	 * @param projectSpace if needed for the generation of changes between two different versions
	 * @param ensUser to get the user name and the user email
	 * @param mailerInfo information for actually sending an email
	 */
	public EMailNotifierMailHelper(ProjectSpace projectSpace, ENSUser ensUser, MailerInfo mailerInfo) {
		this.projectSpace = projectSpace;
		this.username = ensUser.getUserName();
		this.useremail = ensUser.getUserEMail();
		this.mailerInfo = mailerInfo;
	}
	
	/**
	 * Will generate ESNotification depending from a base version and a target version.
	 * 
	 * @param baseVersion the base version
	 * @param targetVersion the target version
	 * @return a list of ESNotifications, ordered by their NotificationProvider
	 * @throws EmfStoreException can happen during getting changes from the emf store
	 */
	public Map<NotificationProvider, List<ESNotification>> generateNotifications(int baseVersion, int targetVersion) throws EmfStoreException {
		PrimaryVersionSpec baseSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		baseSpec.setIdentifier( baseVersion );
		
		PrimaryVersionSpec targetSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		targetSpec.setIdentifier( targetVersion );
		
		// TODO Review if projectSpace.getChanges(VersionSpec sourceVersion, VersionSpec targetVersion) has correct order
		//final List<ChangePackage> changes = projectSpace.getChanges(baseSpec, targetSpec); // <-- this should be right
		final List<ChangePackage> changes = projectSpace.getChanges(targetSpec, baseSpec); // <-- but this one is correct
		
		Map<NotificationProvider, List<ESNotification>> newNotifications = new UnicaseCommandWithResult<Map<NotificationProvider, List<ESNotification>>>() {

			@Override
			protected Map<NotificationProvider, List<ESNotification>> doRun() {
				Map<NotificationProvider, List<ESNotification>> newNotifications = NotificationGenerator.getInstance( projectSpace ).generateNotificationsByProvider(changes, username, true);
				return newNotifications;
			}
		}.run();
		
		return newNotifications;
	}
	
	/**
	 * Only these notifications are keep, if the user has configured a NotificationGroup, and these notification are part of a selected NotificationProvider.
	 * 
	 * @param usersession is needed to get the user defined NotificationGroups
	 * @param ensNotificationGroup the local available ENSNotificationGroup. This one must match a user defined NotificationGroup.
	 * @param newNotifications previous generated notifications
	 * @return a list of ESNotifications that must be only in consideration for the given ensNotificationGroup
	 * @throws NotificationGroupNotFoundException if the matching between NotificationGroup and ENSNotificationGroups failed
	 */
	public List<ESNotification> getRelevantNotifications(Usersession usersession, ENSNotificationGroup ensNotificationGroup, Map<NotificationProvider, List<ESNotification>> newNotifications) throws NotificationGroupNotFoundException {
		// notificationGroup is needed to resolve which NotificationsProviders were selected
		NotificationGroup notificationGroup = getNotificationGroup(usersession, username, projectSpace.getProjectId(), ensNotificationGroup);
		
		List<ESNotification> notificationsToSend = new LinkedList<ESNotification>();
		List<DashboardKey> selectedNotificationProviders = getSelectedNotificationProviders(notificationGroup);
		for(NotificationProvider notificationProvider: newNotifications.keySet()) {
			boolean notificationIsContainedInBundle = isESNotificationContainedInBundle(notificationProvider, selectedNotificationProviders);
			if( notificationIsContainedInBundle ) {
				List<ESNotification> notifications = newNotifications.get( notificationProvider );
				notificationsToSend.addAll( notifications );
			}
		}
		
		return notificationsToSend;
	}
	
	/**
	 * Will create an email for a ENSNotificationGroup and a list of notifications. These notifications should be only a set of relevant notifications for this ensNotificationGroup 
	 * 
	 * @param ensNotificationGroup the notification group that will be sent
	 * @param notifications these notifications will be the content
	 * @return true if the email can be sent
	 */
	public boolean sendEMail(ENSNotificationGroup ensNotificationGroup, List<ESNotification> notifications) {
		String eMailBody = getEMailBody(notifications);
		String subject = "Notifications for "+ projectSpace.getProjectName() +" project. (NotificationGroup "+ ensNotificationGroup.getName() +")";
		
		Mailer mailer = new Mailer(mailerInfo);
		
		return mailer.send(username + " <" + useremail + ">", subject, eMailBody);
	}
	
	/**
	 * Will create a HTML email body for a list of notifications.
	 * 
	 * @param notifications the notifications
	 * @return a HTML representation for the given notifications
	 */
	private String getEMailBody(List<ESNotification> notifications) {
		StringBuilder messageBody = new StringBuilder();
		for (ESNotification notification: notifications) {
			
			if (notification.getRelatedModelElements().size() > 0) {
				messageBody.append(notification.getMessage() + "<br><br>");
				
				for(ModelElementId modelElementId: notification.getRelatedModelElements()) {
					ModelElement modelElement = projectSpace.getProject().getModelElement(modelElementId);
					if( modelElement instanceof Comment ) {
						Comment comment = (Comment) modelElement;
						messageBody.append( "  Time: "+ comment.getCreationDate() +"<br>" );
						messageBody.append( "  Creator: "+ comment.getCreator() + "<br>" );
						messageBody.append( "  "+ comment.getDescription() + "<br>" );
						
						
					} else if( modelElement instanceof UnicaseModelElement ) {
						UnicaseModelElement unicaseModelElement = (UnicaseModelElement) modelElement;
						messageBody.append( "Name: "+ unicaseModelElement.getName() + "<br>" );
						messageBody.append( "Creator: "+ unicaseModelElement.getCreator() + "<br>" );
						messageBody.append( "Time: "+ unicaseModelElement.getCreationDate() + "<br>" );
						messageBody.append( "Description: "+ unicaseModelElement.getDescription() + "<br>" );
						messageBody.append( "<br>" );
					}
				}
				
			}
			
			messageBody.append("<br><br>");
		}
		
		return messageBody.toString();
	}
	
	/**
	 * Retrieves from the emf store all properties. Try to find the NotificationGroup that is described by the following parameters.
	 * 
	 * @param usersession the admin user session
	 * @param username the user name that will hopefully match to an ACUser
	 * @param projectId the project id that must be set for the OrgUnitProperties
	 * @param ensNotificationGroup the ensNotificationGroup that should match the user defined NOtificationGroup
	 * @return a NotificationGroup
	 * @throws NotificationGroupNotFoundException if such a NotificationGroup cannot be found 
	 */
	private static NotificationGroup getNotificationGroup(Usersession usersession, String username, ProjectId projectId, ENSNotificationGroup ensNotificationGroup) throws NotificationGroupNotFoundException {
		try {
			List<ACUser> acUsers = usersession.getAdminBroker().getUsers();
			ACUser acUser = Helper.getACUser(acUsers, username);
			List<OrgUnitProperty> projectUserProperties = Helper.getProjectProperties(acUser, projectId);
			
			OrgUnitProperty property = Helper.getProperty(EMailNotifierKey.NOTIFICATIONGROUPS, projectUserProperties);
			List<NotificationGroup> notificationGroups = new ArrayList<NotificationGroup>();
			property.getEObjectListProperty(notificationGroups);
			
			for(NotificationGroup notificationGroup: notificationGroups) {
				if( notificationGroup.getNotificationGroupName().equals( ensNotificationGroup.getName() ) ) {
					return notificationGroup;
				}
			}
			
			throw new NotificationGroupNotFoundException();
			
		} catch(ACUserNotFoundException e) {
			throw new NotificationGroupNotFoundException(e);
			
		} catch (AccessControlException e) {
			throw new NotificationGroupNotFoundException(e);
			
		} catch (EmfStoreException e) {
			throw new NotificationGroupNotFoundException(e);
			
		} catch (PropertyNotFoundException e) {
			throw new NotificationGroupNotFoundException(e);
			
		}
			
	}
	
	/**
	 * Returns a list of NotificationProviders (represented as DashboardKeys). These NotificationProviders are configured by the given notificationGroup.
	 * 
	 * @param notificationGroup the notification group for that the specified NotificationProviders should be found.
	 * @return list of NotificationProviders (represented as DashboardKeys)
	 */
	private static List<DashboardKey> getSelectedNotificationProviders(NotificationGroup notificationGroup) {
		List<DashboardKey> availableProvider = new LinkedList<DashboardKey>();
		availableProvider.add( DashboardKey.TASK_PROVIDER );
		availableProvider.add( DashboardKey.TASK_CHANGE_PROVIDER );
		availableProvider.add( DashboardKey.TASK_TRACE_PROVIDER );
		availableProvider.add( DashboardKey.TASK_REVIEW_PROVIDER );
		availableProvider.add( DashboardKey.SUBSCRIPTION_PROVIDER );
		availableProvider.add( DashboardKey.COMMENTS_PROVIDER );
		availableProvider.add( DashboardKey.PUSHED_PROVIDER );
		availableProvider.add( DashboardKey.UPDATE_PROVIDER );
		
		List<DashboardKey> keyProvider = new LinkedList<DashboardKey>();
		
		EList<Object> providers = notificationGroup.getProviders();
		for(Object provider: providers) {
			if(provider instanceof DashboardKey) {
				DashboardKey dashboardKey = (DashboardKey) provider;
				if( availableProvider.contains( dashboardKey ) ) {
					keyProvider.add( dashboardKey );
				}
			}
		}
		
		return keyProvider;
	}
	
	/**
	 * Identifies if the given notificationProvider is in the providerList. Matching is done by the DashboardKey.
	 * 
	 * @param notificationProvider a notification provider
	 * @param providerList a list of notification provider (originally specified by a NotificationGroup) represented as DashboardKeys
	 * @return true if it is contained, false otherwise
	 */
	private static boolean isESNotificationContainedInBundle(NotificationProvider notificationProvider, List<DashboardKey> providerList) {
		for(DashboardKey dashboardKey: providerList) {
			if( notificationProvider.getKey().equals( dashboardKey ) ) {
				return true;
			}
		}
		
		return false;
	}
}

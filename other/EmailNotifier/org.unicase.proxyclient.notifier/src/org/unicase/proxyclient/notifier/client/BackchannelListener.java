/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.proxyclient.notifier.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.unicase.emailnotifierpreferences.properties.EMailNotifierKey;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.events.server.ProjectUpdatedEvent;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.proxyclient.notifier.Activator;
import org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.notification.NotificationGenerator;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * Class will handle incoming server events.
 * 
 * @author staudta
 */
public class BackchannelListener implements EMFStoreEventListener {
	
	private Map<ProjectId, ProjectInfo> projectInfoMap = new HashMap<ProjectId, ProjectInfo>();
	private Map<ProjectId, ProjectSpace> projectSpaceMap = new HashMap<ProjectId, ProjectSpace>();
	private final NotifierProxyClientStore notifierProxyClientStore;
	
	/**
	 * Constructor. projectInfoMap and projectSpaceMap have the same size. For both maps the key attribute is the ProjectId.
	 * 
	 * @param notifierProxyClientStore NPC store
	 * @param projectInfoMap a map of project infos. In the project info map are representations of the remote projects. Is needed to get the new version.
	 * @param projectSpaceMap a map of project spaces
	 */
	public BackchannelListener(NotifierProxyClientStore notifierProxyClientStore, Map<ProjectId, ProjectInfo> projectInfoMap, Map<ProjectId, ProjectSpace> projectSpaceMap) {
		this.notifierProxyClientStore = notifierProxyClientStore;
		this.projectInfoMap = projectInfoMap;
		this.projectSpaceMap = projectSpaceMap;
	}
	
	/**
	 * This method will be called from the backchannel.
	 * 
	 * @param event the server event
	 * @return event has been handled
	 */
	public boolean handleEvent(ServerEvent event) {
		try {
			if( event instanceof ProjectUpdatedEvent ) {
				ProjectUpdatedEvent projectUpdatedEvent = (ProjectUpdatedEvent) event;
				ProjectId projectId = projectUpdatedEvent.getProjectId();
				
				final ProjectSpace projectSpace = projectSpaceMap.get( projectId );
				
				// do an update first
				PrimaryVersionSpec newVersion = new UnicaseCommandWithResult<PrimaryVersionSpec>() {
					@Override
					protected PrimaryVersionSpec doRun() {
						PrimaryVersionSpec baseVersion;
						try {
							baseVersion = projectSpace.update();
							return baseVersion;
						} catch (EmfStoreException e) {
							Activator.logException(e);
						}
						return null;
					}
				}.run();
				
				if( newVersion == null ) {
					throw new NotificationProxyClientException("Project cannot be updated. Exception occured.");
				}
				
				ProjectInfo projectInfo = projectInfoMap.get( projectId );
				final PrimaryVersionSpec localVersion = projectInfo.getVersion();
				final List<ChangePackage> changes = projectSpace.getChanges(localVersion, newVersion);
				new ProjectNotificationsToStorage(projectSpace, changes).run();
				
			}
			
		} catch (EmfStoreException e) {
			Activator.logException(e);
			return false;
			
		} catch(NotificationProxyClientException e) {
			Activator.logException(e);
			return false;
		}
		
		return true;
	}
	
	/**
	 * Generates Notifications from changes and adds them to the NPC storage.
	 */
	class ProjectNotificationsToStorage extends UnicaseCommand {
		
		private final ProjectSpace projectSpace;
		private final List<ChangePackage> changes;
		
		/**
		 * Constructor.
		 * 
		 * @param projectSpace the project space
		 * @param changes project changes since last update
		 */
		public ProjectNotificationsToStorage(final ProjectSpace projectSpace, final List<ChangePackage> changes) {
			this.projectSpace = projectSpace;
			this.changes = changes;
		}
		
		/**
		 * Method is called from the superior run method.
		 */
		@Override
		protected void doRun() {
			try {
				try {
					List<ACUser> acUsers = projectSpace.getUsersession().getAdminBroker().getUsers();
					
					for(ACUser acUser: acUsers) {
						// check if this acUser is allowed to access the affected project
						EList<Role> roles = acUser.getRoles();
						boolean canRead = false;
						for(Role role: roles) {
							canRead = role.canRead(projectSpace.getProjectId(), null);
							if( canRead ) {
								break;
							}
						}
						if( !canRead ) {
							// user is not allowed to access this project
							continue;
						}
						
						EList<OrgUnitProperty> properties = acUser.getProperties();
	//					try {
	//						OrgUnitProperty notificationServiceOn = getProperty(properties, EMailNotifierKey.ACTIVATED);
	//						if( !( notificationServiceOn != null && notificationServiceOn.getBooleanProperty() ) ) {
	//							// NotificationService is either not configured or deactivated (for this user)
	//							continue;
	//						}
	//						
	//					} catch (PropertyNotFoundException e) {
	//						// NotificationService is either not configured or deactivated (for this user)
	//						continue;
	//					}
						
						// create notifications for this user
						Map<NotificationProvider, List<ESNotification>> newNotifications = NotificationGenerator.getInstance( projectSpace ).generateNotificationsByProvider(changes, acUser.getName(), true);
						
						// add those notifications to storage
						new Notifications2Storage(notifierProxyClientStore, newNotifications, projectSpace, acUser);
					}
					
				} catch (AccessControlException e) {
					throw new NotificationProxyClientException("User isn't admin.", e);
				} catch (EmfStoreException e) {
					throw new NotificationProxyClientException("EmfStoreException during getting all ac users.", e);
				}
				
			} catch(NotificationProxyClientException e) {
				Activator.logException(e);
			}
		}
		
		private OrgUnitProperty getProperty(EList<OrgUnitProperty> properties, EMailNotifierKey propertyKey) throws PropertyNotFoundException {
			for(OrgUnitProperty property: properties) {
				if( property.getName().equals( propertyKey.toString() ) ) {
					return property;
				}
			}
			throw new PropertyNotFoundException();
		}
		
		/**
		 * An inner class exception. Will be used to indicate that a property wasn't found.
		 */
		class PropertyNotFoundException extends Exception {
			private static final long serialVersionUID = -6367387559189130986L;}
	}
	
}

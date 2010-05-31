package org.unicase.proxyclient.notifier.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.events.server.ProjectUpdatedEvent;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.RMISerializationException;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.notification.NotificationGenerator;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.preferences.DashboardKey;
import org.unicase.workspace.preferences.PreferenceManager;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * @author Adrian Staudt <staudta@in.tum.de>
 */
public class EMFStoreEventNotifierListener implements EMFStoreEventListener {
	
	private Map<ProjectId, ProjectInfo> projectInfoMap = new HashMap<ProjectId, ProjectInfo>();
	private Map<ProjectId, ProjectSpace> projectSpaceMap = new HashMap<ProjectId, ProjectSpace>();
	private final NotifierProxyClientStore notifierProxyClientStore;
	
	public EMFStoreEventNotifierListener(NotifierProxyClientStore notifierProxyClientStore, Map<ProjectId, ProjectInfo> projectInfoMap, Map<ProjectId, ProjectSpace> projectSpaceMap) {
		this.notifierProxyClientStore = notifierProxyClientStore;
		this.projectInfoMap = projectInfoMap;
		this.projectSpaceMap = projectSpaceMap;
	}
	
	public boolean handleEvent(ServerEvent event) {
		System.out.println( event );
		
		try {
			if( event instanceof ProjectUpdatedEvent ) {
				ProjectUpdatedEvent projectUpdatedEvent = (ProjectUpdatedEvent) event;
				ProjectId projectId = projectUpdatedEvent.getProjectId();
				
				final ProjectSpace projectSpace = projectSpaceMap.get( projectId );
				
				// do an update first
				PrimaryVersionSpec baseVersion = new UnicaseCommandWithResult<PrimaryVersionSpec>() {

					@Override
					protected PrimaryVersionSpec doRun() {
						PrimaryVersionSpec baseVersion;
						try {
							baseVersion = projectSpace.update();
							return baseVersion;
						} catch (EmfStoreException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return null;
					}
				}.run();
				
				ProjectInfo projectInfo = projectInfoMap.get( projectId );
				final PrimaryVersionSpec resolvedVersion = projectInfo.getVersion();
				
				final List<ChangePackage> changes = projectSpace.getChanges(baseVersion, resolvedVersion);
				
				
				new UnicaseCommand() {
					
					@Override
					protected void doRun() {
						try {
							List<ACUser> acUsers = projectSpace.getUsersession().getAdminBroker().getUsers();
							List<User> users = projectSpace.getProject().getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>());
							
							for(ACUser acUser: acUsers) {
								User user = null;
								for(User iteratorUser: users) {
									String acOrdId = iteratorUser.getAcOrgId();
									if( acUser.getId().getId().equals( acOrdId ) ) {
										user = iteratorUser;
										break;
									}
								}
								
								// no OrgUnit-User found, ignore this ac user
								if( user == null )
									continue;
								
								// is notification activated for this user?
								OrgUnitProperty dashboardSize = PreferenceManager.INSTANCE.getProperty(projectSpace, DashboardKey.DASHBOARD_SIZE);
								System.out.println( dashboardSize.getName() + " :: " +dashboardSize.getValue());
								
								// neue notifications
								Map<NotificationProvider, List<ESNotification>> newNotifications = NotificationGenerator.getInstance( projectSpace ).generateNotificationsByProvider(changes, acUser.getName(), true);
								new Notifications2Storage(notifierProxyClientStore, newNotifications, projectSpace, user);
								
								
							}
						} catch (AccessControlException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (EmfStoreException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}.run();
				
				System.out.println(SerializationUtil.eObjectToString(event));
			}
		} catch (RMISerializationException e) {
			e.printStackTrace();
		} catch (EmfStoreException e) {
			e.printStackTrace();
		}
		return true;
	}
	

}

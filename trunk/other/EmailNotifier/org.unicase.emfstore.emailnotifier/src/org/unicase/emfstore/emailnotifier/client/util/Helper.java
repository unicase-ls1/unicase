/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.emfstore.emailnotifier.client.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.unicase.emailnotifierpreferences.properties.EMailNotifierKey;
import org.unicase.emfstore.emailnotifier.Activator;
import org.unicase.emfstore.emailnotifier.exception.ACUserNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.EMailNotifierException;
import org.unicase.emfstore.emailnotifier.exception.ENSNotificationGroupNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.ENSNotificationProjectNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.ENSUserNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.NotificationGroupNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.ProjectNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.PropertyNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.UserEMailNotSetException;
import org.unicase.emfstore.emailnotifier.store.EMailNotifierStore;
import org.unicase.emfstore.emailnotifier.store.ENSFactory;
import org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup;
import org.unicase.emfstore.emailnotifier.store.ENSNotificationProject;
import org.unicase.emfstore.emailnotifier.store.ENSUser;
import org.unicase.emfstore.emailnotifier.store.SendOption;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.emailnotificationgroup.NotificationGroup;
import org.unicase.model.emailnotificationgroup.Weekdays;
import org.unicase.model.organization.User;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * Helper class for the EMail Notifier Service.
 * 
 * @author staudta
 */
public final class Helper {
	
	private Helper() { }
	
	/**
	 * If a project exists on the server but not local, this project will be checked out.
	 * This can be done with this method.
	 * 
	 * @param workspace the current workspace
	 * @param usersession the admin user session
	 * @param project a remote project info
	 * @return the project space where the project has been checked out
	 * @throws EMailNotifierException if the project can't be checked out
	 */
	public static ProjectSpace checkout(final Workspace workspace, final Usersession usersession, final ProjectInfo project) throws EMailNotifierException {
		UnicaseCommandWithResult<ProjectSpace> comand = new UnicaseCommandWithResult<ProjectSpace>() {

			@Override
			protected ProjectSpace doRun() {
				try {
					ProjectSpace space = workspace.checkout(usersession, project);
					return space;

				} catch (EmfStoreException e) {
					Activator.logException(e);
				}
				return null;
			}
		};

		ProjectSpace space = comand.run();
		if( space == null ) {
			throw new EMailNotifierException( "EMF Store Exception during checkout." );
		}
		return space;
	}
	
	/**
	 * Adds days to an already instantiated date.
	 * 
	 * @param date start date
	 * @param days amount of days that should be added
	 * @return Date 
	 */
	public static Date addDays(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime( date );
		calendar.add(Calendar.DATE, days);  // number of days to add
		
		return calendar.getTime();
	}
	
	/**
	 * Calculates the next date for the specified weekday from the input date.
	 * 
	 * @param date start date for calculation
	 * @param weekday the expected weekday
	 * @return Date
	 */
	public static Date nextWeekday(Date date, Weekdays weekday) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime( date );
		
		int calendarDayOfWeekIndex = weekday.getValue() +1;
		if( weekday == Weekdays.SUNDAY ) {
			calendarDayOfWeekIndex = 1;
		}
		
		int dayOfWeek = calendar.get( Calendar.DAY_OF_WEEK );
		if( dayOfWeek == calendarDayOfWeekIndex ) {
			return date;
		}
		return nextWeekday( addDays(date, 1) , weekday);
	}
	
	/**
	 * Returns a project space from the local checked out projects that has the same project id as the one from the parameter.
	 * 
	 * @param projectId the project id that you are interested in
	 * @return the project space
	 * @throws ProjectNotFoundException will be thrown if the project wasn't found in the local checked out projects
	 */
	public static ProjectSpace getLocalProject( ProjectId projectId ) throws ProjectNotFoundException {
		EList<ProjectSpace> projectSpaces = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces();
		for(ProjectSpace projectSpace: projectSpaces) {
			if( projectId.getId().equals( projectSpace.getProjectId().getId() ) ) {
				return projectSpace;
			}
		}
		
		throw new ProjectNotFoundException(projectId);
	}
	
	/**
	 * Returns a project info from the available remote projects that has the same project id as the one from the parameter.
	 * 
	 * @param usersession the admin user session
	 * @param projectId the project id that you are interested in
	 * @return the project info
	 * @throws EmfStoreException will be thrown if something goes wrong while gathering the remote project info.
	 * @throws ProjectNotFoundException will be thrown if the project wasn't found in the remote emf store
	 */
	public static ProjectInfo getRemoteProject(Usersession usersession, ProjectId projectId ) throws EmfStoreException, ProjectNotFoundException {
		List<ProjectInfo> remoteProjectList = usersession.getRemoteProjectList();
		for(ProjectInfo projectInfo: remoteProjectList) {
			if( projectId.getId().equals( projectInfo.getProjectId().getId() ) ) {
				return projectInfo;
			}
		}
		
		throw new ProjectNotFoundException(projectId);
	}
	
	/**
	 * Returns a list of OrgUnitProperty that are for the user available and stored in the context of the given project.
	 * 
	 * @param acUser a ac user
	 * @param projectId a project id
	 * @return a list of OrgUnitProperty
	 */
	public static List<OrgUnitProperty> getProjectProperties(ACUser acUser, ProjectId projectId) {
		List<OrgUnitProperty> projectProperties = new LinkedList<OrgUnitProperty>();
		
		EList<OrgUnitProperty> properties = acUser.getProperties();
		for(OrgUnitProperty property: properties) {
			if( property.getProject() != null && projectId.getId().equals( property.getProject().getId() ) ) {
				projectProperties.add( property );
			}
		}
		
		return projectProperties;
	}
	
	/**
	 * Returns the ac user from the acUsers list with the given username, if such a user exists in the list.
	 * 
	 * @param acUsers a list of ac users
	 * @param username the username that should be resolved from the ac users list
	 * @return a ac user
	 * @throws ACUserNotFoundException will be thrown if the username isn't contained in the ac users list
	 */
	public static ACUser getACUser(List<ACUser> acUsers, String username) throws ACUserNotFoundException {
		for(ACUser acUser: acUsers) {
			if( acUser.getName().equals( username ) ) {
				return acUser;
			}
		}
		
		throw new ACUserNotFoundException(username);
	}
	
	/**
	 * Selects from a list of OrgUnitProperties the one that matches the key.
	 * 
	 * @param key this key property is searched for in the properties list
	 * @param properties a list of properties
	 * @return the matched OrgUnitProperty
	 * @throws PropertyNotFoundException if the property is not found in the OrgUnitProperties list
	 */
	public static OrgUnitProperty getProperty(EMailNotifierKey key, List<OrgUnitProperty> properties) throws PropertyNotFoundException {
		for(OrgUnitProperty property: properties) {
			if( property.getName().equals( key.toString() ) ) {
				return property;
			}
		}
		
		throw new PropertyNotFoundException(key);
	}
	
	/**
	 * This utility method is useful if a project will be deleted, or the users deactivates the email notifier service.
	 *
	 * For a certain ENSUser will be the next sending time set to now, for all ENSNotificationGroups. But only if 
	 * these notification groups are marked for aggregation. If a notification group is marked for immediately sending,
	 * this notification group will be deleted.
	 * 
	 * @param ensUser a ensUser for that all notification groups should be set for instantly sending
	 * @return true is anything was changed, this means that the ENS should be marked as dirty.
	 */
	public static boolean markUserNotificationGroupsForInstantlySending(ENSUser ensUser) {
		boolean isENSDirty = false;
		
		final Date now = new Date();
		List<ENSNotificationGroup> ensNotificationGroupsToRemove = new ArrayList<ENSNotificationGroup>();
		
		for(ENSNotificationGroup ensNotificationGroup: ensUser.getGroups() ) {
			if( ensNotificationGroup.getSendOption().equals( SendOption.AGGREGATED ) ) {
				// if sending setting == aggregated
				ensNotificationGroup.setNextSendingDate(now);
				isENSDirty = true;
				
			} else if( ensNotificationGroup.getSendOption().equals( SendOption.IMMEDIATELY ) ) {
				// if sending setting == immediately
				// remove notification group directly from the store
				ensNotificationGroupsToRemove.add(ensNotificationGroup);
			}
		}
		
		// remove immediately ENSNotificationGroups
		if( !ensNotificationGroupsToRemove.isEmpty() ) {
			ensUser.getGroups().removeAll(ensNotificationGroupsToRemove);
			isENSDirty = true;
		}
		
		return isENSDirty;
	}
	
	/**
	 * If such a project exists in the ENS, the project will be given back.
	 *
	 * @param emailNotifierStore an EMailNotifierStore where a certain project should be found
	 * @param projectId the project id that is expected in the emailNotifierStore
	 * @return an ENSNotificationProject
	 * @throws ENSNotificationProjectNotFoundException if the projectId is not part of the EMailNotifierStore
	 */
	public static ENSNotificationProject getENSNotificationProject(EMailNotifierStore emailNotifierStore, ProjectId projectId) throws ENSNotificationProjectNotFoundException {
		for(ENSNotificationProject ensNotificationProject: emailNotifierStore.getProjects()) {
			if( ensNotificationProject.getId().equals( projectId.getId() ) ) {
				return ensNotificationProject;
			}
		}
		
		throw new ENSNotificationProjectNotFoundException();
	}
	
	/**
	 * If such a project exists in the ENS, the project will be given back, otherwise it will be created first.
	 * 
	 * @param emailNotifierStore an EMailNotifierStore where a certain project should be found
	 * @param projectId the project id that is expected in the emailNotifierStore
	 * @param madeDirty will be handled as an additional return value. If it will be set to true, if the obtain method has created an ENSNotificationProject. This means that the ENS is dirty.
	 * @return an ENSNotificationProject
	 */
	public static ENSNotificationProject obtainENSNotificationProject(EMailNotifierStore emailNotifierStore, ProjectId projectId, Flag madeDirty) {
		if( madeDirty != null ) {
			madeDirty.setFlag(false);
		}
		
		ENSNotificationProject ensNotificationProject = null;
		try {
			ensNotificationProject = getENSNotificationProject(emailNotifierStore, projectId);
			
		} catch (ENSNotificationProjectNotFoundException e) {
			// create new NotificationProject
			ensNotificationProject = ENSFactory.eINSTANCE.createENSNotificationProject();
			ensNotificationProject.setId(projectId.getId());
			
			emailNotifierStore.getProjects().add( ensNotificationProject );
			if( madeDirty != null ) {
				madeDirty.setFlag(true);
			}
		}
		
		return ensNotificationProject;
	}
		
	/**
	 * If such a project exists in the ENS, the project will be given back.
	 *
	 * @param ensNotificationProject an ENSNotificationProject where a user should be found
	 * @param username the user name that is expected in the ensNotificationProject
	 * @return an ENSUser
	 * @throws ENSUserNotFoundException if the user is not part of the ensNotificationProject
	 */
	public static ENSUser getENSUser(ENSNotificationProject ensNotificationProject, String username) throws ENSUserNotFoundException {
		for(ENSUser ensUser: ensNotificationProject.getUsers()) {
			if( ensUser.getUserName().equals( username ) ) {
				return ensUser;
			}
		}
		
		throw new ENSUserNotFoundException();
	}
	
	/**
	 * If such a project exists in the ENS, the project will be given back, otherwise it will be created first.
	 * 
	 * @param ensNotificationProject an ENSNotificationProject where a user should be found
	 * @param acUser contains for sure a user name, this user name is checked, if it is contained in the ensNotificationProject
	 * @param user the user email will be set from this object
	 * @param madeDirty will be handled as an additional return value. If it will be set to true, if the obtain method has created an ENSUser. This means that the ENS is dirty.
	 * @return an ENSNotificationProject
	 * @throws UserEMailNotSetException if the user object hasn't set an email address
	 */
	public static ENSUser obtainENSUser(ENSNotificationProject ensNotificationProject, ACUser acUser, User user, Flag madeDirty) throws UserEMailNotSetException {
		if( madeDirty != null ) {
			madeDirty.setFlag(false);
		}
		
		ENSUser ensUser = null;
		try {
			ensUser = getENSUser(ensNotificationProject, acUser.getName());
			// reset new email if set on user object
			if( user != null && user.getEmail() != null && !user.getEmail().trim().equals("") ) {
				ensUser.setUserEMail( user.getEmail() );
				if( madeDirty != null ) {
					madeDirty.setFlag(true);
				}
			}
			
		} catch(ENSUserNotFoundException e) {
			// check first for an email address
			if( user == null || user.getEmail() == null || user.getEmail().trim().equals("") ) {
				throw new UserEMailNotSetException( acUser.getName() );
			}
			
			ensUser = ENSFactory.eINSTANCE.createENSUser();
			ensUser.setUserName( acUser.getName() );
			ensUser.setUserEMail( user.getEmail() );
			
			ensNotificationProject.getUsers().add( ensUser );
			if( madeDirty != null ) {
				madeDirty.setFlag(true);
			}
		}
		
		return ensUser;
	}
	
	/**
	 * From a given list of ENSNotificationGroups, the one will be returned which matches the expected group name.
	 * 
	 * @param ensNotificationGroups a list of ENSNotificationGroups
	 * @param groupName a group name that should be found in the list
	 * @return a ENSNotificationGroup
	 * @throws ENSNotificationGroupNotFoundException if the ENSNotificationGroup hasn't been found in the given list
	 */
	public static ENSNotificationGroup getENSNotficationGroup(List<ENSNotificationGroup> ensNotificationGroups, String groupName) throws ENSNotificationGroupNotFoundException {
		for(ENSNotificationGroup ensNotificationGroup: ensNotificationGroups) {
			if( ensNotificationGroup.getName().equals( groupName ) ) {
				return ensNotificationGroup;
			}
		}
		
		throw new ENSNotificationGroupNotFoundException();
	}
	
	/**
	 * Tries to find out the corresponding NotificationGroup for an ENSNotificationGroup.
	 * 
	 * @param usersession the admin user session
	 * @param username the user for that the properties will be loaded
	 * @param projectId the project id where the NotificationGroup should be found
	 * @param ensNotificationGroup the mapping opposite
	 * @return The mapped NotificationGroup
	 * @throws NotificationGroupNotFoundException Will be thrown if no mapping has been found.
	 */
	public static NotificationGroup getNotificationGroup(Usersession usersession, String username, ProjectId projectId, ENSNotificationGroup ensNotificationGroup) throws NotificationGroupNotFoundException {
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
	
}

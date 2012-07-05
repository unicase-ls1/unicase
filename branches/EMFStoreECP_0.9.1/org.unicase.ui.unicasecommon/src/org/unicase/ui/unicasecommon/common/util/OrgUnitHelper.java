/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.common.model.NoWorkspaceException;
import org.eclipse.emf.ecp.common.utilities.CannotMatchUserInProjectException;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.Workspace;
import org.eclipse.emf.emfstore.client.model.accesscontrol.AccessControlHelper;
import org.eclipse.emf.emfstore.client.model.exceptions.NoCurrentUserException;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.ConnectionException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;

/**
 * Helper for OrgUnit operations.
 * 
 * @author helming
 */
public final class OrgUnitHelper {

	private OrgUnitHelper() {

	}

	/**
	 * Returns the current User in the project, whos logged in.
	 * 
	 * @param currentWorkspace the current workspace
	 * @return The current user
	 * @throws NoCurrentUserException if there is no current user.
	 * @throws CannotMatchUserInProjectException if the current user cannot be found in the current project
	 */
	public static User getCurrentUser(Workspace currentWorkspace) throws NoCurrentUserException,
		CannotMatchUserInProjectException {
		try {
			ProjectSpace activeProjectSpace = (ProjectSpace) ECPWorkspaceManager.getInstance().getWorkSpace()
				.getActiveProject().getRootObject();
			if (activeProjectSpace == null) {
				throw new NoCurrentUserException();
			}
			return getUser(activeProjectSpace);
		} catch (NoWorkspaceException e) {
			ModelUtil.logException("Retrieving current user failed!", e);
			return null;
		}

	}

	/**
	 * Returns the User in the project of the given projectSpace.
	 * 
	 * @param projectSpace the project space
	 * @return the user model element
	 * @throws NoCurrentUserException if there is no user logged into the project space
	 * @throws CannotMatchUserInProjectException if the user cannot be found in the project
	 */
	public static User getUser(ProjectSpace projectSpace) throws NoCurrentUserException,
		CannotMatchUserInProjectException {
		// JH: handle non-existing usersession
		Usersession currentUserSession = projectSpace.getUsersession();
		if (currentUserSession == null) {
			throw new NoCurrentUserException();
		}
		EList<User> projectUsers = projectSpace.getProject().getAllModelElementsbyClass(
			OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>());
		String id = currentUserSession.getACUser().getId().getId();
		for (User currentUser : projectUsers) {
			// FS how can I get the appropriate user from the current user
			// session?
			String acOrgId = currentUser.getAcOrgId();
			if (acOrgId != null) {
				if (acOrgId.equals(id)) {
					return currentUser;
				}
			}
		}
		throw new CannotMatchUserInProjectException();
	}

	/**
	 * Returns the User in the project of the given projectSpace and username.
	 * 
	 * @param projectSpace the project space
	 * @param username the user name for that the user model element should match
	 * @return the user model element
	 * @throws CannotMatchUserInProjectException if the user cannot be found in the project
	 */
	public static User getUser(ProjectSpace projectSpace, String username) throws CannotMatchUserInProjectException {
		EList<User> projectUsers = projectSpace.getProject().getAllModelElementsbyClass(
			OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>());
		for (User user : projectUsers) {
			if (user.getName().equals(username)) {
				return user;
			}
		}
		throw new CannotMatchUserInProjectException();
	}

	/**
	 * Gets the team of the user. Includes all groups he is member of, all members of this groups and himself.
	 * 
	 * @param user the user
	 * @return his team
	 */
	public static Set<OrgUnit> getTeam(User user) {
		Set<OrgUnit> team = new HashSet<OrgUnit>();
		if (user == null) {
			return team;
		}
		team.add(user);
		List<Group> groupMemberships = user.getGroupMemberships();
		for (Group group : groupMemberships) {
			team.add(group);
			team.addAll(group.getOrgUnits());
		}
		return team;

	}

	/**
	 * Get all Groups an organizational unit is member of.
	 * 
	 * @param orgUnit the organizational unit
	 * @return the set of groups
	 */
	public static Set<Group> getAllGroupsOfOrgUnit(OrgUnit orgUnit) {
		return getAllGroupsOfOrgUnit(orgUnit, new HashSet<Group>());
	}

	private static Set<Group> getAllGroupsOfOrgUnit(OrgUnit orgUnit, Set<Group> alreadySeenGroups) {
		for (Group group : orgUnit.getGroupMemberships()) {
			if (!alreadySeenGroups.contains(group)) {
				alreadySeenGroups.add(group);
				getAllGroupsOfOrgUnit(orgUnit, alreadySeenGroups);
			}
		}
		return alreadySeenGroups;
	}

	/**
	 * Imports users from the access control to the project in the given project space. Will only work if the
	 * usersession of the project space is an admin user.
	 * 
	 * @param projectSpace the project space
	 * @throws AccessControlException if the user has no admin rights
	 */
	public static void importACUsers(ProjectSpace projectSpace) throws AccessControlException {
		AccessControlHelper accessControlHelper = new AccessControlHelper(projectSpace.getUsersession());
		accessControlHelper.checkProjectAdminAccess(projectSpace.getProjectId());
		try {
			List<ACOrgUnit> participants = projectSpace.getWorkspace().getAdminBroker(projectSpace.getUsersession())
				.getParticipants(projectSpace.getProjectId());
			if (participants != null) {
				addToProject(participants, projectSpace);
			}
		} catch (ConnectionException e) {
			WorkspaceUtil.logException("Importing users failed!", e);
		} catch (EmfStoreException e) {
			WorkspaceUtil.logException("Importing users failed!", e);
		}
	}

	/**
	 * Adds a list of acUsers to a project.
	 * 
	 * @param participants The list of ACUser
	 * @param projectSpace The projectSpace which contains the project
	 */
	private static void addToProject(List<ACOrgUnit> participants, ProjectSpace projectSpace) {
		HashMap<String, User> userIdMap = new HashMap<String, User>();
		HashMap<String, User> userNameMap = new HashMap<String, User>();
		List<ACUser> importUserList = new ArrayList<ACUser>();
		Project project = projectSpace.getProject();
		EList<User> existingUsers = new BasicEList<User>();
		project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(), existingUsers);
		// Put existing users in a map
		for (User user : existingUsers) {
			userIdMap.put(user.getAcOrgId(), user);
			userNameMap.put(user.getName(), user);
		}
		// Convert list to flat user list
		convertList(participants, importUserList, projectSpace);
		// List to save ids to check dengling users in the project later and
		// remove their acId
		List<String> acUserIds = new ArrayList<String>();
		for (ACUser acuser : importUserList) {
			ACOrgUnitId id = acuser.getId();
			acUserIds.add(id.getId());
			User user = userIdMap.get(id.getId());
			if (user == null) {
				user = userNameMap.get(acuser.getName());
				// If user not found create it
				if (user == null) {
					user = OrganizationFactory.eINSTANCE.createUser();
					user.setName(acuser.getName());
					user.setDescription(acuser.getDescription());
					project.addModelElement(user);
				}
				user.setAcOrgId(id.getId());
			}

		}
		// Remove all acIds which are no longer in th group
		for (User user : existingUsers) {
			if (!acUserIds.contains(user.getAcOrgId())) {
				user.setAcOrgId(null);
			}
		}

	}

	private static void convertList(List<ACOrgUnit> participants, List<ACUser> importUserList, ProjectSpace projectSpace) {
		for (ACOrgUnit orgUnit : participants) {
			if (orgUnit instanceof ACUser) {
				importUserList.add((ACUser) orgUnit);
			}
			if (orgUnit instanceof ACGroup) {
				List<ACOrgUnit> recursiveList = null;
				try {
					recursiveList = projectSpace.getWorkspace().getAdminBroker(projectSpace.getUsersession())
						.getMembers(orgUnit.getId());
				} catch (ConnectionException e) {
					WorkspaceUtil.logException("Importing users failed!", e);
				} catch (EmfStoreException e) {
					WorkspaceUtil.logException("Importing users failed!", e);
				}
				if (recursiveList != null) {
					convertList(recursiveList, importUserList, projectSpace);
				}

			}
		}

	}

}

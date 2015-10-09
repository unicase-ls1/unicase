/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.core.util.ECPUtil;
import org.eclipse.emf.ecp.emfstore.core.internal.EMFStoreProvider;
import org.eclipse.emf.ecp.internal.core.ECPProjectImpl;
import org.eclipse.emf.ecp.spi.core.InternalProject;
import org.eclipse.emf.emfstore.client.ESLocalProject;
import org.eclipse.emf.emfstore.client.ESUsersession;
import org.eclipse.emf.emfstore.internal.client.accesscontrol.AccessControlHelper;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.client.model.exceptions.UnkownProjectException;
import org.eclipse.emf.emfstore.internal.client.model.impl.api.ESLocalProjectImpl;
import org.eclipse.emf.emfstore.internal.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.internal.common.model.Project;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.internal.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.internal.server.exceptions.ConnectionException;
import org.eclipse.emf.emfstore.internal.server.model.accesscontrol.ACGroup;
import org.eclipse.emf.emfstore.internal.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.internal.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.internal.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.exceptions.ESException;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationFactory;
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
	 * @param ecpProject2
	 *            the current workspace
	 * @return The current user
	 * @throws NoCurrentUserException
	 *             if there is no current user.
	 * @throws CannotMatchUserInProjectException
	 *             if the current user cannot be found in the current project
	 */
	public static ESUsersession getUserSession(ECPProject ecpProject)
			throws UnkownProjectException {
		ESLocalProject projectSpace = null;
		if (ecpProject != null
				&& ecpProject.getRepository() != null
				&& ecpProject.getRepository().getProvider() != null
				&& ecpProject.getRepository().getProvider()
						.hasCreateRepositorySupport()) {
			projectSpace = EMFStoreProvider.INSTANCE
					.getProjectSpace((InternalProject) ecpProject);
		}
		if (projectSpace == null) {
			return null;
		}
		ESUsersession session = projectSpace.getUsersession();
		if (session != null) {
			return session;
		}
		return null;
	}

	/**
	 * Returns the User in the project of the given projectSpace and username.
	 * 
	 * @param projectSpace
	 *            the project space
	 * @param username
	 *            the user name for that the user model element should match
	 * @return the user model element
	 * @throws CannotMatchUserInProjectException
	 *             if the user cannot be found in the project
	 */
	public static User getUser(ECPProject project, String username) {
		Set<User> projectUsers = getAllModelElementsByClass(project,
				User.class, true);
		for (User user : projectUsers) {
			if (user.getName().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public static <T extends EObject> Set<T> getAllModelElementsByClass(
			ECPProject project, Class<T> instanceClass,
			Boolean includeSubclasses) {
		Object provider = ((ECPProjectImpl) project).getProviderSpecificData();
		if (provider instanceof ESLocalProjectImpl) {
			return ((ESLocalProjectImpl) provider).getAllModelElementsByClass(
					instanceClass, true);
		}
		final LinkedHashSet<T> result = new LinkedHashSet<T>();
		return result;
	}

	/**
	 * Gets the team of the user. Includes all groups he is member of, all
	 * members of this groups and himself.
	 * 
	 * @param user
	 *            the user
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
	 * @param orgUnit
	 *            the organizational unit
	 * @return the set of groups
	 */
	public static Set<Group> getAllGroupsOfOrgUnit(OrgUnit orgUnit) {
		return getAllGroupsOfOrgUnit(orgUnit, new HashSet<Group>());
	}

	private static Set<Group> getAllGroupsOfOrgUnit(OrgUnit orgUnit,
			Set<Group> alreadySeenGroups) {
		for (Group group : orgUnit.getGroupMemberships()) {
			if (!alreadySeenGroups.contains(group)) {
				alreadySeenGroups.add(group);
				getAllGroupsOfOrgUnit(orgUnit, alreadySeenGroups);
			}
		}
		return alreadySeenGroups;
	}

	/**
	 * Imports users from the access control to the project in the given project
	 * space. Will only work if the usersession of the project space is an admin
	 * user.
	 * 
	 * @param projectSpace
	 *            the project space
	 * @throws AccessControlException
	 *             if the user has no admin rights
	 */
	public static void importACUsers(ProjectSpace projectSpace)
			throws AccessControlException {
		AccessControlHelper accessControlHelper = new AccessControlHelper(
				projectSpace.getUsersession());
		accessControlHelper
				.checkProjectAdminAccess(projectSpace.getProjectId());
		try {
			List<ACOrgUnit> participants = projectSpace.getWorkspace()
					.getAdminBroker(projectSpace.getUsersession())
					.getParticipants(projectSpace.getProjectId());
			if (participants != null) {
				addToProject(participants, projectSpace);
			}
		} catch (ConnectionException e) {
			WorkspaceUtil.logException("Importing users failed!", e);
		} catch (ESException e) {
			ModelUtil.logWarning(e.getMessage(), e);
		}
	}

	/**
	 * Adds a list of acUsers to a project.
	 * 
	 * @param participants
	 *            The list of ACUser
	 * @param projectSpace
	 *            The projectSpace which contains the project
	 */
	private static void addToProject(List<ACOrgUnit> participants,
			ProjectSpace projectSpace) {
		HashMap<String, User> userIdMap = new HashMap<String, User>();
		HashMap<String, User> userNameMap = new HashMap<String, User>();
		List<ACUser> importUserList = new ArrayList<ACUser>();
		Project project = projectSpace.getProject();
		Set<? extends User> existingUsers = project.getAllModelElementsByClass(
				User.class, true);
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

	private static void convertList(List<ACOrgUnit> participants,
			List<ACUser> importUserList, ProjectSpace projectSpace) {
		for (ACOrgUnit orgUnit : participants) {
			if (orgUnit instanceof ACUser) {
				importUserList.add((ACUser) orgUnit);
			}
			if (orgUnit instanceof ACGroup) {
				List<ACOrgUnit> recursiveList = null;
				try {
					recursiveList = projectSpace.getWorkspace()
							.getAdminBroker(projectSpace.getUsersession())
							.getMembers(orgUnit.getId());
				} catch (ConnectionException e) {
					WorkspaceUtil.logException("Importing users failed!", e);
				} catch (AccessControlException e) {
					ModelUtil.logWarning(e.getMessage(), e);
				} catch (ESException e) {
					ModelUtil.logWarning(e.getMessage(), e);
				}
				if (recursiveList != null) {
					convertList(recursiveList, importUserList, projectSpace);
				}

			}
		}

	}

	@SuppressWarnings("restriction")
	public static ESUsersession getUserSession(Project project) {
		ECPProject ecpProject = ECPUtil.getECPProjectManager().getProject(
				((ProjectSpace) project.eContainer()).getProjectName());
		if (ecpProject != null) {
			try {
				getUserSession(ecpProject);
			} catch (UnkownProjectException e) {
				ModelUtil.logException(e);
			}
		}
		return null;
	}
}

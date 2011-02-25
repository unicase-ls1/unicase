/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.exceptions.CannotMatchUserInProjectException;

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
		ProjectSpace activeProjectSpace = currentWorkspace.getActiveProjectSpace();
		if (activeProjectSpace == null) {
			throw new NoCurrentUserException();
		}
		return getUser(activeProjectSpace);
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

}

/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
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

/**
 * Helper for OrgUnit operations.
 * @author helming
 *
 */
public final class OrgUnitHelper {
	
	private OrgUnitHelper() {
		
	}
/**
 * Returns the current User in the project, whos logged in.
 * @param currentWorkspace the current workspace
 * @return The current user
 */
	public static User getCurrentUser(Workspace currentWorkspace) {
		ProjectSpace activeProjectSpace = currentWorkspace
		.getActiveProjectSpace();
		if(activeProjectSpace==null){
			return null;
		}
		//JH: handle non-existing usersession
		Usersession currentUserSession = activeProjectSpace.getUsersession();
		EList<User> projectUsers = currentWorkspace.getActiveProjectSpace()
				.getProject().getAllModelElementsbyClass(
						OrganizationPackage.eINSTANCE.getUser(),
						new BasicEList<User>());
		String id = currentUserSession.getACUser().getId().getId();
		for (User currentUser : projectUsers) {
			// FS how can I get the appropriate user from the current user
			// session?
			if (currentUser.getAcOrgId().equals(id)) {
				return currentUser;
			}
		}
		return null;
	}
/**
 * Gets the team of the user. Includes all groups he is member of, all members of this groups and himself.
 * @param user the user
 * @return his team
 */
	public static Set<OrgUnit> getTeam(User user) {
		Set<OrgUnit> team = new HashSet<OrgUnit>();
		if(user==null){
			return team;
		}
		team.add(user);
		List<Group> groupMemberships = user.getGroupMemberships();
		for(Group group: groupMemberships){
			team.add(group);
			team.addAll(group.getOrgUnits());
		}
		return team;
		
		
	}

}

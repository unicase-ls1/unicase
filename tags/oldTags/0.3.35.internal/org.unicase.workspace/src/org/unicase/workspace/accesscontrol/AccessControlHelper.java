/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.accesscontrol;

import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.esmodel.accesscontrol.roles.ServerAdmin;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.workspace.Usersession;

/**
 * Helper class for access control checks.
 * 
 * @author koegel
 */
public class AccessControlHelper {

	private ACUser user;
	private Usersession usersession;

	/**
	 * Default constructor.
	 * 
	 * @param usersession the user session that needs to be checked
	 */
	public AccessControlHelper(Usersession usersession) {
		this.usersession = usersession;
		this.user = usersession.getACUser();
	}

	/**
	 * Check write access for the given project.
	 * 
	 * @param projectId the project id
	 * @throws AccessControlException if access is denied.
	 */
	public void checkWriteAccess(ProjectId projectId) throws AccessControlException {
		for (Role role : user.getRoles()) {
			if (role.canDelete(projectId, null) || role.canCreate(projectId, null) || role.canModify(projectId, null)) {
				return;
			}
		}
		throw new AccessControlException();
	}

	/**
	 * Check project admin access for the given project.
	 * 
	 * @param projectId the project id
	 * @throws AccessControlException if access is denied.
	 */
	public void checkProjectAdminAccess(ProjectId projectId) throws AccessControlException {
		for (Role role : user.getRoles()) {
			if (role.canAdministrate(projectId)) {
				return;
			}
		}
		throw new AccessControlException();
	}

	/**
	 * Check the server admin access.
	 * 
	 * @throws AccessControlException if access is denied.
	 */
	public void checkServerAdminAccess() throws AccessControlException {
		for (Role role : user.getRoles()) {
			if (role instanceof ServerAdmin) {
				return;
			}
		}
		throw new AccessControlException();
	}

	/**
	 * @return usersession
	 */
	public Usersession getUsersession() {
		return usersession;
	}
}

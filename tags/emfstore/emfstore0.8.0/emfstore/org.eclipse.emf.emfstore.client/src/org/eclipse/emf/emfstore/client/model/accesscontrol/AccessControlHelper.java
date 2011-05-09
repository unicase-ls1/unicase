/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.accesscontrol;

import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.Role;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.ServerAdmin;

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

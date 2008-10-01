/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.util;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;

//JH please comment
public final class OrgUnitHelper {
	
	private OrgUnitHelper() {
		
	}

	public static User getCurrentUser(Workspace currentWorkspace) {
		Usersession currentUserSession = currentWorkspace
				.getActiveProjectSpace().getUsersession();
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

}

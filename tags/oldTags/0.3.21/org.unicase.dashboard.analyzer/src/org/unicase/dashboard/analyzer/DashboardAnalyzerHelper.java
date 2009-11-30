/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard.analyzer;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.workspace.ProjectSpace;

/**
 * Helper class.
 * 
 * @author shterev
 */
public final class DashboardAnalyzerHelper {

	private DashboardAnalyzerHelper() {

	}

	/**
	 * Matches a unicase OrgUnit user to its username.
	 * 
	 * @param projectSpace the {@link ProjectSpace}
	 * @param username the username.
	 * @return the user if existing
	 */
	public static User getUser(ProjectSpace projectSpace, String username) {
		EList<User> projectUsers = projectSpace.getProject().getAllModelElementsbyClass(
			OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>());
		for (User currentUser : projectUsers) {
			if (currentUser.getName().equals(username)) {
				return currentUser;
			}
		}
		return null;
	}
}

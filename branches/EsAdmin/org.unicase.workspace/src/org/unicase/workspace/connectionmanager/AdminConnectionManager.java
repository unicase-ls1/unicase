/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.connectionmanager;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;

public interface AdminConnectionManager {

	/**
	 * Added the methods from AdminEmfStore and removed extension of the
	 * interface until AdminUsersession and RMI is implemented in order to use
	 * the stub.
	 * 
	 */

	EList<ProjectInfo> getProjectInfos();

	EList<ACGroup> getGroups();

	EList<ACUser> getUsers();

	EList<ACOrgUnit> getOrgUnits();

	EList<ACGroup> getGroups(ACUser user);

	void addGroup(ACUser user, ACGroup group);

	void removeGroup(ACUser user, ACGroup group);

	EList<ACOrgUnit> getParticipants(ProjectInfo project);

	void addParticipant(ProjectInfo project, ACOrgUnit participant);

	void removeParticipant(ProjectInfo project, ACOrgUnit participant);

	Role getRole(ProjectInfo project, ACOrgUnit orgUnit);

	void changeRole(ProjectInfo projectInfo, ACOrgUnit orgUnit, EClass role);
}

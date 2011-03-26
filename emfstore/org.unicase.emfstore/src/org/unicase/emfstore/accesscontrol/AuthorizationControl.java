/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.accesscontrol;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.AccessControlException;

/**
 * Control for the authorization of users.
 * 
 * @author koegel
 */
public interface AuthorizationControl {

	/**
	 * Check if the given session is valid.
	 * 
	 * @param sessionId the session id
	 * @throws AccessControlException if the session is invalid
	 */
	void checkSession(SessionId sessionId) throws AccessControlException;

	/**
	 * Check if the session is valid for admin access to the given project.
	 * 
	 * @param sessionId the session id
	 * @param projectId the project id
	 * @throws AccessControlException if the session is invalid for admin access
	 */
	void checkProjectAdminAccess(SessionId sessionId, ProjectId projectId) throws AccessControlException;

	/**
	 * Check if the session is valid for server admin access.
	 * 
	 * @param sessionId the session id
	 * @throws AccessControlException if the session is invalid for server admin access
	 */
	void checkServerAdminAccess(SessionId sessionId) throws AccessControlException;

	/**
	 * Check if the session may read the given model elements in the project.
	 * 
	 * @param sessionId session id
	 * @param projectId project id
	 * @param modelElements a set of model elements
	 * @throws AccessControlException if the session may not read any of the model elements
	 */
	void checkReadAccess(SessionId sessionId, ProjectId projectId, Set<EObject> modelElements)
		throws AccessControlException;

	/**
	 * Check if the session may write the given model elements in the project.
	 * 
	 * @param sessionId session id
	 * @param projectId project id
	 * @param modelElements a set of model elements
	 * @throws AccessControlException if the session may not write any of the model elements
	 */
	void checkWriteAccess(SessionId sessionId, ProjectId projectId, Set<EObject> modelElements)
		throws AccessControlException;

	/**
	 * This method looks up the session id on the server and returns the relating user. Please notice that the returned
	 * user also contains roles which are not contained in the original user. These extra roles come from the user's
	 * groups.
	 * 
	 * @param sessionId session id
	 * @return ACUser user with roles from resolved user and it's groups
	 * @throws AccessControlException exception
	 */
	ACUser resolveUser(SessionId sessionId) throws AccessControlException;

	/**
	 * This method looks up the orgUnit id the server and returns the relating user. Please notice that the returned
	 * user also contains roles which are not contained in the original user. These extra roles come from the user's
	 * groups.
	 * 
	 * @param orgUnitId OrgUnit id
	 * @return ACUser user with roles from resolved user and it's groups
	 * @throws AccessControlException exception
	 */
	ACUser resolveUser(ACOrgUnitId orgUnitId) throws AccessControlException;
}

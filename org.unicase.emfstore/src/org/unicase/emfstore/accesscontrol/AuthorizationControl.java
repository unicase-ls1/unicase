/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.accesscontrol;

import java.util.Set;

import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.model.ModelElement;

/**
 * Control for the authorization of users.
 * 
 * @author koegel
 * 
 */
public interface AuthorizationControl {

	/**
	 * Check if the given session is valid.
	 * 
	 * @param sessionId
	 *            the session id
	 * @throws AccessControlException
	 *             if the session is invalid
	 */
	void checkSession(SessionId sessionId) throws AccessControlException;

	/**
	 * Check if the session is valid for admin access to the given project.
	 * 
	 * @param sessionId
	 *            the session id
	 * @param projectId
	 *            the project id
	 * @throws AccessControlException
	 *             if the session is invalid for admin access
	 */
	void checkProjectAdminAccess(SessionId sessionId, ProjectId projectId)
			throws AccessControlException;

	/**
	 * Check if the session is valid for server admin access.
	 * 
	 * @param sessionId
	 *            the session id
	 * @throws AccessControlException
	 *             if the session is invalid for server admin access
	 */
	void checkServerAdminAccess(SessionId sessionId)
			throws AccessControlException;

	/**
	 * Check if the session may read the given model elements in the project.
	 * 
	 * @param sessionId
	 *            session id
	 * @param projectId
	 *            project id
	 * @param modelElements
	 *            a set of model elements
	 * @throws AccessControlException
	 *             if the session may not read any of the model elements
	 */
	void checkReadAccess(SessionId sessionId, ProjectId projectId,
			Set<ModelElement> modelElements) throws AccessControlException;
	/**
	 * Check if the session may write the given model elements in the project.
	 * 
	 * @param sessionId
	 *            session id
	 * @param projectId
	 *            project id
	 * @param modelElements
	 *            a set of model elements
	 * @throws AccessControlException
	 *             if the session may not write any of the model elements
	 */
	void checkWriteAccess(SessionId sessionId, ProjectId projectId,
			Set<ModelElement> modelElements) throws AccessControlException;

	ACUser getUser(SessionId sessionId) throws AccessControlException;
}

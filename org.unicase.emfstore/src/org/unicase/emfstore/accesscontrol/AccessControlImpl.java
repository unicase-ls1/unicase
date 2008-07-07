/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.accesscontrol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.esmodel.accesscontrol.roles.ServerAdmin;
import org.unicase.model.ModelElement;

/**
 * A simple implementation of Authentication and Authorization Control.
 * 
 * @author koegel
 * 
 */
public class AccessControlImpl implements AuthenticationControl,
		AuthorizationControl {

	private Map<SessionId, ACUser> sessionUserMap;
	private ServerSpace serverSpace;

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace
	 *            the server space to work on
	 */
	public AccessControlImpl(ServerSpace serverSpace) {
		this.sessionUserMap = new HashMap<SessionId, ACUser>();
		this.serverSpace = serverSpace;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.accesscontrol.AuthenticationControl#logIn(java.lang.String,
	 *      java.lang.String)
	 */
	public SessionId logIn(String username, String password)
			throws AccessControlException {

		SessionId sessionId = EsmodelFactory.eINSTANCE.createSessionId();
		//ACUser user = resolveUser(username);
		// // FIXME:checkpassword here
		// sessionUserMap.put(sessionId, user);
		return sessionId;
	}

	/**
	 * Resolve a String to a user.
	 * 
	 * @param username
	 * @return the ACuser instance with the given name
	 * @throws AccessControlException
	 *             if there is no such user
	 */
	private ACUser resolveUser(String username) throws AccessControlException {
		for (ACUser user : serverSpace.getUsers()) {
			if (user.getName().equals(username)) {
				return user;
			}
		}
		throw new AccessControlException();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.accesscontrol.AuthorizationControl#checkSession(org.unicase.emfstore.esmodel.SessionId)
	 */
	public void checkSession(SessionId sessionId) throws AccessControlException {
		if (!sessionUserMap.containsKey(sessionId)) {
			throw new AccessControlException("Session ID unkown.");
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.accesscontrol.AuthorizationControl#checkWriteAccess(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.ProjectId, java.util.Set)
	 */
	public void checkWriteAccess(SessionId sessionId, ProjectId projectId,
			Set<ModelElement> modelElements) throws AccessControlException {
		checkSession(sessionId);
		ACUser user = sessionUserMap.get(sessionId);
		List<Role> roles = user.getRoles();
		for (ModelElement modelElement : modelElements) {
			if (!canWrite(roles, projectId, modelElement)) {
				throw new AccessControlException();
			}
		}
	}

	/**
	 * Check if the given list of roles can write to the model element in the
	 * project.
	 * 
	 * @param roles a list of roles
	 * @param projectId a project id
	 * @param modelElement a model element
	 * @return true if one of the roles can write
	 * @throws AccessControlException
	 */
	private boolean canWrite(List<Role> roles, ProjectId projectId,
			ModelElement modelElement) throws AccessControlException {
		for (Role role : roles) {
			if (role.canModify(projectId, modelElement)
					|| role.canCreate(projectId, modelElement)
					|| role.canDelete(projectId, modelElement)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if the given list of roles can read the model element in the
	 * project.
	 * 
	 * @param roles a list of roles
	 * @param projectId a project id
	 * @param modelElement a model element
	 * @return true if one of the roles can read
	 * @throws AccessControlException
	 */
	private boolean canRead(List<Role> roles, ProjectId projectId,
			ModelElement modelElement) throws AccessControlException {
		for (Role role : roles) {
			if (role.canRead(projectId, modelElement)) {
				return true;
			}
		}
		return false;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.accesscontrol.AuthorizationControl#checkReadAccess(org.unicase.emfstore.esmodel.SessionId, org.unicase.emfstore.esmodel.ProjectId, java.util.Set)
	 */
	public void checkReadAccess(SessionId sessionId, ProjectId projectId,
			Set<ModelElement> modelElements) throws AccessControlException {
		checkSession(sessionId);
		ACUser user = sessionUserMap.get(sessionId);
		List<Role> roles = user.getRoles();
		for (ModelElement modelElement : modelElements) {
			if (!canRead(roles, projectId, modelElement)) {
				throw new AccessControlException();
			}
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.accesscontrol.AuthorizationControl#checkProjectAdminAccess(org.unicase.emfstore.esmodel.SessionId, org.unicase.emfstore.esmodel.ProjectId)
	 */
	public void checkProjectAdminAccess(SessionId sessionId, ProjectId projectId)
			throws AccessControlException {
		checkSession(sessionId);
		ACUser user = sessionUserMap.get(sessionId);
		List<Role> roles = user.getRoles();
		for (Role role : roles) {
			if (role.canAdministrate(projectId)) {
				return;
			}
		}
		throw new AccessControlException();
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.accesscontrol.AuthorizationControl#checkServerAdminAccess(org.unicase.emfstore.esmodel.SessionId)
	 */
	public void checkServerAdminAccess(SessionId sessionId)
			throws AccessControlException {
		checkSession(sessionId);
		ACUser user = sessionUserMap.get(sessionId);
		List<Role> roles = user.getRoles();
		for (Role role : roles) {
			if (role instanceof ServerAdmin) {
				return;
			}
		}
		throw new AccessControlException();

	}

}

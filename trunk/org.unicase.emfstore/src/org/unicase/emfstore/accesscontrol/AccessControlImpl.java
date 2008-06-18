/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
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

public class AccessControlImpl implements AuthenticationControl,
		AuthorizationControl {

	private Map<SessionId, ACUser> sessionUserMap;
	private ServerSpace serverSpace;

	public AccessControlImpl(ServerSpace serverSpace) {
		this.sessionUserMap = new HashMap<SessionId, ACUser>();
		this.serverSpace = serverSpace;
	}

	public SessionId logIn(String username, String password)
			throws AccessControlException {

		SessionId sessionId = EsmodelFactory.eINSTANCE.createSessionId();
		// ACUser user = resolveUser(username);
		// // FIXME:checkpassword here
		// sessionUserMap.put(sessionId, user);
		return sessionId;
	}

	private ACUser resolveUser(String username) throws AccessControlException {
		for (ACUser user : serverSpace.getUsers()) {
			if (user.getName().equals(username)) {
				return user;
			}
		}
		throw new AccessControlException();
	}

	public void checkSession(SessionId sessionId) throws AccessControlException {
		if (!sessionUserMap.containsKey(sessionId)) {
			throw new AccessControlException("Session ID unkown.");
		}
	}

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

	private boolean canRead(List<Role> roles, ProjectId projectId,
			ModelElement modelElement) throws AccessControlException {
		for (Role role : roles) {
			if (role.canRead(projectId, modelElement)) {
				return true;
			}
		}
		return false;
	}

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

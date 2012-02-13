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
package org.eclipse.emf.emfstore.server.accesscontrol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.server.ServerConfiguration;
import org.eclipse.emf.emfstore.server.accesscontrol.authentication.AbstractAuthenticationControl;
import org.eclipse.emf.emfstore.server.accesscontrol.authentication.factory.AuthenticationControlFactory;
import org.eclipse.emf.emfstore.server.accesscontrol.authentication.factory.AuthenticationControlFactoryImpl;
import org.eclipse.emf.emfstore.server.core.MonitorProvider;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.SessionTimedOutException;
import org.eclipse.emf.emfstore.server.model.ClientVersionInfo;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ServerSpace;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.Role;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.ServerAdmin;

/**
 * A simple implementation of Authentication and Authorization Control.
 * 
 * @author koegel
 * @author wesendonk
 */
public class AccessControlImpl implements AuthenticationControl,
		AuthorizationControl {

	private Map<SessionId, ACUserContainer> sessionUserMap;
	private ServerSpace serverSpace;
	private AbstractAuthenticationControl authenticationControl;

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace
	 *            the server space to work on
	 * @throws FatalEmfStoreException
	 *             an exception
	 */
	public AccessControlImpl(ServerSpace serverSpace)
			throws FatalEmfStoreException {
		this.sessionUserMap = new HashMap<SessionId, ACUserContainer>();
		this.serverSpace = serverSpace;

		authenticationControl = getAuthenticationFactory()
				.createAuthenticationControl();
	}

	private AuthenticationControlFactory getAuthenticationFactory() {
		IConfigurationElement[] config = Platform
				.getExtensionRegistry()
				.getConfigurationElementsFor(
						"org.eclipse.emf.emfstore.server.authenticationfactory");

		// get all providers from the extension points
		for (IConfigurationElement e : config) {
			try {
				Object o = e.createExecutableExtension("class");
				if (o instanceof AuthenticationControlFactory) {
					return (AuthenticationControlFactory) o;
				}
			} catch (CoreException e1) {
				// fail silently
				// e1.printStackTrace();
			}
		}

		// fallback in case that no factory was registered
		return new AuthenticationControlFactoryImpl();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.AuthenticationControl#logIn(java.lang.String,
	 *      java.lang.String)
	 */
	public SessionId logIn(String username, String password,
			ClientVersionInfo clientVersionInfo) throws AccessControlException {
		synchronized (MonitorProvider.getInstance()
				.getMonitor("authentication")) {
			ACUser user = resolveUser(username);
			SessionId sessionId = authenticationControl.logIn(user.getName(),
					password, clientVersionInfo);
			sessionUserMap.put(sessionId, new ACUserContainer(user));
			return sessionId;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.AuthenticationControl#logout(org.eclipse.emf.emfstore.server.model.SessionId)
	 */
	public void logout(SessionId sessionId) throws AccessControlException {
		synchronized (MonitorProvider.getInstance()
				.getMonitor("authentication")) {
			if (sessionId == null) {
				throw new AccessControlException("SessionId is null.");
			}
			sessionUserMap.remove(sessionId);
		}
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

		Boolean ignoreCase = Boolean
				.parseBoolean(ServerConfiguration
						.getProperties()
						.getProperty(
								ServerConfiguration.AUTHENTICATION_MATCH_USERS_IGNORE_CASE,
								"false"));

		synchronized (MonitorProvider.getInstance().getMonitor()) {
			for (ACUser user : serverSpace.getUsers()) {
				if (ignoreCase) {
					if (user.getName().equalsIgnoreCase(username)) {
						return user;
					}
				} else {
					if (user.getName().equals(username)) {
						return user;
					}
				}
			}
			throw new AccessControlException();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.AuthorizationControl#checkSession(org.eclipse.emf.emfstore.server.model.SessionId)
	 */
	public void checkSession(SessionId sessionId) throws AccessControlException {
		if (!sessionUserMap.containsKey(sessionId)) {
			throw new SessionTimedOutException("Session ID unkown.");
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.AuthorizationControl#checkWriteAccess(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.ProjectId, java.util.Set)
	 */
	public void checkWriteAccess(SessionId sessionId, ProjectId projectId,
			Set<EObject> modelElements) throws AccessControlException {
		checkSession(sessionId);
		ACUser user = getUser(sessionId);
		List<Role> roles = new ArrayList<Role>();
		roles.addAll(user.getRoles());
		roles.addAll(getRolesFromGroups(user));
		// MK: remove access control simplification
		if (!canWrite(roles, projectId, null)) {
			throw new AccessControlException();
			// for (ModelElement modelElement : modelElements) {
			// if (!canWrite(roles, projectId, modelElement)) {
			// throw new AccessControlException();
			// }
		}
	}

	/**
	 * Check if the given list of roles can write to the model element in the
	 * project.
	 * 
	 * @param roles
	 *            a list of roles
	 * @param projectId
	 *            a project id
	 * @param modelElement
	 *            a model element
	 * @return true if one of the roles can write
	 * @throws AccessControlException
	 */
	private boolean canWrite(List<Role> roles, ProjectId projectId,
			EObject modelElement) throws AccessControlException {
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
	 * @param roles
	 *            a list of roles
	 * @param projectId
	 *            a project id
	 * @param modelElement
	 *            a model element
	 * @return true if one of the roles can read
	 * @throws AccessControlException
	 */
	private boolean canRead(List<Role> roles, ProjectId projectId,
			EObject modelElement) throws AccessControlException {
		for (Role role : roles) {
			if (role.canRead(projectId, modelElement)) {
				return true;
			}
		}
		return false;
	}

	private List<Role> getRolesFromGroups(ACOrgUnit orgUnit) {
		ArrayList<Role> roles = new ArrayList<Role>();
		for (ACGroup group : getGroups(orgUnit)) {
			roles.addAll(group.getRoles());
		}
		return roles;
	}

	private List<ACGroup> getGroups(ACOrgUnit orgUnit) {
		synchronized (MonitorProvider.getInstance().getMonitor()) {
			ArrayList<ACGroup> groups = new ArrayList<ACGroup>();
			for (ACGroup group : serverSpace.getGroups()) {
				if (group.getMembers().contains(orgUnit)) {
					groups.add(group);
					for (ACGroup g : getGroups(group)) {
						if (groups.contains(g)) {
							continue;
						}
						groups.add(g);
					}
				}
			}
			return groups;
		}
	}

	private ACUser getUser(ACOrgUnitId orgUnitId) throws AccessControlException {
		synchronized (MonitorProvider.getInstance().getMonitor()) {
			for (ACUser user : serverSpace.getUsers()) {
				if (user.getId().equals(orgUnitId)) {
					return user;
				}
			}
			throw new AccessControlException("Given User doesn't exist.");
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.AuthorizationControl#checkReadAccess(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.ProjectId, java.util.Set)
	 */
	public void checkReadAccess(SessionId sessionId, ProjectId projectId,
			Set<EObject> modelElements) throws AccessControlException {
		checkSession(sessionId);
		ACUser user = getUser(sessionId);
		List<Role> roles = new ArrayList<Role>();
		roles.addAll(user.getRoles());
		roles.addAll(getRolesFromGroups(user));
		// MK: remove access control simplification
		if (!canRead(roles, projectId, null)) {
			throw new AccessControlException();
			// for (ModelElement modelElement : modelElements) {
			// if (!canRead(roles, projectId, modelElement)) {
			// throw new AccessControlException();
			// }
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.AuthorizationControl#checkProjectAdminAccess(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.ProjectId)
	 */
	public void checkProjectAdminAccess(SessionId sessionId, ProjectId projectId)
			throws AccessControlException {
		checkSession(sessionId);
		ACUser user = getUser(sessionId);
		List<Role> roles = new ArrayList<Role>();
		roles.addAll(user.getRoles());
		roles.addAll(getRolesFromGroups(user));
		for (Role role : roles) {
			if (role.canAdministrate(projectId)) {
				return;
			}
		}
		throw new AccessControlException();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.AuthorizationControl#checkServerAdminAccess(org.eclipse.emf.emfstore.server.model.SessionId)
	 */
	public void checkServerAdminAccess(SessionId sessionId)
			throws AccessControlException {
		checkSession(sessionId);
		ACUser user = getUser(sessionId);
		List<Role> roles = new ArrayList<Role>();
		roles.addAll(user.getRoles());
		roles.addAll(getRolesFromGroups(user));
		for (Role role : roles) {
			if (role instanceof ServerAdmin) {
				return;
			}
		}
		throw new AccessControlException();

	}

	/**
	 * {@inheritDoc}
	 */
	public ACUser resolveUser(SessionId sessionId)
			throws AccessControlException {
		checkSession(sessionId);
		ACUser tmpUser = sessionUserMap.get(sessionId).getRawUser();
		return copyAndResolveUser(tmpUser);
	}

	/**
	 * {@inheritDoc}
	 */
	public ACUser resolveUser(ACOrgUnitId id) throws AccessControlException {
		ACUser tmpUser = getUser(id);
		return copyAndResolveUser(tmpUser);
	}

	private ACUser copyAndResolveUser(ACUser tmpUser) {
		ACUser user = (ACUser) EcoreUtil.copy(tmpUser);
		for (Role role : getRolesFromGroups(tmpUser)) {
			user.getRoles().add((Role) EcoreUtil.copy(role));
		}

		for (ACGroup group : getGroups(tmpUser)) {
			if (user.getEffectiveGroups().contains(group)) {
				continue;
			}
			ACGroup copy = (ACGroup) EcoreUtil.copy(group);
			copy.getMembers().clear();
		}

		return user;
	}

	private ACUser getUser(SessionId sessionId) throws AccessControlException {
		try {
			return sessionUserMap.get(sessionId).getUser();
		} catch (AccessControlException e) {
			sessionUserMap.remove(sessionId);
			throw e;
		}
	}

	// extract to normal class
	/**
	 * @author wesendonk
	 */
	private class ACUserContainer {
		private ACUser acUser;
		// private long firstActive;
		private long lastActive;

		public ACUserContainer(ACUser acUser) {
			this.acUser = acUser;
			// firstActive = System.currentTimeMillis();
			active();
		}

		/**
		 * Get the ACUser.
		 * 
		 * @return
		 * @throws AccessControlException
		 */
		public ACUser getUser() throws AccessControlException {
			// OW: timeout behaviour does not work as expected
			checkLastActive();
			active();
			return getRawUser();
		}

		public ACUser getRawUser() {
			return acUser;
		}

		public void checkLastActive() throws AccessControlException {
			// OW finish implementing this method
			String property = ServerConfiguration.getProperties().getProperty(
					ServerConfiguration.SESSION_TIMEOUT,
					ServerConfiguration.SESSION_TIMEOUT_DEFAULT);
			if (System.currentTimeMillis() - lastActive > Integer
					.parseInt(property)
			/*
			 * || System.currentTimeMillis() - firstActive >
			 * Integer.parseInt(property)
			 */) {
				// OW: delete from map
				throw new SessionTimedOutException("Usersession timed out.");
			}
		}

		private void active() {
			lastActive = System.currentTimeMillis();
		}
	}
}

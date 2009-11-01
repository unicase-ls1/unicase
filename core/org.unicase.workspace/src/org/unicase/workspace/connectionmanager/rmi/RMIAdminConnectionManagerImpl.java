/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.connectionmanager.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.connection.rmi.RMIAdminConnectionHandler;
import org.unicase.emfstore.connection.rmi.RMIAdminEmfStoreFacade;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.UnknownSessionException;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.connectionmanager.AdminConnectionManager;

/**
 * @author Wesendonk
 */
public class RMIAdminConnectionManagerImpl implements AdminConnectionManager {

	private HashMap<SessionId, RMIAdminEmfStoreFacade> adminFacadeMap;

	private static final String REMOTE = "A rmi communication-related exception.";

	/**
	 * Default constructor.
	 */
	public RMIAdminConnectionManagerImpl() {
		adminFacadeMap = new HashMap<SessionId, RMIAdminEmfStoreFacade>();
	}

	/**
	 * {@inheritDoc}
	 */
	public void addParticipant(SessionId sessionId, ProjectId projectId, ACOrgUnitId participant)
		throws EmfStoreException {
		try {
			getFacade(sessionId).addParticipant(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(projectId), SerializationUtil.eObjectToString(participant));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void changeRole(SessionId sessionId, ProjectId projectId, ACOrgUnitId orgUnit, EClass role)
		throws EmfStoreException {
		try {
			getFacade(sessionId).changeRole(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(projectId), SerializationUtil.eObjectToString(orgUnit),
				SerializationUtil.eObjectToString(role));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACGroup> getGroups(SessionId sessionId) throws EmfStoreException {
		try {
			List<ACGroup> result = new ArrayList<ACGroup>();
			for (String str : getFacade(sessionId).getGroups(SerializationUtil.eObjectToString(sessionId))) {
				result.add((ACGroup) SerializationUtil.stringToEObject(str));
			}
			return result;
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACGroup> getGroups(SessionId sessionId, ACOrgUnitId user) throws EmfStoreException {
		try {
			List<ACGroup> result = new ArrayList<ACGroup>();
			for (String str : getFacade(sessionId).getGroups(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(user))) {
				result.add((ACGroup) SerializationUtil.stringToEObject(str));
			}
			return result;
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACOrgUnit> getOrgUnits(SessionId sessionId) throws EmfStoreException {
		try {
			List<ACOrgUnit> result = new ArrayList<ACOrgUnit>();
			for (String str : getFacade(sessionId).getOrgUnits(SerializationUtil.eObjectToString(sessionId))) {
				result.add((ACOrgUnit) SerializationUtil.stringToEObject(str));
			}
			return result;
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACOrgUnit> getParticipants(SessionId sessionId, ProjectId projectId) throws EmfStoreException {
		try {
			List<ACOrgUnit> result = new ArrayList<ACOrgUnit>();
			for (String str : getFacade(sessionId).getParticipants(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(projectId))) {
				result.add((ACOrgUnit) SerializationUtil.stringToEObject(str));
			}
			return result;
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACOrgUnit> getMembers(SessionId sessionId, ACOrgUnitId groupId) throws EmfStoreException {
		try {
			List<ACOrgUnit> result = new ArrayList<ACOrgUnit>();
			for (String str : getFacade(sessionId).getMembers(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(groupId))) {
				result.add((ACOrgUnit) SerializationUtil.stringToEObject(str));
			}
			return result;
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ProjectInfo> getProjectInfos(SessionId sessionId) throws EmfStoreException {
		try {
			List<ProjectInfo> result = new ArrayList<ProjectInfo>();
			for (String str : getFacade(sessionId).getProjectInfos(SerializationUtil.eObjectToString(sessionId))) {
				result.add((ProjectInfo) SerializationUtil.stringToEObject(str));
			}
			return result;
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Role getRole(SessionId sessionId, ProjectId projectId, ACOrgUnitId orgUnit) throws EmfStoreException {
		try {
			return (Role) SerializationUtil.stringToEObject(getFacade(sessionId).getRole(
				SerializationUtil.eObjectToString(sessionId), SerializationUtil.eObjectToString(projectId),
				SerializationUtil.eObjectToString(orgUnit)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACUser> getUsers(SessionId sessionId) throws EmfStoreException {
		try {
			List<ACUser> result = new ArrayList<ACUser>();
			for (String user : getFacade(sessionId).getUsers(SerializationUtil.eObjectToString(sessionId))) {
				result.add((ACUser) SerializationUtil.stringToEObject(user));
			}
			return result;
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeGroup(SessionId sessionId, ACOrgUnitId user, ACOrgUnitId group) throws EmfStoreException {
		try {
			getFacade(sessionId).removeGroup(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(user), SerializationUtil.eObjectToString(group));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeParticipant(SessionId sessionId, ProjectId projectId, ACOrgUnitId participant)
		throws EmfStoreException {
		try {
			getFacade(sessionId).removeParticipant(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(projectId), SerializationUtil.eObjectToString(participant));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ACOrgUnitId createGroup(SessionId sessionId, String name) throws EmfStoreException {
		try {
			return (ACOrgUnitId) SerializationUtil.stringToEObject((getFacade(sessionId).createGroup(SerializationUtil
				.eObjectToString(sessionId), name)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ACOrgUnitId createUser(SessionId sessionId, String name) throws EmfStoreException {
		try {
			return (ACOrgUnitId) SerializationUtil.stringToEObject(getFacade(sessionId).createUser(
				SerializationUtil.eObjectToString(sessionId), name));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteGroup(SessionId sessionId, ACOrgUnitId group) throws EmfStoreException {
		try {
			getFacade(sessionId).deleteGroup(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(group));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteUser(SessionId sessionId, ACOrgUnitId user) throws EmfStoreException {
		try {
			getFacade(sessionId).deleteUser(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(user));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	private RMIAdminEmfStoreFacade getFacade(SessionId sessionId) throws EmfStoreException {
		RMIAdminEmfStoreFacade facade = adminFacadeMap.get(sessionId);
		if (facade == null) {
			throw new UnknownSessionException(
				"Session unkown to AdminConnectionManager, either log in first or init connection!");
		}
		return facade;
	}

	/**
	 * {@inheritDoc}
	 */
	public void initConnection(ServerInfo serverInfo, SessionId id) throws ConnectionException {
		Registry registry;
		RMIAdminEmfStoreFacade facade;
		try {
			registry = LocateRegistry.getRegistry(serverInfo.getUrl(), serverInfo.getPort());
			facade = (RMIAdminEmfStoreFacade) registry.lookup(RMIAdminConnectionHandler.RMI_NAME);
		} catch (RemoteException e) {
			throw new ConnectionException("todo");
		} catch (NotBoundException e) {
			throw new ConnectionException("Registry not available.");
		}
		adminFacadeMap.put(id, facade);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addMember(SessionId sessionId, ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException {
		try {
			getFacade(sessionId).addMember(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(group), SerializationUtil.eObjectToString(member));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeMember(SessionId sessionId, ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException {
		try {
			getFacade(sessionId).removeMember(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(group), SerializationUtil.eObjectToString(member));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void changeOrgUnit(SessionId sessionId, ACOrgUnitId orgUnitId, String name, String description)
		throws EmfStoreException {
		try {
			getFacade(sessionId).changeOrgUnit(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(orgUnitId), name, description);
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ACOrgUnit getOrgUnit(SessionId sessionId, ACOrgUnitId orgUnitId) throws EmfStoreException {
		try {
			return (ACOrgUnit) SerializationUtil.stringToEObject(getFacade(sessionId).getOrgUnit(
				SerializationUtil.eObjectToString(sessionId), SerializationUtil.eObjectToString(orgUnitId)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}
}

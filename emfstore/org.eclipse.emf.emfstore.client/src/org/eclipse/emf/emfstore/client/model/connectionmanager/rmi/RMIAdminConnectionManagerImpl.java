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
package org.eclipse.emf.emfstore.client.model.connectionmanager.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.connectionmanager.AbstractConnectionManager;
import org.eclipse.emf.emfstore.client.model.connectionmanager.AdminConnectionManager;
import org.eclipse.emf.emfstore.server.connection.rmi.RMIAdminConnectionHandler;
import org.eclipse.emf.emfstore.server.connection.rmi.RMIAdminEmfStoreFacade;
import org.eclipse.emf.emfstore.server.connection.rmi.SerializationUtil;
import org.eclipse.emf.emfstore.server.exceptions.ConnectionException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.Role;

/**
 * @author Wesendonk
 */
public class RMIAdminConnectionManagerImpl extends AbstractConnectionManager<RMIAdminEmfStoreFacade> implements
	AdminConnectionManager {

	private static final String REMOTE = "A rmi communication-related exception.";

	/**
	 * {@inheritDoc}
	 */
	public void addParticipant(SessionId sessionId, ProjectId projectId, ACOrgUnitId participant)
		throws EmfStoreException {
		try {
			getConnectionProxy(sessionId).addParticipant(SerializationUtil.eObjectToString(sessionId),
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
			getConnectionProxy(sessionId).changeRole(SerializationUtil.eObjectToString(sessionId),
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
			for (String str : getConnectionProxy(sessionId).getGroups(SerializationUtil.eObjectToString(sessionId))) {
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
			for (String str : getConnectionProxy(sessionId).getGroups(SerializationUtil.eObjectToString(sessionId),
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
			for (String str : getConnectionProxy(sessionId).getOrgUnits(SerializationUtil.eObjectToString(sessionId))) {
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
			for (String str : getConnectionProxy(sessionId).getParticipants(
				SerializationUtil.eObjectToString(sessionId), SerializationUtil.eObjectToString(projectId))) {
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
			for (String str : getConnectionProxy(sessionId).getMembers(SerializationUtil.eObjectToString(sessionId),
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
			for (String str : getConnectionProxy(sessionId).getProjectInfos(
				SerializationUtil.eObjectToString(sessionId))) {
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
			return (Role) SerializationUtil.stringToEObject(getConnectionProxy(sessionId).getRole(
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
			for (String user : getConnectionProxy(sessionId).getUsers(SerializationUtil.eObjectToString(sessionId))) {
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
			getConnectionProxy(sessionId).removeGroup(SerializationUtil.eObjectToString(sessionId),
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
			getConnectionProxy(sessionId).removeParticipant(SerializationUtil.eObjectToString(sessionId),
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
			return (ACOrgUnitId) SerializationUtil.stringToEObject((getConnectionProxy(sessionId).createGroup(
				SerializationUtil.eObjectToString(sessionId), name)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ACOrgUnitId createUser(SessionId sessionId, String name) throws EmfStoreException {
		try {
			return (ACOrgUnitId) SerializationUtil.stringToEObject(getConnectionProxy(sessionId).createUser(
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
			getConnectionProxy(sessionId).deleteGroup(SerializationUtil.eObjectToString(sessionId),
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
			getConnectionProxy(sessionId).deleteUser(SerializationUtil.eObjectToString(sessionId),
				SerializationUtil.eObjectToString(user));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
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
		addConnectionProxy(id, facade);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addMember(SessionId sessionId, ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException {
		try {
			getConnectionProxy(sessionId).addMember(SerializationUtil.eObjectToString(sessionId),
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
			getConnectionProxy(sessionId).removeMember(SerializationUtil.eObjectToString(sessionId),
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
			getConnectionProxy(sessionId).changeOrgUnit(SerializationUtil.eObjectToString(sessionId),
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
			return (ACOrgUnit) SerializationUtil.stringToEObject(getConnectionProxy(sessionId).getOrgUnit(
				SerializationUtil.eObjectToString(sessionId), SerializationUtil.eObjectToString(orgUnitId)));
		} catch (RemoteException e) {
			throw new ConnectionException(REMOTE, e);
		}
	}
}

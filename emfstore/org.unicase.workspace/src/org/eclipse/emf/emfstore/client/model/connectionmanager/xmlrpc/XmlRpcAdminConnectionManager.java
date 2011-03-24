/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.model.connectionmanager.xmlrpc;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.connectionmanager.AbstractConnectionManager;
import org.eclipse.emf.emfstore.client.model.connectionmanager.AdminConnectionManager;
import org.unicase.emfstore.connection.xmlrpc.XmlRpcAdminConnectionHander;
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

/**
 * connection manager for adminemfstore.
 * 
 * @author wesendon
 */
public class XmlRpcAdminConnectionManager extends AbstractConnectionManager<XmlRpcClientManager> implements
	AdminConnectionManager {

	/**
	 * {@inheritDoc}
	 */
	public void initConnection(ServerInfo serverInfo, SessionId id) throws ConnectionException {
		XmlRpcClientManager clientManager = new XmlRpcClientManager(XmlRpcAdminConnectionHander.ADMINEMFSTORE);
		clientManager.initConnection(serverInfo);
		addConnectionProxy(id, clientManager);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addMember(SessionId sessionId, ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException {
		getConnectionProxy(sessionId).call("addMember", sessionId, group, member);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addParticipant(SessionId sessionId, ProjectId projectId, ACOrgUnitId participant)
		throws EmfStoreException {
		getConnectionProxy(sessionId).call("addParticipant", sessionId, projectId, participant);
	}

	/**
	 * {@inheritDoc}
	 */
	public void changeOrgUnit(SessionId sessionId, ACOrgUnitId orgUnitId, String name, String description)
		throws EmfStoreException {
		getConnectionProxy(sessionId).call("changeOrgUnit", sessionId, orgUnitId, name, description);
	}

	/**
	 * {@inheritDoc}
	 */
	public void changeRole(SessionId sessionId, ProjectId projectId, ACOrgUnitId orgUnit, EClass role)
		throws EmfStoreException {
		getConnectionProxy(sessionId).call("changeRole", sessionId, projectId, orgUnit, role);
	}

	/**
	 * {@inheritDoc}
	 */
	public ACOrgUnitId createGroup(SessionId sessionId, String name) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithResult("createGroup", ACOrgUnitId.class, sessionId, name);
	}

	/**
	 * {@inheritDoc}
	 */
	public ACOrgUnitId createUser(SessionId sessionId, String name) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithResult("createUser", ACOrgUnitId.class, sessionId, name);
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteGroup(SessionId sessionId, ACOrgUnitId group) throws EmfStoreException {
		getConnectionProxy(sessionId).call("deleteGroup", sessionId, group);
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteUser(SessionId sessionId, ACOrgUnitId user) throws EmfStoreException {
		getConnectionProxy(sessionId).call("deleteUser", sessionId, user);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACGroup> getGroups(SessionId sessionId) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithListResult("getGroups", ACGroup.class, sessionId);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACGroup> getGroups(SessionId sessionId, ACOrgUnitId user) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithListResult("getGroups", ACGroup.class, sessionId, user);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACOrgUnit> getMembers(SessionId sessionId, ACOrgUnitId groupId) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithListResult("getMembers", ACOrgUnit.class, sessionId, groupId);
	}

	/**
	 * {@inheritDoc}
	 */
	public ACOrgUnit getOrgUnit(SessionId sessionId, ACOrgUnitId orgUnitId) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithResult("getOrgUnit", ACOrgUnit.class, sessionId, orgUnitId);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACOrgUnit> getOrgUnits(SessionId sessionId) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithListResult("getOrgUnits", ACOrgUnit.class, sessionId);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACOrgUnit> getParticipants(SessionId sessionId, ProjectId projectId) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithListResult("getParticipants", ACOrgUnit.class, sessionId,
			projectId);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ProjectInfo> getProjectInfos(SessionId sessionId) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithListResult("getProjectInfos", ProjectInfo.class, sessionId);
	}

	/**
	 * {@inheritDoc}
	 */
	public Role getRole(SessionId sessionId, ProjectId projectId, ACOrgUnitId orgUnit) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithResult("getRole", Role.class, sessionId, projectId, orgUnit);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACUser> getUsers(SessionId sessionId) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithListResult("getUsers", ACUser.class, sessionId);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeGroup(SessionId sessionId, ACOrgUnitId user, ACOrgUnitId group) throws EmfStoreException {
		getConnectionProxy(sessionId).call("removeGroup", sessionId, user, group);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeMember(SessionId sessionId, ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException {
		getConnectionProxy(sessionId).call("removeMember", sessionId, group, member);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeParticipant(SessionId sessionId, ProjectId projectId, ACOrgUnitId participant)
		throws EmfStoreException {
		getConnectionProxy(sessionId).call("removeParticipant", sessionId, projectId, participant);
	}

}

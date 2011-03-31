/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.emfstore.client.model.AdminBroker;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
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
 * Implementation of the AdminBroker.
 * 
 * @author Wesendonk
 */
/**
 * @author koegel
 */
/**
 * @author koegel
 */
public class AdminBrokerImpl implements AdminBroker {

	private SessionId sessionId;

	/**
	 * Constructor.
	 * 
	 * @param serverInfo server info
	 * @param sessionId session id, must be an admin session
	 * @throws ConnectionException if connection init fails
	 */
	public AdminBrokerImpl(ServerInfo serverInfo, SessionId sessionId) throws ConnectionException {
		this.sessionId = sessionId;
		WorkspaceManager.getInstance().getAdminConnectionManager().initConnection(serverInfo, sessionId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#addParticipant(org.eclipse.emf.emfstore.server.ProjectId,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId)
	 */
	public void addParticipant(ProjectId projectId, ACOrgUnitId participant) throws EmfStoreException {

		WorkspaceManager.getInstance().getAdminConnectionManager()
			.addParticipant(getSessionId(), projectId, participant);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#changeRole(org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.emfstore.client.model.accesscontrol.ACOrgUnitId, org.eclipse.emf.ecore.EClass)
	 */
	public void changeRole(ProjectId projectId, ACOrgUnitId orgUnit, EClass role) throws EmfStoreException {

		WorkspaceManager.getInstance().getAdminConnectionManager().changeRole(getSessionId(), projectId, orgUnit, role);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#getGroups()
	 */
	public List<ACGroup> getGroups() throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager().getGroups(getSessionId());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#getGroups(org.eclipse.emf.emfstore.client.model.accesscontrol.ACOrgUnitId)
	 */
	public List<ACGroup> getGroups(ACOrgUnitId user) throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager().getGroups(getSessionId(), user);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#getOrgUnits()
	 */
	public List<ACOrgUnit> getOrgUnits() throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager().getOrgUnits(getSessionId());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#getParticipants(org.eclipse.emf.emfstore.server.model.ProjectId)
	 */
	public List<ACOrgUnit> getParticipants(ProjectId projectId) throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager().getParticipants(getSessionId(), projectId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#getMembers(org.eclipse.emf.emfstore.client.model.accesscontrol.ACOrgUnitId)
	 */
	public List<ACOrgUnit> getMembers(ACOrgUnitId groupId) throws EmfStoreException {
		return WorkspaceManager.getInstance().getAdminConnectionManager().getMembers(getSessionId(), groupId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#getProjectInfos()
	 */
	public List<ProjectInfo> getProjectInfos() throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager().getProjectInfos(getSessionId());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#getRole(org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.emfstore.client.model.accesscontrol.ACOrgUnitId)
	 */
	public Role getRole(ProjectId projectId, ACOrgUnitId orgUnit) throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager().getRole(getSessionId(), projectId, orgUnit);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#getUsers()
	 */
	public List<ACUser> getUsers() throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager().getUsers(getSessionId());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#removeGroup(org.eclipse.emf.emfstore.client.model.accesscontrol.ACOrgUnitId,
	 *      org.eclipse.emf.emfstore.client.model.accesscontrol.ACOrgUnitId)
	 */
	public void removeGroup(ACOrgUnitId user, ACOrgUnitId group) throws EmfStoreException {

		WorkspaceManager.getInstance().getAdminConnectionManager().removeGroup(getSessionId(), user, group);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#removeParticipant(org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.emfstore.client.model.accesscontrol.ACOrgUnitId)
	 */
	public void removeParticipant(ProjectId projectId, ACOrgUnitId participant) throws EmfStoreException {

		WorkspaceManager.getInstance().getAdminConnectionManager()
			.removeParticipant(getSessionId(), projectId, participant);

	}

	private SessionId getSessionId() {
		return sessionId;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#createGroup(java.lang.String)
	 */
	public ACOrgUnitId createGroup(String name) throws EmfStoreException {
		return WorkspaceManager.getInstance().getAdminConnectionManager().createGroup(getSessionId(), name);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#createUser(java.lang.String)
	 */
	public ACOrgUnitId createUser(String name) throws EmfStoreException {
		return WorkspaceManager.getInstance().getAdminConnectionManager().createUser(getSessionId(), name);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#deleteGroup(org.eclipse.emf.emfstore.client.model.accesscontrol.ACOrgUnitId)
	 */
	public void deleteGroup(ACOrgUnitId group) throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager().deleteGroup(getSessionId(), group);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#deleteUser(org.eclipse.emf.emfstore.client.model.accesscontrol.ACOrgUnitId)
	 */
	public void deleteUser(ACOrgUnitId user) throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager().deleteUser(getSessionId(), user);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#addMember(org.eclipse.emf.emfstore.client.model.accesscontrol.ACOrgUnitId,
	 *      org.eclipse.emf.emfstore.client.model.accesscontrol.ACOrgUnitId)
	 */
	public void addMember(ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager().addMember(getSessionId(), group, member);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#removeMember(org.eclipse.emf.emfstore.client.model.accesscontrol.ACOrgUnitId,
	 *      org.eclipse.emf.emfstore.client.model.accesscontrol.ACOrgUnitId)
	 */
	public void removeMember(ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager().removeMember(getSessionId(), group, member);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#changeOrgUnit(org.eclipse.emf.emfstore.client.model.accesscontrol.ACOrgUnitId,
	 *      java.lang.String, java.lang.String)
	 */
	public void changeOrgUnit(ACOrgUnitId orgUnitId, String name, String description) throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager()
			.changeOrgUnit(getSessionId(), orgUnitId, name, description);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#getOrgUnit(org.eclipse.emf.emfstore.client.model.accesscontrol.ACOrgUnitId)
	 */
	public ACOrgUnit getOrgUnit(ACOrgUnitId orgUnitId) throws EmfStoreException {
		return WorkspaceManager.getInstance().getAdminConnectionManager().getOrgUnit(sessionId, orgUnitId);
	}

}

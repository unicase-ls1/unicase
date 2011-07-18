/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
import org.unicase.workspace.AdminBroker;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.WorkspaceManager;

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
	 * @see org.unicase.workspace.AdminBroker#addParticipant(org.unicase.emfstore.esmodel.ProjectId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 */
	public void addParticipant(ProjectId projectId, ACOrgUnitId participant) throws EmfStoreException {

		WorkspaceManager.getInstance().getAdminConnectionManager()
			.addParticipant(getSessionId(), projectId, participant);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#changeRole(org.unicase.emfstore.esmodel.ProjectId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId, org.eclipse.emf.ecore.EClass)
	 */
	public void changeRole(ProjectId projectId, ACOrgUnitId orgUnit, EClass role) throws EmfStoreException {

		WorkspaceManager.getInstance().getAdminConnectionManager().changeRole(getSessionId(), projectId, orgUnit, role);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#getGroups()
	 */
	public List<ACGroup> getGroups() throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager().getGroups(getSessionId());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#getGroups(org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 */
	public List<ACGroup> getGroups(ACOrgUnitId user) throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager().getGroups(getSessionId(), user);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#getOrgUnits()
	 */
	public List<ACOrgUnit> getOrgUnits() throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager().getOrgUnits(getSessionId());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#getParticipants(org.unicase.emfstore.esmodel.ProjectId)
	 */
	public List<ACOrgUnit> getParticipants(ProjectId projectId) throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager().getParticipants(getSessionId(), projectId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#getMembers(org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 */
	public List<ACOrgUnit> getMembers(ACOrgUnitId groupId) throws EmfStoreException {
		return WorkspaceManager.getInstance().getAdminConnectionManager().getMembers(getSessionId(), groupId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#getProjectInfos()
	 */
	public List<ProjectInfo> getProjectInfos() throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager().getProjectInfos(getSessionId());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#getRole(org.unicase.emfstore.esmodel.ProjectId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 */
	public Role getRole(ProjectId projectId, ACOrgUnitId orgUnit) throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager().getRole(getSessionId(), projectId, orgUnit);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#getUsers()
	 */
	public List<ACUser> getUsers() throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager().getUsers(getSessionId());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#removeGroup(org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 */
	public void removeGroup(ACOrgUnitId user, ACOrgUnitId group) throws EmfStoreException {

		WorkspaceManager.getInstance().getAdminConnectionManager().removeGroup(getSessionId(), user, group);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#removeParticipant(org.unicase.emfstore.esmodel.ProjectId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
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
	 * @see org.unicase.workspace.AdminBroker#createGroup(java.lang.String)
	 */
	public ACOrgUnitId createGroup(String name) throws EmfStoreException {
		return WorkspaceManager.getInstance().getAdminConnectionManager().createGroup(getSessionId(), name);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#createUser(java.lang.String)
	 */
	public ACOrgUnitId createUser(String name) throws EmfStoreException {
		return WorkspaceManager.getInstance().getAdminConnectionManager().createUser(getSessionId(), name);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#deleteGroup(org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 */
	public void deleteGroup(ACOrgUnitId group) throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager().deleteGroup(getSessionId(), group);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#deleteUser(org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 */
	public void deleteUser(ACOrgUnitId user) throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager().deleteUser(getSessionId(), user);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#addMember(org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 */
	public void addMember(ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager().addMember(getSessionId(), group, member);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#removeMember(org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 */
	public void removeMember(ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager().removeMember(getSessionId(), group, member);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#changeOrgUnit(org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId,
	 *      java.lang.String, java.lang.String)
	 */
	public void changeOrgUnit(ACOrgUnitId orgUnitId, String name, String description) throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager()
			.changeOrgUnit(getSessionId(), orgUnitId, name, description);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.AdminBroker#getOrgUnit(org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 */
	public ACOrgUnit getOrgUnit(ACOrgUnitId orgUnitId) throws EmfStoreException {
		return WorkspaceManager.getInstance().getAdminConnectionManager().getOrgUnit(sessionId, orgUnitId);
	}

}

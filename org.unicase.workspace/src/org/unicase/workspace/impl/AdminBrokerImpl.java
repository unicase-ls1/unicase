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
 * 
 * @author Wesendonk
 */
public class AdminBrokerImpl implements AdminBroker {

	private SessionId sessionId;

	public AdminBrokerImpl(ServerInfo serverInfo, SessionId sessionId)
			throws ConnectionException {
		this.sessionId = sessionId;
		WorkspaceManager.getInstance().getAdminConnectionManager()
				.initConnection(serverInfo, sessionId);
	}

	public void addParticipant(ProjectId projectId, ACOrgUnitId participant)
			throws EmfStoreException {

		WorkspaceManager.getInstance().getAdminConnectionManager()
				.addParticipant(getSessionId(), projectId, participant);

	}

	public void changeRole(ProjectId projectId, ACOrgUnitId orgUnit, EClass role)
			throws EmfStoreException {

		WorkspaceManager.getInstance().getAdminConnectionManager().changeRole(
				getSessionId(), projectId, orgUnit, role);

	}

	public List<ACGroup> getGroups() throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager()
				.getGroups(getSessionId());
	}

	public List<ACGroup> getGroups(ACOrgUnitId user) throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager()
				.getGroups(getSessionId(), user);
	}

	public List<ACOrgUnit> getOrgUnits() throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager()
				.getOrgUnits(getSessionId());
	}

	public List<ACOrgUnit> getParticipants(ProjectId projectId)
			throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager()
				.getParticipants(getSessionId(), projectId);
	}

	public List<ProjectInfo> getProjectInfos() throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager()
				.getProjectInfos(getSessionId());
	}

	public Role getRole(ProjectId projectId, ACOrgUnitId orgUnit)
			throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager()
				.getRole(getSessionId(), projectId, orgUnit);
	}

	public List<ACUser> getUsers() throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager()
				.getUsers(getSessionId());
	}

	public void removeGroup(ACOrgUnitId user, ACOrgUnitId group)
			throws EmfStoreException {

		WorkspaceManager.getInstance().getAdminConnectionManager().removeGroup(
				getSessionId(), user, group);

	}

	public void removeParticipant(ProjectId projectId, ACOrgUnitId participant)
			throws EmfStoreException {

		WorkspaceManager.getInstance().getAdminConnectionManager()
				.removeParticipant(getSessionId(), projectId, participant);

	}

	private SessionId getSessionId() {
		return sessionId;
	}

	public void createGroup(String name) throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager().createGroup(
				getSessionId(), name);

	}

	public void createUser(String name) throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager().createUser(
				getSessionId(), name);

	}

	public void deleteGroup(ACOrgUnitId group) throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager().deleteGroup(
				getSessionId(), group);

	}

	public void deleteUser(ACOrgUnitId user) throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager().deleteUser(
				getSessionId(), user);

	}

	public void addMember(ACOrgUnitId group, ACOrgUnitId member)
			throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager().addMember(
				getSessionId(), group, member);

	}

	public void removeMember(ACOrgUnitId group, ACOrgUnitId member)
			throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager()
				.removeMember(getSessionId(), group, member);
	}

	public void changeOrgUnit(ACOrgUnitId orgUnitId, String name,
			String description) throws EmfStoreException {
		WorkspaceManager.getInstance().getAdminConnectionManager()
				.changeOrgUnit(getSessionId(), orgUnitId, name, description);
	}
}

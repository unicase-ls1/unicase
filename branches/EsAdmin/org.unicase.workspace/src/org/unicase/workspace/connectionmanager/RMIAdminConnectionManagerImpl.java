package org.unicase.workspace.connectionmanager;

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
import org.unicase.emfstore.exceptions.EmfStoreException;

public class RMIAdminConnectionManagerImpl implements AdminConnectionManager {

	public void addGroup(SessionId sessionId, ACUser user, ACOrgUnitId group)
			throws EmfStoreException {
		// TODO Auto-generated method stub

	}

	public void addParticipant(SessionId sessionId, ProjectId projectId,
			ACOrgUnitId participant) throws EmfStoreException {
		// TODO Auto-generated method stub

	}

	public void changeRole(SessionId sessionId, ProjectId projectId,
			ACOrgUnitId orgUnit, EClass role) throws EmfStoreException {
		// TODO Auto-generated method stub

	}

	public List<ACGroup> getGroups(SessionId sessionId)
			throws EmfStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ACGroup> getGroups(SessionId sessionId, ACOrgUnitId user)
			throws EmfStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ACOrgUnit> getOrgUnits(SessionId sessionId)
			throws EmfStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ACOrgUnit> getParticipants(SessionId sessionId,
			ProjectId projectId) throws EmfStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProjectInfo> getProjectInfos(SessionId sessionId)
			throws EmfStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	public Role getRole(SessionId sessionId, ProjectId projectId,
			ACOrgUnitId orgUnit) throws EmfStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ACUser> getUsers(SessionId sessionId) throws EmfStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeGroup(SessionId sessionId, ACOrgUnitId user,
			ACOrgUnitId group) throws EmfStoreException {
		// TODO Auto-generated method stub

	}

	public void removeParticipant(SessionId sessionId, ProjectId projectId,
			ACOrgUnitId participant) throws EmfStoreException {
		// TODO Auto-generated method stub

	}

}

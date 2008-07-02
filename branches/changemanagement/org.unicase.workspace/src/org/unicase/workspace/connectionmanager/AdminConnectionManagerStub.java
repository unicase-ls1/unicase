package org.unicase.workspace.connectionmanager;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;

public class AdminConnectionManagerStub implements AdminConnectionManager {

	public EList<ACGroup> getGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	public EList<ACGroup> getGroups(ACUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	public EList<ACOrgUnit> getOrgUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	public EList<ACOrgUnit> getParticipants(ProjectInfo project) {
		// TODO Auto-generated method stub
		return null;
	}

	public EList<ProjectInfo> getProjectInfos() {
		// TODO Auto-generated method stub
		return null;
	}

	public EList<ACUser> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}

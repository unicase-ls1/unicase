package org.unicase.emfstore;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;

public interface AdminEmfStore {

	EList<ProjectInfo> getProjectInfos();
	EList<ACGroup> getGroups();
	EList<ACUser> getUsers();
	EList<ACOrgUnit> getOrgUnits();
	
	EList<ACGroup> getGroups(ACUser user);
	
	EList<ACOrgUnit> getParticipants(ProjectInfo project);
	
	void addParticipant(ProjectInfo project, ACOrgUnit participant);
	void removeParticipant(ProjectInfo project, ACOrgUnit participant);
	
}

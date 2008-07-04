package org.unicase.emfstore;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;

public interface AdminEmfStore {

	EList<ProjectInfo> getProjectInfos();
	EList<ACGroup> getGroups();
	EList<ACUser> getUsers();
	EList<ACOrgUnit> getOrgUnits();
	
	EList<ACGroup> getGroups(ACUser user);
	void addGroup(ACUser user, ACGroup group);
	void removeGroup(ACUser user, ACGroup group);
	
	EList<ACOrgUnit> getParticipants(ProjectInfo project);
	
	void addParticipant(ProjectInfo project, ACOrgUnit participant);
	void removeParticipant(ProjectInfo project, ACOrgUnit participant);
	
	Role getRole(ProjectInfo project, ACOrgUnit orgUnit);
	void changeRole(ProjectInfo projectInfo, ACOrgUnit orgUnit,	EClass role);


}

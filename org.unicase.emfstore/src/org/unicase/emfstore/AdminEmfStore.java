package org.unicase.emfstore;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;

public interface AdminEmfStore {

	public EList<ProjectInfo> getProjectInfos();
	public EList<ACGroup> getGroups();
	public EList<ACUser> getUsers();
	public EList<ACOrgUnit> getOrgUnits();
	
	public EList<ACGroup> getGroups(ACUser user);
	
	public EList<ACOrgUnit> getParticipants(ProjectInfo project);
	
	public void addParticipant(ProjectInfo project, ACOrgUnit participant);
	public void removeParticipant(ProjectInfo project, ACOrgUnit participant);
	
}

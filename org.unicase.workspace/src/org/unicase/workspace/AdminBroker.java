package org.unicase.workspace;

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

/**
 * @author Hodaie
 * @author Wesendonk
 */
public interface AdminBroker {
	
	List<ProjectInfo> getProjectInfos() throws EmfStoreException;
	List<ACGroup> getGroups() throws EmfStoreException;
	List<ACUser> getUsers() throws EmfStoreException;
	List<ACOrgUnit> getOrgUnits() throws EmfStoreException;
	
	void createGroup(String name) throws EmfStoreException;
	void deleteGroup(ACOrgUnitId group) throws EmfStoreException;
	List<ACGroup> getGroups(ACOrgUnitId user) throws EmfStoreException;
	void removeGroup(ACOrgUnitId user, ACOrgUnitId group) throws EmfStoreException;
	
	void createUser(String name) throws EmfStoreException;
	void deleteUser(ACOrgUnitId user) throws EmfStoreException;
	
	List<ACOrgUnit> getMembers(ACOrgUnitId groupId) throws EmfStoreException;
	ACOrgUnit getOrgUnit(ACOrgUnitId orgUnitId) throws EmfStoreException;
	void addMember(ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException;
	void removeMember(ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException;
	
	void changeOrgUnit(ACOrgUnitId orgUnitId, String name, String description) throws EmfStoreException;
	
	List<ACOrgUnit> getParticipants(ProjectId projectId) throws EmfStoreException;
	
	void addParticipant(ProjectId projectId, ACOrgUnitId participant) throws EmfStoreException;
	void removeParticipant(ProjectId projectId, ACOrgUnitId participant) throws EmfStoreException;
	
	Role getRole(ProjectId projectId, ACOrgUnitId orgUnit) throws EmfStoreException;
	void changeRole(ProjectId projectId, ACOrgUnitId orgUnit, EClass role) throws EmfStoreException;

}

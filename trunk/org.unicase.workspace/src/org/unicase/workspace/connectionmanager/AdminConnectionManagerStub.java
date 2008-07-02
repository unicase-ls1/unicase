package org.unicase.workspace.connectionmanager;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolFactory;
import org.unicase.emfstore.esmodel.accesscontrol.roles.ReaderRole;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesFactory;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

public class AdminConnectionManagerStub implements AdminConnectionManager {

	private EList<ProjectInfo> projectInfos;
	private static EList<ACGroup> groups = new BasicEList<ACGroup>();;
	private static EList<ACUser> users = new BasicEList<ACUser>();;
	private EList<ACOrgUnit> orgUnits = new BasicEList<ACOrgUnit>();;
	
	public AdminConnectionManagerStub(){
		createDummyProject();
	}
	
	public EList<ProjectInfo> getProjectInfos() {
		EList<ProjectInfo> result = new BasicEList<ProjectInfo>();
		Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		for(ProjectSpace projectSpace : workspace.getProjectSpaces()){
			
			result.add(projectSpace.getProjectInfo());
		}
		
		this.projectInfos = result;
		return result;
			
	}

	public EList<ACGroup> getGroups() {
		
		return groups;
	}

	public EList<ACOrgUnit> getOrgUnits() {
		EList<ACOrgUnit> result = new BasicEList<ACOrgUnit>();
		result.addAll(groups);
		result.addAll(users);
		return result;
	}

	public EList<ACUser> getUsers() {
	
		return users;
	}

	public EList<ACGroup> getGroups(ACUser user) {
		EList<ACGroup> result = new BasicEList<ACGroup>();
		for(ACGroup group : groups){
			if (group.getMembers().contains(user)){
				result.add(group);
			}
		}
		
		return result;
	}

	public EList<ACOrgUnit> getParticipants(ProjectInfo project) {
		EList<ACOrgUnit> participants = new BasicEList<ACOrgUnit>();
		for(ACOrgUnit orgUnit : getOrgUnits()){
			for(Role role : orgUnit.getRoles()){
				if (role.getProjects().contains(project)){
					participants.add(orgUnit);
				}
			}
		}
		
		return participants;
	}

	public void addParticipant(ProjectInfo project, ACOrgUnit participant) {
		ReaderRole readerRole = RolesFactory.eINSTANCE.createReaderRole();
	    if(participant.getRoles() == null){
	    	
	    }
		if(participant.getRoles().contains(readerRole)){
			participant.getRoles().get(participant.getRoles().indexOf(readerRole)).getProjects().add(project.getProjectId());
			
		}else {
			readerRole.getProjects().add(project.getProjectId());
			participant.getRoles().add(readerRole);
		}
		
	}

	public void removeParticipant(ProjectInfo project, ACOrgUnit participant) {
		for(Role role : participant.getRoles()){
			if (role.getProjects().contains(project)){
				role.getProjects().remove(project);
			}
		}
		
	}
	
	private static void createDummyProject(){
		
		for (int i = 0; i < 4; i++){
			ACGroup group = AccesscontrolFactory.eINSTANCE.createACGroup();
			group.setName("Group " + i);
			group.setDescription("This is group " + i);
			groups.add(group);
		}
				
		for (int i = 0; i < 4; i++){
			ACUser user = AccesscontrolFactory.eINSTANCE.createACUser();
			user.setName("User " + i);
			user.setDescription("This is user " + i);
			users.add(user);
		}
		
	}
		
			
	
}

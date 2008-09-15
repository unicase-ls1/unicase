
/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.connectionmanager;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolFactory;
import org.unicase.emfstore.esmodel.accesscontrol.roles.ReaderRole;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesFactory;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

public class AdminConnectionManagerStub {

	private static EList<ProjectInfo> projectInfos = new BasicEList<ProjectInfo>();
	private static EList<ACGroup> groups = new BasicEList<ACGroup>();
	private static EList<ACUser> users = new BasicEList<ACUser>();
	private static EList<ACOrgUnit> orgUnits = new BasicEList<ACOrgUnit>();
	
	
	public AdminConnectionManagerStub(){
	
	}
	
	public EList<ProjectInfo> getProjectInfos() {
		return projectInfos;
			
	}

	public EList<ACGroup> getGroups() {
		
		return groups;
	}

	public EList<ACOrgUnit> getOrgUnits() {
		return orgUnits;
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
		ProjectId projectId = project.getProjectId();
		EList<ACOrgUnit> participants = new BasicEList<ACOrgUnit>();
		for(ACOrgUnit orgUnit : getOrgUnits()){
			for(Role role : orgUnit.getRoles()){
				for (ProjectId pId : role.getProjects()){
					if(pId.equals(projectId)){
						participants.add(orgUnit);
					}
				}
			}
		}
		
		return participants;
	}

	public void addParticipant(ProjectInfo project, ACOrgUnit participant) {
		ProjectId projectId = project.getProjectId();
		
		if(hasRole(participant, RolesPackage.eINSTANCE.getReaderRole())){
			getRole(participant, RolesPackage.eINSTANCE.getReaderRole()).getProjects().add(projectId);
			
		}else {
			ReaderRole readerRole = RolesFactory.eINSTANCE.createReaderRole();
			readerRole.getProjects().add(projectId);
			participant.getRoles().add(readerRole);
		}
		
	}

	private Role getRole(ACOrgUnit participant, EClass roleEClass) {
		Role result = null;
		for(Role role : participant.getRoles()){
			if (role.eClass().equals(roleEClass)){
				result = role;
				break;
			}
		}
		
		return result;
	}

	private boolean hasRole(ACOrgUnit orgUnit, EClass roleEClass) {
		
		for(Role role : orgUnit.getRoles()){
			if(role.eClass().equals(roleEClass)){
				return true;
			}
		}
		return false;
		
	}

	public void removeParticipant(ProjectInfo project, ACOrgUnit participant) {
		ProjectId projectId = project.getProjectId();
		for(Role role : participant.getRoles()){
			if (role.getProjects().contains(projectId)){
				role.getProjects().remove(projectId);
			}
		}
		
	}
	
	public static void createDummyProject(){
		
		if (projectInfos.size() == 0 ){
			Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
			for(ProjectSpace projectSpace : workspace.getProjectSpaces()){
				projectInfos.add(projectSpace.getProjectInfo());
			}
		}
		
		if(groups.size() == 0){
			for (int i = 0; i < 4; i++){
				ACGroup group = AccesscontrolFactory.eINSTANCE.createACGroup();
				group.setName("Group " + i);
				group.setDescription("This is group " + i);
				groups.add(group);
			}
			orgUnits.addAll(groups);
		}
		
		
		if(users.size() == 0){
			for (int i = 0; i < 4; i++){
				ACUser user = AccesscontrolFactory.eINSTANCE.createACUser();
				user.setName("User " + i);
				user.setDescription("This is user " + i);
				users.add(user);
			}
			
			orgUnits.addAll(users);
		}
			
	}

	
	public Role getRole(ProjectInfo project, ACOrgUnit orgUnit) {
		Role result = null;
		ProjectId projectId = project.getProjectId();
		for(Role role : orgUnit.getRoles()){
			if(role.getProjects().contains(projectId)){
				result = role;
				break;
			}
		}
		return result;
	}

	
	
	public void changeRole(ProjectInfo projectInfo, ACOrgUnit orgUnit, EClass roleEClass) {
		//first remove the project from previous role
		Role oldRole = getRole(projectInfo, orgUnit);
		int index = oldRole.getProjects().indexOf(projectInfo.getProjectId());
		oldRole.getProjects().remove(index);
		
		//if orgUnit already has the required role, then just add project to this existing role
		if(hasRole(orgUnit, roleEClass)){
			Role newRole = getRole(orgUnit, roleEClass);
			newRole.getProjects().add(projectInfo.getProjectId());
			
		}else {
			//create the required role and add the project to it
			Role newRole = (Role)RolesPackage.eINSTANCE.getEFactoryInstance().create(roleEClass);
			newRole.getProjects().add(projectInfo.getProjectId());
			orgUnit.getRoles().add(newRole);
		}
			
	}

	public void addGroup(ACUser user, ACGroup group) {
		group.getMembers().add(user);
	}

	public void removeGroup(ACUser user, ACGroup group) {
		int index = group.getMembers().indexOf(user);
		if (index != -1){
			group.getMembers().remove(index);
		}
	}
		
			
	
}

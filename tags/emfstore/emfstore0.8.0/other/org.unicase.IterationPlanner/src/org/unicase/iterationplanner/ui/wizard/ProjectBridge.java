package org.unicase.iterationplanner.ui.wizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.unicase.metamodel.Project;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

public class ProjectBridge {
	
	private Project project;
	

	public ProjectBridge(Project project){
		this.project = project;
	}

	
	
	public Project getProject() {
		return project;
	}
	
	public List<FunctionalRequirement> getTopLevelRequirements(){
		List<FunctionalRequirement> result = new ArrayList<FunctionalRequirement>();
		List<FunctionalRequirement> allFRs = project.getAllModelElementsbyClass(RequirementPackage.eINSTANCE.getFunctionalRequirement(),
			new BasicEList<FunctionalRequirement>());
		
		for(FunctionalRequirement fr : allFRs){
			if(fr.getRefinedRequirement() == null){
				result.add(fr);
			}
		}
		
		return result;
		
	}
	
	public List<FunctionalRequirement> getAllRequirements(){
		return null;
		
	}
	
	public List<WorkItem> getAllWorkItems(){
		List<WorkItem> allWorkItems = project.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(),
			new BasicEList<WorkItem>());
		return allWorkItems;
	}
	
	public List<WorkPackage> getAllWorkPackages(){
		List<WorkPackage> allWorkPackages = project.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkPackage(),
			new BasicEList<WorkPackage>());
		return allWorkPackages;
	}
	
	public List<WorkPackage> getTopLevelWorkPackages(){
		ArrayList<WorkPackage> result = new ArrayList<WorkPackage>();
		List<WorkPackage> allWorkPackages = getAllWorkPackages();
		for(WorkPackage wp : allWorkPackages){
			if(wp.getContainingWorkpackage() == null){
				result.add(wp);
			}
		}
		return result;
	}
	
	
	public List<Group> getTopLevelGroups(){
		List<Group> result = new ArrayList<Group>();
		List<Group> allGroups = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getGroup(),
			new BasicEList<Group>());
		for(Group group : allGroups){
			if(group.getGroupMemberships().size() == 0){
				result.add(group);
			}
		}
		return result;
	}
	
	public List<User> getAllUsers(){
		List<User> allUsers = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
			new BasicEList<User>());
		return allUsers;
	}
	

}

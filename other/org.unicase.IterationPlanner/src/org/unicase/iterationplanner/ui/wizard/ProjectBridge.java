package org.unicase.iterationplanner.ui.wizard;

import java.util.List;

import org.unicase.metamodel.Project;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

public class ProjectBridge {
	
	private static ProjectBridge instance;
	private Project project;
	

	/**
	 * returns an instance of project bridge for the given unicase project. 
	 * @param project
	 * @return
	 */
	public static ProjectBridge getInstance(Project project){
		if(instance == null){
			instance = new ProjectBridge(project);
		}
		return instance;
	}
	
	private ProjectBridge(Project project){
		this.project = project;
	}

	
	
	public Project getProject() {
		return project;
	}
	
	public List<FunctionalRequirement> getTopLevelRequirements(){
		return null;
		
	}
	
	public List<FunctionalRequirement> getAllRequirements(){
		return null;
		
	}
	
	public List<WorkItem> getAllWorkItems(){
		return null;
	}
	
	public List<WorkPackage> getAllWorkPackages(){
		return null;
	}
	
	public List<OrgUnit> getAllOrgUnits(){
		return null;
	}
	
	public List<Group> getAllGroups(){
		return null;
	}
	
	public List<User> getAllUsers(){
		return null;
	}
	

}

package org.unicase.iterationplanner.ui.wizard;

import java.util.ArrayList;
import java.util.List;

import org.unicase.iterationplanner.ui.wizard.input.UserAvailability;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkItem;

public class PlannerBridge {
	
	private int numOfIteations;
	private List<FunctionalRequirement> requirements;
	private List<WorkItem> workItems;
	private List<UserAvailability> userAvailabilities; 
	
	public PlannerBridge(){
		
	}


	public int getNumOfIteations() {
		return numOfIteations == 0 ? 1 : numOfIteations;
	}

	public void setNumOfIteations(int numOfIteations) {
		this.numOfIteations = numOfIteations;
	}


	public void setRequirements(List<FunctionalRequirement> reqs) {
		this.requirements = new ArrayList<FunctionalRequirement>();
		//reqs is a faltenned list of requirements
		for(FunctionalRequirement req : reqs){
			if(req.getRefinedRequirement() == null){
				requirements.add(req);
			}
		}
	}


	public void setWorkItems(List<WorkItem> workItemsToPlan) {
		this.workItems = workItemsToPlan;
	}


	public void setAssignees(List<UserAvailability> userAvailabilities) {
		this.userAvailabilities = userAvailabilities;
	}


	public void startPlanner() {
		new Object().toString();
	}

	
	
}

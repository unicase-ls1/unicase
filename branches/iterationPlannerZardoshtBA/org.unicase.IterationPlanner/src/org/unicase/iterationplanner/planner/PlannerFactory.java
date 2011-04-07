package org.unicase.iterationplanner.planner;

import java.util.List;

import org.unicase.iterationplanner.assigneeRecommender.TaskPotentialAssigneeList;
import org.unicase.iterationplanner.entities.AssigneeAvailabilityManager;
import org.unicase.iterationplanner.entities.PlannerParameters;
import org.unicase.iterationplanner.planner.impl.MyPlanner;

public class PlannerFactory {
	
	private static PlannerFactory instance;
	
	private PlannerFactory(){
		
	}

	
	public static PlannerFactory getInstance(){
		if(instance == null){
			instance = new PlannerFactory();
		}
		return instance;
	}
	
	public Planner getDefaultPlanner(int numOfIterations, List<TaskPotentialAssigneeList> taskPotentialAssigneeLists,
		AssigneeAvailabilityManager assigneeAvailabilityManager, PlannerParameters plannerParameters){
		
		return new MyPlanner(numOfIterations, taskPotentialAssigneeLists, assigneeAvailabilityManager, plannerParameters);
		
	}
}

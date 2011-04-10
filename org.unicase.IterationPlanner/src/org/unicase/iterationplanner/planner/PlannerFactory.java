package org.unicase.iterationplanner.planner;

import java.util.List;

import org.unicase.iterationplanner.assigneeRecommender.TaskPotentialAssigneeList;
import org.unicase.iterationplanner.planner.impl.shiftdownplanner.ShiftDownEvaluator;
import org.unicase.iterationplanner.planner.impl.shiftdownplanner.ShiftDownPlanner;
import org.unicase.iterationplanner.planner.selectionstrategies.RankBasedSelectionStrategy;

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
	
	public AbstractPlanner getShiftDownPlanner(int numOfIterations, List<TaskPotentialAssigneeList> taskPotentialAssigneeLists,
		AssigneeAvailabilityManager assigneeAvailabilityManager, PlannerParameters plannerParameters){
		
		ISelectionStrategy rankBasedSelectionStrategy = new RankBasedSelectionStrategy(plannerParameters.getRandom());
		ShiftDownEvaluator evaluator = new ShiftDownEvaluator(plannerParameters, assigneeAvailabilityManager);
		return new ShiftDownPlanner(numOfIterations, taskPotentialAssigneeLists, assigneeAvailabilityManager, evaluator, rankBasedSelectionStrategy, plannerParameters);
		
	}
}

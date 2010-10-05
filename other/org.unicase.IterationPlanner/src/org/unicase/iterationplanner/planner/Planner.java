package org.unicase.iterationplanner.planner;

import java.util.List;

import org.unicase.iterationplanner.assigneerecommendation.TaskPotentialAssigneeList;

public class Planner {

	private final int numOfIterations;
	private final List<TaskPotentialAssigneeList> taskAssignees;

	public Planner(int numOfIterations, List<TaskPotentialAssigneeList> taskAssignees) {
		this.numOfIterations = numOfIterations;
		this.taskAssignees = taskAssignees;
	}

	public int getNumOfIterations() {
		return numOfIterations;
	}

	public List<TaskPotentialAssigneeList> getTaskAssignees() {
		return taskAssignees;
	}

}

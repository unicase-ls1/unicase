package org.unicase.iterationplanner.ui.wizard.output;

import java.util.Set;

import org.unicase.iterationplanner.planner.PlannedTask;

public class Iteration {

	private int iterationNumber;
	public int getIterationNumber() {
		return iterationNumber;
	}

	private Set<PlannedTask> plannedTasks;

	public Iteration(int iterationNumber, Set<PlannedTask> allPlannedTasksForIteration) {
		this.plannedTasks = allPlannedTasksForIteration;
		this.iterationNumber = iterationNumber;
	
	}

	public Set<PlannedTask> getPlannedTasks() {
		return plannedTasks;
	}

}

package org.unicase.iterationplanner.ui.wizard.output;

import java.util.Set;

import org.unicase.iterationplanner.entities.IPlannedTask;

public class Iteration {

	private int iterationNumber;
	public int getIterationNumber() {
		return iterationNumber;
	}

	private Set<IPlannedTask> plannedTasks;

	public Iteration(int iterationNumber, Set<IPlannedTask> allPlannedTasksForIteration) {
		this.plannedTasks = allPlannedTasksForIteration;
		this.iterationNumber = iterationNumber;
	
	}

	public Set<IPlannedTask> getPlannedTasks() {
		return plannedTasks;
	}

}

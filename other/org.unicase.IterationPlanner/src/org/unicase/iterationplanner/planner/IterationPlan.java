package org.unicase.iterationplanner.planner;

import java.util.ArrayList;
import java.util.List;

import org.unicase.iterationplanner.assigneerecommendation.TaskPotentialAssigneeList;

/**
 * This represents single individuals in population. Hence, this is the representation of our genome. Our genome is a
 * set of Iterations. An Iteration is itself as set of PlannedTasks, i.e. IterationPlan = {(task, assignee, iteration)}.
 * The cardinality of this set is number of tasks that are to be planned.
 * 
 * @author zardosht
 */
public class IterationPlan implements Comparable<IterationPlan> {

	private final Iteration[] iterations;
	private final int numOfIterations;
	private double score;
	private final List<TaskPotentialAssigneeList> tasksToPlan;
	private List<PlannedTask> plannedTasks;

	@Override
	public IterationPlan clone() {
		IterationPlan clone = new IterationPlan(this.numOfIterations, this.tasksToPlan);
		for (int i = 0; i < this.iterations.length; i++) {
			Iteration iteration = this.iterations[i];
			clone.iterations[i] = iteration.clone();
		}

		return clone;
	}

	public IterationPlan(int numOfIterations, List<TaskPotentialAssigneeList> taskToPlan) {
		this.numOfIterations = numOfIterations;
		iterations = new Iteration[numOfIterations];
		this.tasksToPlan = taskToPlan;
	}

	public Iteration[] getIterations() {
		return iterations;
	}

	public int getNumOfIterations() {
		return numOfIterations;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public List<TaskPotentialAssigneeList> getTasksToPlan() {
		return this.tasksToPlan;
	}

	public int compareTo(IterationPlan otherPlan) {
		if (otherPlan.getScore() > this.score) {
			return 1;
		}
		return -1;
	}

	public List<PlannedTask> getPlannedTasks() {
		if (plannedTasks == null) {
			plannedTasks = new ArrayList<PlannedTask>();
		}
		return plannedTasks;
	}

}

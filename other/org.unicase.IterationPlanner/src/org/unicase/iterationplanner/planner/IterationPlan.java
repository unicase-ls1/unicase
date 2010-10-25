package org.unicase.iterationplanner.planner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.unicase.iterationplanner.assigneerecommendation.Assignee;

/**
 * This represents single individuals in population. Hence, this is the representation of our genome. Our genome is a
 * set of Iterations. An Iteration is itself as set of PlannedTasks, i.e. IterationPlan = {(task, assignee, iteration)}.
 * The cardinality of this set is number of tasks that are to be planned.
 * 
 * @author zardosht
 */
public class IterationPlan implements Comparable<IterationPlan> {

	// private final Iteration[] iterations;
	private final int numOfIterations;
	private double score;
	private Set<PlannedTask> plannedTasks;

	@Override
	public IterationPlan clone() {
		IterationPlan clone = new IterationPlan(this.numOfIterations);
		clone.plannedTasks = this.plannedTasks; // is it really possible? plannedTasks is private!
		return clone;
	}

	public IterationPlan(int numOfIterations) {
		this.numOfIterations = numOfIterations;
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

	public int compareTo(IterationPlan otherPlan) {
		if (otherPlan.getScore() > this.score) {
			return 1;
		}
		return -1;
	}

	public Set<PlannedTask> getPlannedTasks() {
		if (plannedTasks == null) {
			plannedTasks = new HashSet<PlannedTask>();
		}
		return plannedTasks;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IterationPlan)) {
			return false;
		}
		IterationPlan incomming = (IterationPlan) obj;
		return this.plannedTasks.equals(incomming.plannedTasks);
	}

	public void setIterationNumberFor(PlannedTask plannedTask, int newIterationNumber) {
		plannedTask.setIterationNumber(newIterationNumber);
	}

	public Set<PlannedTask> getAllPlannedTasksForIteration(int iterationNumber) {
		Set<PlannedTask> result = new HashSet<PlannedTask>();
		for (PlannedTask pt : getPlannedTasks()) {
			if (pt.getIterationNumber() == iterationNumber) {
				result.add(pt);
			}
		}

		return result;
	}

	public int getBacklogNumber() {
		// if numOfIteration == 3, then we have Iter0, Iter1, Iter2, hence Backlog will be Iter3
		return numOfIterations;
	}

	public List<PlannedTask> getAllPlannedTasksForIterationAndAssignee(int iterationNumber, Assignee assignee) {
		Set<PlannedTask> ptsForIteration = getAllPlannedTasksForIteration(iterationNumber);
		List<PlannedTask> ptsForIterAndAssignee = new ArrayList<PlannedTask>();
		for (PlannedTask pt : ptsForIteration) {
			if (pt.getAssigneeExpertise().getAssignee().equals(assignee)) {
				ptsForIterAndAssignee.add(pt);
			}
		}
		return ptsForIterAndAssignee;
	}
}

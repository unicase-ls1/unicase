package org.unicase.iterationplanner.planner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.unicase.iterationplanner.assigneerecommendation.Assignee;
import org.unicase.iterationplanner.assigneerecommendation.AssigneeExpertise;

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
	private final AssigneeAvailabilityManager assigneeAvailabilityManager;
	private double score;
	private Set<PlannedTask> plannedTasks;

	@Override
	public IterationPlan clone() {
		IterationPlan clone = new IterationPlan(this.numOfIterations, this.assigneeAvailabilityManager);
		clone.plannedTasks = this.plannedTasks; // is it really possible? plannedTasks is private!
		return clone;
	}

	public IterationPlan(int numOfIterations, AssigneeAvailabilityManager assigneeAvailabilityManager) {
		this.numOfIterations = numOfIterations;
		this.assigneeAvailabilityManager = assigneeAvailabilityManager;
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
		// invariant: getSumOfEstimateForIterationAndAssignee(newIterationNumber, task.assignee) <=
		// getAvailability(newIterationNumber, task.assignee);
		if (plannedTask.getAssigneeExpertise() == null) {
			// this task doesn't still have an assignee
			return;
		}
		if (newIterationNumber == getBacklogNumber()) {
			// in backlog every assignee is infinite available ==> invariant true
			return;
		}

		// find the the lowest priority task in this iteration for this assignee and move it one iteration downward.
		Assignee assignee = plannedTask.getAssigneeExpertise().getAssignee();
		int availabilityForIteration = assigneeAvailabilityManager.getAvailability(newIterationNumber, assignee);

		int sumOfEstimateForIterationAndAssignee = getSumOfEstimateForIterationAndAssignee(newIterationNumber, assignee);
		while (sumOfEstimateForIterationAndAssignee > availabilityForIteration) {
			PlannedTask lowestPrioTask = findLowestPriorityTaskInThisIterationForThisAssignee(newIterationNumber,
				assignee);
			// put this task in a later iteration or eventually in backlog.
			lowestPrioTask.setIterationNumber(lowestPrioTask.getIterationNumber() + 1);
			sumOfEstimateForIterationAndAssignee = getSumOfEstimateForIterationAndAssignee(newIterationNumber, assignee);
		}

		// check the invariant
		for (int i = 0; i < numOfIterations; i++) {
			assert (getSumOfEstimateForIterationAndAssignee(i, assignee) <= availabilityForIteration);
		}

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

	public void setAssigneeFor(PlannedTask plannedTask, AssigneeExpertise assignee) {
		plannedTask.setAssigneeExpertise(assignee);
		// invariant: getSumOfEstimateForIterationAndAssignee(newIterationNumber, task.assignee) <=
		// getAvailability(newIterationNumber, task.assignee);
		int iterationNumber = plannedTask.getIterationNumber();
		if (iterationNumber == getBacklogNumber()) {
			// in backlog every assignee is infinite available ==> invariant true
			return;
		}

		int availabilityForIteration = assigneeAvailabilityManager.getAvailability(iterationNumber, assignee
			.getAssignee());

		int sumOfEstimateForIterationAndAssignee = getSumOfEstimateForIterationAndAssignee(iterationNumber, assignee
			.getAssignee());
		while (sumOfEstimateForIterationAndAssignee > availabilityForIteration) {
			PlannedTask lowestPrioTask = findLowestPriorityTaskInThisIterationForThisAssignee(iterationNumber, assignee
				.getAssignee());
			// put this task in a later iteration or eventually in backlog.
			lowestPrioTask.setIterationNumber(lowestPrioTask.getIterationNumber() + 1);
			sumOfEstimateForIterationAndAssignee = getSumOfEstimateForIterationAndAssignee(iterationNumber, assignee
				.getAssignee());
		}
		// check the invariant
		for (int i = 0; i < numOfIterations; i++) {
			assert (getSumOfEstimateForIterationAndAssignee(i, assignee.getAssignee()) <= availabilityForIteration);
		}

	}

	private PlannedTask findLowestPriorityTaskInThisIterationForThisAssignee(int iterationNumber, Assignee assignee) {
		List<PlannedTask> allPlannedTasksForIterationAndAssignee = getAllPlannedTasksForIterationAndAssignee(
			iterationNumber, assignee);
		PlannedTask lowestPrioTask = allPlannedTasksForIterationAndAssignee.get(0);
		for (PlannedTask pt : getAllPlannedTasksForIterationAndAssignee(iterationNumber, assignee)) {
			if (pt.getTask().getPriority() < lowestPrioTask.getTask().getPriority()) {
				lowestPrioTask = pt;
			}
		}

		return lowestPrioTask;
	}

	public int getSumOfEstimateForIterationAndAssignee(int iterationNumber, Assignee assignee) {
		int sumOfEstimate = 0;
		for (PlannedTask pt : getAllPlannedTasksForIterationAndAssignee(iterationNumber, assignee)) {
			sumOfEstimate += pt.getTask().getEstimate();
		}
		return sumOfEstimate;
	}

	public List<Assignee> getAssignees() {
		List<Assignee> assignees = new ArrayList<Assignee>();
		for (PlannedTask pt : plannedTasks) {
			assignees.add(pt.getAssigneeExpertise().getAssignee());
		}

		return assignees;
	}

}

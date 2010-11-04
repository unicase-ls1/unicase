package org.unicase.iterationplanner.planner;

import java.util.ArrayList;
import java.util.Collection;
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
	private boolean crossover = false;
	private int numOfTasks;

	@Override
	public IterationPlan clone() {
		IterationPlan clone = new IterationPlan(this.numOfIterations, this.numOfTasks, this.assigneeAvailabilityManager);
		for(PlannedTask plannedTask : this.plannedTasks){
			clone.addPlannedTask(plannedTask.clone());
		}
		return clone;
	}

	/**
	 * 
	 * @param numOfIterations
	 * @param numOfTasks is used just for checking invariants
	 * @param assigneeAvailabilityManager
	 */
	public IterationPlan(int numOfIterations, int numOfTasks, AssigneeAvailabilityManager assigneeAvailabilityManager) {
		this.numOfIterations = numOfIterations;
		this.numOfTasks = numOfTasks;
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

	private Set<PlannedTask> getPlannedTasks() {
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
		if(isCrossover()){
			plannedTask.setIterationNumber(newIterationNumber);
			return;
		}
		
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
			PlannedTask lowestPrioTask = findLowestPriorityTaskInIterationForAssignee(newIterationNumber, assignee);
			// put this task in a later iteration or eventually in backlog.
			setIterationNumberFor(lowestPrioTask, lowestPrioTask.getIterationNumber() + 1);
			sumOfEstimateForIterationAndAssignee = getSumOfEstimateForIterationAndAssignee(newIterationNumber, assignee);
		}

		// check the invariant
		checkInvariant(assignee);

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
		if(isCrossover()) {
			//during crossover we do nothing. after crossover an invarian correction will be run on iteration plan.
			return;
		}
		// invariant: getSumOfEstimateForIterationAndAssignee(newIterationNumber, task.assignee) <=
		// getAvailability(newIterationNumber, task.assignee);
		int iterationNumber = plannedTask.getIterationNumber();
		if (iterationNumber == getBacklogNumber()) {
			// in backlog every assignee is infinite available ==> invariant true
			return;
		}

		int availabilityForIteration = assigneeAvailabilityManager.getAvailability(iterationNumber, assignee.getAssignee());

		int sumOfEstimateForIterationAndAssignee = getSumOfEstimateForIterationAndAssignee(iterationNumber, assignee.getAssignee());
		while (sumOfEstimateForIterationAndAssignee > availabilityForIteration) {
			PlannedTask lowestPrioTask = findLowestPriorityTaskInIterationForAssignee(iterationNumber, assignee.getAssignee());
			// put this task in a later iteration or eventually in backlog.
			setIterationNumberFor(lowestPrioTask, lowestPrioTask.getIterationNumber() + 1);
			sumOfEstimateForIterationAndAssignee = getSumOfEstimateForIterationAndAssignee(iterationNumber, assignee.getAssignee());
		}
		// check the invariant
		checkInvariant(assignee.getAssignee());

	}

	private void checkInvariant(Assignee assignee) {
		for (int i = 0; i < numOfIterations; i++) {
			assert (getSumOfEstimateForIterationAndAssignee(i, assignee) <= assigneeAvailabilityManager
				.getAvailability(i, assignee));
		}
	}

	private PlannedTask findLowestPriorityTaskInIterationForAssignee(int iterationNumber, Assignee assignee) {
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

	public void addPlannedTask(PlannedTask mutatedTask) {
		getPlannedTasks().add(mutatedTask);
		mutatedTask.setIterationPlan(this);
	}
	
	public void addAll(Collection<PlannedTask> plannedTasks) {
		for(PlannedTask pt : plannedTasks){
			getPlannedTasks().add(pt);
			pt.setIterationPlan(this);
		}
	}

	/*
	 * If crossover is true, this instance of iteration plan is being created through crossover.
	 * In this state the invariants are not checked when setting iteration number and assignee for a task.
	 * Calling setCrossover(false) triggers an invariant correction on iteration plan.
	 * For Invariant see setAssigneeFor() and setIterationNumberFor() methods. 
	 */
	public void setCrossover(boolean crossover) {
		this.crossover = crossover;
		if(crossover == false){
			doInvariantCorrection();
		}
	}

	/*
	 * This goes through all tasks, and all assignees, and checks the invariant for this assignee. 
	 * If needed the lowest priority task for this assignee is shifted down one iteration.
	 */
	private void doInvariantCorrection() {
		List<Assignee> assignees = getAssignees();
		for(int i = 0; i < numOfIterations; i++){
			for(Assignee assignee : assignees){
				while (getSumOfEstimateForIterationAndAssignee(i, assignee) > assigneeAvailabilityManager
					.getAvailability(i, assignee)) {
					PlannedTask lowestPrioTask = findLowestPriorityTaskInIterationForAssignee(i, assignee);
					lowestPrioTask.setIterationNumber(i + 1);
				}
			}
		}
		
		checkAllInvariants();
	}

	public void checkAllInvariants() {
		List<Assignee> assignees = getAssignees();
		for(Assignee assignee : assignees){
			checkInvariant(assignee);
		}
		// also do some other checks to ensure that iteration plan is not corrupted.
		// check number of tasks
		assert(plannedTasks.size() == numOfTasks);
		
		//check for duplicate tasks 
		for(PlannedTask pt1 : plannedTasks){
			for(PlannedTask pt2 : plannedTasks){
				if(!pt1.equals(pt2)){
					assert(!pt1.getTask().equals(pt2));
				}
			}
		}
	
	}

	/*
	 * returns if this iteration plan is in the state of bing created through crossover.
	 * In this state the invariants are not checked when setting iteration number and assignee for a task.
	 */
	public boolean isCrossover() {
		return crossover;
	}
	
	
}

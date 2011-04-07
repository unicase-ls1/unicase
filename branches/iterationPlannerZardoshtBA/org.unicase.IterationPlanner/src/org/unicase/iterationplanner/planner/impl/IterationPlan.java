package org.unicase.iterationplanner.planner.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.unicase.iterationplanner.assigneeRecommender.AssigneeExpertise;
import org.unicase.iterationplanner.assigneeRecommender.IAssignee;
import org.unicase.iterationplanner.entities.AssigneeAvailabilityManager;
import org.unicase.iterationplanner.entities.IIterationPlan;
import org.unicase.iterationplanner.entities.IPlannedTask;


/**
 * This represents single individuals in population. Hence, this is the representation of our genome. Our genome is a
 * set of Iterations. An Iteration is itself as set of PlannedTasks, i.e. IterationPlan = {(task, assignee, iteration)}.
 * The cardinality of this set is number of tasks that are to be planned.
 * 
 * @author zardosht
 */
public class IterationPlan implements Comparable<IIterationPlan>, IIterationPlan {

	// private final Iteration[] iterations;
	private final int numOfIterations;
	private final AssigneeAvailabilityManager assigneeAvailabilityManager;
	private double score;
	private Set<IPlannedTask> plannedTasks;
	private boolean crossover = false;
	private int numOfTasks;
	private boolean checkInvariants;

	

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
		this.checkInvariants = true;
	}
	
	
	@Override
	public IterationPlan clone() {
		this.checkAllInvariants();
		IterationPlan clone = new IterationPlan(this.numOfIterations, this.numOfTasks, this.assigneeAvailabilityManager);
		for(IPlannedTask plannedTask : this.plannedTasks){
			clone.addPlannedTask(plannedTask.clone());
		}
		clone.checkAllInvariants();
		return clone;
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

	public int compareTo(IIterationPlan otherPlan) {
		if (otherPlan.getScore() > this.score) {
			return 1;
		}
		return -1;
	}

	private Set<IPlannedTask> getPlannedTasks() {
		if (plannedTasks == null) {
			plannedTasks = new HashSet<IPlannedTask>();
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

	public void setIterationNumberFor(IPlannedTask plannedTask, int newIterationNumber) {
		
		((PlannedTask)plannedTask).setIterationNumber(newIterationNumber);
		// invariant: getSumOfEstimateForIterationAndAssignee(newIterationNumber, task.assignee) <=
		// getAvailability(newIterationNumber, task.assignee);
		// find the the lowest priority task in this iteration for this assignee and move it one iteration downward.
		doInvariantCorrection();

	}

	public Set<IPlannedTask> getAllPlannedTasksForIteration(int iterationNumber) {
		Set<IPlannedTask> result = new HashSet<IPlannedTask>();
		for (IPlannedTask pt : getPlannedTasks()) {
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

	public List<IPlannedTask> getAllPlannedTasksForIterationAndAssignee(int iterationNumber, IAssignee assignee) {
		Set<IPlannedTask> ptsForIteration = getAllPlannedTasksForIteration(iterationNumber);
		List<IPlannedTask> ptsForIterAndAssignee = new ArrayList<IPlannedTask>();
		for (IPlannedTask pt : ptsForIteration) {
			if (pt.getAssigneeExpertise() != null && assignee.equals(pt.getAssigneeExpertise().getAssignee())) {
				ptsForIterAndAssignee.add(pt);
			}
		}
		return ptsForIterAndAssignee;
	}

	public void setAssigneeFor(IPlannedTask plannedTask, AssigneeExpertise assignee) {
		((PlannedTask)plannedTask).setAssigneeExpertise(assignee);
		// invariant: getSumOfEstimateForIterationAndAssignee(newIterationNumber, task.assignee) <=
		// getAvailability(newIterationNumber, task.assignee);
		doInvariantCorrection();

	}

	private void checkDevLoadInvariant(IAssignee assignee) {
		for (int i = 0; i < numOfIterations; i++) {
			assert (getSumOfEstimateForIterationAndAssignee(i, assignee) <= assigneeAvailabilityManager
				.getAvailability(i, assignee));
		}
	}

	private IPlannedTask findLowestPriorityTaskInIterationForAssignee(int iterationNumber, IAssignee assignee) {
		List<IPlannedTask> allPlannedTasksForIterationAndAssignee = getAllPlannedTasksForIterationAndAssignee(
			iterationNumber, assignee);
		IPlannedTask lowestPrioTask = allPlannedTasksForIterationAndAssignee.get(0);
		for (IPlannedTask pt : getAllPlannedTasksForIterationAndAssignee(iterationNumber, assignee)) {
			if (pt.getTask().getPriority() < lowestPrioTask.getTask().getPriority()) {
				lowestPrioTask = pt;
			}
		}

		return lowestPrioTask;
	}

	public int getSumOfEstimateForIterationAndAssignee(int iterationNumber, IAssignee assignee) {
		int sumOfEstimate = 0;
		List<IPlannedTask> allPlannedTasksForIterationAndAssignee = getAllPlannedTasksForIterationAndAssignee(iterationNumber, assignee);
		for (IPlannedTask pt : allPlannedTasksForIterationAndAssignee) {
			sumOfEstimate += pt.getTask().getEstimate();
		}
		return sumOfEstimate;
	}

	public Set<IAssignee> getAssignees() {
		Set<IAssignee> assignees = new HashSet<IAssignee>();
		for (IPlannedTask pt : plannedTasks) {
			if(pt.getAssigneeExpertise() != null){
				assignees.add(pt.getAssigneeExpertise().getAssignee());
			}
		}

		return assignees;
	}

	public void addPlannedTask(IPlannedTask plannedTask) {
		getPlannedTasks().add(plannedTask);
		((PlannedTask)plannedTask).setIterationPlan(this);
	}
	
	public void addAll(Collection<IPlannedTask> plannedTasks) {
		for(IPlannedTask pt : plannedTasks){
			getPlannedTasks().add(pt);
			((PlannedTask)pt).setIterationPlan(this);
		}
	}

	/**
	 * If crossover is true, this instance of iteration plan is being created through crossover.
	 * In this state the invariants are not checked when setting iteration number and assignee for a task.
	 * Calling setCrossover(false) triggers an invariant correction on iteration plan.
	 * For Invariant see setAssigneeFor() and setIterationNumberFor() methods. 
	 */
	protected void setCrossover(boolean crossover) {
		this.crossover = crossover;
		if(crossover == false){
			doInvariantCorrection();
			checkAllInvariants();
		}
	}

	/**
	 * This goes through all tasks, and all assignees, and checks the invariant for this assignee. 
	 * If needed the lowest priority task for this assignee is shifted down one iteration.
	 */
	private void doInvariantCorrection() {
		if(!isCheckInvariants()){
			return;
		}
		Set<IAssignee> assignees = getAssignees();
		for(int i = 0; i < numOfIterations; i++){
			for(IAssignee assignee : assignees){
				while (getSumOfEstimateForIterationAndAssignee(i, assignee) > assigneeAvailabilityManager
					.getAvailability(i, assignee)) {
					IPlannedTask lowestPrioTask = findLowestPriorityTaskInIterationForAssignee(i, assignee);
					((PlannedTask)lowestPrioTask).setIterationNumber(i + 1);
				}
			}
		}
		checkDevLoadInvariantForAllAssignees();
		
	}
	

	private boolean isCheckInvariants() {
		return checkInvariants;
	}

	public void setCheckInvariants(boolean checkInvariants) {
		this.checkInvariants = checkInvariants;
		if(checkInvariants){
			checkAllInvariants();
		}
	}

	public void checkAllInvariants() {
		if(!isCheckInvariants()){
			return;
		}
		checkDevLoadInvariantForAllAssignees();
		// also do some other checks to ensure that iteration plan is not corrupted.
		// check number of tasks
		checkNumOfTasks();
		
		//check for duplicate tasks 
		checkForDuplicateTasks();
		
		checkForTasksWithOutAssignee();
	}

	private void checkForTasksWithOutAssignee() {
		for(IPlannedTask pt : plannedTasks){
			assert pt.getAssigneeExpertise() != null;
		}
	}

	private void checkForDuplicateTasks() {
		for(IPlannedTask pt1 : plannedTasks){
			for(IPlannedTask pt2 : plannedTasks){
				if(!pt1.equals(pt2)){
					assert(!pt1.getTask().equals(pt2));
				}
			}
		}
	}

	private void checkNumOfTasks() {
		assert(plannedTasks.size() == numOfTasks);
	}

	private void checkDevLoadInvariantForAllAssignees() {
		if(checkInvariants){
			Set<IAssignee> assignees = getAssignees();
			for(IAssignee assignee : assignees){
				checkDevLoadInvariant(assignee);
			}
		}
	}

	/**
	 * returns if this iteration plan is in the state of bing created through crossover.
	 * In this state the invariants are not checked when setting iteration number and assignee for a task.
	 */
	protected boolean isCrossover() {
		return crossover;
	}
	
	public Set<IPlannedTask> getAllPlannedTasks(){
		return Collections.unmodifiableSet(plannedTasks);
	}
	
	
}

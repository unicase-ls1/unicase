package org.unicase.iterationplanner.planner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
		for(PlannedTask plannedTask : this.plannedTasks){
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
		
		plannedTask.setIterationNumber(newIterationNumber);
		// invariant: getSumOfEstimateForIterationAndAssignee(newIterationNumber, task.assignee) <=
		// getAvailability(newIterationNumber, task.assignee);
		// find the the lowest priority task in this iteration for this assignee and move it one iteration downward.
		doInvariantCorrection();

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
			if (pt.getAssigneeExpertise() != null && assignee.equals(pt.getAssigneeExpertise().getAssignee())) {
				ptsForIterAndAssignee.add(pt);
			}
		}
		return ptsForIterAndAssignee;
	}

	public void setAssigneeFor(PlannedTask plannedTask, AssigneeExpertise assignee) {
		plannedTask.setAssigneeExpertise(assignee);
		// invariant: getSumOfEstimateForIterationAndAssignee(newIterationNumber, task.assignee) <=
		// getAvailability(newIterationNumber, task.assignee);
		doInvariantCorrection();

	}

	private void checkDevLoadInvariant(Assignee assignee) {
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
		List<PlannedTask> allPlannedTasksForIterationAndAssignee = getAllPlannedTasksForIterationAndAssignee(iterationNumber, assignee);
		for (PlannedTask pt : allPlannedTasksForIterationAndAssignee) {
			sumOfEstimate += pt.getTask().getEstimate();
		}
		return sumOfEstimate;
	}

	public Set<Assignee> getAssignees() {
		Set<Assignee> assignees = new HashSet<Assignee>();
		for (PlannedTask pt : plannedTasks) {
			if(pt.getAssigneeExpertise() != null){
				assignees.add(pt.getAssigneeExpertise().getAssignee());
			}
		}

		return assignees;
	}

	public void addPlannedTask(PlannedTask plannedTask) {
		getPlannedTasks().add(plannedTask);
		plannedTask.setIterationPlan(this);
	}
	
	public void addAll(Collection<PlannedTask> plannedTasks) {
		for(PlannedTask pt : plannedTasks){
			getPlannedTasks().add(pt);
			pt.setIterationPlan(this);
		}
	}

	/**
	 * If crossover is true, this instance of iteration plan is being created through crossover.
	 * In this state the invariants are not checked when setting iteration number and assignee for a task.
	 * Calling setCrossover(false) triggers an invariant correction on iteration plan.
	 * For Invariant see setAssigneeFor() and setIterationNumberFor() methods. 
	 */
	public void setCrossover(boolean crossover) {
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
		Set<Assignee> assignees = getAssignees();
		for(int i = 0; i < numOfIterations; i++){
			for(Assignee assignee : assignees){
				while (getSumOfEstimateForIterationAndAssignee(i, assignee) > assigneeAvailabilityManager
					.getAvailability(i, assignee)) {
					PlannedTask lowestPrioTask = findLowestPriorityTaskInIterationForAssignee(i, assignee);
					lowestPrioTask.setIterationNumber(i + 1);
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
		for(PlannedTask pt : plannedTasks){
			assert pt.getAssigneeExpertise() != null;
		}
	}

	private void checkForDuplicateTasks() {
		for(PlannedTask pt1 : plannedTasks){
			for(PlannedTask pt2 : plannedTasks){
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
			Set<Assignee> assignees = getAssignees();
			for(Assignee assignee : assignees){
				checkDevLoadInvariant(assignee);
			}
		}
	}

	/**
	 * returns if this iteration plan is in the state of bing created through crossover.
	 * In this state the invariants are not checked when setting iteration number and assignee for a task.
	 */
	public boolean isCrossover() {
		return crossover;
	}
	
	public Set<PlannedTask> getAllPlannedTasks(){
		return Collections.unmodifiableSet(plannedTasks);
	}
	
	
}

package org.unicase.iterationplanner.planner.impl.randomplanner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.unicase.iterationplanner.assigneeRecommender.AssigneeExpertise;
import org.unicase.iterationplanner.assigneeRecommender.IAssignee;
import org.unicase.iterationplanner.planner.AssigneeAvailabilityManager;
import org.unicase.iterationplanner.planner.IIterationPlan;
import org.unicase.iterationplanner.planner.IPlannedTask;

public class RandomIterationPlan implements IIterationPlan {

	private final int numOfIterations;
	private final AssigneeAvailabilityManager assigneeAvailabilityManager;
	private double score;
	private Set<IPlannedTask> plannedTasks;
	private int numOfTasks;
	
	
	
	public RandomIterationPlan(int numOfIterations, int numOfTasks, AssigneeAvailabilityManager assigneeAvailabilityManager){
		this.numOfIterations = numOfIterations;
		this.numOfTasks = numOfTasks;
		this.assigneeAvailabilityManager = assigneeAvailabilityManager;
		plannedTasks = new HashSet<IPlannedTask>();
	}
	
	@Override
	public IIterationPlan clone(){
		RandomIterationPlan clone = new RandomIterationPlan(this.numOfIterations, this.numOfTasks, this.assigneeAvailabilityManager);
		for(IPlannedTask plannedTask : this.plannedTasks){
			clone.addPlannedTask(plannedTask.clone());
		}
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
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof RandomIterationPlan)) {
			return false;
		}
		RandomIterationPlan incomming = (RandomIterationPlan) obj;
		return this.plannedTasks.equals(incomming.plannedTasks);
	}
	
	
	public void addAll(Collection<IPlannedTask> plannedTasks) {
		for(IPlannedTask pt : plannedTasks){
			plannedTasks.add(pt);
			((RandomPlannedTask)pt).setIterationPlan(this);
		}
	}

	public void addPlannedTask(IPlannedTask plannedTask) {
		this.plannedTasks.add(plannedTask);
		((RandomPlannedTask)plannedTask).setIterationPlan(this);
	}

	public Set<IPlannedTask> getAllPlannedTasks() {
		return Collections.unmodifiableSet(plannedTasks);
	}

	public Set<IPlannedTask> getAllPlannedTasksForIteration(int iterationNumber) {
		Set<IPlannedTask> result = new HashSet<IPlannedTask>();
		for (IPlannedTask pt : plannedTasks) {
			if (pt.getIterationNumber() == iterationNumber) {
				result.add(pt);
			}
		}

		return result;
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

	public Set<IAssignee> getAssignees() {
		Set<IAssignee> assignees = new HashSet<IAssignee>();
		for (IPlannedTask pt : plannedTasks) {
			if(pt.getAssigneeExpertise() != null){
				assignees.add(pt.getAssigneeExpertise().getAssignee());
			}
		}

		return assignees;
	}

	public int getBacklogNumber() {
		// if numOfIteration == 3, then we have Iter0, Iter1, Iter2, hence Backlog will be Iter3
		return numOfIterations;
	}


	
	public int getSumOfEstimateForIterationAndAssignee(int iterationNumber, IAssignee assignee) {
		int sumOfEstimate = 0;
		List<IPlannedTask> allPlannedTasksForIterationAndAssignee = getAllPlannedTasksForIterationAndAssignee(iterationNumber, assignee);
		for (IPlannedTask pt : allPlannedTasksForIterationAndAssignee) {
			sumOfEstimate += pt.getTask().getEstimate();
		}
		return sumOfEstimate;
	}

	public void setAssigneeFor(IPlannedTask plannedTask, AssigneeExpertise assignee) {
		((RandomPlannedTask)plannedTask).setAssigneeExpertise(assignee);

	}

	public void setIterationNumberFor(IPlannedTask plannedTask, int newIterationNumber) {
		((RandomPlannedTask)plannedTask).setIterationNumber(newIterationNumber);
		
	}
	
	
	public void setCheckInvariants(boolean b) { }


	

}

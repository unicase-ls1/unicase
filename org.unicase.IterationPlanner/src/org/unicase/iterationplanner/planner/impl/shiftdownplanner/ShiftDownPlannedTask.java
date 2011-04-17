package org.unicase.iterationplanner.planner.impl.shiftdownplanner;

import org.unicase.iterationplanner.assigneeRecommender.AssigneeExpertise;
import org.unicase.iterationplanner.assigneeRecommender.ITask;
import org.unicase.iterationplanner.planner.AbstractPlannedTask;
import org.unicase.iterationplanner.planner.IPlannedTask;


/**
 * This represents a task along with the assigneeExpertise chosen by planner algorithm to do this task. The
 * assigneeExpertise is actually an instance of AssigneeExperties, to experss its qualification for doing this task. The
 * expertise will then be used to evaluate IterationPlans.
 * 
 * @author zardosht
 */
public class ShiftDownPlannedTask extends AbstractPlannedTask  {
	private final ITask task;
	private AssigneeExpertise assigneeExpertise;
	private int iterationNumber = -1;
	private boolean evaluateExperties = true;
	private ShiftDownIterationPlan iterationPlan;
	private boolean clonning;

	public ShiftDownPlannedTask(ITask task) {
		this.task = task;
	}

	@Override
	public IPlannedTask clone() {
		ShiftDownPlannedTask clone = new ShiftDownPlannedTask(this.task);
		clone.setClonning(true);
		clone.setAssigneeExpertise(this.assigneeExpertise);
		clone.setIterationNumber(this.iterationNumber);
		clone.setClonning(false);
		return clone;
	}

	private void setClonning(boolean clonning) {
		this.clonning = clonning;
	}
	
	private boolean isClonning() {
		return this.clonning;
	}

	@Override
	public ITask getTask() {
		return task;
	}

	protected void setAssigneeExpertise(AssigneeExpertise assigneeExpertise) {
		checkIteartionPlann();
		this.assigneeExpertise = assigneeExpertise;
	}

	private void checkIteartionPlann() {
		if(!isClonning() && iterationPlan == null){
			throw new IllegalStateException("This planned task is not added to an iteration plan yet.");
		}
	}


	@Override
	public AssigneeExpertise getAssigneeExpertise() {
		return assigneeExpertise;
	}

	protected void setIterationNumber(int iterationNumber) {
		checkIteartionPlann();
		this.iterationNumber = iterationNumber;
	}

	@Override
	public int getIterationNumber() {
		return iterationNumber;
	}

	/**
	 * true if Task, AssigneeExpertise, and iterationNumber are equal.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ShiftDownPlannedTask)) {
			return false;
		}
		ShiftDownPlannedTask incomming = (ShiftDownPlannedTask) obj;
		if (!this.assigneeExpertise.equals(incomming.assigneeExpertise)) {
			return false;
		}
		if (!this.task.equals(incomming.task)) {
			return false;
		}
		if (this.iterationNumber != incomming.iterationNumber) {
			return false;
		}
		return true;
	}

	
	
	

	/**
	 * true if Tasks in both instances are equal.
	 */
	@Override
	public boolean equalsTask(Object obj) {
		if (!(obj instanceof ShiftDownPlannedTask)) {
			return false;
		}
		ShiftDownPlannedTask incomming = (ShiftDownPlannedTask) obj;
		if (!this.task.equals(incomming.task)) {
			return false;
		}
		return true;
	}
	
	/**
	 * if all potential assignees for this task have the same expertise value, then this task should not be considered
	 * in evaluation of expertise for an iteration plan.
	 * 
	 * @param evaluateExperties
	 */
	@Override
	public void setEvaluateExperties(boolean evaluateExperties) {
		this.evaluateExperties = evaluateExperties;
	}

	/**
	 * if all potential assignees for this task have the same expertise value, then this task should not be considered
	 * in evaluation of expertise for an iteration plan.
	 * 
	 * @return
	 */
	@Override
	public boolean isEvaluateExpertise() {
		return evaluateExperties;
	}

	protected void setIterationPlan(ShiftDownIterationPlan iterationPlan) {
		this.iterationPlan = iterationPlan;
	}
}

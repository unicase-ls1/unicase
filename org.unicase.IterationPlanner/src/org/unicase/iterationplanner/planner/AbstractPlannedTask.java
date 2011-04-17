package org.unicase.iterationplanner.planner;

import org.unicase.iterationplanner.assigneeRecommender.AssigneeExpertise;
import org.unicase.iterationplanner.assigneeRecommender.ITask;

public abstract class AbstractPlannedTask implements IPlannedTask {

	@Override
	public abstract boolean equals(Object obj);

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	@Override
	public String toString() {
		String result = "Iteration: " + getIterationNumber() + " ---> " + getAssigneeExpertise().getAssignee().toString()
			+ " ---> " + getTask().getName() + " (Obejct: " + super.toString() + ")";
		return result;
	}

	public boolean equalsTask(Object obj) {
		return false;
	}

	@Override
	public abstract IPlannedTask clone() throws CloneNotSupportedException;

	public abstract AssigneeExpertise getAssigneeExpertise();

	public abstract int getIterationNumber();

	public abstract ITask getTask();

	public boolean isEvaluateExpertise() {
		return false;
	}

	public void setEvaluateExperties(boolean evaluateExpertise) {

	}

}

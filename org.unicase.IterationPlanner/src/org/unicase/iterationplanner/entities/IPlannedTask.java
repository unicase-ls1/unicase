package org.unicase.iterationplanner.entities;

import org.unicase.iterationplanner.planner.impl.PlannedTask;

public interface IPlannedTask {

	PlannedTask clone();

	ITask getTask();

	AssigneeExpertise getAssigneeExpertise();

	int getIterationNumber();
	
	void setIterationNumber(int iterationNumber);
	
	void setAssigneeExpertise(AssigneeExpertise assigneeExpertise);

	/**
	 * true if Task, AssigneeExpertise, and iterationNumber are equal.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	boolean equals(Object obj);

	/**
	 * true if Tasks in both instances are equal.
	 */
	boolean equalsTask(Object obj);
	
	
	boolean isEvaluateExpertise();
	
	void setEvaluateExperties(boolean evaluateExpertise);

}
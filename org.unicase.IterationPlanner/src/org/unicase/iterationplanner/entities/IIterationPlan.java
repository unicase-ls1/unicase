package org.unicase.iterationplanner.entities;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface IIterationPlan {

	IIterationPlan clone();

	int getNumOfIterations();

	void setScore(double score);

	double getScore();

	int compareTo(IIterationPlan otherPlan);

	boolean equals(Object obj);

	void setIterationNumberFor(IPlannedTask plannedTask, int newIterationNumber);

	Set<IPlannedTask> getAllPlannedTasksForIteration(int iterationNumber);

	int getBacklogNumber();

	List<IPlannedTask> getAllPlannedTasksForIterationAndAssignee(int iterationNumber, IAssignee assignee);

	void setAssigneeFor(IPlannedTask plannedTask, AssigneeExpertise assignee);

	int getSumOfEstimateForIterationAndAssignee(int iterationNumber, IAssignee assignee);

	Set<IAssignee> getAssignees();

	void addPlannedTask(IPlannedTask plannedTask);

	void addAll(Collection<IPlannedTask> plannedTasks);

	void checkAllInvariants();

	Set<IPlannedTask> getAllPlannedTasks();
	
	void setCheckInvariants(boolean checkInvariants);

}
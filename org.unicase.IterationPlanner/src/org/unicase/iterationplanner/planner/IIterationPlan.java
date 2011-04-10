package org.unicase.iterationplanner.planner;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.unicase.iterationplanner.assigneeRecommender.AssigneeExpertise;
import org.unicase.iterationplanner.assigneeRecommender.IAssignee;

public interface IIterationPlan extends Comparable<IIterationPlan> {

	IIterationPlan clone();

	int getNumOfIterations();

	void setScore(double score);

	double getScore();

	void setIterationNumberFor(IPlannedTask plannedTask, int newIterationNumber);

	Set<IPlannedTask> getAllPlannedTasksForIteration(int iterationNumber);

	int getBacklogNumber();

	List<IPlannedTask> getAllPlannedTasksForIterationAndAssignee(int iterationNumber, IAssignee assignee);

	void setAssigneeFor(IPlannedTask plannedTask, AssigneeExpertise assignee);

	int getSumOfEstimateForIterationAndAssignee(int iterationNumber, IAssignee assignee);

	Set<IAssignee> getAssignees();

	void addPlannedTask(IPlannedTask plannedTask);

	void addAll(Collection<IPlannedTask> plannedTasks);

	Set<IPlannedTask> getAllPlannedTasks();
	
}
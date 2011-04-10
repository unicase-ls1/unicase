package org.unicase.iterationplanner.planner;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.unicase.iterationplanner.assigneeRecommender.AssigneeExpertise;
import org.unicase.iterationplanner.assigneeRecommender.IAssignee;

public interface IIterationPlan extends Comparable<IIterationPlan> {

	IIterationPlan clone();
	int getNumOfIterations();
	int getBacklogNumber();
	void setScore(double score);
	double getScore();

	Set<IAssignee> getAssignees();
	Set<IPlannedTask> getAllPlannedTasks();
	Set<IPlannedTask> getAllPlannedTasksForIteration(int iterationNumber);
	List<IPlannedTask> getAllPlannedTasksForIterationAndAssignee(int iterationNumber, IAssignee assignee);
	int getSumOfEstimateForIterationAndAssignee(int iterationNumber, IAssignee assignee);

	void addPlannedTask(IPlannedTask plannedTask);
	void addAll(Collection<IPlannedTask> plannedTasks);
	
	void setIterationNumberFor(IPlannedTask plannedTask, int newIterationNumber);
	void setAssigneeFor(IPlannedTask plannedTask, AssigneeExpertise assignee);
}
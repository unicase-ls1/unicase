package org.unicase.iterationplanner.assigneeRecommender;

import java.util.List;


/**
 * This class represent a task along with a list of potential assignees. The assignee list is a list of (assignee,
 * expertise) tuples, whereby expertise is a measure of how good a potential assignee is qualified to do this task. This
 * list is also already sorted based on expertise. That is, the first assignee in this list is the most qualified person
 * to do this task.
 * 
 * @author zardosht
 */
public class TaskPotentialAssigneeList {

	private final List<AssigneeExpertise> recommendedAssignees;
	private final ITask task;

	public TaskPotentialAssigneeList(ITask task, List<AssigneeExpertise> assignees) {
		this.recommendedAssignees = assignees;
		this.task = task;
	}

	public List<AssigneeExpertise> getRecommendedAssignees() {
		return recommendedAssignees;
	}

	public ITask getTask() {
		return task;
	}

}

package org.unicase.ui.iterationplanner.assigneerecommendation;

import java.util.List;

public class TaskAssignee {

	private final List<Assignee> recommendedAssignees;
	private final Task task;

	public TaskAssignee(List<Assignee> recommendedAssignees, Task task) {
		this.recommendedAssignees = recommendedAssignees;
		this.task = task;
	}

	public List<Assignee> getRecommendedAssignees() {
		return recommendedAssignees;
	}

	public Task getTask() {
		return task;
	}

}

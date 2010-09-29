package org.unicase.ui.iterationplanner.assigneerecommendation;

import java.util.List;

public class TaskAssignee {

	private final List<AssigneeExpertise> recommendedAssignees;
	private final Task task;

	public TaskAssignee(Task task, List<AssigneeExpertise> assignees) {
		this.recommendedAssignees = assignees;
		this.task = task;
	}

	public List<AssigneeExpertise> getRecommendedAssignees() {
		return recommendedAssignees;
	}

	public Task getTask() {
		return task;
	}

}

package org.unicase.iterationplanner.assigneerecommender;

import java.util.ArrayList;
import java.util.List;

import org.unicase.iterationplanner.assigneeRecommender.AssigneeExpertise;
import org.unicase.iterationplanner.assigneeRecommender.AssigneeRecommender;
import org.unicase.iterationplanner.assigneeRecommender.TaskPotentialAssigneeList;

public class UnicaseAssigneeRecommender extends AssigneeRecommender {
	public UnicaseAssigneeRecommender() {
		setRecommendationStrategy(new ModelBasedAssigneeRecommendation(20, 0.0));
	}

	@Override
	public List<TaskPotentialAssigneeList> getTaskPotenialAssigneeLists() {
		List<TaskPotentialAssigneeList> result = new ArrayList<TaskPotentialAssigneeList>();
		for (Task task : TaskPool.getInstance().getTasksToPlan()) {
			List<AssigneeExpertise> assignees = getRecommendationStrategy().getRecommendedAssignees(task);
			result.add(new TaskPotentialAssigneeList(task, assignees));
		}

		return result;
	}
}

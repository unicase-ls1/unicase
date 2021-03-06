package org.unicase.iterationplanner.assigneerecommendation;

import java.util.ArrayList;
import java.util.List;

public class AssigneeRecommender {

	private AssigneeRecommendationStrategy recommendationStrategy;

	public AssigneeRecommender() {
		this.recommendationStrategy = new ModelBasedAssigneeRecommendation(20, 0.);
	}

	public void setRecommendationStrategy(AssigneeRecommendationStrategy recommendationStrategy) {
		this.recommendationStrategy = recommendationStrategy;
	}

	public AssigneeRecommendationStrategy getRecommendationStrategy() {
		return recommendationStrategy;
	}

	public List<TaskPotentialAssigneeList> getTaskPotenialAssigneeLists() {

		List<TaskPotentialAssigneeList> result = new ArrayList<TaskPotentialAssigneeList>();
		for (Task task : TaskPool.getInstance().getTasksToPlan()) {
			List<AssigneeExpertise> assignees = recommendationStrategy.getRecommendedAssignees(task);
			result.add(new TaskPotentialAssigneeList(task, assignees));
		}

		return result;
	}

}

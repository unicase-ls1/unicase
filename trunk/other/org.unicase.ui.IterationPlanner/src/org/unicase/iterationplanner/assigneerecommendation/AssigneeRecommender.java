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

	public List<TaskAssignee> getTaskAssignees() {

		List<TaskAssignee> result = new ArrayList<TaskAssignee>();
		for (Task task : TaskPool.getInstance().getTasks()) {
			List<AssigneeExpertise> assignees = recommendationStrategy.getRecommendedAssignees(task);
			result.add(new TaskAssignee(task, assignees));
		}

		return result;
	}

}

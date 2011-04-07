package org.unicase.iterationplanner.assigneeRecommender;

import java.util.List;

public abstract class AssigneeRecommender {

	private AssigneeRecommendationStrategy recommendationStrategy;

	public AssigneeRecommender() {
		
	}

	public void setRecommendationStrategy(AssigneeRecommendationStrategy recommendationStrategy) {
		this.recommendationStrategy = recommendationStrategy;
	}

	public AssigneeRecommendationStrategy getRecommendationStrategy() {
		return recommendationStrategy;
	}

	public abstract List<TaskPotentialAssigneeList> getTaskPotenialAssigneeLists(); 

}

package org.unicase.ui.iterationplanner.assigneerecommendation;

public class AssigneeRecommender {

	private AssigneeRecommendationStrategy recommendationStrategy;

	public void setRecommendationStrategy(AssigneeRecommendationStrategy recommendationStrategy) {
		this.recommendationStrategy = recommendationStrategy;
	}

	public AssigneeRecommendationStrategy getRecommendationStrategy() {
		return recommendationStrategy;
	}

}

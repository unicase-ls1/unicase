package org.unicase.ui.iterationplanner.assigneerecommendation;

import java.util.List;

public class ModelBasedAssigneeRecommendation extends AssigneeRecommendationStrategy {

	public ModelBasedAssigneeRecommendation(int maxNumOfAssignees, double expertiseThreshold) {
		super(maxNumOfAssignees, expertiseThreshold);
	}

	@Override
	public List<AssigneeExpertise> getRecommendedAssignees(Task task) {

		return null;
	}

}

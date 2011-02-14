package org.unicase.iterationplanner.assigneerecommender;

import java.util.ArrayList;
import java.util.List;

import org.unicase.iterationplanner.assigneerecommendation.AssigneeExpertise;
import org.unicase.iterationplanner.assigneerecommendation.AssigneeRecommendationStrategy;
import org.unicase.iterationplanner.assigneerecommendation.ModelBasedAssigneeRecommendation;
import org.unicase.iterationplanner.assigneerecommendation.Task;
import org.unicase.iterationplanner.assigneerecommendation.TaskPool;
import org.unicase.iterationplanner.assigneerecommendation.TaskPotentialAssigneeList;

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

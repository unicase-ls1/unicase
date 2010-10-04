package org.unicase.iterationplanner.assigneerecommendation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;

public class ModelBasedAssigneeRecommendation extends AssigneeRecommendationStrategy {

	public ModelBasedAssigneeRecommendation(int maxNumOfAssignees, double expertiseThreshold) {
		super(maxNumOfAssignees, expertiseThreshold);
	}

	@Override
	public List<AssigneeExpertise> getRecommendedAssignees(Task task) {
		List<AssigneeExpertise> recommendedAssignees = new ArrayList<AssigneeExpertise>();

		// get related tasks
		List<Task> relatedTasks = TaskPool.getInstance().getRelatedTasks(task);

		// all available assignees (from AssigneePool)
		List<Assignee> availableAssignees = AssigneePool.getInstance().getAvailableAssignees();

		for (Assignee assignee : availableAssignees) {
			double expertise = getExperties(assignee, relatedTasks);
			recommendedAssignees.add(new AssigneeExpertise(assignee, expertise));
		}
		Collections.sort(recommendedAssignees);
		return recommendedAssignees;
	}

	/**
	 * find how many of the related tasks are done by this assignee
	 * 
	 * @param assignee
	 * @param relatedTasks
	 * @return
	 */
	private double getExperties(Assignee assignee, List<Task> relatedTasks) {
		double result = 0;
		for (Task task : relatedTasks) {
			WorkItem workItem = task.getWorkItem();
			OrgUnit orgUnit = assignee.getOrgUnit();
			if (orgUnit.equals(workItem.getAssignee())) {
				result += 3;
			} else if (workItem.getAssignee() != null && workItem.getAssignee() instanceof Group
				&& ((Group) workItem.getAssignee()).getOrgUnits().contains(orgUnit)) {
				result += 2;
			} else if (workItem.getParticipants().contains(orgUnit)) {
				result += 1;
			}
		}
		return result;
	}
}

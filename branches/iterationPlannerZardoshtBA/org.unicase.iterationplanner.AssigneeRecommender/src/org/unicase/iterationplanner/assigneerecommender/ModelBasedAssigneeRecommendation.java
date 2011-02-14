package org.unicase.iterationplanner.assigneerecommender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.unicase.iterationplanner.planner.AssigneeExpertise;
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
		List<Task> relatedTasks = new ArrayList<Task>();
		try {
			relatedTasks.addAll(TaskPool.getInstance().getRelatedTasks(task));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// all available assignees (from AssigneePool)
		List<Assignee> availableAssignees = AssigneePool.getInstance().getAssignees();

		for (Assignee assignee : availableAssignees) {
			double expertise = getExperties(assignee, relatedTasks);
			recommendedAssignees.add(new AssigneeExpertise(assignee, expertise));
		}
		Collections.sort(recommendedAssignees);
		if(recommendedAssignees.size() > getMaxNumOfAssignees()){
			return recommendedAssignees.subList(0, getMaxNumOfAssignees());
		}else{
			return recommendedAssignees;
		}
	}

	/**
	 * find how many of the related tasks are done by this assignee
	 * 
	 * @param assignee
	 * @param relatedTasks
	 * @return
	 */
	private double getExperties(Assignee assignee, List<Task> relatedTasks) {
		if (relatedTasks.size() == 0) {
			return 0.0;
		}
		int done = 0;
		for (Task task : relatedTasks) {
			WorkItem workItem = task.getWorkItem();
			OrgUnit orgUnit = assignee.getOrgUnit();
			if (orgUnit.equals(workItem.getAssignee())) {
				done += 1;
			}
		}
		// normalize between 0.0 and 1.0
		double result = (double) done / relatedTasks.size();
		return result;
	}
}

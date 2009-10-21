/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.assigneerecommender;

import org.unicase.model.organization.OrgUnit;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkItem;

import java.util.List;
import java.util.Map.Entry;

/**
 * @author Hodaie
 */
public class SimpleAssigneeRecommender implements AssigneeRecommender {

	/**
	 * Finds expertise of a user regarding a task. Expertise is number of related tasks which have this user as
	 * assignee.
	 * 
	 * @param assignee assignee
	 * @param task task
	 * @return int
	 */
	public double getExpertise(WorkItem task, OrgUnit assignee) {

		int expertise = 0;

		List<WorkItem> relatedWorkItems = planningManager.getTaskProvider().getRelatedWorkItems(task);

		// count number of related tasks assigned to this user
		for (WorkItem relatedWorkItem : relatedWorkItems) {
			if (relatedWorkItem.getAssignee() != null && relatedWorkItem.getAssignee().equals(assignee)) {
				expertise += 1;
			}
		}

		return expertise;
	}

	/**
	 * returns a expertise for each assignee relating this task.
	 * 
	 * @param task task
	 * @return a map of assignee to expertise relating this task
	 */
	public ExpertiseMap getExpertiseMap(WorkItem task) {
		ExpertiseMap result = new ExpertiseMap();
		for (OrgUnit assignee : getAssignees()) {
			result.put(assignee, getExpertise(task, assignee));
		}
		return result;
	}

	public OrgUnit getAppropriateAssignee(WorkItem task) {
		// return assigneePredictionStrategy.predictAssignee(task);
		ExpertiseMap expertiseMap = getExpertiseMap(task);
		List<Entry<OrgUnit, Double>> sortedExpertiseMap = expertiseMap.sortByExpertise();

		return sortedExpertiseMap.get(0).getKey();

	}

	/**
	 * @param fr
	 * @return
	 */
	public ExpertiseMap getExpertiseMap(FunctionalRequirement fr) {
		ExpertiseMap result = new ExpertiseMap();
		for (OrgUnit assignee : getAssignees()) {
			result.put(assignee, getExpertise(fr, assignee));
		}
		return result;
	}

	/**
	 * @param fr
	 * @param assignee
	 * @return
	 */
	private double getExpertise(FunctionalRequirement fr, OrgUnit assignee) {
		int expertise = 0;
		List<WorkItem> relatedWorkItems = planningManager.getTaskProvider().getRelatedWorkItems(fr);
		// count number of related tasks assigned to this user
		for (WorkItem relatedWorkItem : relatedWorkItems) {
			if (relatedWorkItem.getAssignee() != null && relatedWorkItem.getAssignee().equals(assignee)) {
				expertise += 1;
			}
		}

		return expertise;
	}
}

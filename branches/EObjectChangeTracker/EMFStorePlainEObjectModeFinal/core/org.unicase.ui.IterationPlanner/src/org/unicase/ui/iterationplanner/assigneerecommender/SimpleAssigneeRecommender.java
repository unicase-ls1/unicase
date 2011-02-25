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

import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.iterationplanner.util.TaskHelper;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hodaie
 */
public class SimpleAssigneeRecommender {

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

		List<WorkItem> relatedWorkItems = TaskHelper.getRelatedWorkItems(task);

		// count number of related tasks assigned to this user
		for (WorkItem relatedWorkItem : relatedWorkItems) {
			if (relatedWorkItem.getAssignee() != null && relatedWorkItem.getAssignee().equals(assignee)) {
				expertise += 1;
			}
		}

		return expertise;
	}

	public Map<UnicaseModelElement, Double> getMatchingMap(WorkItem wi, Collection<OrgUnit> assignees) {
		HashMap<UnicaseModelElement, Double> result = new HashMap<UnicaseModelElement, Double>();
		double maxExpertise = 0.0;
		double rawExpertise;
		for (OrgUnit assignee : assignees) {
			rawExpertise = getExpertise(wi, assignee);
			result.put(assignee, rawExpertise);
			if (rawExpertise > maxExpertise) {
				maxExpertise = rawExpertise;
			}
		}

		// normalize
		for (UnicaseModelElement assignee : result.keySet()) {
			result.put(assignee, result.get(assignee) / maxExpertise);
		}
		return result;
	}

	public String getName() {
		return "SimpleAssigneeRecommender";
	}
}

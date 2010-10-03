/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.planner;

import java.util.Map;

import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;

/**
 * A sprint plan is a mapping from work items to users. These are the task to be done in this sprint by users.
 * @author hodaie
 *
 */
public class SprintPlan {
	private Map<WorkItem, User> assignmentMap;

	/**
	 * Constructor.
	 * 
	 * @param assignements
	 *            assignements.
	 */
	public SprintPlan(Map<WorkItem, User> assignements) {
		this.assignmentMap = assignements;
	}

	/**
	 * @return the plan
	 */
	public Map<WorkItem, User> getAssignementMap() {
		return assignmentMap;
	}

	/**
	 * @param task
	 *            task
	 * @return assignee for this task.
	 */
	public User getAssignee(WorkItem task) {
		return assignmentMap.get(task);
	}

	/**
	 * Sets assignee for this task.
	 * 
	 * @param task
	 *            task
	 * @param user
	 *            assignee
	 */
	public void setAssignee(WorkItem task, User user) {
		assignmentMap.put(task, user);

	}
}

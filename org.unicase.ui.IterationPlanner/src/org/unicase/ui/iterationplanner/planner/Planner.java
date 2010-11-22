/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.iterationplanner.planner;

import java.util.List;

import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.iterationplanner.core.Plan;

/**
 * A org.unicase.ui.iterationplanner.planner takes a set of WorkItems, a set of Users, and number of sprints to
 * plan. It returns a set of sprint plans. Each plan is a mapping of work items
 * to users.
 * 
 * @author Hodaie
 * 
 */
public abstract class Planner {

	/**
	 * assigns tasks to users.
	 * 
	 * @param tasks
	 *            tasks
	 * @param assignees
	 *            users
	 * @param numOfIterations
	 *            number of iterations to plan
	 * @return a list of plans. Each plan is a mapping from task to user.
	 */
	public abstract Plan plan(List<WorkItem> tasks, List<User> assignees,
			int numOfIterations);

}

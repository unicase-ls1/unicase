/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.evaluator;

import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.iterationplanner.planner.Plan;
import org.unicase.ui.iterationplanner.planner.SprintPlan;

/**
 * @author Hodaie
 * 
 */
public interface Evaluator {

	/**
	 * evaluate.
	 * 
	 * @param plan
	 *            plan
	 * @return evaluation
	 */
	 double evaluate(Plan plan);


	/**
	 * 
	 * @param task task
	 * @param assignee assignee
	 * @return how the user is appropriate for this task
	 */
	 double evaluateAssignment(WorkItem task, User assignee);
	 
	 /**
	  * 
	  * @param sprintPlan sprint plan
	  * @return sprint plan
	  */
	 double evaluateSprintPlan(SprintPlan sprintPlan);

}

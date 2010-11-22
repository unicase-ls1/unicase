/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.core;

import java.util.List;

/**
 * An iteration plan is set of sprint plans. A sprint plan is a mapping from work items to users.
 * 
 * @author Hodaie
 * 
 */
public class Plan {

	private List<SprintPlan> sprintPlans;
	private int numOfSprints;

	/**
	 * plan.
	 * 
	 * @param sprintPlans
	 *            sprintPlans.
	 */
	public Plan(List<SprintPlan> sprintPlans) {
		this.sprintPlans = sprintPlans;
	}

	/**
	 * @return the plan
	 */
	public List<SprintPlan> getSprintPlans() {
		return sprintPlans;
	}

	/**
	 * number of sprints.
	 * @return number of sprint
	 */
	public int getNumOfSprints() {
		return numOfSprints;
	}

	
}

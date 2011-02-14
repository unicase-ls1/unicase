/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.iterationplanner.assigneerecommender;

import java.util.List;

import org.unicase.iterationplanner.planner.AssigneeExpertise;

public abstract class AssigneeRecommendationStrategy {

	private final int maxNumOfAssignees;
	private final double expertiseThreshold;

	public AssigneeRecommendationStrategy(int maxNumOfAssignees, double expertiseThreshold) {
		this.maxNumOfAssignees = maxNumOfAssignees;
		this.expertiseThreshold = expertiseThreshold;
	}

	/**
	 * This returns a sorted list of assignees qualified to do this task. The list returns maximum number of assignees
	 * as defined in maxNumOfAssignees, and also contains only assignees whose expertise is regarding the given task is
	 * more than expertiesThreshold.
	 * 
	 * @param task
	 * @return
	 */
	public abstract List<AssigneeExpertise> getRecommendedAssignees(Task task);

	public int getMaxNumOfAssignees() {
		return maxNumOfAssignees;
	}

	public double getExpertiseThreshold() {
		return expertiseThreshold;
	}
}

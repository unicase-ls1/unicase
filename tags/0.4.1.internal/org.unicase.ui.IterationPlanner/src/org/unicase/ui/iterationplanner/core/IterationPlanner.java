/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.iterationplanner.core;

import java.util.List;

import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkPackage;

/**
 * Iteration planner.
 * 
 * @author hodaie
 * 
 */
public class IterationPlanner {

	private WorkPackage backLog;
	private WorkPackage lastSprint;
	private int numOfSprintsToPlan;
	private List<FunctionalRequirement> requirements;

	/**
	 * @param backLog
	 *            the backLog to set
	 */
	public void setBackLog(WorkPackage backLog) {
		this.backLog = backLog;
	}

	/**
	 * @return the backLog
	 */
	public WorkPackage getBackLog() {
		return backLog;
	}

	/**
	 * @param lastSprint
	 *            the lastSprint to set
	 */
	public void setLastSprint(WorkPackage lastSprint) {
		this.lastSprint = lastSprint;
	}

	/**
	 * @return the lastSprint
	 */
	public WorkPackage getLastSprint() {
		return lastSprint;
	}

	/**
	 * How many sprints should be planned.
	 * 
	 * @param sprintsToPlan
	 *            number of sprints to plan.
	 */
	public void setNumOfSprintsToPlan(int sprintsToPlan) {
		this.setNumOfSprintsToPlan(sprintsToPlan);

	}

	/**
	 * @return the numOfSprintsToPlan
	 */
	public int getNumOfSprintsToPlan() {
		return numOfSprintsToPlan;
	}

	/**
	 * 
	 * @param requirements
	 *            a set of functional requirements to be implemented in sprints.
	 */
	public void setRequirements(List<FunctionalRequirement> requirements) {
		this.requirements = requirements;
	}

	/**
	 * 
	 * @return set of functional requirements to be implemented in sprints.
	 */
	public List<FunctionalRequirement> getRequirements() {
		return requirements;
	}

}

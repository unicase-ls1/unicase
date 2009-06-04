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

	private List<WorkPackage> workPackages;
	private List<FunctionalRequirement> requirements;
	private int sprintDuration;
	private String sprintName;

	


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

	

	/**
	 * 
	 * @param sprintName sprint name 
	 */
	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}
	
	
	/**
	 * 
	 * @return sprint name
	 */
	public String getSprintName(){
		return sprintName;
	}

	/**
	 * @param sprintDuration the sprintDuration to set
	 */
	public void setSprintDuration(int sprintDuration) {
		this.sprintDuration = sprintDuration;
	}

	/**
	 * @return the sprintDuration
	 */
	public int getSprintDuration() {
		return sprintDuration;
	}

	/**
	 * @param workPackages the workPackages to set
	 */
	public void setWorkPackages(List<WorkPackage> workPackages) {
		this.workPackages = workPackages;
	}

	/**
	 * @return the workPackages
	 */
	public List<WorkPackage> getWorkPackages() {
		return workPackages;
	}

}

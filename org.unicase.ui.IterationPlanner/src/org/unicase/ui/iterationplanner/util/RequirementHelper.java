/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.util;

import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.ui.iterationplanner.IterationPlannerManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hodaie
 */
public class RequirementHelper {

	private List<FunctionalRequirement> requirements;

	/**
	 * Constructor.
	 * 
	 * @param iterationPlannerManager iteration planning manager
	 */
	public RequirementHelper(IterationPlannerManager iterationPlannerManager) {}

	/**
	 * Constructor.
	 * 
	 * @param iterationPlannerManager iteration planning manager
	 * @param reqs input requirement
	 */
	public RequirementHelper(IterationPlannerManager iterationPlannerManager, List<FunctionalRequirement> reqs) {
		this.requirements = reqs;
	}

	/**
	 * @return set of functional requirements to be implemented in sprints.
	 */
	public List<FunctionalRequirement> getRequirements() {
		if (requirements == null) {
			requirements = new ArrayList<FunctionalRequirement>();
		}
		return requirements;
	}

	/**
	 * tmp.
	 * 
	 * @param reqs functional requirements
	 */
	public void setRequirements(List<FunctionalRequirement> reqs) {
		this.requirements = reqs;
	}

	/**
	 * getAllRefiningRequirements recursive.
	 * 
	 * @param req req.
	 * @return getAllRefiningRequirements recursive.
	 */
	public static List<FunctionalRequirement> getAllRefiningRequirements(FunctionalRequirement req) {
		List<FunctionalRequirement> result = new ArrayList<FunctionalRequirement>();
		for (FunctionalRequirement fr : req.getRefiningRequirements()) {
			result.add(fr);
			result.addAll(getAllRefiningRequirements(fr));
		}
		return result;
	}
}

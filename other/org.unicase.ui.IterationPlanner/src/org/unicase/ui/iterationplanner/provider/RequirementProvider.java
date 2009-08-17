/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.provider;

import java.util.ArrayList;
import java.util.List;

import org.unicase.model.requirement.FunctionalRequirement;

/**
 * 
 * @author hodaie
 *
 */
public class RequirementProvider {

	
	private List<FunctionalRequirement> requirements;


	/**
	 * Constructor.
	 */
	public RequirementProvider(){
		
	}
	
	
	/**
	 * Constructor.
	 * @param reqs input requirement
	 */
	public RequirementProvider(List<FunctionalRequirement> reqs){
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
	 * @param reqs functional requirements
	 */
	public void setRequirements(List<FunctionalRequirement> reqs) {
		this.requirements = reqs;
	}
}

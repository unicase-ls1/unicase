/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview.roles;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.danger.Danger;
import org.unicase.model.urml.goal.Goal;
import org.unicase.model.urml.requirement.Requirement;

/**
 * The class represents the safety engineer role for the stakeholder view.
 * 
 * @author kterzieva
 * 
 */

public class SafetyEngineerRole extends StakeholderRole{

	@Override
	public ViewerFilter getViewerFilter() {
		return new SaftyEngineerFilter();
	}
	
	/**
	 * The filter to safety engineer role.
	 * 
	 * @author kterzieva
	 * 
	 */
	
	class SaftyEngineerFilter extends ViewerFilter{

		@Override
		public boolean select(Viewer viewer, Object parentElement,
				Object element) {
			
			if(element instanceof UrmlModelElement){
				if(	element instanceof Goal ||
					element instanceof Requirement ||
					element instanceof Danger){
					return true;
				}
				return false;
			}
			return true;
		}
		
	}

}

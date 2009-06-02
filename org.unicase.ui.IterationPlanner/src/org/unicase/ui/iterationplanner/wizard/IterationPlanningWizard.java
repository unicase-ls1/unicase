/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.iterationplanner.wizard;

import org.eclipse.jface.wizard.Wizard;
import org.unicase.ui.iterationplanner.core.IterationPlanner;

/**
 * @author Hodaie
 *
 */
public class IterationPlanningWizard extends Wizard {

	
	
	
	
	private IterationPlanner iterationPlanner;

	/**
	 * Constructor.
	 */
	public IterationPlanningWizard() {

		iterationPlanner = new IterationPlanner();
	  
	
	}
	
	
	/**
	 *  {@inheritDoc}
	 *  
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		//first page: select last sprint, select backlog,
		TaskPage tasksPage = new TaskPage(iterationPlanner);
		addPage(tasksPage);
		
		
		//second page: select participants
		RequirementsPage requirementsPage = new RequirementsPage(iterationPlanner);
		addPage(requirementsPage);
		
		
		//third page: set sprint attributes, name, duration, estimate
		
		//fourth page: show plans in a table tree viewer
		
		
	}

	
	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public boolean performFinish() {
		
		return false;
	}

}

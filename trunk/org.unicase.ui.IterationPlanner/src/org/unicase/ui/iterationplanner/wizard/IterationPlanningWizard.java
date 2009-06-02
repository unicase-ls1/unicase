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
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		// 1. page: set sprint attributes, name, duration, estimate
		SprintAttributesPage sprintAttributesPage = new SprintAttributesPage(
				iterationPlanner);
		addPage(sprintAttributesPage);

		// 2. page: select last sprint, select backlog,
		TaskPage tasksPage = new TaskPage(iterationPlanner);
		addPage(tasksPage);

		// 3. page: select participants
		RequirementsPage requirementsPage = new RequirementsPage(
				iterationPlanner);
		addPage(requirementsPage);

		// 4. page: show plans in a table tree viewer
		PlansPage plansPage = new PlansPage(iterationPlanner);
		addPage(plansPage);

	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public boolean performFinish() {

		return false;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		return getContainer().getCurrentPage() instanceof PlansPage;
	}

}

/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.wizard;

import org.eclipse.jface.wizard.Wizard;
import org.unicase.ui.iterationplanner.IterationPlannerManager;

/**
 * @author Hodaie
 */
public class IterationPlanningWizard extends Wizard {

	@SuppressWarnings("unused")
	private IterationPlannerManager iterationPlanner;

	/**
	 * Constructor.
	 */
	public IterationPlanningWizard() {

		iterationPlanner = new IterationPlannerManager();

	}

	@Override
	public boolean performFinish() {
		return false;
	}

}

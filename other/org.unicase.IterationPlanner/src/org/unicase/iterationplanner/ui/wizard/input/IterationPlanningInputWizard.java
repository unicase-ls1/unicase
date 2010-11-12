/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.iterationplanner.ui.wizard.input;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

/**
 * @author Hodaie
 */
public class IterationPlanningInputWizard extends Wizard {

	/**
	 * Constructor.
	 */
	public IterationPlanningInputWizard() {
		setWindowTitle("Define Inputs to Iteration Planning Algorithm");
	}

	@Override
	public void addPages() {
		
		AbstractInputPage defineReqsPage = new DefineRequirementsPage("defineRequirementsPage");
		AbstractInputPage defineTasksPage = new DefineTasksPage("defineTasksPage");
		AbstractInputPage defineAssigneesPage = new DefineAssigneesPage("defineAssigneesPage");
		WizardPage definePlannerParametersPage = new DefinePlannerParametersPage("definePlannerParametersPage");
		addPage(defineReqsPage);
		addPage(defineTasksPage);
		addPage(defineAssigneesPage);
		addPage(definePlannerParametersPage);
	}

	@Override
	public boolean performFinish() {
		return true;
	}

}

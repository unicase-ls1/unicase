/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.iterationplanner.wizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.unicase.ui.iterationplanner.core.IterationPlanner;

/**
 * In this page we can select requirements which should be implemented in this
 * sprint.
 * 
 * @author hodaie
 * 
 */
public class RequirementsPage extends WizardPage {

	private IterationPlanner iterationPlanner;

	/**
	 * Constructor.
	 * 
	 * @param planner
	 *            iteration planner
	 */
	RequirementsPage(IterationPlanner planner) {
		super("requirements page");
		this.iterationPlanner = planner;

	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {

	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		iterationPlanner.setRequirements(null);
		return super.getNextPage();
	}

	/**
	 * 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		return super.canFlipToNextPage();
	}

}

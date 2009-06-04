/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.iterationplanner.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.ui.iterationplanner.core.IterationPlanner;

/**
 * 
 * @author hodaie
 * 
 */
public class PlansPage extends WizardPage {

	private IterationPlanner iterationPlanner;

	/**
	 * Constructor.
	 * 
	 * @param planner
	 *            iteration planner
	 */
	public PlansPage(IterationPlanner planner) {
		super("plans page");
		this.iterationPlanner = planner;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		setControl(contents);
		setPageComplete(true);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
	 */
	@Override
	public boolean isPageComplete() {
		iterationPlanner.getSprint().setName("aaa");
		return true;
	}

}

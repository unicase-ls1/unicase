/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.iterationplanner.wizard;


import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
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
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayout(new GridLayout());
		
		Label lblReq = new Label(contents, SWT.NONE);
		lblReq.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		lblReq.setText("Select requirements which should be implemented in this sprint:");
		
		
		CheckboxTreeViewer treeViewer = new CheckboxTreeViewer(contents, SWT.NONE);
		
		
		
		
		setControl(contents);
		setPageComplete(true);		
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

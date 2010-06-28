/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */


package org.unicase.ui.refactoring.strategies.dialogs.impl;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.ui.meeditor.mecontrols.MEEnumControl;
import org.unicase.ui.refactoring.strategies.dialogs.AbstractTitleAreaRefactoringDialog;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;
import org.unicase.ui.validation.refactoring.strategy.RefactoringStrategy;

/**
 * @author pfeifferc
 */
public class ActivityNotSetRefactoringDialog extends
		AbstractTitleAreaRefactoringDialog {

	/**
	 * @param parentShell the
	 * @param abstractRefactoringStrategy the
	 */
	public ActivityNotSetRefactoringDialog(Shell parentShell,
			RefactoringStrategy abstractRefactoringStrategy) {
		super(parentShell, abstractRefactoringStrategy);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// set message here, since otherwise it is either disposed or null
		setTitle("Please assign an activity to the action item");
		setMessage("An activity has not been set yet. Please assign an activity now.");
		// reusable variables
		Composite composite;
		// create body composite as base for the other composites
		Composite body = getRefactoringDialogHelper().createBodyComposite(parent);
		// refactoringDialogHelper.create affected model element composite
		getRefactoringDialogHelper().createModelElementInformationWithDescriptionComposite(body, getInvalidModelElement());
		// refactoringDialogHelper.create separator
		getRefactoringDialogHelper().createSeparator(body);
		// create the composite to put the widgets on
		composite = getRefactoringDialogHelper().createComposite(body, SWT.NONE, new GridLayout(3, false), new GridData(SWT.FILL, SWT.FILL, true,
				true));
		// create link icon
		getRefactoringDialogHelper().createIconLabel(composite, "cog.png");
		// create text for work package
		getRefactoringDialogHelper().createText(composite, "Activity:");
		// create link for work package
		getRefactoringDialogHelper().createMEControl(new MEEnumControl(), composite, getInvalidModelElement(), "activity");
		// create the remaining dialog area
		return super.createDialogArea(parent);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void performFinish() {
		setRefactoringResult(RefactoringResult.SUCCESS_CREATE);
	}
}

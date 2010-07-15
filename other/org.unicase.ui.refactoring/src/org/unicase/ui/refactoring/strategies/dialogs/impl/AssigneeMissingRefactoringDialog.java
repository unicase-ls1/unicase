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
import org.unicase.ui.refactoring.strategies.AbstractRefactoringStrategy;
import org.unicase.ui.refactoring.strategies.dialogs.AbstractTitleAreaRefactoringDialog;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.util.controls.MESingeLinkControlWithoutNewReferenceAction;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;

/**
 * @author pfeifferc
 */
public class AssigneeMissingRefactoringDialog extends
		AbstractTitleAreaRefactoringDialog {

	/**
	 * @param parentShell the
	 * @param abstractRefactoringStrategy the
	 */
	public AssigneeMissingRefactoringDialog(Shell parentShell,
			AbstractRefactoringStrategy abstractRefactoringStrategy) {
		super(parentShell, abstractRefactoringStrategy);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// set message here, since otherwise it is either disposed or null
		setTitle("Please assign a user to the action item");
		setMessage("An assigne has not been set yet. Please do so now.");
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
		getRefactoringDialogHelper().createIconLabel(composite, "filtertouser.png");
		// create text for work package
		getRefactoringDialogHelper().createText(composite, "Assignee:");
		// create link for work package
		getRefactoringDialogHelper().createMEControl(new MESingeLinkControlWithoutNewReferenceAction(), composite, getInvalidModelElement(), "assignee");
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
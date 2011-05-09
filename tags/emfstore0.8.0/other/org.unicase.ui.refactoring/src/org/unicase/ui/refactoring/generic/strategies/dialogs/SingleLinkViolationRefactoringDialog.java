/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.generic.strategies.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.refactoring.templates.UnicaseRefactoringStrategy;
import org.unicase.ui.refactoring.templates.dialogs.AbstractTitleAreaRefactoringDialog;
import org.unicase.ui.refactoring.templates.util.MESingeLinkControlWithoutNewReferenceAction;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * @author pfeifferc
 */
public class SingleLinkViolationRefactoringDialog extends AbstractTitleAreaRefactoringDialog {

	/**
	 * @param parentShell the
	 * @param unicaseRefactoringStrategy the
	 */
	public SingleLinkViolationRefactoringDialog(Shell parentShell,
			UnicaseRefactoringStrategy unicaseRefactoringStrategy) {
		super(parentShell, unicaseRefactoringStrategy);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// reusable variables
		Composite composite;
		// create body composite as base for the other composites
		Composite body = getRefactoringDialogHelper().createBodyComposite(parent);
		// refactoringDialogHelper.create affected model element composite
		getRefactoringDialogHelper().createModelElementInformationWithDescriptionComposite(body,(UnicaseModelElement) getInvalidEObject());
		// refactoringDialogHelper.create separator
		getRefactoringDialogHelper().createSeparator(body);
		// create the composite to put the widgets on
		composite = getRefactoringDialogHelper().createComposite(body, SWT.NONE, new GridLayout(3, false), new GridData(SWT.FILL, SWT.FILL, true,
				true));
		// create link icon
		getRefactoringDialogHelper().createIconLabel(composite, "link.png");
		// create text for work package
		getRefactoringDialogHelper().createText(composite, "Set new reference");
		// create link for work package
		getRefactoringDialogHelper().createMEControl(new MESingeLinkControlWithoutNewReferenceAction(), composite, 
				(UnicaseModelElement) getInvalidEObject(), getAbstractRefactoringStrategy().getFirstInvalidStructuralFeature().getName());
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
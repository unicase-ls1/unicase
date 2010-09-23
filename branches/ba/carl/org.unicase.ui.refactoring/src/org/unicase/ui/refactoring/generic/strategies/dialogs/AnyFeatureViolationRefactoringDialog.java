/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.generic.strategies.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.refactoring.templates.AbstractRefactoringStrategy;
import org.unicase.ui.refactoring.templates.dialogs.AbstractTitleAreaRefactoringDialog;
import org.unicase.ui.refactoring.templates.util.RefactoringDialogHelper;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * @author pfeifferc
 */
public class AnyFeatureViolationRefactoringDialog extends AbstractTitleAreaRefactoringDialog {

	/**
	 * @param parentShell the
	 * @param abstractRefactoringStrategy the
	 */
	public AnyFeatureViolationRefactoringDialog(Shell parentShell,
			AbstractRefactoringStrategy abstractRefactoringStrategy) {
		super(parentShell, abstractRefactoringStrategy);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(500, 500);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createHelpControl(Composite parent) {
		return parent;
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
		composite = getRefactoringDialogHelper().createComposite(body, SWT.NONE, new GridLayout(1, false), new GridData(SWT.FILL, SWT.FILL, true,
				true));
		// create control
		AbstractMEControl meControl = RefactoringDialogHelper.getMEControl(getInvalidEObject(), getAbstractRefactoringStrategy().getInvalidStructuralFeature());
		// create text
		if(meControl == null) {
			getRefactoringDialogHelper().createText(composite, "There are no editor parts registered for this feature.");
		} else {
			getRefactoringDialogHelper().createText(composite, "Please set a valid value or reference:");
			// create me control
			getRefactoringDialogHelper().createMEControl(meControl, composite, 
					(UnicaseModelElement) getInvalidEObject(), getAbstractRefactoringStrategy().getInvalidStructuralFeature().getName());
		}
		// create the remaining dialog area
		return parent;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void performFinish() {
		setRefactoringResult(RefactoringResult.SUCCESS_CREATE);
	}
}
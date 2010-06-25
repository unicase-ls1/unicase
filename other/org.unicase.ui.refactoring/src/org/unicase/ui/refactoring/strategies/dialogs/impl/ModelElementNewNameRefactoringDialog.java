/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.impl;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.refactoring.strategies.dialogs.AbstractRefactoringDialog;
import org.unicase.ui.refactoring.strategies.dialogs.AbstractRefactoringInputDialog;
import org.unicase.ui.validation.refactoring.strategy.AbstractRefactoringStrategy;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * The model element new name refactoring dialog.
 * 
 * @author pfeifferc
 */
public class ModelElementNewNameRefactoringDialog extends AbstractRefactoringInputDialog implements AbstractRefactoringDialog {

	private UnicaseModelElement unicaseModelElement;
	private Button button;

	/**
	 * @param parentShell the
	 * @param abstractRefactoringStrategy the
	 * @param dialogTitle the
	 * @param dialogMessage the
	 * @param initialValue the
	 * @param validator the
	 */
	public ModelElementNewNameRefactoringDialog(Shell parentShell,
			AbstractRefactoringStrategy abstractRefactoringStrategy,
			String dialogTitle, String dialogMessage, String initialValue,
			IInputValidator validator) {
		super(parentShell, abstractRefactoringStrategy, dialogTitle, dialogMessage,
				initialValue, validator);
		unicaseModelElement = (UnicaseModelElement) getAbstractRefactoringStrategy().getInvalidModelElement();
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
		getRefactoringDialogHelper().createModelElementInformationWithDescriptionComposite(body, unicaseModelElement);
		// refactoringDialogHelper.create separator
		getRefactoringDialogHelper().createSeparator(body);
		// refactoringDialogHelper.create instruction text composite
		getRefactoringDialogHelper().createExplanatoryTextComposite(body, "Please specify the new name.", "exclamation.png");
		// create the composite to put the widgets on
		composite = getRefactoringDialogHelper().createComposite(body, SWT.NONE, new GridLayout(1, false), new GridData(SWT.FILL, SWT.FILL, true,
				true));
		button = new Button(composite, SWT.CHECK);
		button.setSelection(false);
		button.setText("Delete the model element instead.");
		button.addSelectionListener(new DeleteButtonSelectionListener());
		// create the remaining dialog area
		return super.createDialogArea(parent);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void performFinish() {
		new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				if(button.getSelection()) {
					getInvalidModelElement().delete();
				} else {
					getInvalidModelElement().setName(getValue());
				}
			}
		}.run();
		setRefactoringResult(RefactoringResult.SUCCESS_CREATE);
	}

	/**
	 * @author pfeifferc
	 */
	private final class DeleteButtonSelectionListener implements
			SelectionListener {
		
		public void widgetSelected(SelectionEvent e) {
			getText().setEnabled(!button.getSelection());
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do here
		}
	}
}

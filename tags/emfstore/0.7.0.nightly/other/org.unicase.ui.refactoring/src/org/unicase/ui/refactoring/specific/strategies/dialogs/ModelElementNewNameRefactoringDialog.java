/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.specific.strategies.dialogs;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.refactoring.templates.UnicaseRefactoringStrategy;
import org.unicase.ui.refactoring.templates.dialogs.AbstractRefactoringDialog;
import org.unicase.ui.refactoring.templates.dialogs.AbstractRefactoringInputDialog;
import org.unicase.ui.validation.refactoring.RefactoringResult;
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
	 * @param unicaseRefactoringStrategy the
	 * @param dialogTitle the
	 * @param dialogMessage the
	 * @param initialValue the
	 * @param validator the
	 */
	public ModelElementNewNameRefactoringDialog(Shell parentShell,
			UnicaseRefactoringStrategy unicaseRefactoringStrategy,
			String dialogTitle, String dialogMessage, String initialValue,
			IInputValidator validator) {
		super(parentShell, unicaseRefactoringStrategy, dialogTitle, dialogMessage,
				initialValue, validator);
		unicaseModelElement = (UnicaseModelElement) getAbstractRefactoringStrategy().getInvalidEObject();
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
		// create delete button
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
				UnicaseModelElement invalidModelElement = (UnicaseModelElement) getAbstractRefactoringStrategy().getInvalidEObject();
				if(button.getSelection()) {
					boolean delete = true;
					if(!ModelUtil.getAllContainedModelElements(invalidModelElement, false).isEmpty()) {
						delete = MessageDialog.openQuestion(getShell(), "Do you really wish to delete the element?", 
						"The model element contains at least one other model element, which will be deleted, too. Would you like to continue anyway?");
					}
					if(delete) {
						ModelUtil.removeModelElementAndChildrenFromResource(invalidModelElement);
						setRefactoringResult(RefactoringResult.SUCCESS_CREATE);
					} else {
						setRefactoringResult(RefactoringResult.ABORT);
					}
				} else {
					invalidModelElement.setName(getValue());
					setRefactoringResult(RefactoringResult.SUCCESS_CREATE);
				}
			}
		}.run();
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
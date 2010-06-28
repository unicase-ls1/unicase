/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.impl;

import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.metamodel.Project;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.meeditor.mecontrols.METextControl;
import org.unicase.ui.refactoring.strategies.dialogs.AbstractElementListSelectionRefactoringDialog;
import org.unicase.ui.refactoring.strategies.dialogs.util.RefactoringDialogHelper;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.util.controls.MERichTextControlWithoutToolbar;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;
import org.unicase.ui.validation.refactoring.strategy.RefactoringStrategy;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author pfeifferc
 */
public class ActionItemNotInWorkPackageRefactoringDialog extends AbstractElementListSelectionRefactoringDialog {

	private Composite body;
	
	private Composite right;

	private WorkPackage workPackage;

	private Composite compositeRight;

	/**
	 * @param parent the
	 * @param abstractRefactoringStrategy the
	 */
	public ActionItemNotInWorkPackageRefactoringDialog(Shell parent,
			RefactoringStrategy abstractRefactoringStrategy) {
		super(parent, abstractRefactoringStrategy, RefactoringDialogHelper.getLabelProvider());
		// set functional requirements as dialog elements
		EList<WorkPackage> workPackages = new BasicEList<WorkPackage>();
		Project project = WorkspaceManager.getProjectSpace(getInvalidModelElement()).getProject();
		project.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkPackage(), workPackages);
		Vector<WorkPackage> vector = new Vector<WorkPackage>();
		for(WorkPackage workPackage : workPackages) {
			vector.add(workPackage);
		}
		setElements(vector.toArray());
		setMultipleSelection(false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// set message here, since otherwise it is either disposed or null
		setMessage("A containing work package has not been set yet. Please set one now.");
		setTitle("Test");
		// reusable variables
		Composite composite;
		body = getRefactoringDialogHelper().createBodyComposite(parent);
		// create affected model element composite
		getRefactoringDialogHelper().createModelElementInformationWithDescriptionComposite(body, getInvalidModelElement());
		// create separator
		getRefactoringDialogHelper().createSeparator(body);
		// standard layout used by dialogue area
		GridLayout layout = new GridLayout();
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		// create the composite for the two column layout to put the widgets on
		composite = getRefactoringDialogHelper().createComposite(body, SWT.TOP, new GridLayout(2, true), new GridData(SWT.FILL, SWT.TOP, true,
				false));
		// create left column composite
		Composite left = getRefactoringDialogHelper().createComposite(composite, SWT.TOP, new GridLayout(1, false), new GridData(SWT.FILL, SWT.TOP, true,
				false));
		// create the dialog area
		super.createDialogArea(left);
		// create the right column composite
		right = getRefactoringDialogHelper().createComposite(composite, SWT.TOP, new GridLayout(1, false), new GridData(SWT.FILL, SWT.TOP, true,
				false));
		if(workPackage != null) {
			updateWidgets();
		}
		// return the parent
		return parent;
	}

	private void updateWidgets() {
		// dispose out-dated elements
		if(compositeRight != null) {
			getRefactoringDialogHelper().disposeMEControls();
			compositeRight.dispose();
		}
		compositeRight = getRefactoringDialogHelper().createComposite(right, SWT.FILL, new GridLayout(2, false), new GridData(SWT.FILL, SWT.FILL, true,
				true));
		// create pencil icon
		getRefactoringDialogHelper().createIconLabel(compositeRight, "pencil.png");
		// create text for new requirement name
		getRefactoringDialogHelper().createText(compositeRight, "Name:");
		// create input field for new requirement name
		getRefactoringDialogHelper().createIconLabel(compositeRight);
		getRefactoringDialogHelper().createMEControl(new METextControl(), compositeRight, workPackage, "name");
		// create pencil icon
		getRefactoringDialogHelper().createIconLabel(compositeRight, "pencil.png");
		// create text for new requirement description
		getRefactoringDialogHelper().createText(compositeRight, "Description:");
		// create input field for new requirement description
		getRefactoringDialogHelper().createIconLabel(compositeRight);
		getRefactoringDialogHelper().createMEControl(new MERichTextControlWithoutToolbar(), compositeRight, workPackage, "description");
		// update layout
		compositeRight.layout(true);
		body.layout(true, true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handleSelectionChanged() {
		if(getSelectedElements().length > 0) {
			workPackage = (WorkPackage) getSelectedElements()[0];
			updateWidgets();
		}
		super.handleSelectionChanged();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void performFinish() {
		new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				ActionItem actionItem = (ActionItem) getInvalidModelElement();
				actionItem.setContainingWorkpackage(workPackage);
			}
		}.run();
		setRefactoringResult(RefactoringResult.SUCCESS_CREATE);
	}
}

/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.ui.dialogs.impl;

import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.task.ActionItem;
import org.unicase.ui.refactoring.strategies.AbstractRefactoringStrategy;
import org.unicase.ui.refactoring.ui.dialogs.AbstractElementListSelectionRefactoringDialog;
import org.unicase.ui.refactoring.ui.util.RefactoringDialogHelper;
import org.unicase.ui.validation.refactoring.RefactoringResult;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author pfeifferc
 */
public class ActionItemNotAnnotatedRefactoringDialog extends AbstractElementListSelectionRefactoringDialog {

	/**
	 * @param parent the
	 * @param abstractRefactoringStrategy the
	 */
	public ActionItemNotAnnotatedRefactoringDialog(Shell parent,
			AbstractRefactoringStrategy abstractRefactoringStrategy) {
		super(parent, abstractRefactoringStrategy, RefactoringDialogHelper.getLabelProvider());
		// set functional requirements as dialog elements
		EList<FunctionalRequirement> functionalRequirements = new BasicEList<FunctionalRequirement>();
		Project project = WorkspaceManager.getProjectSpace((UnicaseModelElement) getAbstractRefactoringStrategy().getInvalidEObject()).getProject();
		project.getAllModelElementsbyClass(RequirementPackage.eINSTANCE.getFunctionalRequirement(), functionalRequirements);
		Vector<FunctionalRequirement> vector = new Vector<FunctionalRequirement>();
		for(FunctionalRequirement functionalRequirement : functionalRequirements) {
			vector.add(functionalRequirement);
		}
		setElements(vector.toArray());
	}
	
	/**	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		// reusable variables
		// create body composite as base for the other composites
		Composite body = getRefactoringDialogHelper().createBodyComposite(parent);
		// refactoringDialogHelper.create affected model element composite
		getRefactoringDialogHelper().createModelElementInformationWithDescriptionComposite(body, (UnicaseModelElement) getAbstractRefactoringStrategy().getInvalidEObject());
		// refactoringDialogHelper.create separator
		getRefactoringDialogHelper().createSeparator(body);
		// create the remaining dialog area
		return super.createDialogArea(parent);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void performFinish() {
		if(getSelectedElements() != null && getSelectedElements().length > 0) {
			new UnicaseCommand() {

				@Override
				protected void doRun() {
					((ActionItem) getAbstractRefactoringStrategy().getInvalidEObject()).getAnnotatedModelElements().add((FunctionalRequirement) getSelectedElements()[0]);

				}
			}.run();
		}
		setRefactoringResult(RefactoringResult.SUCCESS_CREATE);
	}
}
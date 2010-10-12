/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.specific.strategies.dialogs;

import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.refactoring.templates.AbstractRefactoringStrategy;
import org.unicase.ui.refactoring.templates.dialogs.AbstractElementListSelectionRefactoringDialog;
import org.unicase.ui.refactoring.templates.util.RefactoringDialogHelper;
import org.unicase.ui.validation.refactoring.RefactoringResult;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author pfeifferc
 */
public class ActionItemMissingWorkPackageRefactoringDialog extends AbstractElementListSelectionRefactoringDialog {

	/**
	 * @param parent the
	 * @param abstractRefactoringStrategy the
	 */
	public ActionItemMissingWorkPackageRefactoringDialog(Shell parent,
			AbstractRefactoringStrategy abstractRefactoringStrategy) {
		super(parent, abstractRefactoringStrategy, RefactoringDialogHelper.getLabelProvider());
		// set functional requirements as dialog elements
		EClass eClass = TaskPackage.eINSTANCE.getWorkPackage();
		EList<ModelElement> elements = new BasicEList<ModelElement>();
		Project project = getAbstractRefactoringStrategy().getProjectSpace().getProject();
		project.getAllModelElementsbyClass(eClass, elements);
		Vector<ModelElement> vector = new Vector<ModelElement>();
		for(ModelElement element : elements) {
			vector.add(element);
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
					((ActionItem) getAbstractRefactoringStrategy().getInvalidEObject()).setContainingWorkpackage((WorkPackage) getSelectedElements()[0]);

				}
			}.run();
		}
		setRefactoringResult(RefactoringResult.SUCCESS_CREATE);
	}
}
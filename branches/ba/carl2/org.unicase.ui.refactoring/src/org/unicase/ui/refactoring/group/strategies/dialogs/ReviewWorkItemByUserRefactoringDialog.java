/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.group.strategies.dialogs;

import java.util.Set;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.swt.widgets.Shell;
import org.unicase.metamodel.Project;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.common.validation.ValidationResultProviderRegistry;
import org.unicase.ui.refactoring.templates.AbstractRefactoringStrategy;
import org.unicase.ui.refactoring.templates.dialogs.AbstractElementListSelectionRefactoringDialog;
import org.unicase.ui.refactoring.templates.util.RefactoringDialogHelper;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * @author pfeifferc
 */
public class ReviewWorkItemByUserRefactoringDialog extends AbstractElementListSelectionRefactoringDialog {

	/**
	 * @param parent the
	 * @param abstractRefactoringStrategy the
	 */
	public ReviewWorkItemByUserRefactoringDialog(Shell parent,
			AbstractRefactoringStrategy abstractRefactoringStrategy) {
		super(parent, abstractRefactoringStrategy, RefactoringDialogHelper.getLabelProvider());
		// set functional requirements as dialog elements
		EList<User> users = new BasicEList<User>();
		Project project = getAbstractRefactoringStrategy().getProjectSpace().getProject();
		project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(), users);
		Vector<User> vector = new Vector<User>();
		for(User user : users) {
			vector.add(user);
		}
		setElements(vector.toArray());
		setMultipleSelection(false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void performFinish() {
		if(getSelectedElements().length > 0) {
			User user = (User) getSelectedElements()[0];
			EObject invalidEObject = getAbstractRefactoringStrategy().getInvalidEObject();
			Set<IConstraintStatus> violations = ValidationResultProviderRegistry.getInstance().
			getValidationResultProvider(invalidEObject).getViolationsRecursively(invalidEObject);
			for(IConstraintStatus constraintStatus : violations) {
				EObject target = constraintStatus.getTarget();
				if(target instanceof WorkItem) {
					WorkItem workItem = (WorkItem) target;
					if(workItem.getReviewer() == null) {
						workItem.setReviewer(user);
					}
				}
			}
		}
		setRefactoringResult(RefactoringResult.SUCCESS_CREATE);
	}
}
/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.group.strategies;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.validation.model.IConstraintStatus;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.common.validation.ValidationResultProviderRegistry;
import org.unicase.ui.refactoring.templates.UnicaseRefactoringStrategy;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * Deletes model elements with default names.
 * 
 * @author pfeifferc
 */
public class DeleteDefaultNameElementsRefactoringStrategy extends UnicaseRefactoringStrategy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RefactoringResult performRefactoring() {
		Set<IConstraintStatus> violations = ValidationResultProviderRegistry.getInstance().getValidationResultProvider(getInvalidEObject()).getViolationsRecursively(getInvalidEObject());
		Set<UnicaseModelElement> toDelete = new HashSet<UnicaseModelElement>();
		for(IConstraintStatus constraintStatus : violations) {
			if(constraintStatus.getConstraint().getDescriptor().getId().equals("org.unicase.model.validation.ModelElementNewNameConstraint")) {
				toDelete.add((UnicaseModelElement) constraintStatus.getTarget());
			}
		}
		for(UnicaseModelElement modelElement : toDelete) {
			ModelUtil.removeModelElementAndChildrenFromResource(modelElement);
		}
		return RefactoringResult.SUCCESS_CREATE;
	}
}
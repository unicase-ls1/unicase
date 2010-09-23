/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.group.strategies;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.validation.model.IConstraintStatus;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.validation.ValidationResultProviderRegistry;
import org.unicase.ui.refactoring.templates.AbstractRefactoringStrategy;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * Deletes model elements with default names.
 * 
 * @author pfeifferc
 */
public class DeleteDefaultNameElementsRefactoringStrategy extends AbstractRefactoringStrategy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RefactoringResult performRefactoring() {
		Set<IConstraintStatus> violations = ValidationResultProviderRegistry.getInstance().getValidationResultProvider(getInvalidEObject()).getViolationsRecursively(getInvalidEObject());
		Set<ModelElement> toDelete = new HashSet<ModelElement>();
		for(IConstraintStatus constraintStatus : violations) {
			if(constraintStatus.getConstraint().getDescriptor().getId().equals("org.unicase.model.validation.ModelElementNewNameConstraint")) {
				toDelete.add((ModelElement) constraintStatus.getTarget());
			}
		}
		for(ModelElement modelElement : toDelete) {
			if(modelElement.getProject() != null) {
				modelElement.delete();
			}
		}
		return RefactoringResult.SUCCESS_CREATE;
	}
}
/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.conflictDetection;

import java.util.Set;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.ModelElementId;

/**
 * Detects conflicts by single elements.
 * 
 * @author koegel
 */
public class ByModelElementConflictDetectionStrategy implements ConflictDetectionStrategy {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.conflictDetection.ConflictDetectionStrategy#doConflict(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation,
	 *      org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public boolean doConflict(AbstractOperation operationA, AbstractOperation operationB) {
		Set<ModelElementId> allInvolvedModelElementsA = operationA.getAllInvolvedModelElements();
		Set<ModelElementId> allInvolvedModelElementsB = operationB.getAllInvolvedModelElements();
		return allInvolvedModelElementsA.removeAll(allInvolvedModelElementsB);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.conflictDetection.ConflictDetectionStrategy#isRequired(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation,
	 *      org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public boolean isRequired(AbstractOperation requiredOperation, AbstractOperation operation) {
		return this.doConflict(requiredOperation, operation);
	}
}

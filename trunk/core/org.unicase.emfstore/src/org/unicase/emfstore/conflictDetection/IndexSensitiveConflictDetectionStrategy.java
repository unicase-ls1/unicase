/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.conflictDetection;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation;
import org.unicase.emfstore.esmodel.versioning.operations.util.OperationInfo;

/**
 * A conflict detection strategy that will operate on a per attribute and feature level.
 * 
 * @author koegel
 */
public class IndexSensitiveConflictDetectionStrategy implements ConflictDetectionStrategy {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.conflictDetection.ConflictDetectionStrategy#doConflict(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation,
	 *      org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public boolean doConflict(AbstractOperation operationA, AbstractOperation operationB) {
		return doConflictHard(operationA, operationB) || doConflictIndexIntegrity(operationA, operationB);
	}

	private boolean doConflictHard(AbstractOperation operationA, AbstractOperation operationB) {

		// handle hard conflicts, same feature is changed by A and by B on same element
		if (operationA instanceof FeatureOperation && operationB instanceof FeatureOperation) {
			FeatureOperation opA = (FeatureOperation) operationA;
			FeatureOperation opB = (FeatureOperation) operationB;
			if (OperationInfo.changesModelElementFeature(opB, opA.getModelElementId(), opA.getFeatureName())) {
				return true;
			}
		}

		return false;
	}

	private boolean doConflictIndexIntegrity(AbstractOperation operationA, AbstractOperation operationB) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.conflictDetection.ConflictDetectionStrategy#isRequired(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation,
	 *      org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public boolean isRequired(AbstractOperation operationA, AbstractOperation operationB) {
		return isRequiredHard(operationA, operationB) || isRequiredIndexIntegrity(operationA, operationB);
	}

	private boolean isRequiredHard(AbstractOperation requiredOperation, AbstractOperation operation) {
		return false;
	}

	private boolean isRequiredIndexIntegrity(AbstractOperation requiredOperation, AbstractOperation operation) {
		return false;
	}

}

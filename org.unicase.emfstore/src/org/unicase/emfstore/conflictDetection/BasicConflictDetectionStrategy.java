package org.unicase.emfstore.conflictDetection;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * Very basic conflict detection strategy. Will only check if same model element is touched.
 * @author koegel
 *
 */
public class BasicConflictDetectionStrategy implements
		ConflictDetectionStrategy {

	public boolean doConflict(AbstractOperation operationA,
			AbstractOperation operationB) {
		//FIXME MK
		//return operationA.getModelElement().equals(operationB.getModelElement());
		return false;
	}

	public boolean isRequired(AbstractOperation requiredOperation,
			AbstractOperation operation) {
		return doConflict(requiredOperation, operation);
	}
}

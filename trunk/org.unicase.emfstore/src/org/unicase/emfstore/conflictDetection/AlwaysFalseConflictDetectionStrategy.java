package org.unicase.emfstore.conflictDetection;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * This strategy will never detect any conflicts.
 * 
 * @author koegel
 *
 */
public class AlwaysFalseConflictDetectionStrategy implements
		ConflictDetectionStrategy {

	public boolean doConflict(AbstractOperation operationA,
			AbstractOperation operationB) {
		return false;
	}

	public boolean isRequired(AbstractOperation requiredOperation,
			AbstractOperation operation) {
		return false;
	}

}

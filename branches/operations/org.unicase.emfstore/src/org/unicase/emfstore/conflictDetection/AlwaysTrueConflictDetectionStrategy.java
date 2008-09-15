package org.unicase.emfstore.conflictDetection;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * This conflict detection strategy will always detect conflicts.
 * @author koegel
 *
 */
public class AlwaysTrueConflictDetectionStrategy implements
		ConflictDetectionStrategy {

	public boolean doConflict(AbstractOperation operationA,
			AbstractOperation operationB) {
		return true;
	}

	public boolean isRequired(AbstractOperation requiredOperation,
			AbstractOperation operation) {
		return true;
	}

}

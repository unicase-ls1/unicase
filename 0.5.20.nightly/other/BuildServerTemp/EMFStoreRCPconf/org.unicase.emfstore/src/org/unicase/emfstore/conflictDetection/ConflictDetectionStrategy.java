/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.conflictDetection;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * This is the interface for a conflict detection strategy.
 * 
 * @author Maximilian Koegel
 */
public interface ConflictDetectionStrategy {

	/**
	 * Determines weather requiredOperation is required by operation. This means that operation can not be applied
	 * without applying requiredOperation first. Contract: isRequired is a transitive relation. isRequired(A,B)==true &&
	 * isRequired(B,C) => isRequired(A,C)==true
	 * 
	 * @param requiredOperation The operation to be tested if it is required from operation.
	 * @param operation The operation that may require the requiredOperation.
	 * @return true if requiredOperation is required for operation
	 */
	boolean isRequired(AbstractOperation requiredOperation, AbstractOperation operation);

	/**
	 * Determines whether two Operations do conflict with each other. This means that either the result of applying them
	 * depends on the order of applying them or after applying A, B cannot be applied any more or vice versa. Contract:
	 * doConflict is symmetric. doConflict(A,B) <=> doConflict(B,A)
	 * 
	 * @param operationA an operation
	 * @param operationB an other operation
	 * @return true if they do conflict with each other
	 */
	boolean doConflict(AbstractOperation operationA, AbstractOperation operationB);

}

package org.unicase.emfstore.conflictDetection;

/**
* This is the interface for a conflict detection strategy
* 
* Contract: If doConflict returns true for any two operations, one part of
* change package A and one part of change package B, then doConflict on the two
* change packages is also expected to return true. In other words:
* cp_A.getOperations().contains(op_A) AND cp_B.getOperations().contains(op_B)
* AND doConflict(opA, op_B) => doConflict(cp_A, cp_B)
* 
* @author Maximilian Koegel
* 
*/
public interface ConflictDetectionStrategy {

	/**
	 * Determines weather requiredOperation is required by operation. This means
	 * that operation can not be applied without applying requiredOperation
	 * first.
	 * 
	 * @param requiredOperation
	 *            The operation to be tested if it is required from operation.
	 * @param operation
	 *            The operation that may require the requiredOperation.
	 * @return true if requiredOperation is required for operation
	 */
	//boolean isRequired(ESOperation requiredOperation, ESOperation operation);

	/**
	 * Determines whether two Operations do conflict with each other. This means
	 * that either the result of applying them depends on the order of applying
	 * them or after applying A, B cannot be applied any more or vice versa.
	 * 
	 * Contract: doConflict is supposed to be symmetric, meaning doConflict(A,
	 * B) => doConflict(B, A)
	 * 
	 * @param operationA
	 *            an operation
	 * @param operationB
	 *            an other operation
	 * @return true if they do conflict with each other
	 */
	//boolean doConflict(ESOperation operationA, ESOperation operationB);

}


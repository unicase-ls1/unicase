/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.conflictDetection;

import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

/**
 * Conflict Detection Strategy that considers index conflicts as hard conflicts.
 * 
 * @author koegel
 */
public class NonIndexSensitiveConflictDetectionStrategy implements ConflictDetectionStrategy {

	private IndexSensitiveConflictDetectionStrategy indexSensitiveConflictDetectionStrategy;

	/**
	 * Deafault Constructor.
	 */
	public NonIndexSensitiveConflictDetectionStrategy() {
		indexSensitiveConflictDetectionStrategy = new IndexSensitiveConflictDetectionStrategy();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.conflictDetection.ConflictDetectionStrategy#doConflict(org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation,
	 *      org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation)
	 */
	public boolean doConflict(AbstractOperation operationA, AbstractOperation operationB) {
		if (indexSensitiveConflictDetectionStrategy.doConflict(operationA, operationB)) {
			return true;
		}
		return indexSensitiveConflictDetectionStrategy.doConflictIndexIntegrity(operationA, operationB);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.conflictDetection.ConflictDetectionStrategy#isRequired(org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation,
	 *      org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation)
	 */
	public boolean isRequired(AbstractOperation requiredOperation, AbstractOperation operation) {
		return (indexSensitiveConflictDetectionStrategy.isRequired(requiredOperation, operation));
	}

}

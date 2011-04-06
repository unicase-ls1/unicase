/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.conflictDetection;

import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

/**
 * This strategy will never detect any conflicts.
 * 
 * @author koegel
 */
public class AlwaysFalseConflictDetectionStrategy implements ConflictDetectionStrategy {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.conflictDetection.ConflictDetectionStrategy#doConflict(org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation,
	 *      org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation)
	 */
	public boolean doConflict(AbstractOperation operationA, AbstractOperation operationB) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.conflictDetection.ConflictDetectionStrategy#isRequired(org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation,
	 *      org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation)
	 */
	public boolean isRequired(AbstractOperation requiredOperation, AbstractOperation operation) {
		return false;
	}

}

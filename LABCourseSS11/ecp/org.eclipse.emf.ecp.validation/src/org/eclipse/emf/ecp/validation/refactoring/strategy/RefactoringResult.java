/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.validation.refactoring.strategy;

/**
 * Possible refactoring outcomes.
 * 
 * @author pfeifferc
 */
public enum RefactoringResult {

	/**
	 * The refactoring was successful, finish the operation.
	 */
	SUCCESS_CREATE,

	/**
	 * The possible violation was not a violation after all.
	 */
	NO_VIOLATION,

	/**
	 * The refactoring was successful, but do not create any model elements.
	 */
	SUCCESS_UNDO,

	/**
	 * The refactoring was cancelled.
	 */
	ABORT,

}

/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getAtomicOperations <em>Atomic Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getCompositeOperation()
 * @model
 * @generated
 */
public interface CompositeOperation extends AbstractOperation {
	/**
	 * Returns the value of the '<em><b>Atomic Operations</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.emfstore.esmodel.versioning.operations.AtomicOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atomic Operations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atomic Operations</em>' reference list.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getCompositeOperation_AtomicOperations()
	 * @model
	 * @generated
	 */
	EList<AtomicOperation> getAtomicOperations();

} // CompositeOperation

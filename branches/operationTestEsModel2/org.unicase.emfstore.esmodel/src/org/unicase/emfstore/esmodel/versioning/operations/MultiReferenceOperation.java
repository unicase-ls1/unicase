/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Reference Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation#getOldValues <em>Old Values</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation#getNewValues <em>New Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getMultiReferenceOperation()
 * @model
 * @generated
 */
public interface MultiReferenceOperation extends FeatureOperation {
	/**
	 * Returns the value of the '<em><b>Old Values</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Values</em>' reference list.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getMultiReferenceOperation_OldValues()
	 * @model
	 * @generated
	 */
	EList<EObject> getOldValues();

	/**
	 * Returns the value of the '<em><b>New Values</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Values</em>' reference list.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getMultiReferenceOperation_NewValues()
	 * @model
	 * @generated
	 */
	EList<EObject> getNewValues();

} // MultiReferenceOperation

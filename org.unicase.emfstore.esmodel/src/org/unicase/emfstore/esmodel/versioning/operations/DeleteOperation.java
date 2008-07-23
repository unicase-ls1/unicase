/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delete Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.DeleteOperation#getObjectToDelete <em>Object To Delete</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getDeleteOperation()
 * @model
 * @generated
 */
public interface DeleteOperation extends AtomicOperation {
	/**
	 * Returns the value of the '<em><b>Object To Delete</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object To Delete</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object To Delete</em>' reference.
	 * @see #setObjectToDelete(EObject)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getDeleteOperation_ObjectToDelete()
	 * @model
	 * @generated
	 */
	EObject getObjectToDelete();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.DeleteOperation#getObjectToDelete <em>Object To Delete</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object To Delete</em>' reference.
	 * @see #getObjectToDelete()
	 * @generated
	 */
	void setObjectToDelete(EObject value);

} // DeleteOperation

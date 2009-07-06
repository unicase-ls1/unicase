/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.CreateOperation#getObjectToCreate <em>Object To Create</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getCreateOperation()
 * @model
 * @generated
 */
public interface CreateOperation extends AtomicOperation {
	/**
	 * Returns the value of the '<em><b>Object To Create</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object To Create</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object To Create</em>' containment reference.
	 * @see #setObjectToCreate(EObject)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getCreateOperation_ObjectToCreate()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EObject getObjectToCreate();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.CreateOperation#getObjectToCreate <em>Object To Create</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object To Create</em>' containment reference.
	 * @see #getObjectToCreate()
	 * @generated
	 */
	void setObjectToCreate(EObject value);

} // CreateOperation

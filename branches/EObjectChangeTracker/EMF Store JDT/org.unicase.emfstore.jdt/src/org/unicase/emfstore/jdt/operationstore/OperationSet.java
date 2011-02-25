/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.jdt.operationstore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.jdt.operationstore.OperationSet#getBaseVersion <em>Base Version</em>}</li>
 *   <li>{@link org.unicase.emfstore.jdt.operationstore.OperationSet#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.jdt.operationstore.OperationstorePackage#getOperationSet()
 * @model
 * @generated
 */
public interface OperationSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Version</em>' attribute.
	 * @see #setBaseVersion(String)
	 * @see org.unicase.emfstore.jdt.operationstore.OperationstorePackage#getOperationSet_BaseVersion()
	 * @model
	 * @generated
	 */
	String getBaseVersion();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.jdt.operationstore.OperationSet#getBaseVersion <em>Base Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Version</em>' attribute.
	 * @see #getBaseVersion()
	 * @generated
	 */
	void setBaseVersion(String value);

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see org.unicase.emfstore.jdt.operationstore.OperationstorePackage#getOperationSet_Operations()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractOperation> getOperations();

} // OperationSet

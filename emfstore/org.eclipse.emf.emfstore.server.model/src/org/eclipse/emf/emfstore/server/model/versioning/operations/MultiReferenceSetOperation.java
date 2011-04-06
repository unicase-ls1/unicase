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
package org.eclipse.emf.emfstore.server.model.versioning.operations;

import org.eclipse.emf.emfstore.common.model.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Multi Reference Set Operation</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation#getOldValue <em>Old Value</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation#getNewValue <em>New Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getMultiReferenceSetOperation()
 * @model
 * @generated
 */
public interface MultiReferenceSetOperation extends ReferenceOperation {
	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getMultiReferenceSetOperation_Index()
	 * @model
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Old Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Value</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Value</em>' containment reference.
	 * @see #setOldValue(ModelElementId)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getMultiReferenceSetOperation_OldValue()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getOldValue();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation#getOldValue <em>Old Value</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Value</em>' containment reference.
	 * @see #getOldValue()
	 * @generated
	 */
	void setOldValue(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>New Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Value</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Value</em>' containment reference.
	 * @see #setNewValue(ModelElementId)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getMultiReferenceSetOperation_NewValue()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getNewValue();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation#getNewValue <em>New Value</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Value</em>' containment reference.
	 * @see #getNewValue()
	 * @generated
	 */
	void setNewValue(ModelElementId value);

} // MultiReferenceSetOperation

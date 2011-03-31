/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.operations;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Multi Attribute Move Operation</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation#getOldIndex <em>Old Index</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation#getNewIndex <em>New Index</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation#getReferencedValue <em>Referenced Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getMultiAttributeMoveOperation()
 * @model
 * @generated
 */
public interface MultiAttributeMoveOperation extends FeatureOperation {
	/**
	 * Returns the value of the '<em><b>Old Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Index</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Index</em>' attribute.
	 * @see #setOldIndex(int)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getMultiAttributeMoveOperation_OldIndex()
	 * @model
	 * @generated
	 */
	int getOldIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation#getOldIndex <em>Old Index</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Index</em>' attribute.
	 * @see #getOldIndex()
	 * @generated
	 */
	void setOldIndex(int value);

	/**
	 * Returns the value of the '<em><b>New Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Index</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Index</em>' attribute.
	 * @see #setNewIndex(int)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getMultiAttributeMoveOperation_NewIndex()
	 * @model
	 * @generated
	 */
	int getNewIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation#getNewIndex <em>New Index</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Index</em>' attribute.
	 * @see #getNewIndex()
	 * @generated
	 */
	void setNewIndex(int value);

	/**
	 * Returns the value of the '<em><b>Referenced Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Value</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Value</em>' attribute.
	 * @see #setReferencedValue(Object)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getMultiAttributeMoveOperation_ReferencedValue()
	 * @model unique="false"
	 * @generated
	 */
	Object getReferencedValue();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation#getReferencedValue <em>Referenced Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Value</em>' attribute.
	 * @see #getReferencedValue()
	 * @generated
	 */
	void setReferencedValue(Object value);

} // MultiAttributeMoveOperation

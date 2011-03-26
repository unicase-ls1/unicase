/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.versioning.operations;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Multi Attribute Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation#isAdd <em>Add</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation#getIndexes <em>Indexes</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation#getReferencedValues <em>
 * Referenced Values</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getMultiAttributeOperation()
 * @model
 * @generated
 */
public interface MultiAttributeOperation extends FeatureOperation {
	/**
	 * Returns the value of the '<em><b>Add</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Add</em>' attribute.
	 * @see #setAdd(boolean)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getMultiAttributeOperation_Add()
	 * @model
	 * @generated
	 */
	boolean isAdd();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation#isAdd
	 * <em>Add</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Add</em>' attribute.
	 * @see #isAdd()
	 * @generated
	 */
	void setAdd(boolean value);

	/**
	 * Returns the value of the '<em><b>Indexes</b></em>' attribute list. The list contents are of type
	 * {@link java.lang.Integer}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indexes</em>' attribute list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Indexes</em>' attribute list.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getMultiAttributeOperation_Indexes()
	 * @model
	 * @generated
	 */
	EList<Integer> getIndexes();

	/**
	 * Returns the value of the '<em><b>Referenced Values</b></em>' attribute list. The list contents are of type
	 * {@link java.lang.Object}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Values</em>' attribute list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Referenced Values</em>' attribute list.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getMultiAttributeOperation_ReferencedValues()
	 * @model unique="false"
	 * @generated
	 */
	EList<Object> getReferencedValues();

} // MultiAttributeOperation

/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Attribute Operation</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation#getOldValue <em>Old Value</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation#getNewValue <em>New Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getAttributeOperation()
 * @model
 * @generated
 */
public interface AttributeOperation extends FeatureOperation {
	/**
	 * Returns the value of the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Value</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Value</em>' attribute.
	 * @see #setOldValue(Object)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getAttributeOperation_OldValue()
	 * @model
	 * @generated
	 */
	Object getOldValue();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation#getOldValue <em>Old Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Value</em>' attribute.
	 * @see #getOldValue()
	 * @generated
	 */
	void setOldValue(Object value);

	/**
	 * Returns the value of the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Value</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Value</em>' attribute.
	 * @see #setNewValue(Object)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getAttributeOperation_NewValue()
	 * @model
	 * @generated
	 */
	Object getNewValue();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation#getNewValue <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Value</em>' attribute.
	 * @see #getNewValue()
	 * @generated
	 */
	void setNewValue(Object value);

} // AttributeOperation

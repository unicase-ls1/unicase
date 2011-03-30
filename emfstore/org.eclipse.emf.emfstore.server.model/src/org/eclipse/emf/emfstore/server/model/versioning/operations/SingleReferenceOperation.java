/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.versioning.operations;

import org.eclipse.emf.emfstore.common.model.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Single Reference Operation</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation#getOldValue <em>Old Value</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation#getNewValue <em>New Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getSingleReferenceOperation()
 * @model
 * @generated
 */
public interface SingleReferenceOperation extends ReferenceOperation {
	/**
	 * Returns the value of the '<em><b>Old Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Value</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Value</em>' containment reference.
	 * @see #setOldValue(ModelElementId)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getSingleReferenceOperation_OldValue()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getOldValue();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation#getOldValue <em>Old Value</em>}' containment reference.
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
	 * If the meaning of the '<em>New Value</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Value</em>' containment reference.
	 * @see #setNewValue(ModelElementId)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getSingleReferenceOperation_NewValue()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getNewValue();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation#getNewValue <em>New Value</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Value</em>' containment reference.
	 * @see #getNewValue()
	 * @generated
	 */
	void setNewValue(ModelElementId value);

} // SingleReferenceOperation

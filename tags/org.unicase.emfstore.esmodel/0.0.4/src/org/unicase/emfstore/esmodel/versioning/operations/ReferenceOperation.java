/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation#getOldValue <em>Old Value</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation#getNewValue <em>New Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getReferenceOperation()
 * @model
 * @generated
 */
public interface ReferenceOperation extends FeatureOperation {
	/**
	 * Returns the value of the '<em><b>Old Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Value</em>' reference.
	 * @see #setOldValue(ModelElement)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getReferenceOperation_OldValue()
	 * @model
	 * @generated
	 */
	ModelElement getOldValue();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation#getOldValue <em>Old Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Value</em>' reference.
	 * @see #getOldValue()
	 * @generated
	 */
	void setOldValue(ModelElement value);

	/**
	 * Returns the value of the '<em><b>New Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Value</em>' reference.
	 * @see #setNewValue(ModelElement)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getReferenceOperation_NewValue()
	 * @model
	 * @generated
	 */
	ModelElement getNewValue();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation#getNewValue <em>New Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Value</em>' reference.
	 * @see #getNewValue()
	 * @generated
	 */
	void setNewValue(ModelElement value);

} // ReferenceOperation

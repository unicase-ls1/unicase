/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Multi Reference Operation</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation#isAdd <em>Add</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation#getIndex <em>Index</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation#getReferencedModelElements <em>Referenced Model Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getMultiReferenceOperation()
 * @model
 * @generated
 */
public interface MultiReferenceOperation extends ReferenceOperation {
	/**
	 * Returns the value of the '<em><b>Add</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add</em>' attribute.
	 * @see #setAdd(boolean)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getMultiReferenceOperation_Add()
	 * @model
	 * @generated
	 */
	boolean isAdd();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation#isAdd <em>Add</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add</em>' attribute.
	 * @see #isAdd()
	 * @generated
	 */
	void setAdd(boolean value);

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
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getMultiReferenceOperation_Index()
	 * @model
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Referenced Model Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.metamodel.ModelElementId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Model Elements</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Model Elements</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getMultiReferenceOperation_ReferencedModelElements()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ModelElementId> getReferencedModelElements();

} // MultiReferenceOperation

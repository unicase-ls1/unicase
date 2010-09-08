/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import org.unicase.metamodel.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Multi Reference Move Operation</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation#getOldIndex <em>Old Index</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation#getNewIndex <em>New Index</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation#getReferencedModelElementId <em>Referenced Model Element Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getMultiReferenceMoveOperation()
 * @model
 * @generated
 */
public interface MultiReferenceMoveOperation extends FeatureOperation {
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
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getMultiReferenceMoveOperation_OldIndex()
	 * @model
	 * @generated
	 */
	int getOldIndex();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation#getOldIndex <em>Old Index</em>}' attribute.
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
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getMultiReferenceMoveOperation_NewIndex()
	 * @model
	 * @generated
	 */
	int getNewIndex();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation#getNewIndex <em>New Index</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Index</em>' attribute.
	 * @see #getNewIndex()
	 * @generated
	 */
	void setNewIndex(int value);

	/**
	 * Returns the value of the '<em><b>Referenced Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Referenced Model Element Id</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Model Element Id</em>' containment reference.
	 * @see #setReferencedModelElementId(ModelElementId)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getMultiReferenceMoveOperation_ReferencedModelElementId()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getReferencedModelElementId();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation#getReferencedModelElementId <em>Referenced Model Element Id</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Model Element Id</em>' containment reference.
	 * @see #getReferencedModelElementId()
	 * @generated
	 */
	void setReferencedModelElementId(ModelElementId value);

} // MultiReferenceMoveOperation

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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Reference Operation</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation#isBidirectional <em>
 * Bidirectional </em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation#getOppositeFeatureName <em>
 * Opposite Feature Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getReferenceOperation()
 * @model abstract="true"
 * @generated
 */
public interface ReferenceOperation extends FeatureOperation {
	/**
	 * Returns the value of the '<em><b>Bidirectional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bidirectional</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Bidirectional</em>' attribute.
	 * @see #setBidirectional(boolean)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getReferenceOperation_Bidirectional()
	 * @model
	 * @generated
	 */
	boolean isBidirectional();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation#isBidirectional
	 * <em>Bidirectional</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Bidirectional</em>' attribute.
	 * @see #isBidirectional()
	 * @generated
	 */
	void setBidirectional(boolean value);

	/**
	 * Returns the value of the '<em><b>Opposite Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite Feature Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Opposite Feature Name</em>' attribute.
	 * @see #setOppositeFeatureName(String)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getReferenceOperation_OppositeFeatureName()
	 * @model
	 * @generated
	 */
	String getOppositeFeatureName();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation#getOppositeFeatureName
	 * <em>Opposite Feature Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Opposite Feature Name</em>' attribute.
	 * @see #getOppositeFeatureName()
	 * @generated
	 */
	void setOppositeFeatureName(String value);

	/**
	 * Returns the value of the '<em><b>Containment Type</b></em>' attribute.
	 * The literals are from the enumeration
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ContainmentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment Type</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Containment Type</em>' attribute.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.ContainmentType
	 * @see #setContainmentType(ContainmentType)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getReferenceOperation_ContainmentType()
	 * @model
	 * @generated
	 */
	ContainmentType getContainmentType();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation#getContainmentType
	 * <em>Containment Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Containment Type</em>' attribute.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.ContainmentType
	 * @see #getContainmentType()
	 * @generated
	 */
	void setContainmentType(ContainmentType value);

} // ReferenceOperation

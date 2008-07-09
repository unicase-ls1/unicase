/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Kögel
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment.changepackage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ES Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation#getDescription <em>Description</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#getESOperation()
 * @model
 * @generated
 */
public interface ESOperation extends ESAbstractOperation {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#getESOperation_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#getESOperation_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESAbstractOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#getESOperation_Operations()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ESAbstractOperation> getOperations();

} // ESOperation

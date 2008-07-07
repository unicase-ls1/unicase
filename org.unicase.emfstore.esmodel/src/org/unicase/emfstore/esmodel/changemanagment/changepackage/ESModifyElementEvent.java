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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ES Modify Element Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent#getPreviousState <em>Previous State</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent#getSubsequentState <em>Subsequent State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#getESModifyElementEvent()
 * @model
 * @generated
 */
public interface ESModifyElementEvent extends ESEvent {
	/**
	 * Returns the value of the '<em><b>Previous State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Previous State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Previous State</em>' attribute.
	 * @see #setPreviousState(String)
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#getESModifyElementEvent_PreviousState()
	 * @model
	 * @generated
	 */
	String getPreviousState();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent#getPreviousState <em>Previous State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Previous State</em>' attribute.
	 * @see #getPreviousState()
	 * @generated
	 */
	void setPreviousState(String value);

	/**
	 * Returns the value of the '<em><b>Subsequent State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsequent State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsequent State</em>' attribute.
	 * @see #setSubsequentState(String)
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#getESModifyElementEvent_SubsequentState()
	 * @model
	 * @generated
	 */
	String getSubsequentState();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent#getSubsequentState <em>Subsequent State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subsequent State</em>' attribute.
	 * @see #getSubsequentState()
	 * @generated
	 */
	void setSubsequentState(String value);

} // ESModifyElementEvent

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

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESe Attribute Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent#getPreviousState <em>Previous State</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent#getSubsequentState <em>Subsequent State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#getESeAttributeEvent()
 * @model
 * @generated
 */
public interface ESeAttributeEvent extends ESEvent {
	/**
	 * Returns the value of the '<em><b>Previous State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Previous State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Previous State</em>' containment reference.
	 * @see #setPreviousState(EAttribute)
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#getESeAttributeEvent_PreviousState()
	 * @model containment="true"
	 * @generated
	 */
	EAttribute getPreviousState();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent#getPreviousState <em>Previous State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Previous State</em>' containment reference.
	 * @see #getPreviousState()
	 * @generated
	 */
	void setPreviousState(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Subsequent State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsequent State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsequent State</em>' reference.
	 * @see #setSubsequentState(EAttribute)
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#getESeAttributeEvent_SubsequentState()
	 * @model
	 * @generated
	 */
	EAttribute getSubsequentState();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent#getSubsequentState <em>Subsequent State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subsequent State</em>' reference.
	 * @see #getSubsequentState()
	 * @generated
	 */
	void setSubsequentState(EAttribute value);

} // ESeAttributeEvent

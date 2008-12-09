/**
 * <copyright>Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html</copyright>
 *
 * $Id$
 */
package org.unicase.model.state;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.state.State#getExitConditions <em>Exit Conditions</em>}</li>
 *   <li>{@link org.unicase.model.state.State#getActivities <em>Activities</em>}</li>
 *   <li>{@link org.unicase.model.state.State#getEntryConditions <em>Entry Conditions</em>}</li>
 *   <li>{@link org.unicase.model.state.State#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link org.unicase.model.state.State#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.state.StatePackage#getState()
 * @model
 * @generated
 */
public interface State extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Exit Conditions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit Conditions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit Conditions</em>' attribute.
	 * @see #setExitConditions(String)
	 * @see org.unicase.model.state.StatePackage#getState_ExitConditions()
	 * @model
	 * @generated
	 */
	String getExitConditions();

	/**
	 * Sets the value of the '{@link org.unicase.model.state.State#getExitConditions <em>Exit Conditions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit Conditions</em>' attribute.
	 * @see #getExitConditions()
	 * @generated
	 */
	void setExitConditions(String value);

	/**
	 * Returns the value of the '<em><b>Activities</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activities</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activities</em>' attribute.
	 * @see #setActivities(String)
	 * @see org.unicase.model.state.StatePackage#getState_Activities()
	 * @model
	 * @generated
	 */
	String getActivities();

	/**
	 * Sets the value of the '{@link org.unicase.model.state.State#getActivities <em>Activities</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activities</em>' attribute.
	 * @see #getActivities()
	 * @generated
	 */
	void setActivities(String value);

	/**
	 * Returns the value of the '<em><b>Entry Conditions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Conditions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Conditions</em>' attribute.
	 * @see #setEntryConditions(String)
	 * @see org.unicase.model.state.StatePackage#getState_EntryConditions()
	 * @model
	 * @generated
	 */
	String getEntryConditions();

	/**
	 * Sets the value of the '{@link org.unicase.model.state.State#getEntryConditions <em>Entry Conditions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Conditions</em>' attribute.
	 * @see #getEntryConditions()
	 * @generated
	 */
	void setEntryConditions(String value);

	/**
	 * Returns the value of the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.state.Transition}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.state.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Transitions</em>' reference list.
	 * @see org.unicase.model.state.StatePackage#getState_OutgoingTransitions()
	 * @see org.unicase.model.state.Transition#getSource
	 * @model opposite="source" keys="identifier"
	 * @generated
	 */
	EList<Transition> getOutgoingTransitions();

	/**
	 * Returns the value of the '<em><b>Incoming Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.state.Transition}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.state.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Transitions</em>' reference list.
	 * @see org.unicase.model.state.StatePackage#getState_IncomingTransitions()
	 * @see org.unicase.model.state.Transition#getTarget
	 * @model opposite="target" keys="identifier"
	 * @generated
	 */
	EList<Transition> getIncomingTransitions();

} // State

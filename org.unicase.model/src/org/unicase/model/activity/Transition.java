/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.activity;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Transition</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.activity.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link org.unicase.model.activity.Transition#getTarget <em>Target</em>}</li>
 *   <li>{@link org.unicase.model.activity.Transition#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.activity.ActivityPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.activity.ActivityObject#getOutgoingTransitions <em>Outgoing Transitions</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ActivityObject)
	 * @see org.unicase.model.activity.ActivityPackage#getTransition_Source()
	 * @see org.unicase.model.activity.ActivityObject#getOutgoingTransitions
	 * @model opposite="outgoingTransitions" keys="identifier"
	 * @generated
	 */
	ActivityObject getSource();

	/**
	 * Sets the value of the '{@link org.unicase.model.activity.Transition#getSource <em>Source</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ActivityObject value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.activity.ActivityObject#getIncomingTransitions <em>Incoming Transitions</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ActivityObject)
	 * @see org.unicase.model.activity.ActivityPackage#getTransition_Target()
	 * @see org.unicase.model.activity.ActivityObject#getIncomingTransitions
	 * @model opposite="incomingTransitions" keys="identifier"
	 * @generated
	 */
	ActivityObject getTarget();

	/**
	 * Sets the value of the '{@link org.unicase.model.activity.Transition#getTarget <em>Target</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ActivityObject value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see org.unicase.model.activity.ActivityPackage#getTransition_Condition()
	 * @model
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link org.unicase.model.activity.Transition#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

} // Transition

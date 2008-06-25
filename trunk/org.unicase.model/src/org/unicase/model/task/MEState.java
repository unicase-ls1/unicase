/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Kšgel
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.model.task;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ME State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.task.MEState#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.task.TaskPackage#getMEState()
 * @model
 * @generated
 */
public interface MEState extends EObject {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.model.task.StateType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.unicase.model.task.StateType
	 * @see #setState(StateType)
	 * @see org.unicase.model.task.TaskPackage#getMEState_State()
	 * @model
	 * @generated
	 */
	StateType getState();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.MEState#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.unicase.model.task.StateType
	 * @see #getState()
	 * @generated
	 */
	void setState(StateType value);

} // MEState

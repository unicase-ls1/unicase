/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Undo Event</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.UndoEvent#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getUndoEvent()
 * @model
 * @generated
 */
public interface UndoEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Operation</em>' containment reference.
	 * @see #setOperation(AbstractOperation)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getUndoEvent_Operation()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	AbstractOperation getOperation();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.UndoEvent#getOperation
	 * <em>Operation</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Operation</em>' containment reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(AbstractOperation value);

} // UndoEvent

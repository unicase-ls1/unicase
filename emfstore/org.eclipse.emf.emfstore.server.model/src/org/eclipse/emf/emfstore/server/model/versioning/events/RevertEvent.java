/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.events;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Revert Event</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.RevertEvent#getRevertedChangesCount <em>Reverted Changes Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getRevertEvent()
 * @model
 * @generated
 */
public interface RevertEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Reverted Changes Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reverted Changes Count</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reverted Changes Count</em>' attribute.
	 * @see #setRevertedChangesCount(int)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getRevertEvent_RevertedChangesCount()
	 * @model
	 * @generated
	 */
	int getRevertedChangesCount();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.RevertEvent#getRevertedChangesCount <em>Reverted Changes Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reverted Changes Count</em>' attribute.
	 * @see #getRevertedChangesCount()
	 * @generated
	 */
	void setRevertedChangesCount(int value);

} // RevertEvent

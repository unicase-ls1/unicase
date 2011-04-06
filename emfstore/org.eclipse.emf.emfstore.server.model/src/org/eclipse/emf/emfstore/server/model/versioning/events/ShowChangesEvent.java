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
package org.eclipse.emf.emfstore.server.model.versioning.events;

import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Show Changes Event</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.ShowChangesEvent#getSourceVersion <em>Source Version</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.ShowChangesEvent#getTargetVersion <em>Target Version</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getShowChangesEvent()
 * @model
 * @generated
 */
public interface ShowChangesEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Source Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Version</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Version</em>' containment reference.
	 * @see #setSourceVersion(PrimaryVersionSpec)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getShowChangesEvent_SourceVersion()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	PrimaryVersionSpec getSourceVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.ShowChangesEvent#getSourceVersion <em>Source Version</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Version</em>' containment reference.
	 * @see #getSourceVersion()
	 * @generated
	 */
	void setSourceVersion(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Target Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Version</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Version</em>' containment reference.
	 * @see #setTargetVersion(PrimaryVersionSpec)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getShowChangesEvent_TargetVersion()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	PrimaryVersionSpec getTargetVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.ShowChangesEvent#getTargetVersion <em>Target Version</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Version</em>' containment reference.
	 * @see #getTargetVersion()
	 * @generated
	 */
	void setTargetVersion(PrimaryVersionSpec value);

} // ShowChangesEvent

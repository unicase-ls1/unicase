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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Presentation Switch Event</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.PresentationSwitchEvent#getReadView <em>Read View</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.PresentationSwitchEvent#getNewPresentation <em>New Presentation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getPresentationSwitchEvent()
 * @model
 * @generated
 */
public interface PresentationSwitchEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Read View</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read View</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read View</em>' attribute.
	 * @see #setReadView(String)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getPresentationSwitchEvent_ReadView()
	 * @model
	 * @generated
	 */
	String getReadView();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.PresentationSwitchEvent#getReadView <em>Read View</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read View</em>' attribute.
	 * @see #getReadView()
	 * @generated
	 */
	void setReadView(String value);

	/**
	 * Returns the value of the '<em><b>New Presentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Presentation</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Presentation</em>' attribute.
	 * @see #setNewPresentation(String)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getPresentationSwitchEvent_NewPresentation()
	 * @model
	 * @generated
	 */
	String getNewPresentation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.PresentationSwitchEvent#getNewPresentation <em>New Presentation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Presentation</em>' attribute.
	 * @see #getNewPresentation()
	 * @generated
	 */
	void setNewPresentation(String value);

} // PresentationSwitchEvent

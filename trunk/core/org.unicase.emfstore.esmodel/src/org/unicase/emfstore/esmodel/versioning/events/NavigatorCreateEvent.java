/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events;

import org.unicase.metamodel.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Navigator Create Event</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent#getCreatedElement <em>Created Element</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent#getSourceSection <em>Source Section</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent#isDynamic <em>Dynamic</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getNavigatorCreateEvent()
 * @model
 * @generated
 */
public interface NavigatorCreateEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Created Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created Element</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created Element</em>' containment reference.
	 * @see #setCreatedElement(ModelElementId)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getNavigatorCreateEvent_CreatedElement()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getCreatedElement();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent#getCreatedElement <em>Created Element</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created Element</em>' containment reference.
	 * @see #getCreatedElement()
	 * @generated
	 */
	void setCreatedElement(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Source Section</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Section</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Section</em>' containment reference.
	 * @see #setSourceSection(ModelElementId)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getNavigatorCreateEvent_SourceSection()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getSourceSection();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent#getSourceSection <em>Source Section</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Section</em>' containment reference.
	 * @see #getSourceSection()
	 * @generated
	 */
	void setSourceSection(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic</em>' attribute.
	 * @see #setDynamic(boolean)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getNavigatorCreateEvent_Dynamic()
	 * @model
	 * @generated
	 */
	boolean isDynamic();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent#isDynamic <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic</em>' attribute.
	 * @see #isDynamic()
	 * @generated
	 */
	void setDynamic(boolean value);

} // NavigatorCreateEvent

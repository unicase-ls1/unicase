/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.versioning.events;

import org.eclipse.emf.emfstore.common.model.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>URL Event</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.URLEvent#getSourceModelElement <em>Source Model Element</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.URLEvent#getSourceView <em>Source View</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.URLEvent#getSourceURL <em>Source URL</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getURLEvent()
 * @model
 * @generated
 */
public interface URLEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Source Model Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Model Element</em>' containment reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Model Element</em>' containment reference.
	 * @see #setSourceModelElement(ModelElementId)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getURLEvent_SourceModelElement()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getSourceModelElement();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.URLEvent#getSourceModelElement <em>Source Model Element</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Model Element</em>' containment reference.
	 * @see #getSourceModelElement()
	 * @generated
	 */
	void setSourceModelElement(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Source View</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source View</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source View</em>' attribute.
	 * @see #setSourceView(String)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getURLEvent_SourceView()
	 * @model
	 * @generated
	 */
	String getSourceView();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.URLEvent#getSourceView <em>Source View</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source View</em>' attribute.
	 * @see #getSourceView()
	 * @generated
	 */
	void setSourceView(String value);

	/**
	 * Returns the value of the '<em><b>Source URL</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source URL</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source URL</em>' containment reference.
	 * @see #setSourceURL(ModelElementId)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getURLEvent_SourceURL()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getSourceURL();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.URLEvent#getSourceURL <em>Source URL</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source URL</em>' containment reference.
	 * @see #getSourceURL()
	 * @generated
	 */
	void setSourceURL(ModelElementId value);

} // URLEvent

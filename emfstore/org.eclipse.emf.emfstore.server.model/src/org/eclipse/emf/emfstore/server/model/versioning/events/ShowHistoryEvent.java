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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Show History Event</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.ShowHistoryEvent#getSourceVersion <em>Source Version</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.ShowHistoryEvent#getTargetVersion <em>Target Version</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getShowHistoryEvent()
 * @model
 * @generated
 */
public interface ShowHistoryEvent extends Event {
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
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getShowHistoryEvent_SourceVersion()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	PrimaryVersionSpec getSourceVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.ShowHistoryEvent#getSourceVersion <em>Source Version</em>}' containment reference.
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
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getShowHistoryEvent_TargetVersion()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	PrimaryVersionSpec getTargetVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.ShowHistoryEvent#getTargetVersion <em>Target Version</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Version</em>' containment reference.
	 * @see #getTargetVersion()
	 * @generated
	 */
	void setTargetVersion(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.common.model.ModelElementId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getShowHistoryEvent_ModelElement()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ModelElementId> getModelElement();

} // ShowHistoryEvent

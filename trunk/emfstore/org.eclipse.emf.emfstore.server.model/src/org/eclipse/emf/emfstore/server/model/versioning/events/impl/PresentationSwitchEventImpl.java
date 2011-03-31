/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.events.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.PresentationSwitchEvent;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Presentation Switch Event</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.PresentationSwitchEventImpl#getReadView <em>Read View</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.PresentationSwitchEventImpl#getNewPresentation <em>New Presentation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PresentationSwitchEventImpl extends EventImpl implements PresentationSwitchEvent {
	/**
	 * The default value of the '{@link #getReadView() <em>Read View</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getReadView()
	 * @generated
	 * @ordered
	 */
	protected static final String READ_VIEW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReadView() <em>Read View</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getReadView()
	 * @generated
	 * @ordered
	 */
	protected String readView = READ_VIEW_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewPresentation() <em>New Presentation</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getNewPresentation()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_PRESENTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewPresentation() <em>New Presentation</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getNewPresentation()
	 * @generated
	 * @ordered
	 */
	protected String newPresentation = NEW_PRESENTATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PresentationSwitchEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.PRESENTATION_SWITCH_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getReadView() {
		return readView;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadView(String newReadView) {
		String oldReadView = readView;
		readView = newReadView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.PRESENTATION_SWITCH_EVENT__READ_VIEW, oldReadView, readView));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewPresentation() {
		return newPresentation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewPresentation(String newNewPresentation) {
		String oldNewPresentation = newPresentation;
		newPresentation = newNewPresentation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.PRESENTATION_SWITCH_EVENT__NEW_PRESENTATION, oldNewPresentation, newPresentation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventsPackage.PRESENTATION_SWITCH_EVENT__READ_VIEW:
				return getReadView();
			case EventsPackage.PRESENTATION_SWITCH_EVENT__NEW_PRESENTATION:
				return getNewPresentation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EventsPackage.PRESENTATION_SWITCH_EVENT__READ_VIEW:
				setReadView((String)newValue);
				return;
			case EventsPackage.PRESENTATION_SWITCH_EVENT__NEW_PRESENTATION:
				setNewPresentation((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EventsPackage.PRESENTATION_SWITCH_EVENT__READ_VIEW:
				setReadView(READ_VIEW_EDEFAULT);
				return;
			case EventsPackage.PRESENTATION_SWITCH_EVENT__NEW_PRESENTATION:
				setNewPresentation(NEW_PRESENTATION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EventsPackage.PRESENTATION_SWITCH_EVENT__READ_VIEW:
				return READ_VIEW_EDEFAULT == null ? readView != null : !READ_VIEW_EDEFAULT.equals(readView);
			case EventsPackage.PRESENTATION_SWITCH_EVENT__NEW_PRESENTATION:
				return NEW_PRESENTATION_EDEFAULT == null ? newPresentation != null : !NEW_PRESENTATION_EDEFAULT.equals(newPresentation);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (readView: ");
		result.append(readView);
		result.append(", newPresentation: ");
		result.append(newPresentation);
		result.append(')');
		return result.toString();
	}

} // PresentationSwitchEventImpl

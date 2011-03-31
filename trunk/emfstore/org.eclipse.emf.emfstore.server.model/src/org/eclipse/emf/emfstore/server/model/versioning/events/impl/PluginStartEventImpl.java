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
import org.eclipse.emf.emfstore.server.model.versioning.events.PluginStartEvent;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Plugin Start Event</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.PluginStartEventImpl#getPluginId <em>Plugin Id</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PluginStartEventImpl extends EventImpl implements PluginStartEvent {
	/**
	 * The default value of the '{@link #getPluginId() <em>Plugin Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPluginId()
	 * @generated
	 * @ordered
	 */
	protected static final String PLUGIN_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPluginId() <em>Plugin Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPluginId()
	 * @generated
	 * @ordered
	 */
	protected String pluginId = PLUGIN_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PluginStartEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.PLUGIN_START_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPluginId() {
		return pluginId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPluginId(String newPluginId) {
		String oldPluginId = pluginId;
		pluginId = newPluginId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.PLUGIN_START_EVENT__PLUGIN_ID, oldPluginId, pluginId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventsPackage.PLUGIN_START_EVENT__PLUGIN_ID:
				return getPluginId();
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
			case EventsPackage.PLUGIN_START_EVENT__PLUGIN_ID:
				setPluginId((String)newValue);
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
			case EventsPackage.PLUGIN_START_EVENT__PLUGIN_ID:
				setPluginId(PLUGIN_ID_EDEFAULT);
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
			case EventsPackage.PLUGIN_START_EVENT__PLUGIN_ID:
				return PLUGIN_ID_EDEFAULT == null ? pluginId != null : !PLUGIN_ID_EDEFAULT.equals(pluginId);
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
		result.append(" (pluginId: ");
		result.append(pluginId);
		result.append(')');
		return result.toString();
	}

} // PluginStartEventImpl

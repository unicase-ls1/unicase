/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.events.server.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ProjectUpdatedEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Project Updated Event</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.server.impl.ProjectUpdatedEventImpl#getNewVersion <em>New Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectUpdatedEventImpl extends ServerProjectEventImpl implements ProjectUpdatedEvent {
	/**
	 * The cached value of the '{@link #getNewVersion() <em>New Version</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNewVersion()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec newVersion;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectUpdatedEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServerPackage.Literals.PROJECT_UPDATED_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec getNewVersion() {
		if (newVersion != null && newVersion.eIsProxy()) {
			InternalEObject oldNewVersion = (InternalEObject)newVersion;
			newVersion = (PrimaryVersionSpec)eResolveProxy(oldNewVersion);
			if (newVersion != oldNewVersion) {
				InternalEObject newNewVersion = (InternalEObject)newVersion;
				NotificationChain msgs = oldNewVersion.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServerPackage.PROJECT_UPDATED_EVENT__NEW_VERSION, null, null);
				if (newNewVersion.eInternalContainer() == null) {
					msgs = newNewVersion.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServerPackage.PROJECT_UPDATED_EVENT__NEW_VERSION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServerPackage.PROJECT_UPDATED_EVENT__NEW_VERSION, oldNewVersion, newVersion));
			}
		}
		return newVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec basicGetNewVersion() {
		return newVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNewVersion(PrimaryVersionSpec newNewVersion, NotificationChain msgs) {
		PrimaryVersionSpec oldNewVersion = newVersion;
		newVersion = newNewVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServerPackage.PROJECT_UPDATED_EVENT__NEW_VERSION, oldNewVersion, newNewVersion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewVersion(PrimaryVersionSpec newNewVersion) {
		if (newNewVersion != newVersion) {
			NotificationChain msgs = null;
			if (newVersion != null)
				msgs = ((InternalEObject)newVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServerPackage.PROJECT_UPDATED_EVENT__NEW_VERSION, null, msgs);
			if (newNewVersion != null)
				msgs = ((InternalEObject)newNewVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServerPackage.PROJECT_UPDATED_EVENT__NEW_VERSION, null, msgs);
			msgs = basicSetNewVersion(newNewVersion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerPackage.PROJECT_UPDATED_EVENT__NEW_VERSION, newNewVersion, newNewVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServerPackage.PROJECT_UPDATED_EVENT__NEW_VERSION:
				return basicSetNewVersion(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServerPackage.PROJECT_UPDATED_EVENT__NEW_VERSION:
				if (resolve) return getNewVersion();
				return basicGetNewVersion();
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
			case ServerPackage.PROJECT_UPDATED_EVENT__NEW_VERSION:
				setNewVersion((PrimaryVersionSpec)newValue);
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
			case ServerPackage.PROJECT_UPDATED_EVENT__NEW_VERSION:
				setNewVersion((PrimaryVersionSpec)null);
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
			case ServerPackage.PROJECT_UPDATED_EVENT__NEW_VERSION:
				return newVersion != null;
		}
		return super.eIsSet(featureID);
	}

} // ProjectUpdatedEventImpl

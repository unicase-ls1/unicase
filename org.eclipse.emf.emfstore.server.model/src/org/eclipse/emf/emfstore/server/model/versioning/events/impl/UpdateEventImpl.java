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
package org.eclipse.emf.emfstore.server.model.versioning.events.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.UpdateEvent;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Update Event</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.UpdateEventImpl#getBaseVersion <em>Base
 * Version</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.UpdateEventImpl#getTargetVersion <em>Target
 * Version</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UpdateEventImpl extends EventImpl implements UpdateEvent {
	/**
	 * The cached value of the '{@link #getBaseVersion() <em>Base Version</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBaseVersion()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec baseVersion;

	/**
	 * The cached value of the '{@link #getTargetVersion() <em>Target Version</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTargetVersion()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec targetVersion;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected UpdateEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.UPDATE_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimaryVersionSpec getBaseVersion() {
		if (baseVersion != null && baseVersion.eIsProxy()) {
			InternalEObject oldBaseVersion = (InternalEObject) baseVersion;
			baseVersion = (PrimaryVersionSpec) eResolveProxy(oldBaseVersion);
			if (baseVersion != oldBaseVersion) {
				InternalEObject newBaseVersion = (InternalEObject) baseVersion;
				NotificationChain msgs = oldBaseVersion.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.UPDATE_EVENT__BASE_VERSION, null, null);
				if (newBaseVersion.eInternalContainer() == null) {
					msgs = newBaseVersion.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- EventsPackage.UPDATE_EVENT__BASE_VERSION, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.UPDATE_EVENT__BASE_VERSION,
						oldBaseVersion, baseVersion));
			}
		}
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimaryVersionSpec basicGetBaseVersion() {
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetBaseVersion(PrimaryVersionSpec newBaseVersion, NotificationChain msgs) {
		PrimaryVersionSpec oldBaseVersion = baseVersion;
		baseVersion = newBaseVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				EventsPackage.UPDATE_EVENT__BASE_VERSION, oldBaseVersion, newBaseVersion);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBaseVersion(PrimaryVersionSpec newBaseVersion) {
		if (newBaseVersion != baseVersion) {
			NotificationChain msgs = null;
			if (baseVersion != null)
				msgs = ((InternalEObject) baseVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.UPDATE_EVENT__BASE_VERSION, null, msgs);
			if (newBaseVersion != null)
				msgs = ((InternalEObject) newBaseVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.UPDATE_EVENT__BASE_VERSION, null, msgs);
			msgs = basicSetBaseVersion(newBaseVersion, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.UPDATE_EVENT__BASE_VERSION,
				newBaseVersion, newBaseVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimaryVersionSpec getTargetVersion() {
		if (targetVersion != null && targetVersion.eIsProxy()) {
			InternalEObject oldTargetVersion = (InternalEObject) targetVersion;
			targetVersion = (PrimaryVersionSpec) eResolveProxy(oldTargetVersion);
			if (targetVersion != oldTargetVersion) {
				InternalEObject newTargetVersion = (InternalEObject) targetVersion;
				NotificationChain msgs = oldTargetVersion.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.UPDATE_EVENT__TARGET_VERSION, null, null);
				if (newTargetVersion.eInternalContainer() == null) {
					msgs = newTargetVersion.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- EventsPackage.UPDATE_EVENT__TARGET_VERSION, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						EventsPackage.UPDATE_EVENT__TARGET_VERSION, oldTargetVersion, targetVersion));
			}
		}
		return targetVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimaryVersionSpec basicGetTargetVersion() {
		return targetVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetTargetVersion(PrimaryVersionSpec newTargetVersion, NotificationChain msgs) {
		PrimaryVersionSpec oldTargetVersion = targetVersion;
		targetVersion = newTargetVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				EventsPackage.UPDATE_EVENT__TARGET_VERSION, oldTargetVersion, newTargetVersion);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTargetVersion(PrimaryVersionSpec newTargetVersion) {
		if (newTargetVersion != targetVersion) {
			NotificationChain msgs = null;
			if (targetVersion != null)
				msgs = ((InternalEObject) targetVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.UPDATE_EVENT__TARGET_VERSION, null, msgs);
			if (newTargetVersion != null)
				msgs = ((InternalEObject) newTargetVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.UPDATE_EVENT__TARGET_VERSION, null, msgs);
			msgs = basicSetTargetVersion(newTargetVersion, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.UPDATE_EVENT__TARGET_VERSION,
				newTargetVersion, newTargetVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EventsPackage.UPDATE_EVENT__BASE_VERSION:
			return basicSetBaseVersion(null, msgs);
		case EventsPackage.UPDATE_EVENT__TARGET_VERSION:
			return basicSetTargetVersion(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EventsPackage.UPDATE_EVENT__BASE_VERSION:
			if (resolve)
				return getBaseVersion();
			return basicGetBaseVersion();
		case EventsPackage.UPDATE_EVENT__TARGET_VERSION:
			if (resolve)
				return getTargetVersion();
			return basicGetTargetVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case EventsPackage.UPDATE_EVENT__BASE_VERSION:
			setBaseVersion((PrimaryVersionSpec) newValue);
			return;
		case EventsPackage.UPDATE_EVENT__TARGET_VERSION:
			setTargetVersion((PrimaryVersionSpec) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case EventsPackage.UPDATE_EVENT__BASE_VERSION:
			setBaseVersion((PrimaryVersionSpec) null);
			return;
		case EventsPackage.UPDATE_EVENT__TARGET_VERSION:
			setTargetVersion((PrimaryVersionSpec) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case EventsPackage.UPDATE_EVENT__BASE_VERSION:
			return baseVersion != null;
		case EventsPackage.UPDATE_EVENT__TARGET_VERSION:
			return targetVersion != null;
		}
		return super.eIsSet(featureID);
	}

} // UpdateEventImpl

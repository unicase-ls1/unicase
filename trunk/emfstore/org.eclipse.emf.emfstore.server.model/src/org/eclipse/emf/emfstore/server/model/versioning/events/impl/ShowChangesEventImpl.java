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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.ShowChangesEvent;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Show Changes Event</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.ShowChangesEventImpl#getSourceVersion <em>Source
 * Version</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.ShowChangesEventImpl#getTargetVersion <em>Target
 * Version</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ShowChangesEventImpl extends EventImpl implements ShowChangesEvent {
	/**
	 * The cached value of the '{@link #getSourceVersion() <em>Source Version</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSourceVersion()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec sourceVersion;

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
	 * @generated
	 */
	protected ShowChangesEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.SHOW_CHANGES_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec getSourceVersion() {
		if (sourceVersion != null && sourceVersion.eIsProxy()) {
			InternalEObject oldSourceVersion = (InternalEObject)sourceVersion;
			sourceVersion = (PrimaryVersionSpec)eResolveProxy(oldSourceVersion);
			if (sourceVersion != oldSourceVersion) {
				InternalEObject newSourceVersion = (InternalEObject)sourceVersion;
				NotificationChain msgs = oldSourceVersion.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.SHOW_CHANGES_EVENT__SOURCE_VERSION, null, null);
				if (newSourceVersion.eInternalContainer() == null) {
					msgs = newSourceVersion.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.SHOW_CHANGES_EVENT__SOURCE_VERSION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.SHOW_CHANGES_EVENT__SOURCE_VERSION, oldSourceVersion, sourceVersion));
			}
		}
		return sourceVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec basicGetSourceVersion() {
		return sourceVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceVersion(PrimaryVersionSpec newSourceVersion, NotificationChain msgs) {
		PrimaryVersionSpec oldSourceVersion = sourceVersion;
		sourceVersion = newSourceVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventsPackage.SHOW_CHANGES_EVENT__SOURCE_VERSION, oldSourceVersion, newSourceVersion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceVersion(PrimaryVersionSpec newSourceVersion) {
		if (newSourceVersion != sourceVersion) {
			NotificationChain msgs = null;
			if (sourceVersion != null)
				msgs = ((InternalEObject)sourceVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.SHOW_CHANGES_EVENT__SOURCE_VERSION, null, msgs);
			if (newSourceVersion != null)
				msgs = ((InternalEObject)newSourceVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.SHOW_CHANGES_EVENT__SOURCE_VERSION, null, msgs);
			msgs = basicSetSourceVersion(newSourceVersion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.SHOW_CHANGES_EVENT__SOURCE_VERSION, newSourceVersion, newSourceVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec getTargetVersion() {
		if (targetVersion != null && targetVersion.eIsProxy()) {
			InternalEObject oldTargetVersion = (InternalEObject)targetVersion;
			targetVersion = (PrimaryVersionSpec)eResolveProxy(oldTargetVersion);
			if (targetVersion != oldTargetVersion) {
				InternalEObject newTargetVersion = (InternalEObject)targetVersion;
				NotificationChain msgs = oldTargetVersion.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.SHOW_CHANGES_EVENT__TARGET_VERSION, null, null);
				if (newTargetVersion.eInternalContainer() == null) {
					msgs = newTargetVersion.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.SHOW_CHANGES_EVENT__TARGET_VERSION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.SHOW_CHANGES_EVENT__TARGET_VERSION, oldTargetVersion, targetVersion));
			}
		}
		return targetVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec basicGetTargetVersion() {
		return targetVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetVersion(PrimaryVersionSpec newTargetVersion, NotificationChain msgs) {
		PrimaryVersionSpec oldTargetVersion = targetVersion;
		targetVersion = newTargetVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventsPackage.SHOW_CHANGES_EVENT__TARGET_VERSION, oldTargetVersion, newTargetVersion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetVersion(PrimaryVersionSpec newTargetVersion) {
		if (newTargetVersion != targetVersion) {
			NotificationChain msgs = null;
			if (targetVersion != null)
				msgs = ((InternalEObject)targetVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.SHOW_CHANGES_EVENT__TARGET_VERSION, null, msgs);
			if (newTargetVersion != null)
				msgs = ((InternalEObject)newTargetVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.SHOW_CHANGES_EVENT__TARGET_VERSION, null, msgs);
			msgs = basicSetTargetVersion(newTargetVersion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.SHOW_CHANGES_EVENT__TARGET_VERSION, newTargetVersion, newTargetVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventsPackage.SHOW_CHANGES_EVENT__SOURCE_VERSION:
				return basicSetSourceVersion(null, msgs);
			case EventsPackage.SHOW_CHANGES_EVENT__TARGET_VERSION:
				return basicSetTargetVersion(null, msgs);
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
			case EventsPackage.SHOW_CHANGES_EVENT__SOURCE_VERSION:
				if (resolve) return getSourceVersion();
				return basicGetSourceVersion();
			case EventsPackage.SHOW_CHANGES_EVENT__TARGET_VERSION:
				if (resolve) return getTargetVersion();
				return basicGetTargetVersion();
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
			case EventsPackage.SHOW_CHANGES_EVENT__SOURCE_VERSION:
				setSourceVersion((PrimaryVersionSpec)newValue);
				return;
			case EventsPackage.SHOW_CHANGES_EVENT__TARGET_VERSION:
				setTargetVersion((PrimaryVersionSpec)newValue);
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
			case EventsPackage.SHOW_CHANGES_EVENT__SOURCE_VERSION:
				setSourceVersion((PrimaryVersionSpec)null);
				return;
			case EventsPackage.SHOW_CHANGES_EVENT__TARGET_VERSION:
				setTargetVersion((PrimaryVersionSpec)null);
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
			case EventsPackage.SHOW_CHANGES_EVENT__SOURCE_VERSION:
				return sourceVersion != null;
			case EventsPackage.SHOW_CHANGES_EVENT__TARGET_VERSION:
				return targetVersion != null;
		}
		return super.eIsSet(featureID);
	}

} // ShowChangesEventImpl

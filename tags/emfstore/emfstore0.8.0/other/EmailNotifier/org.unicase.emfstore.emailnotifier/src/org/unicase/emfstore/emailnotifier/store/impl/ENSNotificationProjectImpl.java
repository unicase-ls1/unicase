/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.store.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.emfstore.emailnotifier.store.ENSNotificationProject;
import org.unicase.emfstore.emailnotifier.store.ENSPackage;
import org.unicase.emfstore.emailnotifier.store.ENSUser;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Notification Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.impl.ENSNotificationProjectImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.impl.ENSNotificationProjectImpl#getLatestVersion <em>Latest Version</em>}</li>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.impl.ENSNotificationProjectImpl#getUsers <em>Users</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ENSNotificationProjectImpl extends EObjectImpl implements ENSNotificationProject {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLatestVersion() <em>Latest Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatestVersion()
	 * @generated
	 * @ordered
	 */
	protected static final int LATEST_VERSION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLatestVersion() <em>Latest Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatestVersion()
	 * @generated
	 * @ordered
	 */
	protected int latestVersion = LATEST_VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUsers() <em>Users</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsers()
	 * @generated
	 * @ordered
	 */
	protected EList<ENSUser> users;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ENSNotificationProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ENSPackage.Literals.ENS_NOTIFICATION_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENSPackage.ENS_NOTIFICATION_PROJECT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLatestVersion() {
		return latestVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLatestVersion(int newLatestVersion) {
		int oldLatestVersion = latestVersion;
		latestVersion = newLatestVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENSPackage.ENS_NOTIFICATION_PROJECT__LATEST_VERSION, oldLatestVersion, latestVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ENSUser> getUsers() {
		if (users == null) {
			users = new EObjectContainmentEList<ENSUser>(ENSUser.class, this, ENSPackage.ENS_NOTIFICATION_PROJECT__USERS);
		}
		return users;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ENSPackage.ENS_NOTIFICATION_PROJECT__USERS:
				return ((InternalEList<?>)getUsers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ENSPackage.ENS_NOTIFICATION_PROJECT__ID:
				return getId();
			case ENSPackage.ENS_NOTIFICATION_PROJECT__LATEST_VERSION:
				return getLatestVersion();
			case ENSPackage.ENS_NOTIFICATION_PROJECT__USERS:
				return getUsers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ENSPackage.ENS_NOTIFICATION_PROJECT__ID:
				setId((String)newValue);
				return;
			case ENSPackage.ENS_NOTIFICATION_PROJECT__LATEST_VERSION:
				setLatestVersion((Integer)newValue);
				return;
			case ENSPackage.ENS_NOTIFICATION_PROJECT__USERS:
				getUsers().clear();
				getUsers().addAll((Collection<? extends ENSUser>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ENSPackage.ENS_NOTIFICATION_PROJECT__ID:
				setId(ID_EDEFAULT);
				return;
			case ENSPackage.ENS_NOTIFICATION_PROJECT__LATEST_VERSION:
				setLatestVersion(LATEST_VERSION_EDEFAULT);
				return;
			case ENSPackage.ENS_NOTIFICATION_PROJECT__USERS:
				getUsers().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ENSPackage.ENS_NOTIFICATION_PROJECT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ENSPackage.ENS_NOTIFICATION_PROJECT__LATEST_VERSION:
				return latestVersion != LATEST_VERSION_EDEFAULT;
			case ENSPackage.ENS_NOTIFICATION_PROJECT__USERS:
				return users != null && !users.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", latestVersion: ");
		result.append(latestVersion);
		result.append(')');
		return result.toString();
	}

} //ENSNotificationProjectImpl

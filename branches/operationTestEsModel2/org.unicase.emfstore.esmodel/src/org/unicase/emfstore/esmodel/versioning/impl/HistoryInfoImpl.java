/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>History Info</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.impl.HistoryInfoImpl#getPrimerySpec <em>Primery Spec</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.impl.HistoryInfoImpl#getLogMessage <em>Log Message</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HistoryInfoImpl extends EObjectImpl implements HistoryInfo {
	/**
	 * The cached value of the '{@link #getPrimerySpec() <em>Primery Spec</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPrimerySpec()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec primerySpec;

	/**
	 * The cached value of the '{@link #getLogMessage() <em>Log Message</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLogMessage()
	 * @generated
	 * @ordered
	 */
	protected LogMessage logMessage;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected HistoryInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VersioningPackage.Literals.HISTORY_INFO;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec getPrimerySpec() {
		if (primerySpec != null && primerySpec.eIsProxy()) {
			InternalEObject oldPrimerySpec = (InternalEObject) primerySpec;
			primerySpec = (PrimaryVersionSpec) eResolveProxy(oldPrimerySpec);
			if (primerySpec != oldPrimerySpec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							VersioningPackage.HISTORY_INFO__PRIMERY_SPEC,
							oldPrimerySpec, primerySpec));
			}
		}
		return primerySpec;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec basicGetPrimerySpec() {
		return primerySpec;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimerySpec(PrimaryVersionSpec newPrimerySpec) {
		PrimaryVersionSpec oldPrimerySpec = primerySpec;
		primerySpec = newPrimerySpec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					VersioningPackage.HISTORY_INFO__PRIMERY_SPEC,
					oldPrimerySpec, primerySpec));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LogMessage getLogMessage() {
		if (logMessage != null && logMessage.eIsProxy()) {
			InternalEObject oldLogMessage = (InternalEObject) logMessage;
			logMessage = (LogMessage) eResolveProxy(oldLogMessage);
			if (logMessage != oldLogMessage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							VersioningPackage.HISTORY_INFO__LOG_MESSAGE,
							oldLogMessage, logMessage));
			}
		}
		return logMessage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LogMessage basicGetLogMessage() {
		return logMessage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogMessage(LogMessage newLogMessage) {
		LogMessage oldLogMessage = logMessage;
		logMessage = newLogMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					VersioningPackage.HISTORY_INFO__LOG_MESSAGE, oldLogMessage,
					logMessage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case VersioningPackage.HISTORY_INFO__PRIMERY_SPEC:
			if (resolve)
				return getPrimerySpec();
			return basicGetPrimerySpec();
		case VersioningPackage.HISTORY_INFO__LOG_MESSAGE:
			if (resolve)
				return getLogMessage();
			return basicGetLogMessage();
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
		case VersioningPackage.HISTORY_INFO__PRIMERY_SPEC:
			setPrimerySpec((PrimaryVersionSpec) newValue);
			return;
		case VersioningPackage.HISTORY_INFO__LOG_MESSAGE:
			setLogMessage((LogMessage) newValue);
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
		case VersioningPackage.HISTORY_INFO__PRIMERY_SPEC:
			setPrimerySpec((PrimaryVersionSpec) null);
			return;
		case VersioningPackage.HISTORY_INFO__LOG_MESSAGE:
			setLogMessage((LogMessage) null);
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
		case VersioningPackage.HISTORY_INFO__PRIMERY_SPEC:
			return primerySpec != null;
		case VersioningPackage.HISTORY_INFO__LOG_MESSAGE:
			return logMessage != null;
		}
		return super.eIsSet(featureID);
	}

} // HistoryInfoImpl

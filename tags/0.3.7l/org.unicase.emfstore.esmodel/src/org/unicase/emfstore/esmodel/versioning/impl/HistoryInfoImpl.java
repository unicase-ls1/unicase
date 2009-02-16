/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.impl;

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
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;

/*
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>History Info</b></em>'. <!-- end-user-doc -->
 * <p> The following features are implemented: <ul> <li>{@link
 * org.unicase.emfstore.esmodel.versioning.impl.HistoryInfoImpl#getPrimerySpec <em>Primery Spec</em>}</li> <li>{@link
 * org.unicase.emfstore.esmodel.versioning.impl.HistoryInfoImpl#getLogMessage <em>Log Message</em>}</li> <li>{@link
 * org.unicase.emfstore.esmodel.versioning.impl.HistoryInfoImpl#getTagSpecs <em>Tag Specs</em>}</li> </ul> </p>
 * @generated
 */
public class HistoryInfoImpl extends EObjectImpl implements HistoryInfo {
	/**
	 * The cached value of the '{@link #getPrimerySpec() <em>Primery Spec</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPrimerySpec()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec primerySpec;

	/**
	 * The cached value of the '{@link #getLogMessage() <em>Log Message</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLogMessage()
	 * @generated
	 * @ordered
	 */
	protected LogMessage logMessage;

	/**
	 * The cached value of the '{@link #getTagSpecs() <em>Tag Specs</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTagSpecs()
	 * @generated
	 * @ordered
	 */
	protected EList<TagVersionSpec> tagSpecs;

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
				InternalEObject newPrimerySpec = (InternalEObject) primerySpec;
				NotificationChain msgs = oldPrimerySpec.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- VersioningPackage.HISTORY_INFO__PRIMERY_SPEC, null, null);
				if (newPrimerySpec.eInternalContainer() == null) {
					msgs = newPrimerySpec.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- VersioningPackage.HISTORY_INFO__PRIMERY_SPEC, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						VersioningPackage.HISTORY_INFO__PRIMERY_SPEC, oldPrimerySpec, primerySpec));
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
	public NotificationChain basicSetPrimerySpec(PrimaryVersionSpec newPrimerySpec, NotificationChain msgs) {
		PrimaryVersionSpec oldPrimerySpec = primerySpec;
		primerySpec = newPrimerySpec;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				VersioningPackage.HISTORY_INFO__PRIMERY_SPEC, oldPrimerySpec, newPrimerySpec);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimerySpec(PrimaryVersionSpec newPrimerySpec) {
		if (newPrimerySpec != primerySpec) {
			NotificationChain msgs = null;
			if (primerySpec != null)
				msgs = ((InternalEObject) primerySpec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- VersioningPackage.HISTORY_INFO__PRIMERY_SPEC, null, msgs);
			if (newPrimerySpec != null)
				msgs = ((InternalEObject) newPrimerySpec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- VersioningPackage.HISTORY_INFO__PRIMERY_SPEC, null, msgs);
			msgs = basicSetPrimerySpec(newPrimerySpec, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VersioningPackage.HISTORY_INFO__PRIMERY_SPEC,
				newPrimerySpec, newPrimerySpec));
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
				InternalEObject newLogMessage = (InternalEObject) logMessage;
				NotificationChain msgs = oldLogMessage.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- VersioningPackage.HISTORY_INFO__LOG_MESSAGE, null, null);
				if (newLogMessage.eInternalContainer() == null) {
					msgs = newLogMessage.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- VersioningPackage.HISTORY_INFO__LOG_MESSAGE, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						VersioningPackage.HISTORY_INFO__LOG_MESSAGE, oldLogMessage, logMessage));
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
	public NotificationChain basicSetLogMessage(LogMessage newLogMessage, NotificationChain msgs) {
		LogMessage oldLogMessage = logMessage;
		logMessage = newLogMessage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				VersioningPackage.HISTORY_INFO__LOG_MESSAGE, oldLogMessage, newLogMessage);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogMessage(LogMessage newLogMessage) {
		if (newLogMessage != logMessage) {
			NotificationChain msgs = null;
			if (logMessage != null)
				msgs = ((InternalEObject) logMessage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- VersioningPackage.HISTORY_INFO__LOG_MESSAGE, null, msgs);
			if (newLogMessage != null)
				msgs = ((InternalEObject) newLogMessage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- VersioningPackage.HISTORY_INFO__LOG_MESSAGE, null, msgs);
			msgs = basicSetLogMessage(newLogMessage, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VersioningPackage.HISTORY_INFO__LOG_MESSAGE,
				newLogMessage, newLogMessage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TagVersionSpec> getTagSpecs() {
		if (tagSpecs == null) {
			tagSpecs = new EObjectContainmentEList.Resolving<TagVersionSpec>(TagVersionSpec.class, this,
				VersioningPackage.HISTORY_INFO__TAG_SPECS);
		}
		return tagSpecs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case VersioningPackage.HISTORY_INFO__PRIMERY_SPEC:
			return basicSetPrimerySpec(null, msgs);
		case VersioningPackage.HISTORY_INFO__LOG_MESSAGE:
			return basicSetLogMessage(null, msgs);
		case VersioningPackage.HISTORY_INFO__TAG_SPECS:
			return ((InternalEList<?>) getTagSpecs()).basicRemove(otherEnd, msgs);
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
		case VersioningPackage.HISTORY_INFO__PRIMERY_SPEC:
			if (resolve)
				return getPrimerySpec();
			return basicGetPrimerySpec();
		case VersioningPackage.HISTORY_INFO__LOG_MESSAGE:
			if (resolve)
				return getLogMessage();
			return basicGetLogMessage();
		case VersioningPackage.HISTORY_INFO__TAG_SPECS:
			return getTagSpecs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case VersioningPackage.HISTORY_INFO__PRIMERY_SPEC:
			setPrimerySpec((PrimaryVersionSpec) newValue);
			return;
		case VersioningPackage.HISTORY_INFO__LOG_MESSAGE:
			setLogMessage((LogMessage) newValue);
			return;
		case VersioningPackage.HISTORY_INFO__TAG_SPECS:
			getTagSpecs().clear();
			getTagSpecs().addAll((Collection<? extends TagVersionSpec>) newValue);
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
		case VersioningPackage.HISTORY_INFO__TAG_SPECS:
			getTagSpecs().clear();
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
		case VersioningPackage.HISTORY_INFO__TAG_SPECS:
			return tagSpecs != null && !tagSpecs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // HistoryInfoImpl

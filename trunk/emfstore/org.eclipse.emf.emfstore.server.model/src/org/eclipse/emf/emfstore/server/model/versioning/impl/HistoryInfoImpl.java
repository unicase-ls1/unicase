/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.versioning.impl;

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
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersionProperty;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>History Info</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryInfoImpl#getPrimerySpec <em>Primery Spec</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryInfoImpl#getLogMessage <em>Log Message</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryInfoImpl#getTagSpecs <em>Tag Specs</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryInfoImpl#getVersionProperties <em>Version Properties</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryInfoImpl#getChangePackage <em>Change Package</em>}</li>
 * </ul>
 * </p>
 *
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
	 * The cached value of the '{@link #getVersionProperties() <em>Version Properties</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVersionProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<VersionProperty> versionProperties;

	/**
	 * The cached value of the '{@link #getChangePackage() <em>Change Package</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getChangePackage()
	 * @generated
	 * @ordered
	 */
	protected ChangePackage changePackage;

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
			InternalEObject oldPrimerySpec = (InternalEObject)primerySpec;
			primerySpec = (PrimaryVersionSpec)eResolveProxy(oldPrimerySpec);
			if (primerySpec != oldPrimerySpec) {
				InternalEObject newPrimerySpec = (InternalEObject)primerySpec;
				NotificationChain msgs = oldPrimerySpec.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_INFO__PRIMERY_SPEC, null, null);
				if (newPrimerySpec.eInternalContainer() == null) {
					msgs = newPrimerySpec.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_INFO__PRIMERY_SPEC, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VersioningPackage.HISTORY_INFO__PRIMERY_SPEC, oldPrimerySpec, primerySpec));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VersioningPackage.HISTORY_INFO__PRIMERY_SPEC, oldPrimerySpec, newPrimerySpec);
			if (msgs == null) msgs = notification; else msgs.add(notification);
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
				msgs = ((InternalEObject)primerySpec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_INFO__PRIMERY_SPEC, null, msgs);
			if (newPrimerySpec != null)
				msgs = ((InternalEObject)newPrimerySpec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_INFO__PRIMERY_SPEC, null, msgs);
			msgs = basicSetPrimerySpec(newPrimerySpec, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VersioningPackage.HISTORY_INFO__PRIMERY_SPEC, newPrimerySpec, newPrimerySpec));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LogMessage getLogMessage() {
		if (logMessage != null && logMessage.eIsProxy()) {
			InternalEObject oldLogMessage = (InternalEObject)logMessage;
			logMessage = (LogMessage)eResolveProxy(oldLogMessage);
			if (logMessage != oldLogMessage) {
				InternalEObject newLogMessage = (InternalEObject)logMessage;
				NotificationChain msgs = oldLogMessage.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_INFO__LOG_MESSAGE, null, null);
				if (newLogMessage.eInternalContainer() == null) {
					msgs = newLogMessage.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_INFO__LOG_MESSAGE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VersioningPackage.HISTORY_INFO__LOG_MESSAGE, oldLogMessage, logMessage));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VersioningPackage.HISTORY_INFO__LOG_MESSAGE, oldLogMessage, newLogMessage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
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
				msgs = ((InternalEObject)logMessage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_INFO__LOG_MESSAGE, null, msgs);
			if (newLogMessage != null)
				msgs = ((InternalEObject)newLogMessage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_INFO__LOG_MESSAGE, null, msgs);
			msgs = basicSetLogMessage(newLogMessage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VersioningPackage.HISTORY_INFO__LOG_MESSAGE, newLogMessage, newLogMessage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TagVersionSpec> getTagSpecs() {
		if (tagSpecs == null) {
			tagSpecs = new EObjectContainmentEList.Resolving<TagVersionSpec>(TagVersionSpec.class, this, VersioningPackage.HISTORY_INFO__TAG_SPECS);
		}
		return tagSpecs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VersionProperty> getVersionProperties() {
		if (versionProperties == null) {
			versionProperties = new EObjectContainmentEList.Resolving<VersionProperty>(VersionProperty.class, this, VersioningPackage.HISTORY_INFO__VERSION_PROPERTIES);
		}
		return versionProperties;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ChangePackage getChangePackage() {
		if (changePackage != null && changePackage.eIsProxy()) {
			InternalEObject oldChangePackage = (InternalEObject)changePackage;
			changePackage = (ChangePackage)eResolveProxy(oldChangePackage);
			if (changePackage != oldChangePackage) {
				InternalEObject newChangePackage = (InternalEObject)changePackage;
				NotificationChain msgs = oldChangePackage.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_INFO__CHANGE_PACKAGE, null, null);
				if (newChangePackage.eInternalContainer() == null) {
					msgs = newChangePackage.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_INFO__CHANGE_PACKAGE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VersioningPackage.HISTORY_INFO__CHANGE_PACKAGE, oldChangePackage, changePackage));
			}
		}
		return changePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ChangePackage basicGetChangePackage() {
		return changePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChangePackage(ChangePackage newChangePackage, NotificationChain msgs) {
		ChangePackage oldChangePackage = changePackage;
		changePackage = newChangePackage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VersioningPackage.HISTORY_INFO__CHANGE_PACKAGE, oldChangePackage, newChangePackage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangePackage(ChangePackage newChangePackage) {
		if (newChangePackage != changePackage) {
			NotificationChain msgs = null;
			if (changePackage != null)
				msgs = ((InternalEObject)changePackage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_INFO__CHANGE_PACKAGE, null, msgs);
			if (newChangePackage != null)
				msgs = ((InternalEObject)newChangePackage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_INFO__CHANGE_PACKAGE, null, msgs);
			msgs = basicSetChangePackage(newChangePackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VersioningPackage.HISTORY_INFO__CHANGE_PACKAGE, newChangePackage, newChangePackage));
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
				return ((InternalEList<?>)getTagSpecs()).basicRemove(otherEnd, msgs);
			case VersioningPackage.HISTORY_INFO__VERSION_PROPERTIES:
				return ((InternalEList<?>)getVersionProperties()).basicRemove(otherEnd, msgs);
			case VersioningPackage.HISTORY_INFO__CHANGE_PACKAGE:
				return basicSetChangePackage(null, msgs);
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
				if (resolve) return getPrimerySpec();
				return basicGetPrimerySpec();
			case VersioningPackage.HISTORY_INFO__LOG_MESSAGE:
				if (resolve) return getLogMessage();
				return basicGetLogMessage();
			case VersioningPackage.HISTORY_INFO__TAG_SPECS:
				return getTagSpecs();
			case VersioningPackage.HISTORY_INFO__VERSION_PROPERTIES:
				return getVersionProperties();
			case VersioningPackage.HISTORY_INFO__CHANGE_PACKAGE:
				if (resolve) return getChangePackage();
				return basicGetChangePackage();
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
				setPrimerySpec((PrimaryVersionSpec)newValue);
				return;
			case VersioningPackage.HISTORY_INFO__LOG_MESSAGE:
				setLogMessage((LogMessage)newValue);
				return;
			case VersioningPackage.HISTORY_INFO__TAG_SPECS:
				getTagSpecs().clear();
				getTagSpecs().addAll((Collection<? extends TagVersionSpec>)newValue);
				return;
			case VersioningPackage.HISTORY_INFO__VERSION_PROPERTIES:
				getVersionProperties().clear();
				getVersionProperties().addAll((Collection<? extends VersionProperty>)newValue);
				return;
			case VersioningPackage.HISTORY_INFO__CHANGE_PACKAGE:
				setChangePackage((ChangePackage)newValue);
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
				setPrimerySpec((PrimaryVersionSpec)null);
				return;
			case VersioningPackage.HISTORY_INFO__LOG_MESSAGE:
				setLogMessage((LogMessage)null);
				return;
			case VersioningPackage.HISTORY_INFO__TAG_SPECS:
				getTagSpecs().clear();
				return;
			case VersioningPackage.HISTORY_INFO__VERSION_PROPERTIES:
				getVersionProperties().clear();
				return;
			case VersioningPackage.HISTORY_INFO__CHANGE_PACKAGE:
				setChangePackage((ChangePackage)null);
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
			case VersioningPackage.HISTORY_INFO__VERSION_PROPERTIES:
				return versionProperties != null && !versionProperties.isEmpty();
			case VersioningPackage.HISTORY_INFO__CHANGE_PACKAGE:
				return changePackage != null;
		}
		return super.eIsSet(featureID);
	}

} // HistoryInfoImpl

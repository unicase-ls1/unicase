/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.configuration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.jdt.configuration.ConfigurationPackage;
import org.unicase.emfstore.jdt.configuration.SimpleVersionMapping;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Simple Version Mapping</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.jdt.configuration.impl.SimpleVersionMappingImpl#getEMFStoreRevision <em>EMF Store Revision</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleVersionMappingImpl extends VersionMappingImpl implements SimpleVersionMapping {
	/**
	 * The default value of the '{@link #getEMFStoreRevision() <em>EMF Store Revision</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEMFStoreRevision()
	 * @generated
	 * @ordered
	 */
	protected static final int EMF_STORE_REVISION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEMFStoreRevision() <em>EMF Store Revision</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEMFStoreRevision()
	 * @generated
	 * @ordered
	 */
	protected int emfStoreRevision = EMF_STORE_REVISION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleVersionMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.SIMPLE_VERSION_MAPPING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getEMFStoreRevision() {
		return emfStoreRevision;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEMFStoreRevision(int newEMFStoreRevision) {
		int oldEMFStoreRevision = emfStoreRevision;
		emfStoreRevision = newEMFStoreRevision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SIMPLE_VERSION_MAPPING__EMF_STORE_REVISION, oldEMFStoreRevision, emfStoreRevision));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.SIMPLE_VERSION_MAPPING__EMF_STORE_REVISION:
				return getEMFStoreRevision();
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
			case ConfigurationPackage.SIMPLE_VERSION_MAPPING__EMF_STORE_REVISION:
				setEMFStoreRevision((Integer)newValue);
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
			case ConfigurationPackage.SIMPLE_VERSION_MAPPING__EMF_STORE_REVISION:
				setEMFStoreRevision(EMF_STORE_REVISION_EDEFAULT);
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
			case ConfigurationPackage.SIMPLE_VERSION_MAPPING__EMF_STORE_REVISION:
				return emfStoreRevision != EMF_STORE_REVISION_EDEFAULT;
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
		result.append(" (EMFStoreRevision: ");
		result.append(emfStoreRevision);
		result.append(')');
		return result.toString();
	}

} // SimpleVersionMappingImpl

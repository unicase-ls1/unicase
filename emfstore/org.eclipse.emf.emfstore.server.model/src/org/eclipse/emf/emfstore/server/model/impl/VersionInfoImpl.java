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
package org.eclipse.emf.emfstore.server.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.emfstore.server.model.ModelPackage;
import org.eclipse.emf.emfstore.server.model.VersionInfo;
import org.osgi.framework.Version;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Version Info</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.impl.VersionInfoImpl#getEmfStoreVersionString <em>Emf Store Version
 * String</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class VersionInfoImpl extends EObjectImpl implements VersionInfo {
	/**
	 * The default value of the '{@link #getEmfStoreVersionString() <em>Emf Store Version String</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEmfStoreVersionString()
	 * @generated
	 * @ordered
	 */
	protected static final String EMF_STORE_VERSION_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEmfStoreVersionString() <em>Emf Store Version String</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEmfStoreVersionString()
	 * @generated
	 * @ordered
	 */
	protected String emfStoreVersionString = EMF_STORE_VERSION_STRING_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected VersionInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.VERSION_INFO;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getEmfStoreVersionString() {
		return emfStoreVersionString;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setEmfStoreVersionString(String newEmfStoreVersionString) {
		String oldEmfStoreVersionString = emfStoreVersionString;
		emfStoreVersionString = newEmfStoreVersionString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.VERSION_INFO__EMF_STORE_VERSION_STRING,
				oldEmfStoreVersionString, emfStoreVersionString));
	}

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> Get the version.
	 * 
	 * @return the version <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Version getEmfStoreVersion() {
		return new Version(getEmfStoreVersionString());
	}

	/**
	 * <!-- begin-user-doc --> Set the version String.
	 * 
	 * @param emfStoreVersion the version <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setEmfStoreVersion(Version emfStoreVersion) {
		setEmfStoreVersionString(emfStoreVersion.toString());
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ModelPackage.VERSION_INFO__EMF_STORE_VERSION_STRING:
			return getEmfStoreVersionString();
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
		case ModelPackage.VERSION_INFO__EMF_STORE_VERSION_STRING:
			setEmfStoreVersionString((String) newValue);
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
		case ModelPackage.VERSION_INFO__EMF_STORE_VERSION_STRING:
			setEmfStoreVersionString(EMF_STORE_VERSION_STRING_EDEFAULT);
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
		case ModelPackage.VERSION_INFO__EMF_STORE_VERSION_STRING:
			return EMF_STORE_VERSION_STRING_EDEFAULT == null ? emfStoreVersionString != null
				: !EMF_STORE_VERSION_STRING_EDEFAULT.equals(emfStoreVersionString);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (emfStoreVersionString: ");
		result.append(emfStoreVersionString);
		result.append(')');
		return result.toString();
	}

} // VersionInfoImpl

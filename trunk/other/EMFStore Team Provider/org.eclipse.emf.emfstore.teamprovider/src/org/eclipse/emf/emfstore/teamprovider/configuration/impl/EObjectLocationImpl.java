/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider.configuration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage;
import org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreLocation;
import org.eclipse.emf.emfstore.teamprovider.configuration.EObjectLocation;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>EObject Location</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.impl.EObjectLocationImpl#getEMFStoreLocation <em>EMF Store Location
 * </em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.impl.EObjectLocationImpl#getEObjectID <em>EObject ID</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EObjectLocationImpl extends EObjectImpl implements EObjectLocation {
	/**
	 * The cached value of the '{@link #getEMFStoreLocation() <em>EMF Store Location</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEMFStoreLocation()
	 * @generated
	 * @ordered
	 */
	protected EMFStoreLocation emfStoreLocation;

	/**
	 * The default value of the '{@link #getEObjectID() <em>EObject ID</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getEObjectID()
	 * @generated
	 * @ordered
	 */
	protected static final String EOBJECT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEObjectID() <em>EObject ID</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getEObjectID()
	 * @generated
	 * @ordered
	 */
	protected String eObjectID = EOBJECT_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EObjectLocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.EOBJECT_LOCATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EMFStoreLocation getEMFStoreLocation() {
		return emfStoreLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetEMFStoreLocation(EMFStoreLocation newEMFStoreLocation, NotificationChain msgs) {
		EMFStoreLocation oldEMFStoreLocation = emfStoreLocation;
		emfStoreLocation = newEMFStoreLocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				ConfigurationPackage.EOBJECT_LOCATION__EMF_STORE_LOCATION, oldEMFStoreLocation, newEMFStoreLocation);
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
	public void setEMFStoreLocation(EMFStoreLocation newEMFStoreLocation) {
		if (newEMFStoreLocation != emfStoreLocation) {
			NotificationChain msgs = null;
			if (emfStoreLocation != null)
				msgs = ((InternalEObject) emfStoreLocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- ConfigurationPackage.EOBJECT_LOCATION__EMF_STORE_LOCATION, null, msgs);
			if (newEMFStoreLocation != null)
				msgs = ((InternalEObject) newEMFStoreLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- ConfigurationPackage.EOBJECT_LOCATION__EMF_STORE_LOCATION, null, msgs);
			msgs = basicSetEMFStoreLocation(newEMFStoreLocation, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				ConfigurationPackage.EOBJECT_LOCATION__EMF_STORE_LOCATION, newEMFStoreLocation, newEMFStoreLocation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getEObjectID() {
		return eObjectID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setEObjectID(String newEObjectID) {
		String oldEObjectID = eObjectID;
		eObjectID = newEObjectID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.EOBJECT_LOCATION__EOBJECT_ID,
				oldEObjectID, eObjectID));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ConfigurationPackage.EOBJECT_LOCATION__EMF_STORE_LOCATION:
			return basicSetEMFStoreLocation(null, msgs);
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
		case ConfigurationPackage.EOBJECT_LOCATION__EMF_STORE_LOCATION:
			return getEMFStoreLocation();
		case ConfigurationPackage.EOBJECT_LOCATION__EOBJECT_ID:
			return getEObjectID();
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
		case ConfigurationPackage.EOBJECT_LOCATION__EMF_STORE_LOCATION:
			setEMFStoreLocation((EMFStoreLocation) newValue);
			return;
		case ConfigurationPackage.EOBJECT_LOCATION__EOBJECT_ID:
			setEObjectID((String) newValue);
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
		case ConfigurationPackage.EOBJECT_LOCATION__EMF_STORE_LOCATION:
			setEMFStoreLocation((EMFStoreLocation) null);
			return;
		case ConfigurationPackage.EOBJECT_LOCATION__EOBJECT_ID:
			setEObjectID(EOBJECT_ID_EDEFAULT);
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
		case ConfigurationPackage.EOBJECT_LOCATION__EMF_STORE_LOCATION:
			return emfStoreLocation != null;
		case ConfigurationPackage.EOBJECT_LOCATION__EOBJECT_ID:
			return EOBJECT_ID_EDEFAULT == null ? eObjectID != null : !EOBJECT_ID_EDEFAULT.equals(eObjectID);
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
		result.append(" (EObjectID: ");
		result.append(eObjectID);
		result.append(')');
		return result.toString();
	}

} // EObjectLocationImpl

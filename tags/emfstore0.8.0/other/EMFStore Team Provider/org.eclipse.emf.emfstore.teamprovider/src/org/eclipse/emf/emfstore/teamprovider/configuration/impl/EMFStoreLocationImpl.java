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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage;
import org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreLocation;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>EMF Store Location</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.impl.EMFStoreLocationImpl#getHost <em>Host</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.impl.EMFStoreLocationImpl#getPort <em>Port</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.impl.EMFStoreLocationImpl#getCertificate <em>Certificate</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.impl.EMFStoreLocationImpl#getProjectID <em>Project ID</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EMFStoreLocationImpl extends EObjectImpl implements EMFStoreLocation {
	/**
	 * The default value of the '{@link #getHost() <em>Host</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected static final String HOST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHost() <em>Host</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected String host = HOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final int PORT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected int port = PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCertificate() <em>Certificate</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getCertificate()
	 * @generated
	 * @ordered
	 */
	protected static final String CERTIFICATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCertificate() <em>Certificate</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getCertificate()
	 * @generated
	 * @ordered
	 */
	protected String certificate = CERTIFICATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProjectID() <em>Project ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getProjectID()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectID() <em>Project ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getProjectID()
	 * @generated
	 * @ordered
	 */
	protected String projectID = PROJECT_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EMFStoreLocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.EMF_STORE_LOCATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getHost() {
		return host;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHost(String newHost) {
		String oldHost = host;
		host = newHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.EMF_STORE_LOCATION__HOST, oldHost, host));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(int newPort) {
		int oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.EMF_STORE_LOCATION__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCertificate() {
		return certificate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCertificate(String newCertificate) {
		String oldCertificate = certificate;
		certificate = newCertificate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.EMF_STORE_LOCATION__CERTIFICATE, oldCertificate, certificate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectID() {
		return projectID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectID(String newProjectID) {
		String oldProjectID = projectID;
		projectID = newProjectID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.EMF_STORE_LOCATION__PROJECT_ID, oldProjectID, projectID));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.EMF_STORE_LOCATION__HOST:
				return getHost();
			case ConfigurationPackage.EMF_STORE_LOCATION__PORT:
				return getPort();
			case ConfigurationPackage.EMF_STORE_LOCATION__CERTIFICATE:
				return getCertificate();
			case ConfigurationPackage.EMF_STORE_LOCATION__PROJECT_ID:
				return getProjectID();
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
			case ConfigurationPackage.EMF_STORE_LOCATION__HOST:
				setHost((String)newValue);
				return;
			case ConfigurationPackage.EMF_STORE_LOCATION__PORT:
				setPort((Integer)newValue);
				return;
			case ConfigurationPackage.EMF_STORE_LOCATION__CERTIFICATE:
				setCertificate((String)newValue);
				return;
			case ConfigurationPackage.EMF_STORE_LOCATION__PROJECT_ID:
				setProjectID((String)newValue);
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
			case ConfigurationPackage.EMF_STORE_LOCATION__HOST:
				setHost(HOST_EDEFAULT);
				return;
			case ConfigurationPackage.EMF_STORE_LOCATION__PORT:
				setPort(PORT_EDEFAULT);
				return;
			case ConfigurationPackage.EMF_STORE_LOCATION__CERTIFICATE:
				setCertificate(CERTIFICATE_EDEFAULT);
				return;
			case ConfigurationPackage.EMF_STORE_LOCATION__PROJECT_ID:
				setProjectID(PROJECT_ID_EDEFAULT);
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
			case ConfigurationPackage.EMF_STORE_LOCATION__HOST:
				return HOST_EDEFAULT == null ? host != null : !HOST_EDEFAULT.equals(host);
			case ConfigurationPackage.EMF_STORE_LOCATION__PORT:
				return port != PORT_EDEFAULT;
			case ConfigurationPackage.EMF_STORE_LOCATION__CERTIFICATE:
				return CERTIFICATE_EDEFAULT == null ? certificate != null : !CERTIFICATE_EDEFAULT.equals(certificate);
			case ConfigurationPackage.EMF_STORE_LOCATION__PROJECT_ID:
				return PROJECT_ID_EDEFAULT == null ? projectID != null : !PROJECT_ID_EDEFAULT.equals(projectID);
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
		result.append(" (Host: ");
		result.append(host);
		result.append(", Port: ");
		result.append(port);
		result.append(", Certificate: ");
		result.append(certificate);
		result.append(", ProjectID: ");
		result.append(projectID);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @generated NOT
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EMFStoreLocation) {
			EMFStoreLocation emfStoreLocation = (EMFStoreLocation) obj;
			// certificate is with intension not included
			return host.equals(emfStoreLocation.getHost()) && port == emfStoreLocation.getPort()
				&& projectID.equals(emfStoreLocation.getProjectID());
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 * @generated NOT
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

} // EMFStoreLocationImpl

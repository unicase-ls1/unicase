/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider.configuration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>EMF Store Location</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreLocation#getHost <em>Host</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreLocation#getPort <em>Port</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreLocation#getCertificate <em>Certificate</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreLocation#getProjectID <em>Project ID</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEMFStoreLocation()
 * @model
 * @generated
 */
public interface EMFStoreLocation extends EObject {
	/**
	 * Returns the value of the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host</em>' attribute.
	 * @see #setHost(String)
	 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEMFStoreLocation_Host()
	 * @model required="true"
	 * @generated
	 */
	String getHost();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreLocation#getHost <em>Host</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host</em>' attribute.
	 * @see #getHost()
	 * @generated
	 */
	void setHost(String value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(int)
	 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEMFStoreLocation_Port()
	 * @model required="true"
	 * @generated
	 */
	int getPort();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreLocation#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(int value);

	/**
	 * Returns the value of the '<em><b>Certificate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Certificate</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Certificate</em>' attribute.
	 * @see #setCertificate(String)
	 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEMFStoreLocation_Certificate()
	 * @model required="true"
	 * @generated
	 */
	String getCertificate();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreLocation#getCertificate <em>Certificate</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Certificate</em>' attribute.
	 * @see #getCertificate()
	 * @generated
	 */
	void setCertificate(String value);

	/**
	 * Returns the value of the '<em><b>Project ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project ID</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project ID</em>' attribute.
	 * @see #setProjectID(String)
	 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEMFStoreLocation_ProjectID()
	 * @model required="true"
	 * @generated
	 */
	String getProjectID();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreLocation#getProjectID <em>Project ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project ID</em>' attribute.
	 * @see #getProjectID()
	 * @generated
	 */
	void setProjectID(String value);

} // EMFStoreLocation

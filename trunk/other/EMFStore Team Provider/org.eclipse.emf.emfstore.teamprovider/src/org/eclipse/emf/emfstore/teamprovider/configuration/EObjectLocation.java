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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>EObject Location</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.EObjectLocation#getEMFStoreLocation <em>EMF Store Location</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.EObjectLocation#getEObjectID <em>EObject ID</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEObjectLocation()
 * @model
 * @generated
 */
public interface EObjectLocation extends EObject {
	/**
	 * Returns the value of the '<em><b>EMF Store Location</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EMF Store Location</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>EMF Store Location</em>' containment reference.
	 * @see #setEMFStoreLocation(EMFStoreLocation)
	 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEObjectLocation_EMFStoreLocation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EMFStoreLocation getEMFStoreLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.teamprovider.configuration.EObjectLocation#getEMFStoreLocation
	 * <em>EMF Store Location</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>EMF Store Location</em>' containment reference.
	 * @see #getEMFStoreLocation()
	 * @generated
	 */
	void setEMFStoreLocation(EMFStoreLocation value);

	/**
	 * Returns the value of the '<em><b>EObject ID</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EObject ID</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>EObject ID</em>' attribute.
	 * @see #setEObjectID(String)
	 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEObjectLocation_EObjectID()
	 * @model required="true"
	 * @generated
	 */
	String getEObjectID();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.teamprovider.configuration.EObjectLocation#getEObjectID
	 * <em>EObject ID</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>EObject ID</em>' attribute.
	 * @see #getEObjectID()
	 * @generated
	 */
	void setEObjectID(String value);

} // EObjectLocation

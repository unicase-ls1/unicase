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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Entry</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.Entry#getConfiguration <em>Configuration</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.Entry#getProjectRelativeLocation <em>Project Relative Location
 * </em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.Entry#getEObjectLocation <em>EObject Location</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.Entry#getVersionMapping <em>Version Mapping</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.Entry#isMarkedForDeletion <em>Marked For Deletion</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEntry()
 * @model
 * @generated
 */
public interface Entry extends EObject {
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreJDTConfiguration#getEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Configuration</em>' container reference.
	 * @see #setConfiguration(EMFStoreJDTConfiguration)
	 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEntry_Configuration()
	 * @see org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreJDTConfiguration#getEntry
	 * @model opposite="Entry" required="true" transient="false"
	 * @generated
	 */
	EMFStoreJDTConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.teamprovider.configuration.Entry#getConfiguration
	 * <em>Configuration</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Configuration</em>' container reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(EMFStoreJDTConfiguration value);

	/**
	 * Returns the value of the '<em><b>Project Relative Location</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Relative Location</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Project Relative Location</em>' attribute.
	 * @see #setProjectRelativeLocation(String)
	 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEntry_ProjectRelativeLocation()
	 * @model required="true"
	 * @generated
	 */
	String getProjectRelativeLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.teamprovider.configuration.Entry#getProjectRelativeLocation
	 * <em>Project Relative Location</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Project Relative Location</em>' attribute.
	 * @see #getProjectRelativeLocation()
	 * @generated
	 */
	void setProjectRelativeLocation(String value);

	/**
	 * Returns the value of the '<em><b>EObject Location</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EObject Location</em>' containment reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>EObject Location</em>' containment reference.
	 * @see #setEObjectLocation(EObjectLocation)
	 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEntry_EObjectLocation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EObjectLocation getEObjectLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.teamprovider.configuration.Entry#getEObjectLocation
	 * <em>EObject Location</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>EObject Location</em>' containment reference.
	 * @see #getEObjectLocation()
	 * @generated
	 */
	void setEObjectLocation(EObjectLocation value);

	/**
	 * Returns the value of the '<em><b>Version Mapping</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Mapping</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Version Mapping</em>' containment reference.
	 * @see #setVersionMapping(VersionMapping)
	 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEntry_VersionMapping()
	 * @model containment="true"
	 * @generated
	 */
	VersionMapping getVersionMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.teamprovider.configuration.Entry#getVersionMapping
	 * <em>Version Mapping</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Version Mapping</em>' containment reference.
	 * @see #getVersionMapping()
	 * @generated
	 */
	void setVersionMapping(VersionMapping value);

	/**
	 * Returns the value of the '<em><b>Marked For Deletion</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Marked For Deletion</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Marked For Deletion</em>' attribute.
	 * @see #setMarkedForDeletion(boolean)
	 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEntry_MarkedForDeletion()
	 * @model
	 * @generated
	 */
	boolean isMarkedForDeletion();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.teamprovider.configuration.Entry#isMarkedForDeletion
	 * <em>Marked For Deletion</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Marked For Deletion</em>' attribute.
	 * @see #isMarkedForDeletion()
	 * @generated
	 */
	void setMarkedForDeletion(boolean value);

} // Entry

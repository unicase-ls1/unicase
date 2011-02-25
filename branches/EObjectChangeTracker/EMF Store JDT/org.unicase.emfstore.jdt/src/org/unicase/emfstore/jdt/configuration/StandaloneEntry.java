/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.configuration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Standalone Entry</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.jdt.configuration.StandaloneEntry#getConfiguration <em>Configuration</em>}</li>
 * <li>{@link org.unicase.emfstore.jdt.configuration.StandaloneEntry#getProjectRelativeLocation <em>Project Relative
 * Location</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage#getStandaloneEntry()
 * @model
 * @generated
 */
public interface StandaloneEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration#getStandaloneEntry <em>Standalone Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' container reference.
	 * @see #setConfiguration(EMFStoreJDTConfiguration)
	 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage#getStandaloneEntry_Configuration()
	 * @see org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration#getStandaloneEntry
	 * @model opposite="StandaloneEntry" required="true" transient="false"
	 * @generated
	 */
	EMFStoreJDTConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.jdt.configuration.StandaloneEntry#getConfiguration <em>Configuration</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' container reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(EMFStoreJDTConfiguration value);

	/**
	 * Returns the value of the '<em><b>Project Relative Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Relative Location</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Relative Location</em>' attribute.
	 * @see #setProjectRelativeLocation(String)
	 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage#getStandaloneEntry_ProjectRelativeLocation()
	 * @model required="true"
	 * @generated
	 */
	String getProjectRelativeLocation();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.jdt.configuration.StandaloneEntry#getProjectRelativeLocation <em>Project Relative Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Relative Location</em>' attribute.
	 * @see #getProjectRelativeLocation()
	 * @generated
	 */
	void setProjectRelativeLocation(String value);

	/**
	 * Returns the value of the '<em><b>Current Team Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Team Revision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Team Revision</em>' attribute.
	 * @see #setCurrentTeamRevision(String)
	 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage#getStandaloneEntry_CurrentTeamRevision()
	 * @model
	 * @generated
	 */
	String getCurrentTeamRevision();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.jdt.configuration.StandaloneEntry#getCurrentTeamRevision <em>Current Team Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Team Revision</em>' attribute.
	 * @see #getCurrentTeamRevision()
	 * @generated
	 */
	void setCurrentTeamRevision(String value);

} // StandaloneEntry

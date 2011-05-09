/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.teamprovider.configuration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>EMF Store Team Provider Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreTeamProviderConfiguration#getEntry <em>Entry
 * </em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreTeamProviderConfiguration#getAnywayCommit <em>
 * Anyway Commit</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEMFStoreTeamProviderConfiguration()
 * @model
 * @generated
 */
public interface EMFStoreTeamProviderConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Entry</b></em>' containment reference list. The list contents are of type
	 * {@link org.eclipse.emf.emfstore.teamprovider.configuration.Entry}. It is bidirectional and its opposite is '
	 * {@link org.eclipse.emf.emfstore.teamprovider.configuration.Entry#getConfiguration <em>Configuration</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Entry</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEMFStoreTeamProviderConfiguration_Entry()
	 * @see org.eclipse.emf.emfstore.teamprovider.configuration.Entry#getConfiguration
	 * @model opposite="Configuration" containment="true"
	 * @generated
	 */
	EList<Entry> getEntry();

	/**
	 * Returns the value of the '<em><b>Anyway Commit</b></em>' containment reference list. The list contents are of
	 * type {@link org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreLocation}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anyway Commit</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Anyway Commit</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage#getEMFStoreTeamProviderConfiguration_AnywayCommit()
	 * @model containment="true"
	 * @generated
	 */
	EList<EMFStoreLocation> getAnywayCommit();

	/**
	 * @generated NOT
	 */
	void save();
} // EMFStoreTeamProviderConfiguration

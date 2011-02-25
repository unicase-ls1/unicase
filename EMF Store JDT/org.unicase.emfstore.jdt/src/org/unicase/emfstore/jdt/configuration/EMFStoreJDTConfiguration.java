/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.configuration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>EMF Store JDT Configuration</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration#getStandaloneEntry <em>Standalone Entry</em>}</li>
 *   <li>{@link org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration#getAnywayCommit <em>Anyway Commit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage#getEMFStoreJDTConfiguration()
 * @model
 * @generated
 */
public interface EMFStoreJDTConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Entry</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.emfstore.jdt.configuration.Entry}. It is bidirectional and its opposite is '
	 * {@link org.unicase.emfstore.jdt.configuration.Entry#getConfiguration <em>Configuration</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Entry</em>' containment reference list.
	 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage#getEMFStoreJDTConfiguration_Entry()
	 * @see org.unicase.emfstore.jdt.configuration.Entry#getConfiguration
	 * @model opposite="Configuration" containment="true"
	 * @generated
	 */
	EList<Entry> getEntry();

	/**
	 * Returns the value of the '<em><b>Standalone Entry</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.jdt.configuration.StandaloneEntry}.
	 * It is bidirectional and its opposite is '{@link org.unicase.emfstore.jdt.configuration.StandaloneEntry#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Standalone Entry</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Standalone Entry</em>' containment reference list.
	 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage#getEMFStoreJDTConfiguration_StandaloneEntry()
	 * @see org.unicase.emfstore.jdt.configuration.StandaloneEntry#getConfiguration
	 * @model opposite="Configuration" containment="true"
	 * @generated
	 */
	EList<StandaloneEntry> getStandaloneEntry();

	/**
	 * Returns the value of the '<em><b>Anyway Commit</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.jdt.configuration.EMFStoreLocation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anyway Commit</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anyway Commit</em>' containment reference list.
	 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage#getEMFStoreJDTConfiguration_AnywayCommit()
	 * @model containment="true"
	 * @generated
	 */
	EList<EMFStoreLocation> getAnywayCommit();

	/**
	 * @generated NOT
	 */
	void save();

} // EMFStoreJDTConfiguration

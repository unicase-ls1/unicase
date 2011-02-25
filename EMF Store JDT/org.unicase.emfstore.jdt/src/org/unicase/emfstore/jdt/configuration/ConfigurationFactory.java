/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.configuration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage
 * @generated
 */
public interface ConfigurationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	ConfigurationFactory eINSTANCE = org.unicase.emfstore.jdt.configuration.impl.ConfigurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EMF Store JDT Configuration</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>EMF Store JDT Configuration</em>'.
	 * @generated
	 */
	EMFStoreJDTConfiguration createEMFStoreJDTConfiguration();

	/**
	 * Returns a new object of class '<em>EMF Store Location</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>EMF Store Location</em>'.
	 * @generated
	 */
	EMFStoreLocation createEMFStoreLocation();

	/**
	 * Returns a new object of class '<em>Entry</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Entry</em>'.
	 * @generated
	 */
	Entry createEntry();

	/**
	 * Returns a new object of class '<em>EObject Location</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>EObject Location</em>'.
	 * @generated
	 */
	EObjectLocation createEObjectLocation();

	/**
	 * Returns a new object of class '<em>History Version Mapping</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>History Version Mapping</em>'.
	 * @generated
	 */
	HistoryVersionMapping createHistoryVersionMapping();

	/**
	 * Returns a new object of class '<em>History Version Mapping Entry</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>History Version Mapping Entry</em>'.
	 * @generated
	 */
	HistoryVersionMappingEntry createHistoryVersionMappingEntry();

	/**
	 * Returns a new object of class '<em>Simple Version Mapping</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Version Mapping</em>'.
	 * @generated
	 */
	SimpleVersionMapping createSimpleVersionMapping();

	/**
	 * Returns a new object of class '<em>Standalone Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Standalone Entry</em>'.
	 * @generated
	 */
	StandaloneEntry createStandaloneEntry();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConfigurationPackage getConfigurationPackage();

} // ConfigurationFactory

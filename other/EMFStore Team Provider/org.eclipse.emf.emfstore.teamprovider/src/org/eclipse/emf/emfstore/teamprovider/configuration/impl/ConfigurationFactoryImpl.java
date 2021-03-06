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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.emfstore.teamprovider.configuration.*;
import org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationFactory;
import org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage;
import org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreTeamProviderConfiguration;
import org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreLocation;
import org.eclipse.emf.emfstore.teamprovider.configuration.EObjectLocation;
import org.eclipse.emf.emfstore.teamprovider.configuration.Entry;
import org.eclipse.emf.emfstore.teamprovider.configuration.HistoryVersionMapping;
import org.eclipse.emf.emfstore.teamprovider.configuration.HistoryVersionMappingEntry;
import org.eclipse.emf.emfstore.teamprovider.configuration.SimpleVersionMapping;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ConfigurationFactoryImpl extends EFactoryImpl implements ConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ConfigurationFactory init() {
		try {
			ConfigurationFactory theConfigurationFactory = (ConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory("http://emfstore.org/teamprovider"); 
			if (theConfigurationFactory != null) {
				return theConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ConfigurationPackage.EMF_STORE_TEAM_PROVIDER_CONFIGURATION: return createEMFStoreTeamProviderConfiguration();
			case ConfigurationPackage.EMF_STORE_LOCATION: return createEMFStoreLocation();
			case ConfigurationPackage.ENTRY: return createEntry();
			case ConfigurationPackage.EOBJECT_LOCATION: return createEObjectLocation();
			case ConfigurationPackage.HISTORY_VERSION_MAPPING: return createHistoryVersionMapping();
			case ConfigurationPackage.HISTORY_VERSION_MAPPING_ENTRY: return createHistoryVersionMappingEntry();
			case ConfigurationPackage.SIMPLE_VERSION_MAPPING: return createSimpleVersionMapping();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMFStoreTeamProviderConfiguration createEMFStoreTeamProviderConfiguration() {
		EMFStoreTeamProviderConfigurationImpl emfStoreTeamProviderConfiguration = new EMFStoreTeamProviderConfigurationImpl();
		return emfStoreTeamProviderConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Entry createEntry() {
		EntryImpl entry = new EntryImpl();
		return entry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMFStoreLocation createEMFStoreLocation() {
		EMFStoreLocationImpl emfStoreLocation = new EMFStoreLocationImpl();
		return emfStoreLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObjectLocation createEObjectLocation() {
		EObjectLocationImpl eObjectLocation = new EObjectLocationImpl();
		return eObjectLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HistoryVersionMapping createHistoryVersionMapping() {
		HistoryVersionMappingImpl historyVersionMapping = new HistoryVersionMappingImpl();
		return historyVersionMapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HistoryVersionMappingEntry createHistoryVersionMappingEntry() {
		HistoryVersionMappingEntryImpl historyVersionMappingEntry = new HistoryVersionMappingEntryImpl();
		return historyVersionMappingEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleVersionMapping createSimpleVersionMapping() {
		SimpleVersionMappingImpl simpleVersionMapping = new SimpleVersionMappingImpl();
		return simpleVersionMapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationPackage getConfigurationPackage() {
		return (ConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConfigurationPackage getPackage() {
		return ConfigurationPackage.eINSTANCE;
	}

} // ConfigurationFactoryImpl

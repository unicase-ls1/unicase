/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.configuration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.emfstore.jdt.configuration.ConfigurationFactory;
import org.unicase.emfstore.jdt.configuration.ConfigurationPackage;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.configuration.EMFStoreLocation;
import org.unicase.emfstore.jdt.configuration.EObjectLocation;
import org.unicase.emfstore.jdt.configuration.Entry;
import org.unicase.emfstore.jdt.configuration.HistoryVersionMapping;
import org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry;
import org.unicase.emfstore.jdt.configuration.SimpleVersionMapping;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ConfigurationFactoryImpl extends EFactoryImpl implements ConfigurationFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ConfigurationFactory init() {
		try {
			ConfigurationFactory theConfigurationFactory = (ConfigurationFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://emfstore.org/jdt");
			if (theConfigurationFactory != null) {
				return theConfigurationFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConfigurationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ConfigurationPackage.EMF_STORE_JDT_CONFIGURATION:
			return createEMFStoreJDTConfiguration();
		case ConfigurationPackage.EMF_STORE_LOCATION:
			return createEMFStoreLocation();
		case ConfigurationPackage.ENTRY:
			return createEntry();
		case ConfigurationPackage.EOBJECT_LOCATION:
			return createEObjectLocation();
		case ConfigurationPackage.HISTORY_VERSION_MAPPING:
			return createHistoryVersionMapping();
		case ConfigurationPackage.HISTORY_VERSION_MAPPING_ENTRY:
			return createHistoryVersionMappingEntry();
		case ConfigurationPackage.SIMPLE_VERSION_MAPPING:
			return createSimpleVersionMapping();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EMFStoreJDTConfiguration createEMFStoreJDTConfiguration() {
		EMFStoreJDTConfigurationImpl emfStoreJDTConfiguration = new EMFStoreJDTConfigurationImpl();
		return emfStoreJDTConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Entry createEntry() {
		EntryImpl entry = new EntryImpl();
		return entry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EMFStoreLocation createEMFStoreLocation() {
		EMFStoreLocationImpl emfStoreLocation = new EMFStoreLocationImpl();
		return emfStoreLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObjectLocation createEObjectLocation() {
		EObjectLocationImpl eObjectLocation = new EObjectLocationImpl();
		return eObjectLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public HistoryVersionMapping createHistoryVersionMapping() {
		HistoryVersionMappingImpl historyVersionMapping = new HistoryVersionMappingImpl();
		return historyVersionMapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public HistoryVersionMappingEntry createHistoryVersionMappingEntry() {
		HistoryVersionMappingEntryImpl historyVersionMappingEntry = new HistoryVersionMappingEntryImpl();
		return historyVersionMappingEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SimpleVersionMapping createSimpleVersionMapping() {
		SimpleVersionMappingImpl simpleVersionMapping = new SimpleVersionMappingImpl();
		return simpleVersionMapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConfigurationPackage getConfigurationPackage() {
		return (ConfigurationPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConfigurationPackage getPackage() {
		return ConfigurationPackage.eINSTANCE;
	}

} // ConfigurationFactoryImpl

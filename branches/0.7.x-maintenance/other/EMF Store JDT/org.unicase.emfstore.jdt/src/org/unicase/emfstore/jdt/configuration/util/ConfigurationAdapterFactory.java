/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.configuration.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.jdt.configuration.ConfigurationPackage;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.configuration.EMFStoreLocation;
import org.unicase.emfstore.jdt.configuration.EObjectLocation;
import org.unicase.emfstore.jdt.configuration.Entry;
import org.unicase.emfstore.jdt.configuration.HistoryVersionMapping;
import org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry;
import org.unicase.emfstore.jdt.configuration.SimpleVersionMapping;
import org.unicase.emfstore.jdt.configuration.VersionMapping;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage
 * @generated
 */
public class ConfigurationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ConfigurationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConfigurationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ConfigurationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc --> This
	 * implementation returns <code>true</code> if the object is either the model's package or is an instance object of
	 * the model. <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ConfigurationSwitch<Adapter> modelSwitch = new ConfigurationSwitch<Adapter>() {
		@Override
		public Adapter caseEMFStoreJDTConfiguration(EMFStoreJDTConfiguration object) {
			return createEMFStoreJDTConfigurationAdapter();
		}

		@Override
		public Adapter caseEMFStoreLocation(EMFStoreLocation object) {
			return createEMFStoreLocationAdapter();
		}

		@Override
		public Adapter caseEntry(Entry object) {
			return createEntryAdapter();
		}

		@Override
		public Adapter caseEObjectLocation(EObjectLocation object) {
			return createEObjectLocationAdapter();
		}

		@Override
		public Adapter caseVersionMapping(VersionMapping object) {
			return createVersionMappingAdapter();
		}

		@Override
		public Adapter caseHistoryVersionMapping(HistoryVersionMapping object) {
			return createHistoryVersionMappingAdapter();
		}

		@Override
		public Adapter caseHistoryVersionMappingEntry(HistoryVersionMappingEntry object) {
			return createHistoryVersionMappingEntryAdapter();
		}

		@Override
		public Adapter caseSimpleVersionMapping(SimpleVersionMapping object) {
			return createSimpleVersionMappingAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration <em>EMF Store JDT Configuration</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration
	 * @generated
	 */
	public Adapter createEMFStoreJDTConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.jdt.configuration.Entry <em>Entry</em>}
	 * '. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.emfstore.jdt.configuration.Entry
	 * @generated
	 */
	public Adapter createEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.jdt.configuration.VersionMapping
	 * <em>Version Mapping</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.emfstore.jdt.configuration.VersionMapping
	 * @generated
	 */
	public Adapter createVersionMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.unicase.emfstore.jdt.configuration.HistoryVersionMapping <em>History Version Mapping</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.emfstore.jdt.configuration.HistoryVersionMapping
	 * @generated
	 */
	public Adapter createHistoryVersionMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry <em>History Version Mapping Entry</em>}
	 * '. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry
	 * @generated
	 */
	public Adapter createHistoryVersionMappingEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.jdt.configuration.SimpleVersionMapping
	 * <em>Simple Version Mapping</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.emfstore.jdt.configuration.SimpleVersionMapping
	 * @generated
	 */
	public Adapter createSimpleVersionMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.jdt.configuration.EMFStoreLocation
	 * <em>EMF Store Location</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.emfstore.jdt.configuration.EMFStoreLocation
	 * @generated
	 */
	public Adapter createEMFStoreLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.jdt.configuration.EObjectLocation
	 * <em>EObject Location</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.emfstore.jdt.configuration.EObjectLocation
	 * @generated
	 */
	public Adapter createEObjectLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This default implementation returns null.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // ConfigurationAdapterFactory

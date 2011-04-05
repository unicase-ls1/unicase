/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.configuration.impl;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.jdt.configuration.ConfigurationPackage;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.configuration.EMFStoreLocation;
import org.unicase.emfstore.jdt.configuration.Entry;
import org.unicase.metamodel.util.ModelUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>EMF Store JDT Configuration</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.jdt.configuration.impl.EMFStoreJDTConfigurationImpl#getEntry <em>Entry</em>}</li>
 * <li>{@link org.unicase.emfstore.jdt.configuration.impl.EMFStoreJDTConfigurationImpl#getAnywayCommit <em>Anyway Commit
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EMFStoreJDTConfigurationImpl extends EObjectImpl implements EMFStoreJDTConfiguration {
	/**
	 * The cached value of the '{@link #getEntry() <em>Entry</em>}' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getEntry()
	 * @generated
	 * @ordered
	 */
	protected EList<Entry> entry;

	/**
	 * The cached value of the '{@link #getAnywayCommit() <em>Anyway Commit</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAnywayCommit()
	 * @generated
	 * @ordered
	 */
	protected EList<EMFStoreLocation> anywayCommit;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EMFStoreJDTConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.EMF_STORE_JDT_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Entry> getEntry() {
		if (entry == null) {
			entry = new EObjectContainmentWithInverseEList<Entry>(Entry.class, this,
				ConfigurationPackage.EMF_STORE_JDT_CONFIGURATION__ENTRY, ConfigurationPackage.ENTRY__CONFIGURATION);
		}
		return entry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<EMFStoreLocation> getAnywayCommit() {
		if (anywayCommit == null) {
			anywayCommit = new EObjectContainmentEList<EMFStoreLocation>(EMFStoreLocation.class, this,
				ConfigurationPackage.EMF_STORE_JDT_CONFIGURATION__ANYWAY_COMMIT);
		}
		return anywayCommit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ConfigurationPackage.EMF_STORE_JDT_CONFIGURATION__ENTRY:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getEntry()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ConfigurationPackage.EMF_STORE_JDT_CONFIGURATION__ENTRY:
			return ((InternalEList<?>) getEntry()).basicRemove(otherEnd, msgs);
		case ConfigurationPackage.EMF_STORE_JDT_CONFIGURATION__ANYWAY_COMMIT:
			return ((InternalEList<?>) getAnywayCommit()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ConfigurationPackage.EMF_STORE_JDT_CONFIGURATION__ENTRY:
			return getEntry();
		case ConfigurationPackage.EMF_STORE_JDT_CONFIGURATION__ANYWAY_COMMIT:
			return getAnywayCommit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ConfigurationPackage.EMF_STORE_JDT_CONFIGURATION__ENTRY:
			getEntry().clear();
			getEntry().addAll((Collection<? extends Entry>) newValue);
			return;
		case ConfigurationPackage.EMF_STORE_JDT_CONFIGURATION__ANYWAY_COMMIT:
			getAnywayCommit().clear();
			getAnywayCommit().addAll((Collection<? extends EMFStoreLocation>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ConfigurationPackage.EMF_STORE_JDT_CONFIGURATION__ENTRY:
			getEntry().clear();
			return;
		case ConfigurationPackage.EMF_STORE_JDT_CONFIGURATION__ANYWAY_COMMIT:
			getAnywayCommit().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ConfigurationPackage.EMF_STORE_JDT_CONFIGURATION__ENTRY:
			return entry != null && !entry.isEmpty();
		case ConfigurationPackage.EMF_STORE_JDT_CONFIGURATION__ANYWAY_COMMIT:
			return anywayCommit != null && !anywayCommit.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	public void save() {
		try {
			eResource().save(null);
		} catch (IOException e) {
			ModelUtil.logException(e);
		}
	}

} // EMFStoreJDTConfigurationImpl

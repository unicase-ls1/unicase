/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.configuration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.jdt.ITeamSynchronizer;
import org.unicase.emfstore.jdt.configuration.ConfigurationPackage;
import org.unicase.emfstore.jdt.configuration.HistoryVersionMapping;
import org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry;
import org.unicase.emfstore.jdt.exception.TeamSynchronizerException;
import org.unicase.metamodel.util.ModelUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>History Version Mapping</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.jdt.configuration.impl.HistoryVersionMappingImpl#getHvmEntry <em>Hvm Entry</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HistoryVersionMappingImpl extends VersionMappingImpl implements HistoryVersionMapping {
	/**
	 * The cached value of the '{@link #getHvmEntry() <em>Hvm Entry</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHvmEntry()
	 * @generated
	 * @ordered
	 */
	protected EList<HistoryVersionMappingEntry> hvmEntry;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected HistoryVersionMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.HISTORY_VERSION_MAPPING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HistoryVersionMappingEntry> getHvmEntry() {
		if (hvmEntry == null) {
			hvmEntry = new EObjectContainmentEList<HistoryVersionMappingEntry>(HistoryVersionMappingEntry.class, this, ConfigurationPackage.HISTORY_VERSION_MAPPING__HVM_ENTRY);
		}
		return hvmEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.HISTORY_VERSION_MAPPING__HVM_ENTRY:
				return ((InternalEList<?>)getHvmEntry()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.HISTORY_VERSION_MAPPING__HVM_ENTRY:
				return getHvmEntry();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfigurationPackage.HISTORY_VERSION_MAPPING__HVM_ENTRY:
				getHvmEntry().clear();
				getHvmEntry().addAll((Collection<? extends HistoryVersionMappingEntry>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConfigurationPackage.HISTORY_VERSION_MAPPING__HVM_ENTRY:
				getHvmEntry().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConfigurationPackage.HISTORY_VERSION_MAPPING__HVM_ENTRY:
				return hvmEntry != null && !hvmEntry.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.configuration.Entry#getVersionMapping4TeamRevision(long)
	 * @generated NOT
	 */
	public HistoryVersionMappingEntry getVersionMapping4TeamRevision(String teamRevision) {
		EList<HistoryVersionMappingEntry> hvmEntries = getHvmEntry();
		for (HistoryVersionMappingEntry hvmEntry : hvmEntries) {
			if (hvmEntry.getTeamProviderRevision().equals(teamRevision)) {
				return hvmEntry;
			}
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.configuration.Entry#getVersionMapping4TeamRevisionBestMatch(org.unicase.emfstore.jdt.ITeamSynchronizer,
	 *      java.lang.String)
	 */
	public HistoryVersionMappingEntry getVersionMapping4TeamRevisionBestMatch(ITeamSynchronizer teamSynchronizer,
		String teamRevision) {
		EList<HistoryVersionMappingEntry> versionMappings = getHvmEntry();
		HistoryVersionMappingEntry bestMatch = null;

		for (HistoryVersionMappingEntry versionMapping : versionMappings) {
			if (versionMapping.getTeamProviderRevision().equals(teamRevision)) {
				return versionMapping;
			}

			try {
				if (bestMatch == null
					|| ((teamSynchronizer.compare(versionMapping.getTeamProviderRevision(), bestMatch
						.getTeamProviderRevision()) == -1) && (teamSynchronizer.compare(versionMapping
						.getTeamProviderRevision(), teamRevision) == 1))) {
					bestMatch = versionMapping;
				}

			} catch (TeamSynchronizerException e) {
				ModelUtil.logException(e);
			}
		}

		return bestMatch;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.configuration.Entry#getLowestTeamVersionMapping()
	 * @generated NOT
	 */
	public HistoryVersionMappingEntry getLowestTeamVersionMapping(ITeamSynchronizer teamSynchronizer) {
		HistoryVersionMappingEntry lowestVersionMapping = null;

		EList<HistoryVersionMappingEntry> versionMappings = getHvmEntry();
		for (HistoryVersionMappingEntry versionMapping : versionMappings) {
			try {
				if (lowestVersionMapping == null
					|| (teamSynchronizer.compare(versionMapping.getTeamProviderRevision(), lowestVersionMapping
						.getTeamProviderRevision()) == 1)) {
					lowestVersionMapping = versionMapping;
				}

			} catch (TeamSynchronizerException e) {
				ModelUtil.logException(e);
				continue;
			}
		}

		return lowestVersionMapping;
	}

} // HistoryVersionMappingImpl

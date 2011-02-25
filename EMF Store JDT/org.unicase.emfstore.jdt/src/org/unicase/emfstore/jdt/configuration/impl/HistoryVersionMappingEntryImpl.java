/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.configuration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.unicase.emfstore.jdt.configuration.ConfigurationPackage;
import org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>History Version Mapping Entry</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.jdt.configuration.impl.HistoryVersionMappingEntryImpl#getTeamProviderRevision <em>Team Provider Revision</em>}</li>
 *   <li>{@link org.unicase.emfstore.jdt.configuration.impl.HistoryVersionMappingEntryImpl#getEMFStoreRevision <em>EMF Store Revision</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HistoryVersionMappingEntryImpl extends EObjectImpl implements HistoryVersionMappingEntry {
	/**
	 * The default value of the '{@link #getTeamProviderRevision() <em>Team Provider Revision</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTeamProviderRevision()
	 * @generated
	 * @ordered
	 */
	protected static final String TEAM_PROVIDER_REVISION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTeamProviderRevision() <em>Team Provider Revision</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTeamProviderRevision()
	 * @generated
	 * @ordered
	 */
	protected String teamProviderRevision = TEAM_PROVIDER_REVISION_EDEFAULT;

	/**
	 * The default value of the '{@link #getEMFStoreRevision() <em>EMF Store Revision</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEMFStoreRevision()
	 * @generated
	 * @ordered
	 */
	protected static final int EMF_STORE_REVISION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEMFStoreRevision() <em>EMF Store Revision</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEMFStoreRevision()
	 * @generated
	 * @ordered
	 */
	protected int emfStoreRevision = EMF_STORE_REVISION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected HistoryVersionMappingEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.HISTORY_VERSION_MAPPING_ENTRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTeamProviderRevision() {
		return teamProviderRevision;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTeamProviderRevision(String newTeamProviderRevision) {
		String oldTeamProviderRevision = teamProviderRevision;
		teamProviderRevision = newTeamProviderRevision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.HISTORY_VERSION_MAPPING_ENTRY__TEAM_PROVIDER_REVISION, oldTeamProviderRevision, teamProviderRevision));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getEMFStoreRevision() {
		return emfStoreRevision;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEMFStoreRevision(int newEMFStoreRevision) {
		int oldEMFStoreRevision = emfStoreRevision;
		emfStoreRevision = newEMFStoreRevision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.HISTORY_VERSION_MAPPING_ENTRY__EMF_STORE_REVISION, oldEMFStoreRevision, emfStoreRevision));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.HISTORY_VERSION_MAPPING_ENTRY__TEAM_PROVIDER_REVISION:
				return getTeamProviderRevision();
			case ConfigurationPackage.HISTORY_VERSION_MAPPING_ENTRY__EMF_STORE_REVISION:
				return getEMFStoreRevision();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfigurationPackage.HISTORY_VERSION_MAPPING_ENTRY__TEAM_PROVIDER_REVISION:
				setTeamProviderRevision((String)newValue);
				return;
			case ConfigurationPackage.HISTORY_VERSION_MAPPING_ENTRY__EMF_STORE_REVISION:
				setEMFStoreRevision((Integer)newValue);
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
			case ConfigurationPackage.HISTORY_VERSION_MAPPING_ENTRY__TEAM_PROVIDER_REVISION:
				setTeamProviderRevision(TEAM_PROVIDER_REVISION_EDEFAULT);
				return;
			case ConfigurationPackage.HISTORY_VERSION_MAPPING_ENTRY__EMF_STORE_REVISION:
				setEMFStoreRevision(EMF_STORE_REVISION_EDEFAULT);
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
			case ConfigurationPackage.HISTORY_VERSION_MAPPING_ENTRY__TEAM_PROVIDER_REVISION:
				return TEAM_PROVIDER_REVISION_EDEFAULT == null ? teamProviderRevision != null : !TEAM_PROVIDER_REVISION_EDEFAULT.equals(teamProviderRevision);
			case ConfigurationPackage.HISTORY_VERSION_MAPPING_ENTRY__EMF_STORE_REVISION:
				return emfStoreRevision != EMF_STORE_REVISION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (TeamProviderRevision: ");
		result.append(teamProviderRevision);
		result.append(", EMFStoreRevision: ");
		result.append(emfStoreRevision);
		result.append(')');
		return result.toString();
	}

} // HistoryVersionMappingEntryImpl

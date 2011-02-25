/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.configuration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.jdt.configuration.ConfigurationPackage;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.configuration.StandaloneEntry;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Standalone Entry</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.jdt.configuration.impl.StandaloneEntryImpl#getConfiguration <em>Configuration</em>}</li>
 * <li>{@link org.unicase.emfstore.jdt.configuration.impl.StandaloneEntryImpl#getProjectRelativeLocation <em>Project
 * Relative Location</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class StandaloneEntryImpl extends EObjectImpl implements StandaloneEntry {
	/**
	 * The default value of the '{@link #getProjectRelativeLocation() <em>Project Relative Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProjectRelativeLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_RELATIVE_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectRelativeLocation() <em>Project Relative Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProjectRelativeLocation()
	 * @generated
	 * @ordered
	 */
	protected String projectRelativeLocation = PROJECT_RELATIVE_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentTeamRevision() <em>Current Team Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentTeamRevision()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENT_TEAM_REVISION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrentTeamRevision() <em>Current Team Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentTeamRevision()
	 * @generated
	 * @ordered
	 */
	protected String currentTeamRevision = CURRENT_TEAM_REVISION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected StandaloneEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.STANDALONE_ENTRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMFStoreJDTConfiguration getConfiguration() {
		if (eContainerFeatureID() != ConfigurationPackage.STANDALONE_ENTRY__CONFIGURATION) return null;
		return (EMFStoreJDTConfiguration)eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfiguration(EMFStoreJDTConfiguration newConfiguration, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConfiguration, ConfigurationPackage.STANDALONE_ENTRY__CONFIGURATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(EMFStoreJDTConfiguration newConfiguration) {
		if (newConfiguration != eInternalContainer() || (eContainerFeatureID() != ConfigurationPackage.STANDALONE_ENTRY__CONFIGURATION && newConfiguration != null)) {
			if (EcoreUtil.isAncestor(this, newConfiguration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConfiguration != null)
				msgs = ((InternalEObject)newConfiguration).eInverseAdd(this, ConfigurationPackage.EMF_STORE_JDT_CONFIGURATION__STANDALONE_ENTRY, EMFStoreJDTConfiguration.class, msgs);
			msgs = basicSetConfiguration(newConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.STANDALONE_ENTRY__CONFIGURATION, newConfiguration, newConfiguration));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectRelativeLocation() {
		return projectRelativeLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectRelativeLocation(String newProjectRelativeLocation) {
		String oldProjectRelativeLocation = projectRelativeLocation;
		projectRelativeLocation = newProjectRelativeLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.STANDALONE_ENTRY__PROJECT_RELATIVE_LOCATION, oldProjectRelativeLocation, projectRelativeLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrentTeamRevision() {
		return currentTeamRevision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentTeamRevision(String newCurrentTeamRevision) {
		String oldCurrentTeamRevision = currentTeamRevision;
		currentTeamRevision = newCurrentTeamRevision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.STANDALONE_ENTRY__CURRENT_TEAM_REVISION, oldCurrentTeamRevision, currentTeamRevision));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.STANDALONE_ENTRY__CONFIGURATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConfiguration((EMFStoreJDTConfiguration)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.STANDALONE_ENTRY__CONFIGURATION:
				return basicSetConfiguration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ConfigurationPackage.STANDALONE_ENTRY__CONFIGURATION:
				return eInternalContainer().eInverseRemove(this, ConfigurationPackage.EMF_STORE_JDT_CONFIGURATION__STANDALONE_ENTRY, EMFStoreJDTConfiguration.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.STANDALONE_ENTRY__CONFIGURATION:
				return getConfiguration();
			case ConfigurationPackage.STANDALONE_ENTRY__PROJECT_RELATIVE_LOCATION:
				return getProjectRelativeLocation();
			case ConfigurationPackage.STANDALONE_ENTRY__CURRENT_TEAM_REVISION:
				return getCurrentTeamRevision();
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
			case ConfigurationPackage.STANDALONE_ENTRY__CONFIGURATION:
				setConfiguration((EMFStoreJDTConfiguration)newValue);
				return;
			case ConfigurationPackage.STANDALONE_ENTRY__PROJECT_RELATIVE_LOCATION:
				setProjectRelativeLocation((String)newValue);
				return;
			case ConfigurationPackage.STANDALONE_ENTRY__CURRENT_TEAM_REVISION:
				setCurrentTeamRevision((String)newValue);
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
			case ConfigurationPackage.STANDALONE_ENTRY__CONFIGURATION:
				setConfiguration((EMFStoreJDTConfiguration)null);
				return;
			case ConfigurationPackage.STANDALONE_ENTRY__PROJECT_RELATIVE_LOCATION:
				setProjectRelativeLocation(PROJECT_RELATIVE_LOCATION_EDEFAULT);
				return;
			case ConfigurationPackage.STANDALONE_ENTRY__CURRENT_TEAM_REVISION:
				setCurrentTeamRevision(CURRENT_TEAM_REVISION_EDEFAULT);
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
			case ConfigurationPackage.STANDALONE_ENTRY__CONFIGURATION:
				return getConfiguration() != null;
			case ConfigurationPackage.STANDALONE_ENTRY__PROJECT_RELATIVE_LOCATION:
				return PROJECT_RELATIVE_LOCATION_EDEFAULT == null ? projectRelativeLocation != null : !PROJECT_RELATIVE_LOCATION_EDEFAULT.equals(projectRelativeLocation);
			case ConfigurationPackage.STANDALONE_ENTRY__CURRENT_TEAM_REVISION:
				return CURRENT_TEAM_REVISION_EDEFAULT == null ? currentTeamRevision != null : !CURRENT_TEAM_REVISION_EDEFAULT.equals(currentTeamRevision);
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
		result.append(" (ProjectRelativeLocation: ");
		result.append(projectRelativeLocation);
		result.append(", CurrentTeamRevision: ");
		result.append(currentTeamRevision);
		result.append(')');
		return result.toString();
	}

} // StandaloneEntryImpl

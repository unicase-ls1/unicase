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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage;
import org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreTeamProviderConfiguration;
import org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreTeamProviderConfiguration;
import org.eclipse.emf.emfstore.teamprovider.configuration.EObjectLocation;
import org.eclipse.emf.emfstore.teamprovider.configuration.Entry;
import org.eclipse.emf.emfstore.teamprovider.configuration.VersionMapping;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Entry</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.impl.EntryImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.impl.EntryImpl#getProjectRelativeLocation <em>Project Relative Location</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.impl.EntryImpl#getEObjectLocation <em>EObject Location</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.impl.EntryImpl#getVersionMapping <em>Version Mapping</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.impl.EntryImpl#isMarkedForDeletion <em>Marked For Deletion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntryImpl extends EObjectImpl implements Entry {
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
	 * The cached value of the '{@link #getEObjectLocation() <em>EObject Location</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEObjectLocation()
	 * @generated
	 * @ordered
	 */
	protected EObjectLocation eObjectLocation;

	/**
	 * The cached value of the '{@link #getVersionMapping() <em>Version Mapping</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVersionMapping()
	 * @generated
	 * @ordered
	 */
	protected VersionMapping versionMapping;

	/**
	 * The default value of the '{@link #isMarkedForDeletion() <em>Marked For Deletion</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMarkedForDeletion()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MARKED_FOR_DELETION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMarkedForDeletion() <em>Marked For Deletion</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMarkedForDeletion()
	 * @generated
	 * @ordered
	 */
	protected boolean markedForDeletion = MARKED_FOR_DELETION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.ENTRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMFStoreTeamProviderConfiguration getConfiguration() {
		if (eContainerFeatureID() != ConfigurationPackage.ENTRY__CONFIGURATION) return null;
		return (EMFStoreTeamProviderConfiguration)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfiguration(EMFStoreTeamProviderConfiguration newConfiguration, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConfiguration, ConfigurationPackage.ENTRY__CONFIGURATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(EMFStoreTeamProviderConfiguration newConfiguration) {
		if (newConfiguration != eInternalContainer() || (eContainerFeatureID() != ConfigurationPackage.ENTRY__CONFIGURATION && newConfiguration != null)) {
			if (EcoreUtil.isAncestor(this, newConfiguration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConfiguration != null)
				msgs = ((InternalEObject)newConfiguration).eInverseAdd(this, ConfigurationPackage.EMF_STORE_TEAM_PROVIDER_CONFIGURATION__ENTRY, EMFStoreTeamProviderConfiguration.class, msgs);
			msgs = basicSetConfiguration(newConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.ENTRY__CONFIGURATION, newConfiguration, newConfiguration));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.ENTRY__PROJECT_RELATIVE_LOCATION, oldProjectRelativeLocation, projectRelativeLocation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObjectLocation getEObjectLocation() {
		return eObjectLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEObjectLocation(EObjectLocation newEObjectLocation, NotificationChain msgs) {
		EObjectLocation oldEObjectLocation = eObjectLocation;
		eObjectLocation = newEObjectLocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.ENTRY__EOBJECT_LOCATION, oldEObjectLocation, newEObjectLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEObjectLocation(EObjectLocation newEObjectLocation) {
		if (newEObjectLocation != eObjectLocation) {
			NotificationChain msgs = null;
			if (eObjectLocation != null)
				msgs = ((InternalEObject)eObjectLocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.ENTRY__EOBJECT_LOCATION, null, msgs);
			if (newEObjectLocation != null)
				msgs = ((InternalEObject)newEObjectLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.ENTRY__EOBJECT_LOCATION, null, msgs);
			msgs = basicSetEObjectLocation(newEObjectLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.ENTRY__EOBJECT_LOCATION, newEObjectLocation, newEObjectLocation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VersionMapping getVersionMapping() {
		return versionMapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVersionMapping(VersionMapping newVersionMapping, NotificationChain msgs) {
		VersionMapping oldVersionMapping = versionMapping;
		versionMapping = newVersionMapping;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.ENTRY__VERSION_MAPPING, oldVersionMapping, newVersionMapping);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionMapping(VersionMapping newVersionMapping) {
		if (newVersionMapping != versionMapping) {
			NotificationChain msgs = null;
			if (versionMapping != null)
				msgs = ((InternalEObject)versionMapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.ENTRY__VERSION_MAPPING, null, msgs);
			if (newVersionMapping != null)
				msgs = ((InternalEObject)newVersionMapping).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.ENTRY__VERSION_MAPPING, null, msgs);
			msgs = basicSetVersionMapping(newVersionMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.ENTRY__VERSION_MAPPING, newVersionMapping, newVersionMapping));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMarkedForDeletion() {
		return markedForDeletion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMarkedForDeletion(boolean newMarkedForDeletion) {
		boolean oldMarkedForDeletion = markedForDeletion;
		markedForDeletion = newMarkedForDeletion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.ENTRY__MARKED_FOR_DELETION, oldMarkedForDeletion, markedForDeletion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.ENTRY__CONFIGURATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConfiguration((EMFStoreTeamProviderConfiguration)otherEnd, msgs);
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
			case ConfigurationPackage.ENTRY__CONFIGURATION:
				return basicSetConfiguration(null, msgs);
			case ConfigurationPackage.ENTRY__EOBJECT_LOCATION:
				return basicSetEObjectLocation(null, msgs);
			case ConfigurationPackage.ENTRY__VERSION_MAPPING:
				return basicSetVersionMapping(null, msgs);
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
			case ConfigurationPackage.ENTRY__CONFIGURATION:
				return eInternalContainer().eInverseRemove(this, ConfigurationPackage.EMF_STORE_TEAM_PROVIDER_CONFIGURATION__ENTRY, EMFStoreTeamProviderConfiguration.class, msgs);
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
			case ConfigurationPackage.ENTRY__CONFIGURATION:
				return getConfiguration();
			case ConfigurationPackage.ENTRY__PROJECT_RELATIVE_LOCATION:
				return getProjectRelativeLocation();
			case ConfigurationPackage.ENTRY__EOBJECT_LOCATION:
				return getEObjectLocation();
			case ConfigurationPackage.ENTRY__VERSION_MAPPING:
				return getVersionMapping();
			case ConfigurationPackage.ENTRY__MARKED_FOR_DELETION:
				return isMarkedForDeletion();
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
			case ConfigurationPackage.ENTRY__CONFIGURATION:
				setConfiguration((EMFStoreTeamProviderConfiguration)newValue);
				return;
			case ConfigurationPackage.ENTRY__PROJECT_RELATIVE_LOCATION:
				setProjectRelativeLocation((String)newValue);
				return;
			case ConfigurationPackage.ENTRY__EOBJECT_LOCATION:
				setEObjectLocation((EObjectLocation)newValue);
				return;
			case ConfigurationPackage.ENTRY__VERSION_MAPPING:
				setVersionMapping((VersionMapping)newValue);
				return;
			case ConfigurationPackage.ENTRY__MARKED_FOR_DELETION:
				setMarkedForDeletion((Boolean)newValue);
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
			case ConfigurationPackage.ENTRY__CONFIGURATION:
				setConfiguration((EMFStoreTeamProviderConfiguration)null);
				return;
			case ConfigurationPackage.ENTRY__PROJECT_RELATIVE_LOCATION:
				setProjectRelativeLocation(PROJECT_RELATIVE_LOCATION_EDEFAULT);
				return;
			case ConfigurationPackage.ENTRY__EOBJECT_LOCATION:
				setEObjectLocation((EObjectLocation)null);
				return;
			case ConfigurationPackage.ENTRY__VERSION_MAPPING:
				setVersionMapping((VersionMapping)null);
				return;
			case ConfigurationPackage.ENTRY__MARKED_FOR_DELETION:
				setMarkedForDeletion(MARKED_FOR_DELETION_EDEFAULT);
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
			case ConfigurationPackage.ENTRY__CONFIGURATION:
				return getConfiguration() != null;
			case ConfigurationPackage.ENTRY__PROJECT_RELATIVE_LOCATION:
				return PROJECT_RELATIVE_LOCATION_EDEFAULT == null ? projectRelativeLocation != null : !PROJECT_RELATIVE_LOCATION_EDEFAULT.equals(projectRelativeLocation);
			case ConfigurationPackage.ENTRY__EOBJECT_LOCATION:
				return eObjectLocation != null;
			case ConfigurationPackage.ENTRY__VERSION_MAPPING:
				return versionMapping != null;
			case ConfigurationPackage.ENTRY__MARKED_FOR_DELETION:
				return markedForDeletion != MARKED_FOR_DELETION_EDEFAULT;
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
		result.append(", MarkedForDeletion: ");
		result.append(markedForDeletion);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 * @generated NOT
	 */
	@Override
	public int hashCode() {
		return getProjectRelativeLocation().hashCode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @generated NOT
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Entry) {
			Entry entry = (Entry) obj;
			return getProjectRelativeLocation().equals(entry.getProjectRelativeLocation());
		}
		return false;
	}

} // EntryImpl

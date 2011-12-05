/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.emfstore.common.model.EMFStoreProperty;
import org.eclipse.emf.emfstore.server.model.ModelPackage;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.versioning.Version;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Project History</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.impl.ProjectHistoryImpl#getProjectId <em>Project Id</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.impl.ProjectHistoryImpl#getVersions <em>Versions</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.impl.ProjectHistoryImpl#getProjectName <em>Project Name</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.impl.ProjectHistoryImpl#getProjectDescription <em>Project
 * Description</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProjectHistoryImpl extends EObjectImpl implements ProjectHistory {
	/**
	 * The cached value of the '{@link #getProjectId() <em>Project Id</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected ProjectId projectId;

	/**
	 * The cached value of the '{@link #getVersions() <em>Versions</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVersions()
	 * @generated
	 * @ordered
	 */
	protected EList<Version> versions;

	/**
	 * The default value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected String projectName = PROJECT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProjectDescription() <em>Project Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectDescription() <em>Project Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectDescription()
	 * @generated
	 * @ordered
	 */
	protected String projectDescription = PROJECT_DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSharedProperties() <em>Shared Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSharedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<EMFStoreProperty> sharedProperties;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProjectHistoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PROJECT_HISTORY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectId getProjectId() {
		if (projectId != null && projectId.eIsProxy()) {
			InternalEObject oldProjectId = (InternalEObject) projectId;
			projectId = (ProjectId) eResolveProxy(oldProjectId);
			if (projectId != oldProjectId) {
				InternalEObject newProjectId = (InternalEObject) projectId;
				NotificationChain msgs = oldProjectId.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- ModelPackage.PROJECT_HISTORY__PROJECT_ID, null, null);
				if (newProjectId.eInternalContainer() == null) {
					msgs = newProjectId.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- ModelPackage.PROJECT_HISTORY__PROJECT_ID, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PROJECT_HISTORY__PROJECT_ID,
						oldProjectId, projectId));
			}
		}
		return projectId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectId basicGetProjectId() {
		return projectId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetProjectId(ProjectId newProjectId, NotificationChain msgs) {
		ProjectId oldProjectId = projectId;
		projectId = newProjectId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				ModelPackage.PROJECT_HISTORY__PROJECT_ID, oldProjectId, newProjectId);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProjectId(ProjectId newProjectId) {
		if (newProjectId != projectId) {
			NotificationChain msgs = null;
			if (projectId != null)
				msgs = ((InternalEObject) projectId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- ModelPackage.PROJECT_HISTORY__PROJECT_ID, null, msgs);
			if (newProjectId != null)
				msgs = ((InternalEObject) newProjectId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- ModelPackage.PROJECT_HISTORY__PROJECT_ID, null, msgs);
			msgs = basicSetProjectId(newProjectId, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROJECT_HISTORY__PROJECT_ID,
				newProjectId, newProjectId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Version> getVersions() {
		if (versions == null) {
			versions = new EObjectContainmentEList.Resolving<Version>(Version.class, this,
				ModelPackage.PROJECT_HISTORY__VERSIONS);
		}
		return versions;
	}

	// begin of custom code
	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public Version getLastVersion() {
		EList<Version> versions = getVersions();
		return (versions.size() == 0) ? null : versions.get(versions.size() - 1);
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProjectName(String newProjectName) {
		String oldProjectName = projectName;
		projectName = newProjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROJECT_HISTORY__PROJECT_NAME,
				oldProjectName, projectName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getProjectDescription() {
		return projectDescription;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProjectDescription(String newProjectDescription) {
		String oldProjectDescription = projectDescription;
		projectDescription = newProjectDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROJECT_HISTORY__PROJECT_DESCRIPTION,
				oldProjectDescription, projectDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<EMFStoreProperty> getSharedProperties() {
		if (sharedProperties == null) {
			sharedProperties = new EObjectContainmentEList.Resolving<EMFStoreProperty>(EMFStoreProperty.class, this,
				ModelPackage.PROJECT_HISTORY__SHARED_PROPERTIES);
		}
		return sharedProperties;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.PROJECT_HISTORY__PROJECT_ID:
			return basicSetProjectId(null, msgs);
		case ModelPackage.PROJECT_HISTORY__VERSIONS:
			return ((InternalEList<?>) getVersions()).basicRemove(otherEnd, msgs);
		case ModelPackage.PROJECT_HISTORY__SHARED_PROPERTIES:
			return ((InternalEList<?>) getSharedProperties()).basicRemove(otherEnd, msgs);
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
		case ModelPackage.PROJECT_HISTORY__PROJECT_ID:
			if (resolve)
				return getProjectId();
			return basicGetProjectId();
		case ModelPackage.PROJECT_HISTORY__VERSIONS:
			return getVersions();
		case ModelPackage.PROJECT_HISTORY__PROJECT_NAME:
			return getProjectName();
		case ModelPackage.PROJECT_HISTORY__PROJECT_DESCRIPTION:
			return getProjectDescription();
		case ModelPackage.PROJECT_HISTORY__SHARED_PROPERTIES:
			return getSharedProperties();
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
		case ModelPackage.PROJECT_HISTORY__PROJECT_ID:
			setProjectId((ProjectId) newValue);
			return;
		case ModelPackage.PROJECT_HISTORY__VERSIONS:
			getVersions().clear();
			getVersions().addAll((Collection<? extends Version>) newValue);
			return;
		case ModelPackage.PROJECT_HISTORY__PROJECT_NAME:
			setProjectName((String) newValue);
			return;
		case ModelPackage.PROJECT_HISTORY__PROJECT_DESCRIPTION:
			setProjectDescription((String) newValue);
			return;
		case ModelPackage.PROJECT_HISTORY__SHARED_PROPERTIES:
			getSharedProperties().clear();
			getSharedProperties().addAll((Collection<? extends EMFStoreProperty>) newValue);
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
		case ModelPackage.PROJECT_HISTORY__PROJECT_ID:
			setProjectId((ProjectId) null);
			return;
		case ModelPackage.PROJECT_HISTORY__VERSIONS:
			getVersions().clear();
			return;
		case ModelPackage.PROJECT_HISTORY__PROJECT_NAME:
			setProjectName(PROJECT_NAME_EDEFAULT);
			return;
		case ModelPackage.PROJECT_HISTORY__PROJECT_DESCRIPTION:
			setProjectDescription(PROJECT_DESCRIPTION_EDEFAULT);
			return;
		case ModelPackage.PROJECT_HISTORY__SHARED_PROPERTIES:
			getSharedProperties().clear();
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
		case ModelPackage.PROJECT_HISTORY__PROJECT_ID:
			return projectId != null;
		case ModelPackage.PROJECT_HISTORY__VERSIONS:
			return versions != null && !versions.isEmpty();
		case ModelPackage.PROJECT_HISTORY__PROJECT_NAME:
			return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
		case ModelPackage.PROJECT_HISTORY__PROJECT_DESCRIPTION:
			return PROJECT_DESCRIPTION_EDEFAULT == null ? projectDescription != null : !PROJECT_DESCRIPTION_EDEFAULT
				.equals(projectDescription);
		case ModelPackage.PROJECT_HISTORY__SHARED_PROPERTIES:
			return sharedProperties != null && !sharedProperties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (projectName: ");
		result.append(projectName);
		result.append(", projectDescription: ");
		result.append(projectDescription);
		result.append(')');
		return result.toString();
	}

} // ProjectHistoryImpl

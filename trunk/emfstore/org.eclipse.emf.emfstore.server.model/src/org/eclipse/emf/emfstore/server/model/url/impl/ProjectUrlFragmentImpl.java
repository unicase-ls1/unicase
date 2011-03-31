/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.url.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.url.ProjectUrlFragment;
import org.eclipse.emf.emfstore.server.model.url.UrlPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Project Url Fragment</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.url.impl.ProjectUrlFragmentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.url.impl.ProjectUrlFragmentImpl#getProjectId <em>Project Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectUrlFragmentImpl extends EObjectImpl implements ProjectUrlFragment {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProjectId() <em>Project Id</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected ProjectId projectId;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectUrlFragmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UrlPackage.Literals.PROJECT_URL_FRAGMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UrlPackage.PROJECT_URL_FRAGMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId getProjectId() {
		if (projectId != null && projectId.eIsProxy()) {
			InternalEObject oldProjectId = (InternalEObject)projectId;
			projectId = (ProjectId)eResolveProxy(oldProjectId);
			if (projectId != oldProjectId) {
				InternalEObject newProjectId = (InternalEObject)projectId;
				NotificationChain msgs = oldProjectId.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrlPackage.PROJECT_URL_FRAGMENT__PROJECT_ID, null, null);
				if (newProjectId.eInternalContainer() == null) {
					msgs = newProjectId.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrlPackage.PROJECT_URL_FRAGMENT__PROJECT_ID, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrlPackage.PROJECT_URL_FRAGMENT__PROJECT_ID, oldProjectId, projectId));
			}
		}
		return projectId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId basicGetProjectId() {
		return projectId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProjectId(ProjectId newProjectId, NotificationChain msgs) {
		ProjectId oldProjectId = projectId;
		projectId = newProjectId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UrlPackage.PROJECT_URL_FRAGMENT__PROJECT_ID, oldProjectId, newProjectId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectId(ProjectId newProjectId) {
		if (newProjectId != projectId) {
			NotificationChain msgs = null;
			if (projectId != null)
				msgs = ((InternalEObject)projectId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrlPackage.PROJECT_URL_FRAGMENT__PROJECT_ID, null, msgs);
			if (newProjectId != null)
				msgs = ((InternalEObject)newProjectId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrlPackage.PROJECT_URL_FRAGMENT__PROJECT_ID, null, msgs);
			msgs = basicSetProjectId(newProjectId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UrlPackage.PROJECT_URL_FRAGMENT__PROJECT_ID, newProjectId, newProjectId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UrlPackage.PROJECT_URL_FRAGMENT__PROJECT_ID:
				return basicSetProjectId(null, msgs);
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
			case UrlPackage.PROJECT_URL_FRAGMENT__NAME:
				return getName();
			case UrlPackage.PROJECT_URL_FRAGMENT__PROJECT_ID:
				if (resolve) return getProjectId();
				return basicGetProjectId();
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
			case UrlPackage.PROJECT_URL_FRAGMENT__NAME:
				setName((String)newValue);
				return;
			case UrlPackage.PROJECT_URL_FRAGMENT__PROJECT_ID:
				setProjectId((ProjectId)newValue);
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
			case UrlPackage.PROJECT_URL_FRAGMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UrlPackage.PROJECT_URL_FRAGMENT__PROJECT_ID:
				setProjectId((ProjectId)null);
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
			case UrlPackage.PROJECT_URL_FRAGMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UrlPackage.PROJECT_URL_FRAGMENT__PROJECT_ID:
				return projectId != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public String getUrlString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getName());
		stringBuilder.append("%");
		stringBuilder.append(getProjectId().getId());
		return stringBuilder.toString();
	}

} // ProjectUrlFragmentImpl

/**
 * <copyright> Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Unversitaet Muenchen. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.eclipse.emf.emfstore.client.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.emfstore.client.model.ModelPackage;
import org.eclipse.emf.emfstore.client.model.OperationComposite;
import org.eclipse.emf.emfstore.client.model.ProjectData;

import org.eclipse.emf.emfstore.common.model.Project;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ProjectDataImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ProjectDataImpl#getLocalOperations <em>Local Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectDataImpl extends EObjectImpl implements ProjectData {
	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected Project project;

	/**
	 * The cached value of the '{@link #getLocalOperations() <em>Local Operations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalOperations()
	 * @generated
	 * @ordered
	 */
	protected OperationComposite localOperations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PROJECT_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProject() {
		if (project != null && project.eIsProxy()) {
			InternalEObject oldProject = (InternalEObject) project;
			project = (Project) eResolveProxy(oldProject);
			if (project != oldProject) {
				InternalEObject newProject = (InternalEObject) project;
				NotificationChain msgs = oldProject.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- ModelPackage.PROJECT_DATA__PROJECT, null,
						null);
				if (newProject.eInternalContainer() == null) {
					msgs = newProject.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
							- ModelPackage.PROJECT_DATA__PROJECT, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ModelPackage.PROJECT_DATA__PROJECT, oldProject,
							project));
			}
		}
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project basicGetProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProject(Project newProject,
			NotificationChain msgs) {
		Project oldProject = project;
		project = newProject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, ModelPackage.PROJECT_DATA__PROJECT,
					oldProject, newProject);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(Project newProject) {
		if (newProject != project) {
			NotificationChain msgs = null;
			if (project != null)
				msgs = ((InternalEObject) project).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- ModelPackage.PROJECT_DATA__PROJECT, null,
						msgs);
			if (newProject != null)
				msgs = ((InternalEObject) newProject).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- ModelPackage.PROJECT_DATA__PROJECT, null,
						msgs);
			msgs = basicSetProject(newProject, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.PROJECT_DATA__PROJECT, newProject, newProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationComposite getLocalOperations() {
		if (localOperations != null && localOperations.eIsProxy()) {
			InternalEObject oldLocalOperations = (InternalEObject) localOperations;
			localOperations = (OperationComposite) eResolveProxy(oldLocalOperations);
			if (localOperations != oldLocalOperations) {
				InternalEObject newLocalOperations = (InternalEObject) localOperations;
				NotificationChain msgs = oldLocalOperations.eInverseRemove(
						this, EOPPOSITE_FEATURE_BASE
								- ModelPackage.PROJECT_DATA__LOCAL_OPERATIONS,
						null, null);
				if (newLocalOperations.eInternalContainer() == null) {
					msgs = newLocalOperations
							.eInverseAdd(
									this,
									EOPPOSITE_FEATURE_BASE
											- ModelPackage.PROJECT_DATA__LOCAL_OPERATIONS,
									null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ModelPackage.PROJECT_DATA__LOCAL_OPERATIONS,
							oldLocalOperations, localOperations));
			}
		}
		return localOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationComposite basicGetLocalOperations() {
		return localOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocalOperations(
			OperationComposite newLocalOperations, NotificationChain msgs) {
		OperationComposite oldLocalOperations = localOperations;
		localOperations = newLocalOperations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					ModelPackage.PROJECT_DATA__LOCAL_OPERATIONS,
					oldLocalOperations, newLocalOperations);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalOperations(OperationComposite newLocalOperations) {
		if (newLocalOperations != localOperations) {
			NotificationChain msgs = null;
			if (localOperations != null)
				msgs = ((InternalEObject) localOperations).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- ModelPackage.PROJECT_DATA__LOCAL_OPERATIONS,
						null, msgs);
			if (newLocalOperations != null)
				msgs = ((InternalEObject) newLocalOperations).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- ModelPackage.PROJECT_DATA__LOCAL_OPERATIONS,
						null, msgs);
			msgs = basicSetLocalOperations(newLocalOperations, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.PROJECT_DATA__LOCAL_OPERATIONS,
					newLocalOperations, newLocalOperations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.PROJECT_DATA__PROJECT:
			return basicSetProject(null, msgs);
		case ModelPackage.PROJECT_DATA__LOCAL_OPERATIONS:
			return basicSetLocalOperations(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ModelPackage.PROJECT_DATA__PROJECT:
			if (resolve)
				return getProject();
			return basicGetProject();
		case ModelPackage.PROJECT_DATA__LOCAL_OPERATIONS:
			if (resolve)
				return getLocalOperations();
			return basicGetLocalOperations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ModelPackage.PROJECT_DATA__PROJECT:
			setProject((Project) newValue);
			return;
		case ModelPackage.PROJECT_DATA__LOCAL_OPERATIONS:
			setLocalOperations((OperationComposite) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ModelPackage.PROJECT_DATA__PROJECT:
			setProject((Project) null);
			return;
		case ModelPackage.PROJECT_DATA__LOCAL_OPERATIONS:
			setLocalOperations((OperationComposite) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ModelPackage.PROJECT_DATA__PROJECT:
			return project != null;
		case ModelPackage.PROJECT_DATA__LOCAL_OPERATIONS:
			return localOperations != null;
		}
		return super.eIsSet(featureID);
	}

} //ProjectDataImpl

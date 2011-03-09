/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecp.model.workSpaceModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.ecp.model.workSpaceModel.WorkSpaceModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>ECP Workspace</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.ecp.model.workSpaceModel.impl.ECPWorkspaceImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.unicase.ecp.model.workSpaceModel.impl.ECPWorkspaceImpl#getActiveProject <em>Active Project</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ECPWorkspaceImpl extends EObjectImpl implements ECPWorkspace {
	/**
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<ECPProject> projects;

	/**
	 * The cached value of the '{@link #getActiveProject() <em>Active Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveProject()
	 * @generated
	 * @ordered
	 */
	protected ECPProject activeProject;

	private EditingDomain editingDomain;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ECPWorkspaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkSpaceModelPackage.Literals.ECP_WORKSPACE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ECPProject> getProjects() {
		if (projects == null) {
			projects = new EObjectContainmentWithInverseEList<ECPProject>(ECPProject.class, this, WorkSpaceModelPackage.ECP_WORKSPACE__PROJECTS, WorkSpaceModelPackage.ECP_PROJECT__WORKSPACE);
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ECPProject getActiveProject() {
		if (activeProject != null && activeProject.eIsProxy()) {
			InternalEObject oldActiveProject = (InternalEObject)activeProject;
			activeProject = (ECPProject)eResolveProxy(oldActiveProject);
			if (activeProject != oldActiveProject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT, oldActiveProject, activeProject));
			}
		}
		return activeProject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ECPProject basicGetActiveProject() {
		return activeProject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setActiveProject(ECPProject newActiveProject) {
		ECPProject oldActiveProject = activeProject;
		activeProject = newActiveProject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT, oldActiveProject, activeProject));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkSpaceModelPackage.ECP_WORKSPACE__PROJECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProjects()).basicAdd(otherEnd, msgs);
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
			case WorkSpaceModelPackage.ECP_WORKSPACE__PROJECTS:
				return ((InternalEList<?>)getProjects()).basicRemove(otherEnd, msgs);
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
			case WorkSpaceModelPackage.ECP_WORKSPACE__PROJECTS:
				return getProjects();
			case WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT:
				if (resolve) return getActiveProject();
				return basicGetActiveProject();
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
			case WorkSpaceModelPackage.ECP_WORKSPACE__PROJECTS:
				getProjects().clear();
				getProjects().addAll((Collection<? extends ECPProject>)newValue);
				return;
			case WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT:
				setActiveProject((ECPProject)newValue);
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
			case WorkSpaceModelPackage.ECP_WORKSPACE__PROJECTS:
				getProjects().clear();
				return;
			case WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT:
				setActiveProject((ECPProject)null);
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
			case WorkSpaceModelPackage.ECP_WORKSPACE__PROJECTS:
				return projects != null && !projects.isEmpty();
			case WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT:
				return activeProject != null;
		}
		return super.eIsSet(featureID);
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	public ECPProject getProject(EObject me) {
		for (ECPProject project : getProjects()) {
			if (project.contains(me)) {
				return project;
			}
		}
		throw new IllegalStateException("Project for element not found!");
	}

	public void setActiveModelelement(EObject eobject) {
		// TODO Auto-generated method stub

	}

	public void setEditingDomain(TransactionalEditingDomain editingDomain) {
		this.editingDomain = editingDomain;

	}

	public boolean isRootObject(EObject eObject) {
		for (ECPProject ecpProject : getProjects()) {
			if (ecpProject.getRootObject().equals(eObject)) {
				return true;
			}
		}
		return false;
	}

} // ECPWorkspaceImpl

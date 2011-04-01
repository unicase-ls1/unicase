/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.accesscontrol.roles.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.Role;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.RolesPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Role</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.roles.impl.RoleImpl#getProjects <em>Projects</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class RoleImpl extends EObjectImpl implements Role {
	/**
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<ProjectId> projects;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RolesPackage.Literals.ROLE;
	}

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> Get all projects of the role.
	 * 
	 * @return a list of project ids <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("serial")
	public EList<ProjectId> getProjects() {
		if (projects == null) {
			// the contains() method of EObjectEList uses reference equality ,
			// because its useEquals() return false.
			// we need to compare using equals method.
			projects = new EObjectResolvingEList<ProjectId>(ProjectId.class, this, RolesPackage.ROLE__PROJECTS) {

				@Override
				protected boolean useEquals() {
					return true;
				}

			};
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc --> Determines if the role can administrate the project.
	 * 
	 * @param projectId the project id
	 * @return true if the role can <!-- end-user-doc --> {@inheritDoc}
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.roles.Role#canAdministrate(org.eclipse.emf.emfstore.server.model.ProjectId)
	 * @generated NOT
	 */
	public boolean canAdministrate(ProjectId projectId) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.roles.Role#canCreate(org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.ecore.EObject)
	 * @generated NOT
	 */
	public boolean canCreate(ProjectId projectId, EObject modelElement) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.roles.Role#canDelete(org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.ecore.EObject)
	 * @generated NOT
	 */
	public boolean canDelete(ProjectId projectId, EObject modelElement) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.roles.Role#canModify(org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.ecore.EObject)
	 * @generated NOT
	 */
	public boolean canModify(ProjectId projectId, EObject modelElement) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.roles.Role#canRead(org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.ecore.EObject)
	 * @generated NOT
	 */
	public boolean canRead(ProjectId projectId, EObject modelElement) {
		return false;
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RolesPackage.ROLE__PROJECTS:
			return ((InternalEList<?>) getProjects()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.impl.BasicEObjectImpl#eGet(int, boolean, boolean)
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RolesPackage.ROLE__PROJECTS:
			return getProjects();
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
		case RolesPackage.ROLE__PROJECTS:
			getProjects().clear();
			getProjects().addAll((Collection<? extends ProjectId>) newValue);
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
		case RolesPackage.ROLE__PROJECTS:
			getProjects().clear();
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
		case RolesPackage.ROLE__PROJECTS:
			return projects != null && !projects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * Checks whether the role is connected to a project.
	 * 
	 * @param projectId the project
	 * @return true or false
	 * @generated NOT
	 */
	protected boolean isMyProject(ProjectId projectId) {
		return getProjects().contains(projectId);
	}

} // RoleImpl

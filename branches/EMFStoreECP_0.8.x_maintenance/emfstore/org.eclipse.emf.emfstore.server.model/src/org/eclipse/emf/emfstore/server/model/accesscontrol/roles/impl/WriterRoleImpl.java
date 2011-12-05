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
package org.eclipse.emf.emfstore.server.model.accesscontrol.roles.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.RolesPackage;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.WriterRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Writer Role</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class WriterRoleImpl extends RoleImpl implements WriterRole {
	@Override
	public boolean canAdministrate(ProjectId projectId) {
		return false;
	}

	@Override
	public boolean canCreate(ProjectId projectId, EObject modelElement) {
		return isMyProject(projectId);
	}

	@Override
	public boolean canDelete(ProjectId projectId, EObject modelElement) {
		return isMyProject(projectId);
	}

	@Override
	public boolean canModify(ProjectId projectId, EObject modelElement) {
		return isMyProject(projectId);
	}

	@Override
	public boolean canRead(ProjectId projectId, EObject modelElement) {
		return isMyProject(projectId);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected WriterRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RolesPackage.Literals.WRITER_ROLE;
	}

} // WriterRoleImpl

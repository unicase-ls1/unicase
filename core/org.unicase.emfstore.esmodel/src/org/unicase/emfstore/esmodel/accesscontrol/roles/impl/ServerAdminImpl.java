/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.accesscontrol.roles.impl;

import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.emfstore.esmodel.accesscontrol.roles.ServerAdmin;
import org.unicase.metamodel.ModelElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Server Admin</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class ServerAdminImpl extends RoleImpl implements ServerAdmin {
	@Override
	public boolean canAdministrate(ProjectId projectId) {
		return true;
	}

	@Override
	public boolean canCreate(ProjectId projectId, ModelElement modelElement) {
		return true;
	}

	@Override
	public boolean canDelete(ProjectId projectId, ModelElement modelElement) {
		return true;
	}

	@Override
	public boolean canModify(ProjectId projectId, ModelElement modelElement) {
		return true;
	}

	@Override
	public boolean canRead(ProjectId projectId, ModelElement modelElement) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ServerAdminImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RolesPackage.Literals.SERVER_ADMIN;
	}

} // ServerAdminImpl

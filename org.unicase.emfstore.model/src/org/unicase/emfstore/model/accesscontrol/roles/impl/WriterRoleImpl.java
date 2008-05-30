/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.model.accesscontrol.roles.impl;

import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.model.ProjectId;
import org.unicase.emfstore.model.accesscontrol.roles.RolesPackage;
import org.unicase.emfstore.model.accesscontrol.roles.WriterRole;
import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Writer Role</b></em>'.
 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WriterRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RolesPackage.Literals.WRITER_ROLE;
	}

} //WriterRoleImpl

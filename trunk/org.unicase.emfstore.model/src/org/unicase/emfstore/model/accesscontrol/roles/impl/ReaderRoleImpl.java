/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.model.accesscontrol.roles.impl;

import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.model.ProjectId;
import org.unicase.emfstore.model.accesscontrol.roles.ReaderRole;
import org.unicase.emfstore.model.accesscontrol.roles.RolesPackage;
import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reader Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ReaderRoleImpl extends RoleImpl implements ReaderRole {
	@Override
	public boolean canAdministrate(ProjectId projectId) {
		return false;
	}

	@Override
	public boolean canCreate(ProjectId projectId, ModelElement modelElement) {
		return false;
	}

	@Override
	public boolean canDelete(ProjectId projectId, ModelElement modelElement) {
		return false;
	}

	@Override
	public boolean canModify(ProjectId projectId, ModelElement modelElement) {
		return false;
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
	protected ReaderRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RolesPackage.Literals.READER_ROLE;
	}

} //ReaderRoleImpl

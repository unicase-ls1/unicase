/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.accesscontrol.roles;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.unicase.esmodel.ProjectId;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.esmodel.accesscontrol.roles.Role#getProjects <em>Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.esmodel.accesscontrol.roles.RolesPackage#getRole()
 * @model abstract="true"
 * @generated
 */
public interface Role extends EObject {
	/**
	 * Returns the value of the '<em><b>Projects</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.esmodel.ProjectId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' reference list.
	 * @see org.unicase.esmodel.accesscontrol.roles.RolesPackage#getRole_Projects()
	 * @model
	 * @generated
	 */
	EList<ProjectId> getProjects();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canAdministrate(ProjectId projectId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canCreate(ProjectId projectId, ModelElement modelElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canDelete(ProjectId projectId, ModelElement modelElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canModify(ProjectId projectId, ModelElement modelElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canRead(ProjectId projectId, ModelElement modelElement);

} // Role

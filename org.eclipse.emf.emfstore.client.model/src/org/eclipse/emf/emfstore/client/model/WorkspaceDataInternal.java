/**
 * <copyright> Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Unversitaet Muenchen. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.eclipse.emf.emfstore.client.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workspace Data Internal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal#getInternalProjectSpaces <em>Internal Project Spaces</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal#getInternalServerInfos <em>Internal Server Infos</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal#getInternalUsersessions <em>Internal Usersessions</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal#getInternalActiveProjectSpace <em>Internal Active Project Space</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getWorkspaceDataInternal()
 * @model
 * @generated NOT
 */
public interface WorkspaceDataInternal extends EObject, WorkspaceData {
	/**
	 * Returns the value of the '<em><b>Internal Project Spaces</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Project Spaces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Project Spaces</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getWorkspaceDataInternal_InternalProjectSpaces()
	 * @model containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<ProjectSpaceDataInternal> getInternalProjectSpaces();

	/**
	 * Returns the value of the '<em><b>Internal Server Infos</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.client.model.ServerInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Server Infos</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Server Infos</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getWorkspaceDataInternal_InternalServerInfos()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ServerInfo> getInternalServerInfos();

	/**
	 * Returns the value of the '<em><b>Internal Usersessions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.client.model.Usersession}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Usersessions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Usersessions</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getWorkspaceDataInternal_InternalUsersessions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Usersession> getInternalUsersessions();

	/**
	 * Returns the value of the '<em><b>Internal Active Project Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Active Project Space</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Active Project Space</em>' reference.
	 * @see #setInternalActiveProjectSpace(ProjectSpaceDataInternal)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getWorkspaceDataInternal_InternalActiveProjectSpace()
	 * @model keys="identifier"
	 * @generated
	 */
	ProjectSpaceDataInternal getInternalActiveProjectSpace();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal#getInternalActiveProjectSpace <em>Internal Active Project Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Active Project Space</em>' reference.
	 * @see #getInternalActiveProjectSpace()
	 * @generated
	 */
	void setInternalActiveProjectSpace(ProjectSpaceDataInternal value);

} // WorkspaceDataInternal

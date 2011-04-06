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
package org.eclipse.emf.emfstore.server.model;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Server Space</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.ServerSpace#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.ServerSpace#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.ServerSpace#getOpenSessions <em>Open Sessions</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.ServerSpace#getUsers <em>Users</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.ModelPackage#getServerSpace()
 * @model
 * @generated
 */
public interface ServerSpace extends EObject {
	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.ModelPackage#getServerSpace_Groups()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ACGroup> getGroups();

	/**
	 * Returns the value of the '<em><b>Projects</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.ProjectHistory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' containment reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' reference list.
	 * @see org.eclipse.emf.emfstore.server.model.ModelPackage#getServerSpace_Projects()
	 * @model
	 * @generated
	 */
	EList<ProjectHistory> getProjects();

	/**
	 * Returns the value of the '<em><b>Open Sessions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.SessionId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Open Sessions</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Open Sessions</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.ModelPackage#getServerSpace_OpenSessions()
	 * @model containment="true" resolveProxies="true" transient="true"
	 * @generated
	 */
	EList<SessionId> getOpenSessions();

	/**
	 * Returns the value of the '<em><b>Users</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Users</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Users</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.ModelPackage#getServerSpace_Users()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ACUser> getUsers();

	/**
	 * Make the current ServerSpace state persistent. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws IOException if save fails
	 * @model
	 * @generated NOT
	 */
	// FIXME: IOException???
	void save() throws IOException;

	/**
	 * Set the resource the ServerSpace is contained in. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param resource the resource
	 * @model
	 * @generated NOT
	 */
	// OW: do we need this method?
	void setResource(Resource resource);

} // ServerSpace

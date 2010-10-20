/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Server Space</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.ServerSpace#getGroups <em>Groups</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.ServerSpace#getProjects <em>Projects</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.ServerSpace#getOpenSessions <em>Open Sessions</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.ServerSpace#getUsers <em>Users</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.EsmodelPackage#getServerSpace()
 * @model
 * @generated
 */
public interface ServerSpace extends EObject {
	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.emfstore.esmodel.accesscontrol.ACGroup}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.EsmodelPackage#getServerSpace_Groups()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ACGroup> getGroups();

	/**
	 * Returns the value of the '<em><b>Projects</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.emfstore.esmodel.ProjectHistory}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' containment reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Projects</em>' reference list.
	 * @see org.unicase.emfstore.esmodel.EsmodelPackage#getServerSpace_Projects()
	 * @model
	 * @generated
	 */
	EList<ProjectHistory> getProjects();

	/**
	 * Returns the value of the '<em><b>Open Sessions</b></em>' containment reference list. The list contents are of
	 * type {@link org.unicase.emfstore.esmodel.SessionId}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Open Sessions</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Open Sessions</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.EsmodelPackage#getServerSpace_OpenSessions()
	 * @model containment="true" resolveProxies="true" transient="true"
	 * @generated
	 */
	EList<SessionId> getOpenSessions();

	/**
	 * Returns the value of the '<em><b>Users</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.emfstore.esmodel.accesscontrol.ACUser}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Users</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Users</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.EsmodelPackage#getServerSpace_Users()
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

/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Usersession</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.workspace.Usersession#getUsername <em>Username</em>}</li>
 *   <li>{@link org.unicase.workspace.Usersession#getPassword <em>Password</em>}</li>
 *   <li>{@link org.unicase.workspace.Usersession#getSessionId <em>Session Id</em>}</li>
 *   <li>{@link org.unicase.workspace.Usersession#getPersistentPassword <em>Persistent Password</em>}</li>
 *   <li>{@link org.unicase.workspace.Usersession#getServerInfo <em>Server Info</em>}</li>
 *   <li>{@link org.unicase.workspace.Usersession#isSavePassword <em>Save Password</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.workspace.WorkspacePackage#getUsersession()
 * @model
 * @generated
 */
public interface Usersession extends EObject {
	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see org.unicase.workspace.WorkspacePackage#getUsersession_Username()
	 * @model
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.Usersession#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see org.unicase.workspace.WorkspacePackage#getUsersession_Password()
	 * @model transient="true"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.Usersession#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Session Id</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session Id</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Session Id</em>' reference.
	 * @see #setSessionId(SessionId)
	 * @see org.unicase.workspace.WorkspacePackage#getUsersession_SessionId()
	 * @model transient="true"
	 * @generated
	 */
	SessionId getSessionId();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.Usersession#getSessionId <em>Session Id</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Session Id</em>' reference.
	 * @see #getSessionId()
	 * @generated
	 */
	void setSessionId(SessionId value);

	/**
	 * Returns the value of the '<em><b>Persistent Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persistent Password</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persistent Password</em>' attribute.
	 * @see #setPersistentPassword(String)
	 * @see org.unicase.workspace.WorkspacePackage#getUsersession_PersistentPassword()
	 * @model
	 * @generated
	 */
	String getPersistentPassword();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.Usersession#getPersistentPassword <em>Persistent Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Persistent Password</em>' attribute.
	 * @see #getPersistentPassword()
	 * @generated
	 */
	void setPersistentPassword(String value);

	/**
	 * Returns the value of the '<em><b>Server Info</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Info</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Server Info</em>' reference.
	 * @see #setServerInfo(ServerInfo)
	 * @see org.unicase.workspace.WorkspacePackage#getUsersession_ServerInfo()
	 * @model
	 * @generated
	 */
	ServerInfo getServerInfo();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.Usersession#getServerInfo <em>Server Info</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Server Info</em>' reference.
	 * @see #getServerInfo()
	 * @generated
	 */
	void setServerInfo(ServerInfo value);

	/**
	 * Returns the value of the '<em><b>Save Password</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Save Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Save Password</em>' attribute.
	 * @see #setSavePassword(boolean)
	 * @see org.unicase.workspace.WorkspacePackage#getUsersession_SavePassword()
	 * @model
	 * @generated
	 */
	boolean isSavePassword();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.Usersession#isSavePassword <em>Save Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Save Password</em>' attribute.
	 * @see #isSavePassword()
	 * @generated
	 */
	void setSavePassword(boolean value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isLoggedIn();

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> Log in.
	 * 
	 * @throws AccessControlException
	 *             if login fails.
	 * @throws EmfStoreException
	 *             if anything else fails. <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated NOT
	 */
	void logIn() throws AccessControlException, EmfStoreException;

	/**
	 * <!-- begin-user-doc --> Checkout a project to the local workspace.
	 * 
	 * @param projectInfo
	 *            a project info describing the project and its version
	 * @return a Project space containing the project
	 * @throws EmfStoreException
	 * 
	 *             <!-- end-user-doc -->
	 * 
	 * @model
	 * 
	 * @generated NOT
	 */
	ProjectSpace checkout(ProjectInfo projectInfo) throws EmfStoreException;

	/**
	 * Get the list of remotely available projects.
	 * 
	 * @return a list of project infos
	 * @throws EmfStoreException
	 *             if retrieval fails
	 * 
	 * @generated NOT
	 */
	List<ProjectInfo> getRemoteProjectList() throws EmfStoreException;

	/**
	 * Create a project on the server.
	 * 
	 * @param name
	 *            the project name
	 * @param description
	 *            the project description
	 * @return the ProjectInfo of the new Project
	 * 
	 * @throws AccessControlException
	 *             if creating projects is not allowed
	 * @throws EmfStoreException
	 *             if creation fails
	 * 
	 * @generated NOT
	 */
	ProjectInfo createProject(String name, String description)
			throws AccessControlException, EmfStoreException;
	
	/**
	 * Returns a {@link AdminBroker} related to the user session.
	 * 
	 * @return {@link AdminBroker}
	 * @generated NOT
	 */
	AdminBroker getAdminBroker() throws ConnectionException;
	
	// end of custom code
} // Usersession

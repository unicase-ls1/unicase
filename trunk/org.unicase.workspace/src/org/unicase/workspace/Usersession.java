/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.unicase.esmodel.ProjectInfo;
import org.unicase.esmodel.SessionId;
import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.model.ProjectId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Usersession</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.workspace.Usersession#getUsername <em>Username</em>}</li>
 *   <li>{@link org.unicase.workspace.Usersession#getPassword <em>Password</em>}</li>
 *   <li>{@link org.unicase.workspace.Usersession#getSessionId <em>Session Id</em>}</li>
 *   <li>{@link org.unicase.workspace.Usersession#getServerInfo <em>Server Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.workspace.WorkspacePackage#getUsersession()
 * @model
 * @generated
 */
public interface Usersession extends EObject {
	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see org.unicase.workspace.WorkspacePackage#getUsersession_Username()
	 * @model
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.Usersession#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see org.unicase.workspace.WorkspacePackage#getUsersession_Password()
	 * @model transient="true"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.Usersession#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Session Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Session Id</em>' reference.
	 * @see #setSessionId(SessionId)
	 * @see org.unicase.workspace.WorkspacePackage#getUsersession_SessionId()
	 * @model
	 * @generated
	 */
	SessionId getSessionId();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.Usersession#getSessionId <em>Session Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session Id</em>' reference.
	 * @see #getSessionId()
	 * @generated
	 */
	void setSessionId(SessionId value);

	/**
	 * Returns the value of the '<em><b>Server Info</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Info</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Info</em>' reference.
	 * @see #setServerInfo(ServerInfo)
	 * @see org.unicase.workspace.WorkspacePackage#getUsersession_ServerInfo()
	 * @model
	 * @generated
	 */
	ServerInfo getServerInfo();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.Usersession#getServerInfo <em>Server Info</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Info</em>' reference.
	 * @see #getServerInfo()
	 * @generated
	 */
	void setServerInfo(ServerInfo value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isLoggedIn();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void logIn(String password);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	void logIn(ServerInfo serverInfo) throws ConnectionException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws ConnectionException 
	 * @model
	 * @generated NOT
	 */
	ProjectSpace checkout(ProjectId projectId, VersionSpec versionSpec) throws ConnectionException;

	/**
	 * @return
	 * @throws ConnectionException 
	 *
	 * @generated NOT
	 */
	List<ProjectInfo> getRemoteProjectList() throws ConnectionException;
	
} // Usersession

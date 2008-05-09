/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.unicase.esmodel.ProjectInfo;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Server Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.workspace.ServerInfo#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.workspace.ServerInfo#getUrl <em>Url</em>}</li>
 *   <li>{@link org.unicase.workspace.ServerInfo#getPort <em>Port</em>}</li>
 *   <li>{@link org.unicase.workspace.ServerInfo#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.unicase.workspace.ServerInfo#getProjectInfos <em>Project Infos</em>}</li>
 *   <li>{@link org.unicase.workspace.ServerInfo#getLastUsersession <em>Last Usersession</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.workspace.WorkspacePackage#getServerInfo()
 * @model
 * @generated
 */
public interface ServerInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.unicase.workspace.WorkspacePackage#getServerInfo_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ServerInfo#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see org.unicase.workspace.WorkspacePackage#getServerInfo_Url()
	 * @model required="true"
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ServerInfo#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(String)
	 * @see org.unicase.workspace.WorkspacePackage#getServerInfo_Port()
	 * @model required="true"
	 * @generated
	 */
	String getPort();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ServerInfo#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(String value);

	/**
	 * Returns the value of the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Name</em>' attribute.
	 * @see #setDisplayName(String)
	 * @see org.unicase.workspace.WorkspacePackage#getServerInfo_DisplayName()
	 * @model
	 * @generated
	 */
	String getDisplayName();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ServerInfo#getDisplayName <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' attribute.
	 * @see #getDisplayName()
	 * @generated
	 */
	void setDisplayName(String value);

	/**
	 * Returns the value of the '<em><b>Project Infos</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.esmodel.ProjectInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Infos</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Infos</em>' reference list.
	 * @see org.unicase.workspace.WorkspacePackage#getServerInfo_ProjectInfos()
	 * @model transient="true"
	 * @generated
	 */
	EList<ProjectInfo> getProjectInfos();

	/**
	 * Returns the value of the '<em><b>Last Usersession</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.workspace.Usersession#getServerInfo <em>Server Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Usersession</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Usersession</em>' reference.
	 * @see #setLastUsersession(Usersession)
	 * @see org.unicase.workspace.WorkspacePackage#getServerInfo_LastUsersession()
	 * @see org.unicase.workspace.Usersession#getServerInfo
	 * @model opposite="serverInfo"
	 * @generated
	 */
	Usersession getLastUsersession();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ServerInfo#getLastUsersession <em>Last Usersession</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Usersession</em>' reference.
	 * @see #getLastUsersession()
	 * @generated
	 */
	void setLastUsersession(Usersession value);

} // ServerInfo

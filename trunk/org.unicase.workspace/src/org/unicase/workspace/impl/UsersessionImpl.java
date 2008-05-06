/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.unicase.emfstore.EmfStoreException;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.esmodel.ProjectInfo;
import org.unicase.esmodel.SessionId;

import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.model.ProjectId;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.connectionmanager.ConnectionException;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Usersession</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.workspace.impl.UsersessionImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.UsersessionImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.UsersessionImpl#getSessionId <em>Session Id</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.UsersessionImpl#getServerInfo <em>Server Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UsersessionImpl extends EObjectImpl implements Usersession {
	
	/**
	 * @generated NOT
	 */
	private WorkspaceManager workspaceManager;
	
	/**
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected String username = USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSessionId() <em>Session Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSessionId()
	 * @generated
	 * @ordered
	 */
	protected SessionId sessionId;

	/**
	 * The cached value of the '{@link #getServerInfo() <em>Server Info</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerInfo()
	 * @generated
	 * @ordered
	 */
	protected ServerInfo serverInfo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsersessionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.USERSESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.USERSESSION__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.USERSESSION__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SessionId getSessionId() {
		if (sessionId != null && sessionId.eIsProxy()) {
			InternalEObject oldSessionId = (InternalEObject)sessionId;
			sessionId = (SessionId)eResolveProxy(oldSessionId);
			if (sessionId != oldSessionId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkspacePackage.USERSESSION__SESSION_ID, oldSessionId, sessionId));
			}
		}
		return sessionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SessionId basicGetSessionId() {
		return sessionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSessionId(SessionId newSessionId) {
		SessionId oldSessionId = sessionId;
		sessionId = newSessionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.USERSESSION__SESSION_ID, oldSessionId, sessionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerInfo getServerInfo() {
		if (serverInfo != null && serverInfo.eIsProxy()) {
			InternalEObject oldServerInfo = (InternalEObject)serverInfo;
			serverInfo = (ServerInfo)eResolveProxy(oldServerInfo);
			if (serverInfo != oldServerInfo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkspacePackage.USERSESSION__SERVER_INFO, oldServerInfo, serverInfo));
			}
		}
		return serverInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerInfo basicGetServerInfo() {
		return serverInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerInfo(ServerInfo newServerInfo) {
		ServerInfo oldServerInfo = serverInfo;
		serverInfo = newServerInfo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.USERSESSION__SERVER_INFO, oldServerInfo, serverInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isLoggedIn() {
		return this.sessionId!=null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws ConnectionException 
	 * @throws AccessControlException 
	 * @generated NOT
	 */
	public void logIn(String password) throws ConnectionException, AccessControlException {
		//MK sanity checks for usersession state
		this.password=password;
		ConnectionManager connectionManager = this.getWorkspaceManager().getConnectionManager();
		this.setSessionId(connectionManager.logIn(username, password, serverInfo));
	}

	/**
	 * @return
	 * @generated NOT
	 */
	private WorkspaceManager getWorkspaceManager() {
		if (this.workspaceManager==null) {
			this.workspaceManager=WorkspaceManager.getInstance();
		}
		return this.workspaceManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws ConnectionException 
	 * @generated NOT
	 */
	public ProjectSpace checkout(ProjectId projectId, VersionSpec versionSpec) throws EmfStoreException {
		//MK sanity checks for usersession state
		return this.getWorkspaceManager().getCurrentWorkspace().checkout(this, projectId, versionSpec);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkspacePackage.USERSESSION__USERNAME:
				return getUsername();
			case WorkspacePackage.USERSESSION__PASSWORD:
				return getPassword();
			case WorkspacePackage.USERSESSION__SESSION_ID:
				if (resolve) return getSessionId();
				return basicGetSessionId();
			case WorkspacePackage.USERSESSION__SERVER_INFO:
				if (resolve) return getServerInfo();
				return basicGetServerInfo();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkspacePackage.USERSESSION__USERNAME:
				setUsername((String)newValue);
				return;
			case WorkspacePackage.USERSESSION__PASSWORD:
				setPassword((String)newValue);
				return;
			case WorkspacePackage.USERSESSION__SESSION_ID:
				setSessionId((SessionId)newValue);
				return;
			case WorkspacePackage.USERSESSION__SERVER_INFO:
				setServerInfo((ServerInfo)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case WorkspacePackage.USERSESSION__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case WorkspacePackage.USERSESSION__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case WorkspacePackage.USERSESSION__SESSION_ID:
				setSessionId((SessionId)null);
				return;
			case WorkspacePackage.USERSESSION__SERVER_INFO:
				setServerInfo((ServerInfo)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WorkspacePackage.USERSESSION__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case WorkspacePackage.USERSESSION__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case WorkspacePackage.USERSESSION__SESSION_ID:
				return sessionId != null;
			case WorkspacePackage.USERSESSION__SERVER_INFO:
				return serverInfo != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (username: ");
		result.append(username);
		result.append(", password: ");
		result.append(password);
		result.append(')');
		return result.toString();
	}

	public List<ProjectInfo> getRemoteProjectList() throws EmfStoreException {
		//MK sanity checks for usersession state
		return getWorkspaceManager().getConnectionManager().getProjectList(sessionId);
	}

} //UsersessionImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.model.ProjectInfo;
import org.unicase.emfstore.model.SessionId;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
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
 *   <li>{@link org.unicase.workspace.impl.UsersessionImpl#getPersistentPassword <em>Persistent Password</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.UsersessionImpl#getServerInfo <em>Server Info</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.UsersessionImpl#isSavePassword <em>Save Password</em>}</li>
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
	 * The default value of the '{@link #getPersistentPassword() <em>Persistent Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistentPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PERSISTENT_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPersistentPassword() <em>Persistent Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistentPassword()
	 * @generated
	 * @ordered
	 */
	protected String persistentPassword = PERSISTENT_PASSWORD_EDEFAULT;

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
	 * The default value of the '{@link #isSavePassword() <em>Save Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSavePassword()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SAVE_PASSWORD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSavePassword() <em>Save Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSavePassword()
	 * @generated
	 * @ordered
	 */
	protected boolean savePassword = SAVE_PASSWORD_EDEFAULT;

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
	public void setPasswordGen(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.USERSESSION__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPassword(String newPassword) {
		setPasswordGen(newPassword);
		if (isSavePassword()) {
			setPersistentPassword(newPassword);
		}
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
	public String getPersistentPassword() {
		return persistentPassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersistentPassword(String newPersistentPassword) {
		String oldPersistentPassword = persistentPassword;
		persistentPassword = newPersistentPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.USERSESSION__PERSISTENT_PASSWORD, oldPersistentPassword, persistentPassword));
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
	public NotificationChain basicSetServerInfo(ServerInfo newServerInfo, NotificationChain msgs) {
		ServerInfo oldServerInfo = serverInfo;
		serverInfo = newServerInfo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkspacePackage.USERSESSION__SERVER_INFO, oldServerInfo, newServerInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerInfo(ServerInfo newServerInfo) {
		if (newServerInfo != serverInfo) {
			NotificationChain msgs = null;
			if (serverInfo != null)
				msgs = ((InternalEObject)serverInfo).eInverseRemove(this, WorkspacePackage.SERVER_INFO__LAST_USERSESSION, ServerInfo.class, msgs);
			if (newServerInfo != null)
				msgs = ((InternalEObject)newServerInfo).eInverseAdd(this, WorkspacePackage.SERVER_INFO__LAST_USERSESSION, ServerInfo.class, msgs);
			msgs = basicSetServerInfo(newServerInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.USERSESSION__SERVER_INFO, newServerInfo, newServerInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSavePassword() {
		return savePassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSavePasswordGen(boolean newSavePassword) {
		boolean oldSavePassword = savePassword;
		savePassword = newSavePassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.USERSESSION__SAVE_PASSWORD, oldSavePassword, savePassword));
	}
	
	/** 
	 * @see org.unicase.workspace.Usersession#setSavePassword(boolean)
	 *
	 * @generated NOT
	 */
	public void setSavePassword(boolean newSavePassword) {
		setSavePasswordGen(newSavePassword);
		if (getPassword()!=null) {
			setPersistentPassword(getPassword());
		}
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
	 * @generated NOT
	 */
	public void logIn() throws EmfStoreException, AccessControlException {
		ConnectionManager connectionManager = this.getWorkspaceManager().getConnectionManager();
		
		//FIXME:
		//prepare serverInfo for send: copy and remove usersession
		ServerInfo copy = (ServerInfo)EcoreUtil.copy(serverInfo);
		copy.setLastUsersession(null);
		
		this.setSessionId(connectionManager.logIn(username, password, copy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ProjectSpace checkout(ProjectInfo projectInfo) throws EmfStoreException {
		return this.getWorkspaceManager().getCurrentWorkspace().checkout(this, projectInfo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkspacePackage.USERSESSION__SERVER_INFO:
				if (serverInfo != null)
					msgs = ((InternalEObject)serverInfo).eInverseRemove(this, WorkspacePackage.SERVER_INFO__LAST_USERSESSION, ServerInfo.class, msgs);
				return basicSetServerInfo((ServerInfo)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkspacePackage.USERSESSION__SERVER_INFO:
				return basicSetServerInfo(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case WorkspacePackage.USERSESSION__PERSISTENT_PASSWORD:
				return getPersistentPassword();
			case WorkspacePackage.USERSESSION__SERVER_INFO:
				if (resolve) return getServerInfo();
				return basicGetServerInfo();
			case WorkspacePackage.USERSESSION__SAVE_PASSWORD:
				return isSavePassword() ? Boolean.TRUE : Boolean.FALSE;
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
			case WorkspacePackage.USERSESSION__PERSISTENT_PASSWORD:
				setPersistentPassword((String)newValue);
				return;
			case WorkspacePackage.USERSESSION__SERVER_INFO:
				setServerInfo((ServerInfo)newValue);
				return;
			case WorkspacePackage.USERSESSION__SAVE_PASSWORD:
				setSavePassword(((Boolean)newValue).booleanValue());
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
			case WorkspacePackage.USERSESSION__PERSISTENT_PASSWORD:
				setPersistentPassword(PERSISTENT_PASSWORD_EDEFAULT);
				return;
			case WorkspacePackage.USERSESSION__SERVER_INFO:
				setServerInfo((ServerInfo)null);
				return;
			case WorkspacePackage.USERSESSION__SAVE_PASSWORD:
				setSavePassword(SAVE_PASSWORD_EDEFAULT);
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
			case WorkspacePackage.USERSESSION__PERSISTENT_PASSWORD:
				return PERSISTENT_PASSWORD_EDEFAULT == null ? persistentPassword != null : !PERSISTENT_PASSWORD_EDEFAULT.equals(persistentPassword);
			case WorkspacePackage.USERSESSION__SERVER_INFO:
				return serverInfo != null;
			case WorkspacePackage.USERSESSION__SAVE_PASSWORD:
				return savePassword != SAVE_PASSWORD_EDEFAULT;
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
		result.append(", persistentPassword: ");
		result.append(persistentPassword);
		result.append(", savePassword: ");
		result.append(savePassword);
		result.append(')');
		return result.toString();
	}

	public List<ProjectInfo> getRemoteProjectList() throws EmfStoreException {
		//MK sanity checks for usersession state
		return getWorkspaceManager().getConnectionManager().getProjectList(sessionId);
	}

} //UsersessionImpl

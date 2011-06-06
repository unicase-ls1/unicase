package org.eclipse.emf.emfstore.client.accesscontrol;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.client.WorkspaceManager;
import org.eclipse.emf.emfstore.client.connectionmanager.ConnectionManager;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.observers.LoginObserver;
import org.eclipse.emf.emfstore.client.util.Configuration;
import org.eclipse.emf.emfstore.client.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.ConnectionException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery;

public class UsersessionController {

	private final Usersession session;
	private WorkspaceManager workspaceManager;
	private Set<LoginObserver> loginObservers;

	public UsersessionController(Usersession session) {
		// TODO: IllegalArgumentException or the like if session is null
		this.session = session;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.Usersession#logIn()
	 * @generated NOT
	 */
	public void logIn() throws EmfStoreException, AccessControlException {
		ConnectionManager connectionManager = this.getWorkspaceManager()
				.getConnectionManager();
		// sanity checks
		if (session.getUsername() == null || session.getPassword() == null) {
			throw new AccessControlException("Username or Password not set!");
		}
		ServerInfo serverInfo = session.getServerInfo();
		if (serverInfo == null) {
			throw new IllegalStateException("No ServerInfo set!");
		}
		if (serverInfo.getUrl() == null) {
			throw new ConnectionException("Invalid server url: null");
		}

		// prepare serverInfo for send: copy and remove usersession
		ServerInfo copy = EcoreUtil.copy(serverInfo);
		copy.setLastUsersession(null);
		SessionId newSessionId = null;

		newSessionId = connectionManager.logIn(session.getUsername(),
				session.getPassword(), copy, Configuration.getClientVersion());

		session.setSessionId(newSessionId);
		updateACUser();
		updateProjectInfos();
		if (loginObservers != null) {
			for (LoginObserver observer : loginObservers) {
				observer.loginCompleted(session);
			}
		}

		// BEGIN SUPRESS CATCH EXCEPTION
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						"org.eclipse.emf.emfstore.client.notify.login");
		for (IConfigurationElement e : config) {
			try {
				Object o = e.createExecutableExtension("class");
				if (o instanceof LoginObserver) {
					LoginObserver loginObserver = (LoginObserver) o;
					loginObserver.loginCompleted(session);
				}
			} catch (CoreException e1) {
				WorkspaceUtil.logException(e1.getMessage(), e1);
			} catch (RuntimeException e1) {
				WorkspaceUtil.logException(e1.getMessage(), e1);
			}
		}
		// END SUPRESS CATCH EXCEPTION
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateACUser() throws EmfStoreException {
		ConnectionManager connectionManager = this.getWorkspaceManager()
				.getConnectionManager();
		session.setACUser(connectionManager.resolveUser(session.getSessionId(),
				null));
	}

	/**
	 * {@inheritDoc}
	 */
	public void logout() throws EmfStoreException {
		ConnectionManager connectionManager = this.getWorkspaceManager()
				.getConnectionManager();
		connectionManager.logout(session.getSessionId());
		session.setSessionId(null);
		updateProjectInfos();
	}

	/**
	 * @return
	 * @generated NOT
	 */
	private WorkspaceManager getWorkspaceManager() {
		if (this.workspaceManager == null) {
			this.workspaceManager = WorkspaceManager.getInstance();
		}
		return this.workspaceManager;
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateProjectInfos() {
		// BEGIN SUPRESS CATCH EXCEPTION
		try {
			session.getServerInfo().getProjectInfos().clear();
			// TODO MK: is this correct?
			if (isLoggedIn()) {
				session.getServerInfo().getProjectInfos()
						.addAll(getRemoteProjectList());
			}
			getWorkspaceManager().getCurrentWorkspace().save();
		} catch (EmfStoreException e) {
			WorkspaceUtil.logException(e.getMessage(), e);
		} catch (RuntimeException e) {
			WorkspaceUtil.logException(e.getMessage(), e);
		}
		// END SUPRESS CATCH EXCEPTION
	}

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> Return whether session is logged in.
	 * 
	 * @return true if session is logged in <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isLoggedIn() {
		return session.getSessionId() != null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.Usersession#getRemoteProjectList()
	 */
	public List<ProjectInfo> getRemoteProjectList() throws EmfStoreException {
		// TODO: MK sanity checks for usersession state
		return getWorkspaceManager().getConnectionManager().getProjectList(
				session.getSessionId());
	}

	/**
	 * {@inheritDoc}
	 */
	public void addLoginObserver(LoginObserver observer) {
		if (loginObservers == null) {
			loginObservers = new HashSet<LoginObserver>();
		}
		loginObservers.add(observer);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeLoginObserver(LoginObserver observer) {
		if (loginObservers != null) {
			loginObservers.remove(observer);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public List<HistoryInfo> getHistoryInfo(ProjectId projectId,
			HistoryQuery query) throws EmfStoreException {
		ConnectionManager connectionManager = WorkspaceManager.getInstance()
				.getConnectionManager();
		return connectionManager.getHistoryInfo(session.getSessionId(),
				projectId, query);
	}

}

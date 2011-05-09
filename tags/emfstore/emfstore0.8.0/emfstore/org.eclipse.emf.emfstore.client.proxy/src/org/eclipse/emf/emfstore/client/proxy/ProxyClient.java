package org.eclipse.emf.emfstore.client.proxy;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.emfstore.client.model.Configuration;
import org.eclipse.emf.emfstore.client.model.ModelFactory;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Workspace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.connectionmanager.ConnectionManager;
import org.eclipse.emf.emfstore.client.model.connectionmanager.KeyStoreManager;
import org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceImpl;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ClientVersionInfo;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningFactory;

/**
 * Supposed to be a helper class for all proxy clients. These are used to
 * programmaticly connect to the server.
 * 
 * @author wesendon
 * 
 */
public abstract class ProxyClient {

	private ConnectionManager connectionManager;
	private SessionId sessionId;
	private ProjectSpaceImpl projectSpace;

	public void loginServer(String username, String password, String url,
			String clientVersion, String certificate, int port) throws EmfStoreException {
		setConnectionManager(WorkspaceManager.getInstance()
				.getConnectionManager());
		ClientVersionInfo _clientVersion = Configuration.getClientVersion();
		if (clientVersion != null) {
			_clientVersion.setVersion(clientVersion);
		}
		ServerInfo serverInfo = getServerInfo(url, certificate, port);
		setSessionId(getConnectionManager().logIn(username, KeyStoreManager
				.getInstance().encrypt(password, serverInfo), serverInfo,
				_clientVersion));
	}

	public ServerInfo getServerInfo(String url, String certificate, int port) {
		ServerInfo serverInfo = ModelFactory.eINSTANCE.createServerInfo();
		serverInfo.setPort(port);
		serverInfo.setUrl(url);
		if (certificate != null) {
			serverInfo.setCertificateAlias(certificate);
		}
		return serverInfo;
	}

	public PrimaryVersionSpec createVersionSpec(int id) {
		PrimaryVersionSpec primaryVersionSpec = VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec();
		primaryVersionSpec.setIdentifier(id);
		return primaryVersionSpec;
	}
	
	public ProjectInfo getProjectInfo(String projectName, boolean contains) throws EmfStoreException {
		for (ProjectInfo info : getProjectList()) {
			if ((!contains && info.getName().equals(projectName))
					|| (contains && info.getName().contains(projectName))) {
				return info;
			}
		}
		return null;
	}
	
	abstract public void run() throws Exception;
	
	public ProjectSpaceImpl createTransientProjectSpace(Project project) {
		setProjectSpace((ProjectSpaceImpl) ModelFactory.eINSTANCE.createProjectSpace());
		getProjectSpace().setBaseVersion(VersioningFactory.eINSTANCE.createPrimaryVersionSpec());
		getProjectSpace().setIdentifier("testProjectSpace");
		getProjectSpace().setLastUpdated(new Date());
		getProjectSpace().setLocalOperations(ModelFactory.eINSTANCE.createOperationComposite());
		getProjectSpace().setProjectDescription("ps description");
		getProjectSpace().setProjectId(org.eclipse.emf.emfstore.server.model.ModelFactory.eINSTANCE.createProjectId());
		getProjectSpace().setProjectName("ps n0ame");
		getProjectSpace().makeTransient();
		getProjectSpace().setProject(project);
		getProjectSpace().init();
		return getProjectSpace();
	}

	public LogMessage createLogMessage(String author, String message, Date date) {
		LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		logMessage.setAuthor(author);
		logMessage.setClientDate(date);
		logMessage.setMessage(message);
		return logMessage;
	}
	
	public List<ProjectInfo> getProjectList() throws EmfStoreException {
		return getConnectionManager().getProjectList(getSessionId());
	}

	public Workspace getWorkspace() {
		return WorkspaceManager.getInstance().getCurrentWorkspace();
	}

	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	public void setSessionId(SessionId sessionId) {
		this.sessionId = sessionId;
	}

	public SessionId getSessionId() {
		return sessionId;
	}

	public void setProjectSpace(ProjectSpaceImpl projectSpace) {
		this.projectSpace = projectSpace;
	}

	public ProjectSpaceImpl getProjectSpace() {
		return projectSpace;
	}
}

package org.unicase.proxyclient;

import java.util.Date;
import java.util.List;

import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.Project;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.connectionmanager.KeyStoreManager;
import org.unicase.workspace.impl.ProjectSpaceImpl;

/**
 * Supposed to be a helper class for all proxy clients. These are used to
 * programmaticly connect to the server.
 * 
 * @author wesendon
 * 
 */
public class ProxyClient {

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
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
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
	
	public ProjectSpaceImpl createTransientProjectSpace(Project project) {
		setProjectSpace((ProjectSpaceImpl) WorkspaceFactory.eINSTANCE.createProjectSpace());
		getProjectSpace().setBaseVersion(VersioningFactory.eINSTANCE.createPrimaryVersionSpec());
		getProjectSpace().setIdentifier("testProjectSpace");
		getProjectSpace().setLastUpdated(new Date());
		getProjectSpace().setLocalOperations(WorkspaceFactory.eINSTANCE.createOperationComposite());
		getProjectSpace().setProjectDescription("ps description");
		getProjectSpace().setProjectId(EsmodelFactory.eINSTANCE.createProjectId());
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

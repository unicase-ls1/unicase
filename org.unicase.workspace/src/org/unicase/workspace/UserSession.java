package org.unicase.workspace;

import java.util.List;

import org.unicase.model.ProjectId;

public class UserSession {
	
	private ServerInfo serverInfo;
	private String username;
	private SessionId sessionId;
		
	private transient String password;
	
	private UCConnectionManager connectionManager;
	
	public UserSession(ServerInfo serverInfo) {
		this.serverInfo=serverInfo;
		this.connectionManager=UCConnectionManager.getInstance();
	}
	
	public void logIn(String username, String password) {
		
	}
	
	public boolean isLoggedIn() {
		return sessionId!=null;
	}
	
	public List<ProjectInfo> getProjectList() {
		return connectionManager.getProjectList(sessionId, serverInfo);
	}
	
	public UCWorkspace checkOut(ProjectId projectId, PrimaryVersionSpec version) {
		return connectionManager.checkOut(sessionId, serverInfo, projectId, version);
	}
}

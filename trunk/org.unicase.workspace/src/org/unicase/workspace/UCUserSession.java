package org.unicase.workspace;

import java.util.List;

import org.unicase.model.ProjectId;

public class UCUserSession {
	
	private ServerInfo serverInfo;
	private String username;
	private SessionId sessionId;
		
	private transient String password;
	
	private UCConnectionManager connectionManager;
	
	public UCUserSession(ServerInfo serverInfo) {
		this.serverInfo=serverInfo;
		this.connectionManager=UCConnectionManager.getInstance();
	}
	
	public void logIn(String username, String password) {
		this.sessionId=connectionManager.logIn(serverInfo, username, password);
	}
	
	public boolean isLoggedIn() {
		return sessionId!=null;
	}
	
	public List<ProjectInfo> getProjectList() {
		return connectionManager.getProjectList(sessionId);
	}
	
	public UCWorkspace checkOut(ProjectId projectId, PrimaryVersionSpec version) {
		return connectionManager.checkOut(sessionId, projectId, version);
	}
	
	public static ServerInfo getDefaultServerInfo() {
		return new ServerInfo("someUrl", "someName", "somePort");
	}
}

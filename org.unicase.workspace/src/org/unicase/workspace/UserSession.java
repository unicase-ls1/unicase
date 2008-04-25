package org.unicase.workspace;

import java.util.List;

import org.unicase.model.ProjectId;

public class UserSession {
	
	private ServerInfo serverInfo;
	private String username;
	private SessionId sessionId;
	
	private transient String password;
	
	public UserSession(ServerInfo serverInfo) {
		this.serverInfo=serverInfo;
	}
	
	public void logIn(String username, String password) {
		
	}
	
	public boolean isLoggedIn() {
		return sessionId!=null;
	}
	
	public List<ProjectInfo> getProjectList() {
		return null;
	}
	
	public UCWorkspace checkOut(ProjectId projectId, PrimaryVersionSpec version) {
		return null;
	}
}

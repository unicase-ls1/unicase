package org.unicase.workspace;

import java.util.List;

import org.unicase.model.ProjectId;

public class UCConnectionManager {
	
	private static UCConnectionManager instance;
	
	private UCConnectionManager() {
		
	}
	
	public static UCConnectionManager getInstance() {
		if (instance==null) {
			instance=new UCConnectionManager();
		}
		return instance;
	}
	
	public List<ProjectInfo> getProjectList(SessionId sessionId, ServerInfo serverInfo) {
		return null;
	}
	
	public UCWorkspace checkOut(SessionId sessionId, ServerInfo serverInfo, ProjectId projectId, PrimaryVersionSpec version) {
		return null;
	}
	
	public UCWorkspace getCurrentWorkspace() {
		return null;
	}
	
	public List<ChangePackage> getChanges(SessionId sessionId, ServerInfo serverInfo, VersionSpec sourceVersion, VersionSpec targetVersion) {
		return null;
	}
	
	public List<HistoryInfo> getHistoryInfos(SessionId sessionId, ServerInfo serverInfo, VersionSpec sourceVersion, VersionSpec targetVersion) {
		return null;
	}
}

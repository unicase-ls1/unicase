package org.unicase.workspace;

import java.util.List;

import org.unicase.model.ProjectId;

public class UCConnectionManager {
	
	public List<ProjectInfo> getProjectList(UserSession userSession) {
		return null;
	}
	
	public UCWorkspace checkOut(UserSession session, ProjectId projectId, PrimaryVersionSpec version) {
		return null;
	}
	
	public UCWorkspace getCurrentWorkspace() {
		return null;
	}
	
	public List<ChangePackage> getChanges(VersionSpec sourceVersion, VersionSpec targetVersion) {
		return null;
	}
	
	public List<HistoryInfo> getHistoryInfos(VersionSpec sourceVersion, VersionSpec targetVersion) {
		return null;
	}
}

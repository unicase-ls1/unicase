package org.unicase.workspace;

import java.util.List;

public class UCWorkspaceManager {
	
	private static UCWorkspaceManager instance;
	
	public static UCWorkspaceManager getInstance() {
		if (instance==null) {
			instance = new UCWorkspaceManager();
		}
		return instance;
	}
	
	public List<ProjectInfo> getProjectInfos() {
		return null;
	}
	
	public Project getProject(ProjectInfo projectInfo) {
		return null;
	}
	
	
	
}

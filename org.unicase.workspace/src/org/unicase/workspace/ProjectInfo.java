package org.unicase.workspace;

import org.unicase.model.ProjectId;

public class ProjectInfo {
	
	private ProjectId projectId;
	
	private String projectName;
	
	private String projectDescription;
	
	public ProjectInfo(ProjectId projectId, String projectName, String projectDescription) {
		this.projectId=projectId;
		this.projectName=projectName;
		this.projectDescription=projectDescription;
	}

	/**
	 * @return the projectId
	 */
	public ProjectId getProjectId() {
		return projectId;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @return the projectDescription
	 */
	public String getProjectDescription() {
		return projectDescription;
	}
}

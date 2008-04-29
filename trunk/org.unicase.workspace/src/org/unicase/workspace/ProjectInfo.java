package org.unicase.workspace;

import org.unicase.model.ProjectId;

public class ProjectInfo {
	
	private ProjectId projectId;
	
	private String projectName;
	
	private String projectDescription;
	
	private PrimaryVersionSpec version;
	
	public ProjectInfo(ProjectId projectId, String projectName, String projectDescription, PrimaryVersionSpec version) {
		this.projectId=projectId;
		this.projectName=projectName;
		this.projectDescription=projectDescription;
		this.version=version;
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

	/**
	 * @return the version
	 */
	public PrimaryVersionSpec getVersion() {
		return version;
	}
}

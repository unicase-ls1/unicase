package org.unicase.rapclient;

import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;

public class ProxyCommit {

	private static ProjectSpace projectSpace;
	private static Project project;
	
	public static void setProjectSpace(ProjectSpace currProjectSpace) {
		projectSpace = currProjectSpace;
	}

	public static ProjectSpace getProjectSpace() {
		return projectSpace;
	}
	
	public static Project getProject() {
		return project;
	}
	
	public static void setProject(Project currProject) {
		project = currProject;	
	}
	
	public ProxyCommit() {
		
	}
}

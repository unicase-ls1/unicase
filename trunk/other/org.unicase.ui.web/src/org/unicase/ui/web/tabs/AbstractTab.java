package org.unicase.ui.web.tabs;

import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

public abstract class AbstractTab {

	private Project currProject;
	private ProjectSpace currProjectSpace;
	
	public void foo(String projectName) {
		resolveProject(projectName);	
		createContent();
	}
	
	private void resolveProject(String projectName) {
		// TODO: resolve project via projectname directly
		for (ProjectSpace p:  WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces()) {
			if (p.getProjectName().equalsIgnoreCase(projectName)) {
				setCurrProjectSpace(p);
				setCurrProject(p.getProject());
			}
		}
	}
	
	public abstract void createContent();

	private void setCurrProject(Project currProject) {
		this.currProject = currProject;
	}

	public Project getCurrProject() {
		return currProject;
	}

	private void setCurrProjectSpace(ProjectSpace currProjectSpace) {
		this.currProjectSpace = currProjectSpace;
	}

	public ProjectSpace getCurrProjectSpace() {
		return currProjectSpace;
	}
}

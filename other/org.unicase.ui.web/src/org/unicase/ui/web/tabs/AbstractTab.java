package org.unicase.ui.web.tabs;

import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * Abstract tab for all tabs.
 * 
 * @author Edgar Müller
 * @author Fatih Ulusoy
 */
public abstract class AbstractTab {

	private Project currProject;
	
	private ProjectSpace currProjectSpace;
	
	/**
	 * Creates content.
	 * 
	 * @param projectName
	 */
	public void createContent(String projectName) {
		resolveProject(projectName);	
		createTabContent();
	}
	
	/**
	 * Creates tab content.
	 */
	public abstract void createTabContent();
	
	private void resolveProject(String projectName) {
		// TODO: resolve project via projectname directly
		EList<ProjectSpace> projectSpaces = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getProjectSpaces();
		for (ProjectSpace p : projectSpaces) {
			if (p.getProjectName().equalsIgnoreCase(projectName)) {
				setCurrProjectSpace(p);
				setCurrProject(p.getProject());
			}
		}
	}

	/**
	 * Gets current project.
	 * 
	 * @return current project
	 */
	public Project getCurrProject() {
		return currProject;
	}
	
	/**
	 * Sets current project.
	 * 
	 * @param currProject
	 */
	private void setCurrProject(Project currProject) {
		this.currProject = currProject;
	}

	/**
	 * Gets current project space.
	 * 
	 * @return current project space
	 */
	public ProjectSpace getCurrProjectSpace() {
		return currProjectSpace;
	}

	/**
	 * Sets current project space.
	 * 
	 * @param currProjectSpace
	 */
	private void setCurrProjectSpace(ProjectSpace currProjectSpace) {
		this.currProjectSpace = currProjectSpace;
	}
	
}



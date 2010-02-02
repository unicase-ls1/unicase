package org.unicase.ui.web.tabs;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * Abstract tab for all tabs.
 * 
 * @author Edgar Müller
 * @author Fatih Ulusoy
 */
public class ProjectObserver implements ProjectChangeObserver {

	private Project currProject;
	
	private ProjectSpace currProjectSpace;
	
	protected void resolveProject(String projectName) {
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
	protected void setCurrProject(Project currProject) {
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
	
	public void notify(Notification notification, Project project,
			ModelElement modelElement) {
		updateInput(project, modelElement);
	}

	public void modelElementAdded(Project project, ModelElement modelElement) {
		updateInput(project, modelElement);
	}

	public void modelElementDeleteStarted(Project project,
			ModelElement modelElement) {
		updateInput(project, modelElement);
	}

	public void modelElementDeleteCompleted(Project project,
			ModelElement modelElement) {
		updateInput(project, modelElement);
	}
	
	/**
	 * should be overriden by subclasses if you want to update tab
	 * 
	 * @param project
	 * @param modelElement
	 */
	public void updateInput(Project project, ModelElement modelElement) {
		// do nothing
	}
	
}



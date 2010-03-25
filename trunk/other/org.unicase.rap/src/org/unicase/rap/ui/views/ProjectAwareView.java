package org.unicase.rap.ui.views;

import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * Abstract class for a view that is dependant of a project.
 * 
 * @author emueller
 *
 */
public abstract class ProjectAwareView extends AbstractView implements ProjectChangeObserver {
	
	protected ProjectSpace projectSpace;
	
	public ProjectAwareView() {
		// TODO: parameter name currently hard coded
		String projectName = getHttpRequest().getParameter("name");
		if (projectName != null) {
			resolveProject(projectName);
			getProject().addProjectChangeObserver(this);
		}
	}
	
	public void setProjectSpace(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace; 
	}
	
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}
	
	public Project getProject() {
		return projectSpace.getProject();
	}
	
	// TODO: 
	protected void resolveProject(String projectName) {
		// TODO: resolve project via projectname directly
		EList<ProjectSpace> projectSpaces = WorkspaceManager.getInstance()
		.getCurrentWorkspace().getProjectSpaces();
		for (ProjectSpace p : projectSpaces) {
			if (p.getProjectName().equalsIgnoreCase(projectName)) {
				setProjectSpace(p);				
			}
		}
	}
}
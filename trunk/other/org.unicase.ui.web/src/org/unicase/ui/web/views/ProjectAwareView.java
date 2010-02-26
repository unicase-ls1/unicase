package org.unicase.ui.web.views;

import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * Abstract class for implementing a view that is dependant on a project.
 * 
 * @author emueller
 *
 */
public abstract class ProjectAwareView extends AbstractView 
	implements ProjectChangeObserver {
	
	protected ProjectSpace projectSpace;
	
	public ProjectAwareView() {
		
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
	
	public void init() {
		// TODO: connect parameter to 
		String projectName = getHttpRequest().getParameter("name");
		if (projectName != null) {
			resolveProject(projectName);
			getProject().addProjectChangeObserver(this);
		}
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
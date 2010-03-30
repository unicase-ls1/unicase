package org.unicase.rap.ui.views;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.ProjectKeysConfigEntity;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

import config.ConfigEntity;

/**
 * Abstract class for a view that is dependant of a project.
 * 
 * @author emueller
 *
 */
public abstract class ProjectAwareView extends AbstractView implements ProjectChangeObserver {
	
	/**
	 * The project space this view is associated with.
	 */
	protected ProjectSpace projectSpace;
	
	public ProjectAwareView() {
		// TODO: parameter names 'key' and 'name' currently hard coded
		String projectName = getHttpRequest().getParameter("name");
		if (projectName != null) {
			resolveProject(projectName);
			getProject().addProjectChangeObserver(this);
		}
		
		if (!isKeyParameterValid()) {
			MessageDialog.openInformation(Display.getDefault().getActiveShell(), 
					"Access denied", "You aren't allowed to access this site.");
		}
	}
	
	/**
	 * Checks whether a key parameter has been passed and if so, whether it is valid.
	 * If the project didn't define any key parameter, access is allowed.
	 */
	private boolean isKeyParameterValid() {
		
		String crypticElement = getHttpRequest().getParameter("key");
		
		ProjectKeysConfigEntity configEntity = new ProjectKeysConfigEntity();
		ConfigEntity cfgEntity = ConfigEntityStore.loadConigEntity(configEntity, configEntity.eClass());
		
		if (cfgEntity != null && projectSpace != null) {
			Object savedCrypticElement = cfgEntity.getProperties().get(projectSpace.getProjectName());
			
			if (savedCrypticElement != null && !savedCrypticElement.equals(crypticElement)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Sets the current project space.
	 * 
	 * @param projectSpace The project space to be set.
	 */
	public void setProjectSpace(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace; 
	}
	
	/**
	 * Gets the current project space.
	 * @return The currently project space.
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}
	
	/**
	 * Returns the project itself.
	 * 
	 * @return The project that is associated with this view.
	 */
	public Project getProject() {
		
		if (projectSpace != null) { 
			return projectSpace.getProject();
		}
		
		return null;
	}
	
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
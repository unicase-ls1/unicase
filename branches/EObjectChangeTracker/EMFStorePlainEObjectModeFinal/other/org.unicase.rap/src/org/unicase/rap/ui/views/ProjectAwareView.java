/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.ui.views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;

import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.metamodel.util.ProjectChangeObserver;

import config.ConfigEntity;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.ProjectKeysConfigEntity;

/**
 * Abstract class for a view that is dependent of a project.
 * 
 * @author Edgar Müller
 */
public abstract class ProjectAwareView extends AbstractView implements ProjectChangeObserver {

	/**  */
	public static final String NAME_OF_VIEW_ARGUMENT = "view";
	
	/**  */
	public static final String NAME_OF_PROJECT_ARGUMENT = "name";
	
	/**  */
	public static final String NAME_OF_KEY_ARGUMENT = "key";
	
	/**
	 * The project space this view is associated with.
	 */
	protected ProjectSpace projectSpace;
	
	/**
	 * The constructor.
	 */
	public ProjectAwareView() {
		// TODO: parameter names 'key' and 'name' currently hard coded
		String projectName = getHttpRequest().getParameter(NAME_OF_PROJECT_ARGUMENT);
		if (projectName != null) {
			resolveProject(projectName);
			Project project = getProject();
			if(project != null) {
				project.addProjectChangeObserver(this);
			}else {
				MessageDialog.openInformation(Display.getDefault().getActiveShell(), 
					"Access error", "One of your url argument is wrong.");
			}
		}
		String viewName = getHttpRequest().getParameter(NAME_OF_VIEW_ARGUMENT);
		
		if(viewName != null && !viewName.equals("config")) {
			if (!isKeyParameterValid()) {
				MessageDialog.openInformation(Display.getDefault().getActiveShell(), 
						"Access denied", "You aren't allowed to access this site.");
			}
		}
	}
	
	/**
	 * Checks whether a key parameter has been passed and if so, whether it is valid.
	 * If the project didn't define any key parameter, access is allowed.
	 */
	private boolean isKeyParameterValid() {
		
		String crypticElement = getHttpRequest().getParameter(NAME_OF_KEY_ARGUMENT);
		
		ProjectKeysConfigEntity configEntity = new ProjectKeysConfigEntity();
		ConfigEntityStore.loadConfigEntity(configEntity, configEntity.eClass());
		
		if (configEntity != null && (configEntity.getProperties().size() > 0) && projectSpace != null) {
			String savedCrypticElement = configEntity.getAccessKey(projectSpace.getProjectName());
			
			if (savedCrypticElement == null || !savedCrypticElement.equals(crypticElement)) {
				return false;
			}
			return true;
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
	
	/**
	 * 
	 * @param projectName Name of project.
	 */
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
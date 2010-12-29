package org.unicase.xmi.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.views.CreateProjectDialog;
import org.unicase.xmi.workspace.XMIECPWorkspace;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructureFactory;

public class NewProjectHandler extends AbstractHandler {
	
	/**
	 * Name of the new project.
	 */
	private String projectName;

	/**
	 * Description of the new project.
	 */
	private String projectDescription;
	
	/**
	 * File location of the new project.
	 */
	private String projectLocation;
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		// open dialog
		CreateProjectDialog dialog = new CreateProjectDialog(PlatformUI
			.getWorkbench().getDisplay().getActiveShell(), this);

		// work with the results of the dialog and create the project
		if(dialog.open() == Window.OK) {
			
			try {						
				// get ECPWorkspace
				final ECPWorkspace ws = ECPWorkspaceManager.getInstance().getWorkSpace();
				
				new XmiCommand(ws.getEditingDomain()) {

					@Override
					protected void doRun() {
						if(ws instanceof XMIECPWorkspace) {
							XMIECPFileProject project = XmiworkspacestructureFactory.eINSTANCE.createXMIECPFileProject();
							project.setProjectName(getProjectName());
							project.setProjectDescription(getProjectDescription());
							project.setXmiFilePath(getProjectLocation());
							
							// add a new XMIFileProject to the workspace
							((XMIECPWorkspace) ws).addProject(project);
						}
						else {
							new XMIWorkspaceException("Could not add project to workspace. Unknown workspace.");
						}
					}
					
				}.run(true);

			} catch (Exception e) {
				new XMIWorkspaceException("Could not create new model element.", e);
			}
		}
		
		return null;
	}
	
	// BEGIN GETTERS AND SETTERS
	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getProjectDescription() {
		return projectDescription;
	}


	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}


	public String getProjectLocation() {
		return projectLocation;
	}


	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}
	
	// END GETTERS AND SETTERS
}

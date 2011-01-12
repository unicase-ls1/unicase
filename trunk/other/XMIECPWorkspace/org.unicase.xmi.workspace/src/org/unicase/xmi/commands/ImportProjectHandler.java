package org.unicase.xmi.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.views.ImportProjectDialog;
import org.unicase.xmi.workspace.XMIECPWorkspace;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructureFactory;

public class ImportProjectHandler extends AbstractHandler {
	
	private String projectLocation;
	private String projectName;
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ImportProjectDialog dialog = new ImportProjectDialog(PlatformUI
			.getWorkbench().getDisplay().getActiveShell(), this);
		
		int dialogResult = dialog.open();
		if(dialogResult == Window.OK) {
			try {
				final ECPWorkspace ws = ECPWorkspaceManager.getInstance().getWorkSpace();
				
				new XmiCommand(ws.getEditingDomain()) {

					@Override
					protected void doRun() {
						if(ws instanceof XMIECPWorkspace && ws != null) {
							XMIECPFileProject project = XmiworkspacestructureFactory.eINSTANCE.createXMIECPFileProject(); // create the project blank
							project.setProjectName(projectName); // set name
							project.setXmiFilePath(projectLocation); // initialize it when setting the file
							
							// add a new XMIFileProject to the workspace
							((XMIECPWorkspace) ws).addProject(project);
						}
						else {
							new XMIWorkspaceException("Could not add project to workspace. Unknown workspace.");
						}
					}
					
				}.run(true);
				
			} catch (NoWorkspaceException e) {
				new XMIWorkspaceException("Could not add project to workspace. Unknown workspace.");
			}
		}
		
		return null;
	} // END execute(event)
	
	/**
	 * Sets the project's location
	 * @param path Path to the project's resource file.
	 */
	public void setProjectLocation(String path) {
		this.projectLocation = path;
	}
	
	/**
	 * Sets the project's name.
	 * @param name Name of the project.
	 */
	public void setProjectName(String name) {
		this.projectName = name;
	}
	
} // END ImportProjectHandler
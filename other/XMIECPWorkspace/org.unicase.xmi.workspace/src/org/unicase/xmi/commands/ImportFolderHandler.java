package org.unicase.xmi.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.views.ImportFolderDialog;
import org.unicase.xmi.workspace.XMIECPWorkspace;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructureFactory;

/**
 * Handler for importing files from a folder
 * @author kraftm, maierma
 *
 */
public class ImportFolderHandler extends AbstractHandler {

	/**
	 * Files that can be loaded as an xmi resource.
	 */
	private List<String> files = new ArrayList<String>();

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ImportFolderDialog dialog = new ImportFolderDialog(PlatformUI
			.getWorkbench().getDisplay().getActiveShell(), this);

		files.clear();
		if(dialog.open() == Window.OK) {			
			try {
				final ECPWorkspace ws = ECPWorkspaceManager.getInstance().getWorkSpace();
				
				// Go through all loadable files and make projects out of them.
				for(String filePath: files) {

					// set the name of the project as the full path of the project
					final String projectName = filePath;
					final String projectLocation = filePath;
					
					// wrap creation in command
					new XmiCommand((TransactionalEditingDomain) ws.getEditingDomain()) {
	
						@Override
						protected void doRun() {
							if(ws instanceof XMIECPWorkspace && ws != null) {
								XMIECPFileProject project = XmiworkspacestructureFactory.eINSTANCE.createXMIECPFileProject(); // create the project blank
								project.setProjectName(projectName); // set name
								project.setProjectDescription("Imported Project"); // set description
								project.setXmiFilePath(projectLocation); // initialize it when setting the file
								
								// add a new XMIFileProject to the workspace
								((XMIECPWorkspace) ws).addProject(project);
							}
							else {
								new XMIWorkspaceException("Could not add project to workspace. Unknown workspace.");
							}
						}
						
					}.run(true);
				
				}
				
			} catch (NoWorkspaceException e) {
				new XMIWorkspaceException("Could not add project to workspace. Unknown workspace.");
			}
		}
		
		return null;
	}
	
	/**
	 * Adds loadable files to handler.
	 * @param files Files that can be loaded as an xmi resource.
	 */
	public void addLoadableFiles(List<String> files) {
		this.files.addAll(files);
	}
}

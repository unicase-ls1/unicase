package org.unicase.xmi.commands;

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.ui.navigator.TreeView;
import org.unicase.ui.util.ActionHelper;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.views.DeletedObjectDialog;
import org.unicase.xmi.workspace.XMIECPWorkspace;
import org.unicase.xmi.workspace.XmiUtil;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;

/**
 * Handles the user's choice to resolve the projects inability to load its resources.
 * @author maierma, kraftm
 */
public class DeletedResourceHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {		
		
		final XMIECPFileProject project = ActionHelper.getEventElementByClass(event, XMIECPFileProject.class);
		if (project == null) {
			new XMIWorkspaceException("Event not associated with XMI-Project.");
			return null;
		}
		
		ECPWorkspace workspace = project.getWorkspace();
		XMIECPWorkspace ws;
		if(workspace instanceof XMIECPWorkspace) {
			ws = (XMIECPWorkspace) workspace;
		}
		else {
			return null;
		}
		
		DeletedObjectDialog dialog = new DeletedObjectDialog(project.getProjectStatus(), project.getXmiFilePath());
		Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
		
		switch(dialog.getResult()) {
		case 1: // remove from workspace
			ws.removeProject(project);
			break;
			
		case 2: // import from filesystem
			FileDialog fileDialog = new FileDialog(shell, SWT.OPEN);
			String fsPath = "";
			while(!XmiUtil.validate(fsPath)) {
				fsPath = fileDialog.open();
			}
			project.setXmiFilePath(fsPath);
			project.loadContents();
			break;
		
		case 4: // create new project
			project.setProjectStatus(XmiUtil.PROJECT_STATUS.NOTLOADED);
			project.loadContents(); // automatically creates resource
			break;
		
		case 5: // import from workspace
			String title = "Select a Project File";
			String message = "Please select an XMI file with project contents.";
			
			String wsPath = "";
			IFile[] fileSelection = null;
			while(!XmiUtil.validate(wsPath)) {
				fileSelection = WorkspaceResourceDialog.openFileSelection(shell, title, message,
					false, null, new ArrayList<ViewerFilter>());
				
				if(fileSelection.length > 0) {
					// only choose index 0 -> multiple = false
					wsPath = fileSelection[0].getLocation().toOSString();
					project.setXmiFilePath(wsPath);
					project.loadContents();
				}
			}
			
			break;
		
		default: // cancel dialog
			break;
		}
		
		TreeView.getTreeViewer().refresh();
			
		return null;
	}
}

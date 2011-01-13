package org.unicase.xmi.views;

import java.io.File;

import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.unicase.xmi.commands.NewProjectHandler;

public class CreateProjectDialog extends XMIDialog {

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent shell
	 * @param handler
	 *            the NewProjectHandler calling this dialog
	 */
	public CreateProjectDialog(Shell parent, NewProjectHandler handler) {
		super(parent, "Create New Project", "Please enter the name, the location and a description of the project.");
		setHandler(handler);
	}

	protected SelectionListener getBrowseFilesystemListener() {
		return new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				/**
				 * Folder where to save the file
				 */
				DirectoryDialog dirDialog = new DirectoryDialog(shell, SWT.OPEN);
				
				String path = dirDialog.open();
				if(path == null) {
					path = DEFAULT_LOCATION;
				}
				
				if(txtProjectName.getText() == null || txtProjectName.getText() == "") {
					path += File.separator + "newproject.ucw";
				}
				else {
					path += File.separator + txtProjectName.getText() + ".ucw";
				}
				txtProjectLocation.setText(path);
			}

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}
			
		};
	} // END method

	@Override
	protected SelectionListener getBrowseWorkspaceListener() {
		return new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {		
				// opens up a new dialog to browse the "eclipse" workspace
				WorkspaceResourceDialog workspaceDialog = new WorkspaceResourceDialog(shell, new WorkbenchLabelProvider(), new WorkbenchContentProvider());
				workspaceDialog.setAllowMultiple(false);
				workspaceDialog.setTitle("Select a folder");
				workspaceDialog.setMessage("Please select a folder where to save the file");
				workspaceDialog.loadContents();
				int dialogRes = workspaceDialog.open();
								
				//TODO continue... implemenet Browse Workspace for New Project Dialog
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
			
		};
	}

}

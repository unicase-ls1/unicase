package org.unicase.xmi.views;

import java.util.ArrayList;

import org.eclipse.core.resources.IContainer;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
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

	/**
	 * {@inheritDoc}
	 */
	protected SelectionListener getBrowseFilesystemListener() {
		return new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// select the folder where to save the file
				DirectoryDialog dirDialog = new DirectoryDialog(shell, SWT.OPEN);
				
				String path = dirDialog.open();
				txtProjectLocation.setText(getResourceLocation(txtProjectName.getText(), path));
			}

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}
			
		};
	}

	@Override
	protected SelectionListener getBrowseWorkspaceListener() {
		return new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {		
				// opens up a new dialog to browse the "eclipse" workspace for folders
				String title = "Select a folder";
				String message = "Please select a folder where to save the file";
				String path = null;
				
				IContainer[] selectedFolders = WorkspaceResourceDialog.openFolderSelection(shell, title, message, false, null, new ArrayList<ViewerFilter>());
				if(selectedFolders.length > 0) {
					// index 0 because multi option is off and it can import only one or no files
					path = selectedFolders[0].getLocation().toOSString(); 
				}
				
				txtProjectLocation.setText(getResourceLocation(txtProjectName.getText(), path));
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
			
		};
	}

}

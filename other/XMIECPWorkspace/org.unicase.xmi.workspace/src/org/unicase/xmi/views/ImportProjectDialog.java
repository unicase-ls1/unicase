/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.views;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.unicase.xmi.commands.ImportProjectHandler;

/**
 * Dialog that will be shown when the user wants to import a new project.
 * @author matti, markus
 *
 */
public class ImportProjectDialog extends XMIDialog {
	
	/**
	 * Create a dialog to import a file from the workspace or filesystem.
	 * @param parent Shell where the dialog will be created in.
	 * @param handler Handler which invokes the dialog and who will receive the result upon completion.
	 */
	public ImportProjectDialog(Shell parent, ImportProjectHandler handler) {
		super(parent, "Import Project", "Please enter the name of your project-file and its location.");
		setHandler(handler);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SelectionListener getBrowseFilesystemListener() {
		return new SelectionListener() {
		
			public void widgetDefaultSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(shell, SWT.OPEN);
				String path = dialog.open();
				txtProjectLocation.setText(getResourceLocation(txtProjectName.getText(), path));
			}

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}
			
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SelectionListener getBrowseWorkspaceListener() {
		return new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// opens up a new dialog to browse the "eclipse" workspace
				WorkspaceResourceDialog workspaceDialog = new WorkspaceResourceDialog(shell, new WorkbenchLabelProvider(), new WorkbenchContentProvider());
				workspaceDialog.setAllowMultiple(false);
				workspaceDialog.setTitle("Select a Project File");
				workspaceDialog.setMessage("Please select an XMI file with project contents.");
				workspaceDialog.loadContents();
				int dialogRes = workspaceDialog.open();
				
				// dialog results
				String fileName = null;
				if(dialogRes == WorkspaceResourceDialog.OK) {
					IFile[] selectedFiles = workspaceDialog.getSelectedFiles();
					if(selectedFiles.length != 0) {
						fileName = selectedFiles[0].getLocation().toOSString(); // index 0 because multi option is off and it can import only one or no files 
					}
				}
				
				// set the textfield to a fitting project name
				txtProjectLocation.setText(getResourceLocation(txtProjectName.getText(), fileName));
			}

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}
			
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addInputListener() {
		// do nothing, because listener is not needed in this case
	}
}

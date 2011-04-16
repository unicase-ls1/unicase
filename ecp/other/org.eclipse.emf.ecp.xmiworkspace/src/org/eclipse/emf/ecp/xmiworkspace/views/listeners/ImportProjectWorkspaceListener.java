/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.ecp.xmiworkspace.views.listeners;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.ecp.xmiworkspace.views.XMIDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * Workspace listener for the "browse workspace" button.
 * @author matti, markus
 *
 */
public class ImportProjectWorkspaceListener implements SelectionListener {

	/**
	 * Textfield for the name of the project.
	 */
	private Text txtProjectName;
	
	/**
	 * Textfield for the project's resource location.
	 */
	private Text txtProjectLocation;
	
	/**
	 * Shell for dialogs.
	 */
	private Shell shell;
	
	/**
	 * Creates a workspace listener for the "browse workspace" button.
	 * @param txtProjectName Textfield of the project's name.
	 * @param txtProjectLocation Textfield of the project's resource location.
	 * @param shell Shell for dialogs.
	 */
	public ImportProjectWorkspaceListener(Text txtProjectName,
			Text txtProjectLocation, Shell shell) {
		this.txtProjectName = txtProjectName;
		this.txtProjectLocation = txtProjectLocation;
		this.shell = shell;
	}

	/**
	 * {@inheritDoc}
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		// opens up a new dialog to browse the "eclipse" workspace
		WorkspaceResourceDialog workspaceDialog = new WorkspaceResourceDialog(shell,
				new WorkbenchLabelProvider(), new WorkbenchContentProvider());
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
				// index 0 because multi option is off and it can import only one or no files
				fileName = selectedFiles[0].getLocation().toOSString(); 
			}
		}
		
		// set the textfield to a fitting project name
		txtProjectLocation.setText(XMIDialog.getResourceLocation(txtProjectName.getText(), fileName));
	}

	/**
	 * {@inheritDoc}
	 */
	public void widgetSelected(SelectionEvent e) {
		widgetDefaultSelected(e);
	}

}

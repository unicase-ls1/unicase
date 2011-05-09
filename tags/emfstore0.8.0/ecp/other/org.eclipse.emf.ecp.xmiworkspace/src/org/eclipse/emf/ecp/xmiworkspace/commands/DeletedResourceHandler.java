/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.ecp.xmiworkspace.commands;

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.ecp.common.util.UiUtil;
import org.eclipse.emf.ecp.xmiworkspace.XmiUtil;
import org.eclipse.emf.ecp.xmiworkspace.exceptions.XMIWorkspaceException;
import org.eclipse.emf.ecp.xmiworkspace.structure.XMIECPFileProject;
import org.eclipse.emf.ecp.xmiworkspace.views.DeletedObjectDialog;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * Handles the user's choice to resolve the projects inability to load its
 * resources.
 * 
 * @author maierma, kraftm
 */
public class DeletedResourceHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final XMIECPFileProject project = UiUtil.getEventElementByClass(event,
				XMIECPFileProject.class);
		if (project == null) {
			new XMIWorkspaceException("Event not associated with XMI-Project.");
			return null;
		}

		ECPWorkspace workspace = project.getWorkspace();
		if (workspace == null) {
			return null;
		}
		DeletedObjectDialog dialog = new DeletedObjectDialog(
				project.getProjectStatus(), project.getXmiFilePath());
		Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();

		switch (dialog.getResult()) {
		case 1: // remove from workspace
			workspace.getProjects().remove(project);
			break;

		case 2: // import from filesystem
			FileDialog fileDialog = new FileDialog(shell, SWT.OPEN);
			String fsPath = "";
			while (!XmiUtil.validate(fsPath)) {
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
			while (!XmiUtil.validate(wsPath)) {
				fileSelection = WorkspaceResourceDialog.openFileSelection(
						shell, title, message, false, null,
						new ArrayList<ViewerFilter>());

				if (fileSelection.length > 0) {
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

		return null;
	}
}

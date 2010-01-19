/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.meeditor.MEEditorInput;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Handler for delete project menu item.
 * 
 * @author koegel
 */
public class DeleteProjectHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ProjectSpace projectSpace = ActionHelper.getProjectSpace(event);
		if (projectSpace == null) {
			return null;
		}
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				deleteProjectSpace(projectSpace);
			}
		}.run();
		return null;
	}

	private void deleteProjectSpace(final ProjectSpace projectSpace) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Do you really want to delete your local copy of project \"");
		stringBuilder.append(projectSpace.getProjectName());
		stringBuilder.append("\"");
		if (projectSpace.getBaseVersion() != null) {
			stringBuilder.append(" in version ");
			stringBuilder.append(projectSpace.getBaseVersion().getIdentifier());
		}
		stringBuilder.append("?");
		String message = stringBuilder.toString();

		MessageDialog dialog = new MessageDialog(null, "Confirmation", null, message, MessageDialog.QUESTION,
			new String[] { "Yes", "No" }, 0);
		int result = dialog.open();
		if (result == 0) {

			Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();

			// close all open editors before deleting
			IWorkbenchPage wbpage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IEditorReference[] editors = wbpage.getEditorReferences();
			for (IEditorReference editorReference : editors) {
				try {
					if (editorReference.getEditorInput() instanceof MEEditorInput) {
						MEEditorInput editorInput = (MEEditorInput) editorReference.getEditorInput();
						if (projectSpace.getProject().equals(editorInput.getModelElement().getProject())) {
							// don't ask for saving, because we delete the
							// project anyways
							wbpage.closeEditor(editorReference.getEditor(false), false);
						}
					}
					// TODO: AS: add delete project observer / ext.point

					// if (editorReference.getEditorInput() instanceof
					// DashboardEditorInput) {
					// DashboardEditorInput editorInput = (DashboardEditorInput)
					// editorReference
					// .getEditorInput();
					// if (projectSpace.equals(editorInput.getProjectSpace())) {
					// wbpage.closeEditor(
					// editorReference.getEditor(false), false);
					// }
					// }
				} catch (PartInitException e) {
					// Just print the stacktrace
					e.printStackTrace();
				}
			}

			try {
				currentWorkspace.deleteProjectSpace(projectSpace);
			} catch (IOException e) {
				DialogHandler.showExceptionDialog("Couldn't delete project files in file system.", e);
			}

		}
	}
}

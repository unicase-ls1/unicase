/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.util.UnicaseCommandWithResult;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.util.ActionHelper;
import org.unicase.ui.util.DialogHandler;

// MK: document whats this exactly does
/**
 * @author helming
 * @author shterev
 */
public class RevertHandler extends AbstractHandler {
	/**
	 * Command to revert a project.
	 * 
	 * @author helming
	 */
	private final class RevertCommand extends UnicaseCommandWithResult<Boolean> {
		private final ProgressMonitorDialog progressDialog;
		private final ProjectSpace projectSpace;

		private RevertCommand(ProgressMonitorDialog progressDialog, ProjectSpace projectSpace) {
			this.progressDialog = progressDialog;
			this.projectSpace = projectSpace;
		}

		@Override
		protected Boolean doRun() {
			Boolean resultValue = false;
			MessageDialog dialog = new MessageDialog(null, "Confirmation", null,
				"Do you really want to revert all your changes on project " + projectSpace.getProjectName(),
				MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
			int result = dialog.open();
			if (result == Window.OK) {
				progressDialog.open();
				progressDialog.getProgressMonitor().beginTask("Revert project...", 100);
				progressDialog.getProgressMonitor().worked(10);
				// BEGIN SUPRESS CATCH EXCEPTION
				try {
					projectSpace.revert();
					resultValue = true;
				} catch (RuntimeException e) {
					DialogHandler.showExceptionDialog(e);
					WorkspaceUtil.logWarning("RuntimeException in " + RevertHandler.class.getName(), e);
				} finally {
					// END SUPRESS CATCH EXCEPTION
					progressDialog.getProgressMonitor().done();
					progressDialog.close();
				}
			}
			return resultValue;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {

		final ProjectSpace projectSpace;
		projectSpace = ActionHelper.getEventElementByClass(event, ProjectSpace.class);

		if (projectSpace == null) {
			DialogHandler.showErrorDialog("No Project selected.");
		}
		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell());
		RevertCommand command = new RevertCommand(progressDialog, projectSpace);

		if (command.run()) {
			MessageDialog.openInformation(null, "Revert", "Reverted project ");
		}
		return null;
	}
}

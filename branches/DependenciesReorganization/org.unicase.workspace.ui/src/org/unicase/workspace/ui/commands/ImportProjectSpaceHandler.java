/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.ui.commands;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.util.DialogHandler;
import org.unicase.ui.util.PreferenceHelper;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Imports a project space to the current workspace.
 * 
 * @author koegel
 */
public class ImportProjectSpaceHandler extends AbstractHandler {

	private static final String IMPORT_PROJECTSPACE_PATH = "org.unicase.workspace.ui.importProjectSpacePath";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), SWT.OPEN);
		dialog.setFilterNames(ImportProjectHandler.FILTER_NAMES);
		dialog.setFilterExtensions(ImportProjectHandler.FILTER_EXTS);
		String initialPath = PreferenceHelper.getPreference(
				IMPORT_PROJECTSPACE_PATH, System.getProperty("user.home"));
		dialog.setFilterPath(initialPath);
		String fn = dialog.open();
		if (fn == null) {
			return null;
		}

		final File file = new File(dialog.getFilterPath(), dialog.getFileName());
		PreferenceHelper.setPreference(IMPORT_PROJECTSPACE_PATH, file
				.getParent());

		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				try {
					progressDialog.open();
					progressDialog.getProgressMonitor().beginTask(
							"Export project...", 100);
					progressDialog.getProgressMonitor().worked(10);
					Workspace currentWorkspace = WorkspaceManager.getInstance()
							.getCurrentWorkspace();
					currentWorkspace.importProjectSpace(file.getAbsolutePath());

				} catch (IOException e) {
					DialogHandler.showExceptionDialog(e);
				} finally {
					progressDialog.getProgressMonitor().done();
					progressDialog.close();
				}
			}
		}.run();

		MessageDialog.openInformation(null, "Import",
				"Imported project space from file: " + file.getAbsolutePath());
		return null;
	}

}

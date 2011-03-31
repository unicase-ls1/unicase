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

import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.UnicaseCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.util.ActionHelper;
import org.unicase.ui.util.DialogHandler;
import org.unicase.ui.util.PreferenceHelper;

/**
 * Exports a project space to a file.
 * 
 * @author helming
 */
public class ExportProjectSpaceHandler extends AbstractHandler {

	/**
	 * These filter names are used to filter which files are displayed.
	 */
	public static final String[] FILTER_NAMES = { "Unicase change package (*.ucc)", "All Files (*.*)" };

	/**
	 * These filter extensions are used to filter which files are displayed.
	 */
	public static final String[] FILTER_EXTS = { "*.ucc", "*.*" };

	private static final String EXPORT_PROJECTSPACE_PATH = "org.eclipse.emf.emfstore.client.ui.exportProjectSpacePath";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ProjectSpace projectSpace = ActionHelper.getEventElementByClass(event, ProjectSpace.class);
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.SAVE);
		dialog.setFilterNames(ExportProjectSpaceHandler.FILTER_NAMES);
		dialog.setFilterExtensions(ExportProjectSpaceHandler.FILTER_EXTS);
		dialog.setOverwrite(true);
		try {
			String initialFilename = "projectspace_" + projectSpace.getProjectName() + "@"
				+ projectSpace.getBaseVersion().getIdentifier() + ".ucc";
			// NPE raised when project is not shared yet, since getBaseVersion
			// needs the project on the server already.
			dialog.setFileName(initialFilename);
			String initialPath = PreferenceHelper.getPreference(EXPORT_PROJECTSPACE_PATH, System
				.getProperty("user.home"));
			dialog.setFilterPath(initialPath);
		} catch (NullPointerException e) {

		}

		String fn = dialog.open();
		if (fn == null) {
			return null;
		}

		final File file = new File(fn);
		PreferenceHelper.setPreference(EXPORT_PROJECTSPACE_PATH, file.getParent());

		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell());

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				try {
					progressDialog.open();
					progressDialog.getProgressMonitor().beginTask("Export projectspace...", 100);
					progressDialog.getProgressMonitor().worked(10);
					// OW: why is the project exported as well? who's idea was
					// that?
					// projectSpace.exportProject(file.getAbsolutePath());
					WorkspaceManager.getInstance().getCurrentWorkspace().exportProjectSpace(projectSpace,
						file.getAbsolutePath());
				} catch (IOException e) {
					DialogHandler.showExceptionDialog(e);
				} finally {
					progressDialog.getProgressMonitor().done();
					progressDialog.close();
				}
			}
		}.run();
		MessageDialog.openInformation(null, "Export", "Exported projectspace to file " + file.getName());
		return null;
	}
}

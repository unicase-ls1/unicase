/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
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
import org.eclipse.emf.ecp.common.util.DialogHandler;
import org.eclipse.emf.ecp.common.util.PreferenceHelper;
import org.eclipse.emf.ecp.common.util.UiUtil;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

/**
 * Handler for export project menu item.
 * 
 * @author koegel
 */
public class ExportProjectHandler extends AbstractHandler {

	private static final String EXPORT_PROJECT_PATH = "org.eclipse.emf.emfstore.client.ui.exportProjectPath";

	/**
	 * These filter names are used to filter which files are displayed.
	 */
	public static final String[] FILTER_NAMES = { "EMFStore Project Files (*.ecp)", "All Files (*.*)" };

	/**
	 * These filter extensions are used to filter which files are displayed.
	 */
	public static final String[] FILTER_EXTS = { "*.ecp", "*.*" };

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final ProjectSpace projectSpace = UiUtil.getEventElementByClass(event, ProjectSpace.class);

		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.SAVE);
		dialog.setFilterNames(ExportProjectHandler.FILTER_NAMES);
		dialog.setFilterExtensions(ExportProjectHandler.FILTER_EXTS);
		dialog.setOverwrite(true);
		try {
			String initialFileName = projectSpace.getProjectName() + "@"
				+ projectSpace.getBaseVersion().getIdentifier() + ".ucp";
			dialog.setFileName(initialFileName);
			String initialPath = PreferenceHelper.getPreference(EXPORT_PROJECT_PATH, System.getProperty("user.home"));
			dialog.setFilterPath(initialPath);
			// NPE raised when project is not shared yet, since getBaseVersion
			// needs the project on the server already.
			// dialog
		} catch (NullPointerException e) {

		}
		String fn = dialog.open();
		if (fn == null) {
			return null;
		}

		final File file = new File(fn);
		PreferenceHelper.setPreference(EXPORT_PROJECT_PATH, file.getParent());

		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell());
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				try {
					progressDialog.open();
					progressDialog.getProgressMonitor().beginTask("Export project...", 100);
					progressDialog.getProgressMonitor().worked(10);
					projectSpace.exportProject(file.getAbsolutePath());
					MessageDialog.openInformation(null, "Export", "Exported project to file " + file.getName());
				} catch (IOException e) {
					DialogHandler.showExceptionDialog(e);
					// BEGIN SUPRESS CATCH EXCEPTION
				} catch (Exception e) {
					DialogHandler.showExceptionDialog(e);
				} finally {
					progressDialog.getProgressMonitor().done();
					progressDialog.close();
				}
				// END SUPRESS CATCH EXCEPTION
			}
		}.run();

		return null;
	}
}

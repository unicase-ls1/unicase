/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.commands;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.ProjectSpace;

/**
 * . ExportChangesHandler
 * 
 * @author Hodaie
 * 
 */
public class ExportChangesHandler extends ProjectActionHandler {

	/**
	 * These filter names are used to filter which files are displayed.
	 */
	public static final String[] FILTER_NAMES = {
			"Unicase change package (*.ucc)", "All Files (*.*)" };

	/**
	 * These filter extensions are used to filter which files are displayed.
	 */
	public static final String[] FILTER_EXTS = { "*.ucc", "*.*" };

	/**
	 * . {@inheritDoc}
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), SWT.SAVE);
		dialog.setFilterNames(ExportChangesHandler.FILTER_NAMES);
		dialog.setFilterExtensions(ExportChangesHandler.FILTER_EXTS);
		dialog.setOverwrite(true);
		String fn = dialog.open();
		if (fn == null) {
			return null;
		}

		String fileName = dialog.getFileName();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(dialog.getFilterPath());
		if (fileName.charAt(fileName.length() - 1) != File.separatorChar) {
			stringBuilder.append(File.separatorChar);
		}
		stringBuilder.append(fileName);
		final String absoluteFileName = stringBuilder.toString();
		final ProjectSpace projectSpace = this.getProjectSpace(event);
		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			       .getActiveWorkbenchWindow().getShell());

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				try {
					progressDialog.open();
					progressDialog.getProgressMonitor().beginTask("Export changs...", 100);
					progressDialog.getProgressMonitor().worked(10);
                    projectSpace.exportLocalChanges(absoluteFileName);
				} catch (IOException e) {
					DialogHandler.showExceptionDialog(e);
					// BEGIN SUPRESS CATCH EXCEPTION
				} catch (Exception e) {
					DialogHandler.showExceptionDialog(e);
				}
				finally {
					progressDialog.getProgressMonitor().done();
					progressDialog.close();
				}
				// END SUPRESS CATCH EXCEPTION
			}
		});
		MessageDialog.openInformation(null, "Export",
				"Exported changes to file " + fileName);
		return null;
	}

}

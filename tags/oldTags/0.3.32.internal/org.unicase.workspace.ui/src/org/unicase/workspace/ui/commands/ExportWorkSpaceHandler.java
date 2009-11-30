/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
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
import org.unicase.workspace.WorkspaceManager;

/**
 * Exports the current workspace.
 * 
 * @author helming
 */
public class ExportWorkSpaceHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.SAVE);
		dialog.setFilterNames(ExportChangesHandler.FILTER_NAMES);
		dialog.setFilterExtensions(ExportChangesHandler.FILTER_EXTS);
		dialog.setOverwrite(true);
		String fn = dialog.open();
		if (fn == null) {
			return null;
		}

		final String absoluteFileName = fn;
		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell());

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				try {
					progressDialog.open();
					progressDialog.getProgressMonitor().beginTask("Export workspace...", 100);
					progressDialog.getProgressMonitor().worked(10);
					WorkspaceManager.getInstance().getCurrentWorkspace().exportWorkSpace(absoluteFileName);
				} catch (IOException e) {
					DialogHandler.showExceptionDialog(e);
				} finally {
					progressDialog.getProgressMonitor().done();
					progressDialog.close();
				}
			}
		});
		MessageDialog.openInformation(null, "Export", "Exported workspace to file " + absoluteFileName);
		return null;
	}

}

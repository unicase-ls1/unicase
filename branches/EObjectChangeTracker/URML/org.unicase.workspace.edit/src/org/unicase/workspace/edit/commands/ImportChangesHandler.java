/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.commands;

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
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;

/**
 * . ImportChangesHandler
 * 
 * @author Hodaie
 */
public class ImportChangesHandler extends AbstractHandler {

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
		dialog.setFilterNames(ExportChangesHandler.FILTER_NAMES);
		dialog.setFilterExtensions(ExportChangesHandler.FILTER_EXTS);
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
		final ProjectSpace projectSpace = ActionHelper.getProjectSpace(event);
		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell());

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				try {
					progressDialog.open();
					progressDialog.getProgressMonitor().beginTask("Import changes...", 100);
					progressDialog.getProgressMonitor().worked(10);
					projectSpace.importLocalChanges(absoluteFileName);
				} catch (IOException e) {
					DialogHandler.showExceptionDialog(e);
				} finally {
					progressDialog.getProgressMonitor().done();
					progressDialog.close();
				}

			}
		});
		MessageDialog.openInformation(null, "Import", "Imported changes from file " + absoluteFileName);
		return null;
	}

}

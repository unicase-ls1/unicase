package org.unicase.workspace.edit.commands;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.common.exceptions.ExceptionDialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

public class ImportProjectHandler extends ProjectActionHandler {

	public static final String[] FILTER_NAMES = {
			"Unicase Project Files (*.ucp)", "All Files (*.*)" };

	// These filter extensions are used to filter which files are displayed.
	public static final String[] FILTER_EXTS = { "*.ucp", "*.*" };

	public Object execute(ExecutionEvent event) throws ExecutionException {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), SWT.OPEN);
		dialog.setFilterNames(ImportProjectHandler.FILTER_NAMES);
		dialog.setFilterExtensions(ImportProjectHandler.FILTER_EXTS);
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

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				try {
					Workspace currentWorkspace = WorkspaceManager.getInstance()
							.getCurrentWorkspace();
					ProjectSpace projectSpace = currentWorkspace
							.importProject(absoluteFileName);
	
				} catch (IOException e) {
					ExceptionDialogHandler.showExceptionDialog(e);
				}
				catch (RuntimeException e) {
					ExceptionDialogHandler.showExceptionDialog(e);
					throw e;
				}
			}
		});

		MessageDialog.openInformation(null, "Import",
				"Imported project from file: " + absoluteFileName);
		return null;
	}

}

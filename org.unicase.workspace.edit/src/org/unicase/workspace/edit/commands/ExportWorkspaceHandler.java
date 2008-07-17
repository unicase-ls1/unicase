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

public class ExportWorkspaceHandler extends ProjectSpaceActionHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), SWT.SAVE);
		dialog.setFilterNames(ImportWorkspaceHandler.FILTER_NAMES);
		dialog.setFilterExtensions(ImportWorkspaceHandler.FILTER_EXTS);
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

		final ProjectSpace projectSpace = getProjectSpace(event);
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				try {
					projectSpace.exportProject(absoluteFileName);
				} catch (IOException e) {
					ExceptionDialogHandler.showExceptionDialog(e);
				}
			}
		});
		MessageDialog.openInformation(null, "Export", "Exported project to file " + fileName);
		return null;
	}

}

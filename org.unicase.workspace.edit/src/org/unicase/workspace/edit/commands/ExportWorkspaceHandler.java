package org.unicase.workspace.edit.commands;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

public class ExportWorkspaceHandler extends AbstractHandler {


	public Object execute(ExecutionEvent event) throws ExecutionException {
		FileDialog dlg = new FileDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), SWT.SAVE);
		dlg.setFilterNames(ImportWorkspaceHandler.FILTER_NAMES);
		dlg.setFilterExtensions(ImportWorkspaceHandler.FILTER_EXTS);
		String fn = dlg.open();
		if (fn != null) {
			// Append all the selected files. Since getFileNames() returns only
			// the names, and not the path, prepend the path, normalizing
			// if necessary
			StringBuffer buf = new StringBuffer();
			String[] files = dlg.getFileNames();
			for (int i = 0, n = files.length; i < n; i++) {
				buf.append(dlg.getFilterPath());
				if (buf.charAt(buf.length() - 1) != File.separatorChar) {
					buf.append(File.separatorChar);
				}
				buf.append(files[i]);
				buf.append(" ");
			}
			//MK: do sth. with the file
			MessageDialog.openInformation(null, "Export", buf.toString());
		}
		return null;
	}

}

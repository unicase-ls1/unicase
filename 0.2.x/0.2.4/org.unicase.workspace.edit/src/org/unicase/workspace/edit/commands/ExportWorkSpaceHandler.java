package org.unicase.workspace.edit.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.workspace.ProjectSpace;

public class ExportWorkSpaceHandler extends ProjectActionHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ProjectSpace projectSpace = getProjectSpace(event);
		MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Export Workspace", "");
		return null;
	}

}

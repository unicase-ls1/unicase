package org.unicase.xmi.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.unicase.xmi.views.CreateFolderDialog;

public class NewFolderHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		CreateFolderDialog dialog = new CreateFolderDialog(PlatformUI
			.getWorkbench().getDisplay().getActiveShell(), null);

		dialog.open();
		return null;
	}

}

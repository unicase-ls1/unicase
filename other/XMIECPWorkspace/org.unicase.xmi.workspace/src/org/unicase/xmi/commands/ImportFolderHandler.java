package org.unicase.xmi.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.unicase.xmi.views.ImportFolderDialog;

public class ImportFolderHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ImportFolderDialog dialog = new ImportFolderDialog(PlatformUI
			.getWorkbench().getDisplay().getActiveShell());

		dialog.open();
		return null;
	}

}

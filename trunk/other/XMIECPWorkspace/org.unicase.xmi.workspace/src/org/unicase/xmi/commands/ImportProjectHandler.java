package org.unicase.xmi.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.unicase.xmi.views.ImportProjectDialog;

public class ImportProjectHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ImportProjectDialog dialog = new ImportProjectDialog(PlatformUI
			.getWorkbench().getDisplay().getActiveShell(), null);

		dialog.open();
		
		return null;
	}

}

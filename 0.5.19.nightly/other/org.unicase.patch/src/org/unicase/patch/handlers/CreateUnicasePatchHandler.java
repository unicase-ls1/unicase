package org.unicase.patch.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;
import org.unicase.patch.adapters.ProjectSelectionDialog;

public class CreateUnicasePatchHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ProjectSelectionDialog dlg = new ProjectSelectionDialog(
				Display.getCurrent().getActiveShell());
		
//		dlg.create();
		dlg.setBlockOnOpen(true);
		dlg.open();
		
		return null;
	}

}

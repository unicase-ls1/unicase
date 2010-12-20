package org.unicase.xmi.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.unicase.xmi.views.CreateProjectDialog;

public class NewProjectHandler extends AbstractHandler {
	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		CreateProjectDialog dialog = new CreateProjectDialog(PlatformUI
			.getWorkbench().getDisplay().getActiveShell(), null);

		dialog.open();
		
		return null;
	}
}

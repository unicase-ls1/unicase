package org.unicase.xmi.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.views.NewProjectDialog;

/**
 * Handler for creating a new project in workspace or filesystem
 * @author kraftm, maierma
 *
 */
public class NewProjectHandler extends XmiAbstractHandler {
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		// open dialog
		Shell activeShell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
		NewProjectDialog dialog = new NewProjectDialog(activeShell, this);

		// open dialog and process the results if the user doesn't cancel the dialog
		if(dialog.open() == Window.OK) {
			try {						
				// run the import process in a command
				buildCommand(ECPWorkspaceManager.getInstance().getWorkSpace()).run(true);
			} catch (Exception e) {
				new XMIWorkspaceException("Could not create new model element.", e);
			}
		}
		
		return null;
	}
}

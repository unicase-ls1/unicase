package org.unicase.model.edit.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ProjectSpace;


/**
 * 
 * @author Hodaie
 *   This handlers handles UpdateWorkspace command.
 *   This command is shown in UC View context menu only for Projects 
 *
 */
public class UpdateWorkspaceHandler extends AbstractHandler  {

	
	/**.
	 * ({@inheritDoc})
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IWorkbenchWindow window = HandlerUtil
				.getActiveWorkbenchWindowChecked(event);

		MessageDialog.openInformation(window.getShell(), null,
				"UpdateWorkspace!");

		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}

		Object o = ssel.getFirstElement();
		if (!(o instanceof ProjectSpace)) {
			return null;
		}

		ProjectSpace projectSpace = (ProjectSpace) o;
		
		//TODO: handle exception
		try {
			projectSpace.update();
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}

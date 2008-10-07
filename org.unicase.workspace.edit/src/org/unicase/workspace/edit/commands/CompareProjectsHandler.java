package org.unicase.workspace.edit.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.edit.dialogs.CompareProjectsDialog;

public class CompareProjectsHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		//show compare dialog
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		ProjectSpace projSpace = (ProjectSpace)((StructuredSelection)sel).getFirstElement();
		
		CompareProjectsDialog compareDialog = new CompareProjectsDialog(HandlerUtil.getActiveShell(event), projSpace);
		compareDialog.create();
		compareDialog.open();
		return null;
	}

}

package org.unicase.workspace.edit.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.workspace.ProjectSpace;

public abstract class ProjectActionHandler extends AbstractHandler {

	public ProjectActionHandler() {
		super();
	}

	/**
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	protected ProjectSpace getProjectSpace(ExecutionEvent event) throws ExecutionException {
	
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}
	
		IStructuredSelection structuredSelection = (IStructuredSelection) sel;
		if (structuredSelection.isEmpty()) {
			return null;
		}
	
		Object selectedElement = structuredSelection.getFirstElement();
		if (!(selectedElement instanceof ProjectSpace)) {
			return null;
		}
		return (ProjectSpace) selectedElement;
	}

}
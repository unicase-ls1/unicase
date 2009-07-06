package org.unicase.ui.navigator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.StructuredSelection;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.ui.navigator.TreeView;

/**
 * This is the handler for ShowMEInNavigator command. It shows location of currently open model element or currently
 * selected model element in navigator tree.
 * 
 * @author Hodaie
 */
public class ShowMEInNavigatorHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ModelElement me = ActionHelper.getModelElement(event);
		if (me == null) {
			return null;
		}

		TreeView.getTreeViewer().setSelection(new StructuredSelection(me), true);

		return null;
	}

}

package org.unicase.ui.stem.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.stem.views.statusview.StatusView;

/**
 * This is the handler for ShowInStatusView command.
 * 
 * @author Hodaie
 */
public class ShowInStausViewHandler extends AbstractHandler {

	private static final String STATUS_VIEW_ID = "org.unicase.ui.treeview.views.StatusView";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		ModelElement me = ActionHelper.getModelElement(event);

		try {
			StatusView statusView = (StatusView) page.showView(STATUS_VIEW_ID, me.getName(),
				IWorkbenchPage.VIEW_ACTIVATE);

			statusView.setInput(me);

		} catch (PartInitException e) {
			DialogHandler.showExceptionDialog(e);
		}

		return null;
	}
}

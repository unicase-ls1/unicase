package org.unicase.urml.ui.hypergraph;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.unicasecommon.UnicaseActionHelper;

public class ShowHypergraphViewHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		UrmlModelElement urmlModelElement = (UrmlModelElement) UnicaseActionHelper.getModelElement(event);

		try {
			HypergraphView hypergraphView = (HypergraphView) page.showView(HypergraphView.ID);
			hypergraphView.setInput(urmlModelElement);

		} catch (PartInitException e) {
			DialogHandler.showExceptionDialog(e);
		}

		return null;
	}
}

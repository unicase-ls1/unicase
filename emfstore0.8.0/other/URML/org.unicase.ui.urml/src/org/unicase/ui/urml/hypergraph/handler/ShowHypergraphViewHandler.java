package org.unicase.ui.urml.hypergraph.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ui.urml.hypergraph.HypergraphView;
import org.unicase.ui.util.DialogHandler;

/**
 * Extract the selected element and open the hypergraph view with that element as selected object.
 * 
 * @author Michael Haeger
 */
public class ShowHypergraphViewHandler extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		try {
			HypergraphView hypergraphView = (HypergraphView) page.showView(HypergraphView.ID);
			hypergraphView.setInput(selection);
		} catch (PartInitException e) {
			DialogHandler.showExceptionDialog(e);
		}
		return null;
	}
}

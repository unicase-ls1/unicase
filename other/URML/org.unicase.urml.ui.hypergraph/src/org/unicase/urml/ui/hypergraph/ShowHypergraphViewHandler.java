package org.unicase.urml.ui.hypergraph;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.provider.DelegatingWrapperItemProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ui.common.exceptions.DialogHandler;

public class ShowHypergraphViewHandler extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		Object element = null;
		if (selection instanceof IStructuredSelection) {
			element = ((IStructuredSelection) selection).getFirstElement();
			if (element instanceof EditPart) {
				element = ((View) ((EditPart) element).getModel()).getElement();
			} else if (element instanceof DelegatingWrapperItemProvider) {
				element = ((DelegatingWrapperItemProvider) element).getValue();
			}
		} else {
			return null;
		}
		try {
			HypergraphView hypergraphView = (HypergraphView) page.showView(HypergraphView.ID);
			hypergraphView.setInput(element);
		} catch (PartInitException e) {
			DialogHandler.showExceptionDialog(e);
		}
		return null;
	}
}

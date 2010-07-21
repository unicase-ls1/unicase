package org.unicase.urml.ui.hypergraph;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.ui.common.exceptions.DialogHandler;

public class ShowHypergraphViewAction implements IObjectActionDelegate {

	private EditPart selectedElement;

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// nothing
	}

	public void run(IAction action) {
		if (this.selectedElement != null) {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			UrmlModelElement urmlModelElement = (UrmlModelElement) ((View) selectedElement.getModel()).getElement();
			try {
				HypergraphView hypergraphView = (HypergraphView) page.showView(HypergraphView.ID);
				hypergraphView.setInput(urmlModelElement);

			} catch (PartInitException e) {
				DialogHandler.showExceptionDialog(e);
			}
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		selectedElement = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof EditPart) {
				selectedElement = (EditPart) structuredSelection.getFirstElement();
			}
		}
	}
}

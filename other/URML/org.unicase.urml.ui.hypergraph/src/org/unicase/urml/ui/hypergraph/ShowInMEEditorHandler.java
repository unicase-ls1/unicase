package org.unicase.urml.ui.hypergraph;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.navigatormeeditorbridge.ModelElementOpener;

public class ShowInMEEditorHandler extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		if (selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
			selectedElement = ((GraphEObjectLayouted) selectedElement).object;
			EObject element = null;
			if (selectedElement instanceof EditPart) {
				element = ((View) ((EditPart) selectedElement).getModel()).getElement();
			} else if (selectedElement instanceof EObject) {
				element = (EObject) selectedElement;
			}
			if (element instanceof MEDiagram) {
				new ModelElementOpener().openModelElement(element);
			} else {
				ActionHelper.openModelElement(element, HypergraphView.ID);
			}
		}
		return null;
	}
}

package org.unicase.ui.urml.hypergraph.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ui.navigatormeeditorbridge.ModelElementOpener;
import org.unicase.ui.urml.hypergraph.layout.GraphEObjectLayouted;

/**
 * Open the selected element in MEEditor.
 * 
 * @author Michael Haeger
 */
public class ShowInMEEditorHandler extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		if (selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
			EObject element = ((GraphEObjectLayouted) selectedElement).object;
			new ModelElementOpener().openModelElement(element);
		}
		return null;
	}
}

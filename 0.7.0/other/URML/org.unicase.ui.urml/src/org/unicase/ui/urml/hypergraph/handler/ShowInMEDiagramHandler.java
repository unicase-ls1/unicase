package org.unicase.ui.urml.hypergraph.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.urml.hypergraph.HypergraphView;
import org.unicase.ui.urml.hypergraph.layout.GraphEObjectLayouted;

/**
 * Open all diagrams in which the selected element takes part.
 * 
 * @author Michael Haeger
 */
public class ShowInMEDiagramHandler extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		if (selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
			for (MEDiagram diagram : ((GraphEObjectLayouted) selectedElement).diagrams) {
				ActionHelper.openModelElement(diagram, HypergraphView.ID);
			}
		}
		return null;
	}
}

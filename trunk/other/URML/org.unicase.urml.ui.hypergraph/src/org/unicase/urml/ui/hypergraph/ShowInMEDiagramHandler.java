package org.unicase.urml.ui.hypergraph;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.util.ActionHelper;

public class ShowInMEDiagramHandler extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		HypergraphView view = (HypergraphView) HandlerUtil.getActivePart(event);
		// TODO : extract graph from event
		Graph graph = view.getGraphViewer().getGraphControl();
		for (Object selectedElement : graph.getSelection()) {
			if (selectedElement instanceof GraphNode) {
				for (Object connection : ((GraphNode) selectedElement).getSourceConnections()) {
					Object element = ((GraphConnection) connection).getSource().getData();
					element = ((GraphEObjectLayouted) element).object;
					if (element instanceof MEDiagram) {
						ActionHelper.openModelElement((MEDiagram) element, HypergraphView.ID);
					}
				}
				for (Object connection : ((GraphNode) selectedElement).getTargetConnections()) {
					Object element = ((GraphConnection) connection).getSource().getData();
					element = ((GraphEObjectLayouted) element).object;
					if (element instanceof MEDiagram) {
						ActionHelper.openModelElement((MEDiagram) element, HypergraphView.ID);
					}
				}
			}
		}
		return null;
	}
}

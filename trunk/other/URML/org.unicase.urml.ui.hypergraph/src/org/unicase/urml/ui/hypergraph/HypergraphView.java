package org.unicase.urml.ui.hypergraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.edit.provider.DelegatingWrapperItemProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.urml.UrmlModelElement;

public class HypergraphView extends ViewPart implements ISelectionListener {

	public static final String ID = "org.unicase.urml.ui.hypergraph.HypergraphView";

	// private Label label;
	private Action autoRefresh;
	private Graph g;

	public HypergraphView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		// label = new Label(parent, 0);

		g = new Graph(parent, SWT.NONE);
		g.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);

		autoRefresh = new Action("Auto Refresh", IAction.AS_CHECK_BOX) {
			@Override
			public void run() {
				// nothing
			}
		};
		autoRefresh.setText("Auto Refresh");
		autoRefresh.setToolTipText("Auto refresh graph on item selection");
		autoRefresh.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
			ISharedImages.IMG_OBJS_INFO_TSK));
		IActionBars bars = getViewSite().getActionBars();
		bars.getToolBarManager().add(autoRefresh);
		getViewSite().getPage().addSelectionListener(this);
	}

	@Override
	public void setFocus() {
		// label.setFocus();
		g.setFocus();
	}

	public void setInput(UrmlModelElement element) {
		// label.setText(urmlModelElement.getName());
		List delNodes = g.getNodes();
		int s = delNodes.size();
		for (int i = s - 1; i >= 0; i--) {
			((GraphNode) delNodes.get(i)).dispose();
		}
		connections = new HashMap<UrmlModelElement, List<UrmlModelElement>>();
		nodes = new HashMap<UrmlModelElement, GraphNode>();
		buildGraph(element);
		g.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
	}

	private HashMap<UrmlModelElement, List<UrmlModelElement>> connections;
	private HashMap<UrmlModelElement, GraphNode> nodes;

	private GraphNode buildGraph(UrmlModelElement element) {
		GraphNode n1 = new GraphNode(g, SWT.NONE, element.getName());
		connections.put(element, new LinkedList<UrmlModelElement>());
		nodes.put(element, n1);
		for (ModelElement tmp : element.getLinkedModelElements()) {
			if (tmp instanceof UrmlModelElement) {
				if (connections.containsKey(tmp)) {
					if(!connections.get(tmp).contains(element)) {
						new GraphConnection(g, SWT.NONE, n1, nodes.get(tmp));
						connections.get(element).add((UrmlModelElement) tmp);
					}
				}
				else {
					GraphNode n2 = buildGraph((UrmlModelElement) tmp);
					new GraphConnection(g, SWT.NONE, n1, n2);
					connections.get(element).add((UrmlModelElement) tmp);
				}
			}
		}
		return n1;
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (autoRefresh.isChecked()) {
			if (selection instanceof IStructuredSelection) {
				Object element = ((IStructuredSelection) selection).getFirstElement();
				if (element instanceof EditPart) {
					element = ((View) ((EditPart) element).getModel()).getElement();
				} else if (element instanceof DelegatingWrapperItemProvider) {
					element = ((DelegatingWrapperItemProvider) element).getValue();
				}
				if (element instanceof UrmlModelElement) {
					setInput((UrmlModelElement) element);
				}
			}
		}
	}
}
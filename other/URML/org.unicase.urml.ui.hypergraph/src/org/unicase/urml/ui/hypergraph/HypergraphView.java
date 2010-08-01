package org.unicase.urml.ui.hypergraph;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.DelegatingWrapperItemProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.layouts.LayoutStyles;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.ProjectSpace;

public class HypergraphView extends ViewPart implements ISelectionListener {
	public static final int MAX_DEPTH = 3;

	public static final String ID = "org.unicase.urml.ui.hypergraph.HypergraphView";

	// private Label label;
	private Action autoRefresh;
	private GraphViewer graph;
	public EObject selectedItem;

	public HypergraphView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		graph = new GraphViewer(parent, SWT.NONE);
		graph.setContentProvider(new UnicaseEntityContentProvider());
		graph.setLabelProvider(UnicaseLabelProvider.getInstance());
		graph.setLayoutAlgorithm(new UnicaseLayoutAlgorithm(this, LayoutStyles.NONE), true);

		graph.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object element = ((IStructuredSelection) selection).getFirstElement();
					if (element != null) {
						setInput(element);
					}
				}
			}
		});

		MenuManager menuMgr = new MenuManager();
		menuMgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		getSite().registerContextMenu(menuMgr, graph);
		Control control = graph.getControl();
		Menu menu = menuMgr.createContextMenu(control);
		control.setMenu(menu);

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
	}

	public void setInput(Object element) {
		if (element instanceof ProjectSpace) {
			element = ((ProjectSpace) element).getProject();
		}
		if (element instanceof EObject) {
			selectedItem = (EObject) element;
			graph.setInput(recAddModelElement((EObject) element, 0, null));
		}
	}

	private LinkedList<Object> recAddModelElement(EObject element, int depth, Object from) {
		LinkedList<Object> input = new LinkedList<Object>();
		if (depth < MAX_DEPTH) {
			input.add(element);
			for (EObject child : element.eContents()) {
				if (!child.equals(from)) {
					input.addAll(recAddModelElement(child, depth + 1, element));
				}
			}
			EObject parent = element.eContainer();
			if (parent == null && element instanceof ModelElement) {
				parent = ((ModelElement) element).getProject();
			}
			if (parent != null && !(parent instanceof ProjectSpace) && (from == null || !from.equals(parent))) {
				input.addAll(recAddModelElement(parent, depth + 1, element));
			}
		}
		return input;
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
				if (element != null) {
					setInput(element);
				}
			}
		}
	}

	public GraphViewer getGraphViewer() {
		return graph;
	}
}
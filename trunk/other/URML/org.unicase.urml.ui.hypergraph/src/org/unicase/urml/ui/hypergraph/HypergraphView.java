package org.unicase.urml.ui.hypergraph;

import java.util.LinkedList;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.DelegatingWrapperItemProvider;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
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
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ExpandEvent;
import org.eclipse.swt.events.ExpandListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.layouts.LayoutStyles;
import org.unicase.ui.navigator.NoWorkspaceException;
import org.unicase.ui.navigator.WorkspaceManager;
import org.unicase.ui.navigator.workSpaceModel.ECPProject;
import org.unicase.workspace.ProjectSpace;

public class HypergraphView extends ViewPart implements ISelectionListener {
	public static final int MAX_DEPTH = 3;

	public static final String ID = "org.unicase.urml.ui.hypergraph.HypergraphView";

	// private Label label;
	private Action autoRefresh;
	private GraphViewer graph;
	private Composite composite;
	private GraphEClassFilter nodeFilter;
	private GraphEReferenceFilter edgeFilter;
	private UnicaseEntityContentProvider contentProvider;
	private DropTarget dropTarget;

	public HypergraphView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		getViewSite().getPage().addSelectionListener(this);
		composite = new Composite(parent, SWT.NONE);
		graph = new GraphViewer(composite, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		composite.setLayout(layout);
		try {
			nodeFilter = new GraphEClassFilter(WorkspaceManager.getInstance().getWorkSpace().getProjects(), graph);
		} catch (NoWorkspaceException e) {
			nodeFilter = new GraphEClassFilter(new LinkedList<ECPProject>(), graph);
		}
		edgeFilter = new GraphEReferenceFilter(graph);
		graph.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contentProvider = new UnicaseEntityContentProvider(nodeFilter, edgeFilter);
		graph.setContentProvider(contentProvider);
		graph.setLabelProvider(new UnicaseLabelProvider());
		graph.setLayoutAlgorithm(new UnicaseLayoutProvider(LayoutStyles.NONE), true);

		// Double click navigation
		graph.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object element = ((IStructuredSelection) selection).getFirstElement();
					if (element != null) {
						setInput(((GraphEObjectLayouted) element).object);
					}
				}
			}
		});

		// Mouse gestures
		((Graph) graph.getControl()).setScrollBarVisibility(FigureCanvas.NEVER);
		Listener listener = new Listener() {
			private boolean pressed = false;
			private int pressedX, pressedY;

			public void handleEvent(Event event) {
				if (event.type == SWT.MouseDown) {
					pressed = true;
					pressedX = event.x;
					pressedY = event.y;
				} else if (event.type == SWT.MouseMove) {
					if (pressed) {
						int deltaX = pressedX - event.x;
						int deltaY = pressedY - event.y;
						Graph graph = (Graph) HypergraphView.this.graph.getControl();
						graph.scrollTo(deltaX, deltaY);
					}
				} else if (event.type == SWT.MouseUp) {
					pressed = false;
				}
			}
		};
		graph.getControl().addListener(SWT.MouseDown, listener);
		graph.getControl().addListener(SWT.MouseUp, listener);
		graph.getControl().addListener(SWT.MouseMove, listener);

		// DND
		dropTarget = new DropTarget(composite, SWT.NONE);
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		dropTarget.setTransfer(transfers);
		dropTarget.addDropListener(new DropTargetAdapter() {
			@Override
			public void drop(DropTargetEvent event) {
				if (event.data instanceof IStructuredSelection) {
					Object element = ((IStructuredSelection) event.data).getFirstElement();
					if (element instanceof EditPart) {
						element = ((View) ((EditPart) element).getModel()).getElement();
					}
					if (element instanceof EObject) {
						setInput(element);
					}
				}
			};
		});

		// PopUp menu for graph
		MenuManager menuMgr = new MenuManager();
		menuMgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		getSite().registerContextMenu(menuMgr, graph);
		Control control = graph.getControl();
		Menu menu = menuMgr.createContextMenu(control);
		control.setMenu(menu);

		// Refresh button
		autoRefresh = new Action("Auto Refresh", IAction.AS_CHECK_BOX) {
			@Override
			public void run() {
				// nothing
			}
		};
		autoRefresh.setText("Auto Refresh");
		autoRefresh.setToolTipText("Auto refresh graph on item selection");
		autoRefresh.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
			ISharedImages.IMG_ELCL_SYNCED));
		IActionBars bars = getViewSite().getActionBars();
		bars.getToolBarManager().add(autoRefresh);

		// ExpandBar for options
		final ExpandBar optionBar = new ExpandBar(composite, SWT.NONE);
		GridData gridData = new GridData(SWT.CENTER, SWT.FILL, false, true);
		gridData.widthHint = 200;
		optionBar.setLayoutData(gridData);
		optionBar.addExpandListener(new ExpandListener() {
			public void itemExpanded(ExpandEvent e) {
				// ExpandBar bar = (ExpandBar) e.widget;
				// ExpandItem selectedItem = (ExpandItem) e.item;
				// int heightPerItem = bar.getSize().y / bar.getItemCount();
			}

			public void itemCollapsed(ExpandEvent e) {
			}
		});
		Composite edgeOptCont = new Composite(optionBar, SWT.NONE);
		edgeOptCont.setLayout(new FillLayout());
		Table edgeTable = new Table(edgeOptCont, SWT.CHECK | SWT.NO_SCROLL | SWT.V_SCROLL);
		edgeFilter.addTableItems(edgeTable);
		Composite nodeOptCont = new Composite(optionBar, SWT.NONE);
		nodeOptCont.setLayout(new FillLayout());
		Table nodeTable = new Table(nodeOptCont, SWT.CHECK | SWT.NO_SCROLL | SWT.V_SCROLL);
		nodeFilter.addTableItems(nodeTable);
		ExpandItem edgeOptItem = new ExpandItem(optionBar, SWT.NONE);
		ExpandItem nodeOptItem = new ExpandItem(optionBar, SWT.NONE);
		edgeOptItem.setText("References");
		edgeOptItem.setControl(edgeOptCont);
		edgeOptItem.setHeight(200);
		nodeOptItem.setText("Elements");
		nodeOptItem.setControl(nodeOptCont);
		nodeOptItem.setHeight(200);
	}

	@Override
	public void dispose() {
		dropTarget.dispose();
		graph.getControl().dispose();
		composite.dispose();
	}

	public void setInput(Object element) {
		if (element instanceof ProjectSpace) {
			element = ((ProjectSpace) element).getProject();
		}
		if (element instanceof EObject) {
			graph.setInput(element);
		}
	}

	// TODO : transfer all logic to setInput
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

	// TODO : remove method
	public GraphViewer getGraphViewer() {
		return graph;
	}

	@Override
	public void setFocus() {
	}
}
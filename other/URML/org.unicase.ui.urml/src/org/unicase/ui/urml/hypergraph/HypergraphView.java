package org.unicase.ui.urml.hypergraph;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.GroupMarker;
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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.layouts.LayoutStyles;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.ui.urml.hypergraph.layout.GraphEClassFilter;
import org.unicase.ui.urml.hypergraph.layout.GraphEObjectLayouted;
import org.unicase.ui.urml.hypergraph.layout.GraphEReferenceFilter;
import org.unicase.ui.urml.hypergraph.provider.UnicaseEntityContentProvider;
import org.unicase.ui.urml.hypergraph.provider.UnicaseLabelProvider;
import org.unicase.ui.urml.hypergraph.provider.UnicaseLayoutProvider;
import org.unicase.workspace.ProjectSpace;

public class HypergraphView extends ViewPart implements ISelectionListener {
	public static final String ID = "org.unicase.ui.urml.hypergraph.HypergraphView";

	private boolean autoRefresh;
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
			// put all model elements of all projects into the filter
			nodeFilter = new GraphEClassFilter(ECPWorkspaceManager.getInstance().getWorkSpace().getProjects(), graph);
		} catch (NoWorkspaceException e) {
			nodeFilter = new GraphEClassFilter(new LinkedList<ECPProject>(), graph);
		}
		edgeFilter = new GraphEReferenceFilter(graph);
		graph.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contentProvider = new UnicaseEntityContentProvider(nodeFilter, edgeFilter);
		graph.setContentProvider(contentProvider);
		graph.setLabelProvider(new UnicaseLabelProvider());
		graph.setLayoutAlgorithm(new UnicaseLayoutProvider(LayoutStyles.NONE), true);

		// double click navigation
		graph.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				setInput(event.getSelection());
			}
		});

		// DND
		dropTarget = new DropTarget(composite, SWT.NONE);
		dropTarget.setTransfer(new Transfer[] { LocalTransfer.getInstance() });
		dropTarget.addDropListener(new DropTargetAdapter() {
			@Override
			public void drop(DropTargetEvent event) {
				if (event.data instanceof ISelection) {
					setInput((ISelection) event.data);
				}
			};
		});

		// pop up menu for graph
		MenuManager menuMgr = new MenuManager();
		menuMgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		getSite().registerContextMenu(menuMgr, graph);
		Control control = graph.getControl();
		Menu menu = menuMgr.createContextMenu(control);
		control.setMenu(menu);

		// expandBar for options
		final ExpandBar optionBar = new ExpandBar(composite, SWT.NONE);
		GridData gridData = new GridData(SWT.CENTER, SWT.FILL, false, true);
		gridData.widthHint = 200;
		optionBar.setLayoutData(gridData);
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

	public void setInput(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
			EObject element = null;
			if (selectedElement instanceof EditPart) {
				// diagram element
				element = ((View) ((EditPart) selectedElement).getModel()).getElement();
			} else if (selectedElement instanceof GraphEObjectLayouted) {
				// hypergraph element
				element = ((GraphEObjectLayouted) selectedElement).object;
			} else if (selectedElement instanceof EObject) {
				element = (EObject) selectedElement;
			}
			setInput(element);
		}
	}

	public void setInput(EObject element) {
		if (element != null) {
			if (element instanceof ProjectSpace) {
				element = ((ProjectSpace) element).getProject();
			}
			graph.setInput(element);
		}
	}

	public void setAutoRefresh(boolean autoRefresh) {
		this.autoRefresh = autoRefresh;
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (autoRefresh) {
			setInput(selection);
		}
	}

	@Override
	public void setFocus() {
	}
}
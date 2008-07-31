package org.unicase.ui.stem.views;

import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.decorators.DecoratorManager;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class IterationPlanningView extends ViewPart {
	private TreeViewer viewer;
	private DrillDownAdapter drillDownAdapter;
	private Action doubleClickAction;

	/*
	 * The content provider class is responsible for providing objects to the
	 * view. It can wrap existing objects in adapters or simply return objects
	 * as-is. These objects may be sensitive to the current input of the view,
	 * or ignore it and always show the same content (like Task List, for
	 * example).
	 */

	/**
	 * The constructor.
	 */
	public IterationPlanningView() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new WorkpackageContentProvider());
		IDecoratorManager decoratorManager = new DecoratorManager();
		viewer.setLabelProvider(new DecoratingLabelProvider(
				new LabelProvider(), decoratorManager.getLabelDecorator()));
		Workspace workspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();
		viewer.setInput(workspace.getProjectSpaces().get(0).getProject());
		Tree tree = viewer.getTree();
		tree.setHeaderVisible(true);
		TreeViewerColumn column = new TreeViewerColumn(viewer, SWT.NONE);
		// column.getColumn().setText("Column0");
		column.setLabelProvider(new EMFColumnLabelProvider());

		TreeViewerColumn column1 = new TreeViewerColumn(viewer, SWT.NONE);
		column1.getColumn().setText("Annotated");
		column1.getColumn().setWidth(200);
		column1.setLabelProvider(new TaskObjectLabelProvider());
		column1.setEditingSupport(new TaskObjectEditingSupport(viewer));
		TreeViewerColumn column2 = new TreeViewerColumn(viewer, SWT.NONE);
		column2.getColumn().setText("Assigned to");
		column2.getColumn().setWidth(200);
		column2.setLabelProvider(new AssignedToLabelProvider());
		column2.setEditingSupport(new AssignedToEditingSupport(viewer));
		
		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(),
				"org.unicase.ui.treeview.viewer");

		hookDoubleClickAction();
		addDNDSupport();

	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				// JH open element
			}
		});
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getTree().setFocus();
	}

	private void addDNDSupport() {
		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		Object data = viewer.getTree().getData(DND.DRAG_SOURCE_KEY);

		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(
				viewer));
		viewer.addDropSupport(dndOperations, transfers,
				new WorkPackageViewerDropAdapter(
						TransactionalEditingDomain.Registry.INSTANCE
								.getEditingDomain("org.unicase.EditingDomain"),
						viewer));

	}

}
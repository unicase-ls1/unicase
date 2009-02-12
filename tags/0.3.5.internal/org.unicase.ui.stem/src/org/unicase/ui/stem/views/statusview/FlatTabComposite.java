/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;
import org.unicase.model.util.ProjectChangeObserver;
import org.unicase.ui.common.TableViewerColumnSorter;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.stem.views.AssignedToLabelProvider;
import org.unicase.ui.stem.views.iterationplanningview.TaskObjectLabelProvider;
import org.unicase.ui.stem.views.statusview.dnd.FlatTabDragAdapter;
import org.unicase.ui.stem.views.statusview.dnd.FlatTabDropAdapter;
import org.unicase.ui.tableview.labelprovider.StatusLabelProvider;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

/**
 * This class provides contents of flat tab in Status view. It contains a TableViewer that shows all Checkables and
 * Assignalbes for a model element. These are collected recursively. For example, if a FR has some child FRs as its
 * refiningRequirements(), their Checkables and Assignables are also considered the parents Checkables and Assignables
 * and shown in flat tab of parent.
 * 
 * @author Hodaie
 */
public class FlatTabComposite extends Composite implements ProjectChangeObserver {
	/**
	 * Sorter to sort a status view.
	 * 
	 * @author helming
	 */
	private final class StatusSorter extends TableViewerColumnSorter {
		private StatusSorter(TableViewer viewer, TableViewerColumn column, ColumnLabelProvider columnLabelProvider) {
			super(viewer, column, columnLabelProvider);
		}

		/*
		 * (non-Javadoc)
		 * @see org.unicase.ui.common.TableViewerColumnSorter#compare(org.eclipse .jface.viewers.Viewer,
		 * java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			String status1 = MEState.CLOSED;
			String status2 = MEState.CLOSED;
			if (e1 instanceof ModelElement) {
				try {
					status1 = ((ModelElement) e1).getMEState().getStatus();
				} catch (CircularDependencyException e) {
					// To nothing.
				}
			}
			if (e2 instanceof ModelElement) {
				try {
					status2 = ((ModelElement) e2).getMEState().getStatus();
				} catch (CircularDependencyException e) {
					// To nothing.
				}
			}
			return status1.compareTo(status2);
		}
	}

	private TableViewer tableViewer;
	private FlatTabDropAdapter flatTabDropAdapter;
	private FlatTabDragAdapter flatTabDragAdapter;
	private AdapterImpl adapterImpl;
	private Workspace workspace;

	// //for future use maybe
	// private ModelElement input;

	/**
	 * . Constructor
	 * 
	 * @param parent parent
	 * @param style style
	 */
	public FlatTabComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTable();
		workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		if (workspace.getActiveProjectSpace() != null) {
			workspace.getActiveProjectSpace().getProject().addProjectChangeObserver(FlatTabComposite.this);
		}
		adapterImpl = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {

					// remove old listeners
					Object oldValue = msg.getOldValue();
					if (oldValue instanceof ProjectSpace) {
						((ProjectSpace) oldValue).getProject().removeProjectChangeObserver(FlatTabComposite.this);
					}
					// add listener to get notified when work items get deleted/added/changed
					if (workspace.getActiveProjectSpace() != null) {
						workspace.getActiveProjectSpace().getProject().addProjectChangeObserver(FlatTabComposite.this);
					}
				}
			}
		};
		workspace.eAdapters().add(adapterImpl);
	}

	private void createTable() {

		// to implement the sorting in columns,
		// the tableViewer does not have a LabelProvider itself.
		// Instead of that every column has its own LabelProvider.
		// to implement background color for items each colum's
		// LabelProvider inherits FlatTabColumnLabelProvider which
		// implements IColorProvider
		tableViewer = new TableViewer(this, SWT.FULL_SELECTION | SWT.BORDER);
		tableViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		tableViewer.setContentProvider(new FlatTabContentProvider());

		createColumns();

		hookDoubleClick();

		addDnDSupport();

	}

	private void addDnDSupport() {
		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };

		flatTabDragAdapter = new FlatTabDragAdapter(tableViewer);
		tableViewer.addDragSupport(dndOperations, transfers, flatTabDragAdapter);

		flatTabDropAdapter = new FlatTabDropAdapter();
		tableViewer.addDropSupport(dndOperations, transfers, flatTabDropAdapter);

	}

	private void createColumns() {

		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// Todo column shows all Checkables and Assignables of input ME
		createTodoColumn();
		// state column show state of a Checkable of Assignable
		// (open/closed/blocked)
		createStateColumn();
		// assignedTo column shows the assignee of a checkable/assignable
		createAssignedToColumn();
		// model element column shows model element corresponding to a
		// checkable/assignable
		createModelElementColumn();
	}

	private void createTodoColumn() {
		TableViewerColumn tclmTodo = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmTodo.getColumn().setText("Todo");
		tclmTodo.getColumn().setWidth(80);
		FlatTabColumnLabelProvider columnLabelProvider = new FlatTabColumnLabelProvider() {
			@Override
			public Image getImage(Object element) {
				return getAdapterFactoryLabelProvider().getImage(element);
			}

		};
		tclmTodo.setLabelProvider(columnLabelProvider);
		// set column sorter. Category makes sorting first based on state
		// and then based on items text.
		new TableViewerColumnSorter(tableViewer, tclmTodo, columnLabelProvider) {
			@Override
			public int category(Object element) {
				if (element instanceof ModelElement) {
					ModelElement me = (ModelElement) element;
					if (me.getState().equals(MEState.CLOSED)) {
						return 2;
					} else {
						return 1;
					}
				}
				return 3;
			}

		};
	}

	private void createStateColumn() {
		StatusLabelProvider columnLabelProvider;
		TableViewerColumn tclmState = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmState.getColumn().setText("State");
		tclmState.getColumn().setWidth(80);
		columnLabelProvider = new StatusLabelProvider();
		tclmState.setLabelProvider(columnLabelProvider);
		new StatusSorter(tableViewer, tclmState, columnLabelProvider);

	}

	private void createAssignedToColumn() {
		AssignedToLabelProvider columnLabelProvider;
		TableViewerColumn tclmAsignedTo = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmAsignedTo.getColumn().setText("Assigned to");
		tclmAsignedTo.getColumn().setWidth(80);
		columnLabelProvider = new AssignedToLabelProvider();
		tclmAsignedTo.setLabelProvider(columnLabelProvider);
		new TableViewerColumnSorter(tableViewer, tclmAsignedTo, columnLabelProvider);
	}

	private void createModelElementColumn() {
		TableViewerColumn tclmModelElement = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmModelElement.getColumn().setText("Annotated");
		tclmModelElement.getColumn().setWidth(80);
		TaskObjectLabelProvider labelProvider = new TaskObjectLabelProvider();
		tclmModelElement.setLabelProvider(labelProvider);
		new TableViewerColumnSorter(tableViewer, tclmModelElement, labelProvider);
	}

	// on double click open the selection
	private void hookDoubleClick() {
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event.getSelection();
				ActionHelper.openModelElement((ModelElement) sel.getFirstElement(), tableViewer.getClass().getName());
			}

		});
	}

	/**
	 * Set input to flat tab TableViewer.
	 * 
	 * @param me input model element
	 * @param statusView the active status view. This is needed for drag and drop.
	 */
	public void setInput(ModelElement me, StatusView statusView) {
		// this.input = me;
		flatTabDropAdapter.setCurrentOpenMe(me, statusView);
		tableViewer.setInput(me);
		for (TableColumn column : tableViewer.getTable().getColumns()) {
			column.pack();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementAdded(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		tableViewer.refresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementDeleteCompleted(org.unicase.model.ModelElement)
	 */
	public void modelElementDeleteCompleted(ModelElement modelElement) {
		// nothing to do;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementDeleteStarted(org.unicase.model.ModelElement)
	 */
	public void modelElementDeleteStarted(ModelElement modelElement) {
		// nothing to do

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementRemoved(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public void modelElementRemoved(Project project, ModelElement modelElement) {
		tableViewer.refresh();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.model.Project, org.unicase.model.ModelElement)
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		tableViewer.refresh();
	}

	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {
		workspace.eAdapters().remove(adapterImpl);
		workspace.getActiveProjectSpace().getProject().removeProjectChangeObserver(FlatTabComposite.this);
		super.dispose();
	}

}

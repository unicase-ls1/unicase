/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.task.WorkItem;
import org.unicase.model.util.ProjectChangeObserver;
import org.unicase.ui.common.TableViewerColumnSorter;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.stem.views.statusview.dnd.WorkPackageTabDropAdapter;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

/**
 * @author Shterev
 */
public class WorkPackageTabComposite extends Composite implements ProjectChangeObserver {

	/**
	 * Priority sorter.
	 * 
	 * @author Shterev
	 */
	private final class PrioritySorter extends TableViewerColumnSorter {
		private PrioritySorter(TableViewer viewer, TableViewerColumn column, ColumnLabelProvider columnLabelProvider) {
			super(viewer, column, columnLabelProvider);
		}

		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			int prio1 = 0;
			int prio2 = 0;
			if (e1 instanceof WorkItem) {
				prio1 = ((WorkItem) e1).getPriority();
			}
			if (e2 instanceof WorkItem) {
				prio2 = ((WorkItem) e2).getPriority();
			}
			return (prio1 > prio2 ? 1 : -1);
		}
	}

	/**
	 * @author Shterev
	 */
	private final class WorkPackagePaintListener implements Listener {
		public void handleEvent(Event event) {
			switch (event.type) {
			case SWT.MeasureItem: {
				TableItem item = (TableItem) event.item;
				String text = getText(item);
				Point size = event.gc.textExtent(text);
				event.width = size.x;
				event.height = Math.max(event.height, size.y);
				break;
			}
			case SWT.PaintItem: {
				TableItem item = (TableItem) event.item;
				String text = getText(item);
				Point size = event.gc.textExtent(text);
				int offset2 = event.index == 0 ? Math.max(0, (event.height - size.y) / 2) : 0;
				event.gc.drawText(text, event.x, event.y + offset2, true);
				break;
			}
			case SWT.EraseItem: {
				event.detail &= ~SWT.FOREGROUND;
				break;
			}
			default:
				break;
			}
		}

		String getText(TableItem item) {
			String text = labelProvider.getText(item.getData());
			if (text == null) {
				text = ".";
			}
			return text;
		}
	}

	private Workspace workspace;
	private AdapterImpl adapterImpl;
	private WorkPackageTabDropAdapter wpTabDropAdapter;
	private ArrayList<TableViewer> tables = new ArrayList<TableViewer>();
	private SashForm sash;
	private WorkPackageTabLabelProvider labelProvider;

	/**
	 * Constructor.
	 * 
	 * @param parent parent
	 * @param style style
	 */
	public WorkPackageTabComposite(Composite parent, int style) {
		super(parent, style);
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(this);
		sash = new SashForm(this, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(sash);

		labelProvider = new WorkPackageTabLabelProvider();

		TableViewer unassigned = createTable("Unassigned");
		unassigned.setContentProvider(new WorkPackageTabContentProvider(WorkPackageTabContentProvider.UNASSIGNED));
		TableViewer assigned = createTable("Assigned");
		assigned.setContentProvider(new WorkPackageTabContentProvider(WorkPackageTabContentProvider.ASSIGNED));
		TableViewer blocked = createTable("Blocked");
		blocked.setContentProvider(new WorkPackageTabContentProvider(WorkPackageTabContentProvider.BLOCKED));
		TableViewer testing = createTable("Testing");
		testing.setContentProvider(new WorkPackageTabContentProvider(WorkPackageTabContentProvider.TESTING));
		TableViewer finished = createTable("Done");
		finished.setContentProvider(new WorkPackageTabContentProvider(WorkPackageTabContentProvider.DONE));

		/*
		 * NOTE: MeasureItem, PaintItem and EraseItem are called repeatedly. Therefore, it is critical for performance
		 * that these methods be as efficient as possible.
		 */
		Listener paintListener = new WorkPackagePaintListener();

		tables.add(assigned);
		tables.add(unassigned);
		tables.add(blocked);
		tables.add(testing);
		tables.add(finished);

		sash.setWeights(new int[] { 20, 20, 20, 20, 20 });

		for (TableViewer table : tables) {
			table.getTable().addListener(SWT.MeasureItem, paintListener);
			table.getTable().addListener(SWT.PaintItem, paintListener);
			table.getTable().addListener(SWT.EraseItem, paintListener);
		}

		addDnDSupport();
		hookDoubleClick();

		workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		if (workspace.getActiveProjectSpace() != null) {
			workspace.getActiveProjectSpace().getProject().addProjectChangeObserver(WorkPackageTabComposite.this);
		}
		adapterImpl = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {

					// remove old listeners
					Object oldValue = msg.getOldValue();
					if (oldValue instanceof ProjectSpace) {
						((ProjectSpace) oldValue).getProject()
							.removeProjectChangeObserver(WorkPackageTabComposite.this);
					}
					// add listener to get notified when work items get deleted/added/changed
					if (workspace.getActiveProjectSpace() != null) {
						workspace.getActiveProjectSpace().getProject().addProjectChangeObserver(
							WorkPackageTabComposite.this);
					}
				}
			}
		};
		workspace.eAdapters().add(adapterImpl);

	}

	private TableViewer createTable(String title) {
		TableViewer tableViewer = new TableViewer(sash, SWT.FULL_SELECTION | SWT.BORDER);
		tableViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		tableViewer.setLabelProvider(labelProvider);

		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);

		// root nodes (WorkPackage) and their contained WorkItems
		TableViewerColumn tclmWorkItem = new TableViewerColumn(tableViewer, SWT.NONE);
		tclmWorkItem.getColumn().setText(title);
		tclmWorkItem.getColumn().setWidth(200);
		tclmWorkItem.setLabelProvider(labelProvider);
		new PrioritySorter(tableViewer, tclmWorkItem, labelProvider);
		return tableViewer;
	}

	private void addDnDSupport() {
		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };

		wpTabDropAdapter = new WorkPackageTabDropAdapter();
		for (final TableViewer table : tables) {
			table.addDropSupport(dndOperations, transfers, wpTabDropAdapter);
		}

	}

	// on double-click open the selection
	private void hookDoubleClick() {
		for (final TableViewer table : tables) {
			table.addDoubleClickListener(new IDoubleClickListener() {
				public void doubleClick(DoubleClickEvent event) {
					IStructuredSelection sel = (IStructuredSelection) event.getSelection();
					ActionHelper.openModelElement((ModelElement) sel.getFirstElement(), table.getClass().getName());
				}

			});
		}
	}

	/**
	 * . set input to TreeViewer
	 * 
	 * @param me input model element
	 */
	public void setInput(ModelElement me) {
		// hierachieTabDropAdapter.setCurrentOpenME(me);
		for (TableViewer table : tables) {
			table.setInput(me);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementAdded(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		for (TableViewer table : tables) {
			table.refresh();
		}
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
		for (TableViewer table : tables) {
			table.refresh();
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.model.Project, org.unicase.model.ModelElement)
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		for (TableViewer table : tables) {
			table.refresh();
		}
	}

	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {

		workspace.eAdapters().remove(adapterImpl);
		if (workspace.getActiveProjectSpace() != null && workspace.getActiveProjectSpace().getProject() != null) {
			workspace.getActiveProjectSpace().getProject().removeProjectChangeObserver(WorkPackageTabComposite.this);

		}

		super.dispose();
	}

}

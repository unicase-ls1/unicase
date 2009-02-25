/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.util.ProjectChangeObserver;
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

	private Workspace workspace;
	private AdapterImpl adapterImpl;
	private WorkPackageTabDropAdapter wpTabDropAdapter;
	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;
	private ArrayList<TableViewer> tables = new ArrayList<TableViewer>();
	private SashForm sash;

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

		adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		TableViewer unassigned = createTable("Unassigned");
		unassigned
			.setContentProvider(new WorkPackageStatusContentProvider(WorkPackageStatusContentProvider.UNASSIGNED));
		TableViewer assigned = createTable("Assigned");
		assigned.setContentProvider(new WorkPackageStatusContentProvider(WorkPackageStatusContentProvider.ASSIGNED));
		TableViewer blocked = createTable("Blocked");
		blocked.setContentProvider(new WorkPackageStatusContentProvider(WorkPackageStatusContentProvider.BLOCKED));
		TableViewer testing = createTable("Testing");
		testing.setContentProvider(new WorkPackageStatusContentProvider(WorkPackageStatusContentProvider.TESTING));
		TableViewer finished = createTable("Done");
		finished.setContentProvider(new WorkPackageStatusContentProvider(WorkPackageStatusContentProvider.DONE));

		tables.add(assigned);
		tables.add(unassigned);
		tables.add(blocked);
		tables.add(testing);
		tables.add(finished);

		sash.setWeights(new int[] { 20, 20, 20, 20, 20 });

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
		TableViewer tableViewer = new TableViewer(sash, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final WorkPackageTabLabelProvider labelProvider = new WorkPackageTabLabelProvider();
		tableViewer.setLabelProvider(labelProvider);

		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);

		// root nodes (WorkPackage) and their contained WorkItems
		TableViewerColumn tclmWorkItem = new TableViewerColumn(tableViewer, SWT.NONE);
		tclmWorkItem.getColumn().setText(title);
		tclmWorkItem.getColumn().setWidth(100);
		tclmWorkItem.setLabelProvider(labelProvider);
		tableViewer.setComparator(new ViewerComparator() {

		});

		hookDoubleClick();
		addDnDSupport();
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

/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.util.ProjectChangeObserver;
import org.unicase.ui.common.TreeViewerColumnSorter;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.stem.views.AssignedToLabelProvider;
import org.unicase.ui.stem.views.iterationplanningview.AssignedToEditingSupport;
import org.unicase.ui.stem.views.iterationplanningview.EMFColumnLabelProvider;
import org.unicase.ui.stem.views.iterationplanningview.TaskObjectEditingSupport;
import org.unicase.ui.stem.views.iterationplanningview.TaskObjectLabelProvider;
import org.unicase.ui.stem.views.statusview.dnd.HierarchyTabDropAdapter;
import org.unicase.ui.stem.views.statusview.dnd.StatusViewTabsDragAdapter;
import org.unicase.ui.tableview.labelproviders.StatusLabelProvider;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

/**
 * . This class provides contents of hierarchy tab in Status view. It contains a TreeViewer. For a WorkPackage as input
 * model element, the TreeViewer shows a hierarchical view of all model elements being annotated by WorkItems contained
 * in this WorckPackage. For a model element as input, the TreeViewer just shows a hierarchical view of all its openers
 * as returned by OpeningLinkTaxonomy.getOpeners() I believe that for a model element as input there should also be an
 * implementation like that of a WorkPackage, i.e. for every opener that is an Annotation, instead of this opener its
 * annotated model elements should be shown. This is implemented but currently commented out.
 * 
 * @author Hodaie
 */
public class HierarchyTabComposite extends Composite implements ProjectChangeObserver {

	private TreeViewer treeViewer;
	private Workspace workspace;
	private AdapterImpl adapterImpl;
	private StatusViewTabsDragAdapter hierachieTabDragAdapter;
	private HierarchyTabDropAdapter hierachieTabDropAdapter;

	// private ModelElement input;

	/**
	 * Constructor.
	 * 
	 * @param parent parent
	 * @param style style
	 */
	public HierarchyTabComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTree();

		workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		if (workspace.getActiveProjectSpace() != null) {
			workspace.getActiveProjectSpace().getProject().addProjectChangeObserver(HierarchyTabComposite.this);
		}
		adapterImpl = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {

					// remove old listeners
					Object oldValue = msg.getOldValue();
					if (oldValue instanceof ProjectSpace) {
						((ProjectSpace) oldValue).getProject().removeProjectChangeObserver(HierarchyTabComposite.this);
					}
					// add listener to get notified when work items get deleted/added/changed
					if (workspace.getActiveProjectSpace() != null) {
						workspace.getActiveProjectSpace().getProject().addProjectChangeObserver(
							HierarchyTabComposite.this);
					}
				}
			}
		};
		workspace.eAdapters().add(adapterImpl);

	}

	private void createTree() {
		treeViewer = new TreeViewer(this, SWT.BORDER | SWT.FULL_SELECTION);
		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		treeViewer.setLabelProvider(new HierarchyTabLabelProvider());
		treeViewer.setContentProvider(new HierarchyTabContentProvider());
		// sort contents
		treeViewer.setComparator(new ViewerComparator());

		addColumns(treeViewer);

		hookDoubleClick();
		addDnDSupport();

	}

	private void addDnDSupport() {
		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };

		hierachieTabDragAdapter = new StatusViewTabsDragAdapter(treeViewer);
		treeViewer.addDragSupport(dndOperations, transfers, hierachieTabDragAdapter);

		hierachieTabDropAdapter = new HierarchyTabDropAdapter();
		treeViewer.addDropSupport(dndOperations, transfers, hierachieTabDropAdapter);

	}

	private void addColumns(TreeViewer viewer) {
		Tree tree = viewer.getTree();
		tree.setHeaderVisible(true);

		// root nodes (WorkPackage) and their contained WorkItems
		TreeViewerColumn tclmWorkItem = new TreeViewerColumn(viewer, SWT.NONE);
		tclmWorkItem.getColumn().setText("WorkItem");
		tclmWorkItem.getColumn().setWidth(400);
		EMFColumnLabelProvider emfColumnLabelProvider = new EMFColumnLabelProvider();
		tclmWorkItem.setLabelProvider(emfColumnLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmWorkItem, emfColumnLabelProvider);

		TreeViewerColumn status = new TreeViewerColumn(viewer, SWT.NONE);
		status.getColumn().setWidth(20);
		status.setLabelProvider(new StatusLabelProvider());
		status.getColumn().setText("State");

		// annotated model element
		TreeViewerColumn tclmAnnotatedME = new TreeViewerColumn(viewer, SWT.NONE);
		tclmAnnotatedME.getColumn().setText("Annotated");
		tclmAnnotatedME.getColumn().setWidth(100);
		TaskObjectLabelProvider taskObjectLabelProvider = new TaskObjectLabelProvider();
		tclmAnnotatedME.setLabelProvider(taskObjectLabelProvider);
		tclmAnnotatedME.setEditingSupport(new TaskObjectEditingSupport(viewer));
		new TreeViewerColumnSorter(viewer, tclmAnnotatedME, taskObjectLabelProvider);

		// Assignee
		TreeViewerColumn tclmAssignedTo = new TreeViewerColumn(viewer, SWT.NONE);
		tclmAssignedTo.getColumn().setText("Assigned to");
		tclmAssignedTo.getColumn().setWidth(100);
		AssignedToLabelProvider assignedToLabelProvider = new AssignedToLabelProvider();
		tclmAssignedTo.setLabelProvider(assignedToLabelProvider);
		tclmAssignedTo.setEditingSupport(new AssignedToEditingSupport(viewer));
		new TreeViewerColumnSorter(viewer, tclmAssignedTo, assignedToLabelProvider);

		// Priotity
		TreeViewerColumn tclmPriority = new TreeViewerColumn(viewer, SWT.NONE);
		tclmPriority.getColumn().setText("Priority");
		tclmPriority.getColumn().setWidth(100);
		PriorityLabelProvider priorityToLabelProvider = new PriorityLabelProvider();
		tclmPriority.setLabelProvider(priorityToLabelProvider);
		tclmPriority.setEditingSupport(new PriorityEditingSupport(viewer));
		new TreeViewerColumnSorter(viewer, tclmPriority, priorityToLabelProvider);

		// Estimate
		TreeViewerColumn tclmEstimate = new TreeViewerColumn(viewer, SWT.NONE);
		tclmEstimate.getColumn().setText("Estimate");
		tclmEstimate.getColumn().setWidth(100);
		HierarchyTabEstimateLabelProvider estimateToLabelProvider = new HierarchyTabEstimateLabelProvider(
			(HierarchyTabContentProvider) viewer.getContentProvider());
		tclmEstimate.setLabelProvider(estimateToLabelProvider);
		tclmEstimate.setEditingSupport(new PriorityEditingSupport(viewer));
		new TreeViewerColumnSorter(viewer, tclmEstimate, estimateToLabelProvider);

	}

	// on double-click open the selection
	private void hookDoubleClick() {
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event.getSelection();
				ActionHelper.openModelElement((ModelElement) sel.getFirstElement(), treeViewer.getClass().getName());
			}

		});
	}

	/**
	 * . set input to TreeViewer
	 * 
	 * @param me input model element
	 */
	public void setInput(ModelElement me) {
		hierachieTabDropAdapter.setCurrentOpenME(me);
		treeViewer.setInput(me);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementAdded(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		treeViewer.refresh();
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
		treeViewer.refresh();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.model.Project, org.unicase.model.ModelElement)
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		treeViewer.refresh();
	}

	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {

		workspace.eAdapters().remove(adapterImpl);
		if (workspace.getActiveProjectSpace() != null && workspace.getActiveProjectSpace().getProject() != null) {
			workspace.getActiveProjectSpace().getProject().removeProjectChangeObserver(HierarchyTabComposite.this);

		}

		super.dispose();
	}

}

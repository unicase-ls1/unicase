/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
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
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.stem.views.AssignedToLabelProvider;
import org.unicase.ui.stem.views.iterationplanningview.AssignedToEditingSupport;
import org.unicase.ui.stem.views.iterationplanningview.TaskObjectEditingSupport;
import org.unicase.ui.stem.views.iterationplanningview.TaskObjectLabelProvider;
import org.unicase.ui.stem.views.iterationplanningview.WorkPackageColumnLabelProvider;
import org.unicase.ui.stem.views.statusview.dnd.HierarchyTabDropAdapter;
import org.unicase.ui.stem.views.statusview.dnd.StatusViewTabsDragAdapter;
import org.unicase.ui.tableview.labelproviders.IntegerEditingSupport;
import org.unicase.ui.tableview.labelproviders.StatusLabelProvider;
import org.unicase.ui.unicasecommon.UnicaseActionHelper;
import org.unicase.ui.unicasecommon.common.TreeViewerColumnSorter;
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
		tclmWorkItem.getColumn().setWidth(300);
		WorkPackageColumnLabelProvider emfColumnLabelProvider = new WorkPackageColumnLabelProvider();
		tclmWorkItem.setLabelProvider(emfColumnLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmWorkItem, emfColumnLabelProvider);

		TreeViewerColumn status = new TreeViewerColumn(viewer, SWT.NONE);
		status.getColumn().setWidth(40);
		status.setLabelProvider(new StatusLabelProvider());
		status.getColumn().setText("State");

		// annotated model element
		TreeViewerColumn tclmAnnotatedME = new TreeViewerColumn(viewer, SWT.NONE);
		tclmAnnotatedME.getColumn().setText("Annotated");
		tclmAnnotatedME.getColumn().setWidth(200);
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
		ColumnLabelProvider priorityToLabelProvider = new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof WorkItem) {
					return ((WorkItem) element).getPriority() + "";
				}
				if (element instanceof FunctionalRequirement) {
					return ((FunctionalRequirement) element).getPriority() + "";
				}
				return "";
			}

		};
		tclmPriority.setLabelProvider(priorityToLabelProvider);
		tclmPriority.setEditingSupport(new HierarchyTabPriorityEditingSupport(viewer));
		new TreeViewerColumnSorter(viewer, tclmPriority, priorityToLabelProvider);

		// Estimate
		TreeViewerColumn tclmEstimate = new TreeViewerColumn(viewer, SWT.NONE);
		tclmEstimate.getColumn().setText("Estimate");
		tclmEstimate.getColumn().setWidth(100);
		HierarchyTabEstimateLabelProvider estimateLabelProvider = new HierarchyTabEstimateLabelProvider(
			(HierarchyTabContentProvider) viewer.getContentProvider());
		tclmEstimate.setLabelProvider(estimateLabelProvider);
		tclmEstimate.setEditingSupport(new IntegerEditingSupport(viewer, TaskPackage.eINSTANCE.getWorkItem_Estimate()));
		new TreeViewerColumnSorter(viewer, tclmEstimate, estimateLabelProvider);

	}

	// on double-click open the selection
	private void hookDoubleClick() {
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event.getSelection();
				UnicaseActionHelper.openModelElement((UnicaseModelElement) sel.getFirstElement(), treeViewer.getClass()
					.getName());
			}

		});
	}

	/**
	 * . set input to TreeViewer
	 * 
	 * @param me input model element
	 */
	public void setInput(UnicaseModelElement me) {
		hierachieTabDropAdapter.setCurrentOpenME(me);
		treeViewer.setInput(me);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementAdded(org.unicase.metamodel.Project,
	 *      org.unicase.model.UnicaseModelElement)
	 */
	public void modelElementAdded(Project project, EObject modelElement) {
		treeViewer.refresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementDeleteCompleted(org.unicase.model.UnicaseModelElement)
	 */
	public void modelElementRemoved(Project project, EObject modelElement) {
		treeViewer.refresh();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.metamodel.Project, org.unicase.model.UnicaseModelElement)
	 */
	public void notify(Notification notification, Project project, EObject modelElement) {
		treeViewer.update(modelElement, null);
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#projectDeleted(org.unicase.metamodel.Project)
	 */
	public void projectDeleted(Project project) {
		// TODO Auto-generated method stub

	}

}

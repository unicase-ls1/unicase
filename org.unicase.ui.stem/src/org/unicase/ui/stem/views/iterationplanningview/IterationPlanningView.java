/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.iterationplanningview;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.ui.common.TreeViewerColumnSorter;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.ui.common.dnd.UCDropAdapter;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

/**
 * This view helps managing WorkPackages (sprints) contained in
 * a project. It shows the WorkPackages of active project space (the project 
 * currently selected in navigator)
 * @author Hodaie
 *
 */
public class IterationPlanningView extends ViewPart {
	private TreeViewer viewer;
	private WorkpackageContentProvider workpackageContentProvider;
	private Project project;

	/**
	 * The constructor.
	 */
	public IterationPlanningView() {
	}

	/**.
	 * {@inheritDoc}
	 */
	public void createPartControl(Composite parent) {

		//create a TreeViewer for WorkPackages.
		//Root nodes are WorkPackage and children are their WorkItems
		//The tree has columns showing annotated model element and 
		//Assignee of a WorkItem
		createTreeViwer(parent);
		
		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(),
				"org.unicase.ui.treeview.viewer");

		hookDoubleClickAction();
		addDNDSupport();
		
		//respond to change of active ProjectSpace
		final Workspace workspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();
		workspace.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {
					if (workspace.getActiveProjectSpace() != null) {
						project = workspace.getActiveProjectSpace().getProject();
					}
					setInput();
				}
				super.notifyChanged(msg);
			}
		});

		//set input when showing the view for the first time.
		if (workspace.getActiveProjectSpace() != null) {
			project = workspace.getActiveProjectSpace().getProject();
			setInput();
		} else {
			setInput();
		}

	}

	
	private void createTreeViwer(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION);
		workpackageContentProvider = new WorkpackageContentProvider();
		viewer.setContentProvider(workpackageContentProvider);
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		viewer.setLabelProvider(new DecoratingLabelProvider(
				new LabelProvider(), decoratorManager.getLabelDecorator()));
		
		createColumns(viewer);
			
	}

	private void createColumns(TreeViewer viewer2) {
		Tree tree = viewer.getTree();
		tree.setHeaderVisible(true);

		//root nodes (WorkPackage) and their contained WorkItems
		TreeViewerColumn tclmWorkItem = new TreeViewerColumn(viewer, SWT.NONE);
		tclmWorkItem.getColumn().setText("WorkItem");
		tclmWorkItem.getColumn().setWidth(400);
		EMFColumnLabelProvider emfColumnLabelProvider = new EMFColumnLabelProvider();
		tclmWorkItem.setLabelProvider(emfColumnLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmWorkItem, emfColumnLabelProvider);

		//annotated model element
		TreeViewerColumn tclmAnnotatedME = new TreeViewerColumn(viewer,
				SWT.NONE);
		tclmAnnotatedME.getColumn().setText("Annotated");
		tclmAnnotatedME.getColumn().setWidth(100);
		TaskObjectLabelProvider taskObjectLabelProvider = new TaskObjectLabelProvider();
		tclmAnnotatedME.setLabelProvider(taskObjectLabelProvider);
		tclmAnnotatedME.setEditingSupport(new TaskObjectEditingSupport(viewer));
		new TreeViewerColumnSorter(viewer, tclmAnnotatedME,	taskObjectLabelProvider);

		//Assignee
		TreeViewerColumn tclmAssignedTo = new TreeViewerColumn(viewer, SWT.NONE);
		tclmAssignedTo.getColumn().setText("Assigned to");
		tclmAssignedTo.getColumn().setWidth(100);
		AssignedToLabelProvider assignedToLabelProvider = new AssignedToLabelProvider();
		tclmAssignedTo.setLabelProvider(assignedToLabelProvider);
		tclmAssignedTo.setEditingSupport(new AssignedToEditingSupport(viewer));
		new TreeViewerColumnSorter(viewer, tclmAssignedTo, assignedToLabelProvider);
		
	}

	/**.
	 * This sets the input of viewer on change of active ProjectSpace.
	 * The project is a field being set when activeProjectSpace is changed
	 * 
	 */
	protected void setInput() {
		viewer.setInput(project);
		////I thought this might help making tree columns look better.
		////Currently the width of tree columns are hard coded.
		//for (TreeColumn column : viewer.getTree().getColumns()) {
		//	column.pack();
		//}
	}

	/**
	 * open WorkItem on double-click
	 */
	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				TreeSelection selection = (TreeSelection) viewer.getSelection();
				Object object = selection.getFirstElement();
				if (object instanceof ModelElement) {
					ActionHelper.openModelElement((ModelElement) object);
				}
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

		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
		viewer.addDropSupport(dndOperations, transfers, new UCDropAdapter(
						      TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain"),
						      viewer));

	}

}
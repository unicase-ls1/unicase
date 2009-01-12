/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.TreeViewerColumnSorter;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.ui.stem.views.AssignedToLabelProvider;
import org.unicase.ui.stem.views.iterationplanningview.AssignedToEditingSupport;
import org.unicase.ui.stem.views.iterationplanningview.EMFColumnLabelProvider;
import org.unicase.ui.stem.views.iterationplanningview.TaskObjectEditingSupport;
import org.unicase.ui.stem.views.iterationplanningview.TaskObjectLabelProvider;

/**
 * This class provides contents of users tab in Status view. It contains a TreeViewer showing all OrgUnits participating
 * in progress of input model element. The TreeView has only two levels. At root level are the OrgUnits. The children
 * are Assignables corresponding the input element which are assigned to this OrgUnit.
 * 
 * @author Hodaie
 */
public class UserTabComposite extends Composite {

	private TreeViewer treeViewer;
	private UserTabStatusColumnLabelProvider statusColumnLabelProvider;

	// private ModelElement input;

	/**
	 * Constructor.
	 * 
	 * @param parent parent
	 * @param style style
	 */
	public UserTabComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTree();
	}

	private void createTree() {
		treeViewer = new TreeViewer(this, SWT.BORDER);
		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		UserTabContentProvider contentProvider = new UserTabContentProvider();
		treeViewer.setContentProvider(contentProvider);
		treeViewer.setLabelProvider(new UserTabLabelProvider());
		treeViewer.setComparator(new ViewerComparator());
		addColumns();

		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event.getSelection();
				if (sel.getFirstElement() instanceof ModelElement) {
					ActionHelper
						.openModelElement((ModelElement) sel.getFirstElement(), treeViewer.getClass().getName());
				}
			}

		});
	}

	private void addColumns() {

		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);

		// root nodes (WorkPackage) and their contained WorkItems
		TreeViewerColumn tclmWorkItem = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmWorkItem.getColumn().setText("WorkItem");
		tclmWorkItem.getColumn().setWidth(400);
		EMFColumnLabelProvider emfColumnLabelProvider = new EMFColumnLabelProvider();
		tclmWorkItem.setLabelProvider(emfColumnLabelProvider);
		new TreeViewerColumnSorter(treeViewer, tclmWorkItem, emfColumnLabelProvider);

		// status column
		TreeViewerColumn status = new TreeViewerColumn(treeViewer, SWT.NONE);
		status.getColumn().setWidth(20);
		statusColumnLabelProvider = new UserTabStatusColumnLabelProvider();
		status.setLabelProvider(statusColumnLabelProvider);
		status.getColumn().setText("State");

		// annotated model element
		TreeViewerColumn tclmAnnotatedME = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmAnnotatedME.getColumn().setText("Annotated");
		tclmAnnotatedME.getColumn().setWidth(100);
		TaskObjectLabelProvider taskObjectLabelProvider = new TaskObjectLabelProvider();
		tclmAnnotatedME.setLabelProvider(taskObjectLabelProvider);
		tclmAnnotatedME.setEditingSupport(new TaskObjectEditingSupport(treeViewer));
		new TreeViewerColumnSorter(treeViewer, tclmAnnotatedME, taskObjectLabelProvider);

		// Assignee
		TreeViewerColumn tclmAssignedTo = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmAssignedTo.getColumn().setText("Assigned to");
		tclmAssignedTo.getColumn().setWidth(100);
		AssignedToLabelProvider assignedToLabelProvider = new AssignedToLabelProvider();
		tclmAssignedTo.setLabelProvider(assignedToLabelProvider);
		tclmAssignedTo.setEditingSupport(new AssignedToEditingSupport(treeViewer));
		new TreeViewerColumnSorter(treeViewer, tclmAssignedTo, assignedToLabelProvider);

	}

	/**
	 * Set input to TreeViewer.
	 * 
	 * @param me input model element
	 */
	public void setInput(ModelElement me) {
		// this.input = me;
		statusColumnLabelProvider.setCurrentOpenME(me);
		treeViewer.setInput(me);

	}

}

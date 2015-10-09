/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.unicase.ui.stem.views.iterationplanningview.AssignedToEditingSupport;
import org.unicase.ui.stem.views.iterationplanningview.TaskObjectEditingSupport;
import org.unicase.ui.stem.views.iterationplanningview.TaskObjectLabelProvider;
import org.unicase.ui.stem.views.iterationplanningview.WorkPackageColumnLabelProvider;
import org.unicase.ui.tableview.labelproviders.StatusLabelProvider;
import org.unicase.ui.unicasecommon.common.TreeViewerColumnSorter;

/**
 * Utility for task tables.
 * 
 * @author helming
 */
public abstract class TaskTableUtil {

	private TaskTableUtil() {

	}

	/**
	 * Adds standard Columsn to any task tree table.
	 * 
	 * @param treeViewer The task tree viewer.
	 */
	public static void addColumns(TreeViewer treeViewer) {

		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);

		// root nodes (WorkPackage) and their contained WorkItems
		TreeViewerColumn tclmWorkItem = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmWorkItem.getColumn().setText("WorkItem");
		tclmWorkItem.getColumn().setWidth(300);
		WorkPackageColumnLabelProvider emfColumnLabelProvider = new WorkPackageColumnLabelProvider();
		tclmWorkItem.setLabelProvider(emfColumnLabelProvider);
		new TreeViewerColumnSorter(treeViewer, tclmWorkItem, emfColumnLabelProvider);

		TreeViewerColumn status = new TreeViewerColumn(treeViewer, SWT.NONE);
		status.getColumn().setWidth(40);
		status.setLabelProvider(new StatusLabelProvider());
		status.getColumn().setText("State");

		// annotated model element
		TreeViewerColumn tclmAnnotatedME = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmAnnotatedME.getColumn().setText("Annotated");
		tclmAnnotatedME.getColumn().setWidth(200);
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

}

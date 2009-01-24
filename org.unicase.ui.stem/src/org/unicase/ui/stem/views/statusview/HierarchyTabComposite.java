/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
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
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.stem.views.AssignedToLabelProvider;
import org.unicase.ui.stem.views.iterationplanningview.AssignedToEditingSupport;
import org.unicase.ui.stem.views.iterationplanningview.EMFColumnLabelProvider;
import org.unicase.ui.stem.views.iterationplanningview.TaskObjectEditingSupport;
import org.unicase.ui.stem.views.iterationplanningview.TaskObjectLabelProvider;
import org.unicase.ui.tableview.labelprovider.StatusLabelProvider;

/**.
 * 
 * This class provides contents of hierarchy tab in Status view. It contains a
 * TreeViewer. 
 * For a WorkPackage as input model element, the TreeViewer shows 
 * a hierarchical view of all model elements being annotated by WorkItems 
 * contained in this WorckPackage. 
 * For a model element as input, the TreeViewer just shows a hierarchical 
 * view of all its openers as returned by OpeningLinkTaxonomy.getOpeners()
 * I believe that for a model element as input there should also be an implementation
 * like that of a WorkPackage, i.e. for every opener that is an Annotation, 
 * instead of this opener its annotated model elements should be shown. This is
 * implemented but currently commented out. 
 * 
 * @author Hodaie
 *
 */
public class HierarchyTabComposite extends Composite {

	private TreeViewer treeViewer;
	//private ModelElement input;
	
	/**.
	 * Constructor
	 * @param parent parent
	 * @param style style
	 */
	public HierarchyTabComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTree();
		
	}

	
	private void createTree() {
		treeViewer = new TreeViewer(this, SWT.BORDER);
		treeViewer.getTree().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		
		treeViewer.setLabelProvider(new HierarchyTabLabelProvider());
		treeViewer.setContentProvider(new HierarchyTabContentProvider());
		//sort contents
		treeViewer.setComparator(new ViewerComparator());
		
		addColumns(treeViewer);
		
		hookDoubleClick();
		
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
		TreeViewerColumn tclmAnnotatedME = new TreeViewerColumn(viewer,
				SWT.NONE);
		tclmAnnotatedME.getColumn().setText("Annotated");
		tclmAnnotatedME.getColumn().setWidth(100);
		TaskObjectLabelProvider taskObjectLabelProvider = new TaskObjectLabelProvider();
		tclmAnnotatedME.setLabelProvider(taskObjectLabelProvider);
		tclmAnnotatedME.setEditingSupport(new TaskObjectEditingSupport(viewer));
		new TreeViewerColumnSorter(viewer, tclmAnnotatedME,
				taskObjectLabelProvider);

		// Assignee
		TreeViewerColumn tclmAssignedTo = new TreeViewerColumn(viewer, SWT.NONE);
		tclmAssignedTo.getColumn().setText("Assigned to");
		tclmAssignedTo.getColumn().setWidth(100);
		AssignedToLabelProvider assignedToLabelProvider = new AssignedToLabelProvider();
		tclmAssignedTo.setLabelProvider(assignedToLabelProvider);
		tclmAssignedTo.setEditingSupport(new AssignedToEditingSupport(viewer));
		new TreeViewerColumnSorter(viewer, tclmAssignedTo,
				assignedToLabelProvider);		
	}


	//on double-click open the selection
	private void hookDoubleClick() {
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event
						.getSelection();
				ActionHelper.openModelElement((ModelElement) sel
						.getFirstElement(), treeViewer.getClass().getName());
			}

		});
	}
	
	/**.
	 * set input to TreeViewer
	 * 
	 * @param me input model element
	 */
	public void setInput(ModelElement me) {
		//this.input = me;
		treeViewer.setInput(me);
	
	}

}

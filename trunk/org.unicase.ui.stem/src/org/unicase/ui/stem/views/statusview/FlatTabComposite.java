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
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.unicase.model.ModelElement;
import org.unicase.model.task.Assignable;
import org.unicase.model.task.util.MEState;
import org.unicase.ui.common.TableViewerColumnSorter;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.ui.stem.views.iterationplanningview.TaskObjectLabelProvider;

/**.
 *  This class provides contents of flat tab in Status view. It contains a
 * TableViewer that shows all Checkables and Assignalbes for a model element.
 * These are collected recursively. For example, if a FR has some child FRs as
 * its refiningRequirements(), their Checkables and Assignables are also
 * considered the parents Checkables and Assignables and shown in flat tab of
 * parent.
 * 
 * 
 * @author Hodaie
 * 
 */
public class FlatTabComposite extends Composite {

	private TableViewer tableViewer;

	////for future use maybe
	//private ModelElement input;

	/**
	 * . Constructor
	 * @param parent parent
	 * @param style style
	 */
	public FlatTabComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTable();
	}

	private void createTable() {

		//to implement the sorting in columns, 
		//the tableViewer does not have a LabelProvider itself.
		//Instead of that every column has its own LabelProvider.
		//to implement background color for items each colum's
		//LabelProvider inherits FlatTabColumnLabelProvider which
		//implements IColorProvider
		tableViewer = new TableViewer(this, SWT.FULL_SELECTION | SWT.BORDER);
		tableViewer.getTable().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));

		tableViewer.setContentProvider(new FlatTabContentProvider());

		createColumns();

		hookDoubleClick();
	}

	private void createColumns() {
		
		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		//Todo column shows all Checkables and Assignables of input ME
		createTodoColumn();
		//state column show state of a Checkable of Assignable (open/closed/blocked)
		createStateColumn();
		//assignedTo column shows the assignee of a checkable/assignable
		createAssignedToColumn();
		//model element column shows model element corresponding to a checkable/assignable
		createModelElementColumn();
	}

	private void createTodoColumn() {
		TableViewerColumn tclmTodo = new TableViewerColumn(tableViewer,
				SWT.LEAD);
		tclmTodo.getColumn().setText("Todo");
		tclmTodo.getColumn().setWidth(80);
		FlatTabColumnLabelProvider columnLabelProvider = new FlatTabColumnLabelProvider() {
			@Override
			public Image getImage(Object element) {
				return getAdapterFactoryLabelProvider().getImage(element);
			}

			@Override
			public Color getBackground(Object object) {
				ModelElement me = (ModelElement) object;
				if (me.getState().equals(MEState.CLOSED)) {
					return Display.getDefault().getSystemColor(SWT.COLOR_GREEN);
				} else {
					return getAdapterFactoryLabelProvider().getBackground(object);
				}
			}

		};
		tclmTodo.setLabelProvider(columnLabelProvider);
		//set column sorter. Category makes sorting first based on state
		//and then based on items text.
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
		FlatTabColumnLabelProvider columnLabelProvider;
		TableViewerColumn tclmState = new TableViewerColumn(tableViewer,
				SWT.LEAD);
		tclmState.getColumn().setText("State");
		tclmState.getColumn().setWidth(80);
		columnLabelProvider = new FlatTabColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((ModelElement) element).getState();
			}
		};
		tclmState.setLabelProvider(columnLabelProvider);
		new TableViewerColumnSorter(tableViewer, tclmState, columnLabelProvider);
	
	}

	private void createAssignedToColumn() {
		FlatTabColumnLabelProvider columnLabelProvider;
		TableViewerColumn tclmAsignedTo = new TableViewerColumn(tableViewer,
				SWT.LEAD);
		tclmAsignedTo.getColumn().setText("Assigned to");
		tclmAsignedTo.getColumn().setWidth(80);
		columnLabelProvider = new FlatTabColumnLabelProvider() {

			@Override
			public String getText(Object element) {

				if (element instanceof Assignable) {
					Assignable assignable = (Assignable) element;
					if (assignable.getAssignee() != null) {
						return assignable.getAssignee().getName();
					} else {
						return "N/A";
					}

				} else {
					return "N/A";
				}

			}

		};
		tclmAsignedTo.setLabelProvider(columnLabelProvider);
		new TableViewerColumnSorter(tableViewer, tclmAsignedTo,
				columnLabelProvider);
	}

	private void createModelElementColumn() {
		TableViewerColumn tclmModelElement = new TableViewerColumn(tableViewer,
				SWT.LEAD);
		tclmModelElement.getColumn().setText("Model Element");
		tclmModelElement.getColumn().setWidth(80);
		TaskObjectLabelProvider labelProvider = new TaskObjectLabelProvider(){
			@Override
			public Color getBackground(Object element) {
				return getAdapterFactoryLabelProvider().getBackground(element);
			}
		};
		tclmModelElement.setLabelProvider(labelProvider);
		new TableViewerColumnSorter(tableViewer, tclmModelElement,
				labelProvider);
	}

	// on double click open the selection
	private void hookDoubleClick() {
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event
						.getSelection();
				ActionHelper.openModelElement((ModelElement) sel
						.getFirstElement());
			}

		});
	}

	/**.
	 * set input to flat tab TableViewer
	 * 
	 * @param me input model element
	 */
	public void setInput(ModelElement me) {
		// this.input = me;
		tableViewer.setInput(me);
		for (TableColumn column : tableViewer.getTable().getColumns()) {
			column.pack();
		}
	}

}

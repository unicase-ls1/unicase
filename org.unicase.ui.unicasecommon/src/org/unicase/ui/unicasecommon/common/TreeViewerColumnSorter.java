/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.unicase.model.Annotation;
import org.unicase.model.task.WorkPackage;

/**
 * . This is a sorter class used to sort TreeViewers. Note this class is
 * currently only used by StatusView and its category method is tailored to
 * handle WorkPackages and Annotations. It may be changed to an abstract class
 * without any implementation of category method.
 * 
 * @author hodaie
 */
public class TreeViewerColumnSorter extends ColumnViewerSorter {

	private TreeViewerColumn column;

	/**
	 * Constructor.
	 * 
	 * @param viewer
	 *            TreeViewer to be sorted
	 * @param column
	 *            TreeViewerColumn based on which the TreeViewer is sorted
	 * @param columnLabelProvider
	 *            LabelProvider used to sort the contents
	 */
	public TreeViewerColumnSorter(TreeViewer viewer, TreeViewerColumn column,
			ColumnLabelProvider columnLabelProvider) {
		super(viewer, columnLabelProvider);
		this.column = column;

		column.getColumn().addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (getViewer().getComparator() != null) {
					if (getViewer().getComparator() == TreeViewerColumnSorter.this) {
						if (getDirection() == ASC) {
							setSorter(TreeViewerColumnSorter.this, DESC);
						} else {
							setSorter(TreeViewerColumnSorter.this, ASC);
						}
					} else {
						setSorter(TreeViewerColumnSorter.this, ASC);
					}
				} else {
					setSorter(TreeViewerColumnSorter.this, ASC);
				}
			}
		});
	}

	/**
	 * This is used to set the right direction arrow at column header and
	 * refresh the viewer.
	 * 
	 * @param sorter
	 *            sorter
	 * @param direction
	 *            direction
	 */
	@Override
	protected void setSorter(ColumnViewerSorter sorter, int direction) {

		super.setSorter(sorter, direction);

		column.getColumn().getParent().setSortColumn(column.getColumn());
		if (direction == ASC) {
			column.getColumn().getParent().setSortDirection(SWT.DOWN);
		} else {
			column.getColumn().getParent().setSortDirection(SWT.UP);
		}

	}

	/**
	 * . {@inheritDoc} This method is adapted to sort StatusView tree.
	 */
	@Override
	public int category(Object element) {
		if (element instanceof Annotation) {
			return 1;
		}
		if (element instanceof WorkPackage) {
			return 2;
		}
		return 3;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.UnicaseColumnViewerSorter#getViewerColumn()
	 */
	@Override
	public ViewerColumn getViewerColumn() {
		return column;
	}

}

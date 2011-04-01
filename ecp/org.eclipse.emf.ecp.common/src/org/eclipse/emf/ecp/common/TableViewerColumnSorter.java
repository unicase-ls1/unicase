/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 * . This a sorter for TableViewers.
 * 
 * @author hodaie
 */
public class TableViewerColumnSorter extends UnicaseColumnViewerSorter {

	private TableViewerColumn column;

	/**
	 * . Constructor
	 * 
	 * @param viewer TableViewer to be sorted
	 * @param column TableViewerColumn based on which viewer is sorted
	 * @param columnLabelProvider ColumnLabelProvider used to sort contents
	 */
	public TableViewerColumnSorter(TableViewer viewer, TableViewerColumn column, ColumnLabelProvider columnLabelProvider) {
		super(viewer, columnLabelProvider);
		this.column = column;
		column.getColumn().addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (getViewer().getComparator() != null) {
					if (getViewer().getComparator() == TableViewerColumnSorter.this) {
						if (getDirection() == ASC) {
							setSorter(TableViewerColumnSorter.this, DESC);
						} else {
							setSorter(TableViewerColumnSorter.this, ASC);
						}
					} else {
						setSorter(TableViewerColumnSorter.this, ASC);
					}
				} else {
					setSorter(TableViewerColumnSorter.this, ASC);
				}
			}
		});
	}

	/**
	 * This is used to set the right direction arrow at column header and refresh the viewer.
	 * 
	 * @param sorter sorter
	 * @param direction direction
	 */
	@Override
	protected void setSorter(UnicaseColumnViewerSorter sorter, int direction) {

		super.setSorter(sorter, direction);

		column.getColumn().getParent().setSortColumn(column.getColumn());
		if (direction == ASC) {
			column.getColumn().getParent().setSortDirection(SWT.DOWN);
		} else {
			column.getColumn().getParent().setSortDirection(SWT.UP);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.common.UnicaseColumnViewerSorter#getViewerColumn()
	 */
	@Override
	public ViewerColumn getViewerColumn() {
		return column;
	}

}

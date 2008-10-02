/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.common;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.SelectionEvent;

/**.
 * This a sorter for TableViewers.
 * @author hodaie
 *
 */
public class TableViewerColumnSorter extends ViewerComparator {

	/**.
	 * Direction constant used to show right direction arrow on column header
	 */
	public static final int ASC = 1;
	/**.
	 * Direction constant used to show right direction arrow on column header
	 */
	public static final int DESC = -1;

	private int direction = 1;

	private TableViewerColumn column;
	private ColumnLabelProvider columnLabelProvider;

	private TableViewer viewer;

	/**.
	 * Constructor
	 * @param viewer TableViewer to be sorted
	 * @param column TableViewerColumn based on which viewer is sorted
	 * @param columnLabelProvider ColumnLabelProvider used to sort contents
	 */
	public TableViewerColumnSorter(TableViewer viewer,
			TableViewerColumn column, ColumnLabelProvider columnLabelProvider) {
		this.columnLabelProvider = columnLabelProvider;
		this.column = column;
		this.viewer = viewer;

		this.column.getColumn().addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (TableViewerColumnSorter.this.viewer.getComparator() != null) {
					if (TableViewerColumnSorter.this.viewer.getComparator() == TableViewerColumnSorter.this) {
						if (direction == ASC) {
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
	
	/**.
	 * This is used to set the right direction arrow at column header and refresh the viewer.
	 */
	private void setSorter(TableViewerColumnSorter sorter, int direction) {
		column.getColumn().getParent().setSortColumn(column.getColumn());
		sorter.direction = direction;

		if (direction == ASC) {
			column.getColumn().getParent().setSortDirection(SWT.DOWN);
		} else {
			column.getColumn().getParent().setSortDirection(SWT.UP);
		}

		if (viewer.getComparator() == sorter) {
			viewer.refresh();
		} else {
			viewer.setComparator(sorter);
		}

	}

	/**.
	 * {@inheritDoc}
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {

		int cat1 = category(e1);
		int cat2 = category(e2);

		if (cat1 != cat2) {
			return cat1 - cat2;
		}

		String str1 = columnLabelProvider.getText(e1);
		String str2 = columnLabelProvider.getText(e2);

		if (str1 == null) {
			str1 = "";
		}
		if (str2 == null) {
			str2 = "";
		}

		// use the comparator to compare the strings
		if (direction == ASC) {
			return getComparator().compare(str1, str2);
		} else {
			return getComparator().compare(str2, str1);
		}

	}


}


/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.common;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TableViewerColumnSorter extends ViewerComparator {

	public static final int ASC = 1;
	public static final int DESC = -1;

	private int direction = 1;

	private TableViewerColumn column;
	private ColumnLabelProvider columnLabelProvider;

	private TableViewer viewer;

	public TableViewerColumnSorter(TableViewer viewer,
			TableViewerColumn column, ColumnLabelProvider columnLabelProvider) {
		this.columnLabelProvider = columnLabelProvider;
		this.column = column;
		this.viewer = viewer;

		this.column.getColumn().addSelectionListener(new SelectionAdapter() {

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

	public void setSorter(TableViewerColumnSorter sorter, int direction) {
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

//	@Override
//	public int category(Object element) {
//		if (element instanceof ModelElement) {
//			ModelElement me = (ModelElement) element;
//			if (me.getState().equals(MEState.CLOSED)) {
//				return 2;
//			} else {
//				return 1;
//			}
//		}
//		return 3;
//	}

}

// //====================================================================
// //====================================================================
//
// package org.unicase.ui.common;
//
// import org.eclipse.jface.viewers.ColumnViewer;
// import org.eclipse.jface.viewers.ITableLabelProvider;
// import org.eclipse.jface.viewers.TableViewer;
// import org.eclipse.jface.viewers.TableViewerColumn;
// import org.eclipse.jface.viewers.Viewer;
// import org.eclipse.jface.viewers.ViewerComparator;
// import org.eclipse.swt.SWT;
// import org.eclipse.swt.events.SelectionAdapter;
// import org.eclipse.swt.events.SelectionEvent;
// import org.unicase.model.Annotation;
// import org.unicase.model.task.WorkPackage;
//
// public class TableViewerColumnSorter extends ViewerComparator {
//
// public static final int ASC = 1;
// public static final int DESC = -1;
//
// private int direction = 1;
//
// private TableViewerColumn column;
// private ITableLabelProvider tableLabelProvider;
// private int columnIndex;
//
// private TableViewer viewer;
//
// public TableViewerColumnSorter(TableViewer viewer,
// TableViewerColumn column, ITableLabelProvider tableLabelProvider,
// int columnIndex) {
// this.tableLabelProvider = tableLabelProvider;
// this.column = column;
//
// this.viewer = viewer;
// this.columnIndex = columnIndex;
//
// this.column.getColumn().addSelectionListener(new SelectionAdapter() {
//
// public void widgetSelected(SelectionEvent e) {
// if (TableViewerColumnSorter.this.viewer.getComparator() != null) {
// if (TableViewerColumnSorter.this.viewer.getComparator() ==
// TableViewerColumnSorter.this) {
// if (direction == ASC) {
// setSorter(TableViewerColumnSorter.this, DESC);
// } else {
// setSorter(TableViewerColumnSorter.this, ASC);
// }
// } else {
// setSorter(TableViewerColumnSorter.this, ASC);
// }
// } else {
// setSorter(TableViewerColumnSorter.this, ASC);
// }
// }
// });
// }
//
// public void setSorter(TableViewerColumnSorter sorter, int direction) {
// column.getColumn().getParent().setSortColumn(column.getColumn());
// sorter.direction = direction;
//
// if (direction == ASC) {
// column.getColumn().getParent().setSortDirection(SWT.DOWN);
// } else {
// column.getColumn().getParent().setSortDirection(SWT.UP);
// }
//
// if (viewer.getComparator() == sorter) {
// viewer.refresh();
// } else {
// viewer.setComparator(sorter);
// }
//
// }
//
// public int compare(Viewer viewer, Object e1, Object e2) {
//
// String name1 = tableLabelProvider.getColumnText(e1, columnIndex);
// String name2 = tableLabelProvider.getColumnText(e2, columnIndex);
//
// if (name1 == null) {
// name1 = "";
// }
// if (name2 == null) {
// name2 = "";
// }
//
// // use the comparator to compare the strings
// if (direction == ASC) {
// return getComparator().compare(name1, name2);
// } else {
// return getComparator().compare(name2, name1);
// }
//
// }
//
// // @Override
// // public int category(Object element) {
// // if (element instanceof Annotation)
// // return 1;
// // if (element instanceof WorkPackage)
// // return 2;
// // return 3;
// // }
//
// }
//

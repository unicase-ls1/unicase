/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.tableview.labelproviders;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.model.ModelElement;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;
import org.unicase.ui.common.TableViewerColumnSorter;

/**
 * the Sorter to sort stats.
 * 
 * @author abdelhamidbarzali
 * @author hodai.
 */
public class StatusSorter extends TableViewerColumnSorter {
	/**
	 * @param viewer the Viewer
	 * @param column the TableViewerColumn
	 * @param columnLabelProvider the ColumnLabelProvider
	 */
	public StatusSorter(TableViewer viewer, TableViewerColumn column, ColumnLabelProvider columnLabelProvider) {
		super(viewer, column, columnLabelProvider);
	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		String status1 = MEState.CLOSED;
		String status2 = MEState.CLOSED;
		if (e1 instanceof ModelElement) {
			try {
				status1 = ((ModelElement) e1).getMEState().getStatus();
			} catch (CircularDependencyException e) {
				// To nothing.
			}
		}
		if (e2 instanceof ModelElement) {
			try {
				status2 = ((ModelElement) e2).getMEState().getStatus();
			} catch (CircularDependencyException e) {
				// To nothing.
			}
		}
		return status1.compareTo(status2);
	}
}

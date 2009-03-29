/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;

/**
 * Super-class for sorting column viewer, with ability to turn sorting on and off.
 * @author zardosht
 *
 */
public abstract class UnicaseColumnViewerSorter extends ViewerComparator {

	/**
	 * Direction constant used to show right direction arrow on column header.
	 */
	public static final int ASC = 1;
	/**
	 *  Direction constant used to show right direction arrow on column header.
	 */
	public static final int DESC = -1;
	private int direction = 1;
	private ColumnLabelProvider columnLabelProvider;
	private final ColumnViewer viewer;
	private boolean sortingEnabled;

	
	/**
	 * Constructor.
	 * @param viewer ColumnViewer
	 * @param columnLabelProvider ColumnLabelProvider
	 */
	public UnicaseColumnViewerSorter(ColumnViewer viewer, ColumnLabelProvider columnLabelProvider) {
		this.columnLabelProvider = columnLabelProvider;
		this.viewer = viewer;
	}

	/**
	 * . This is used to set the right direction arrow at column header and refresh the viewer.
	 * @param sorter sorter
	 * @param direction direction
	 */
	protected void setSorter(UnicaseColumnViewerSorter sorter, int direction) {
		if(!sortingEnabled){
			sortingEnabled = true;
		}
	
		this.direction = direction;
	
		if (viewer.getComparator() == sorter) {
			viewer.refresh();
		} else {
			viewer.setComparator(sorter);
		}
	
	}

	/**
	 * . {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		
		if(!sortingEnabled){
			return 0;
		}
		
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

	/**
	 * @param sortingEnabled the sortingEnabled to set
	 */
	public void setSortingEnabled(boolean sortingEnabled) {
		this.sortingEnabled = sortingEnabled;
	}

	/**
	 * @return the sortingEnabled
	 */
	public boolean isSortingEnabled() {
		return sortingEnabled;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * @return the direction
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * 
	 * @return viewer column
	 */
	public abstract ViewerColumn getViewerColumn();

	/**
	 * @param columnLabelProvider the columnLabelProvider to set
	 */
	public void setColumnLabelProvider(ColumnLabelProvider columnLabelProvider) {
		this.columnLabelProvider = columnLabelProvider;
	}

	/**
	 * @return the columnLabelProvider
	 */
	public ColumnLabelProvider getColumnLabelProvider() {
		return columnLabelProvider;
	}

	
	/**
	 * @return the viewer
	 */
	public ColumnViewer getViewer() {
		return viewer;
	}

}
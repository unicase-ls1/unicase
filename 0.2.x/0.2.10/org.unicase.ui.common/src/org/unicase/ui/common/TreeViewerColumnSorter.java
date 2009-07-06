/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */
package org.unicase.ui.common;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.unicase.model.Annotation;
import org.unicase.model.task.WorkPackage;

/**.
 * This is a sorter class used to sort TreeViewers. Note this class is currently only used by StatusView and 
 * its category method is tailored to handle WorkPackages and Annotations. It may be changed to an abstract class without
 * any implementation of category method.
 *  
 * @author hodaie
 *
 */
public  class TreeViewerColumnSorter extends ViewerComparator {
	/**.
	 * Direction constant used to show right direction arrow on column header
	 */
	public static final int ASC = 1;
	/**.
	 * Direction constant used to show right direction arrow on column header
	 */
	public static final int DESC = -1;
	
	private int direction = 1;
	
	private TreeViewerColumn column;
	private ColumnLabelProvider columnLabelProvider;
	
	private TreeViewer viewer;
	
	/**.
	 * Constructor
	 * @param viewer TreeViewer to be sorted
	 * @param column TreeViewerColumn based on which the TreeViewer is sorted
	 * @param columnLabelProvider LabelProvider used to sort the contents
	 */
	public TreeViewerColumnSorter(TreeViewer viewer, TreeViewerColumn column,  ColumnLabelProvider columnLabelProvider) {
		this.columnLabelProvider = columnLabelProvider;
		this.column = column;
		this.viewer = viewer;
		this.column.getColumn().addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if( TreeViewerColumnSorter.this.viewer.getComparator() != null ) {
					if( TreeViewerColumnSorter.this.viewer.getComparator() == TreeViewerColumnSorter.this ) {
						if( direction == ASC ) {
							setSorter(TreeViewerColumnSorter.this, DESC);
						}else{
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
	
	/**.
	 * This is used to set the right direction arrow at column header and refresh the viewer.
	 * 
	 */
	private void setSorter(TreeViewerColumnSorter sorter, int direction) {
			column.getColumn().getParent().setSortColumn(column.getColumn());
			sorter.direction = direction;
			
			if( direction == ASC ) {
				column.getColumn().getParent().setSortDirection(SWT.DOWN);
			} else {
				column.getColumn().getParent().setSortDirection(SWT.UP);
			}
			
			if( viewer.getComparator() == sorter ) {
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
		    	
	    String name1 = columnLabelProvider.getText(e1);
		String name2 = columnLabelProvider.getText(e2);

		if (name1 == null) {
			name1 = "";
		}
		if (name2 == null) {
			name2 = "";
		}

		// use the comparator to compare the strings
		if(direction == ASC){
			return getComparator().compare(name1, name2);
		}else{
			return getComparator().compare(name2, name1);
		}
	
	}
	
	
	/**.
	 * {@inheritDoc}
	 * This method is adapted to sort StatusView tree.  
	 */
	@Override
	public int category(Object element) {
		if(element instanceof Annotation) {
			return 1;
		}
		if(element instanceof WorkPackage) {
			return 2;
		}
		return 3;
	}
	
}

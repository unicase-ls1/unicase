/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.iterationplanningview;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;

/**
 * . I think this class should potentially be used to change Assignee of a WorkItem in IterationPlaningView (my be using
 * a drop-down list showing all users/groups)
 * 
 * @author Helming
 */
public class AssignedToEditingSupport extends EditingSupport {

	/**
	 * . Constructor
	 * 
	 * @param viewer the viewer containing this column
	 */
	public AssignedToEditingSupport(ColumnViewer viewer) {
		super(viewer);
		// TODO Auto-generated constructor stub
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	protected boolean canEdit(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	protected CellEditor getCellEditor(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	protected Object getValue(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	protected void setValue(Object element, Object value) {
		// TODO Auto-generated method stub

	}

}

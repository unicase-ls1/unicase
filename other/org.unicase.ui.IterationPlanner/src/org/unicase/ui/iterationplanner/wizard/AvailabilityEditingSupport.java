/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.wizard;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.unicase.model.organization.User;
import org.unicase.ui.iterationplanner.core.IterationPlanner;

/**
 * @author Hodaie
 */
public class AvailabilityEditingSupport extends EditingSupport {

	private TextCellEditor textCellEditor;
	private IterationPlanner iterationPlanner;

	/**
	 * @param viewer viewer
	 * @param iterationPlanner iteration planner
	 */
	public AvailabilityEditingSupport(TableViewer viewer, IterationPlanner iterationPlanner) {
		super(viewer);
		this.iterationPlanner = iterationPlanner;
		this.textCellEditor = new TextCellEditor(viewer.getTable());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
	 */
	@Override
	protected boolean canEdit(Object element) {
		return iterationPlanner.getAssignees().contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
	 */
	@Override
	protected CellEditor getCellEditor(Object element) {
		return textCellEditor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
	 */
	@Override
	protected Object getValue(Object element) {

		if (element instanceof User) {

			return iterationPlanner.getAvailability((User) element) + "";
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected void setValue(Object element, Object value) {
		if (!(element instanceof User)) {
			return;
		}

		User user = (User) element;
		if (value instanceof String) {
			String strValue = value.toString();
			if (strValue.matches("[0-9]*")) {
				iterationPlanner.setAvailability(user, Integer.parseInt(strValue));
				getViewer().refresh();
			}
		}

	}

}

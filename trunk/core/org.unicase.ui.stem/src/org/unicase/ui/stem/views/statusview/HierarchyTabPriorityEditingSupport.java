/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkItem;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Editingsupport for the priority column.
 * 
 * @author helming
 */
public class HierarchyTabPriorityEditingSupport extends EditingSupport {
	private TextCellEditor textCellEditor;

	/**
	 * . Constructor
	 * 
	 * @param viewer the viewer containing this column
	 */
	public HierarchyTabPriorityEditingSupport(TreeViewer viewer) {
		super(viewer);
		this.textCellEditor = new TextCellEditor(viewer.getTree());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
	 */
	@Override
	protected boolean canEdit(Object element) {

		return element instanceof FunctionalRequirement || element instanceof WorkItem;
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
		if (element instanceof FunctionalRequirement) {
			return ((FunctionalRequirement) element).getPriority() + "";
		} else if (element instanceof WorkItem) {
			return ((WorkItem) element).getPriority() + "";
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
		if (!(value instanceof String)) {
			return;
		}
		if (!(element instanceof EObject)) {
			return;
		}
		String strValue = value.toString();
		if (strValue.matches("[0-9]*")) {
			doSetValue((EObject) element, Integer.parseInt(strValue));
			getViewer().update(element, null);
		}

	}

	private void doSetValue(final EObject element, final int priority) {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				if (element instanceof FunctionalRequirement) {
					((FunctionalRequirement) element).setPriority(priority);
				} else if (element instanceof WorkItem) {
					((WorkItem) element).setPriority(priority);
				}
			}
		}.run();

	}
}

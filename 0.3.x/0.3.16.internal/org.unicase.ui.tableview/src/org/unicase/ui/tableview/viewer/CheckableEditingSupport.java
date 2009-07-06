/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.viewer;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.unicase.model.task.Checkable;

/**
 * Editing support for a checkbox column.
 * 
 * @author helming
 */
public class CheckableEditingSupport extends EditingSupport {

	private CheckboxCellEditor cellEditor;

	/**
	 * default constructor.
	 * 
	 * @param viewer The viewer
	 */
	public CheckableEditingSupport(TableViewer viewer) {
		super(viewer);
		cellEditor = new CheckboxCellEditor();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean canEdit(Object element) {
		return (element instanceof Checkable);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CellEditor getCellEditor(Object element) {
		if (element instanceof Checkable) {
			return cellEditor;
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TableViewer getViewer() {
		return (TableViewer) super.getViewer();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object getValue(Object element) {
		if (element instanceof Checkable) {
			return ((Checkable) element).isChecked();
		}

		else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setValue(Object element, Object value) {
		if ((element instanceof Checkable) && (value instanceof Boolean)) {
			final Checkable c = (Checkable) element;
			final boolean isChecked = (Boolean) value;
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(c);
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					c.setChecked(isChecked);
				}
			});
		}
		getViewer().refresh(element);
	}
}

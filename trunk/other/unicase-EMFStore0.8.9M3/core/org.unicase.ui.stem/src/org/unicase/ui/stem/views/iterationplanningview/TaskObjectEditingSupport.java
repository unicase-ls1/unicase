/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.iterationplanningview;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;

/**
 * . Editing support for annotated model element column in IterationPlaningView
 * 
 * @author Helming
 */
public class TaskObjectEditingSupport extends EditingSupport {

	/**
	 * . Constructor
	 * 
	 * @param viewer the ColumnViewer
	 */
	public TaskObjectEditingSupport(ColumnViewer viewer) {
		super(viewer);
		// JH Auto-generated constructor stub
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	protected boolean canEdit(Object element) {
		// JH Auto-generated method stub
		return false;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	protected CellEditor getCellEditor(Object element) {
		// JH Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	protected Object getValue(Object element) {
		// JH Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	protected void setValue(Object element, Object value) {
		// JH Auto-generated method stub

	}

}

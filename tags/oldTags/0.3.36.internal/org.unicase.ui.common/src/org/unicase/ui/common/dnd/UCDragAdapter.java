/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.dnd;

import java.util.List;

import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DragSourceEvent;

/**
 * This class is just a ViewerDragAdpter, with the difference that in dragStart event the selection is extracted from
 * viewer and set as drag source in DragSourcePlaceHolder.
 * 
 * @author Hodaie
 */
public class UCDragAdapter extends ViewerDragAdapter {

	/**
	 * Constructor.
	 * 
	 * @param viewer The viewer
	 */
	public UCDragAdapter(Viewer viewer) {
		super(viewer);

	}

	/**
	 * {@inheritDoc} This method extracts the viewer's selection and sets it as drag source in DragSourcePlaceHolder.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void dragStart(DragSourceEvent event) {
		super.dragStart(event);

		List<Object> dragSource = null;
		ISelection sel = viewer.getSelection();
		if (sel instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) sel;
			dragSource = ssel.toList();
		}

		DragSourcePlaceHolder.setDragSource(dragSource);

	}

}

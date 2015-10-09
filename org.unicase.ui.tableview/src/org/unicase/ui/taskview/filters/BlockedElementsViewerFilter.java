/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.taskview.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.util.MEState;

/**
 * Filter to filter blocked elements.
 * 
 * @author helming
 */
public class BlockedElementsViewerFilter extends ViewerFilter {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof UnicaseModelElement) {

			return !((UnicaseModelElement) element).getState().equals(MEState.BLOCKED);

		}
		return true;
	}

}

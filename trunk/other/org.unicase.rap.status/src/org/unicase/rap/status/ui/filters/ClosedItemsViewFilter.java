/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.status.ui.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.unicase.model.task.Checkable;

/**
 * 
 * 
 * @author Fatih Ulusoy
 */
public class ClosedItemsViewFilter extends ViewerFilter {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return ((element instanceof Checkable) && (!((Checkable) element).isChecked()));
		
//		if (element instanceof UnicaseModelElement) {
//			UnicaseModelElement workItem = (UnicaseModelElement) element;
//			
//				return !workItem.getState().equals(MEState.CLOSED);
//		}
//		
//		return false;
	}

}


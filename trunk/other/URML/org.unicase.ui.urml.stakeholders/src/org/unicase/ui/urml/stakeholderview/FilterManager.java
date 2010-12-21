/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview;

import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.ui.navigator.TreeView;

/**
 * Filter manager for applying and removing of filter.
 * 
 * @author kterzieva
 */

public class FilterManager {

	/**
	 * Applies the filter.
	 * 
	 * @param filter the filter
	 */
	public void applyFilter(ViewerFilter filter){
		TreeView.getTreeViewer().setFilters(new ViewerFilter[]{filter});
	}
	
	/**
	 * Removes the filter.
	 * 
	 */

	public void removeFilters() {
		TreeView.getTreeViewer().setFilters(new ViewerFilter[0]);
	}

}

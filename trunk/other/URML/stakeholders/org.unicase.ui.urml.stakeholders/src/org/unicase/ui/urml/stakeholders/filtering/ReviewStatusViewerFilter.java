/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholders.filtering;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.urml.UrmlModelElement;

/**
 * Filters for the review view, which show only the reviewed/unreviewed elements. 
 * @author kterzieva
 *
 */
public class ReviewStatusViewerFilter extends ViewerFilter {
	private boolean selectReviewed;

	/**
	 * The construct.
	 * @param selectReviewed defines which filter is used
	 */
	public ReviewStatusViewerFilter(boolean selectReviewed) {
		this.selectReviewed = selectReviewed;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof UrmlModelElement){
			return ((UrmlModelElement) element).isReviewed()== selectReviewed;
		}
		return true;
	}
};

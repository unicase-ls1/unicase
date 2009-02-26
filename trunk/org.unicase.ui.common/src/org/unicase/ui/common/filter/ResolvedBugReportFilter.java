/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.filter;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.bug.BugReport;
import org.unicase.model.bug.BugStatus;

/**
 * This filter prevents showing of resolved bug reports in viewers.
 *  
 * @author Hodaie
 *
 */
public class ResolvedBugReportFilter extends ViewerFilter {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if(element instanceof BugReport){
			return !((BugReport)element).getStatus().equals(BugStatus.RESOLVED);
		}
		return false;
	}

}

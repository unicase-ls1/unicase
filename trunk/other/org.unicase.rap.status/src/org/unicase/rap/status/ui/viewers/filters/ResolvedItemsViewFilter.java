package org.unicase.rap.status.ui.viewers.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.task.WorkItem;

/**
 * 
 * 
 * @author Fatih Ulusoy
 */
public class ResolvedItemsViewFilter extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return ((element instanceof WorkItem) && (!((WorkItem) element).isResolved()));
	}

}

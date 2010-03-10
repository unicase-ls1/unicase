package org.unicase.ui.web.projectview.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.util.MEState;

/**
 * Filter to filter open items.
 * 
 * @author Fatih Ulusoy
 */
public class OpenItemsViewFilter extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		if (element instanceof WorkItem) {
			WorkItem workItem = (WorkItem) element;
			
			return workItem.getState().equals(MEState.OPEN);
		}
		
		return false;
	}

}

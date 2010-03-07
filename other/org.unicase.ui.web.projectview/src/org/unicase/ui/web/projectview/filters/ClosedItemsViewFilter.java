package org.unicase.ui.web.projectview.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.task.WorkItem;

public class ClosedItemsViewFilter extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		if (element instanceof WorkItem) {
			WorkItem workItem = (WorkItem) element;
			
			String str = workItem.getState();
			if(str.equalsIgnoreCase("closed"))
				return true;
		}
		
		return false;
	}

}

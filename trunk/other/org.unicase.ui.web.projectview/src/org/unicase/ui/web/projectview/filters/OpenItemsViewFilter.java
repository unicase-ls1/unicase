package org.unicase.ui.web.projectview.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.task.WorkItem;

public class OpenItemsViewFilter extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		if (element instanceof WorkItem) {
			WorkItem workItem = (WorkItem) element;
			
			System.out.println(workItem.getContainingWorkpackage().getName());
			System.out.println(workItem.getName());
			System.out.println(workItem.getState());
			
			String str = workItem.getState();
			if(str.equalsIgnoreCase("open"))
				return true;
			
		}
		
		return false;
	}

}

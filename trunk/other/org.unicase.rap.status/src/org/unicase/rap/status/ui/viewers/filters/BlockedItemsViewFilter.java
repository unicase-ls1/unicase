package org.unicase.rap.status.ui.viewers.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.task.util.MEState;
import org.unicase.model.UnicaseModelElement;


/**
 * Filter to filter blocked items.
 * 
 * @author Fatih Ulusoy
 */
public class BlockedItemsViewFilter extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		
		if (element instanceof UnicaseModelElement) {
			return !((UnicaseModelElement) element).getState().equals(MEState.BLOCKED);
		}
		
		return true;
	}

}

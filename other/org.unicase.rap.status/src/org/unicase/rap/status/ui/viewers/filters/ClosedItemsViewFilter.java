package org.unicase.rap.status.ui.viewers.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.task.Checkable;

/**
 * 
 * 
 * @author Fatih Ulusoy
 */
public class ClosedItemsViewFilter extends ViewerFilter {

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

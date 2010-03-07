package org.unicase.ui.web.projectview.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.task.Checkable;

public class ResolvedItemsViewFilter extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return ((element instanceof Checkable) && (((Checkable) element).isChecked()));
	}

}

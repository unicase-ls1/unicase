package org.unicase.ui.taskview;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.ModelElement;
import org.unicase.model.task.util.MEState;

/**
 * Filter to filter blocked elements.
 * 
 * @author helming
 * 
 */
public class BlockedElementsViewerFilter extends ViewerFilter {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof ModelElement) {

			return !((ModelElement) element).getState().equals(MEState.BLOCKED);

		}
		return true;
	}

}

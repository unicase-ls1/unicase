package org.unicase.model.urml.ui.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry;

/**
 * @generated
 */
public class UrmlNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 2003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof UrmlNavigatorItem) {
			UrmlNavigatorItem item = (UrmlNavigatorItem) element;
			return UrmlVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

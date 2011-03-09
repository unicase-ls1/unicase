package org.unicase.ui.diagram.urml.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.unicase.ui.diagram.urml.part.UrmlVisualIDRegistry;

/**
 * @generated
 */
public class UrmlNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 4049;

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

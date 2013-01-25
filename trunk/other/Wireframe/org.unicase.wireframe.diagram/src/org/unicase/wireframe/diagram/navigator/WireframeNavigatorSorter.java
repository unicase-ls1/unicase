package org.unicase.wireframe.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.unicase.wireframe.diagram.part.WireframeVisualIDRegistry;

/**
 * @generated
 */
public class WireframeNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof WireframeNavigatorItem) {
			WireframeNavigatorItem item = (WireframeNavigatorItem) element;
			return WireframeVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

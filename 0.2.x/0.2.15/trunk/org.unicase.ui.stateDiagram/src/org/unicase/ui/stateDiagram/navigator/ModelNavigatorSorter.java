package org.unicase.ui.stateDiagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class ModelNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 4003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof org.unicase.ui.stateDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.stateDiagram.navigator.ModelNavigatorItem item = (org.unicase.ui.stateDiagram.navigator.ModelNavigatorItem) element;
			return org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
					.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

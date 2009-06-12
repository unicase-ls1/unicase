package org.unicase.ui.urmlDiagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class ModelNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 4012;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof org.unicase.ui.urmlDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.urmlDiagram.navigator.ModelNavigatorItem item = (org.unicase.ui.urmlDiagram.navigator.ModelNavigatorItem) element;
			return org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
					.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

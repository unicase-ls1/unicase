package org.unicase.ui.usecaseDiagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class ModelNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 1004;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem item = (org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem) element;
			return org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
					.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

package org.unicase.ui.workItemDiagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class ModelNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 4005;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof org.unicase.ui.workItemDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.workItemDiagram.navigator.ModelNavigatorItem item = (org.unicase.ui.workItemDiagram.navigator.ModelNavigatorItem) element;
			return org.unicase.ui.workItemDiagram.part.ModelVisualIDRegistry
					.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

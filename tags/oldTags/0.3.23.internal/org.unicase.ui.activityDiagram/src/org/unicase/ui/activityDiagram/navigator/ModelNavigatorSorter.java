package org.unicase.ui.activityDiagram.navigator;

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
		if (element instanceof org.unicase.ui.activityDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.activityDiagram.navigator.ModelNavigatorItem item = (org.unicase.ui.activityDiagram.navigator.ModelNavigatorItem) element;
			return org.unicase.ui.activityDiagram.part.ModelVisualIDRegistry
					.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

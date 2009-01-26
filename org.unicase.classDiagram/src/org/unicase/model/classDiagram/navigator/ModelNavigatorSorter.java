package org.unicase.model.classDiagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class ModelNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7004;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof org.unicase.model.classDiagram.navigator.ModelNavigatorItem) {
			org.unicase.model.classDiagram.navigator.ModelNavigatorItem item = (org.unicase.model.classDiagram.navigator.ModelNavigatorItem) element;
			return org.unicase.model.classDiagram.part.ModelVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

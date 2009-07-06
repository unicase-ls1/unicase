package org.unicase.ui.tom.classDiagram.navigator;

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
		if (element instanceof org.unicase.ui.tom.classDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.tom.classDiagram.navigator.ModelNavigatorItem item = (org.unicase.ui.tom.classDiagram.navigator.ModelNavigatorItem) element;
			return org.unicase.ui.tom.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

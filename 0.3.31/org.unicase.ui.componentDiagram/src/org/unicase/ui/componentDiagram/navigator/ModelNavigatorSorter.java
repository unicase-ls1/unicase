package org.unicase.ui.componentDiagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class ModelNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 4004;

	/**
	 * @generated
	 */
	@Override
	public int category(Object element) {
		if (element instanceof org.unicase.ui.componentDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.componentDiagram.navigator.ModelNavigatorItem item = (org.unicase.ui.componentDiagram.navigator.ModelNavigatorItem) element;
			return org.unicase.ui.componentDiagram.part.ModelVisualIDRegistry
					.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

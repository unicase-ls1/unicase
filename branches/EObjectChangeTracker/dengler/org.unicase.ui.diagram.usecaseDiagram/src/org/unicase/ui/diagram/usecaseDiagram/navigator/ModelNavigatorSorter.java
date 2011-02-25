package org.unicase.ui.diagram.usecaseDiagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class ModelNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 4006;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof org.unicase.ui.diagram.usecaseDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.diagram.usecaseDiagram.navigator.ModelNavigatorItem item = (org.unicase.ui.diagram.usecaseDiagram.navigator.ModelNavigatorItem) element;
			return org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
					.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

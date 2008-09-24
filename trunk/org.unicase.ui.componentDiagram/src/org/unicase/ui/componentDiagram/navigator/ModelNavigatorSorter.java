package org.unicase.ui.componentDiagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class ModelNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 3004;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 3003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof org.unicase.ui.componentDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.componentDiagram.navigator.ModelNavigatorItem item = (org.unicase.ui.componentDiagram.navigator.ModelNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return org.unicase.ui.componentDiagram.part.ModelVisualIDRegistry
					.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

package org.unicase.ui.usecaseDiagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class ModelNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 3006;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 3005;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem item = (org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
					.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

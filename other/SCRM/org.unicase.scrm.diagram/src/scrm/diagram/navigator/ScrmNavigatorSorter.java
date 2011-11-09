package scrm.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import scrm.diagram.part.ScrmVisualIDRegistry;

/**
 * @generated
 */
public class ScrmNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7009;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof ScrmNavigatorItem) {
			ScrmNavigatorItem item = (ScrmNavigatorItem) element;
			return ScrmVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

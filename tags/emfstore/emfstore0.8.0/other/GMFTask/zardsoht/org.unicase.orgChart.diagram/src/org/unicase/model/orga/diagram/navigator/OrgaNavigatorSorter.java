package org.unicase.model.orga.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.unicase.model.orga.diagram.part.OrgaVisualIDRegistry;

/**
 * @generated
 */
public class OrgaNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 4003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof OrgaNavigatorItem) {
			OrgaNavigatorItem item = (OrgaNavigatorItem) element;
			return OrgaVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

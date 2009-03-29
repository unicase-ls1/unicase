/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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
	public int category(Object element) {
		if (element instanceof org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem item = (org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem) element;
			return org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

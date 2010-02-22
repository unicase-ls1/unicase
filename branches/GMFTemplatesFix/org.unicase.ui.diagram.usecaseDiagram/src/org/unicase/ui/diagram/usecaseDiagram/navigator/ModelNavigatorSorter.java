/*
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 *   accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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

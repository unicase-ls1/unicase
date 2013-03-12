/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class UiModelingNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7009;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem) {
			org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem item = (org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem) element;
			return org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

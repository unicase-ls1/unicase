/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * Helper class for selection.
 * 
 * @author herrmi
 */
public final class SelectionHelper {

	private SelectionHelper() {
		// nothing to do
	}

	/**
	 * Get the selected element of type V.
	 * 
	 * @param <V> the type
	 * @param structuredSelection the selection
	 * @return the selected element
	 */
	@SuppressWarnings("unchecked")
	public static <V> V getSelectedElement(IStructuredSelection structuredSelection) {
		if (structuredSelection.isEmpty()) {
			return null;
		}
		return (V) structuredSelection.getFirstElement();
	}

	/**
	 * Get a list of selected elements of type V.
	 * 
	 * @param <V> the type
	 * @param structuredSelection the selection
	 * @return a list of elements
	 */
	@SuppressWarnings("unchecked")
	public static <V> List<V> getSelectedElements(IStructuredSelection structuredSelection) {
		List<V> elements = new ArrayList<V>();
		for (Iterator i = structuredSelection.iterator(); i.hasNext();) {
			elements.add((V) i.next());
		}
		return elements;
	}

}

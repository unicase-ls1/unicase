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

public class SelectionHelper {

	public static <V> V getSelectedElement(
			IStructuredSelection structuredSelection) {
		if (structuredSelection.isEmpty()) {
			return null;
		}
		return (V) structuredSelection.getFirstElement();
	}

	public static <V> List<V> getSelectedElements(
			IStructuredSelection structuredSelection) {
		List<V> elements = new ArrayList<V>();
		for (Iterator i = structuredSelection.iterator(); i.hasNext();) {
			elements.add((V) i.next());
		}
		return elements;
	}

}

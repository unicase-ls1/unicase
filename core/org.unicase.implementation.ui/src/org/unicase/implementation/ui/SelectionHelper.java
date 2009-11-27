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

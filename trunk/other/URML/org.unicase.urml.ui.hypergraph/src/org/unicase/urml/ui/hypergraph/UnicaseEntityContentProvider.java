package org.unicase.urml.ui.hypergraph;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.ProjectSpace;

public class UnicaseEntityContentProvider extends ArrayContentProvider implements IGraphEntityContentProvider {

	public Object[] getConnectedTo(Object arg0) {
		LinkedList<Object> result = new LinkedList<Object>();
		if (arg0 instanceof EObject) {
			EObject element = (EObject) arg0;
			result.addAll(element.eContents());
			EObject parent = element.eContainer();
			if (parent != null && !(parent instanceof ProjectSpace)) {
				result.add(parent);
			} else if (parent == null && element instanceof ModelElement) {
				result.add(((ModelElement) element).getProject());
			}
		}
		return result.toArray();
	}
}
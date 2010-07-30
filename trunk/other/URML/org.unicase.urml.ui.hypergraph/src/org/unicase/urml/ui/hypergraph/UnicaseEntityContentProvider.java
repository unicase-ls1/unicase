package org.unicase.urml.ui.hypergraph;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.ProjectSpace;

public class UnicaseEntityContentProvider extends ArrayContentProvider implements IGraphEntityContentProvider {

	public Object[] getConnectedTo(Object arg0) {
		ArrayList<Object> result = new ArrayList<Object>();
		if (arg0 instanceof ProjectSpace) {
			result.addAll(((ProjectSpace) arg0).getProject().getModelElements());
		} else if (arg0 instanceof ModelElement) {
			result.addAll(((ModelElement) arg0).getContainedElements());
			result.addAll(((ModelElement) arg0).getCrossReferencedModelElements());
		}
		return result.toArray();
	}
}
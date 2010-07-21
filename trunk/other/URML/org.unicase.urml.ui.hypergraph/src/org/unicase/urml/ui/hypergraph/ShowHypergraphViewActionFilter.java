package org.unicase.urml.ui.hypergraph;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IActionFilter;
import org.unicase.model.urml.UrmlModelElement;

public class ShowHypergraphViewActionFilter implements IActionFilter {
	public boolean testAttribute(Object target, String name, String value) {
		if (name.equals("type") && value.equals("urml")) {
			if (((View) ((EditPart) target).getModel()).getElement() instanceof UrmlModelElement) {
				return true;
			}
		}
		return false;
	}
}

package org.unicase.ui.tom.classDiagram.unicase;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;

public class TouchSelectionEditPolicy extends SelectionEditPolicy 
	implements IAdaptable{

	@Override
	protected void hideSelection() {
		
	}

	@Override
	protected void showSelection() {
		
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {

		return null;
	}

}

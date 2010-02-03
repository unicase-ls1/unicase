package org.unicase.ui.tom.classDiagram.edit.parts;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.ui.tom.tools.TouchSelectConnectionEditPartTracker;

/**
 * @generated
 */
public class Association4EditPart extends org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart implements
		ITreeBranchEditPart {

	public Association4EditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public DragTracker getDragTracker(Request req) {
		return new TouchSelectConnectionEditPartTracker(this);
	}
	
}

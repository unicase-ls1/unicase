package org.unicase.ui.tom.classDiagram.edit.parts;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.ui.tom.tools.TouchSelectConnectionEditPartTracker;

/**
 * @generated
 */
public class DependencyEditPart extends org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart implements
		ITreeBranchEditPart {

	public DependencyEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @generated NOT
	 */
	@Override
	public DragTracker getDragTracker(Request req) {
		return new TouchSelectConnectionEditPartTracker(this);
	}

}

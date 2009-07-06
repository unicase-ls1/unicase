package org.unicase.ui.tom.actions;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.operations.AbstractOperation;

public abstract class AbstractAction extends AbstractOperation implements Action {

	public AbstractAction(DiagramEditPart diagramEditPart) {
		super(diagramEditPart);
	}
	
	public void execute() {
		// TODO Auto-generated method stub

	}

}

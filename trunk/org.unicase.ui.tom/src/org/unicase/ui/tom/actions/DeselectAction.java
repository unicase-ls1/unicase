package org.unicase.ui.tom.actions;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.swt.widgets.Display;

public class DeselectAction extends AbstractAction {
	
	private GraphicalEditPart targetEditPart;

	public DeselectAction(DiagramEditPart diagramEditPart, GraphicalEditPart targetEditPart) {
		super(diagramEditPart);
		this.setTargetEditPart(targetEditPart);
	}

	public void execute() {
		Runnable runnable = new Runnable(){
			public void run(){
				diagramEditPart.getViewer().deselect(targetEditPart);
			}
		};
		
		Display.getDefault().syncExec(runnable);
	}

	public GraphicalEditPart getTargetEditPart() {
		return targetEditPart;
	}

	public void setTargetEditPart(GraphicalEditPart targetEditPart) {
		this.targetEditPart = targetEditPart;
	}
}

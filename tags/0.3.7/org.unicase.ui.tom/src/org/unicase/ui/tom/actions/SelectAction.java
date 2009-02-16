package org.unicase.ui.tom.actions;

import org.eclipse.draw2d.RangeModel;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.swt.widgets.Display;

public class SelectAction extends AbstractAction{

	private GraphicalEditPart targetEditPart;

	public SelectAction(DiagramEditPart diagramEditPart, GraphicalEditPart targetEditPart) {
		super(diagramEditPart);
		this.setTargetEditPart(targetEditPart);
	}

	public void execute() {
		Runnable runnable = new Runnable(){
			public void run(){
				diagramEditPart.getViewer().select(targetEditPart);
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

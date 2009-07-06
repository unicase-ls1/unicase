package org.unicase.ui.tom.actions;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.swt.widgets.Display;

public class DeselectAllAction extends AbstractAction {

	public DeselectAllAction(DiagramEditPart diagramEditPart) {
		super(diagramEditPart);
	}

	public void execute() {
		Runnable runnable = new Runnable(){
			public void run(){
				diagramEditPart.getViewer().deselectAll();
			}
		};
		
		Display.getDefault().syncExec(runnable);
	}
}

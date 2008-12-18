package org.unicase.ui.tom.gestures;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.notifications.GestureNotifier;

public interface Gesture extends GestureNotifier{

	public boolean getAcceptsTouches();
	
	public boolean getCanExecute();
	
	public void execute();
	
	public void reset();

	public DiagramEditPart getDiagramEditPart();

	public void setDiagramEditPart(DiagramEditPart editor); 
}

package org.unicase.ui.tom.gestures;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.notifications.GestureNotifier;

/**
 * @author schroech
 *
 */
public interface Gesture extends GestureNotifier{

	/**
	 * Indicates if a gesture accepts the current constellation of touches.
	 * Acceptance means it may be able to interpret the 
	 * touches and may become executable in the future. 
	 * @return the touch acceptance state 
	 */
	boolean getAcceptsTouches();
	
	/**
	 * Indicates the gesture's ability to execute.
	 * It is up to the gesture interpreter to decide 
	 * whether this gesture should be executed
	 * @return the execution state
	 */
	boolean getCanExecute();
	
	/**
	 * Executes the gesture.
	 */
	void execute();
	
	/**
	 * Resets the gesture.
	 * Sets volatile fields to null, 
	 * sets touch acceptance state to true, 
	 * sets execution state to false
	 */
	void reset();

	DiagramEditPart getDiagramEditPart();

	void setDiagramEditPart(DiagramEditPart editor); 
}

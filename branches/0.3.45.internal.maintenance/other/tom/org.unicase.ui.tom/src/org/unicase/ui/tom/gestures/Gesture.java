/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.notifications.GestureNotifier;
import org.unicase.ui.tom.touches.MultiTouch;

/**
 * @author schroech
 *
 */
public interface Gesture extends GestureNotifier{

	/**
	 * Indicates the gesture's ability to execute.
	 * It is up to the gesture interpreter to decide 
	 * whether this gesture should be executed
	 * @return the execution state
	 */
	boolean canExecute();
	
	void setCanExecute(boolean canExecute);
	
	/**
	 * Executes the gesture.
	 */
	void execute();
	
	/**
	 * Indicates if a gesture accepts the current constellation of touches.
	 * Acceptance means it may be able to interpret the 
	 * touches and may become executable in the future. 
	 * @return the touch acceptance state 
	 */
	boolean acceptsAdditionalTouches();
	
	/**
	 * Resets the gesture.
	 * Sets volatile fields to null, 
	 * sets touch acceptance state to true, 
	 * sets execution state to false
	 */
	void reset(); 
	
	/**
	 * @return The priority of the gesture
	 */
	int getPriority();
	
	/**
	 * @param priority The priority of the gesture
	 */
	void setPriority(int priority);
	
	List<MultiTouch> getMandatoryTouches();
	
	List<MultiTouch> getOptionalTouches();
	
	DiagramEditPart getDiagramEditPart();
	
	void setDiagramEditPart(DiagramEditPart editor);
	
	List<Gesture> getRestrictingGestures();
	
	void setRestrictingGestures(List<Gesture> restrictingGestures);	
}

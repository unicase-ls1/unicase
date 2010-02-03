/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
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
	
	/**
	 * @param canExecute Indicates the gesture's ability to execute.
	 * It is up to the gesture interpreter to decide 
	 * whether this gesture should be executed
	 */
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
	
	/**
	 * @return The touches mandatory for the execution of this gesture
	 */
	List<MultiTouch> getMandatoryTouches();
	
	/**
	 * @return The touches optional for the execution of this gesture
	 */
	List<MultiTouch> getOptionalTouches();
	
	/**
	 * @return The diagram edit part which this gesture acts upon
	 */
	DiagramEditPart getDiagramEditPart();
	
	/**
	 * @param editor The diagram edit part which this gesture acts upon
	 */
	void setDiagramEditPart(DiagramEditPart editor);
	
	/**
	 * @return The gestures which can not be executed concurrently with this gesture 
	 */
	List<Gesture> getRestrictingGestures();
	
	/**
	 * @param restrictingGestures The gestures which can not be executed concurrently with this gesture
	 */
	void setRestrictingGestures(List<Gesture> restrictingGestures);	
}

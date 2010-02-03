/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.touches;

import java.util.Date;

import org.eclipse.draw2d.geometry.Point;

/**
 * @author schroech
 *
 */
public interface Touch{

	/**
	 * @param multiTouch The multi-touch subsuming this touch  
	 */
	void setMultiTouch(MultiTouch multiTouch);
	
	/**
	 * @return The multi-touch subsuming this touch
	 */
	MultiTouch getMultiTouch();
	
	/**
	 * @param claimed A touch is claimed if it is associated to a gesture
	 */
	void setClaimed(boolean claimed);
	
	/**
	 * @return A touch is claimed if it is associated to a gesture
	 */
	boolean isClaimed();
	
	/**
	 * @return The screen relative position of the touch
	 */
	Point getPosition();
	
	/**
	 * @return The screen relative x position of the touch
	 */
	int getX();
	
	
	/**
	 * @return The screen relative y position of the touch
	 */
	int getY();
	
	/**
	 * @return The absolute position of the touch
	 */
	Point getAbsolutePosition();
	
	/**
	 * @return The absolute x position of the touch
	 */
	int getAbsoluteX();
	
	/**
	 * @return The absolute y position of the touch
	 */
	int getAbsoluteY();

	/**
	 * @return The {@link Date} the touch went up
	 */
	Date getTouchUpDate();
	
	/**
	 * @return The {@link Date} the touch went down
	 */
	Date getTouchDownDate();
	
	/**
	 * @return The time between the touch up and touch down {@link Date}
	 */
	long getLifeSpan();
}

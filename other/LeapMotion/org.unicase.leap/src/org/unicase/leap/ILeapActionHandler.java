/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap;

import com.leapmotion.leap.Gesture;

/**
 * Interface for the leap action extension point. Any extensions defined must also specify an implementation of this
 * interface.
 * 
 * @author mharut
 */
public interface ILeapActionHandler {

	/**
	 * Processes a {@link Gesture}. The type of the gesture depends on the type specified by the corresponding
	 * extension. This will be called whenever a gesture is captured within a leap motion Frame.
	 * 
	 * @param gesture the {@link Gesture} to process
	 */
	void processGesture(Gesture gesture);

}

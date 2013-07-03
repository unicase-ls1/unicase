/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.events;

import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Pointable;

/**
 * Event class to provide information about {@link Gesture} events that occurred while using the leap motion sensor.
 * 
 * @author mharut
 */
public class LeapGestureEvent extends LeapInputEvent {

	/**
	 * This event's underlying {@link Gesture}.
	 */
	private final Gesture gesture;

	/**
	 * Constructs a new event for a gesture and the time at which the gesture occurred.
	 * 
	 * @param gesture the {@link Gesture} which was performed by the user
	 * @param time the time in milliseconds at which the gesture was performed
	 */
	public LeapGestureEvent(Gesture gesture, long time) {
		super(gesture.frame(), time);
		this.gesture = gesture;
	}

	/**
	 * Checks whether or not {@link com.leapmotion.Finger Fingers} were involved in this event's underlying gesture.
	 * 
	 * @return whether or not fingers were involved in the gesture
	 */
	public boolean isFingersInvolved() {
		for (Pointable pointable : getGesture().pointables()) {
			if (!pointable.isValid()) {
				continue;
			}
			if (pointable.isFinger()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks whether or not {@link com.leapmotion.Tool Tools} were involved in this event's underlying gesture.
	 * 
	 * @return whether or not tools were involved in the gesture
	 */
	public boolean isToolsInvolved() {
		for (Pointable pointable : getGesture().pointables()) {
			if (!pointable.isValid()) {
				continue;
			}
			if (pointable.isTool()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retrieves this event's underlying {@link Gesture}.
	 * 
	 * @return the gesture which was performed by the user
	 */
	public Gesture getGesture() {
		return gesture;
	}

}

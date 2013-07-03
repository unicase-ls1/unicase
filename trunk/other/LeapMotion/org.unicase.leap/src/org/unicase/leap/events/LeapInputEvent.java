/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.events;

import com.leapmotion.leap.Frame;

/**
 * Event used to provide input information about occuring leap events.
 * 
 * @author mharut
 */
public abstract class LeapInputEvent {

	/**
	 * The leap {@link Frame} at which the input was performed.
	 */
	private final Frame frame;
	/**
	 * The time in milliseconds at which the input was performed.
	 */
	private final long time;

	/**
	 * Constructs a new input event for a leap frame and the time at which the input was performed.
	 * 
	 * @param frame the {@link Frame} at which the input was performed
	 * @param time the time in milliseconds as an unsigned integer (to conform with SWT event standards)
	 * @see #LeapInputEvent(Frame, long)
	 */
	public LeapInputEvent(Frame frame, int time) {
		this.frame = frame;
		this.time = time & 0xFFFFFFFFL; // transform unsigned int to signed long
	}

	/**
	 * Constructs a new input event for a leap frame and the time at which the input was performed.
	 * 
	 * @param frame the {@link Frame} at which the input was performed
	 * @param time the time in milliseconds
	 */
	public LeapInputEvent(Frame frame, long time) {
		this.frame = frame;
		this.time = time;
	}

	/**
	 * Retrieves the frame at which the input was performed.
	 * 
	 * @return the leap motion {@link Frame}
	 */
	public Frame getFrame() {
		return frame;
	}

	/**
	 * Retrieves the time at which the input was performed.
	 * 
	 * @return the time in milliseconds
	 */
	public long getTime() {
		return time;
	}
}

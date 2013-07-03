/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.events;

import org.eclipse.swt.events.KeyEvent;

import com.leapmotion.leap.Frame;

/**
 * Event used to provide information regarding keyboard input.
 * 
 * @author mharut
 */
public class LeapKeyEvent extends LeapInputEvent {

	/**
	 * The underlying {@link KeyEvent} which occurred when the input was performed.
	 */
	private final KeyEvent keyEvent;
	/**
	 * The type of the underlying key event.
	 * 
	 * @see org.eclipse.swt.SWT#KeyDown
	 * @see org.eclipse.swt.SWT#KeyUp
	 */
	private final int type;

	/**
	 * Constructs a new leap key event for a frame, an underlying key event and its type.
	 * 
	 * @param frame the leap motion {@link Frame} at which the key input was performed
	 * @param event the underlying {@link KeyEvent} that occurred when the input was performed
	 * @param type the type of the underlying key event
	 * @see org.eclipse.swt.SWT#KeyDown
	 * @see org.eclipse.swt.SWT#KeyUp
	 */
	public LeapKeyEvent(Frame frame, KeyEvent event, int type) {
		super(frame, event.time);
		this.keyEvent = event;
		this.type = type;
	}

	/**
	 * Retrieves this event's underlying key event.
	 * 
	 * @return the underlying {@link KeyEvent} that occurred when the key input was performed
	 */
	public KeyEvent getKeyEvent() {
		return keyEvent;
	}

	/**
	 * Retrieves the type of the underlying {@link KeyEvent}.
	 * 
	 * @return the type of the key event
	 * @see org.eclipse.swt.SWT#KeyDown
	 * @see org.eclipse.swt.SWT#KeyUp
	 */
	public int getType() {
		return type;
	}

}

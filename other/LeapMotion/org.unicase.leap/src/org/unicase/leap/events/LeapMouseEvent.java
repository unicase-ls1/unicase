/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.events;

import org.eclipse.swt.events.MouseEvent;

import com.leapmotion.leap.Frame;

/**
 * Event used to provide information regarding mouse input.
 * 
 * @author mharut
 */
public class LeapMouseEvent extends LeapInputEvent {

	/**
	 * The underlying {@link MouseEvent} which occurred when the input was performed.
	 */
	private final MouseEvent mouseEvent;
	/**
	 * The type of the underlying mouse event.
	 * 
	 * @see org.eclipse.swt.SWT#MouseDown
	 * @see org.eclipse.swt.SWT#MouseUp
	 * @see org.eclipse.swt.SWT#MouseDoubleClick
	 */
	private final int type;

	/**
	 * Constructs a new leap mouse event for a frame, an underlying mouse event and its type.
	 * 
	 * @param frame the leap motion {@link Frame} at which the mouse input was performed
	 * @param event the underlying {@link MouseEvent} that occurred when the input was performed
	 * @param type the type of the underlying mouse event
	 * @see org.eclipse.swt.SWT#MouseDown
	 * @see org.eclipse.swt.SWT#MouseUp
	 * @see org.eclipse.swt.SWT#MouseDoubleClick
	 */
	public LeapMouseEvent(Frame frame, MouseEvent event, int type) {
		super(frame, event.time);
		this.mouseEvent = event;
		this.type = type;
	}

	/**
	 * Retrieves this event's underlying mouse event.
	 * 
	 * @return the underlying {@link MouseEvent} that occurred when the mouse input was performed
	 */
	public MouseEvent getMouseEvent() {
		return mouseEvent;
	}

	/**
	 * Retrieves the type of the underlying {@link MouseEvent}.
	 * 
	 * @return the type of the mouse event
	 * @see org.eclipse.swt.SWT#MouseDown
	 * @see org.eclipse.swt.SWT#MouseUp
	 * @see org.eclipse.swt.SWT#MouseDoubleClick
	 */
	public int getType() {
		return type;
	}
}

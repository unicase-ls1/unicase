/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.listener;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * This {@link Listener} extension listens to mouse events and wraps them in the {@link MouseEvent} class. Afterwards,
 * events are forwarded to the specified {@link LeapInputListener}.
 * 
 * @author mharut
 */
public class MouseListener implements Listener {

	/**
	 * The input listener to forward events to.
	 */
	private final LeapInputListener inputListener;

	/**
	 * Constructs a new mouse listener for a {@link LeapInputListener}.
	 * 
	 * @param inputListener the input listener events will be forwarded to
	 */
	public MouseListener(LeapInputListener inputListener) {
		this.inputListener = inputListener;
	}

	@Override
	public void handleEvent(Event event) {
		MouseEvent mouseEvent = new MouseEvent(event);
		inputListener.handleMouseEvent(mouseEvent, event.type);
	}

}

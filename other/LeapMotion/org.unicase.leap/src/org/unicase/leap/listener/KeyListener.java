/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.listener;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * This {@link Listener} extension listens to key events and wraps them in the {@link KeyEvent} class. Afterwards,
 * events are forwarded to the specified {@link LeapInputListener}.
 * 
 * @author mharut
 */
public class KeyListener implements Listener {

	/**
	 * The input listener to forward events to.
	 */
	private final LeapInputListener inputListener;

	/**
	 * Constructs a new key listener for a {@link LeapInputListener}.
	 * 
	 * @param inputListener the input listener events will be forwarded to
	 */
	public KeyListener(LeapInputListener inputListener) {
		this.inputListener = inputListener;
	}

	@Override
	public void handleEvent(Event event) {
		KeyEvent keyEvent = new KeyEvent(event);
		inputListener.handleKeyEvent(keyEvent, event.type);
	}

}

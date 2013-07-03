/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.input;

/**
 * Class representing mouse input. Every mouse input is defined for a mouse button and can either be a singleclick-input
 * or a doubleclick-input.
 * 
 * @author mharut
 */
public class MouseInput extends ActionInput {

	/**
	 * The code of the mouse button this input is defined for.
	 * 
	 * @see org.eclipse.swt.events.MouseEvent#button
	 */
	private final int button;
	/**
	 * Flag to indicate whether or not this input is a doubleclick-input.
	 */
	private final boolean doubleClick;

	/**
	 * Constructs a new mouse input instance for a mouse button, a flag to indicate whether this is a doubleclick-input
	 * or not and a timeout.
	 * 
	 * @param button the mouse button this input is defined for
	 * @param doubleClick whether or not this input is a doubleclick-input
	 * @param timeout the timeout in milliseconds - if this is 0 or less, there will be no timeout
	 * @see org.eclipse.swt.events.MouseEvent#button
	 */
	public MouseInput(int button, boolean doubleClick, int timeout) {
		super(timeout);
		this.button = button;
		this.doubleClick = doubleClick;
	}

	/**
	 * Retrieves the mouse button this input is defined for.
	 * 
	 * @return the mouse button this input is defined for
	 * @see org.eclipse.swt.events.MouseEvent#button
	 */
	public int getButton() {
		return button;
	}

	/**
	 * Retrieves whether or not this input is a doubleclick-input.
	 * 
	 * @return whether or not this is a doubleclick-input
	 */
	public boolean isDoubleClick() {
		return doubleClick;
	}

}

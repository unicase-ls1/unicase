/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.input;

/**
 * Class representing keyboard input. Every keyboard input has a key code and can either be a push-input or a
 * hold-input. Any input sequence will be discarded, if the key of a hold-input is released. On the other hand,
 * push-inputs are only valid, if the key is pushed and afterwards released.
 * 
 * @author mharut
 */
public class KeyInput extends ActionInput {

	/**
	 * The code of the key this input is defined for.
	 * 
	 * @see org.eclipse.swt.events.KeyEvent#keyCode
	 */
	private final int keyCode;
	/**
	 * Flag to indicate whether this input is a hold-input or not.
	 */
	private final boolean hold;

	/**
	 * Constructs a new key input instance for a key code, a flag to indicate whether this is a hold-input and a
	 * timeout.
	 * 
	 * @param keyCode the code of the key of this input
	 * @param hold whether or not this input is a hold-input
	 * @param timeout timeout in milliseconds after which this input is discarded - if this is 0 or less, there will be
	 *            no timeout
	 * @see org.eclipse.swt.events.KeyEvent#keyCode
	 */
	public KeyInput(int keyCode, boolean hold, int timeout) {
		super(timeout);
		this.keyCode = keyCode;
		this.hold = hold;
	}

	/**
	 * Retrieves the key code this input is defined for.
	 * 
	 * @return the key code of this input
	 * @see org.eclipse.swt.events.KeyEvent#keyCode
	 */
	public int getKey() {
		return keyCode;
	}

	/**
	 * Retrieves whether or not this input is a hold-input.
	 * 
	 * @return whether or not this is a hold-input
	 */
	public boolean isHold() {
		return hold;
	}

}

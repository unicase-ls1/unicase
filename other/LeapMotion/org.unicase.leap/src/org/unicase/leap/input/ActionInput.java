/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.input;

/**
 * Abstract class to define basic input definitions for leap actions.
 * 
 * @author mharut
 */
public abstract class ActionInput {

	/**
	 * The timeout of this input in milliseconds, before it is discarded. If this is 0 or less, there is no timeout.
	 */
	private final int timeout;

	/**
	 * Constructs a new input instance for a specified timeout.
	 * 
	 * @param timeout the timeout before this input is discarded - if this is 0 or less, there is no timeout
	 */
	public ActionInput(int timeout) {
		this.timeout = timeout;
	}

	/**
	 * Retrieves the timeout of this input.
	 * 
	 * @return the timeout in milliseconds, before this input is discarded
	 */
	public int getTimeout() {
		return timeout;
	}

}

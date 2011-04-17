/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.unicase.emfstore.jdt.exception;

/**
 * Will be thrown if the state between the team synchronizer and the EMF Store cannot be synchronized.
 * 
 * @author Adrian Staudt
 */
@SuppressWarnings("serial")
public class CannotSyncFileException extends Exception {

	private boolean wasHarmless;

	/**
	 * Constructor.
	 */
	public CannotSyncFileException() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param wasHarmless Sometimes synchronization fails, but this is still okay. If a file is newly pushed, there is
	 *            no state that can be synchronized.
	 */
	public CannotSyncFileException(boolean wasHarmless) {
		this.wasHarmless = wasHarmless;
	}

	/**
	 * Tells if this exception is a serious one or not.
	 * 
	 * @return True if this exception does not lead to an error sate, false otherwise.
	 */
	public boolean wasHarmless() {
		return wasHarmless;
	}

}

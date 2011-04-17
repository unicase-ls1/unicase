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
 * General exception if interacting with a team synchronizer.
 * 
 * @author Adrian Staudt
 */
@SuppressWarnings("serial")
public class TeamSynchronizerException extends Exception {

	/**
	 * Constructor.
	 * 
	 * @param string Cause why this exception has been raised.
	 */
	public TeamSynchronizerException(String string) {
		super(string);
	}

	/**
	 * Constructor.
	 * 
	 * @param reason Cause why this exception has been raised.
	 */
	public TeamSynchronizerException(Exception reason) {
		super(reason);
	}

}

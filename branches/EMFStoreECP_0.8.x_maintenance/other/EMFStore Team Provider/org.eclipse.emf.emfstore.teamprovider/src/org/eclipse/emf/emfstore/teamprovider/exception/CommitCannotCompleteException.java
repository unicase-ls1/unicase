/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider.exception;

/**
 * The commit process cannot be completed.
 * 
 * @author Adrian Staudt
 */
@SuppressWarnings("serial")
public class CommitCannotCompleteException extends Exception {

	/**
	 * Constructor.
	 * 
	 * @param reason Cause why this exception has been raised.
	 */
	public CommitCannotCompleteException(Exception reason) {
		super(reason);
	}

}

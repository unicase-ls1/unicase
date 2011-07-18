/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.exception;

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

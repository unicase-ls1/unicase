/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.exceptions;

/**
 * Represents an internal error of the iterator.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class IteratorException extends Exception {

	/**
	 * {@inheritDoc}
	 * 
	 * @see Exception#Exception(String, Throwable).
	 */
	public IteratorException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see Exception#Exception(String)
	 */
	public IteratorException(String message) {
		super(message);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see Exception#Exception(Throwable)
	 */
	public IteratorException(Throwable cause) {
		super(cause);
	}

}

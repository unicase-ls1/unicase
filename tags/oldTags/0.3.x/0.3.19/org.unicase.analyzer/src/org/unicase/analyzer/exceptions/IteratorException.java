/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */
package org.unicase.analyzer.exceptions;

@SuppressWarnings("serial")
public class IteratorException extends Exception {

	public IteratorException(String message, Throwable cause) {
		super(message, cause);
	}

	public IteratorException(String message) {
		super(message);
	}

	public IteratorException(Throwable cause) {
		super(cause);
	}

}

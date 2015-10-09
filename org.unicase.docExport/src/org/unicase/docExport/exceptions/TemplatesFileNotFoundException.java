/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exceptions;

/**
 * The EMF templates resource file could not be found or created.
 * 
 * @author Sebastian Hoecht
 */
public class TemplatesFileNotFoundException extends Exception {

	private static final long serialVersionUID = 1916900335630327864L;

	/**
	 * calls super method.
	 * 
	 * @param cause the Exception which has caused this exception
	 */
	public TemplatesFileNotFoundException(Throwable cause) {
		super(cause);
	}
}

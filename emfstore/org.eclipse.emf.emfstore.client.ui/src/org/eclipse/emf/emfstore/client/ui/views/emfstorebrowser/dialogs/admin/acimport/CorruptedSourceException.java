/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.acimport;

/**
 * This exception class is a very generic one, which can be used for any import
 * source on diagnosing an unwanted behavior, e.g. that no connection to a given
 * server could be established or a file, which should be imported was not in
 * the correct format.
 * 
 * @author deser, karakoc
 */
public class CorruptedSourceException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 *            the message of this exception
	 */
	public CorruptedSourceException(String message) {
		super(message);
	}
}

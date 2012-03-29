/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exceptions;

/**
 * The exception for any failure during the export of a DocWriter.
 * 
 * @see DocWriter
 * @author Sebastian Hoecht
 */
public class DocumentExportException extends Exception {

	private static final long serialVersionUID = -3769960630478314443L;

	/**
	 * @param message the message of the exception
	 * @param ex the exception which caused this exception
	 */
	public DocumentExportException(String message, Exception ex) {
		super(message, ex);
	}

	/**
	 * @param ex the exception which caused this exception
	 */
	public DocumentExportException(Exception ex) {
		super(ex);
	}

	/**
	 * Constructor.
	 */
	public DocumentExportException() {
	}

}

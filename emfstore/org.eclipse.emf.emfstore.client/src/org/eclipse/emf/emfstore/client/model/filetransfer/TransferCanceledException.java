/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.filetransfer;

import org.eclipse.emf.emfstore.server.exceptions.FileTransferException;

/**
 * Exception that is thrown when a transfer is canceled.
 * 
 * @author jfinis
 */
public class TransferCanceledException extends FileTransferException {

	/**
	 * Default constructor.
	 */
	public TransferCanceledException() {
		super("File transfer has been cancelled");
	}

	private static final long serialVersionUID = 1L;

	/**
	 * Stack trace is not filled, since a cancelled exception is no error that has to be debugged but a normal result.
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Throwable#fillInStackTrace()
	 */
	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}

}

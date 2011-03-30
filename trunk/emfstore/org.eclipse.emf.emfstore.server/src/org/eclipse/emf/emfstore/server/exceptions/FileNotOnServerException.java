/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.eclipse.emf.emfstore.server.exceptions;

import org.eclipse.emf.emfstore.server.model.FileIdentifier;
import org.eclipse.emf.emfstore.server.model.ProjectId;

/**
 * Exception class for file transfers that indicates that a requested file was not found on the server.
 * 
 * @author jfinis
 */
public class FileNotOnServerException extends FileTransferException {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * 
	 * @param p project id of the file that was not found on server
	 * @param fileIdentifier identifier of the file
	 */
	public FileNotOnServerException(ProjectId p, FileIdentifier fileIdentifier) {
		super("The file with the identifier " + fileIdentifier.getIdentifier() + " for project " + p.getId()
			+ " does not exist on the server.");
	}

	/**
	 * @param message Error message
	 */
	public FileNotOnServerException(String message) {
		super(message);
	}

	/**
	 * @param e exception originally thrown
	 * @param message Error message
	 */
	public FileNotOnServerException(String message, Throwable e) {
		super(message, e);
	}
}

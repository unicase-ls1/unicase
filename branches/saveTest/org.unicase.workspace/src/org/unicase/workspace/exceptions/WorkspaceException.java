package org.unicase.workspace.exceptions;

import org.unicase.emfstore.exceptions.EmfStoreException;

@SuppressWarnings("serial")
public class WorkspaceException extends EmfStoreException {

	public WorkspaceException(String message, Throwable cause) {
		super(message, cause);
	}

	public WorkspaceException(String message) {
		super(message);
	}

}

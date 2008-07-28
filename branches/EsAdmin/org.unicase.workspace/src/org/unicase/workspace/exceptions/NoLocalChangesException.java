package org.unicase.workspace.exceptions;

public class NoLocalChangesException extends WorkspaceException {

	private final static String message = "No need to commit. There are no local changes.";
	
	public NoLocalChangesException() {
		super(message);
	}

}

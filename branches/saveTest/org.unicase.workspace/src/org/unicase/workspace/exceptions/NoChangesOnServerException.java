package org.unicase.workspace.exceptions;

public class NoChangesOnServerException extends WorkspaceException {

	private final static String message = "No need to update. No changes on Server.";
	
	public NoChangesOnServerException() {
		super(message);
	}

}

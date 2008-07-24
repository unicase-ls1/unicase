package org.unicase.workspace.exceptions;

public class ChangeConflictException extends WorkspaceException {
	public ChangeConflictException() {
		super("Conflict detected on update");
	}
}

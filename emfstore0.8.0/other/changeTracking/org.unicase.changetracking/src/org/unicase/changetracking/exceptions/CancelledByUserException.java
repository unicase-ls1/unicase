package org.unicase.changetracking.exceptions;

public class CancelledByUserException extends Exception {

	/**
	 * .
	 */
	private static final long serialVersionUID = 1L;

	public CancelledByUserException() {
		super("User has canceled the process");
	}
}

package org.unicase.changetracking.git.exceptions;

public class NoMatchingLocalRepositoryInWorkspace extends Exception {

	/**
	 * .
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * .
	 * @param message
	 */
	public NoMatchingLocalRepositoryInWorkspace(String message) {
		super(message);
	}
}

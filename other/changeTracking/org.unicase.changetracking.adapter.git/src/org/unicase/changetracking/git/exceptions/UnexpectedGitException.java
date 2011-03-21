package org.unicase.changetracking.git.exceptions;

import org.unicase.changetracking.exceptions.UnexpectedChangeTrackingException;


/**
 * This exception may be thrown by all parts of the git plugin.
 * It signalizes that something has gone wrong which shouldn't under normal
 * circumstances. Because it is not usual that this will ever happen,
 * this exception is a runtime exception.
 * @author jfinis
 *
 */
public class UnexpectedGitException extends UnexpectedChangeTrackingException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnexpectedGitException() {
		super();
	}

	public UnexpectedGitException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UnexpectedGitException(String arg0) {
		super(arg0);
	}

	public UnexpectedGitException(Throwable arg0) {
		super(arg0);
	}

	
	
}

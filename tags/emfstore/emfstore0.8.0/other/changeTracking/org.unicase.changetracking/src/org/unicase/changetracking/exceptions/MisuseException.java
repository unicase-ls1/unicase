package org.unicase.changetracking.exceptions;

/**
 * A misuse exception is an exception which may occur during command execution
 * and is caused by a misuse of the program. Thus, it is no real exception to
 * be logged but rather only be displayed to the user in a message box.
 * 
 * @author jfinis
 *
 */
public class MisuseException extends RuntimeException{

	/**
	 * .
	 */
	private static final long serialVersionUID = 1L;

	public MisuseException() {
		super();
	}

	public MisuseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MisuseException(String arg0) {
		super(arg0);
	}

	public MisuseException(Throwable arg0) {
		super(arg0);
	}
	
	

}

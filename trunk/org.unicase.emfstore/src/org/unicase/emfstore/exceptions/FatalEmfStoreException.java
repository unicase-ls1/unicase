package org.unicase.emfstore.exceptions;

/**
 * Represents a condition the server or one of its components can not recover
 * from and where a server shutdown is inevitable.
 * 
 * @author Maximilian Koegel
 * 
 * 
 * @generated NOT
 */
@SuppressWarnings("serial")
public class FatalEmfStoreException extends Exception {

	public FatalEmfStoreException(String message, Throwable cause) {
		super(message, cause);
	}

	public FatalEmfStoreException(String message) {
		super(message);
	}

	public FatalEmfStoreException(Throwable cause) {
		super(cause);
	}

}

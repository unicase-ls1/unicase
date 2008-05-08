package org.unicase.emfstore.exceptions;

public class ConnectionException extends EmfStoreException {

	private static final long serialVersionUID = -2839606769454873809L;

	public ConnectionException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConnectionException(String message) {
		super(message);
	}

}

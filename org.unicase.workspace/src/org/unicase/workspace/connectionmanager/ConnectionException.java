package org.unicase.workspace.connectionmanager;

import org.unicase.emfstore.EmfStoreException;

/**
 * Represents an exceptional condition with the connection to the EmfStore.
 * 
 * @author Maximilian Koegel
 *
 * 
 * @generated NOT
 */
@SuppressWarnings("serial")
public class ConnectionException extends EmfStoreException {

	/**
	 * Constructor.
	 *
	 * @param message the message
	 *
	 * @generated NOT
	 */	
	public ConnectionException(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 * 
	 * @param message the message
	 * @param cause the causing exception
	 *
	 * @generated NOT
	 */
	public ConnectionException(String message, Throwable cause) {
		super(message, cause);
	}


	
}

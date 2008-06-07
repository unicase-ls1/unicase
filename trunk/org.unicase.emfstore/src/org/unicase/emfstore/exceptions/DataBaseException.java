package org.unicase.emfstore.exceptions;

/**
 * Represents a condition the server or one of its components can not recover
 * from and where a server shutdown is inevitable and this is caused by a
 * database or storage issue.
 * 
 * @author Otto Wesendonk
 * @generated NOT
 */
@SuppressWarnings("serial")
public class DataBaseException extends EmfStoreException {

	public final static String NOLOAD = "Couldn't load data from database.";
	
	public final static String NOSAVE = "Couldn't save data in database.";
	
	public DataBaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataBaseException(String message) {
		super(message);
	}
}


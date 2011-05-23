/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.commands;

import org.unicase.changetracking.exceptions.MisuseException;

/**
 * The result of a change tracking command. Stores the result type and
 * additional information like a message or an exception which caused an
 * erroneous result.
 * 
 * @author jfinis
 * 
 */
public class ChangeTrackingCommandResult {

	/**
	 * The type of the result.
	 * 
	 * @author jfinis
	 * 
	 */
	public static enum ResultType {
		/**
		 * The command was executed successfully without any warnings.
		 */
		SUCCESS,

		/**
		 * The command was executed but a warning occurred.
		 */
		WARNING,

		/**
		 * The command could not be conducted because of an exception. The
		 * getException method will yield the exception which caused the
		 * problem.
		 */
		ERROR,

		/**
		 * The command was cancelled by the user.
		 */
		CANCELLED,

		/**
		 * The command was aborted because the user used the tool wrongly. For
		 * example, he might have provided invalid input.
		 */
		MISUSE
	}

	/**
	 * Type of the result.
	 */
	private ResultType resultType;

	/**
	 * Exception which caused an erroneous result.
	 */
	private Throwable exception;

	/**
	 * Message (either success, misuse, or warning message, depending on the
	 * result type).
	 */
	private String message;

	/**
	 * Basic constructor.
	 * 
	 * @param result result type.
	 * @param message message.
	 */
	public ChangeTrackingCommandResult(ResultType result, String message) {
		this.resultType = result;
		this.message = message;
	}

	/**
	 * Creates a MISUSE result from a MisuseException.
	 * 
	 * @param e the exception stating the misuse.
	 */
	public ChangeTrackingCommandResult(MisuseException e) {
		this.message = e.getMessage();
		this.resultType = ResultType.MISUSE;
	}

	/**
	 * Creates an ERROR result from a throwable.
	 * 
	 * @param e throwable causeing the result.
	 */
	public ChangeTrackingCommandResult(Throwable e) {
		this.exception = e;
		this.message = e.getMessage();
		this.resultType = ResultType.ERROR;
	}

	/**
	 * Returns the default caption, which a message box displaying the result
	 * should have. This caption depends on the result type.
	 * 
	 * @param result result type.
	 * @return caption
	 */
	private static String getDefaultCaption(ResultType result) {
		switch (result) {
		case CANCELLED:
			return null;
		case ERROR:
			return "Unexpected error!";
		case MISUSE:
			return "Error";
		case SUCCESS:
			return "Success!";
		case WARNING:
			return "Attention!";
		default:
			return null;
		}

	}

	/**
	 * Returns the result type.
	 * 
	 * @return result type.
	 */
	public ResultType getResultType() {
		return resultType;
	}

	/**
	 * Returns the exception causing an ERROR result. If this is no ERROR
	 * result, null will be returned.
	 * 
	 * @return exception causing an error.
	 */
	public Throwable getException() {
		return exception;
	}

	/**
	 * Returns the message of the result. This is either the success, warning,
	 * or misuse message, depending on the result type.
	 * 
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Returns the caption which should be used for message boxes displaying the
	 * result.
	 * 
	 * @return caption.
	 */
	public String getCaption() {
		return getDefaultCaption(resultType);
	}

}

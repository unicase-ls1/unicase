package org.eclipse.emf.emfstore.common;

import org.eclipse.core.runtime.Plugin;

public abstract class AbstractUnicasePlugin extends Plugin {
	
	private UnicaseLogAdapter logAdapter;
	
	public AbstractUnicasePlugin() {
		logAdapter = new UnicaseLogAdapter();
	}

	public void log(String message, Exception exception, int statusInt) {
		logAdapter.log(message, exception, statusInt);
	}

	/**
	 * Log an exception to the error log.
	 * 
	 * @param message the message
	 * @param e the exception
	 */
	public void logException(String message, Exception e) {
		logAdapter.logException(message, e);
	}

	/**
	 * Log a warning to the error log.
	 * 
	 * @param message the message
	 * @param e the exception
	 */
	public void logWarning(String message, Exception e) {
		logAdapter.logWarning(message, e);
	}
}

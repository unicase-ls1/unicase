package org.unicase.ui.util;

import org.eclipse.emf.emfstore.common.IUnicaseLog;
import org.eclipse.emf.emfstore.common.UnicaseLogAdapter;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public abstract class AbstractUnicaseUIPlugin extends AbstractUIPlugin implements IUnicaseLog {
	private UnicaseLogAdapter logAdapter;
	
	public AbstractUnicaseUIPlugin() {
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

package org.eclipse.emf.emfstore.common;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class UnicaseLogAdapter {

	public void log(String message, Exception exception, int statusInt) {
		Status status = new Status(statusInt, Activator.getDefault().getBundle().getSymbolicName(), statusInt, message, exception);
		 Activator.getDefault().getLog().log(status);
	}

	public void logException(String message, Exception e) {
		log(message, e, IStatus.ERROR);
	}

	public void logWarning(String message, Exception e) {
		log(message, e, IStatus.WARNING);
	}
	
}

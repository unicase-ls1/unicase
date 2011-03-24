package org.eclipse.emf.emfstore.common;


public interface IUnicaseLog {
	
	public void log(String message, Exception exception, int statusInt);

	public void logException(String message, Exception e);

	public void logWarning(String message, Exception e);
	
}

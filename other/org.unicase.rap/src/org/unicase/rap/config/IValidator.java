package org.unicase.rap.config;

public interface IValidator {

	/**
	 * Performs validation logic.
	 * 
	 * @return True if validation succeeded, else false. 
	 */
	public boolean validate();
	
	/**
	 * Returns the cause why validation has failed.
	 * 
	 * @return A string desribing while validation has failed.
	 */
	public String getValidationErrorMessage();
}

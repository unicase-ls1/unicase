package org.unicase.changetracking.exceptions;

public class NotSupportedByAdapterException extends VCSException {

	public NotSupportedByAdapterException(String arg0) {
		super(arg0 + " is not supported by this VCS adapter.");
	}
	
}

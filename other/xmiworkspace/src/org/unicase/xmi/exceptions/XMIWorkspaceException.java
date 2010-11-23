package org.unicase.xmi.exceptions;

import java.io.IOException;

public class XMIWorkspaceException extends Exception {

	/**
	 * Generated ID for serialization
	 */
	private static final long serialVersionUID = -4325765045128940221L;
	
	private String title;
	private Exception exc;
	
	public XMIWorkspaceException(String name, Exception e) {
		title = name;
		exc = e;
	}
}

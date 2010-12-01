package org.unicase.xmi.exceptions;

public class XMIWorkspaceException extends Throwable {

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

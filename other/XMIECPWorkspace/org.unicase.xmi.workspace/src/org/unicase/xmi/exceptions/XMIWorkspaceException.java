package org.unicase.xmi.exceptions;

public class XMIWorkspaceException extends XMIException {

	/**
	 * Generated ID for serialization
	 */
	private static final long serialVersionUID = -4325765045128940221L;
	
	public XMIWorkspaceException(String msg) {
		message = msg;
		exception = new Exception(msg);
		
		log();
	}
	
	public XMIWorkspaceException(String msg, Exception e) {
		message = msg;
		exception = e;
		
		log();
	}
}

package org.unicase.xmi.exceptions;

/**
 * This exception is meant to be thrown is there is a workspace related issue.
 * @author matti, markus
 */
public class XMIWorkspaceException extends XMIException {

	/**
	 * Generated ID for serialization
	 */
	private static final long serialVersionUID = -4325765045128940221L;
	
	/**
	 * Create an exception only with a message.
	 * @param msg Custom message to inform the user.
	 */
	public XMIWorkspaceException(String msg) {
		message = msg;
		exception = new Exception(msg);
		
		log();
	}
	
	/**
	 * Create an exception with a custom message an the exception stack.
	 * @param msg Custom message to inform the user.
	 * @param e Exception thrown
	 */
	public XMIWorkspaceException(String msg, Exception e) {
		message = msg;
		exception = e;
		
		log();
	}
}

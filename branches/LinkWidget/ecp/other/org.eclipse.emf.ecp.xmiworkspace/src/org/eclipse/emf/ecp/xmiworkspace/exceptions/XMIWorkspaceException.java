/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.ecp.xmiworkspace.exceptions;

/**
 * This exception is meant to be thrown is there is a workspace related issue.
 * @author matti, markus
 */
public class XMIWorkspaceException extends XMIException {

	/**
	 * Generated ID for serialization.
	 */
	private static final long serialVersionUID = -4325765045128940221L;
	
	/**
	 * Create an exception only with a message.
	 * @param msg Custom message to inform the user.
	 */
	public XMIWorkspaceException(String msg) {
		setMessage(msg);
		setException(new Exception(msg));
		
		log();
	}
	
	/**
	 * Create an exception with a custom message an the exception stack.
	 * @param msg Custom message to inform the user.
	 * @param e Exception thrown
	 */
	public XMIWorkspaceException(String msg, Exception e) {
		setMessage(msg);
		setException(e);
		
		log();
	}
}

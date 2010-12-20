/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.patchAttachment.exported;
/**
 * Exceptions occuring during attaching or creating a patch.
 * @author jfinis
 *
 */
public class PatchAttachmentException extends Exception{

	/**
	 * .
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * .
	 */
	public PatchAttachmentException() {
		super();
	}

	/**
	 * .
	 * @param message message
	 * @param cause cause
	 */
	public PatchAttachmentException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * .
	 * @param message message
	 */
	public PatchAttachmentException(String message) {
		super(message);
	}

	/**
	 * .
	 * @param cause cause
	 */
	public PatchAttachmentException(Throwable cause) {
		super(cause);
	}
 
	
}

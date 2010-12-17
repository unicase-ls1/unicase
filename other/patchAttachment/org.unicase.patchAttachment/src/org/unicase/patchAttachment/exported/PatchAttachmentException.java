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
	 * {@inheritDoc}
	 */
	public PatchAttachmentException() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public PatchAttachmentException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * {@inheritDoc}
	 */
	public PatchAttachmentException(String message) {
		super(message);
	}

	/**
	 * {@inheritDoc}
	 */
	public PatchAttachmentException(Throwable cause) {
		super(cause);
	}
 
	
}

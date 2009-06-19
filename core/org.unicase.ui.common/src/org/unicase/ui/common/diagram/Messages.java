/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.diagram;
//dengler: what is this?
import org.eclipse.osgi.util.NLS;

/**
 * There is a generated Messages.java in each diagram plugin. I extracted the error messages, used by
 * @see org.unicase.ui.common.diagram.part.ModelDocumentProvider into this class.
 * 
 * @author denglerm
 */
public class Messages extends NLS {

	/**
	 * Initialize messages.
	 */
	static {
		NLS.initializeMessages("messages", Messages.class); //$NON-NLS-1$
	}

	/**
	 * The constructor.
	 */
	private Messages() {
	}

	/**
	 * An error message.
	 */
	public static String modelDocumentProviderDiagramLoadingError;

	/**
	 * An error message.
	 */
	public static String modelDocumentProviderNoDiagramInResourceError;

	/**
	 * An error message.
	 */
	public static String modelDocumentProviderIncorrectInputError;

}

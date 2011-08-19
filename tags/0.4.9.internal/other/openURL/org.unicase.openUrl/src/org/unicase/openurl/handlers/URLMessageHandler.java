/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.openurl.handlers;

import it.sauronsoftware.junique.MessageHandler;

import org.unicase.openurl.util.ui.OpenURL;

/**
 * <code>URIMessageHandler</code> is specific message handler for UNICASE
 * link arguments.
 * 
 * @author jfinis
 */
public class URLMessageHandler implements MessageHandler {


	/**
	 * Constructor of URLMessageHandler.
	 */
	public URLMessageHandler() {
		
	}
	
	/**
	 * Whenever the handler receives a message, it passes it to the OpenLink engine.
	 * 
	 * @see it.sauronsoftware.junique.MessageHandler#handle(java.lang.String)
	 * @param message is an argument which is send by other instance of UNICASE.
	 * @return nothing (null).
	 */
	public String handle(final String message) {
		OpenURL.openURL(message);
		return null;
	}

}



/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.trigger;

import java.util.Observable;
import java.util.StringTokenizer;


import it.sauronsoftware.junique.MessageHandler;

/**
 * <code>URIMessageHandler</code> is specific message handler for UNICASE
 * link arguments.
 * 
 * @author fxulusoy, jfinis
 */
public class URLMessageHandler extends Observable implements MessageHandler {


	/**
	 * Constructor of URLMessageHandler.
	 */
	public URLMessageHandler() {
		
	}
	
	/**
	 * Delegates the message(URL) handling to <code>URLEvaluator</code> class.
	 * 
	 * @see it.sauronsoftware.junique.MessageHandler#handle(java.lang.String)
	 * @param message is an argument which is send by other instance of UNICASE.
	 * @return TODO: javadoc for return
	 */
	public String handle(final String message) {
		StringTokenizer strTokenizer = new StringTokenizer(message, " ");

		if (strTokenizer.countTokens() == 1) {
			super.setChanged();
			super.notifyObservers(message);
		} else {
			// TODO: return an error message??
		}
		return null;
	}

}



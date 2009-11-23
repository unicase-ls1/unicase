/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.trigger;

import java.util.StringTokenizer;

import org.eclipse.swt.widgets.Display;

import it.sauronsoftware.junique.MessageHandler;

/**
 * <code>URIMessageHandler</code> is specific message handler for UNICASE
 * link arguments.
 * 
 * @author fxulusoy
 */
public class URLMessageHandler implements MessageHandler {

	/**  */
	private URLEvaluator urlEvaluator;

	/**
	 * Constructor of URLMessageHandler.
	 */
	public URLMessageHandler() {
		urlEvaluator = new URLEvaluator();
	}
	
	/**
	 * Delegates the message(URL) handling to <code>URIEvaluator</code> class.
	 * 
	 * @see it.sauronsoftware.junique.MessageHandler#handle(java.lang.String)
	 * @param message TODO: javadoc for message
	 * @return TODO: javadoc for return
	 */
	public String handle(final String message) {
		StringTokenizer strTokenizer = new StringTokenizer(message, " ");

		if (strTokenizer.countTokens() == 1) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					urlEvaluator.execute(message);
				}
			});
		} else {
			// TODO: return an error message??
		}
		return null;
	}

}



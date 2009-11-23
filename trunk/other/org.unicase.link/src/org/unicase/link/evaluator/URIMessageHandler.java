/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.evaluator;

import java.util.StringTokenizer;

import org.eclipse.swt.widgets.Display;

import it.sauronsoftware.junique.MessageHandler;

/**
 * TODO: Javadoc.
 * 
 * @author fxulusoy
 */
public class URIMessageHandler implements MessageHandler {

	private URIEvaluator eva;

	/**
	 * The constructor.
	 */
	public URIMessageHandler() {
		eva = new URIEvaluator();
	}
	
	/**
	 * TODO: Javadoc.
	 * @param message -insert doc-
	 * @return -insert doc-
	 */
	public String handle(final String message) {
		StringTokenizer strTokenizer = new StringTokenizer(message, " ");

		if (strTokenizer.countTokens() == 1) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					eva.handleArguments(message);
				}
			});
		} else {
			// TODO: return an error message??
		}
		return null;
	}

}



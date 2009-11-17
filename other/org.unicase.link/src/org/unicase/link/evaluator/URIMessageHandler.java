package org.unicase.link.evaluator;

import java.util.StringTokenizer;

import org.eclipse.swt.widgets.Display;

import it.sauronsoftware.junique.MessageHandler;

/**
 * 
 * 
 * @author fxulusoy
 */
public class URIMessageHandler implements MessageHandler {

	private URIEvaluator eva;

	public URIMessageHandler() {
		eva = new URIEvaluator();
	}
	
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



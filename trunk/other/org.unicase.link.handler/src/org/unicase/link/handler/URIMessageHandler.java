package org.unicase.link.handler;

import java.util.StringTokenizer;

import org.eclipse.swt.widgets.Display;
import org.unicase.link.arghandler.IArgsHandler;
import org.unicase.link.arghandler.SampleArgsHandler;

import it.sauronsoftware.junique.MessageHandler;

/**
 * 
 * 
 * @author fxulusoy
 */
public class URIMessageHandler implements MessageHandler {

	private IArgsHandler argHandler;

	public URIMessageHandler() {
		argHandler = new SampleArgsHandler();
	}
	
	@Override
	public String handle(final String message) {
		StringTokenizer strTokenizer = new StringTokenizer(message, " ");

		if (strTokenizer.countTokens() == 1) {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					argHandler.handleArguments(message);
				}
			});
		} else {
			// TODO: return an error message??
		}
		return null;
	}

}



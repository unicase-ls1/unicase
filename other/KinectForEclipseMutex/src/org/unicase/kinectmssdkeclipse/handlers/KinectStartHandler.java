package org.unicase.kinectmssdkeclipse.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class KinectStartHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public KinectStartHandler() {
	}

	
	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		//KinectConnection client = KinectConnection.getInstance();
		//client.openConnection();
		KinectProxy.handle(null);
		return null;
	}
}

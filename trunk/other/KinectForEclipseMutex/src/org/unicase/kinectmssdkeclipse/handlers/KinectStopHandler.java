package org.unicase.kinectmssdkeclipse.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class KinectStopHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public KinectStopHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		//KinectConnection client = KinectConnection.getInstance();
		//client.closeConnection();
		KinectProxy.stopHandle();
		return null;
	}
}

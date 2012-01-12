package org.unicase.kinectmssdkeclipse.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.unicase.kinectmssdkeclipse.KinectConnection;

public class KinectGameHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
	     KinectConnection.getInstance().startKinectGame();
	    return null;
	}

}

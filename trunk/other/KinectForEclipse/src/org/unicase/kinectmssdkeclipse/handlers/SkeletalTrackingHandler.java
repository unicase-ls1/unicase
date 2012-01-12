package org.unicase.kinectmssdkeclipse.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.unicase.kinectmssdkeclipse.KinectConnection;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SkeletalTrackingHandler extends AbstractHandler{
	/**
	 * The constructor.
	 */
	public SkeletalTrackingHandler() {
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
	    
	    //KinectConnection.getInstance().startSkeletonTracking();
		KinectProxy.startSkeletonTracking();
	    
	    return null;
	}

	
}

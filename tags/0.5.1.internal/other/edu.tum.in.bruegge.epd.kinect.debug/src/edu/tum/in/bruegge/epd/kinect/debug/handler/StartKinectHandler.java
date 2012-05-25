package edu.tum.in.bruegge.epd.kinect.debug.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import edu.tum.in.bruegge.epd.kinect.KinectManager;

public class StartKinectHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		KinectManager.INSTANCE.startKinect();
		return null;
	}

}

package edu.tum.in.bruegge.epd.kinect.debug.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import edu.tum.in.bruegge.epd.kinect.KinectManager;
import edu.tum.in.bruegge.epd.kinect.debug.gesture.DebugGestureListener;
import edu.tum.in.bruegge.epd.kinect.gesture.GestureProxy;
import edu.tum.in.bruegge.epd.kinect.gesture.detectors.CrouchGestureDetector;
import edu.tum.in.bruegge.epd.kinect.gesture.detectors.JumpGestureDetector;

public class StartSkeletonTrackingHandler extends AbstractHandler {

	private static boolean addedGestures = false;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (!addedGestures) {
			GestureProxy.INSTANCE.addGestureListener(new DebugGestureListener());
			GestureProxy.INSTANCE.addGestureDetector(new JumpGestureDetector());
			GestureProxy.INSTANCE.addGestureDetector(new CrouchGestureDetector());
			addedGestures = true;
		}
		KinectManager.INSTANCE.startSkeletonTracking();
		return null;
	}

}

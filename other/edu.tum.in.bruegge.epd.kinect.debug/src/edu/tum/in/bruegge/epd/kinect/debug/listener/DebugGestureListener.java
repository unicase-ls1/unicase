package edu.tum.in.bruegge.epd.kinect.debug.listener;

import edu.tum.in.bruegge.epd.kinect.debug.DebugHelper;
import edu.tum.in.bruegge.epd.kinect.gesture.Gesture;
import edu.tum.in.bruegge.epd.kinect.gesture.GestureListener;
import edu.tum.in.bruegge.epd.kinect.gesture.detectors.CrouchGestureDetector;
import edu.tum.in.bruegge.epd.kinect.gesture.detectors.JumpGestureDetector;

public class DebugGestureListener extends GestureListener {

	@Override
	public void notifyGestureDetected(Class<? extends Gesture> gesture) {
		System.out.println("Gesture recognized: " + gesture.getSimpleName());
		/*
		if (JumpGestureDetector.class.equals(gesture)) {
			DebugHelper.stepOver();
		} else if(CrouchGestureDetector.class.equals(gesture)) {
			DebugHelper.stepInto();
		}
		*/
	}
}

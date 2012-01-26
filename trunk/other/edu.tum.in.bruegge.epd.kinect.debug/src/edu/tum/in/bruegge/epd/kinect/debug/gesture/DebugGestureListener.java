package edu.tum.in.bruegge.epd.kinect.debug.gesture;

import edu.tum.in.bruegge.epd.kinect.debug.DebugHelper;
import edu.tum.in.bruegge.epd.kinect.gesture.Gesture;
import edu.tum.in.bruegge.epd.kinect.gesture.GestureListener;
import edu.tum.in.bruegge.epd.kinect.gesture.detectors.CrouchGestureDetector;
import edu.tum.in.bruegge.epd.kinect.gesture.detectors.JumpGestureDetector;

public class DebugGestureListener extends GestureListener {

	@Override
	public void notifyGestureDetected(Class<? extends Gesture> gesture) {
		if(gesture.equals(JumpGestureDetector.class)){
			DebugHelper.stepOver();
		}
		else if(gesture.equals(CrouchGestureDetector.class)){
			DebugHelper.stepInto();
		}
		
	}

}

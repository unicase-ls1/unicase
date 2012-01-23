package edu.tum.in.bruegge.epd.kinect.gesture.impl;

import edu.tum.in.bruegge.epd.kinect.gesture.Gesture;

public interface GestureListenerProxy {

	void notifyGestureDetected(Class<? extends Gesture> gesture);
}

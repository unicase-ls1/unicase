package edu.tum.in.bruegge.epd.kinect.gesture.impl;

import edu.tum.in.bruegge.epd.kinect.gesture.Gesture;

public interface GestureProxyCallback {

	void notifyGestureDetected(Class<? extends Gesture> gesture);
}

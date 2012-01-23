package edu.tum.in.bruegge.epd.kinect.gesture;

public interface GestureListener {

	void notifyGestureDetected(Class<? extends Gesture> gesture);
}

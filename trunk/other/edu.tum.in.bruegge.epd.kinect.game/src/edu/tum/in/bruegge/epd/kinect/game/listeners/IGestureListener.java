package edu.tum.in.bruegge.epd.kinect.game.listeners;

import edu.tum.in.bruegge.epd.kinect.gesture.Gesture;

public interface IGestureListener {

	public void notifyGestureDetected(Class<? extends Gesture> gesture);

}

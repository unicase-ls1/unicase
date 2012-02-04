package edu.tum.in.bruegge.epd.kinect.game.listeners;

import edu.tum.in.bruegge.epd.kinect.gesture.Gesture;
import edu.tum.in.bruegge.epd.kinect.gesture.GestureListener;

public class GameGestureListener extends GestureListener {

	IGestureListener gestureListener = null;

	public GameGestureListener(IGestureListener gestListener) {
		this.gestureListener = gestListener;
	}

	@Override
	public void notifyGestureDetected(Class<? extends Gesture> gesture) {
		gestureListener.notifyGestureDetected(gesture);
	}

}

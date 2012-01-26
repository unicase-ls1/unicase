package edu.tum.in.bruegge.epd.kinect.gesture;

import java.util.Collections;
import java.util.Set;

public abstract class GestureListener {

	public abstract void notifyGestureDetected(Class<? extends Gesture> gesture);
		
	public Set<Gesture> getGestures(){
		return Collections.emptySet();
	}
	
	public boolean isFiltered() {
		return false;
	}
}

package edu.tum.in.bruegge.epd.kinect.gesture;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;

import edu.tum.in.bruegge.epd.kinect.gesture.impl.GestureListenerProxy;

public abstract class Gesture extends EContentAdapter {

	protected GestureListenerProxy gestureListenerProxy;
	
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		
		if (isGestureDetected(notification)) {
			this.gestureListenerProxy.notifyGestureDetected(this.getClass());
		}
	}

	public abstract boolean isGestureDetected(Notification notification);
	
}

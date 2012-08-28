package edu.tum.in.bruegge.epd.kinect.gesture;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;

import edu.tum.in.bruegge.epd.kinect.gesture.impl.GestureProxyCallback;

public abstract class Gesture extends EContentAdapter {

	protected GestureProxyCallback gestureProxy;
	
	/**
	 * DO NOT CALL THIS METHOD, IT WILL BE CALLED BY THE GESTUREPROXY
	 * @param gestureProxy the proxy to notify when a gesture is detected
	 */
	public void setGestureProxy(GestureProxyCallback gestureProxy) {
		this.gestureProxy = gestureProxy;
	}
	
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		
		if (gestureProxy != null && isGestureDetected(notification)) {
			this.gestureProxy.notifyGestureDetected(this.getClass());
		}
	}

	protected abstract boolean isGestureDetected(Notification notification);
}

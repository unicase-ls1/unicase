package edu.tum.in.bruegge.epd.kinect.gesture.impl;

import humanbodymodel.HumanContainer;

import java.util.Set;

import edu.tum.in.bruegge.epd.kinect.KinectManager;
import edu.tum.in.bruegge.epd.kinect.KinectManagerFactory;
import edu.tum.in.bruegge.epd.kinect.gesture.Gesture;
import edu.tum.in.bruegge.epd.kinect.gesture.GestureListener;

public class GestureKinectManager implements GestureListenerProxy {

	private KinectManager kinectManager;

	private Set<GestureListener> gestureListeners;

	public GestureKinectManager() {
		this.kinectManager = KinectManagerFactory.newInstance();

		// TODO Move out of here ...
		addGestureDetector(new JumpGestureDetector());
		addGestureDetector(new CrouchGestureDetector());
	}

	@Override
	public void notifyGestureDetected(Class<? extends Gesture> gesture) {
		for (GestureListener listener : this.gestureListeners) {
			listener.notifyGestureDetected(gesture);
		}
	}

	public void addGestureListener(GestureListener gestureListener) {
		this.gestureListeners.add(gestureListener);
	}

	public void removeGestureListener(GestureListener gestureListener) {
		this.gestureListeners.remove(gestureListener);
	}

	public void addGestureDetector(Gesture gestureDetector) {
		HumanContainer humanContainer = this.kinectManager.getSkeletonModel();
		humanContainer.eAdapters().add(gestureDetector);
	}

	public void removeGestureDetector(Gesture gestureDetector) {
		HumanContainer humanContainer = this.kinectManager.getSkeletonModel();
		humanContainer.eAdapters().remove(gestureDetector);
	}
}

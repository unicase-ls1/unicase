package edu.tum.in.bruegge.epd.kinect.gesture.detectors;

import humanbodymodel.Human;

import org.eclipse.emf.common.notify.Notification;

import edu.tum.in.bruegge.epd.kinect.gesture.Gesture;

public class CrouchGestureDetector extends Gesture {

	@Override
	public boolean isGestureDetected(Notification notification) {
		String bodyPart=((Human)notification.getFeature()).getName();
		if(bodyPart.equalsIgnoreCase("head")){
			
		}
		return false;
	}
}

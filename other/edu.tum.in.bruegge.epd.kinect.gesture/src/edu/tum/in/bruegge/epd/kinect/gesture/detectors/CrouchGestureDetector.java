package edu.tum.in.bruegge.epd.kinect.gesture.detectors;

import humanbodymodel.Human;
import humandiagramgef.HumanBodyEnum;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;

import edu.tum.in.bruegge.epd.kinect.gesture.Gesture;
import edu.tum.in.bruegge.epd.kinect.gesture.impl.MovingAverageCalculator;

public class CrouchGestureDetector extends Gesture {
	
	private static final int NUM_PERIODS = 15;
	private static final float THRESHOLD = 0.4f;
	
	private MovingAverageCalculator yMovingAvgHead;
	
	
	public CrouchGestureDetector() {
		this.yMovingAvgHead = new MovingAverageCalculator(NUM_PERIODS);
	}
	
	@Override
	public boolean isGestureDetected(Notification notification) {
		if (notification.getEventType() == Notification.SET && notification.wasSet()) {
			EAttribute feature = (EAttribute) notification.getFeature();
			Human humanBodyPart = (Human) notification.getNotifier();
			
			if ("y".equals(feature.getName()) && HumanBodyEnum.Head.name().equals(humanBodyPart.getName())) {
				float sensorValue = notification.getNewFloatValue();
				float avgHeadValue = this.yMovingAvgHead.calculateMovingAvg(sensorValue);
				float delta = sensorValue - avgHeadValue;
				
				if (-delta > avgHeadValue * THRESHOLD) {
					return true;
				}
			}
		}
		return false;
	}
}

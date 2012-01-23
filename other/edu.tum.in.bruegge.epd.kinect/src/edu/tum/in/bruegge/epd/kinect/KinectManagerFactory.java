package edu.tum.in.bruegge.epd.kinect;

import edu.tum.in.bruegge.epd.kinect.impl.KinectManagerImpl;

public class KinectManagerFactory {

	private KinectManagerFactory() {
		// Do not instantiate
	}
	
	public static KinectManager newInstance() {
		return new KinectManagerImpl();
	}
}

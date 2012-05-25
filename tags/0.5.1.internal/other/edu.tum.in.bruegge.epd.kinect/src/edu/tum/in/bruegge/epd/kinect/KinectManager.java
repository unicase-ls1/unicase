package edu.tum.in.bruegge.epd.kinect;

import humanbodymodel.HumanContainer;
import edu.tum.in.bruegge.epd.kinect.impl.KinectManagerImpl;


public interface KinectManager {
	
	KinectManager INSTANCE = KinectManagerImpl.getInstance();
	
	void startKinect();
	void stopKinect();
	boolean isStarted();
	
	HumanContainer getSkeletonModel();
	void startSkeletonTracking();
	void stopSkeletonTracking();
	boolean isSkeletonTrackingStarted();
	
	void addSpeechListener(SpeechListener listener);
	void removeSpeechListener(SpeechListener listener);
	void startSpeechRecognition();
	void stopSpeechRecognition();
	boolean isSpeechRecognitionStarted();
}

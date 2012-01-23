package edu.tum.in.bruegge.epd.kinect;

import humanbodymodel.HumanContainer;


public interface KinectManager {
	
	void startKinect();
	void stopKinect();
	
	HumanContainer getSkeletonModel();
	void startSkeletonTracking();
	void stopSkeletonTracking();
	
	void addSpeechListener(SpeechListener listener);
	void removeSpeechListener(SpeechListener listener);
	void startSpeechRecognition();
	void stopSpeechRecognition();
}

package edu.tum.in.bruegge.epd.kinect.impl;

import java.io.IOException;

public interface ConnectionManager {

	void openConnection() throws IOException;
	void closeConnection() throws IOException;
	boolean isConnected();

	void startSkeletonTracking();
	void stopSkeletonTracking();
	boolean isSkeletonTrackingStarted();
	
	void startSpeechRecognition(String[] keywords);
	void stopSpeechRecognition();
	boolean isSpeechRecognitionStarted();
	
	void setDataHandler(KinectDataHandler dataHandler);
}

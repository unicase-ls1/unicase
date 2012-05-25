package edu.tum.in.bruegge.epd.kinect.impl;

import org.w3c.dom.Document;

public interface KinectDataHandler {

	void handleSkeletonData(Document doc);
	
	void handleSpeechData(String word);
}

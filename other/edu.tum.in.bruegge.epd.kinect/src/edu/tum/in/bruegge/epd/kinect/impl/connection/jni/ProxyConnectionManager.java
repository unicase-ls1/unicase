package edu.tum.in.bruegge.epd.kinect.impl.connection.jni;

import java.io.IOException;

import edu.tum.in.bruegge.epd.kinect.impl.ConnectionDataHandler;
import edu.tum.in.bruegge.epd.kinect.impl.ConnectionManager;

public class ProxyConnectionManager extends ConnectionDataHandler implements ConnectionManager {

	private ProxySkeletonConnectionProcessor skeletonProcessor;
	private ProxySpeechConnectionProcessor speechProcessor;
	
	@Override
	public void openConnection() throws IOException {
		this.skeletonProcessor = new ProxySkeletonConnectionProcessor();
		this.skeletonProcessor.setConnectionDataHandler(this);
		this.skeletonProcessor.start();
		
		this.speechProcessor = new ProxySpeechConnectionProcessor();
		this.speechProcessor.setConnectionDataHandler(this);
		this.speechProcessor.start();
	}
	
	@Override
	public void closeConnection() throws IOException {
		this.skeletonProcessor.shutdown();
		this.speechProcessor.shutdown();
	}
	
	@Override
	public void startSkeletonTracking() {
		this.skeletonProcessor.startSkeletonTracking();
	}
	
	@Override
	public void startSpeechRecognition(String[] keywords) {
		this.speechProcessor.initSpeechRecognition(keywords);
	}
}

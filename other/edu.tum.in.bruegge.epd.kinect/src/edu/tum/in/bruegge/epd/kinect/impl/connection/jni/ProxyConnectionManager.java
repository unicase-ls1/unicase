package edu.tum.in.bruegge.epd.kinect.impl.connection.jni;

import java.io.IOException;

import edu.tum.in.bruegge.epd.kinect.impl.ConnectionDataHandler;
import edu.tum.in.bruegge.epd.kinect.impl.ConnectionManager;
import edu.tum.in.bruegge.epd.kinect.impl.KinectDataHandler;

public class ProxyConnectionManager extends ConnectionDataHandler implements ConnectionManager {

	private ProxySkeletonConnectionProcessor skeletonProcessor;
	private ProxySpeechConnectionProcessor speechProcessor;
	
	@Override
	public void openConnection() throws IOException {
		this.skeletonProcessor = new ProxySkeletonConnectionProcessor();
		this.skeletonProcessor.setConnectionDataHandler(this);
		this.skeletonProcessor.init();
		
		this.speechProcessor = new ProxySpeechConnectionProcessor();
		this.speechProcessor.setConnectionDataHandler(this);
		this.speechProcessor.init();
	}
	
	@Override
	public void closeConnection() throws IOException {
		// Shutdown connection processors
		this.skeletonProcessor.shutdown();
		this.speechProcessor.shutdown();
	}
	
	@Override
	public void startSkeletonTracking() {
		this.skeletonProcessor.startSkeletonTracking();
		this.skeletonProcessor.start();
	}
	
	@Override
	public void stopSkeletonTracking() {
		// empty
	}

	@Override
	public void startSpeechRecognition(String[] keywords) {
		this.speechProcessor.initSpeechRecognition(keywords);
		this.speechProcessor.start();
	}

	@Override
	public void stopSpeechRecognition() {
		this.speechProcessor.stopSpeechRecognition();
	}

	@Override
	public void setDataHandler(KinectDataHandler dataHandler) {
		// TODO Auto-generated method stub
		this.dataHandler = dataHandler;
	}
}

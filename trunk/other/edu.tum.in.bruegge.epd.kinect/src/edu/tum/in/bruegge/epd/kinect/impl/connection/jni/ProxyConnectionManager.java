package edu.tum.in.bruegge.epd.kinect.impl.connection.jni;

import java.io.IOException;
import java.util.logging.Logger;

import edu.tum.in.bruegge.epd.kinect.impl.ConnectionDataHandler;
import edu.tum.in.bruegge.epd.kinect.impl.ConnectionManager;
import edu.tum.in.bruegge.epd.kinect.impl.KinectDataHandler;

public class ProxyConnectionManager extends ConnectionDataHandler implements ConnectionManager {

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	private ProxySkeletonConnectionProcessor skeletonProcessor;
	private ProxySpeechConnectionProcessor speechProcessor;
	
	private Thread skeletonProcessorThread;
	private Thread speechProcessorThread;
	
	@Override
	public void openConnection() throws IOException {
		logger.info("Opening connection to Kinect");
		
		this.skeletonProcessor = new ProxySkeletonConnectionProcessor();
		this.skeletonProcessor.setConnectionDataHandler(this);
		this.skeletonProcessor.init();
		
		this.speechProcessor = new ProxySpeechConnectionProcessor();
		this.speechProcessor.setConnectionDataHandler(this);
		this.speechProcessor.init();
	}
	
	@Override
	public void closeConnection() throws IOException {
		logger.info("Closing connection to Kinect");
		
		// Shutdown threads
		stopSkeletonTracking();
		stopSpeechRecognition();
	}
	
	@Override
	public void startSkeletonTracking() {
		if (this.skeletonProcessorThread == null || !this.skeletonProcessorThread.isAlive()) {
			this.skeletonProcessorThread = new Thread(this.skeletonProcessor, this.skeletonProcessor.getClass().getSimpleName());
			this.skeletonProcessorThread.start();
		} else {
			logger.info("Skeleton tracking already running.");
		}
	}
	
	@Override
	public void stopSkeletonTracking() {
		if (this.skeletonProcessorThread != null && this.skeletonProcessorThread.isAlive()) {
			this.skeletonProcessor.shutdown();
		}
	}

	@Override
	public void startSpeechRecognition(String[] keywords) {
		if (this.speechProcessorThread == null || !this.speechProcessorThread.isAlive()) {
			this.speechProcessorThread = new Thread(this.speechProcessor, this.speechProcessor.getClass().getSimpleName());
			this.speechProcessorThread.start();
			this.speechProcessor.initSpeechRecognition(keywords);
		} else {
			logger.info("Speech recognition already running.");
		}
	}

	@Override
	public void stopSpeechRecognition() {
		if (this.speechProcessorThread != null && this.speechProcessorThread.isAlive()) {
			this.speechProcessor.stopSpeechRecognition();
			this.speechProcessor.shutdown();
		}
	}

	@Override
	public void setDataHandler(KinectDataHandler dataHandler) {
		this.dataHandler = dataHandler;
	}

	@Override
	public boolean isConnected() {
		return this.skeletonProcessor != null && this.speechProcessor != null;
	}

	@Override
	public boolean isSkeletonTrackingStarted() {
		return this.skeletonProcessorThread != null && this.skeletonProcessorThread.isAlive();
	}

	@Override
	public boolean isSpeechRecognitionStarted() {
		return this.speechProcessorThread != null && this.speechProcessorThread.isAlive();
	}
}

package edu.tum.in.bruegge.epd.kinect.impl;

import java.io.IOException;

public class KinectConnectionManager {

	private static final String HOST = "127.0.0.1";
	private static final int PORT = 12345;

	// private static KinectConnectionManager INSTANCE;

	private SocketConnectionProcessor connectionProcessor;

	private KinectCommunicationManager communicationManager;

	//private KinectConnectionManager() {
	public KinectConnectionManager(KinectDataHandler dataHandler) {
		this.communicationManager = new KinectCommunicationManager(dataHandler);
	}

	/*
	public static KinectConnectionManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new KinectConnectionManager();
		}
		return INSTANCE;
	}
	 */
	public void openConnection() throws IOException {
		this.connectionProcessor = new SocketConnectionProcessor(HOST, PORT, this.communicationManager);
		this.connectionProcessor.start();
	}

	public void closeConnection() throws IOException {
		this.connectionProcessor.shutdown();
	}
	
	public KinectCommunicationManager getCommunicationManager() {
		return this.communicationManager;
	}
}

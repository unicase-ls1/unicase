package edu.tum.in.bruegge.epd.kinect.impl.connection.socket;

import java.io.IOException;

import edu.tum.in.bruegge.epd.kinect.impl.ConnectionDataHandler;
import edu.tum.in.bruegge.epd.kinect.impl.ConnectionManager;
import edu.tum.in.bruegge.epd.kinect.impl.KinectDataHandler;

public class SocketConnectionManager extends ConnectionDataHandler implements ConnectionManager {

	private SocketConnectionProcessor socketProcessor;
	
	private String host;
	private int port;
	
	public SocketConnectionManager() {
		this.host = KinectProtocolConstants.DEFAULT_HOST;
		this.port = KinectProtocolConstants.DEFAULT_PORT;
	}
	
	public SocketConnectionManager(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	@Override
	public void openConnection() throws IOException {
		this.socketProcessor = new SocketConnectionProcessor(this.host, this.port);
		this.socketProcessor.setConnectionDataHandler(this);
		this.socketProcessor.start();
	}

	@Override
	public void closeConnection() throws IOException {
		this.socketProcessor.shutdown();
	}

	@Override
	public void startSkeletonTracking() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopSkeletonTracking() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startSpeechRecognition(String[] keywords) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopSpeechRecognition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDataHandler(KinectDataHandler dataHandler) {
		// TODO Auto-generated method stub
		this.dataHandler = dataHandler;
	}

}

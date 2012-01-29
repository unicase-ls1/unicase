package edu.tum.in.bruegge.epd.kinect.impl;


public abstract class ConnectionProcessor extends Thread {

	protected ConnectionDataHandler connectionDataHandler;
	
	public ConnectionProcessor() {
		this.setName(this.getClass().getSimpleName());
	}
	
	public void setConnectionDataHandler(ConnectionDataHandler dataHandler) {
		this.connectionDataHandler = dataHandler;
	}
}

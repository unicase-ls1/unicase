package edu.tum.in.bruegge.epd.kinect.impl;


public abstract class ConnectionProcessor extends Thread {

	protected ConnectionDataHandler inputDataHandler;
	
	public ConnectionProcessor() {
		this.setName(this.getClass().getSimpleName());
	}
	
	public void setConnectionDataHandler(ConnectionDataHandler dataHandler) {
		this.inputDataHandler = dataHandler;
	}
}

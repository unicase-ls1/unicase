package edu.tum.in.bruegge.epd.kinect.impl;


public abstract class ConnectionProcessor implements Runnable {

	protected ConnectionDataHandler connectionDataHandler;
	
	public void setConnectionDataHandler(ConnectionDataHandler dataHandler) {
		this.connectionDataHandler = dataHandler;
	}
}

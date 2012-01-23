package edu.tum.in.bruegge.epd.kinect.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketConnectionProcessor extends Thread implements ConnectionProcessor {

	private String host;
	private int port;
	
	private Socket socket;
	private PrintWriter writer;
	private BufferedReader reader;
	
	private KinectCommunicationManager communicationManager;
	
	private boolean run = false;
	
	public SocketConnectionProcessor(String host, int port, KinectCommunicationManager communicationManager) {
		this.host = host;
		this.port = port;
		this.communicationManager = communicationManager;
	}
	
	@Override
	public void run() {
		super.run();
		
		this.run = true;
		
		try {
			this.socket = new Socket(this.host, this.port);
			this.writer = new PrintWriter(this.socket.getOutputStream(), true);
			this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			
			while (this.run) {
				try {
					String input = reader.readLine();
					this.communicationManager.processInput(input);
				} catch (IOException e) {
					// TODO Handle properly
					e.printStackTrace();
				}
			}
			
			this.reader.close();
			this.writer.close();
			this.socket.close();
		} catch (IOException ioe) {
			// TODO Handle properly
			ioe.printStackTrace();
		}
	}
	
	public void shutdown() {
		this.run = false;
	}
}

package edu.tum.in.bruegge.epd.kinect.impl.connection.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.tum.in.bruegge.epd.kinect.impl.ConnectionProcessor;

public class SocketConnectionProcessor extends ConnectionProcessor {
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());

	private String host;
	private int port;

	private Socket socket;
	private PrintWriter writer;
	private BufferedReader reader;

	private boolean run = false;

	public SocketConnectionProcessor(String host, int port) {
		this.host = host;
		this.port = port;
	}

	@Override
	public void run() {
		this.run = true;

		try {
			this.socket = new Socket(this.host, this.port);
			this.writer = new PrintWriter(this.socket.getOutputStream(), true);
			this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

			while (this.run) {
				try {
					String input = reader.readLine();
					processInput(input);
				} catch (IOException e) {
					logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
			}

			this.reader.close();
			this.writer.close();
			this.socket.close();
		} catch (IOException ioe) {
			logger.log(Level.SEVERE, ioe.getLocalizedMessage(), ioe);
		}
	}

	public void shutdown() {
		this.run = false;
	}
	
	private void processInput(String input) {
		if (input.startsWith(KinectProtocolConstants.SPEECH)) {
			String speech = input.substring(KinectProtocolConstants.SPEECH.length());
			this.connectionDataHandler.handleSpeechInput(speech);
		} else if (input.startsWith(KinectProtocolConstants.SKELETON)) {
			String xml = input.substring(KinectProtocolConstants.SKELETON.length());
			this.connectionDataHandler.handleSkeletonInput(xml);
		} else {
			// TODO Handle unrecognized response
			System.out.println("Unrecognized: " + input);// throws IOException
		}
	}

	public void write(KinectProtocolCommands command) {
		this.writer.println(command.getCommand());
	}
}

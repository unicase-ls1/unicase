package edu.tum.in.bruegge.epd.kinect.impl.connection.jni;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import microsoftkinectwrapper.SpeechRecognition;
import net.sf.jni4net.Bridge;
import edu.tum.in.bruegge.epd.kinect.impl.ConnectionProcessor;
import edu.tum.in.bruegge.epd.kinect.impl.connection.socket.KinectProtocolConstants;

public class ProxySpeechConnectionProcessor extends ConnectionProcessor {
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	private boolean run = false;

	private SpeechRecognition kinectSpeechRecognitionProxy;
	
	public void init() {
		try {
			File dll = new File("lib/MicrosoftKinectWrapper.j4n.dll");
			if (!dll.exists()) {
				URL dllUrl = this.getClass().getResource("/MicrosoftKinectWrapper.j4n.dll");
				dll = new File(dllUrl.toURI());
			}
			
			Bridge.init();
			Bridge.LoadAndRegisterAssemblyFrom(dll);
		} catch (IOException ioe) {
			logger.log(Level.SEVERE, ioe.getLocalizedMessage(), ioe);
		} catch (URISyntaxException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		
		this.kinectSpeechRecognitionProxy = new SpeechRecognition();
	}
	
	@Override
	public void run() {
		logger.info("Starting speech recognition");
		
		this.run = true;
		while (this.run) {
			String input = this.kinectSpeechRecognitionProxy.getSpeech(); // This seems to be non-blocking
			if (input != null) {
				// The parts are separated with a '*'.
				String[] inputParts = input.split("\\*");
				for (int i = 0; i < inputParts.length; i++) {
					// TODO The recognized words are prefixed with some constant that needs to be stripped off. This has to be changed in the C/C#-Code.
					String word = inputParts[i].substring(KinectProtocolConstants.SPEECH.length());
					this.connectionDataHandler.handleSpeechInput(word);
				}
			}
			
			// Sleep for 50ms - Give Kinect some time to recognize words
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
		}
		
		logger.info("Shutting down.");
	}

	public void shutdown() {
		logger.info("Shutdown requested.");
		this.run = false;
	}
	
	public void initSpeechRecognition(String[] keywords) {
		this.kinectSpeechRecognitionProxy.setup(keywords);
	}
	
	public void startSpeechRecognition() {
		this.kinectSpeechRecognitionProxy.startRecog();
	}
	
	public void stopSpeechRecognition() {
		this.kinectSpeechRecognitionProxy.stop();
	}
}

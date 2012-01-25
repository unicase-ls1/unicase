package edu.tum.in.bruegge.epd.kinect.impl.connection.jni;

import java.io.File;
import java.io.IOException;

import edu.tum.in.bruegge.epd.kinect.impl.ConnectionProcessor;

import microsoftkinectwrapper.SpeechRecognition;
import net.sf.jni4net.Bridge;

public class ProxySpeechConnectionProcessor extends ConnectionProcessor {
	
	private boolean run = false;

	private SpeechRecognition kinectSpeechRecognitionProxy;
	
	public void init() {
		try {
			Bridge.init();
			Bridge.LoadAndRegisterAssemblyFrom(new File("lib/MicrosoftKinectWrapper.j4n.dll"));
		} catch (IOException ioe) {
			// TODO: handle exception
		}
		
		this.kinectSpeechRecognitionProxy = new SpeechRecognition();
	}
	
	@Override
	public void run() {
		super.run();

		this.run = true;

		while (this.run) {
			String input = this.kinectSpeechRecognitionProxy.getSpeech();
			if (input != null) {
				String[] inputParts = input.split("\\*");
				
				System.out.println("Speech: " + inputParts);
				this.inputDataHandler.handleSpeechInput(inputParts[0]);
			}
		}
	}

	public void shutdown() {
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

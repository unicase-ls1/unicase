package edu.tum.in.bruegge.epd.kinect.impl;

import java.io.IOException;
import java.io.StringReader;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class KinectCommunicationManager {

	private KinectDataHandler dataHandler;
	
	private DocumentBuilder docBuilder;
	
	public KinectCommunicationManager(KinectDataHandler dataHandler) {
		this.dataHandler = dataHandler;
		
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			this.docBuilder = docBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void processInput(String input) {
		if (input.startsWith(KinectProtocolConstants.SPEECH)) {
			String speech = input.substring(KinectProtocolConstants.SPEECH.length());
			handleSpeechInput(speech);
		} else if (input.startsWith(KinectProtocolConstants.SKELETON)) {
			String xml = input.substring(KinectProtocolConstants.SKELETON.length());
			handleSkeletonInput(xml);
		} else {
			// TODO Handle unrecognized response
			System.out.println("Unrecognized: " + input);// throws IOException
		}
	}
	
	public void handleSpeechInput(String speech) {
		this.dataHandler.handleSpeechData(speech);
	}
	
	public void handleSkeletonInput(String xml) {
		try {
			Document doc = this.docBuilder.parse(new InputSource(new StringReader(xml)));
			this.dataHandler.handleSkeletonData(doc);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startSpeechRecognition(Set<String> keywords) {
		
	}
	
	public void stopSpeechRecognition() {
		
	}
	
	public void startSkeletonTracking() {
		
	}
	
	public void stopSkeletonTracking() {
		
	}
}

package edu.tum.in.bruegge.epd.kinect.impl;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ConnectionDataHandler {

	private KinectDataHandler dataHandler;
	private DocumentBuilder docBuilder;
	
	public void init() {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			this.docBuilder = docBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void handleSpeechInput(String input) {
		this.dataHandler.handleSpeechData(input);
	}
	
	public void handleSkeletonInput(String input) {
		try {
			Document doc = this.docBuilder.parse(new InputSource(new StringReader(input)));
			this.dataHandler.handleSkeletonData(doc);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

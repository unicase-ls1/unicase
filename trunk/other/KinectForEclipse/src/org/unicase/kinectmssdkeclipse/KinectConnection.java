package org.unicase.kinectmssdkeclipse;

/**
 * Client.java
 * 
 * Does all the basic I/O routines to connect to the Kinect and parse the skeleton
 * 
 * @author dauberschmidt
 * @author haunolder
 * @author engelmann
 * 
 * 
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.unicase.kinectmssdkeclipse.game.KinectGame;
import org.unicase.kinectmssdkeclipse.handlers.KinectEventsEnum;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class KinectConnection {

//	private static final String HOST = "192.168.178.29";
	private static final String HOST = "127.0.0.1";
	
	private static KinectConnection instance;
	private Socket socket;
	private PrintWriter writer;
	private BufferedReader reader;
	private boolean initialized = false;
	private boolean recognizing = false;
	private boolean stop = false;
	private SkeletalTracking skeletalTracking;
	private SpeechRecognition speechRecognition;
	private KinectGame kinectGame;
	private boolean skeletonTrackingInitialized;
	private Thread processInput;

	private boolean kinectGameInitialized=false;
	
	public KinectConnection() {
		this.skeletalTracking = new SkeletalTracking();
		this.speechRecognition = new SpeechRecognition(/*this*/);
		this.kinectGame= new KinectGame();
		this.kinectGame= new KinectGame();
		this.kinectGame= new KinectGame();
		this.kinectGame= new KinectGame();
		this.kinectGame= new KinectGame();
		this.kinectGame= new KinectGame();
		
	}

	public static KinectConnection getInstance(){
		if(instance == null){
			instance = new KinectConnection();
		}
		return instance;
	}

	public void openConnection()  {
		initialized = false;
		recognizing = false;
		skeletonTrackingInitialized =false;
		processInput = new Thread(new Runnable() {
			public void run() {
				try {

					socket = new Socket(HOST, 12345);
					writer = new PrintWriter(socket.getOutputStream(),true);

					reader = new BufferedReader(new InputStreamReader(socket
							.getInputStream()));
					
					while (!stop) {
						try {
							processInput();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
					
				
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		
	processInput.start();
		
	}

	public SpeechRecognition startSpeechRecog(){
	//	if(!initialized){
			subscribe(KinectEventsEnum.INITSPEECH);
			this.speechRecognition.startSpeechRecognition();
			initialized = true;
			recognizing = true;
//		}
//		else{
//			if(recognizing){
//				subscribe(KinectEventsEnum.STOPSPEECH);
//			}
//			else{
//				subscribe(KinectEventsEnum.RESUMESPEECH);
//			}
//			recognizing = !recognizing;
//		}

		return this.speechRecognition;
	}

	protected void subscribe(KinectEventsEnum subscribtion) {
		if(subscribtion != KinectEventsEnum.INITSPEECH){
			writer.println(subscribtion.toString());
		}
		else {
			writer.println(this.speechRecognition.getCommands(subscribtion.toString()));
		}
	}

	public SkeletalTracking startSkeletonTracking() {
		if (!skeletonTrackingInitialized) {
			skeletonTrackingInitialized=true;
			this.skeletalTracking.startSkeletonTracking();
			try {
				writer.println("START SKELETON TRACKING"); 
				String response;
				response = reader.readLine();
				if (!response.equalsIgnoreCase("OK")) {
					System.err.println("Starting Skeleton Tracking failed!");
				}
	
			} catch (IOException ioe) {
				System.err.println("Starting Skeleton Tracking failed!");
			}
			return this.skeletalTracking;
		
		} else {
			writer.println("STOP SKELETON TRACKING");
			return null;
		}
		
	}
	
	public void startKinectGame() {
		if (!kinectGameInitialized) {
			kinectGameInitialized=true;
			kinectGame.startGame();
		}
	}

	private void processInput() throws IOException {
		try{
			String line;
			line = reader.readLine();

			String recog = "RECOGNIZED: ";
			String skeleton = "SKELETON: ";
			
			
			if(line.startsWith(recog)){
				String word = line.substring(recog.length());
				this.speechRecognition.fireSpeechEvent(word);
			} else if(line.startsWith(skeleton)){
				String xml = line.substring(skeleton.length());

				DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document doc = docBuilder.parse(new InputSource(new StringReader(xml)));
				this.skeletalTracking.parseSkeletonData(doc);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeConnection() {
		processInput.stop();
		writer.write("CLOSE CONNECTION");
		writer.close();
		try {
			reader.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendToKinectServer(String newCommands) {
		writer.println(newCommands);
		
	}

	public void startGestureRecognition() {
		this.skeletalTracking.startGestureRecoginition();
		
	}


}

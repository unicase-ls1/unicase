package org.unicase.kinectmssdkeclipse.handlers;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import microsoftkinectwrapper.IKinectHandler;
import microsoftkinectwrapper.ISpeechRecognition;
import microsoftkinectwrapper.KinectHandler;
import net.sf.jni4net.Bridge;
import org.unicase.kinectmssdkeclipse.SkeletalTracking;
import org.unicase.kinectmssdkeclipse.SpeechRecognition;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class KinectProxy {
	private static boolean stop = false;
	private static SkeletalTracking skeletalTracking;
	private static SpeechRecognition speechRecognition;
	private static boolean isKinectSkeletonSetup = false;
	private static boolean skeletonTrackingInitialized = false;
	private static boolean gestureRecognitionInitialized = false;
	private static boolean speechRecognitionInitialized = false;
	private static IKinectHandler kinectHandler;
	private static ISpeechRecognition speechRecognitionWrapper;
	
	private static void processInput() throws IOException {
		if (skeletonTrackingInitialized || gestureRecognitionInitialized || speechRecognitionInitialized) {
			String[] kinectResultArr = null;
			try{
				
				String recog = "RECOGNIZED: ";
				//String skeleton = "SKELETON: ";
				String kinectResult;
				kinectResult = kinectHandler.getSkeleton();
				//kinectResult = speechRecognitionWrapper.getSpeech();
				
				if (null != kinectResult) {
					//System.out.println(kinectResult);
					kinectResultArr = kinectResult.split("\\*");
					String token;
					
					for (int i = 0; i < kinectResultArr.length; i++) {
						token = kinectResultArr[i];
						
						if(token.startsWith(recog)){ 
								String word = token.substring(recog.length());
								speechRecognition.fireSpeechEvent(word);
							} else if(/*token.startsWith(skeleton)*/ true){
								String xml = /*token.substring(skeleton.length());*/ token;
								//System.out.println(token);
								//if ((i + 1)< kinectResultArr.length)
									//System.out.println(kinectResultArr[i + 1]);
								//if (token.contains("joint"))
									//System.out.println(token);
								DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
								Document doc = docBuilder.parse(new InputSource(new StringReader(xml)));
								skeletalTracking.parseSkeletonData(doc);
							}
					}
				}
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					/*
					System.out.println("Contents:");
					for (int i = 0; i < kinectResultArr.length; i++) {
						System.out.println(kinectResultArr[i]);
					}
					*/
					e.printStackTrace();
				} 
		}

	}

	
	private static void subscribe(KinectEventsEnum subscribtion) {
		if(subscribtion != KinectEventsEnum.INITSPEECH){
			System.out.println(subscribtion.toString());
		}
		else {
			speechRecognitionWrapper.setup(speechRecognition.getCommands(subscribtion.toString()).split(", "));
		}
	}
	
	public static boolean startSpeechRecog(){
		subscribe(KinectEventsEnum.INITSPEECH);
		speechRecognitionInitialized = true;
		return true;
	}
	
	
	public static void startSkeletonTracking() {
		if (!isKinectSkeletonSetup)
			kinectSkeletonSetup();
		if (!skeletonTrackingInitialized) {
			skeletonTrackingInitialized = true;
			skeletalTracking.startSkeletonTracking();
		}
	}
	
	public static void startGestureRecognition() {
		if (!isKinectSkeletonSetup)
			kinectSkeletonSetup();
		if (!gestureRecognitionInitialized) {
			gestureRecognitionInitialized = true;
			skeletalTracking.startGestureRecoginition();
		}
	}
	
	
	public static void kinectSkeletonSetup() {
		isKinectSkeletonSetup = true;
		System.out.println(kinectHandler.setUpAndRun());
	}
	
	public static void handle() {
		
		try {
			Bridge.init();
			Bridge.LoadAndRegisterAssemblyFrom(new java.io.File("lib/MicrosoftKinectWrapper.j4n.dll"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
        kinectHandler = new KinectHandler();
        speechRecognitionWrapper = new microsoftkinectwrapper.SpeechRecognition();
		skeletalTracking = new SkeletalTracking();
		speechRecognition = new SpeechRecognition();
		System.out.println("Connected to Kinect!");
		Thread processInput = new Thread(new Runnable() {
			public void run() {			
					while (!stop) {
						try {
							processInput();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
			}
		});
		
	processInput.start();
	}
	
	
	public static void stopHandle() {
		stop = true;
	}
}

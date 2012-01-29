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
import org.unicase.kinectmssdkeclipse.game.GestureListener;
import org.unicase.kinectmssdkeclipse.game.SpeechListener;
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
	private static boolean isKinectInitialized = false;

	private static void processInput() throws IOException {
		if (skeletonTrackingInitialized || gestureRecognitionInitialized
				|| speechRecognitionInitialized) {
			String[] kinectResultArr = null;
			String[] kinectResultSpeechArr = null;
			try {

				String recog = "RECOGNIZED: ";
				// String skeleton = "SKELETON: ";
				String kinectResult;
				String kinectResultSpeech;
				kinectResult = kinectHandler.getSkeleton();
				kinectResultSpeech = speechRecognitionWrapper.getSpeech();

				if (null != kinectResult || null != kinectResultSpeech) {
					String token;
					if (null != kinectResult) {
						kinectResultArr = kinectResult.split("\\*");
						for (int i = 0; i < kinectResultArr.length; i++) {
							token = kinectResultArr[i];
							DocumentBuilder docBuilder = DocumentBuilderFactory
									.newInstance().newDocumentBuilder();
							Document doc = docBuilder.parse(new InputSource(
									new StringReader(token)));
							skeletalTracking.parseSkeletonData(doc);
						}
					}
					if (null != kinectResultSpeech) {
						kinectResultSpeechArr = kinectResultSpeech.split("\\*");
						for (int i = 0; i < kinectResultSpeechArr.length; i++) {
							token = kinectResultSpeechArr[i];
							String word = token.substring(recog.length());
							speechRecognition.fireSpeechEvent(word);
						}
					}
				}
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				/*
				 * System.out.println("Contents:"); for (int i = 0; i <
				 * kinectResultArr.length; i++) {
				 * System.out.println(kinectResultArr[i]); }
				 */
				e.printStackTrace();
			}
		}

	}

	private static void subscribe(KinectEventsEnum subscribtion) {
		if (subscribtion != KinectEventsEnum.INITSPEECH) {
			System.out.println(subscribtion.toString());
		} else {
			speechRecognitionWrapper.setup(speechRecognition.getCommands(
					subscribtion.toString()).split(", "));
		}
	}

	public static boolean startSpeechRecog() {
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

	public static void handle(GestureListener listener) {

		if (!isKinectInitialized) {
			try {
				Bridge.init();
				Bridge.LoadAndRegisterAssemblyFrom(new java.io.File(
						"lib/MicrosoftKinectWrapper.j4n.dll"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			kinectHandler = new KinectHandler();
			speechRecognitionWrapper = new microsoftkinectwrapper.SpeechRecognition();
			skeletalTracking = new SkeletalTracking();
			skeletalTracking.setGestureListener(listener);
			speechRecognition = new SpeechRecognition();
			speechRecognition.setSpeechListener((SpeechListener) listener);
			isKinectInitialized = true;
		}

		// make stop as false and start the handler thread
		stop = false;

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

	public static void stopGestureRecognition() {
		// isKinectSkeletonSetup = false;
		// gestureRecognitionInitialized = false;
		// skeletalTracking.stopGestureRecognition();
		skeletalTracking.suspendGestureRecognition();
	}

	public static void stopHandle() {
		stop = true;
	}
}

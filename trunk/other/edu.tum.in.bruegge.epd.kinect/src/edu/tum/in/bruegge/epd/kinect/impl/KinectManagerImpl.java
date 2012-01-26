package edu.tum.in.bruegge.epd.kinect.impl;

import humanbodymodel.HumanContainer;
import humandiagramgef.HumanBodyModelUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Document;

import edu.tum.in.bruegge.epd.kinect.KinectManager;
import edu.tum.in.bruegge.epd.kinect.SpeechListener;
import edu.tum.in.bruegge.epd.kinect.impl.connection.jni.ProxyConnectionManager;

public class KinectManagerImpl implements KinectManager, KinectDataHandler {

	private static final KinectManager INSTANCE = new KinectManagerImpl();
	public static KinectManager getInstance() {
		return INSTANCE;
	}
	private ConnectionManager connectionManager;// =
												// KinectConnectionManager.getInstance();

	private HumanBodyModelUtils humanBodyHandler = new HumanBodyModelUtils();
	private SkeletonParser skeletonParser;

	private Map<SpeechListener, Set<String>> speechWords = new HashMap<SpeechListener, Set<String>>();
	private Map<String, Set<SpeechListener>> filteredSpeechListeners = new HashMap<String, Set<SpeechListener>>();
	private Set<SpeechListener> unfilteredSpeechListeners = new HashSet<SpeechListener>();

	public KinectManagerImpl() {
		// this.connectionManager = new SocketConnectionManager();
		this.connectionManager = new ProxyConnectionManager();
		this.skeletonParser = new SkeletonParser(this.humanBodyHandler);
	}

	

	@Override
	public void startKinect() {
		try {
			this.connectionManager.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void stopKinect() {
		try {
			this.connectionManager.closeConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public HumanContainer getSkeletonModel() {
		return this.humanBodyHandler.getHumanContainer();
	}

	@Override
	public void startSkeletonTracking() {
		this.connectionManager.startSkeletonTracking();
	}

	@Override
	public void stopSkeletonTracking() {
		// empty
	}

	@Override
	public void addSpeechListener(SpeechListener listener) {
		this.speechWords.put(listener, listener.getWords());
		if (listener.isFiltered()) {
			for (String word : listener.getWords()) {
				if (!this.filteredSpeechListeners.containsKey(word)) {
					this.filteredSpeechListeners.put(word, new HashSet<SpeechListener>());
				}
				this.filteredSpeechListeners.get(word).add(listener);
			}
		} else {
			this.unfilteredSpeechListeners.add(listener);
		}
	}

	@Override
	public void removeSpeechListener(SpeechListener listener) {
		this.speechWords.remove(listener);
		for (String word : listener.getWords()) {
			this.filteredSpeechListeners.get(word).remove(listener);
		}
		this.unfilteredSpeechListeners.remove(listener);
	}

	@Override
	public void startSpeechRecognition() {
		Set<String> words = new HashSet<String>();
		for (Set<String> listenerWords : this.speechWords.values()) {
			words.addAll(listenerWords);
		}

		String[] keywords = words.toArray(new String[words.size()]);
		this.connectionManager.startSpeechRecognition(keywords);
	}

	@Override
	public void stopSpeechRecognition() {
		// empty
	}

	@Override
	public void handleSkeletonData(Document doc) {
		this.skeletonParser.parseSkeleton(doc);
	}

	@Override
	public void handleSpeechData(String word) {
		Set<SpeechListener> listeners = new HashSet<SpeechListener>();
		listeners.addAll(this.unfilteredSpeechListeners);
		listeners.addAll(this.filteredSpeechListeners.get(word));

		for (SpeechListener listener : listeners) {
			listener.notifySpeech(word);
		}
	}

}

package edu.tum.in.bruegge.epd.kinect.game.listeners;

import java.util.HashSet;
import java.util.Set;

import edu.tum.in.bruegge.epd.kinect.SpeechListener;

public class GameSpeechListener extends SpeechListener {

	private static final String DEBUG_START = "Start debug mode";
	private static final String FIX_BUG = "Fix bug";

	private static final Set<String> words = new HashSet<String>();

	static {
		words.add(DEBUG_START);
		words.add(FIX_BUG);
	}

	ISpeechListener speechListener = null;

	public GameSpeechListener(ISpeechListener speechListener) {
		this.speechListener = speechListener;
	}

	@Override
	public void notifySpeech(String speech) {
		speechListener.notifySpeech(speech);
	}

	@Override
	public Set<String> getWords() {
		return words;
	}
}

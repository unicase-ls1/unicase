package edu.tum.in.bruegge.epd.kinect;

import java.util.Set;

public abstract class SpeechListener {

	public abstract void notifySpeech(String speech);
	
	public abstract Set<String> getWords();
	
	public boolean isFiltered() {
		return true;
	}
}

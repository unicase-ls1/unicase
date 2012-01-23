package edu.tum.in.bruegge.epd.kinect;

import java.util.HashSet;
import java.util.Set;

public abstract class SpeechListener {

	public abstract void notifySpeech(String speech);
	
	public Set<String> getWords() {
		return new HashSet<String>();
	}
	
	public boolean isFiltered() {
		return false;
	}
}

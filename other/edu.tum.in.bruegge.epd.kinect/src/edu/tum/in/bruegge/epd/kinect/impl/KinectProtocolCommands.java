package edu.tum.in.bruegge.epd.kinect.impl;

public enum KinectProtocolCommands {

	SWIPELEFT("SWIPELEFT"),
	SWIPERIGHT("SWIPERIGHT"),
	SWIPEUP("SWIPEUP"),
	SWIPEDOWN("SWIPEDOWN"),
	CLICK("CLICK"),
	ONCIRCLE("ONCIRCLE"),
	OFFCIRCLE("OFFCIRCLE"),
	SESSIONSTART("SESSIONSTART"), 
	SESSIONEND("SESSIONEND"),
	INITSPEECH("INIT SPEECH RECOGNITION: "), // Followed by a list of keywords
	RESUMESPEECH("RESUME SPEECH RECOGNITION"),
	STOPSPEECH("STOP SPEECH RECOGNITION");
	
	
	private final String command;
	
	private KinectProtocolCommands(String command) {
		this.command = command;
	}
	
	public String getCommand() {
		return this.command;
	}
}

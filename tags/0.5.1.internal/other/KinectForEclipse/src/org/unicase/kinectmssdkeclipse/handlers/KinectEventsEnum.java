package org.unicase.kinectmssdkeclipse.handlers;

import java.util.HashMap;
public enum KinectEventsEnum {
    SWIPELEFT("SWIPELEFT"), SWIPERIGHT("SWIPERIGHT"), SWIPEUP("SWIPEUP"), SWIPEDOWN(
	    "SWIPEDOWN"), CLICK("CLICK"), ONCIRCLE("ONCIRCLE"), OFFCIRCLE(
	    "OFFCIRCLE"), SESSIONSTART("SESSIONSTART"), SESSIONEND("SESSIONEND"), INITSPEECH("INIT SPEECH RECOGNITION: "), RESUMESPEECH("RESUME SPEECH RECOGNITION"), STOPSPEECH("STOP SPEECH RECOGNITION");

    private final String kinectEventNameName;

    KinectEventsEnum(String name) {
	kinectEventNameName = name;
    }

   private final static HashMap<String, KinectEventsEnum> nameMap = new HashMap<String, KinectEventsEnum>();    
   static {
	for (KinectEventsEnum type : values()) {
	    nameMap.put(type.kinectEventNameName, type);	    
	}
    }

    public static KinectEventsEnum getEventByName(String input) {
	return nameMap.get(input);
    }

    @Override
    public String toString() {
	return kinectEventNameName;
    }
}

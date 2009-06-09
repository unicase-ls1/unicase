package org.unicase.ui.tom.notifications;

import org.unicase.ui.tom.gestures.Gesture;

public class GestureNotificationImpl implements GestureNotification{

	private int eventType;

	private Gesture gesture;

	public GestureNotificationImpl(Gesture gesture, int eventType) {
		super();
		
		setGesture(gesture);
		setEventType(eventType);
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	public int getEventType() {
		return eventType;
	}

	public void setGesture(Gesture gesture) {
		this.gesture = gesture;
	}

	public Gesture getGesture() {
		return gesture;
	}


}

package org.unicase.ui.tom.notifications;

import org.unicase.ui.tom.touches.Touch;

public class TouchNotificationImpl implements TouchNotification {

	private int eventType;
	private Touch touch;
	
	public TouchNotificationImpl(Touch touch, int eventType) {
		super();
		
		setTouch(touch);
		setEventType(eventType);
	}
	
	public int getEventType() {
		return eventType;
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	public void setTouch(Touch touch) {
		this.touch = touch;
	}

	public Touch getTouch() {
		return touch;
	}

}

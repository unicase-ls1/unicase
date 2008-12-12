package org.unicase.ui.tom;

import java.util.ArrayList;
import java.util.List;

import org.unicase.ui.tom.notifications.TouchNotification;
import org.unicase.ui.tom.notifications.TouchNotificationImpl;
import org.unicase.ui.tom.notifications.TouchNotifierImpl;
import org.unicase.ui.tom.touches.Touch;

public abstract class TouchDispatch extends TouchNotifierImpl{
	
	private List<Touch> activeTouches;
	private List<Touch> removedTouches;
	protected static TouchDispatch instance;
	
	protected TouchDispatch() {
		super();
		setActiveTouches(new ArrayList<Touch>());
		setRemovedTouches(new ArrayList<Touch>());
	}
	
	void addTouch(Touch touch){
		getActiveTouches().add(touch);
		notifyAdapters(new TouchNotificationImpl(touch,TouchNotification.touchAdded));
	}
	
	void removeTouch(Touch touch){
		boolean remove = getActiveTouches().remove(touch);
		if (!remove) {
			getRemovedTouches().remove(touch);
		}else{
			getRemovedTouches().add(touch);
		}
		
		notifyAdapters(new TouchNotificationImpl(touch,TouchNotification.touchRemoved));
	}
	
	void updateTouch(Touch touch){
		notifyAdapters(new TouchNotificationImpl(touch,TouchNotification.touchChanged));
	}

	public static TouchDispatch getInstance() {
		return instance;
	}

	public void setActiveTouches(List<Touch> touches) {
		this.activeTouches = touches;
	}

	public List<Touch> getActiveTouches() {
		return activeTouches;
	}

	public void setRemovedTouches(List<Touch> removedTouches) {
		this.removedTouches = removedTouches;
	}

	public List<Touch> getRemovedTouches() {
		return removedTouches;
	}	
	
}

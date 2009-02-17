package org.unicase.ui.tom;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.unicase.ui.tom.notifications.TouchNotification;
import org.unicase.ui.tom.notifications.TouchNotificationImpl;
import org.unicase.ui.tom.notifications.TouchNotifierImpl;
import org.unicase.ui.tom.tools.TouchUtility;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;
import org.unicase.ui.tom.touches.Touch;

/**
 * @author schroech
 *
 */
public abstract class TouchDispatch extends TouchNotifierImpl{

	private List<MultiTouch> activeMultiTouches;
	private List<MultiTouch> removedMultiTouches;

	private List<SingleTouch> activeSingleTouches;
	private List<SingleTouch> removedSingleTouches;

	/**
	 * Singleton instance.
	 */
	protected static TouchDispatch instance;

	/**
	 * Default constructor. 
	 */
	protected TouchDispatch() {
		super();
		setActiveSingleTouches(new ArrayList<SingleTouch>());
		setRemovedTouches(new ArrayList<SingleTouch>());

		setActiveMultiTouches(new ArrayList<MultiTouch>());
		setRemovedMultiTouches(new ArrayList<MultiTouch>());
	}

	/**
	 * Adds a touch to the list of activeTouches and notifies adapters listening for TouchAdded events.
	 * 
	 * @param touch The touch to add
	 */
	void addTouch(SingleTouch touch){
		assignMultiTouch(touch);

		getActiveSingleTouches().add(touch);
		notifyAdapters(new TouchNotificationImpl(touch, TouchNotification.touchAdded));
		notifyAdapters(new TouchNotificationImpl(touch, TouchNotification.touchPropagated));
	}

	private void assignMultiTouch(Touch touch) {
		Set<Touch> directNeighbors = TouchUtility.findDirectNeighbors(
				touch, 
				getActiveSingleTouches());

		if (directNeighbors.size() == 0) {
			MultiTouch multiTouch = new MultiTouch();
			multiTouch.addTouch(touch);

			getActiveMultiTouches().add(multiTouch);
		}else{
			for (Touch neighbor : directNeighbors) {
				MultiTouch multiTouch = neighbor.getMultiTouch();
				if (multiTouch != null) {
					multiTouch.addTouch(touch);
					break;
				}
			}
		}
	}


	/**
	 * Removes a touch from the list of activeTouches, adds it to the list of removed touches and notifies adapters listening for TouchAdded events.
	 * 
	 * @param touch The touch to remove
	 */
	void removeTouch(SingleTouch touch){
		boolean remove = getActiveSingleTouches().remove(touch);
		if (!remove) {
			getRemovedTouches().remove(touch);
		}else{
			getRemovedTouches().add(touch);
		}
		
		MultiTouch multiTouch = touch.getMultiTouch();
		multiTouch.removeTouch(touch);
		
		List<Touch> activeTouches = multiTouch.getActiveTouches();
		if (activeTouches.size() == 0) {
			if (getActiveMultiTouches().contains(multiTouch)) {
				getActiveMultiTouches().remove(multiTouch);
				getRemovedMultiTouches().add(multiTouch);
			}
		}

		notifyAdapters(new TouchNotificationImpl(touch,TouchNotification.touchRemoved));
		notifyAdapters(new TouchNotificationImpl(touch, TouchNotification.touchPropagated));
	}

	/**
	 * Updates a touch and it's group if necessary.
	 * 
	 * @param touch The {@link Touch} to update 
	 */
	void updateTouch(Touch touch){
		MultiTouch multiTouch = touch.getMultiTouch();
		List<Touch> activeTouches = multiTouch.getActiveTouches();
		if (activeTouches.size() > 1) {
			Set<Touch> directMultiTouchNeighbors = TouchUtility.findDirectNeighbors(touch, activeTouches);
			if (directMultiTouchNeighbors.size() == 0) {
				assignMultiTouch(touch);
			}
		}
		
		notifyAdapters(new TouchNotificationImpl(touch,TouchNotification.touchChanged));
		notifyAdapters(new TouchNotificationImpl(touch, TouchNotification.touchPropagated));
	}

	/**
	 * @return The singleton instance
	 */
	public static TouchDispatch getInstance() {
		return instance;
	}

	public void setActiveSingleTouches(List<SingleTouch> touches) {
		this.activeSingleTouches = touches;
	}

	public List<SingleTouch> getActiveSingleTouches() {
		return activeSingleTouches;
	}

	public void setRemovedTouches(List<SingleTouch> removedTouches) {
		this.removedSingleTouches = removedTouches;
	}

	public List<SingleTouch> getRemovedTouches() {
		return removedSingleTouches;
	}

	public void setActiveMultiTouches(List<MultiTouch> activeMultiTouches) {
		this.activeMultiTouches = activeMultiTouches;
	}

	public List<MultiTouch> getActiveMultiTouches() {
		return activeMultiTouches;
	}

	public void setRemovedMultiTouches(List<MultiTouch> removedMultiTouches) {
		this.removedMultiTouches = removedMultiTouches;
	}

	public List<MultiTouch> getRemovedMultiTouches() {
		return removedMultiTouches;
	}	

}

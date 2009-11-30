package org.unicase.ui.tom.touches;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.notifications.TouchAdapter;
import org.unicase.ui.tom.notifications.TouchNotification;
import org.unicase.ui.tom.notifications.TouchNotificationImpl;
import org.unicase.ui.tom.notifications.TouchNotifier;
import org.unicase.ui.tom.notifications.TouchNotifierImpl;
import org.unicase.ui.tom.tools.TouchUtility;

/**
 * @author schroech
 *
 */
public class MultiTouch extends AbstractTouch{

	private List<Touch> activeTouches;
	private List<Touch> removedTouches;

	/**
	 * Default constructor. 
	 */
	public MultiTouch() {
		setActiveTouches(new ArrayList<Touch>());
		setRemovedTouches(new ArrayList<Touch>());
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getPosition()
	 */
	public Point getPosition() {
		PointList allPositions = new PointList();
		
		for (Touch activeTouch : activeTouches) {
			Point position = activeTouch.getPosition();
			allPositions.addPoint(position);
		}
		
		return allPositions.getBounds().getCenter();
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getTouchDownDate()
	 */
	public Date getTouchDownDate() {
		Touch firstDownTouch = null;

		List<Touch> allTouches = new ArrayList<Touch>();
		allTouches.addAll(getActiveTouches());
		allTouches.addAll(getRemovedTouches());

		for (Touch activeTouch: allTouches) {
			if (firstDownTouch == null) {
				firstDownTouch = activeTouch;
			}else if (activeTouch.getTouchDownDate().compareTo(firstDownTouch.getTouchDownDate()) < 0) {
				firstDownTouch = activeTouch;
			}
		}

		return firstDownTouch.getTouchDownDate();
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getTouchUpDate()
	 */
	public Date getTouchUpDate() {
		Touch lastUpTouch = null;

		List<Touch> allTouches = new ArrayList<Touch>();
		allTouches.addAll(getActiveTouches());
		allTouches.addAll(getRemovedTouches());

		for (Touch activeTouch: allTouches) {
			if (lastUpTouch == null) {
				lastUpTouch = activeTouch;
			}else if (activeTouch.getTouchDownDate().compareTo(lastUpTouch.getTouchDownDate()) > 0) {
				lastUpTouch = activeTouch;
			}
		}

		return lastUpTouch.getTouchUpDate();
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getX()
	 */
	public int getX() {
		PointList points = new PointList();
		for (Touch activeTouch : getActiveTouches()) {
			points.addPoint(activeTouch.getPosition());
		}
		return points.getMidpoint().x;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getY()
	 */
	public int getY() {
		PointList points = new PointList();
		for (Touch activeTouch : getActiveTouches()) {
			points.addPoint(activeTouch.getPosition());
		}

		return points.getMidpoint().y;
	}

	public void addTouch(Touch touch){
		activeTouches.add(touch);
		touch.setMultiTouch(this);
	}

	public void removeTouch(Touch touch){
		if (activeTouches.contains(touch)) {
			activeTouches.remove(touch);
			removedTouches.add(touch);
		}
	}

	/**
	 * @param activeTouches
	 */
	private void setActiveTouches(List<Touch> activeTouches) {
		this.activeTouches = activeTouches;
	}


	public List<Touch> getActiveTouches() {
		return activeTouches;
	}


	private void setRemovedTouches(List<Touch> removedTouches) {
		this.removedTouches = removedTouches;
	}


	public List<Touch> getRemovedTouches() {
		return removedTouches;
	}

}

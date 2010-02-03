/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.touches;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

/**
 * @author schroech
 *
 */
public class MultiTouch extends AbstractTouch{

	private final List<SingleTouch> activeTouches = new ArrayList<SingleTouch>();
	private final List<SingleTouch> removedTouches = new ArrayList<SingleTouch>();
	private boolean isClaimed;
	
	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getPosition()
	 */
	public Point getAbsolutePosition() {
		PointList allPositions = new PointList();
		
		for (Touch activeTouch : activeTouches) {
			Point position = activeTouch.getAbsolutePosition();
			allPositions.addPoint(position);
		}
		
		return allPositions.getBounds().getCenter();
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getPosition()
	 */
	public Point getPosition() {
		PointList allPositions = new PointList();
		
		if (activeTouches.size() == 0) {
			for (Touch removedTouch : removedTouches) {
				Point position = removedTouch.getPosition();
				allPositions.addPoint(position);
			}
		}else{
			for (Touch activeTouch : activeTouches) {
				Point position = activeTouch.getPosition();
				allPositions.addPoint(position);
			}
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
	public int getAbsoluteX() {
		PointList points = new PointList();
		for (Touch activeTouch : getActiveTouches()) {
			points.addPoint(activeTouch.getAbsolutePosition());
		}
		return points.getMidpoint().x;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getY()
	 */
	public int getAbsoluteY() {
		PointList points = new PointList();
		for (Touch activeTouch : getActiveTouches()) {
			points.addPoint(activeTouch.getPosition());
		}

		return points.getMidpoint().y;
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

	/**
	 * @param touch The single touch belonging to this multitouch
	 */
	public void addTouch(SingleTouch touch){
		activeTouches.add(touch);
		touch.setMultiTouch(this);
	}

	/**
	 * @param touch The single no longer belonging to this multitouch
	 */
	public void removeTouch(SingleTouch touch){
		if (activeTouches.contains(touch)) {
			activeTouches.remove(touch);
			removedTouches.add(touch);
		}
	}

	/**
	 * @return The touches of this multitouch still touching the table 
	 */
	public List<SingleTouch> getActiveTouches() {
		return activeTouches;
	}

	/**
	 * @return The touches of this multitouch no longer touching the table 
	 */
	public List<SingleTouch> getRemovedTouches() {
		return removedTouches;
	}
	
	/**
	 * @return All the touches belonging to this multitouch
	 */
	public List<SingleTouch> getAllTouches() {
		List<SingleTouch>allTouches = new ArrayList<SingleTouch>();
		allTouches.addAll(getRemovedTouches());
		allTouches.addAll(getActiveTouches());
		return allTouches;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#setClaimed(boolean)
	 */
	public void setClaimed(boolean isClaimed) {
		this.isClaimed = isClaimed;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#isClaimed()
	 */
	public boolean isClaimed() {
		return isClaimed;
	}

}

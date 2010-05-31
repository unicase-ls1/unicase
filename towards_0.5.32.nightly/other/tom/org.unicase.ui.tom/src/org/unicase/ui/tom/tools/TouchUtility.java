/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IOvalAnchorableFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IPolygonAnchorableFigure;
import org.unicase.ui.tom.touches.SingleTouch;
import org.unicase.ui.tom.touches.Touch;

/**
 * @author schroech
 *
 */
public final class TouchUtility {

	private TouchUtility() {
	}
	
	/**
	 * Returns the current positions of the input {@link SingleTouch}es as a {@link PointList}. 
	 * 
	 * @param touches A {@link Collection} of {@link SingleTouch}es. May not be null.
	 * @return A {@link PointList}. May be empty. 
	 */
	public static PointList pointListOfCurrentPositions(Collection<SingleTouch> touches){
		PointList pointList = new PointList();
		for (Touch touch : touches) {
			Point position = touch.getPosition();
			pointList.addPoint(position);
		}
		return pointList;
	}
	                                                              
	/**
	 * @param touches The touches being evaluated
	 * @return
	 * A list of {@link Touch}es being adjacent to the touch
	 */
	public static Set<Set<Touch>> findNeighborhoods(List<Touch> touches) {
		Set<Set<Touch>> neighborhoods = new HashSet<Set<Touch>>();
		List<Touch> uninspectedTouches = new ArrayList<Touch>();
		
		uninspectedTouches.addAll(touches);
		
		while(uninspectedTouches.size() > 0){
			Touch currentTouch = uninspectedTouches.get(0);
			
			Set<Touch> neighbors = new HashSet<Touch>();
			
			neighbors.add(currentTouch);
			neighbors.addAll(findNeighbors(currentTouch, uninspectedTouches));
			
			uninspectedTouches.removeAll(neighbors);
			
			neighborhoods.add(neighbors);
		}
		
		return neighborhoods;
	}
	
	/**
	 * @param touch The touch whose adjacency is evaluated 
	 * @param touches The touches being compared to the touch
	 * @return
	 * A list of {@link Touch}es being adjacent to the touch
	 */
	public static Set<Touch> findNeighbors(Touch touch, List<Touch> touches) {
		Set<Touch> neighbors = new HashSet<Touch>();
		Set<Touch> uninspectedTouches = new HashSet<Touch>();
		
		uninspectedTouches.add(touch);
		
		while (uninspectedTouches.size() > 0) {
			Touch currentInspectedTouch = uninspectedTouches.iterator().next();
			
			neighbors.addAll(findDirectNeighbors(currentInspectedTouch, uninspectedTouches));
			
			uninspectedTouches.addAll(neighbors);			
			uninspectedTouches.remove(currentInspectedTouch);
		}
		
		return neighbors;
	}
	
	
	/**
	 * @param touch The touch whose adjacency is evaluated 
	 * @param touches The touches being compared to the touch
	 * @return
	 * A list of {@link Touch}es being directly adjacent to the touch
	 */
	public static Set<Touch> findDirectNeighbors(Touch touch, Collection<? extends Touch> touches) {
		Set<Touch> adjacentTouches = new HashSet<Touch>();

		Point position = touch.getPosition();

		for (Touch currentTouch : touches) {
			Point currentPosition = currentTouch.getPosition();
			double distance = position.getDistance(currentPosition);

			int tolerance = TouchConstants.MULTITOUCH_DIAMETER/2 + TouchConstants.TOUCH_DIAMETER/2;
			if (distance < tolerance) {
				adjacentTouches.add(currentTouch);
			}
		}

		return adjacentTouches;
	}

	/**
	 * @param touches The touches whose adjacency is to be determined
	 * @return
	 * true if the touches are adjacent, false otherwise
	 */
	public static boolean touchesAreNeighbors(List<Touch> touches) {
		Set<Touch> distantTouches = new HashSet<Touch>();
		Set<Touch> adjacentTouches = new HashSet<Touch>();

		distantTouches.addAll(touches);

		if (touches.size() == 0) {
			return false;
		}

		Touch touch = distantTouches.iterator().next();
		distantTouches.remove(touch);
		adjacentTouches.add(touch);

		while (adjacentTouches.size() > 0) {
			Touch currentTouch = adjacentTouches.iterator().next();
			
			Set<Touch> currentAdjacentTouches = findDirectNeighbors(currentTouch, distantTouches);
			distantTouches.removeAll(currentAdjacentTouches);
			
			adjacentTouches.addAll(currentAdjacentTouches);
			adjacentTouches.remove(currentTouch);		
		}
		
		if (distantTouches.size() > 0) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * @param touches The touches being evaluated
	 * @return
	 * The midpoint of the touches
	 */
	public static Point touchesMidPoint(List<Touch> touches) {
		PointList touchPoints = new PointList();
		
		for (Touch touch : touches) {
			touchPoints.addPoint(touch.getPosition());
		}

		return touchPoints.getMidpoint();
	}
	
	
	/**
	 * @param firstTouch The first touch
	 * @param secondTouch The second touch
	 * @param distance The allowed distance
	 * @return
	 * true if the points distance is smaller than the input distance 
	 */
	public static boolean pointsInDistance(Touch firstTouch, Touch secondTouch, float distance){
		return (firstTouch.getPosition().getDistance(secondTouch.getPosition()) < distance);
	}
	
	/**
	 * @param figure The figure possibly containing the point
	 * @param position The point possibly in the figure 
	 * @return
	 * true if the point is in the figure
	 */
	public static boolean shapeContainsPoint(IFigure figure, Point position) {
		
		boolean containsPoint = false;
		
		if (figure instanceof IOvalAnchorableFigure) {
			//If the figure is an oval we assume the 
			//oval's hit testing is good enough   
			containsPoint =  figure.containsPoint(position);	
		}else if (figure instanceof IPolygonAnchorableFigure) {
			Rectangle bounds = ((IPolygonAnchorableFigure) figure).getPolygonPoints().getBounds().getCopy();
			bounds.expand(TouchConstants.TOUCH_DIAMETER/2, TouchConstants.TOUCH_DIAMETER/2);
			containsPoint = bounds.contains(position);
		}else{
			Rectangle bounds = figure.getBounds().getCopy();
			bounds.expand(TouchConstants.TOUCH_DIAMETER/2, TouchConstants.TOUCH_DIAMETER/2);
			containsPoint = bounds.contains(position);
		}
		
		return containsPoint;
	}
}

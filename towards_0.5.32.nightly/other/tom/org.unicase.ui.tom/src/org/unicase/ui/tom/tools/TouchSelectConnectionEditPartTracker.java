/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.tools;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.gef.ui.internal.tools.SelectConnectionEditPartTracker;

/**
 * @author schroech
 *
 */
@SuppressWarnings("restriction")
public class TouchSelectConnectionEditPartTracker extends
		SelectConnectionEditPartTracker {
	
	/**
	 * The diameter of a touch.
	 */
	public static final int TOUCH_DIAMETER = 30;
	
	/**
	 * Default constructor. 
	 * 
	 * @param owner The {@link ConnectionEditPart} this tracker operates on
	 */
	public TouchSelectConnectionEditPartTracker(ConnectionEditPart owner) {
		super(owner);
	}

	/** 
	 * @see org.eclipse.gef.tools.AbstractTool#handleButtonDown(int)
	 * Resembles the superclass implementation while taking the touch diameter into account 
	 * 
	 *	@param button which button went down
 	 *	@return <code>true</code> if the buttonDown was handled
	 * 
	 */
	@Override
	protected boolean handleButtonDown(int button) {
		if (!super.handleButtonDown(button)) {
			return false;
		}

		Point p = getLocation();
		getConnection().translateToRelative(p);
		
		PointList points = getConnection().getPoints();
		Dimension size = new Dimension((TOUCH_DIAMETER * 2),(TOUCH_DIAMETER * 2));
		for (int i=1; i<points.size()-1; i++) {
			Point ptCenter = points.getPoint(i);
			Rectangle rect = new Rectangle( ptCenter.x - size.width / 2, ptCenter.y - size.height / 2, size.width, size.height);
			
			if (rect.contains(p)) {
				setType(RequestConstants.REQ_MOVE_BENDPOINT);
				setIndex(i);
			}
		}
		
		if (getIndex() == -1) {
			setIndex(PointListUtilities.findNearestLineSegIndexOfPoint(getConnection().getPoints(), new Point(p.x, p.y)));
	
			setIndex(getIndex() - 1);
			setType(RequestConstants.REQ_CREATE_BENDPOINT);
		}
		
		return true;
	}
	
	/**
	 * @return the <code>Connection</code> that is referenced by the connection edit part.
	 * Resembles the private superclass implementation
	 */
	private Connection getConnection() {
		return (Connection) getConnectionEditPart().getFigure();
	}

	/**
	 * Method getConnectionEditPart.
	 * @return ConnectionEditPart
	 * Resembles the private superclass implementation
	 */
	private ConnectionEditPart getConnectionEditPart() {
		return (ConnectionEditPart)getSourceEditPart();
	}
	

}

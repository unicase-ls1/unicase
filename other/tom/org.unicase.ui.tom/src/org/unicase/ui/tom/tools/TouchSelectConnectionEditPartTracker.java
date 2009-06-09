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

@SuppressWarnings("restriction")
public class TouchSelectConnectionEditPartTracker extends
		SelectConnectionEditPartTracker {
	
	public final static int TOUCH_DIAMETER = 30;
	
	public TouchSelectConnectionEditPartTracker(ConnectionEditPart owner) {
		super(owner);
	}

	/** 
	 * @see org.eclipse.gef.tools.AbstractTool#handleButtonDown(int)
	 * Resembles the superclass implementation
	 * 
	 */
	protected boolean handleButtonDown(int button) {
		if (!super.handleButtonDown(button))
			return false;

		Point p = getLocation();
		getConnection().translateToRelative(p);
		
		PointList points = getConnection().getPoints();
		Dimension size = new Dimension(TOUCH_DIAMETER, TOUCH_DIAMETER);
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

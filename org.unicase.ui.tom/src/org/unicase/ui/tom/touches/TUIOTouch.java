package org.unicase.ui.tom.touches;

import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.Date;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.unicase.ui.tum.tuio.TuioCursor;
import org.unicase.ui.tum.tuio.TuioPoint;

public class TUIOTouch extends SingleTouch implements Touch{

	private TuioCursor cursor;
	private Dimension screenSize; 
	private PointList path;
	
	public TUIOTouch(TuioCursor cursor) {
		super();
		this.cursor = cursor;	
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		
		int i;
		if (gs.length > 1) {
			i = 1;
		}else{
			i = 0;
		}
			
		DisplayMode dm = gs[i].getDisplayMode();
		
	    int screenWidth = dm.getWidth();
	    int screenHeight = dm.getHeight();
	
	    screenSize = new Dimension(screenWidth,screenHeight);
	   
		setTouchDownDate(new Date(cursor.getUpdateTime()));
		path = new PointList();
	}

	public Point getPosition() {
		Point position = new Point(getX(),
				getY());
		return position;
	}

	public int getX() {
		int xPos = (int) (cursor.getX() * screenSize.getWidth());
		xPos -= 57;
		return xPos;
	}

	public int getY() {
		int yPos = (int) (cursor.getY() * screenSize.getHeight());
		yPos -= 112;
		return yPos;
	}

	public void update() {
		// TODO Auto-generated method stub
	}

	public PointList getPath() {
		List<TuioPoint> tuioPath = cursor.getPath();
		
		int tuioPathCount = tuioPath.size();
		int pathCount = path.size();
		
		for (int i = (tuioPathCount - pathCount) - 1;
			i >= 0 && i < tuioPathCount;
			i++) {
			path.addPoint(tuioPath.get(i).getScreenX((int) screenSize.getWidth())- 57,
					tuioPath.get(i).getScreenY((int) screenSize.getHeight())-112);
		}
		
		return path;
	}

}


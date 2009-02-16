package org.unicase.ui.tom.touches;

import java.util.Date;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

public interface Touch{

	Point getPosition();
	
	int getX();

	int getY();	
	
	void update();
	
	PointList getPath();

	void setTouchUpDate(Date date);
	Date getTouchUpDate();
	
	void setTouchDownDate(Date date);
	Date getTouchDownDate();
	
	long getLifeSpan();
	Touch findClosestNeighbor(Touch firstTouch, Touch secondTouch);
}

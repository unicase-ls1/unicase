package org.unicase.ui.tom.touches;

import java.util.Date;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

public interface Touch{

	void setMultiTouch(MultiTouch multiTouch);
	MultiTouch getMultiTouch();
	
	void setClaimed(boolean claimed); 
	boolean isClaimed();
	
	Point getPosition();
	int getX();
	int getY();
	
	Point getAbsolutePosition();
	int getAbsoluteX();
	int getAbsoluteY();

	Date getTouchUpDate();	
	Date getTouchDownDate();
	
	long getLifeSpan();
}

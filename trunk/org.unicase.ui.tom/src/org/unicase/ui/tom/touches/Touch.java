package org.unicase.ui.tom.touches;

import java.util.Date;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

public interface Touch{

	void setMultiTouch(MultiTouch multiTouch);
	MultiTouch getMultiTouch();
	
	Point getPosition();
	
	int getX();

	int getY();	

	Date getTouchUpDate();	
	Date getTouchDownDate();
	
	long getLifeSpan();
}

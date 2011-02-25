package com.onpositive.richtexteditor.model.partitions;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;


public interface IRegionCompositeWrapper
{	
	void addRegionCompositeWrapperListener(IRegionCompositeWrapperListener listener);
	void removeRegionCompositeWrapperListener(IRegionCompositeWrapperListener listener);
	Point getSize();
	Point getLocation();
	void setSize(int width, int height);
	void setLocation(int x, int y);
	int getX();
	int getY();
	int getWidth();
	int getHeight();
	int getInitialHeight();	
	Rectangle getBounds();
	Composite getMainObject();
	Composite getTopLevelObject();
	void dispose();
}

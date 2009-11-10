package com.onpositive.richtexteditor.model.partitions;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.LineBackgroundEvent;
import org.eclipse.swt.custom.LineBackgroundListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


public class CompositeEditorWrapper implements IRegionCompositeWrapper
{
	ArrayList <IRegionCompositeWrapperListener> listeners = new ArrayList<IRegionCompositeWrapperListener>(2);
	protected Composite widget;
	protected StyledText innerStyledText;
	protected int oldLineCount;
	
	
	public CompositeEditorWrapper(Composite widget)
	{
		this.widget = widget;
		if (widget instanceof StyledText) innerStyledText = (StyledText) widget;
		else innerStyledText = tryToSearchStyledText(widget);
		if (innerStyledText != null)
		{
			oldLineCount = innerStyledText.getLineCount();
			innerStyledText.addModifyListener(new ModifyListener(){
	
				public void modifyText(ModifyEvent e)
				{
					if (innerStyledText.getLineCount() != oldLineCount)
					{
						oldLineCount = innerStyledText.getLineCount();
						setSize(getWidth(), innerStyledText.getLineCount() * innerStyledText.getLineHeight());
						notifyListeners(new RegionCompositeEvent(CompositeEditorWrapper.this, RegionCompositeEvent.LINE_COUNT_CHANGE));
						//widget2.getParent().redraw(); //TODO Yet commented; but not sure, we'll don't need this 
					}					
				}
				
			});
			final Listener caretListener = new Listener()
			{
				int caretPos = 0;
				public void paintControl(PaintEvent e)
				{

				}
				public void handleEvent(Event event)
				{
					if (innerStyledText.getCaretOffset() != caretPos)
					{
						notifyListeners(new RegionCompositeEvent(CompositeEditorWrapper.this, RegionCompositeEvent.CARET_MOVE, innerStyledText.getCaret()));
						caretPos = innerStyledText.getCaretOffset();
					}					
				}
			};
			innerStyledText.addListener(SWT.MouseDown,  caretListener);
			innerStyledText.addListener(SWT.KeyDown,  caretListener);
			
		}
		
	}

	public void addRegionCompositeWrapperListener(
			IRegionCompositeWrapperListener listener)
	{
		listeners.add(listener);
	}

	protected void notifyListeners(RegionCompositeEvent event)
	{
		for (Iterator iterator = listeners.iterator(); iterator.hasNext();)
		{
			IRegionCompositeWrapperListener listener = (IRegionCompositeWrapperListener) iterator.next();
			listener.handleEvent(event);
		}
	}
	
	public int getHeight()
	{
		return widget.getBounds().height;
	}

	public int getInitialHeight()
	{
		return innerStyledText.getLineHeight() * Math.max(1, innerStyledText.getLineCount());
	}
	
	public Point getSize()
	{
		return widget.getSize();
	}

	public int getWidth()
	{
		return widget.getBounds().width;
	}

	public void removeRegionCompositeWrapperListener(
			IRegionCompositeWrapperListener listener)
	{
		listeners.remove(listener);
	}


	public Point getLocation()
	{
		return widget.getLocation();
	}


	public int getX()
	{
		return widget.getBounds().x;
	}


	public int getY()
	{
		return widget.getBounds().y;		
	}
	
	
	public Rectangle getBounds()
	{
		return widget.getBounds();
	}
	
	protected StyledText tryToSearchStyledText(Composite parent) 
	{
		if (parent instanceof StyledText)
			return (StyledText) parent;
		Control[] children = parent.getChildren();
		for (int i = 0; i < children.length; i++)
		{
			if (children[i] instanceof Composite)
			{
				StyledText styledText = tryToSearchStyledText((Composite) children[i]);
				if (styledText != null)
					return styledText;
			}
		}
		return null;
	}

	public Composite getMainObject()
	{
		return innerStyledText;
	}

	public void dispose()
	{
		widget.dispose();
	}

	public void setLocation(int x, int y)
	{
		widget.setLocation(x,y);		
	}

	public void setSize(int width, int height)
	{
		widget.setSize(width,height);	
	}

	public Composite getTopLevelObject()
	{		
		return widget;
	}

}

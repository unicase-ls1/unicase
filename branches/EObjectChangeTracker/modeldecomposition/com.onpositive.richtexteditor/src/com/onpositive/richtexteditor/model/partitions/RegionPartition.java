package com.onpositive.richtexteditor.model.partitions;

import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;

import com.onpositive.richtexteditor.model.BasePartitionLayer;
import com.onpositive.richtexteditor.model.LayerManager;
import com.onpositive.richtexteditor.registry.InnerWidgetRegistry;


public class RegionPartition extends ObjectPartition implements IDisposablePartion
{
	protected static final int MARGIN = 5;
	protected IRegionCompositeWrapper wrapper;	

	public RegionPartition(BasePartitionLayer layer, int offset, int length, Composite widget)
	{		
		super(layer, offset, length);
		wrapper = new CompositeEditorWrapper(widget);
		
	}

	public Composite getTopLevelObject()
	{
		return wrapper.getTopLevelObject();
	}
	
	public Object getObject()
	{
		return wrapper.getMainObject();
	}

	
	public void setObject(Object object)
	{
		throw new RuntimeException("setObject() should not be called for instances of " + this.getClass().getCanonicalName() + " class.");
	}
	
	
	public StyleRange getStyleRange(LayerManager manager)
	{
		StyleRange style = new StyleRange ();
		style.start = offset;
		style.length = 1;
//		widget.pack(); //TODO We don't call pack() anywhere. It may result in some side effects
		Rectangle rect = wrapper.getBounds();
		int ascent =  2*rect.height/3;
		int descent = rect.height - ascent;
		style.metrics = new GlyphMetrics(ascent + MARGIN, descent + MARGIN, rect.width + 2*MARGIN);		
		return style;
	}
	
	public int getComponentHeight()
	{
		return wrapper.getHeight();
	}
	
	public void dispose()
	{
		wrapper.dispose();		
	}
	
	/**
	 * @return True, if partition must be single partition on some line
	 */
	
	public boolean requiresSingleLine()
	{
		return true;
	}
	
	public int getInitialHeight()
	{
		return wrapper.getInitialHeight();
	}
	
	public Point getSize()
	{
		return wrapper.getSize();
	}
	
	/**
	 * If one of the partition's symbols should be deleted, should the whole
	 * partition be deleted
	 * 
	 * @return true if yes, false otherwise
	 */
	
	public boolean requiresFullDeletion()
	{
		return true;
	}
	
	/**
	 * Can some symbols be type in the center of the partition
	 * 
	 * @return true if yes, false otherwise
	 */
	
	public boolean allowsInnerTyping()
	{
		return false;
	}

	
	/**
	 * Returns a wrapper, which wraps inner complex Composite-based editors behaviour.
	 * Usually needed to add listeners to them 
	 * @return the wrapper
	 */
	public IRegionCompositeWrapper getWrapper()
	{
		return wrapper;
	}

	public void setSize(int width, int height)
	{
		wrapper.setSize(width,height);		
	}

	public void setLocation(int x, int y)
	{
		wrapper.setLocation(x,y);
	}
	
	
	

}

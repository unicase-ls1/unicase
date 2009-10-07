package com.onpositive.richtexteditor.model.partitions;

import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Composite;


public class RegionCompositeEvent
{
	protected Composite sourceComposite;
	protected IRegionCompositeWrapper source;
	protected int type;
	protected Object object;
	
	public static final int LINE_COUNT_CHANGE = 1;
	public static final int CARET_MOVE = 2;
	
	public RegionCompositeEvent(Composite sourceComposite,
			IRegionCompositeWrapper source, int type)
	{
		super();
		this.sourceComposite = sourceComposite;
		this.source = source;
		this.type = type;
	}

	public RegionCompositeEvent(IRegionCompositeWrapper source, int type)
	{
		super();
		this.source = source;
		this.type = type;
	}

	
	public RegionCompositeEvent(IRegionCompositeWrapper source,
			int type, Object object)
	{
		this(source, type);
		this.object = object;
	}

	/**
	 * @return the sourceComposite
	 */
	public Composite getSourceComposite()
	{
		return sourceComposite;
	}

	
	/**
	 * @param sourceComposite the sourceComposite to set
	 */
	public void setSourceComposite(Composite sourceComposite)
	{
		this.sourceComposite = sourceComposite;
	}

	
	/**
	 * @return the source
	 */
	public IRegionCompositeWrapper getSource()
	{
		return source;
	}

	
	/**
	 * @param source the source to set
	 */
	public void setSource(IRegionCompositeWrapper source)
	{
		this.source = source;
	}

	
	/**
	 * @return the type
	 */
	public int getType()
	{
		return type;
	}

	
	/**
	 * @param type the type to set
	 */
	public void setType(int type)
	{
		this.type = type;
	}

	
	/**
	 * @return the object
	 */
	public Object getObject()
	{
		return object;
	}
	
}

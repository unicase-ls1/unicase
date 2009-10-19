/*******************************************************************************
 * Copyright (c) 2007, 2008 OnPositive Technologies (http://www.onpositive.com/) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     OnPositive Technologies (http://www.onpositive.com/) - initial API and implementation
 *******************************************************************************/

package com.onpositive.richtexteditor.model.partitions;

import org.eclipse.swt.custom.StyleRange;

import com.onpositive.richtexteditor.model.BasePartitionLayer;
import com.onpositive.richtexteditor.model.LayerManager;

/**
 * @author 32kda
 * Superclass for all objects, which isn't
 * really text partition and can contain some objects like images or hr lines.
 */
public abstract class ObjectPartition extends BasePartition
{		
	
	/**
	 * Basic constructor
	 * @param layer Layer where partition'll be situated
	 * @param offset offset of part.
	 * @param length length of part.
	 */
	public ObjectPartition(BasePartitionLayer layer, int offset, int length)
	{		
		super(layer, offset, length);
		mask = 0;
	}
	
	/**
	 * @return Object
	 */
	public abstract Object getObject();
	/** 
	 * @param object Object for setting
	 */
	public abstract void setObject(Object object);

	/**
	 * Do nothing here, preserve old style
	 */	
	public void applyAttributes(BasePartition oldPartition)
	{
	}

	
	/**
	 * @return always false for this class 
	 */
	public boolean isBold()
	{
		return false;
	}
	
	
	/**
	 * @return always false for this class 
	 */	
	public boolean isItalic()
	{
		return false;
	}
	
	/**
	 * @return always false for this class 
	 */
	public boolean isUnderlined()
	{
		return false;
	}
	
	/**
	 * @return always false for this class 
	 */
	public boolean isStrikethrough()
	{
		return false;
	}
	
	/**
	 * Returns partition style-matching style range for it's displaying
	 * @param manager LayerManager responsible for partition handling
	 * @return new StyleRange
	 */
	public StyleRange getStyleRange(LayerManager manager)
	{
		StyleRange style = new StyleRange ();
		style.start = getOffset();
		style.length = 1;
		return style;
	}

}
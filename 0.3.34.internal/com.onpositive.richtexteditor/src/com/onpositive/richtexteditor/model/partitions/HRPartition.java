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
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.graphics.Rectangle;

import com.onpositive.richtexteditor.model.BasePartitionLayer;
import com.onpositive.richtexteditor.model.LayerManager;


/**
 * @author 32kda
 * Partition for hr text breaking line
 */
public class HRPartition extends ObjectPartition
{

   /** Basic constructor
	 * @param layer Layer where partition'll be situated
	 * @param offset offset of part.
	 * @param length length of part.
	 */
	public HRPartition(BasePartitionLayer layer, int offset, int length)
	{
		super(layer, offset, length);
	}

	/**
	 *  Returns partition associated object. 
	 *  Always null in this class
	 */
	
	public Object getObject()
	{
		return null;
	}

	/** (non-Javadoc)
	 * @see com.onpositive.richtexteditor.model.partitions.ObjectPartition#setObject(java.lang.Object)
	 */
	
	public void setObject(Object object)
	{
	}

	/**
	 * Returns partition style-matching style range for it's displaying
	 * @param manager LayerManager responsible for partition handling
	 * @return new StyleRange
	 */
	
	public StyleRange getStyleRange(LayerManager manager)
	{
		StyleRange style = new StyleRange();		
		style.start = getOffset();
		style.length = 2;
		Rectangle rect = new Rectangle(0,0,3,3);
		style.metrics = new GlyphMetrics(rect.height, 0, rect.width);
		return style;
	}
	
		
	/**
	 * @return True, if partition must be single partition on some line
	 */
	
	public boolean requiresSingleLine()
	{
		return true;
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
	
}

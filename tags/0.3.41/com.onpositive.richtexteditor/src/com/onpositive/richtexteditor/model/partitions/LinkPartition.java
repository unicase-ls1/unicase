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

import com.onpositive.richtexteditor.model.BasePartitionLayer;
import com.onpositive.richtexteditor.model.ILink;

/**
 * Represents a BasePartition, which is a link
 * @author 32kda
 * Made in USSR
 */
public class LinkPartition extends BasePartition implements ILink
{
	protected String url;
	

	/**
	 * Basic constructor
	 * @param layer Layer where partition'll be situated
	 * @param offset offset of part.
	 * @param length length of part.
	 */
	public LinkPartition(BasePartitionLayer layer, int offset, int length)
	{
		super(layer, offset, length);
	}
	
	/**
	 * Complex constructor
	 * @param layer Layer where partition'll be situated
	 * @param offset offset of part.
	 * @param length length of part.
	 * @param url url string
	 * @param mask style bitmask
	 * @param stylePrototype link style prototype partition
	 */
	public LinkPartition(BasePartitionLayer layer, int offset, int length, String url, int mask, BasePartition stylePrototype)
	{
		super(layer, offset, length);
		this.url = url;		
		this.mask = mask;
		applyAttributes(stylePrototype);		
	}

	/**
	 * Complex constructor
	 * @param layer Layer where partition'll be situated
	 * @param offset offset of part.
	 * @param length length of part.
	 * @param url url string
	 * @param stylePrototype link style prototype partition
	 */
	public LinkPartition(BasePartitionLayer layer,int offset,int length,
			String url,BasePartition stylePrototype)
	{
		super(layer, offset, length);
		this.url = url;		
		applyAttributes(stylePrototype);
	}
	
	
	/**
	 * @return url string
	 * 
	 */
	public String getUrl()
	{
		return url;
	}

	
	/**
	 * @param url url string 
	 * 
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}
	
	
	/** (non-Javadoc)
	 * @see com.onpositive.richtexteditor.model.partitions.BasePartition#toString()
	 */
	public String toString()
	{
		return "{ (" + offset + "," + length + ") " + " bold: " + isBold() + " italic: " + isItalic() + "   "+ getText() + " url: " + url + "}";
	}

}

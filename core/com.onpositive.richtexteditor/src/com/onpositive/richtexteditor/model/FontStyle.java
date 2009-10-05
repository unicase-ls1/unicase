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

package com.onpositive.richtexteditor.model;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;

import com.onpositive.richtexteditor.model.partitions.BasePartition;
import com.onpositive.richtexteditor.model.resources.FontStyleManager;

/**
 * @author 32kda
 * Class for applyable font style information and handling
 */
public class FontStyle implements Cloneable
{
	
	public static final int BOLD = SWT.BOLD;
	public static final int ITALIC = SWT.ITALIC;
	public static final int UNDERLINED = 4;
	public static final int STRIKETHROUGH = 8;
	public static final String NORMAL_FONT_NAME = FontStyleManager.NORMAL_FONT_NAME;
	public static final String BOLD_PREFFIX = "bold_";
	public static final String ITALIC_PREFFIX = "italic_";
	public static final String UNDERLINED_PREFFIX = "underlined_";
	public static final String BOLD_ITALIC_PREFFIX = "bold_italic_";

	protected int mask;
	protected String fontDataName = null;
	protected String displayName = null;
	protected RGB color = null;
	protected RGB bgColor = null;
		
	
	/**
	 * Constructor by style bitmask
	 * @param mask bitmask
	 */
	public FontStyle(int mask)
	{
		this.mask=mask;
	}
	
	/**
	 * Constructor by style bitmask, Font Data Name and font display name
	 * @param mask bitmask
	 * @param fontDataName Font Data Name
	 * @param displayName font display name
	 */
	public FontStyle(int mask, String fontDataName, String displayName)
	{		
		
		this.mask=mask;
		this.fontDataName = fontDataName;
		this.displayName = displayName;
	}
	
	/**
	 * Constructor by style bitmask and color's RGB
	 * @param mask bitmask
	 * @param RGBColor foreground color
	 * 
	 */
	public FontStyle(int mask, RGB RGBColor)
	{
		this.color = RGBColor;
		this.mask=mask;
	}

	
	/**
	 * @return the color
	 */
	public RGB getColor()
	{
		return color;
	}

	
	/**
	 * @param color the color to set
	 */
	public void setColor(RGB color)
	{
		this.color = color;
	}

	/**
	 * Constructor for copying style from some partition
	 * @param partition Partition to copy style from
	 */
	public FontStyle(BasePartition partition) {
		this.mask=partition.getStyleMask();
		this.color=partition.getColorRGB();
		this.bgColor=partition.getBgColorRGB();
		this.fontDataName=partition.getFontDataName();
		
	}

	
	/**
	 * @param partition where to apply this style to 
	 */
	public void applyStyle(BasePartition partition) 
	{
		partition.setStyleMask(partition.getStyleMask() | mask);
		if (color != null) partition.setColorRGB(color);
		if (bgColor != null) partition.setBgColorRGB(bgColor);
		if (fontDataName != null) partition.setFontDataName(fontDataName);
	}

	/**
	 * @param partition where to set this style to 
	 */
	public void setStyle(BasePartition partition) 
	{
		partition.setStyleMask( mask);
		partition.setColorRGB(color);
		partition.setBgColorRGB(bgColor);
		partition.setFontDataName(fontDataName);
	}

	
	/**
	 * @param partition where to remove this style from 
	 */
	public void removeStyle(BasePartition partition) 
	{
		partition.setStyleMask(partition.getStyleMask() & ~mask);
		if (color != null) partition.setColorRGB(null);
		if (bgColor != null) partition.setBgColorRGB(null);
		if (fontDataName != null && fontDataName != NORMAL_FONT_NAME) partition.setFontDataName(NORMAL_FONT_NAME);
	}

	
	/**
	 * @param partition where to remove this style from 
	 * @return true, if this style is applied to partition
	 */
	public boolean isApplied(BasePartition partition)
	{
		if ((partition.getStyleMask() & mask) > 0) return true;
		return false;
	}

	/**
	 * @return Style display name
	 */
	public String getDisplayName()
	{
		return displayName;
	}

	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}
	
	public String getFontDataName()
	{
		return fontDataName;
	}

	public void setFontDataName(String fontDataName)
	{
		this.fontDataName = fontDataName;
	}
	
	public RGB getBgColor()
	{
		return bgColor;
	}
	
	public void setBgColor(RGB bgColor)
	{
		this.bgColor = bgColor;
	}	
	
	
	public boolean equals(Object obj)
	{
		if (!(obj instanceof FontStyle)) return false;
		FontStyle style2 = (FontStyle)obj;
		if (!fontDataName.equals(style2.fontDataName)) return false;
		if (!(mask == style2.mask)) return false;
		if (color == null && style2.color != null) return false;
		if (color != null && !(color.equals(style2.color))) return false;
		if (bgColor == null && style2.bgColor != null) return false;
		if (bgColor != null && !(bgColor.equals(style2.bgColor))) return false;
		return true;
	}
	
	/** (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	
	public Object clone()
	{
		try
		{
			return super.clone();
		}
		catch (CloneNotSupportedException e) {
			Logger.log(e);
		}
		return null;
	}
	
	/**
	 * @return displayable name of style
	 */
	
	public String toString()
	{
		return displayName;
	}
	
	
}

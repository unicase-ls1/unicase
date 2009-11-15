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

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import com.onpositive.richtexteditor.model.BasePartitionEvent;
import com.onpositive.richtexteditor.model.BasePartitionLayer;
import com.onpositive.richtexteditor.model.FontStyle;
import com.onpositive.richtexteditor.model.IPartition;
import com.onpositive.richtexteditor.model.LayerManager;
import com.onpositive.richtexteditor.model.Logger;

/**
 * @author 32kda
 * Basic partition class. 
 * It's instance can have font, color and style mask
 */
public class BasePartition implements IPartition
{

	BasePartitionLayer layer;

	int length;
	int offset;
	int index = -1;
	
	int mask = 0; // Attributes mask (bold, italic etc.)
	private RGB colorRGB = null, bgColorRGB = null;
	private boolean refreshVisibleState = true;
	protected String fontDataName = FontStyle.NORMAL_FONT_NAME;

	private static String ADDITION = "_bold_italic";

	/**
	 * Gets a name of a "bold+italic" font by the base font name.
	 * 
	 * @param name - base font name.
	 * @return a "bold+italic" font name
	 */
	public static String getBoldItalicNameByFontName(String name)
	{
		return name + ADDITION;
	}
	
	/**
	 * @return Object's index in partition array
	 */
	public int getPosition()
	{
		return index;
	}	

	/**
	 * Basic constructor
	 * @param layer Layer where partition'll be situated
	 * @param offset offset of part.
	 * @param length length of part.
	 */
	public BasePartition(BasePartitionLayer layer, int offset, int length)
	{
		super();
		this.layer = layer;
		this.length = length;
		this.offset = offset;
		mask = 0;
	}

	/**
	 * @return true, if changing partition's attributes should cause partition text
	 * repainting in editor window.
	 */
	public boolean isRefreshVisibleState()
	{
		return refreshVisibleState;
	}


	/**
	 * Should changing partition's attributes cause partition text repainting in editor window?
	 * @param refreshVisibleState It should be false in cause, if partition is incorrect yet, document not changed yet,
	 * text widget not ready for repainting, or if it's too many partitions to repaint,
	 * and it's better to repaint them all later, at same time
	 */
	public void setRefreshVisibleState(boolean refreshVisibleState)
	{
		this.refreshVisibleState = refreshVisibleState;
	}

	/**
	 * @param length new partition length
	 */
	public void setLength(int length)
	{
		this.length = length;
	}

	/**
	 * @return True, if partition must be single partition on some line
	 */
	public boolean requiresSingleLine()
	{
		return false;
	}

	/**
	 * If one of the partition's symbols should be deleted, should the whole
	 * partition be deleted
	 * 
	 * @return true if yes, false otherwise
	 */
	public boolean requiresFullDeletion()
	{
		return false;
	}

	/**
	 * Can some symbols be type in the center of the partition
	 * 
	 * @return true if yes, false otherwise
	 */
	public boolean allowsInnerTyping()
	{
		return true;
	}

	/**
	 * @return has this partition bold attribute?
	 */
	public boolean isBold()
	{
		if ((mask & FontStyle.BOLD) > 0)
			return true;
		return false;
	}
	
	/**
	 * @param bold Should this partition have bold attribute?
	 */
	public void setBold(boolean bold)
	{
		if (bold)
			mask = mask | FontStyle.BOLD;
		else
			mask = mask & ~FontStyle.BOLD;
		if (refreshVisibleState)
			layer.handlePartitionEvent(new BasePartitionEvent(this)); // TODO Не
																		// медленно
																		// ?
	}

	
	/**
	 * @return has this partition italic attribute?
	 */
	public boolean isItalic()
	{
		if ((mask & FontStyle.ITALIC) > 0)
			return true;
		return false;
	}
	
	/**
	 * @param italic Should this partition have italic attribute?
	 */
	public void setItalic(boolean italic)
	{
		if (italic)
			mask = mask | FontStyle.ITALIC;
		else
			mask = mask & ~FontStyle.ITALIC;
		if (refreshVisibleState)
			layer.handlePartitionEvent(new BasePartitionEvent(this));
	}

	/**
	 * @param underlined Should this partition have underlined attribute?
	 */
	public void setUnderlined(boolean underlined)
	{
		if (underlined)
			mask = mask | FontStyle.UNDERLINED;
		else
			mask = mask & ~FontStyle.UNDERLINED;
		if (refreshVisibleState)
			layer.handlePartitionEvent(new BasePartitionEvent(this));
	}

	/**
	 * @param strikeThrough Should this partition have strikethrough attribute?
	 */
	public void setStrikethrough(boolean strikeThrough)
	{
		if (strikeThrough)
			mask = mask | FontStyle.STRIKETHROUGH;
		else
			mask = mask & ~FontStyle.STRIKETHROUGH;
		if (refreshVisibleState)
			layer.handlePartitionEvent(new BasePartitionEvent(this));
	}

	/** (non-Javadoc)
	 * @see com.onpositive.richtexteditor.model.IPartition#getLength()
	 */
	public final int getLength()
	{
		return length;
	}

	/** (non-Javadoc)
	 * @see com.onpositive.richtexteditor.model.IPartition#getOffset()
	 */
	public final int getOffset()
	{
		return offset;
	}

	/** (non-Javadoc)
	 * @see com.onpositive.richtexteditor.model.IPartition#getText()
	 */
	public String getText()
	{
		try
		{
			return layer.getDoc().get(offset, length);
		} catch (BadLocationException e)
		{
		}
		return null;
	}

	/**
	 * Used for inheriting attributes 
	 * @param oldPartition  - source partition for inheritance
	 */
	public void applyAttributes(BasePartition oldPartition)
	{
		mask = mask | oldPartition.mask;
		if (oldPartition.fontDataName != FontStyle.NORMAL_FONT_NAME)
			fontDataName = oldPartition.fontDataName;
		if (oldPartition.colorRGB != null)
			colorRGB = oldPartition.colorRGB;
		if (oldPartition.bgColorRGB != null)
			bgColorRGB = oldPartition.bgColorRGB;
	}

	/**
	 * @param offset new offset
	 */
	public void setOffset(int offset)
	{
		this.offset = offset;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return "{ (" + offset + "," + length + ") " + " bold: " + isBold()
				+ " italic: " + isItalic() + "   " + getText() + "}";
	}


	/**
	 * Breaks this partition into two parts, returns left part
	 * with no style
	 * @param divisionOffset offset to break
	 * @return new partition - left part of older
	 */
	public BasePartition extractLeftPartition(int divisionOffset)
	{
		if (divisionOffset <= offset)
			throw new RuntimeException("Wrong extractLeftPartition argument ("
					+ divisionOffset + " < " + offset + ")");
		if (divisionOffset == offset + length)
			return this;
		int oldOffset = offset;
		offset = divisionOffset;
		length = length - (divisionOffset - oldOffset);
		return PartitionFactory.createAsSample(this, oldOffset,
				divisionOffset - oldOffset);
	}

	/**
	 * Breaks this partition into two parts, returns left part,
	 * with style of old partition
	 * @param divisionOffset offset to break
	 * @return new partition - left part of older
	 */
	public BasePartition extractLeftPartitionWithStyle(int divisionOffset)
	{
		if (divisionOffset <= offset)
			throw new RuntimeException("Wrong extractLeftPartition argument ("
					+ divisionOffset + " < " + offset + ")");
		if (divisionOffset == offset + length)
			return this;
		int oldOffset = offset;
		offset = divisionOffset;
		length = length - (divisionOffset - oldOffset);
		return PartitionFactory.createAsSampleStyle(this, layer, oldOffset,
				divisionOffset - oldOffset);
	}

	/**
	 * @return partition style mask
	 */
	public int getStyleMask()
	{
		return mask;
	}

	/**
	 * @param newMask new style mask for partition
	 */
	public void setStyleMask(int newMask)
	{
		mask = newMask;
		if (refreshVisibleState)
			layer.handlePartitionEvent(new BasePartitionEvent(this));
	}

	boolean equalsByCoords(BasePartition partition2)
	{
		if (partition2.offset == offset && partition2.length == length)
			return true;
		return false;
	}

	/**
	 * Compares two partitions by style
	 * @param partition2 second partition for comparison
	 * @return true, if 2 partition have equal style
	 */
	public boolean equalsByStyle(BasePartition partition2)
	{
		if (partition2 instanceof ObjectPartition
				|| this instanceof ObjectPartition)
		{
			return false;
		}
		if (partition2 instanceof LinkPartition
				|| this instanceof LinkPartition)
		{
			return false;
		}
		if (mask == partition2.mask
				&& fontDataName.equals(partition2.fontDataName)
				&& colorRGB == partition2.colorRGB
				&& bgColorRGB == partition2.bgColorRGB)
			return true;
		return false;
	}

	/**
	 * @return FontData name for partition
	 */
	public String getFontDataName()
	{
		return fontDataName;
	}

	/**
	 * @param fontDataName new fontData name for partition
	 */
	public void setFontDataName(String fontDataName)
	{
		this.fontDataName = fontDataName;
	}

	/**
	 * returns partition's text from <b>offset</b> till patition's end
	 * @param offset Offset to return text from
	 * @return text 
	 */
	public String getTextFromOffset(int offset)
	{
		if (offset < this.offset || offset >= this.offset + this.length)
			throw new RuntimeException("Invalid getTextFromOffset argument - "
					+ offset);
		try
		{
			return layer.getDoc().get(offset,
					this.length - (offset - this.offset));
		} catch (BadLocationException e)
		{
			Logger.log(e);
		}
		return null;
	}

	/**
	 * returns partition's text from it's beginning till <b>offset</b>
	 * @param offset Offset to return text before
	 * @return text
	 */
	public String getTextUpToOffset(int offset)
	{
		if (offset < this.offset || offset > this.offset + this.length)
			throw new RuntimeException("Invalid getTextFromOffset argument - "
					+ offset);
		try
		{
			return layer.getDoc().get(this.offset, offset - this.offset);
		} catch (BadLocationException e)
		{
			Logger.log(e);
		}
		return null;
	}

	/**
	 * Return partition text from specific region
	 * @param offset region offset
	 * @param length region length
	 * @return text
	 */
	public String getTextRegion(int offset, int length)
	{
		if (offset < this.offset || offset >= this.offset + this.length
				|| length <= 0) // TODO Maybe = here
			throw new RuntimeException("Invalid getTextFromOffset argument - "
					+ offset);
		try
		{
			return layer.getDoc().get(offset, length);
		} catch (BadLocationException e)
		{
			Logger.log(e);
		}
		return null;

	}

	/**
	 * @return partition color RGB
	 */
	public RGB getColorRGB()
	{
		return colorRGB;
	}

	/**
	 * @return partition bg color RGB
	 */
	public RGB getBgColorRGB()
	{
		return bgColorRGB;
	}

	/**
	 * @return has this partition Underlined attribute?
	 */
	public boolean isUnderlined()
	{
		if ((mask & FontStyle.UNDERLINED) > 0)
			return true;
		return false;
	}

	/**
	 * @return has this partition Strikethrough attribute?
	 */
	public boolean isStrikethrough()
	{
		if ((mask & FontStyle.STRIKETHROUGH) > 0)
			return true;
		return false;
	}

	
	/**
	 * Returns partition style-matching style range for it's displaying
	 * @param manager LayerManager responsible for partition handling
	 * @return new StyleRange
	 */
	public StyleRange getStyleRange(LayerManager manager)
	{

		StyleRange styleRange = new StyleRange();
		styleRange.start = this.getOffset();
		styleRange.length = this.getLength();
		styleRange.underline = this.isUnderlined();
		styleRange.strikeout = this.isStrikethrough();
		if (this.colorRGB != null)
		{
			styleRange.foreground = manager.getColorRegistry().getColor(
					this.colorRGB);
		}
		if (this.bgColorRGB != null)
		{
			styleRange.background = manager.getColorRegistry().getColor(
					this.bgColorRGB);
		}
		refreshVisibleState = true;
		return styleRange;
	}

	/**
	 * Returns new Color object (meaning system color, with handle) for this partition's color
	 * @param manager LayerManager responsible for partition handling
	 * @return Color object
	 */
	public Color getColor(LayerManager manager)
	{
		if (this.colorRGB != null)
			return manager.getColorRegistry().getColor(this.colorRGB);
		return null;
	}
	
	/**
	 * Returns new Color object (meaning system color, with handle) for this partition's bgcolor
	 * @param manager LayerManager responsible for partition handling
	 * @return Color object
	 */
	public Color getBgColor(LayerManager manager)
	{
		if (this.bgColorRGB != null)
			return manager.getColorRegistry().getColor(this.bgColorRGB);
		return null;
	}
	
	/**
	 * @param color new fg color RGB
	 */
	public void setColorRGB(RGB color)
	{
		this.colorRGB = color;
	}

	/**
	 * @param bgColor new bg color RGB
	 */
	public void setBgColorRGB(RGB bgColor)
	{
		this.bgColorRGB = bgColor;
	}
	
	
	/** 
	 * Creates and returns a copy of this object. 
	 * @return object's clone
	 */
	public BasePartition clone(){
		try {
			BasePartition clone = (BasePartition) super.clone();
			if (clone.colorRGB!=null){
				clone.colorRGB=new RGB(clone.colorRGB.red,clone.colorRGB.green,clone.colorRGB.blue);
			}
			if (clone.bgColorRGB!=null){
				clone.bgColorRGB=new RGB(clone.bgColorRGB.red,clone.bgColorRGB.green,clone.bgColorRGB.blue);
			}
			return clone;
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException("Should never happen");
		}		
	}

}

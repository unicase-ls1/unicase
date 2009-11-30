package com.onpositive.richtexteditor.model.resources;

import java.io.Serializable;

import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;

import com.onpositive.richtexteditor.model.FontStyle;


public class SaveableFontStyle implements Serializable
{
	protected String displayName;
	protected String fontDataName;
	protected String fontDataString;
	protected RGB color = null;
	protected RGB bgColor = null;
	
	
	public SaveableFontStyle(FontStyleManager manager,FontStyle style)
	{
		this.fontDataName = style.getFontDataName();
		this.displayName = style.getDisplayName();		
		FontData fontData = manager.getFontRegistry().get(fontDataName).getFontData()[0];
		this.fontDataString = fontData.toString();
		color = style.getColor();
		bgColor = style.getBgColor();
	}


	
	/**
	 * @return the displayName
	 */
	public String getDisplayName()
	{
		return displayName;
	}


	
	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}


	
	/**
	 * @return the fontDataName
	 */
	public String getFontDataName()
	{
		return fontDataName;
	}


	
	/**
	 * @param fontDataName the fontDataName to set
	 */
	public void setFontDataName(String fontDataName)
	{
		this.fontDataName = fontDataName;
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
	 * @return the bgColor
	 */
	public RGB getBgColor()
	{
		return bgColor;
	}


	
	/**
	 * @param bgColor the bgColor to set
	 */
	public void setBgColor(RGB bgColor)
	{
		this.bgColor = bgColor;
	}



	
	/**
	 * @return the fontDataString
	 */
	public String getFontDataString()
	{
		return fontDataString;
	}



	
	/**
	 * @param fontDataString the fontDataString to set
	 */
	public void setFontDataString(String fontDataString)
	{
		this.fontDataString = fontDataString;
	}
	
	

}

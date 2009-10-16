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
package com.onpositive.richtexteditor.model.resources;

import java.util.ArrayList;

import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.swt.graphics.FontData;

import com.onpositive.richtexteditor.model.FontStyle;


/**
 * @author kor
 * Contains font style data duplicate to edit in customization dialog
 */
public class FontStyleData
{
	protected ArrayList<FontStyle> fontStyles = new ArrayList<FontStyle>();
	protected ArrayList<FontStyle> deletedStyles = new ArrayList<FontStyle>();
	protected ArrayList<FontStyle> changedStyles = new ArrayList<FontStyle>();
	protected ArrayList<FontStyle> addedStyles = new ArrayList<FontStyle>();
	protected DisposableFontRegistry parentFontRegistry, resultFontRegistry;

	/**
	 * Basic constructor
	 * @param initialData Initial font style list to copy to this buffer
	 * @param parentFontRegistry initial fort registry to copy to this buffer
	 */
	public FontStyleData(ArrayList<FontStyle> initialData, DisposableFontRegistry parentFontRegistry)
	{
		for (int i = 0; i < initialData.size(); i++)
		{
			FontStyle fs = initialData.get(i);
			fontStyles.add((FontStyle)fs.clone());
		}
		this.parentFontRegistry = parentFontRegistry;
	}
	
	/**
	 * @return the fontStyles
	 */
	public ArrayList<FontStyle> getFontStyles()
	{
		return fontStyles;
	}
	
	/**
	 * @param fontStyles the fontStyles to set
	 */
	public void setFontStyles(ArrayList<FontStyle> fontStyles)
	{
		this.fontStyles = fontStyles;
	}
	
	/**
	 * @return the deletedStyles
	 */
	public ArrayList<FontStyle> getDeletedStyles()
	{
		return deletedStyles;
	}
	
	
	
	/**
	 * @return the resultFontRegistry
	 */
	public DisposableFontRegistry getResultFontRegistry()
	{
		return resultFontRegistry;
	}

	
	
	/**
	 * @return the addedStyles
	 */
	public ArrayList<FontStyle> getAddedStyles()
	{
		return addedStyles;
	}

	
	/**
	 * @param addedStyles the addedStyles to set
	 */
	public void setAddedStyles(ArrayList<FontStyle> addedStyles)
	{
		this.addedStyles = addedStyles;
	}

	/**
	 * @param resultFontRegistry the resultFontRegistry to set
	 */
	public void setResultFontRegistry(DisposableFontRegistry resultFontRegistry)
	{
		this.resultFontRegistry = resultFontRegistry;
	}

	/**
	 * @return the parentFontRegistry
	 */
	public FontRegistry getParentFontRegistry()
	{
		return parentFontRegistry;
	}

	/**
	 * @param deletedStyles the deletedStyles to set
	 */
	public void setDeletedStyles(ArrayList<FontStyle> deletedStyles)
	{
		this.deletedStyles = deletedStyles;
	}
	
	/**
	 * Adds a style to changed style list
	 * @param style style to add
	 */
	public void addChangedStyle(FontStyle style)
	{
		if (changedStyles.indexOf(style) == -1)
			changedStyles.add(style);
	}
	
	/**
	 * Validates, that styles from changed styles list really changed
	 * @param manager containing old list (currently used by document)
	 * @return Changed Styles list after validating
	 */
	public ArrayList<FontStyle> validateChangedStyles(FontStyleManager manager)
	{
		for (int i = 0; i < changedStyles.size(); i++)
		{
			FontStyle fontStyle = (FontStyle) changedStyles.get(i);
			FontStyle style2 = manager.getStyleMap().get(fontStyle.getFontDataName());			
				if (style2 != null)
				{
					FontData[] oldFD = parentFontRegistry.getFontData(style2.getFontDataName());
					if (style2.equals(fontStyle) && oldFD[0].equals(resultFontRegistry.getFontData(fontStyle.getFontDataName()))) changedStyles.remove(i--);				
				}
		}
		return changedStyles;
	}
	
	
}

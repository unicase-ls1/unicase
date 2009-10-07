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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

import com.onpositive.richtexteditor.model.FontStyle;
import com.onpositive.richtexteditor.model.FontStylesChangeListener;
import com.onpositive.richtexteditor.model.partitions.BasePartition;

/**
 * @author kor & 32kda
 * Manages (creates and disposes) fonts
 */
public class FontStyleManager {

	protected DisposableFontRegistry fontRegistry;

	protected HashMap<String, FontStyle> styleMap = new HashMap<String, FontStyle>();
	protected ArrayList<FontStyle> fontStyles = new ArrayList<FontStyle>(3);
	
	/**
	 * Normal font data display name
	 */
	public static String FONT_NORMAL_DISPLAY_NAME = "Normal";
	/**
	 *  H1 font data display name
	 */
	public static String FONT_H1_DISPLAY_NAME = "Fixed width";
	/**
	 * H2 font data display name
	 */
	public static String FONT_H2_DISPLAY_NAME = "Header 2";
	/**
	 * H3 font data display name
	 */
	public static final String FONT_H3_DISPLAY_NAME = "Header 3";
	
	/**
	 * Normal font data name
	 */
	public static String NORMAL_FONT_NAME = FONT_NORMAL_DISPLAY_NAME;
	/**
	 * H1 font data name
	 */
	public static String FONT_FIXED_NAME = FONT_H1_DISPLAY_NAME;
	/**
	 * H2 font data name
	 */
	public static String FONT_H2_NAME = FONT_H2_DISPLAY_NAME;
	/**
	 * H3 font data name
	 */
	public static final String FONT_H3_NAME = FONT_H3_DISPLAY_NAME;
	
	protected FontStyle normFontStyle = new FontStyle(0, NORMAL_FONT_NAME,
			FONT_NORMAL_DISPLAY_NAME);
	protected FontStyle h1FontStyle = new FontStyle(0, FONT_FIXED_NAME,
			FONT_H1_DISPLAY_NAME);
	protected FontStyle h2FontStyle = new FontStyle(0, FONT_H2_NAME,
			FONT_H2_DISPLAY_NAME);

	protected FontStyle h3FontStyle = new FontStyle(0, FONT_H3_NAME,
			FONT_H3_DISPLAY_NAME);
	
	protected ArrayList<FontStylesChangeListener> listeners = new ArrayList<FontStylesChangeListener>();

	/**
	 * @param style new font style to add to this manager
	 */
	public void addFontStyle(FontStyle style) {
		String fontDataName = style.getFontDataName();
		if (styleMap.containsKey(fontDataName)) {
			throw new IllegalArgumentException(
					"Style with a given font data name already exists");
		}
		this.fontStyles.add(style);
		this.styleMap.put(fontDataName, style);		
		
	}
	
	/**
	 * Disposes font resources
	 */
	public void dispose()
	{
		fontRegistry.dispose();
	}

	/**
	 * Basic constructor
	 * @param display the device on which to allocate fonts
	 */
	public FontStyleManager(Display display) {
		initializeByDefault(display);
	}
	
	protected void initializeByDefault(Display display)
	{
		this.fontRegistry = new DisposableFontRegistry(display);
		addFontStyle(normFontStyle);
		addFontStyle(h1FontStyle);
		fontRegistry.put(FONT_FIXED_NAME, new FontData[] { new FontData(
				"Courier", 12, SWT.NORMAL) });
		fontRegistry.put(NORMAL_FONT_NAME, new FontData[] { new FontData(
				"Helvetica", 12, SWT.NORMAL) });
	}

	/**
	 * @return array of Font Data Names
	 */
	public String[] getFontStyleDataNames() {
		String[] result = new String[fontStyles.size()];
		int a = 0;
		for (FontStyle s : fontStyles) {
			result[a++] = s.getFontDataName();
		}
		return result;
	}

	/**
	 * @return array of Font Displayed Names
	 */
	public String[] getFontStyleDisplayNames() {
		String[] result = new String[fontStyles.size()];
		int a = 0;
		for (FontStyle s : fontStyles) {
			result[a++] = s.getDisplayName();
		}
		return result;
	}
	
	/**
	 * @return array of font styles
	 */
	public FontStyle[] getFontStyles(){
		return fontStyles.toArray(new FontStyle[fontStyles.size()]);
	}

	/**
	 * @return list of font styles
	 */
	public ArrayList<FontStyle> getFontStylesList(){
		return fontStyles;
	}
	
	/**
	 * Get a font style by
	 * @param fontStyleDisplayName specified display name
	 * @return font style
	 */
	public FontStyle getFontStyle(String fontStyleDisplayName) {
		for (Iterator<FontStyle> iterator = fontStyles.iterator(); iterator
				.hasNext();) {
			FontStyle fs = (FontStyle) iterator.next();
			if (fs.getDisplayName().equals(fontStyleDisplayName))
				return fs;
		}
		return null;
	}

	/**
	 * Get a font style by
	 * @param fontDataName inner fontDataName name
	 * @return font style
	 */
	public FontStyle getFontStyleByFontDataName(String fontDataName) {
		for (Iterator<FontStyle> iterator = fontStyles.iterator(); iterator
				.hasNext();) {
			FontStyle fs = (FontStyle) iterator.next();
			if (fs.getFontDataName().equals(fontDataName))
				return fs;
		}
		return null;
	}
	
	/**
	 * @param fontDataName Font Data Name - really unparsed html attr here
	 * @return when it will be parsed, we'll return generated name string for this style
	 */
	public String getNameForStyleString(String fontDataName) {
		if (fontDataName.indexOf("font-family:") == -1
				&& fontDataName.indexOf("font-size:") == -1)
			return FontStyle.NORMAL_FONT_NAME;
		if (fontDataName.indexOf("font-family:") == -1)
			fontRegistry.get(FontStyle.NORMAL_FONT_NAME).getFontData()[0]
					.getName(); // By default
		String faceTail = fontDataName.substring(fontDataName
				.indexOf("font-family:")
				+ String.valueOf("font-family:").length());
		String faceName = faceTail.substring(0, faceTail.indexOf(";"))
				.toLowerCase().trim();

		String heightTail = fontDataName.substring(
				fontDataName.indexOf("font-size:")
						+ String.valueOf("font-size:").length()).trim();
		String heightValue = "";
		for (int i = 0; i < heightTail.length() && heightTail.charAt(i) >= '0'
				&& heightTail.charAt(i) <= '9'; i++)
			heightValue += heightTail.charAt(i);

		int height = fontRegistry.get(FontStyle.NORMAL_FONT_NAME).getFontData()[0]
				.getHeight(); // By default
		try {
			height = Integer.parseInt(heightValue);
		} catch (Exception e) {
		}

		for (Iterator<?> iterator = fontRegistry.getKeySet().iterator(); iterator
				.hasNext();) {
			String name = (String) iterator.next();
			FontData fd = fontRegistry.get(name).getFontData()[0];
			if (fd.getName().toLowerCase().equals(faceName)
					&& fd.getHeight() == height)
				return name;
		}

		String newFontName = faceName + "_" + heightValue;
		fontRegistry.put(newFontName, new FontData[] { new FontData(faceName,
				height, SWT.NORMAL) });

		return newFontName;
	}

	/**
	 * Return Font object for specified partition
	 * @param partition partition
	 * @return font for it
	 */
	public Font getFontForPartition(BasePartition partition) {
		String preffix = "";
		if (partition.isBold())
			preffix += FontStyle.BOLD_PREFFIX;
		if (partition.isItalic())
			preffix += FontStyle.ITALIC_PREFFIX;
		Font basicFont = fontRegistry.get(partition.getFontDataName());
		if (preffix.equals(""))
			return basicFont;
		String preffixName = preffix + partition.getFontDataName();
		Font newFont = fontRegistry.get(preffixName);
		if (newFont == null || newFont == fontRegistry.defaultFont()) {
			int fontStyle = 0;
			if (partition.isBold())
				fontStyle = SWT.BOLD;
			if (partition.isItalic())
				fontStyle = fontStyle | SWT.ITALIC;
			fontRegistry.put(preffixName, new FontData[] { new FontData(
					basicFont.getFontData()[0].getName(), basicFont
							.getFontData()[0].getHeight(), fontStyle) });
			newFont = fontRegistry.get(preffixName);
		}
		return newFont;
	}

	/**
	 * @return font registry associated with this object
	 */
	public FontRegistry getFontRegistry() {
		return fontRegistry;
	}

	/**
	 * @return default font style
	 */
	public FontStyle getDefaultStyle() {
		return styleMap.get(NORMAL_FONT_NAME);
	}
	
	/**
	 * @return the styleMap
	 */
	public HashMap<String, FontStyle> getStyleMap()
	{
		return styleMap;
	}
	
	public ArrayList<SaveableFontStyle> getSavebaleFontStylesList()
	{
		ArrayList<SaveableFontStyle> styles = new ArrayList<SaveableFontStyle>(); 
		for (Iterator iterator = fontStyles.iterator(); iterator.hasNext();)
		{
			FontStyle style = (FontStyle) iterator.next();
			SaveableFontStyle saveableFontStyle = new SaveableFontStyle(this, style);
			styles.add(saveableFontStyle);
		}
		return styles;
	}
	
	public void setStylesFromSaveableFontStylesList(Collection<SaveableFontStyle> list, Display display)
	{
		DisposableFontRegistry newRegistry = new DisposableFontRegistry(display);
		ArrayList<FontStyle> newFontStyles = new ArrayList<FontStyle>();
		for (Iterator iterator = list.iterator(); iterator.hasNext();)
		{
			SaveableFontStyle style = (SaveableFontStyle) iterator.next();
			String fontDataName = style.getFontDataName();
			String fdString = style.getFontDataString();
			FontData[] fontData = new FontData[]{new FontData(fdString)};
			newRegistry.put(fontDataName, fontData);
			FontStyle newStyle = new FontStyle(fontData[0].getStyle(), fontDataName, style.getDisplayName());
			newStyle.setColor(style.getColor());
			newStyle.setBgColor(style.getBgColor());
			newFontStyles.add(newStyle);
		}
		reinit(newFontStyles, newRegistry, newFontStyles);
	}
	

	
	/**
	 * Used to reinitialize contents of this manager, then they were changed by dialog
	 * @param newStyles new styles list
	 * @param newRegistry new font registry, containing modified FontData
	 * @param changedStyles styles, which has been changed
	 */
	public void reinit(ArrayList<FontStyle> newStyles, DisposableFontRegistry newRegistry, ArrayList<FontStyle> changedStyles)
	{
		fontStyles = newStyles;
		styleMap.clear();
		for (Iterator<FontStyle> iterator = newStyles.iterator(); iterator.hasNext();)
		{
			FontStyle fontStyle = (FontStyle) iterator.next();
			styleMap.put(fontStyle.getFontDataName(), fontStyle);			
		}
		fontRegistry.dispose();
		fontRegistry = newRegistry;	
		stylesChanged(changedStyles);
	}
	
	/**
	 * Font style change listener to add
	 * @param listener Listener to ad to listeners list
	 */
	public void addFontStyleChangeListener(FontStylesChangeListener listener)
	{
		listeners.add(listener);
	}
	
	/**
	 * Font style change listener to remove
	 * @param listener Listener to ad to listeners list
	 */
	public void removeFontStyleChangeListener(FontStylesChangeListener listener)
	{
		listeners.remove(listener);
	}
	
	protected void stylesChanged(ArrayList<FontStyle> changedStyles)
	{
		for (Iterator<FontStylesChangeListener> iterator = listeners.iterator(); iterator.hasNext();)
		{
			FontStylesChangeListener listener = (FontStylesChangeListener) iterator.next();
			listener.stylesChanged(changedStyles);
		}
	}
	

}

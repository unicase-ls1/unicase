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

package com.onpositive.richtexteditor.io.html_scaner;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

import org.eclipse.core.internal.runtime.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;

import com.onpositive.richtexteditor.io.LexEvent;
import com.onpositive.richtexteditor.model.BulletFactory;
import com.onpositive.richtexteditor.model.BasePartitionLayer;
import com.onpositive.richtexteditor.model.LayerManager;
import com.onpositive.richtexteditor.model.Logger;
import com.onpositive.richtexteditor.model.partitions.BasePartition;
import com.onpositive.richtexteditor.model.partitions.HRPartition;
import com.onpositive.richtexteditor.model.partitions.ImagePartition;
import com.onpositive.richtexteditor.model.partitions.LinkPartition;

/**
 * 
 * @author 32kda made in USSR
 */
public class HTMLLexListener implements ILexListener {
	// protected boolean isBold = false;
	// protected boolean isItalic = false;
	// protected boolean isUnderlined = false;
	// protected boolean isStrikethrough = false;

	protected boolean isLink = false;
	protected String curHref = "";

	protected boolean isImg = false;
	protected String curSrc = "";
	
	protected Scanner scanner;

	protected Stack<Boolean> boldStack = new Stack<Boolean>();
	protected Stack<Boolean> italicStack = new Stack<Boolean>();
	protected Stack<Boolean> underlinedStack = new Stack<Boolean>();
	protected Stack<Boolean> strikethroughStack = new Stack<Boolean>();
	protected Stack<HashMap<String, String>> styleAttrsStack = new Stack<HashMap<String, String>>();
	protected Stack<Integer> tagsStack = new Stack<Integer>(); // Необходим для
																// корректной
																// обработки
																// не-xhtml,
																// отсл.
																// вложенность
																// тегов

	protected String fontFaceString = "font-family";
	protected String fontSizeString = "font-size";
	protected String fontColorString = "color";
	protected String bkColorString = "background-color";

	protected String h1StyleString = "font-family:Times New Roman; font-size:24pt";
	protected String h2StyleString = "font-family:Times New Roman; font-size:18pt";
	protected String h3StyleString = "font-family:Times New Roman; font-size:14pt";
	protected String h4StyleString = "font-family:Times New Roman; font-size:12pt";

	protected boolean isParagraphAttr = false; // Обозначает, что данный атрибут
												// явл. атрибутом параграфа

	protected StringBuilder curTextStr = new StringBuilder();
	protected ArrayList<BasePartition> partitions = new ArrayList<BasePartition>();
	protected ArrayList<Integer> lineAligns = new ArrayList<Integer>();
	protected ArrayList<Integer> lineBullets = new ArrayList<Integer>();
	protected BasePartitionLayer layer;
	protected StringBuilder globalBuilder = new StringBuilder();
	protected int curAlign = LayerManager.LEFT_ALIGN;
	protected RGB curRGB = null; //Now used to remember <hr> color

	// protected boolean isBulletedList = false;
	// protected boolean isNumberedList = false;
	protected boolean wasLI = false; // Определяет, что в начале строки был тег
										// LI
	protected boolean wasFontTag = false; // Определяет, что был тег font
	protected boolean wasSpanTag = false; // Определяет, что был тег span
	protected boolean appendText = true; // Добавлять ли текущиё текс к
											// итоговому
	protected boolean trimWhiteSpaces = true; // Добавлять ли текущиё текс к
											  // итоговому
	// Необходим, чтобы не добавлять текст из служебных тагов типа style и т.д.

	protected int bulletedListLevel = 0; // Used to manage multi-level list (not
											// really supported yet)
	protected int numberedListLevel = 0;

	protected int currentNumberedListValue = 1; // Чтобы знать, какие баллеты
	protected boolean isHR = false;
												// получать для текущей строки
												// списка
	
	/**
	 * Basic constructor 
	 * @param layer layer for filling with this listener
	 * @param scanner scanner, which we should listen
	 */	
	public HTMLLexListener(BasePartitionLayer layer, Scanner scanner) 
	{
		this.layer = layer;
		this.scanner = scanner;
	}

	/** 
	 *  Main function for parser events handling
	 * @param event LexEvent
	 */
	public void handleLexEvent(LexEvent event) {
		if (event instanceof TagLexEvent) {
			TagLexEvent tagEvent = (TagLexEvent) event;
			int type = tagEvent.getType();
			if (type == -1 || type == Scanner.TYPE_UNKNOWN)
				return;
			HashMap<String, String> currentFontStyleMap;

			if (tagEvent.isOpen()) {
				currentFontStyleMap = new HashMap<String, String>();
				styleAttrsStack.push(currentFontStyleMap);
				tagsStack.push(tagEvent.getType());
			}

			if ((type == Scanner.TYPE_HTML || type == Scanner.TYPE_BODY)) {
				if (resolveStr(curTextStr).length() > 0) {
					BasePartition partition = getNewFontPartition();
					if (partition.getLength() > 0)
						partitions.add(partition);
				}
			} else if (type == Scanner.TYPE_P) {
				if (tagEvent.isOpen()) {
					insertNewLineIfNeeded(); // We must be sure, that list
												// always begins at newline
					isParagraphAttr = true;
					curAlign = LayerManager.LEFT_ALIGN;
				} else
					insertNewLineIfNeeded();
			} else if (type == Scanner.TYPE_BR) {
				styleAttrsStack.pop(); // Because br don't have closing tag to
										// pop there
				tagsStack.pop();
				endOfLineReached();				
			}else if (type == Scanner.TYPE_PRE) 
			{
				BasePartition partition = getNewFontPartition(); //we call this here, because text is being trimmed in getNewFontPartition
				if (partition.getLength() > 0) //or it's submethods
					partitions.add(partition);
				trimWhiteSpaces = !tagEvent.isOpen();
				scanner.setClearEnters(trimWhiteSpaces);
			} else if (type == Scanner.TYPE_OL) {
				if (tagEvent.isOpen())
					numberedListLevel++;
				else {
					if (numberedListLevel > 0)
						numberedListLevel--;
					else
						currentNumberedListValue++;// Means, that list ended,
													// and we must increase this
													// value for possible next
													// list
				}
			} else if (type == Scanner.TYPE_UL) {
				if (tagEvent.isOpen())
					bulletedListLevel++;
				else if (numberedListLevel > 0)
					numberedListLevel--;
			} else if (type == Scanner.TYPE_LI) {
				if (tagEvent.isOpen()) {
					insertNewLineIfNeeded();
					wasLI = true;
				} else
					endOfLineReached();
			} else if (type == Scanner.TYPE_DIV || type == Scanner.TYPE_TABLE
					|| type == Scanner.TYPE_TR) {
				if (tagEvent.isOpen()) {
					insertNewLineIfNeeded();
				} else {
					insertNewLineIfNeeded();
				}
			} else if (type == Scanner.TYPE_STYLE
					|| type == Scanner.TYPE_XML // Skip contents of following
					|| type == Scanner.TYPE_SCRIPT
					|| type == Scanner.TYPE_TITLE) {
				appendText = !tagEvent.isOpen();
			} 
			else if (appendText) // Текст не в служ теге.
			{
				if (type == Scanner.TYPE_IMG && tagEvent.isOpen()) 
				{
					styleAttrsStack.pop(); // Because img don't have closing tag
											// to pop there
					tagsStack.pop();
					isImg = true;
				}
				
				if (type == Scanner.TYPE_HR && tagEvent.isOpen()) 
				{
					
					styleAttrsStack.pop(); // Because hr don't have closing tag
											// to pop there
					tagsStack.pop();
					isHR  = true;
				}

				BasePartition partition = getNewFontPartition();
				if (partition.getLength() > 0)
					partitions.add(partition);

				if (type == Scanner.TYPE_B)
					manageBold(tagEvent.isOpen());
				if (type == Scanner.TYPE_I)
					manageItalic(tagEvent.isOpen());
				if (type == Scanner.TYPE_U)
					manageUnderlined(tagEvent.isOpen());
				if (type == Scanner.TYPE_STRIKE)
					manageStrikethrough(tagEvent.isOpen());
				if (type == Scanner.TYPE_FONT)
					wasFontTag = (tagEvent.isOpen());
				if (type == Scanner.TYPE_SPAN)
					wasSpanTag = (tagEvent.isOpen());
				if (type == Scanner.TYPE_H1) {
					endOfLineReached();
					manageBold(tagEvent.isOpen());
				}
				if (type == Scanner.TYPE_H2) {
					endOfLineReached();
					manageBold(tagEvent.isOpen());
				}
				if (type == Scanner.TYPE_H3) {
					endOfLineReached();
					manageBold(tagEvent.isOpen());
				}
				if (type == Scanner.TYPE_A) {
					if (tagEvent.isOpen())
						isLink = true;
					else {
						isLink = false;
						curHref = "";
					}
				}
			}

			if (!tagEvent.isOpen()) {
				int lastIdx = tagsStack.lastIndexOf(tagEvent.getType());
				if (lastIdx != -1) {
					tagsStack.remove(lastIdx);
					styleAttrsStack.remove(lastIdx);
				}
			}
		} 
		else if (event instanceof AttrValueLexEvent)
		{
			AttrValueLexEvent event2 = (AttrValueLexEvent) event;
			if (event2.type == Scanner.ATTR_TYPE_ALIGN)
			{
				if (isParagraphAttr)
				{
					if (event2.l.equalsIgnoreCase("left"))
						curAlign = LayerManager.LEFT_ALIGN;
					else if (event2.l.equalsIgnoreCase("right"))
						curAlign = LayerManager.RIGHT_ALIGN;
					else if (event2.l.equalsIgnoreCase("justify"))
						curAlign = LayerManager.FIT_ALIGN;
					else if (event2.l.equalsIgnoreCase("center"))
						curAlign = LayerManager.CENTER_ALIGN;
					isParagraphAttr = false;
				}
			} else
			{
				if (!styleAttrsStack.isEmpty())
				{
					HashMap<String, String> peek = styleAttrsStack.peek();

					if (event2.type == Scanner.ATTR_TYPE_COLOR)
					{
						if (wasFontTag || wasSpanTag)
						{
							if (event2.l.indexOf(':') > -1) event2.l = manageStyleString(event2.l, peek);
							else peek.put(fontColorString, event2.l);
						}	
						else if (isHR)
							curRGB = getRGBfromHexRGBString(event2.l);
					} else if (event2.type == Scanner.ATTR_TYPE_STYLE)
					{
						event2.l = manageStyleString(event2.l, peek);
					}
					
				}
				if (event2.type == Scanner.ATTR_TYPE_HREF)
				{
					if (isLink)
						curHref = convertLinkURL(event2.l);
				}else if (event2.type == Scanner.ATTR_TYPE_SRC) {
					if (isImg)
						curSrc = convertImageSrc(event2.l);
				}
			}
		} else if (event instanceof TagEndEvent) // Здесь сбросить все
													// состояния, отн. к тегу
		{
			wasFontTag = false;
			wasSpanTag = false;
			isImg = false;
			isHR = false;
			if (((TagEndEvent) event).isOpen())
			{
				if (((TagEndEvent) event).getType() == Scanner.TYPE_H1)
					inheritStyleFromString(h1StyleString);
				if (((TagEndEvent) event).getType() == Scanner.TYPE_H2)
					inheritStyleFromString(h2StyleString);
				if (((TagEndEvent) event).getType() == Scanner.TYPE_H3)
					inheritStyleFromString(h3StyleString);
				if (((TagEndEvent) event).getType() == Scanner.TYPE_IMG
						&& !curSrc.trim().equals(""))
					appendImage(curSrc);
				if (((TagEndEvent) event).getType() == Scanner.TYPE_HR)
				{
					appendHR(curRGB);
					curRGB = null;
				}
			}
		} else if (event instanceof EOFEvent) {
			BasePartition partition = getNewFontPartition();
			if (partition.getLength() > 0)
				partitions.add(partition);
			if (wasLI) {
				lineAligns.add(curAlign);
				if (bulletedListLevel > 0)
					lineBullets.add(BulletFactory.BULLETED_LIST_CONST);
				else if (numberedListLevel > 0)
					lineBullets.add(currentNumberedListValue);
				else
					lineBullets.add(BulletFactory.NONE_LIST_CONST);
			}
		} else if (appendText) {
			if(!event.l.trim().equals("")) {
				curTextStr.append(event.l);
			}
		}
		// Переводы строки зачищаем заранее, т.к. позже нам надо вставить
		// "значащие" переводы строки
		
		
		if (getLineCount(globalBuilder.toString()) + getLineCount(curTextStr.toString()) != lineAligns.size())
		{
			Logger.log("(!) unsync");
		}
	}

	protected int getLineCount(String s)
	{
		int cnt = 0;
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '\n') cnt++;
		return cnt;
	}
	
	protected String convertImageSrc(String src) {
		return src;
	}

	protected String convertLinkURL(String url) {
		return url;
	}

	private void insertNewLineIfNeeded() {
		if (!checkEolPresence())
			endOfLineReached();
	}

	protected void appendImage(String curSrc)
	{
		int newOffset = getDocEndOffset();

		globalBuilder.append("?");
		Image img = null;
		try
		{
			img = new Image(null, curSrc);
		} catch (Exception e)
		{
			try
			{
				InputStream resourceAsStream = this.getClass().getResourceAsStream("/com/onpositive/richtexteditor/img/notFound.gif");
				img = new Image(null, resourceAsStream);
			}
			catch (Exception e1) 
			{
				System.err.println("Can't find notFound.gif");
			}
		}
		partitions.add(new ImagePartition(layer, newOffset, 1, img, curSrc));

	}
	
	protected void appendHR(RGB rgb)
	{
		int newOffset = getDocEndOffset();
		
		partitions.add(new BasePartition(layer, newOffset, 1));
		globalBuilder.append("\n");
		newOffset++;

		String hrStr = "?\n"; // And here add new HR partition
		HRPartition hrp = new HRPartition(layer, newOffset, hrStr.length());
		if (rgb != null) hrp.setColorRGB(rgb);
		partitions.add(hrp);
		globalBuilder.append(hrStr);
	}
	
	/**
	 * used to get doc index to add partitions to doc's end
	 * 0 if doc contains no partitions,
	 * offset + length of last partition otherwise
	 */
	protected int getDocEndOffset()
	{
		int newOffset = 0; // TODO Maybe, possible to replace with
		// globalBuilder.length
		if (partitions.size() > 0)
			newOffset = partitions.get(partitions.size() - 1).getOffset()
					+ partitions.get(partitions.size() - 1).getLength();
		return newOffset;
	}

	/**
	 * Used to check, is it an eol in the end of current unresolved line or
	 * global StringBuilder
	 * 
	 * @return true, if \n or \r presented false otherwise
	 */
	protected boolean checkEolPresence() {
		String resolveStr = resolveStr(curTextStr);
		if (resolveStr.length() > 0 && !resolveStr.equals(" ")
				&& !resolveStr.equals("\t")) {
			if (resolveStr.charAt(resolveStr.length() - 1) == '\n'
					|| resolveStr.charAt(resolveStr.length() - 1) == '\r') {
				return true;
			}
		} else if (globalBuilder.length() > 0
				&& (globalBuilder.charAt(globalBuilder.length() - 1) == '\n' || globalBuilder
						.charAt(globalBuilder.length() - 1) == '\r'))
			return true;
		if (globalBuilder.toString().trim().equals("")
				&& resolveStr.toString().trim().equals(""))
			return true;
		return globalBuilder.length() == 0 && resolveStr.length() == 0;
	}

	/**
	 * This func is used to inherit style from other attributes and to form
	 * style string with inheritance
	 * 
	 * @param l
	 * @return
	 */
	protected String manageStyleString(String l,
			HashMap<String, String> currentStyleMap) {
		StringTokenizer st = new StringTokenizer(l, ";");
		while (st.hasMoreTokens()) {
			String str = st.nextToken().trim();
			int divPoint = str.indexOf(':');
			try {
				String name = str.substring(0, divPoint).trim();
				String value = str.substring(divPoint + 1).trim();
				currentStyleMap.put(name, value);
			} catch (Exception e) {
			}
		}
		
		searchUndefinedValues(currentStyleMap);

		// styleAttrsStack.push(currentStyleMap); //Here we push current formed
		// style hashmap

		return getStyleStringForStyleMap(currentStyleMap);
	}
	
	protected void searchUndefinedValues(HashMap<String, String> currentStyleMap)
	{
		if (!currentStyleMap.containsKey(fontFaceString))
			searchValueFor(currentStyleMap, fontFaceString);
		if (!currentStyleMap.containsKey(fontSizeString))
			searchValueFor(currentStyleMap, fontSizeString);
		if (!currentStyleMap.containsKey(fontColorString))
			searchValueFor(currentStyleMap, fontColorString);
		if (!currentStyleMap.containsKey(bkColorString))
			searchValueFor(currentStyleMap, bkColorString);
	}
	
	/**
	 * Used to inherit missing attributes for style in a top of style stack from
	 * line l. Used for inheriting style attr for smth like h1
	 * 
	 * @param l
	 * @return attributes string with inheritance
	 */
	protected String inheritStyleFromString(String l) {
		HashMap<String, String> currentStyleMap = styleAttrsStack.peek();
		StringTokenizer st = new StringTokenizer(l, ";");
		while (st.hasMoreTokens()) {
			String str = st.nextToken().trim();
			int divPoint = str.indexOf(':');
			try {
				String name = str.substring(0, divPoint).trim().toLowerCase();
				String value = str.substring(divPoint + 1).trim().toLowerCase();
				if (!currentStyleMap.containsKey(name))
					currentStyleMap.put(name, value);
			} catch (Exception e) {
			}
		}

		return getStyleStringForStyleMap(currentStyleMap);
	}

	/**
	 * Converts styleMap into String
	 * 
	 * @param styleMap
	 * @return
	 */
	protected String getStyleStringForStyleMap(HashMap<String, String> styleMap) {
		String resString = "";
		for (Iterator iterator = styleMap.keySet().iterator(); iterator
				.hasNext();) {
			String key = (String) iterator.next();
			resString = resString + key + ":" + styleMap.get(key) + ";";
		}
		return resString;
	}

	protected void searchValueFor(HashMap<String, String> currentStyleMap,
			String key) {
		String foundValue = null;
		for (Iterator<HashMap<String, String>> iterator = styleAttrsStack
				.iterator(); iterator.hasNext();) {
			HashMap<String, String> map = (HashMap<String, String>) iterator
					.next();
			if (map.containsKey(key)) {
				foundValue = map.get(key);
				break;
			}
		}
		if (foundValue != null)
			currentStyleMap.put(key, foundValue);
	}

	// 4 following Used to manage states stack
	protected void manageBold(boolean open) {
		if (open)
			boldStack.push(true);
		else if (boldStack.size() > 0)
			boldStack.pop();
	}

	protected void manageItalic(boolean open) {
		if (open)
			italicStack.push(true);
		else if (italicStack.size() > 0)
			italicStack.pop();
	}

	protected void manageUnderlined(boolean open) {
		if (open)
			underlinedStack.push(true);
		else if (underlinedStack.size() > 0)
			underlinedStack.pop();
	}

	protected void manageStrikethrough(boolean open) {
		if (open)
			strikethroughStack.push(true);
		else if (strikethroughStack.size() > 0)
			strikethroughStack.pop();

	}

	protected static RGB parseBgColorStyleString(String l) {
		int pos = l.indexOf("background-color:");
		if (pos >= 0) {
			int colorValueStartPos = pos
					+ String.valueOf("background-color:").length();
			String colorString = l.substring(colorValueStartPos,
					colorValueStartPos + 7);
			return parseColorString(colorString);
		}
		return null;
	}

	protected static RGB parseColorString(String colorString) {
		String newString = new String(colorString);
		int pos = newString.indexOf("color:");
		if (pos >= 0) {
			int colorValueStartPos = pos + String.valueOf("color:").length();
			newString = newString.substring(colorValueStartPos,
					colorValueStartPos + 7);
		}
		return getRGBfromHexRGBString(newString);
	}
	
	protected static RGB getRGBfromHexRGBString(String hexRGBString)
	{
		hexRGBString = hexRGBString.trim();
		if (hexRGBString.charAt(0) == '#')
			hexRGBString = hexRGBString.substring(1);
		if (hexRGBString.length() < 6)
			return new RGB(0, 0, 0);
		RGB rgb;
		try {
			rgb = new RGB(Integer.parseInt(hexRGBString.substring(0, 2), 16),
					Integer.parseInt(hexRGBString.substring(2, 4), 16), Integer
							.parseInt(hexRGBString.substring(4, 6), 16));
		} catch (Exception e) {
			rgb = new RGB(0, 0, 0);
		}
		return rgb;
	}

	BasePartition getNewFontPartition() 
	{
		String addAfterPartitionStr = ""; // used for adding some symbols after
											// current partition
		int newOffset = 0;
		if (partitions.size() > 0)
			newOffset = partitions.get(partitions.size() - 1).getOffset()
					+ partitions.get(partitions.size() - 1).getLength();
		BasePartition newPartition;
		if (!curHref.equals("")) {
			if (curTextStr.length() > 0
					&& !Character.isWhitespace(curTextStr.charAt(curTextStr
							.length() - 1)))
				addAfterPartitionStr = " ";
			newPartition = new LinkPartition(layer, newOffset, curTextStr
					.length());
			((LinkPartition) newPartition).setUrl(curHref);
		}

		else
			newPartition = new BasePartition(layer, newOffset, curTextStr
					.length());
		newPartition.setRefreshVisibleState(false); // Не обновлять, т.к.
													// партиция и текст всё ещё
													// в процессе сборки

		newPartition.setBold(boldStack.size() > 0);
		newPartition.setItalic(italicStack.size() > 0);
		newPartition.setUnderlined(underlinedStack.size() > 0);
		newPartition.setStrikethrough(strikethroughStack.size() > 0);

		if (styleAttrsStack.size() > 0) {
			String curFontStyleString = manageStyleString("", styleAttrsStack
					.peek());
			if (curFontStyleString.trim() != "") {
				RGB curBackgroundRGB = parseBgColorStyleString(curFontStyleString);
				RGB curForegroundRGB = parseColorString(curFontStyleString);

				if (curForegroundRGB != null)
					newPartition.setColorRGB(curForegroundRGB);
				if (curBackgroundRGB != null)
					newPartition.setBgColorRGB(curBackgroundRGB);

				if (!curFontStyleString.equals(""))
					newPartition.setFontDataName(curFontStyleString);
			}
		}

		String resStr = resolveStr(curTextStr);
		if (globalBuilder.length() > 0
				&& trimWhiteSpaces
				&& Character.isWhitespace(globalBuilder.charAt(globalBuilder.length() - 1)) && resStr.length() > 0
				&& (resStr.charAt(0) == ' ' || resStr.charAt(0) == '\t'))
			resStr = resStr.substring(1);

		/*if (!trimWhiteSpaces && str.charAt(i) == '\n')
			endOfLineReached();*/
		
		globalBuilder.append(resStr);
		newPartition.setLength(resStr.length());
		curTextStr = new StringBuilder(addAfterPartitionStr);
		return newPartition;
	}

	/**
	 * Inserts \n\r at the end of paragraph && does align & list style calcs, if
	 * needed
	 */
	protected void endOfLineReached() {
		if (trimWhiteSpaces) curTextStr.append("\r\n"); //Otherwise (between <pre> tags) neede enters already exists
		lineAligns.add(curAlign);
		if (bulletedListLevel > 0 && wasLI)
			lineBullets.add(BulletFactory.BULLETED_LIST_CONST);
		else if (numberedListLevel > 0 && wasLI)
			lineBullets.add(currentNumberedListValue);
		else
			lineBullets.add(BulletFactory.NONE_LIST_CONST);
		wasLI = false;
	}

	protected String resolveStr(StringBuilder str) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (builder.length() != 0)
				if (trimWhiteSpaces  && 
					Character.isWhitespace(builder.charAt(builder.length() - 1))) {
					if (str.charAt(i) == ' ' || str.charAt(i) == '\t')
						continue;
				}
			if (!trimWhiteSpaces && str.charAt(i) == '\n')
				endOfLineReached();
			builder.append(str.charAt(i));
		}

		str = builder;

		for (int i = 0; i < str.length(); i++) {
//			if (str.charAt(i) == '&') {
//				int j = str.indexOf(";", i);
//				if (j > i + 1) {
//					String link = str.substring(i + 1, j);
//					char chr = link.c;
//					String l = str.substring(0, i);
//					String r = "";
//					if (j < str.length() - 1)
//						r = str.substring(j + 1);
//					str = new StringBuilder();
//					str.append(l);
//					str.append(chr);
//					str.append(r);
//				}
//			}TODO FIX ME
			
		}
		return str.toString();
	}

	public ArrayList<BasePartition> getPartitions() {
		return partitions;
	}

	public String getText() {
		return globalBuilder.toString();
	}

	public ArrayList<Integer> getLineBullets() {
		return lineBullets;
	}

	public ArrayList<Integer> getLineAligns() {
		return lineAligns;
	}
}

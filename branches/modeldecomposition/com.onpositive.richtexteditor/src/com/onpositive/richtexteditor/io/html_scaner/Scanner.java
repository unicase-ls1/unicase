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
/**
* @author 32kda
* made in USSR
*/
package com.onpositive.richtexteditor.io.html_scaner;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.onpositive.richtexteditor.io.LexEvent;
import com.onpositive.richtexteditor.model.Logger;

/**
 * Предназначен для сканирования различных искусственных текстов.
 * @author root
 * 
 */


public class Scanner 
{
		protected static final int TYPE_END = 0;
		protected static final int TYPE_UNKNOWN = 101;
		protected static final int TYPE_TEXT = 100;
		
		protected static final int TYPE_HTML = 1;
		protected static final int TYPE_BODY = 2;
		protected static final int TYPE_P = 3;
		protected static final int TYPE_B = 4;
		protected static final int TYPE_I = 5;
		protected static final int TYPE_U = 6;
		protected static final int TYPE_STRIKE = 7;
		protected static final int TYPE_FONT = 8;
		protected static final int TYPE_IMG = 9;
		protected static final int TYPE_SPAN = 10;
		
		protected static final int TYPE_BR = 11;
		protected static final int TYPE_OL = 12;
		protected static final int TYPE_UL = 13;
		protected static final int TYPE_LI = 14;
		protected static final int TYPE_STYLE = 15;
		protected static final int TYPE_XML = 16;
		protected static final int TYPE_H1 = 17;
		protected static final int TYPE_H2 = 18;
		protected static final int TYPE_H3 = 19;
		protected static final int TYPE_A = 20;		
		protected static final int TYPE_SCRIPT = 21;
		protected static final int TYPE_TITLE = 22;
		
		protected static final int TYPE_DIV = 23;
		protected static final int TYPE_TR = 24;
		protected static final int TYPE_TABLE = 25;
		protected static final int TYPE_TH = 26;
		protected static final int TYPE_HR = 27;
		protected static final int TYPE_CODE = 28;
		protected static final int TYPE_PRE = 29;
		
		protected static final int ATTR_TYPE_HEIGHT = 50;
		protected static final int ATTR_TYPE_FACE = 51;
		protected static final int ATTR_TYPE_ALIGN = 52;
		protected static final int ATTR_TYPE_COLOR = 53;
		protected static final int ATTR_TYPE_STYLE = 54;
		protected static final int ATTR_TYPE_HREF = 55;
		protected static final int ATTR_TYPE_SRC = 56;
		
		char[] nonTagNameSymbols = new char[]{'"', '\'', '<', '>', '/', '\\', '='};

		protected int uk; 
		protected char[] t;
		protected HashMap<String, Integer> tagKeywords = new HashMap<String,Integer>();
		protected HashMap<String, Integer> attrKeywords = new HashMap<String,Integer>();
		protected ArrayList<ILexListener> listeners = new ArrayList<ILexListener>();
		
		protected static Scanner scaner;
		protected boolean textScanned;
		protected boolean clearEnters = true;
		
		/**
		 * Checks, can this symbol be an ident beginning or not
		 * @param c symbol
		 * @return true/false
		 */
		protected boolean checkForIdentBeginning(char c)
		{
			if ((c>='a') && (c<='z') || 
					   (c>='A') && (c<='Z')
					   || (c == '_')) 
				return true;
			return false;
		}
		
		/**
		 * adds new LexListener
		 * @param lexListener LexListener to add
		 */
		public void addLexListener(ILexListener lexListener)
		{
			listeners.add(lexListener);
		}

		
		/**
		 * Removes LexListener
		 * @param lexListener LexListener to remove
		 */
		public void removeLexListener(ILexListener lexListener)
		{
			listeners.remove(lexListener);
		}
		
		
		/**
		 * Default constructor
		 */
		public Scanner()
		{
			fillKeywords();
		}
		
		protected void fillKeywords()
		{
			tagKeywords.put("html", TYPE_HTML);
			tagKeywords.put("body", TYPE_BODY);
			tagKeywords.put("p", TYPE_P);
			tagKeywords.put("b", TYPE_B);
			tagKeywords.put("i", TYPE_I);
			tagKeywords.put("u", TYPE_U);
			tagKeywords.put("em", TYPE_I);
			tagKeywords.put("strike", TYPE_STRIKE);
			tagKeywords.put("font", TYPE_FONT);
			tagKeywords.put("img", TYPE_IMG);
			tagKeywords.put("span", TYPE_SPAN);
			tagKeywords.put("br", TYPE_BR);
			tagKeywords.put("ol", TYPE_OL);
			tagKeywords.put("ul", TYPE_UL);
			tagKeywords.put("li", TYPE_LI);
			tagKeywords.put("style", TYPE_STYLE);
			tagKeywords.put("xml", TYPE_XML);
			tagKeywords.put("h1", TYPE_H1);
			tagKeywords.put("h2", TYPE_H2);
			tagKeywords.put("h3", TYPE_H3);
			tagKeywords.put("hr", TYPE_HR);
			tagKeywords.put("a", TYPE_A);
			tagKeywords.put("script", TYPE_SCRIPT);
			tagKeywords.put("title", TYPE_TITLE);
			tagKeywords.put("div", TYPE_DIV);
			tagKeywords.put("tr", TYPE_TR);
			tagKeywords.put("table", TYPE_TABLE);
			tagKeywords.put("code", TYPE_CODE);
			tagKeywords.put("pre", TYPE_PRE);
			
			
			attrKeywords.put("height", ATTR_TYPE_HEIGHT);
			attrKeywords.put("face", ATTR_TYPE_FACE);
			attrKeywords.put("align", ATTR_TYPE_ALIGN);
			attrKeywords.put("color", ATTR_TYPE_COLOR);
			attrKeywords.put("style", ATTR_TYPE_STYLE);
			attrKeywords.put("href", ATTR_TYPE_HREF);
			attrKeywords.put("src", ATTR_TYPE_SRC);
			
		}
		
		
		protected boolean checkForTagNameSymbol(char c)
		{
			if (!isIn(c, nonTagNameSymbols) && !Character.isWhitespace(c)) return true;
			return false;
		}
					
		/**
		 * Checks, can this symbol be an ident symbol(not beginning) or not
		 * @param c symbol
		 * @return true/false
		 */
		protected boolean checkForIndentSymbol(char c)
		{
			if (checkForIdentBeginning(c)) return true; //Может быть или начальный символ, или цифра
			if ((t[uk]<='9') && (t[uk]>='0')) return true;
			return false;
		}

		void PutUK (int i) {uk = i;}
		int GetUK () {return uk;};

		void LogError(FileWriter LogFile, String msg) throws IOException
		  {
			if (LogFile != null) LogFile.write("Ошибка! " + msg);
		  }

		
		/**
		 * Main func
		 * @throws Exception
		 */
		void scaner()
		{
			uk = 0;
			while (true)
			{
			  LexEvent lxm = new LexEvent();
			  //pass();
			  if (uk >= t.length) 
				  return ;
			  if (t[uk] == '<')
			    {
				  ++uk;
				  scanForTag();
			    }
			  else
			  	{
				  while (uk < t.length && t[uk] != '<')
					  lxm.l = lxm.l + t[uk++];
				  if (clearEnters) lxm.l = clearFromEnters(lxm.l);
				  handleLexEvent(lxm);
			  	}	
			}
		}
		
		protected void scanForTag()
		{
			pass();
			
			boolean open = true;
			if (t[uk] == '/')
			{				
				open = false;
				uk++;
			}
			if (t[uk] == '!' && uk < t.length - 2 && t[uk+1] == '-' && t[uk+2] == '-') //Comment 
			{
				
				while (uk < t.length && !(t[uk] == '>' && t[uk-1] == '-' && t[uk-2] == '-')) uk++;
				uk++;
				return;					
			}
			
			
			String ident = scanForTagName().toLowerCase();
			
			
			
			int tagType = getTagKeywordType(ident);
			handleLexEvent(new TagLexEvent(ident,tagType,open));
			uk++;
			pass();			
			while (uk < t.length && t[uk] != '>')
			{				
				scanForAttribute();
				pass();
			}			
			if (t[uk] == '>') uk++;
			handleLexEvent(new TagEndEvent(tagType,open));
		}

		protected void scanForAttribute()
		{
			if (!checkForIdentBeginning(t[uk]))
			{
				neutrilzeUpTo('>');
				return;
			}
			String str = "" + t[uk];
			uk++;
			while(checkForTagNameSymbol(t[uk]))
				str = str + t[uk++];
			pass();
			if (t[uk] != '=') 
			{
				neutrilzeUpTo('>');
				return;
			}
			uk++;
			pass();
			String value = getDequotedValueString();
			handleLexEvent(new AttrValueLexEvent(value,getAttrKeywordType(str.toLowerCase())));
		}

		protected String scanForTagName()
		{
			if (!checkForIdentBeginning(t[uk]))
			{
				neutrilzeUpTo('>');
				return "";
			}				
			String str = "" + t[uk];
			uk++;
			while(checkForTagNameSymbol(t[uk]))
				str = str + t[uk++];
			uk--;
			return str;
		}
		
		protected String getDequotedValueString()
		{
			char quote = '\0'; //Means no qoute
			String str = "";
			if (t[uk] == '"' || t[uk] == '\'')
			{
				quote = t[uk];
				uk++;
			}
			if (quote == '\0')
				while (uk < t.length && t[uk] != '>' && !Character.isWhitespace(t[uk]))
					str = str + t[uk++];
			else
				while (uk < t.length && t[uk] != quote)
					str = str + t[uk++];
			if (t[uk] == '"' || t[uk] == '\'') uk++;
			return str.trim();
		}
		
		protected void neutrilzeUpTo(char symbol)
		{
			while (uk < t.length && t[uk] != symbol)
			{
				if ((symbol != '"' && t[uk] == '"') || (symbol != '\'' && t[uk] == '\'')) 
					passStr(t[uk]);				
				uk++;
			}
		}
		
		protected void passStr(char c)
		{
			while (uk < t.length && t[uk] != c)
			{
				if (t[uk] == '\\' && t[uk+1] == c) uk++;
				uk++;
			}
			//uk++; //Пропуск кавычки
		}

		protected void neutrilzeUpTo(char[] symbols)
		{			
			do
			{
				if ((!isIn('"',symbols) && t[uk] == '"') || (!isIn('\'',symbols) && t[uk] == '\'')) 
					passStr(t[uk]);
				if (isIn(t[uk],symbols)) return;
				uk++;
			}
			while (uk < t.length);
		}
		
		boolean isIn(char symbol, char[] array)
		{
			for (int i = 0; i < array.length; i++)
				if (array[i] == symbol) return true;
			return false;
		}
		
		protected int getTagKeywordType(String keyword)
		{
			Integer num = tagKeywords.get(keyword);
			if (num == null) return TYPE_UNKNOWN;
			return num.intValue();
		}

		protected int getAttrKeywordType(String keyword)
		{
			Integer num = attrKeywords.get(keyword);
			if (num == null) return TYPE_UNKNOWN;
			return num.intValue();
		}
		
		/**
		 * Пропускает все незначащие символы		 
		 */
		protected void pass()
		{		  
		  while (uk < t.length && ((t[uk] == ' ') || (t[uk] == '\n') || (t[uk] == '\r') || (t[uk] == '\t')))
		      uk++;
    	}
		
		/**
		 * Gets file's string representation
		 * @param input file
		 */
		
		public void process(File input)
		{
			long k;
			FileReader fr = null;
			k = input.length();
			t = new char[(int) k];		  
			try 
			{
				fr = new FileReader(input);
			} 
			catch (FileNotFoundException e) 
			{
	          Logger.log("CoНе могу открыть файл - " + input.getName() + "!");
	          System.exit(-1);
			}
			try 
			{
				process(fr,k);
			} 
			catch (IOException e) 
			{				
				Logger.log("Error reading file - " + input.getName() + "!");
		        return;		
		    }			
		}
		
		/**
		 * Method for processing Reader provided contents
		 * @param reader Reader
		 * @param charCount char count to read
		 * @throws IOException in case of i/o error
		 */
		public void process(Reader reader, long charCount) throws IOException
		{
			t = new char[(int) charCount];	
			reader.read(t,0,(int) charCount);
			scaner();
			handleLexEvent(new EOFEvent());
			textScanned = true;
		}
		
		/**
		 * Gets file's string representation
		 * @param fileName File Name
		 * @throws IOException in case of file reading errors
		 */
		protected void process(String fileName) throws IOException
		{
			File input = new File(fileName);
			process(input);
		}
		
		protected void handleLexEvent(LexEvent event)
		{
			for (Iterator<ILexListener> iterator = listeners.iterator(); iterator.hasNext();)
			{
				ILexListener listener = (ILexListener) iterator.next();
				listener.handleLexEvent(event);
			}
		}
		
		protected String clearFromEnters(String l)
		{
			l = l.replace('\r',' ');
			l = l.replace('\n',' ');
			return l;
		}

		
		boolean isScanned()
		{
			return textScanned;
		}

		
		/**
		 * @return true if parser clears text fragments from newline symbols
		 */
		public boolean isClearEnters()
		{
			return clearEnters;
		}

		
		/**
		 * @param clearEnters should parser clear text fragments from newline symbols?
		 */
		public void setClearEnters(boolean clearEnters)
		{
			this.clearEnters = clearEnters;
		}

}

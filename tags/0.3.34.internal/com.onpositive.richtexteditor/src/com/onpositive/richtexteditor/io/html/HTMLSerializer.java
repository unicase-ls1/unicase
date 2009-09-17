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

package com.onpositive.richtexteditor.io.html;

import java.io.PrintWriter;
import java.util.HashMap;

import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;

import com.onpositive.richtexteditor.io.TextSerializer;
import com.onpositive.richtexteditor.model.FontStyle;
import com.onpositive.richtexteditor.model.LayerManager;
import com.onpositive.richtexteditor.model.partitions.BasePartition;
import com.onpositive.richtexteditor.model.partitions.HRPartition;
import com.onpositive.richtexteditor.model.partitions.ImagePartition;
import com.onpositive.richtexteditor.model.partitions.LinkPartition;


/**
 * @author 32kda
 * {@link TextSerializer} impl for serializing into HTML format
 */
public class HTMLSerializer extends TextSerializer
{
	protected static final String BOLD_CLOSE_TAG = "</b>";
	protected static final String ITALIC_CLOSE_TAG = "</i>";
	protected static final String UNDERLINE_CLOSE_TAG = "</u>";
	protected static final String STRIKE_CLOSE_TAG = "</STRIKE>";
	protected static final String STRIKE_OPEN_TAG = "<STRIKE>";
	protected static final String UNDERLINE_OPEN_TAG = "<u>";
	protected static final String ITALIC_OPEN_TAG = "<i>";
	protected static final String BOLD_OPEN_TAG = "<b>";
	protected ISerializationHelper helper;
	
	
	/**
	 * @return returns a helper
	 */
	public ISerializationHelper getHelper() {
		return helper;
	}

	/**
	 * @param helper ISerializationHelper to set 
	 */
	public void setHelper(ISerializationHelper helper) {
		this.helper = helper;
	}	
	
	
	/**
	 * Basic constructor
	 * @param manager {@link LayerManager} instance
	 */
	public HTMLSerializer(LayerManager manager)
	{
		numberedListsEnds = new HashMap<Integer, Bullet>();
		curLayer = manager.getLayer();
		fontRegistry = manager.getFontRegistry();
		editor = manager.getEditor();
		doc = manager.getDocument();
	}
			
	/**
	 * Serializes all contents to the specific PrintWriter
	 * @param pw PrintWriter
	 */
	public void serializeAll(PrintWriter pw)
	{
		pw.println("<html>");
		
		pw.println("<body >");
			for (int i = 0; i < doc.getNumberOfLines(); i++)
			{
				pw.println(getSerializedLine(i));
			}
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
	
	
	/**
	 * Return an html string representing some partition wiith all needed style tags etc. 
	 * @param partition partition to serialize
	 * @param partitionText text of such partition.
	 * Can differ from partition text, when we want to get the style for the part of the partition
	 * @return html string for partition with styles  
	 */
	public String applyPartitionStyleToString(BasePartition partition, String partitionText)
	{
		if (partition instanceof ImagePartition)
			return getImageStr((ImagePartition)partition);
		if (partition instanceof HRPartition && partitionText.trim().length() > 0)
			return getHRString((HRPartition)partition);
		
		StringBuilder str = new StringBuilder();
		
		boolean fontTag = false, spanTag = false;
		if (!partition.getFontDataName().equals(FontStyle.NORMAL_FONT_NAME))
		{			
			str.append(getFontStyleOpeningTag(partition));
			spanTag = true;
		}
		if (partition.getColorRGB() != null && !partition.getColorRGB().equals(black)) 
		{
			if (!fontTag) {	str.append(getFontColorTagOpenString()); fontTag = true;}
			str.append(getColorStr(partition.getColorRGB()));
		}
		if (partition.getBgColorRGB() != null && !partition.getBgColorRGB().equals(white)) 
		{
			if (!fontTag) {	str.append(getFontColorTagOpenString());fontTag = true;}
			str.append(getBgColorStr(partition.getBgColorRGB()));
		}
		if (fontTag) {
			str.append(getTagCloseString());
		}
				
		if (partition.isBold()) str.append(getBoldStartString());
		if (partition.isItalic()) str.append(getItalicStartString());
		if (partition.isUnderlined()) str.append(getUnderlinedStartString());
		if (partition.isStrikethrough()) str.append(getStrikeStartString());
		
		
		if (partition instanceof LinkPartition)
		{
			str.append(getLinkStartString((LinkPartition) partition));		
		}
		if (helper!=null){
			String prefix=helper.getAdditionPartitionPrefix(partition);
			if (prefix!=null){
			str.append(prefix);
			}
		}
		str.append(encodeStrToHTML(partitionText));
		if (helper!=null){
			String prefix=helper.getAdditionPartitionSuffix(partition);
			if (prefix!=null){
			str.append(prefix);
			}
		}
		
		StringBuilder carriageReturn = new StringBuilder();
		int n = str.length() - 1;
		while (n > 0 && (str.charAt(n) == '\n' || str.charAt(n) == '\r'))
		{
			carriageReturn.append(str.charAt(n));
			str.deleteCharAt(n);
			n--;
		}
		carriageReturn.reverse();
		
		if (partition instanceof LinkPartition) str.append(getLinkEndString());
			
		if (partition.isStrikethrough()) str.append(getStrikeEndString());
		if (partition.isUnderlined()) str.append(getUnderlinedEndString());
		if (partition.isItalic()) str.append(getItalicEndString());
		if (partition.isBold()) str.append(getBoldEndString());
		if (fontTag) str.append(getFontColorTagCloseString());
		if (spanTag) str.append(getFontStyleClosingTag(partition));
		
		if (carriageReturn.length() > 0) str.append(carriageReturn);
		
		return str.toString();		
	}
	
	protected String getHRString(HRPartition partition)
	{
		String str = "<hr";
		if (partition.getColorRGB() != null)
			str = str + getColorStr(partition.getColorRGB());
		str = str + ">";
		return str;
	}


	protected String encodeStrToHTML(String str)
	{
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < str.length(); i++)
		{
			if (builder.length()!=0)
			{
				if (Character.isWhitespace(builder.charAt(builder.length()-1)))
				{
						if (str.charAt(i) == ' ')
						{
							builder.append("&nbsp;");
							continue;
						}
				}
			}
			builder.append(str.charAt(i));
		}
		String str2 = builder.toString();
		str2.replace(" ", "&nbsp;");
		str2.replace("<", "&lt;");
		str2.replace(">", "&gt;");
		str2.replace("&", "&amp;");
		
		return str2;
	}
	
	protected String getImageStr(ImagePartition partition)
	{
		String imageFileName = partition.getImageFileName();
		if (helper!=null){
			imageFileName=helper.getImageLocation(partition);
		}
		return "<IMG src=\"" + imageFileName + "\">";
	}

	/**
	 * <b>Unused</b>
	 * @param fontDataName
	 * @return
	 */
	protected String getFontFaceStr(String fontDataName)
	{
		return " face = \"" + fontRegistry.get(fontDataName).getFontData()[0].getName() +
			   "\" height = \"" + fontRegistry.get(fontDataName).getFontData()[0].getHeight() + "px\"";
	}

	/**
	 * <b>Unused</b>
	 * @param fontDataName
	 * @return
	 */
	protected String getFontCSSStr(String fontDataName)
	{
		return " font-family : " + fontRegistry.get(fontDataName).getFontData()[0].getName() + ";\n" +
			   " font-size :" + fontRegistry.get(fontDataName).getFontData()[0].getHeight() + "px;";
	}
	
	/**
	 * <b>Unused</b>
	 * @param fontDataName
	 * @return
	 */
	protected String getBodyFontParametersStr()
	{
		 String str = "<style type=\"text/css\">\n";
		 str = str + "body\n{\n";
		 str = str + getFontCSSStr(FontStyle.NORMAL_FONT_NAME);
		 str = str + "}\n</style>\n";
        return str;
	}
	
	protected String getColorStr(RGB color)
	{		
		return " color = \"" + getRGBColorHexStr(color) + "\""; 
	}
	
	protected String getBgColorStr(RGB color)
	{
		return " style=\"background-color:" + getRGBColorHexStr(color) + "\"";
	}
	
	protected String getRGBColorHexStr(RGB color)
	{
		String r = Integer.toHexString(color.red);
		if (r.length() == 1) r = "0" + r;
		String g = Integer.toHexString(color.green);
		if (g.length() == 1) g = "0" + g;
		String b = Integer.toHexString(color.blue);
		if (b.length() == 1) b = "0" + b;
		return "#" + r + g + b; 
	}


	
	protected String getCenterAlignAttributeString()
	{
		return "align = \"center\"";
	}


	
	protected String getFileEndString()
	{
		return "</body></html>";
	}


	
	protected String getFileStartString()
	{
		return 	"<html>\n<body>\n";// + getBodyFontParametersStr();
	}


	
	protected String getJustifyAlignAttributeString()
	{
		return "align = \"justify\"";
	}


	
	protected String getLeftAlignAttributeString()
	{
		return "align = \"left\"";
	}


	
	protected String getLineBreakString()
	{
		return "<br>";
	}


	
	protected String getParagraphEndString()
	{		
		return "</P>";
	}


	
	protected String getParagraphStartString()
	{
		return "<P  style=\"margin: 4;\"";
	}


	
	protected String getRightAlignAttributeString()
	{
		return 	"align = \"right\"";
	}


	
	protected String getTagCloseString()
	{
		return ">";
	}


	
	protected String getBulletedListCloseString()
	{
		return "</ul>";
	}


	
	protected String getBulletedListOpenString()
	{
		return "<ul>";
	}


	
	protected String getBulletedListElementStartString()
	{
		return "<li>";
	}


	
	protected String getNumberedListCloseString()
	{
		return "</ol>";
	}


	
	protected String getNumberedListOpenString()
	{
		return "<ol>";
	}

	protected String getNumberedListElementStartString(String bulletText)
	{
		return getBulletedListElementStartString();
	}

	protected String getLinkEndString()
	{		
		return "</A>";
	}

	protected String getLinkStartString(LinkPartition partition)
	{
		LinkPartition linkPartition = (LinkPartition) partition;
		String url = linkPartition.getUrl();
		if (helper!=null){
			url=helper.getLinkURL(linkPartition);
		}
		return "<A href = \"" + url + "\">";	
		
	}

	protected String getBoldEndString()
	{
		return BOLD_CLOSE_TAG;
	}

	protected String getBoldStartString()
	{
		return BOLD_OPEN_TAG;
	}

	protected String getItalicEndString()
	{
		return ITALIC_CLOSE_TAG;
	}

	protected String getItalicStartString()
	{
		return ITALIC_OPEN_TAG;
	}

	protected String getStrikeEndString()
	{
		return STRIKE_CLOSE_TAG;
	}

	protected String getStrikeStartString()
	{
		return STRIKE_OPEN_TAG;
	}

	protected String getUnderlinedEndString()
	{
		return UNDERLINE_CLOSE_TAG;
	}

	protected String getUnderlinedStartString()
	{
		return UNDERLINE_OPEN_TAG;
	}

	@Override
	protected String getFontStyleClosingTag(BasePartition partition)
	{
		return "</span>";
	}

	@Override
	protected String getFontStyleOpeningTag(BasePartition partition)
	{
		FontData fd = fontRegistry.get(partition.getFontDataName()).getFontData()[0];
		return "<span style='font-family:" + fd.getName() + "; font-weight: normal; font-size: " + fd.getHeight() + "pt;' >";
	}

	@Override
	protected String getFontColorTagOpenString()
	{
		return "<font ";
	}

	@Override
	protected String getFontColorTagCloseString()
	{
		return "</font>";
	}
	
}

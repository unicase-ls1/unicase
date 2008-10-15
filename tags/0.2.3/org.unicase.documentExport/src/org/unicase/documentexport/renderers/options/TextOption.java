package org.unicase.documentexport.renderers.options;

import java.awt.Color;

@SuppressWarnings("serial")
public class TextOption extends RendererOption  {
	public int fontFamily = TextOption.ARIAL;
	public int size = 12;
	public boolean bold = false;
	public boolean italics = false;
	public boolean underline = false;
	public boolean strikethrough = false;
	public Color color = new Color(0,0,0);
	
	public static final int ARIAL = 0;
	public static final int TIMES_NEW_ROMAN = 1;
	public static final int VERDANA = 2;
	public static final int COURIER = 3;
}

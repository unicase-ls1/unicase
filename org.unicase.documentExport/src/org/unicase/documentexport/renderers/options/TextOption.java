package org.unicase.documentexport.renderers.options;

import java.awt.Color;

@SuppressWarnings("serial")
public class TextOption extends RendererOption  {
	public int fontFamily = TextOption.ARIAL;
	public int size = 12;
	public boolean bold = false;
	public int getFontFamily() {
		return fontFamily;
	}
	public void setFontFamily(int fontFamily) {
		this.fontFamily = fontFamily;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public boolean isBold() {
		return bold;
	}
	public void setBold(boolean bold) {
		this.bold = bold;
	}
	public boolean isItalics() {
		return italics;
	}
	public void setItalics(boolean italics) {
		this.italics = italics;
	}
	public boolean isUnderline() {
		return underline;
	}
	public void setUnderline(boolean underline) {
		this.underline = underline;
	}
	public boolean isStrikethrough() {
		return strikethrough;
	}
	public void setStrikethrough(boolean strikethrough) {
		this.strikethrough = strikethrough;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public boolean italics = false;
	public boolean underline = false;
	public boolean strikethrough = false;
	public Color color = new Color(0, 0, 0);
	
	public static final int ARIAL = 0;
	public static final int TIMES_NEW_ROMAN = 1;
	public static final int VERDANA = 2;
	public static final int COURIER = 3;
}

package org.unicase.documentexport.renderers.elements;

import java.awt.Color;

public class UEntry {
	public String text = "";
	
	public int colspan = 1;
	public Color backgroundColor = new Color(255, 255, 255);
	public float borderWidth = 1;
	public Color borderColor = new Color(0, 0, 0);
	
	public UEntry(String text) {
		this.text = text;
	}
}

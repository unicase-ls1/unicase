package org.unicase.documentexport.renderers.options;

import java.awt.Color;

public class BooleanOption extends RendererOption {
	public int style = BooleanOption.YES_NO;
	public Color trueColor = new Color(0, 0, 0);
	public Color falseColor = new Color(0, 0, 0);
	
	public static final int CHECKBOX = 0;
	public static final int YES_NO = 1;
	public static final int NUMBER = 2;
	public static final int TRUE_FALSE = 3;
}

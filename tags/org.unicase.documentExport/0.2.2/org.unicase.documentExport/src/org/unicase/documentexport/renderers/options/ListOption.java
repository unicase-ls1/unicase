package org.unicase.documentexport.renderers.options;

public class ListOption extends RendererOption {
	public int listStyle = JUST_NEW_LINES;
	public String bullet = "-";
	public String seperator = ",";
	
	public static final int BULLETED = 0;
	public static final int JUST_NEW_LINES = 1;
	public static final int SPERERATED_LIST = 2; 
}

package org.unicase.documentexport.renderers.options;

import java.awt.Graphics;

public class LayoutOptions extends RendererOption {
	public Graphics logo = null;
	public int pageNumberingStyle = LayoutOptions.ONLY_PAGE;
	public String header = "";
	public String footer = "";
	public String coverPage = "";
	public TextOption coverTextOption = new TextOption();
	public TextOption defaultTextOption = new TextOption();
	public TextOption sectionTextOption = new TextOption();
	public boolean hideEmptyAttributes = true;
	public boolean alwaysShowDescription = true;
	
	public static final int ONLY_PAGE = 0;
	public static final int PAGE_OF_MAX_PAGE = 1;
	public static final int NONE = 2;
	
	public LayoutOptions() {
		sectionTextOption.bold = true;
		sectionTextOption.size = 14;
		defaultTextOption.size = 10;
	}
}

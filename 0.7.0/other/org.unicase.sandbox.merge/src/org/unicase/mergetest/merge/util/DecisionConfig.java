package org.unicase.mergetest.merge.util;

import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public class DecisionConfig {

	public static final int OPTION_LENGTH = 50;
	
	public static final String SEPERATOR = "#";
	
	public static final String EDITABLE = "editable";

	public static final String WIDGET_MULTILINE = "org.unicase.merge.widget.multiline";

	public static final String WIDGET_MULTILINE_EDITABLE = WIDGET_MULTILINE+SEPERATOR+EDITABLE;

	public static final String WIDGET_OTHERINVOLVED = "org.unicase.merge.widget.otherinvolved";
	
	

	public static void initFonts(FontRegistry fontRegistry) {
		fontRegistry.put("titleLabel", new FontData[] { new FontData("Arial",
				8, SWT.ITALIC) });
		fontRegistry.put("content", new FontData[] { new FontData("Arial", 9,
				SWT.NONE) });
	}
	
	public static Color getOptionSelectedBack() {
		return new Color(Display.getCurrent(), 0, 127, 14);
	}

	public static Color getOptionSelectedBackEnter() {
		return new Color(Display.getCurrent(), 165, 255, 142);
	}
	
	public static Color getOptionSelectedFor() {
		return Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
	}
	
	public static Color getOptionEnteredColor() {
		return Display.getCurrent().getSystemColor(
				SWT.COLOR_INFO_BACKGROUND);
	}
	public static Color getDefaultColor() {
		return null;
	}

}
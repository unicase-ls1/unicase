package org.unicase.workspace.ui.dialogs.merge.util;

import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public class DecisionConfig {

	public static final int OPTION_LENGTH = 50;

	public static final String SEPERATOR = "#";

	public static final String EDITABLE = "editable";

	public static final String WIDGET_MULTILINE = "org.unicase.merge.widget.multiline";

	public static final String WIDGET_MULTILINE_EDITABLE = WIDGET_MULTILINE + SEPERATOR + EDITABLE;

	public static final String WIDGET_OTHERINVOLVED = "org.unicase.merge.widget.otherinvolved";

	public static void initFonts(FontRegistry fontRegistry) {
		FontData[] fontData = JFaceResources.getDialogFontDescriptor().getFontData();
		if (fontData.length > 0) {
			fontData[0].setStyle(SWT.ITALIC);
			fontData[0].setHeight(fontData[0].getHeight() - 1);
		}
		fontRegistry.put("titleLabel", fontData);
		fontRegistry.put("content", JFaceResources.getDialogFontDescriptor().getFontData());
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
		return new Color(Display.getCurrent(), 250, 230, 95);
	}

	public static Color getDefaultColor() {
		return new Color(Display.getCurrent(), 240, 240, 240);
	}

	public static Color getDefaultTextColor() {
		return Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);
	}

	public static Color getFirstDecisionBoxColor() {
		return Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
	}

	public static Color getSecondDecisionBoxColor() {
		return new Color(Display.getCurrent(), 226, 233, 255);

	}
}
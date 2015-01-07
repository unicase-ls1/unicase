/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors.options;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.emfstore.internal.client.model.util.WorkspaceUtil;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.unicase.docExport.editors.TemplateEditor;
import org.unicase.docExport.exportModel.renderers.options.FontFamily;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.docExport.exportModel.renderers.options.UColor;

/**
 * @author Sebastian Hoecht
 */
public class TTextoption extends Composite {

	private static final int FONT_SIZE_MAX = 36;
	private static final int FONT_SIZE_MIN = 8;

	/**
	 * This currently creates an Empty Composite, because there arent any string specific options yet.
	 * 
	 * @param parent SWT Composite parent
	 * @param textOption a TextOption
	 * @param editor the editor for dirty checking
	 * @param title the title of the SWT Group containing all SWT Elements of the TextOption
	 */
	public TTextoption(Composite parent, final TemplateEditor editor, String title, final TextOption textOption) {
		super(parent, SWT.NONE);

		setLayout(new GridLayout());

		Group group = new Group(parent, SWT.BORDER);
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 2;
		group.setLayout(gLayout);
		GridData gData = new GridData(SWT.FILL, SWT.FILL, true, true);
		group.setLayoutData(gData);
		group.setText(title);

		if (textOption == null) {
			WorkspaceUtil.log("A TextOption is null", new Exception(), IStatus.ERROR);
			return;
		}

		// bold
		new Label(group, SWT.LEFT).setText("Bold");
		Button bold = new Button(group, SWT.CHECK);
		bold.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				textOption.setBold(((Button) e.widget).getSelection());
				editor.testDirty();
			}
		});
		bold.setSelection(textOption.isBold());

		// underline
		new Label(group, SWT.LEFT).setText("Underline");
		Button underline = new Button(group, SWT.CHECK);
		underline.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				textOption.setUnderline(((Button) e.widget).getSelection());
				editor.testDirty();
			}
		});
		underline.setSelection(textOption.isUnderline());

		// italics
		new Label(group, SWT.LEFT).setText("Italics");
		Button italics = new Button(group, SWT.CHECK);
		bold.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				textOption.setItalics(((Button) e.widget).getSelection());
				editor.testDirty();
			}
		});
		italics.setSelection(textOption.isItalics());

		// font family
		new Label(group, SWT.LEFT).setText("Font family");
		Combo font = new Combo(group, SWT.READ_ONLY);
		ComboViewer fontViewer = new ComboViewer(font);
		for (FontFamily family : FontFamily.VALUES) {
			fontViewer.add(family);
		}

		font.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				textOption.setFontFamily(FontFamily.get(((Combo) e.widget).getSelectionIndex()));
				editor.testDirty();
			}
		});

		font.select(textOption.getFontFamily().getValue());

		// font size
		new Label(group, SWT.LEFT).setText("Font size");
		Combo fontSize = new Combo(group, SWT.READ_ONLY);
		int i2 = 0;
		for (int i = FONT_SIZE_MIN; i <= FONT_SIZE_MAX; i++) {
			i2++;
			fontSize.add(String.valueOf(i));
		}

		fontSize.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				textOption.setFontSize(((Combo) e.widget).getSelectionIndex() + FONT_SIZE_MIN);
				editor.testDirty();
			}
		});
		fontSize.select(textOption.getFontSize() - FONT_SIZE_MIN);

		// text align
		new Label(group, SWT.LEFT).setText("Text Align");
		Combo textAlign = new Combo(group, SWT.READ_ONLY);
		for (TextAlign style : TextAlign.VALUES) {
			textAlign.add(style.getLiteral(), style.getValue());
		}
		textAlign.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				textOption.setTextAlign(TextAlign.get(((Combo) e.widget).getSelectionIndex()));
				editor.testDirty();
			}
		});
		textAlign.select(textOption.getTextAlign().getValue());

		// text color
		new Label(group, SWT.LEFT).setText("Font color");
		final Button colorSelect = new Button(group, SWT.PUSH);
		colorSelect.setText("...");
		colorSelect.setBackground(getSWTColor(textOption.getFontColor()));
		colorSelect.setForeground(getSWTColor(textOption.getFontColor()));
		colorSelect.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				ColorDialog colorDialog = new ColorDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell());
				colorDialog.setRGB(getRGB(textOption.getFontColor()));
				RGB color = colorDialog.open();
				if (color != null) {
					UColor uColor = OptionsFactory.eINSTANCE.createUColor();
					uColor.setRed(color.red);
					uColor.setGreen(color.green);
					uColor.setBlue(color.blue);
					textOption.setFontColor(uColor);
					colorSelect.setBackground(getSWTColor(uColor));
					colorSelect.setForeground(getSWTColor(uColor));
					editor.testDirty();
				}
			}
		});

		pack();
		layout();
	}

	private static Color getSWTColor(UColor uColor) {
		return new Color(null, uColor.getRed(), uColor.getGreen(), uColor.getBlue());
	}

	private static RGB getRGB(UColor uColor) {
		RGB rgb = new RGB(uColor.getRed(), uColor.getGreen(), uColor.getBlue());
		return rgb;
	}
}

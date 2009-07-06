/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.Enumerator;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;
import org.unicase.docExport.exportModel.renderers.options.FontFamily;
import org.unicase.docExport.exportModel.renderers.options.ListOption;
import org.unicase.docExport.exportModel.renderers.options.ListStyle;
import org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.ReferenceOption;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;
import org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle;
import org.unicase.docExport.exportModel.renderers.options.SectionOption;
import org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.StringAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.docExport.exportModel.renderers.options.UColor;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author Sebastian Hoecht
 */
public final class AttributeOptionFactory {

	private AttributeOptionFactory() {
	}

	/**
	 * @param parent the SWT parent where the formular shall be created
	 * @param option the RenderOption an formular shall be created of
	 */
	public static void buildOptionsFormular(Composite parent, RendererOption option) {

		if (option instanceof AttributeOption) {
			buildAttributeOption(parent, (AttributeOption) option);
		} else if (option instanceof ReferenceOption) {
			buildReferenceOption(parent, (ReferenceOption) option);
		} else if (option instanceof ListOption) {
			buildListOption(parent, (ListOption) option);
		} else if (option instanceof SectionOption) {
			buildSectionOption(parent, (SectionOption) option);
		} else if (option instanceof TextOption) {
			buildTextOption(parent, (TextOption) option, option.getName());
		} else {
			return;
		}
	}

	private static void buildSectionOption(Composite parent, final SectionOption option) {
		Composite container = createContainer(parent);
		Combo sectionStyle = AttributeOptionFactory.createComboBox(container, "section style",
			SectionNumberingStyle.VALUES, option.getSectionNumberingStyle().getValue());

		sectionStyle.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.setSectionNumberingStyle(SectionNumberingStyle.get(((Combo) e.widget).getSelectionIndex()));
			}
		});
		sectionStyle.select(option.getSectionNumberingStyle().getValue());
	}

	private static void buildListOption(Composite parent, final ListOption option) {
		Composite container = createContainer(parent);
		Combo listStyle = AttributeOptionFactory.createComboBox(container, "List style", ListStyle.VALUES, option
			.getListStyle().getValue());

		listStyle.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.setListStyle(ListStyle.get(((Combo) e.widget).getSelectionIndex()));
			}
		});
		listStyle.select(option.getListStyle().getValue());
	}

	private static void buildAttributeOption(Composite parent, final AttributeOption option) {
		Composite container = createContainer(parent);

		// alternative text for the attribute
		newLabel(container, "attribute text");
		Text attributeText = new Text(container, SWT.MULTI | SWT.BORDER);
		attributeText.setLayoutData((new GridData(GridData.FILL_HORIZONTAL)));
		attributeText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.setAttributeText((((Text) e.widget).getText()));
			}
		});
		attributeText.setText(option.getAttributeText());

		// order number for the attribute
		newLabel(container, "order number");
		Combo orderNumber = new Combo(container, SWT.READ_ONLY);
		for (int i = -10; i <= 10; i++) {
			orderNumber.add(String.valueOf(i), i + 10);
		}

		orderNumber.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.setOrderNumber(((Combo) e.widget).getSelectionIndex() - 10);
			}
		});
		orderNumber.select(option.getOrderNumber() + 10);

		// overwrite global option
		Button button = new Button(container, SWT.CHECK);
		button.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				option.setOverwriteGlobalOption(((Button) e.widget).getSelection());
			}
		});
		button.setSelection(option.isOverwriteGlobalOption());
		new Label(container, SWT.LEFT).setText("overwrite");

		// hide attribute
		Button button2 = new Button(container, SWT.CHECK);
		button2.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				option.setHide(((Button) e.widget).getSelection());
			}
		});
		button2.setSelection(option.isHide());
		new Label(container, SWT.LEFT).setText("hide");

		if (option instanceof StringAttributeOption) {
			buildStringAttributeOption(parent, (StringAttributeOption) option);
		} else if (option instanceof MultiReferenceAttributeOption) {
			buildMultiReferenceAttributeOption(parent, (MultiReferenceAttributeOption) option);
		} else if (option instanceof SingleReferenceAttributeOption) {
			buildSingleReferenceAttributeOption(parent, (SingleReferenceAttributeOption) option);
		}
	}

	private static void buildMultiReferenceAttributeOption(Composite parent, final MultiReferenceAttributeOption option) {
		buildReferenceOption(parent, option.getReferenceOption());

		Composite container = createContainer(parent);

		Button contained = new Button(container, SWT.CHECK);
		contained.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				option.setContained(((Button) e.widget).getSelection());
			}
		});
		contained.setSelection(option.isContained());
		newLabel(container, "contained");

		buildListOption(parent, option.getListOption());
	}

	private static void buildSingleReferenceAttributeOption(Composite parent,
		final SingleReferenceAttributeOption option) {
		buildReferenceOption(parent, option.getReferenceOption());

		Composite container = createContainer(parent);

		Button contained = new Button(container, SWT.CHECK);
		contained.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				option.setContained(((Button) e.widget).getSelection());
			}
		});
		contained.setSelection(option.isContained());
		newLabel(container, "contained");
	}

	/**
	 * @param parent the SWT parent Composite
	 * @param option the TextOption which shall be editable
	 * @param title the title of the SWT Group paret
	 */
	public static void buildTextOption(Composite parent, final TextOption option, String title) {

		Group group = new Group(parent, SWT.BORDER);
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 2;
		group.setLayout(gLayout);
		GridData gData = new GridData(SWT.FILL, SWT.FILL, true, true);
		group.setLayoutData(gData);
		group.setText(title);

		if (option == null) {
			WorkspaceUtil.log("A TextOption is null", new Exception(), IStatus.ERROR);
			return;
		}

		// bold
		newLabel(group, "bold");
		Button bold = new Button(group, SWT.CHECK);
		bold.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				option.setBold(((Button) e.widget).getSelection());
			}
		});
		bold.setSelection(option.isBold());

		// underline
		newLabel(group, "underline");
		Button underline = new Button(group, SWT.CHECK);
		underline.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				option.setUnderline(((Button) e.widget).getSelection());
			}
		});
		underline.setSelection(option.isUnderline());

		// italics
		newLabel(group, "italics");
		Button italics = new Button(group, SWT.CHECK);
		italics.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				option.setUnderline(((Button) e.widget).getSelection());
			}
		});
		italics.setSelection(option.isItalics());

		// font family
		newLabel(group, "Font family");
		Combo font = new Combo(group, SWT.READ_ONLY);
		for (FontFamily family : FontFamily.VALUES) {
			font.add(family.getLiteral(), family.getValue());
		}
		font.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.setFontFamily(FontFamily.get(((Combo) e.widget).getSelectionIndex()));
			}
		});
		font.select(option.getFontFamily().getValue());

		// font size
		newLabel(group, "Font size");
		Combo fontSize = new Combo(group, SWT.READ_ONLY);
		int i2 = 0;
		for (int i = 8; i <= 36; i++) {
			i2++;
			fontSize.add(String.valueOf(i));
		}

		fontSize.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.setFontSize(((Combo) e.widget).getSelectionIndex() + 8);
			}
		});
		fontSize.select(option.getFontSize() - 8);

		// text align
		newLabel(group, "Text align");
		Combo textAlign = new Combo(group, SWT.READ_ONLY);
		for (TextAlign style : TextAlign.VALUES) {
			textAlign.add(style.getLiteral(), style.getValue());
		}
		textAlign.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.setTextAlign(TextAlign.get(((Combo) e.widget).getSelectionIndex()));
			}
		});
		textAlign.select(option.getTextAlign().getValue());

		// text color
		newLabel(group, "Color");
		final Button colorSelect = new Button(group, SWT.PUSH);
		colorSelect.setText("...");
		colorSelect.setBackground(getSWTColor(option.getFontColor()));
		colorSelect.setForeground(getSWTColor(option.getFontColor()));
		colorSelect.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				ColorDialog colorDialog = new ColorDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell());
				colorDialog.setRGB(getRGB(option.getFontColor()));
				RGB color = colorDialog.open();
				UColor uColor = OptionsFactory.eINSTANCE.createUColor();
				uColor.setRed(color.red);
				uColor.setGreen(color.green);
				uColor.setBlue(color.blue);
				option.setFontColor(uColor);
				colorSelect.setBackground(getSWTColor(uColor));
				colorSelect.setForeground(getSWTColor(uColor));
			}

		});
	}

	private static RGB getRGB(UColor uColor) {
		RGB rgb = new RGB(uColor.getRed(), uColor.getGreen(), uColor.getBlue());
		return rgb;
	}

	private static Color getSWTColor(UColor uColor) {
		return new Color(null, uColor.getRed(), uColor.getGreen(), uColor.getBlue());
	}

	private static void buildReferenceOption(Composite parent, final ReferenceOption option) {
	}

	private static void buildStringAttributeOption(Composite parent, StringAttributeOption option) {
	}

	private static void newLabel(Composite parent, String text) {
		new Label(parent, SWT.LEFT).setText(text);
	}

	/**
	 * @param parent the SWT parent object
	 * @return a new SWT Composite with two columns
	 */
	public static Composite createContainer(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout gLayout = new GridLayout();
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		container.setLayout(gLayout);
		container.setLayoutData(gData);
		gLayout.numColumns = 2;

		return container;
	}

	/**
	 * @param parent the SWT parent object
	 * @param labelName the label for the checkbox
	 * @param selected the default value of the checkbox
	 * @return the SWT button (checkbox)
	 */
	public static Button createBooleanCheckbox(Composite parent, String labelName, boolean selected) {
		Button button = new Button(parent, SWT.CHECK);
		new Label(parent, SWT.LEFT).setText(labelName);

		return button;
	}

	/**
	 * @param parent the SWT parent object
	 * @param labelName the label for the combo box
	 * @param values the values of the enumerator
	 * @param defaultValue the default value of the option
	 * @return a new SWT combo box
	 */
	public static Combo createComboBox(Composite parent, String labelName, List<? extends Enumerator> values,
		int defaultValue) {

		new Label(parent, SWT.LEFT).setText(labelName);
		Combo combo = new Combo(parent, SWT.READ_ONLY);

		for (Enumerator value : values) {
			combo.add(value.getLiteral(), value.getValue());
		}
		combo.select(defaultValue);

		return combo;
	}
}

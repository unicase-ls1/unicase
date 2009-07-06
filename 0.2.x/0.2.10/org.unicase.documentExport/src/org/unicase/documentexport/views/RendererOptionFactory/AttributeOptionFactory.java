package org.unicase.documentexport.views.RendererOptionFactory;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.documentexport.renderers.options.AttributeOption;
import org.unicase.documentexport.renderers.options.BooleanAttributeOption;
import org.unicase.documentexport.renderers.options.BooleanOption;
import org.unicase.documentexport.renderers.options.LayoutOptions;
import org.unicase.documentexport.renderers.options.ListOption;
import org.unicase.documentexport.renderers.options.MultiReferenceAttributeOption;
import org.unicase.documentexport.renderers.options.ReferenceOption;
import org.unicase.documentexport.renderers.options.RendererOption;
import org.unicase.documentexport.renderers.options.SingleReferenceAttributeOption;
import org.unicase.documentexport.renderers.options.StringAttributeOption;
import org.unicase.documentexport.renderers.options.TextOption;

public class AttributeOptionFactory  {

	private Composite parent;
	
	/**
	 * 
	 * @param parent
	 * @param option
	 */
	public void buildOptionsFormular(
			Composite parent,
			RendererOption option
		) {
		this.parent = parent;
		
		if (option instanceof AttributeOption)
			buildAttributeOption((AttributeOption)option);
		else if (option instanceof ReferenceOption) 
			buildReferenceOption((ReferenceOption)option);
		else if (option instanceof ListOption)
			buildListOption((ListOption)option);
		else if (option instanceof LayoutOptions)
			buildLayoutOptions((LayoutOptions)option);
		else if (option instanceof TextOption)
			buildTextOption((TextOption)option);
		else if (option instanceof BooleanOption)
			buildBooleanOption((BooleanOption)option);
		else
			return;
	}

	private void buildListOption(final ListOption option) {
		newLabel("List style");
		Combo listStyle = new Combo(parent, SWT.READ_ONLY);
		listStyle.add("bulleted", ListOption.BULLETED);
		listStyle.add("just new lines", ListOption.JUST_NEW_LINES);
		listStyle.add("list with seperator", ListOption.SPERERATED_LIST);
		listStyle.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.listStyle = ((Combo)e.widget).getSelectionIndex();
			}
		});
		listStyle.select(option.listStyle);
		
		
		newLabel("List seperator");
		Text seperator = new Text(parent, SWT.BORDER);
		seperator.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		seperator.addModifyListener(new ModifyListener()  {
			public void modifyText(ModifyEvent e) {
				option.seperator = ((Text)e.widget).getText();
			}
		});
		seperator.setText(option.seperator);	
		
		
		newLabel("Bullet");
		Text bullet = new Text(parent, SWT.BORDER);
		bullet.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		bullet.addModifyListener(new ModifyListener()  {
			public void modifyText(ModifyEvent e) {
				option.bullet = ((Text)e.widget).getText();
			}
		});
		bullet.setText(option.bullet);	
	}

	private void buildAttributeOption(final AttributeOption option) {
		new Label(parent, SWT.LEFT).setText("overwrite");
		Button button2 = new Button(parent, SWT.CHECK);
		button2.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.overwrite = ((Button)e.widget).getSelection();
			}
		});
		button2.setSelection(option.overwrite);
		
		new Label(parent, SWT.LEFT).setText("hide");
		Button button = new Button(parent, SWT.CHECK);
		button.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.hide = ((Button)e.widget).getSelection();
			}
		});
		button.setSelection(option.hide);
		
		
		if (option instanceof StringAttributeOption) {
			buildStringAttributeOption((StringAttributeOption)option);
		} else if (option instanceof BooleanAttributeOption) {
			buildBooleanAttributeOption((BooleanAttributeOption)option);
		} else if (option instanceof MultiReferenceAttributeOption) {
			buildMultiReferenceAttributeOption((MultiReferenceAttributeOption)option);
		} else if (option instanceof SingleReferenceAttributeOption) {
			buildSingleReferenceAttributeOption((SingleReferenceAttributeOption)option);
		}
	}

	private void buildMultiReferenceAttributeOption( 
			final MultiReferenceAttributeOption option) {
		buildReferenceOption(option.referenceOption);
		
		buildListOption(option.listOption);
	}

	private void buildSingleReferenceAttributeOption(
			SingleReferenceAttributeOption option) {
		buildReferenceOption(option.referenceOption);
	}

	private void buildBooleanAttributeOption(BooleanAttributeOption option) {
		buildBooleanOption(option.booleanOption);
	}

	private void buildBooleanOption(final BooleanOption option) {

		newLabel("'True' Color");
		Button colorButtonTrue = new Button(parent, SWT.PUSH);
		final ColorDialog colorTrue = new ColorDialog(parent.getShell());
	
		colorButtonTrue.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				RGB rgb = colorTrue.open();
				if (rgb != null) {
					Color trueColor = new Color(parent.getShell().getDisplay(), rgb);
					option.trueColor = new java.awt.Color(
							trueColor.getRed(), 
							trueColor.getBlue(), 
							trueColor.getGreen()
						);
				}
			}
		});

		newLabel("'False' Color");
		Button colorButtonFalse = new Button(parent, SWT.PUSH);
		final ColorDialog colorFalse = new ColorDialog(parent.getShell());
	
		colorButtonFalse.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				RGB rgb = colorFalse.open();
				if (rgb != null) {
					Color falseColor = new Color(parent.getShell().getDisplay(), rgb);
					option.falseColor = new java.awt.Color(
							falseColor.getRed(), 
							falseColor.getBlue(), 
							falseColor.getGreen()
						);
				}
			}
		});
		
		
		newLabel("display style");
		Combo style = new Combo(parent, SWT.READ_ONLY);
		style.add("checkbox", BooleanOption.CHECKBOX);
		style.add("yes / no", BooleanOption.YES_NO);
		style.add("numeric", BooleanOption.NUMBER);
		style.add("true / false", BooleanOption.TRUE_FALSE);
		style.select(option.style);
	}

	
	private void buildTextOption(final TextOption option) {
		newLabel("bold");
		Button bold = new Button(parent, SWT.CHECK);
		bold.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.bold = ((Button)e.widget).getSelection();
			}
		});
		bold.setSelection(option.bold);
		
		newLabel("underline");
		Button underline = new Button(parent, SWT.CHECK);
		underline.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.underline = ((Button)e.widget).getSelection();
			}
		});
		underline.setSelection(option.underline);
		
		newLabel("italics");
		Button italics = new Button(parent, SWT.CHECK);
		italics.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.italics = ((Button)e.widget).getSelection();
			}
		});
		italics.setSelection(option.underline);
		
		newLabel("strikethrough");
		Button strikethrough = new Button(parent, SWT.CHECK);
		strikethrough.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.strikethrough = ((Button)e.widget).getSelection();
			}
		});
		strikethrough.setSelection(option.strikethrough);
		
		newLabel("Font family");
		Combo font = new Combo(parent, SWT.READ_ONLY);
		font.add("Arial", TextOption.ARIAL);
		font.add("Times new Roman", TextOption.TIMES_NEW_ROMAN);
		font.add("Verdana", TextOption.VERDANA);
		font.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.fontFamily = ((Combo)e.widget).getSelectionIndex();
			}
		});
		font.select(option.fontFamily);

		
		newLabel("Font size");
		Combo fontSize = new Combo(parent, SWT.READ_ONLY);
		int i2 = 0;
		for (int i = 10; i <= 36; i++) {
			i2++;
			fontSize.add(String.valueOf(i));
		}

		fontSize.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.size = ((Combo)e.widget).getSelectionIndex() + 10;
			}
		});
		fontSize.select(option.size - 10);
	}
	

	
	private void buildLayoutOptions(final LayoutOptions option) {
		newLabel("Coverpage");
		Text coverpage = new Text(parent, SWT.MULTI | SWT.BORDER);
		coverpage.setLayoutData((new GridData(GridData.FILL_HORIZONTAL)));
		coverpage.addModifyListener(new ModifyListener(){
			public void modifyText(ModifyEvent e) {
				option.coverPage = ((Text)e.widget).getText();
			}
		});
		coverpage.setText(option.coverPage);
		
		
		buildTextOption(option.coverTextOption);
		
		newLabel("Header");
		Text header = new Text(parent, SWT.MULTI | SWT.BORDER);
		header.setLayoutData((new GridData(GridData.FILL_HORIZONTAL)));
		header.addModifyListener(new ModifyListener(){
			public void modifyText(ModifyEvent e) {
				option.header = ((Text)e.widget).getText();
			}
		});
		header.setText(option.header);

		newLabel("footer");
		Text footer = new Text(parent, SWT.MULTI | SWT.BORDER);
		footer.setLayoutData((new GridData(GridData.FILL_HORIZONTAL)));
		footer.addModifyListener(new ModifyListener(){
			public void modifyText(ModifyEvent e) {
				option.footer = ((Text)e.widget).getText();
			}
		});
		footer.setText(option.footer);
		
		
		newLabel("Page numbering style");
		Combo pageNumberingStyle = new Combo(parent, SWT.READ_ONLY);
		pageNumberingStyle.add("<page>", LayoutOptions.ONLY_PAGE);
		pageNumberingStyle.add("<page>/<lastpage>", LayoutOptions.PAGE_OF_MAX_PAGE);
		pageNumberingStyle.add("none", LayoutOptions.NONE);
		pageNumberingStyle.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.pageNumberingStyle = ((Combo)e.widget).getSelectionIndex();
			}
		});

		
		newLabel("hide empty attributes");
		Button hideEmptyAttributes = new Button(parent, SWT.CHECK);
		hideEmptyAttributes.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.hideEmptyAttributes = ((Button)e.widget).getSelection();
			}
		});
		hideEmptyAttributes.setSelection(option.hideEmptyAttributes);
		
		newLabel("hide incomingDocumentReferences");
		Button hideIncomingDocumentReferences = new Button(parent, SWT.CHECK);
		hideIncomingDocumentReferences.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.hideIncomingDocumentReferences = ((Button)e.widget).getSelection();
			}
		});
		hideIncomingDocumentReferences.setSelection(option.hideIncomingDocumentReferences);
		
		
		newLabel("hide annotations");
		Button hideAnnotations = new Button(parent, SWT.CHECK);
		hideAnnotations.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.hideAnnotations = ((Button)e.widget).getSelection();
			}
		});
		hideAnnotations.setSelection(option.hideEmptyAttributes);
		
		
		newLabel("hide attachements");
		Button hideAttachements = new Button(parent, SWT.CHECK);
		hideAttachements.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.hideAttachments = ((Button)e.widget).getSelection();
			}
		});
		hideAttachements.setSelection(option.hideEmptyAttributes);
		
		
		newLabel("always show description");
		Button showDescr = new Button(parent, SWT.CHECK);
		showDescr.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.alwaysShowDescription = ((Button)e.widget).getSelection();
			}
		});
		showDescr.setSelection(option.alwaysShowDescription);
		
		newLabel("default Text Options");
		//parent is GridData with 2 columns
		new Label(parent, SWT.NONE);
		buildTextOption(option.defaultTextOption);
		
		
		newLabel("section Text Option");
		//parent is GridData with 2 columns
		new Label(parent, SWT.NONE);
		buildTextOption(option.sectionTextOption);
	}

	
	private void buildReferenceOption(final ReferenceOption option) {
		buildTextOption(option.textOption);
		
		newLabel("contained");
		Button contained = new Button(parent, SWT.CHECK);
		contained.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.contained = ((Button)e.widget).getSelection();
			}
		});
		contained.setSelection(option.contained);
	}

	
	private void buildStringAttributeOption(StringAttributeOption option) {
		buildTextOption(option.textOption);	
	}
	

	
	
	private void newLabel(String text) {
		new Label(parent, SWT.LEFT).setText(text);
	}

}

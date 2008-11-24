package org.unicase.docExport.views;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;
import org.unicase.docExport.exportModel.renderers.options.FontFamily;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.ListOption;
import org.unicase.docExport.exportModel.renderers.options.ListStyle;
import org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.PageNumberingStyle;
import org.unicase.docExport.exportModel.renderers.options.ReferenceOption;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;
import org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.StringAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public class AttributeOptionFactory  {

	private Composite parent;
	
	/**
	 * 
	 * @param parent the SWT parent where the formular shall be created
	 * @param option the RenderOption an formular shall be created of
	 */
	public void buildOptionsFormular(
			Composite parent,
			RendererOption option
		) {

		this.parent = parent;
		
		if (option instanceof AttributeOption) {
			buildAttributeOption((AttributeOption)option);
		}
		else if (option instanceof ReferenceOption) {
			buildReferenceOption((ReferenceOption)option);
		}
		else if (option instanceof ListOption) {
			buildListOption((ListOption)option);
		}
		else if (option instanceof LayoutOptions) {
			buildLayoutOptions((LayoutOptions)option);
		}
		else if (option instanceof TextOption) {
			buildTextOption((TextOption)option, option.getName());
		}
		else {
			return;
		}
	}

	private void buildListOption(final ListOption option) {
		newLabel(parent, "List style");
		Combo listStyle = new Combo(parent, SWT.READ_ONLY);
		for (ListStyle style : ListStyle.VALUES) {
			listStyle.add(style.getLiteral(), style.getValue());
		}
		listStyle.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.setListStyle(ListStyle.get(((Combo)e.widget).getSelectionIndex()));
			}
		}); 
		listStyle.select(option.getListStyle().getValue());
	}

	private void buildAttributeOption(final AttributeOption option) {
		
		
		new Label(parent, SWT.LEFT).setText("overwrite");
		Button button2 = new Button(parent, SWT.CHECK);
		button2.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.setOverwriteGlobalOption(((Button)e.widget).getSelection());
			}
		});
		button2.setSelection(option.isOverwriteGlobalOption());
		
		new Label(parent, SWT.LEFT).setText("hide");
		Button button = new Button(parent, SWT.CHECK);
		button.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.setHide(((Button)e.widget).getSelection());
			}
		});
		button.setSelection(option.isHide());
		
		
		if (option instanceof StringAttributeOption) {
			buildStringAttributeOption((StringAttributeOption)option);
		}  else if (option instanceof MultiReferenceAttributeOption) {
			buildMultiReferenceAttributeOption((MultiReferenceAttributeOption)option);
		} else if (option instanceof SingleReferenceAttributeOption) {
			buildSingleReferenceAttributeOption((SingleReferenceAttributeOption)option);
		}
	}

	private void buildMultiReferenceAttributeOption( 
			final MultiReferenceAttributeOption option) {
		buildReferenceOption(option.getReferenceOption(true));
		
		newLabel(parent, "contained");
		Button contained = new Button(parent, SWT.CHECK);
		contained.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.setContained(((Button)e.widget).getSelection());
			}
		});
		contained.setSelection(option.isContained());
		
		buildListOption(option.getListOption(true));
	}

	private void buildSingleReferenceAttributeOption(
			final SingleReferenceAttributeOption option) {
		buildReferenceOption(option.getReferenceOption(true));
		
		newLabel(parent, "contained");
		Button contained = new Button(parent, SWT.CHECK);
		contained.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.setContained(((Button)e.widget).getSelection());
			}
		});
		contained.setSelection(option.isContained());
	}


//	private void buildBooleanOption(final BooleanOption option) {
//
//		newLabel("'True' Color");
//		Button colorButtonTrue = new Button(parent, SWT.PUSH);
//		final ColorDialog colorTrue = new ColorDialog(parent.getShell());
//	
//		colorButtonTrue.addSelectionListener(new SelectionListener() {
//			public void widgetDefaultSelected(SelectionEvent e) {}
//
//			public void widgetSelected(SelectionEvent e) {
//				RGB rgb = colorTrue.open();
//				if (rgb != null) {
//					Color trueColor = new Color(parent.getShell().getDisplay(), rgb);
//					option.setTrueColor(new java.awt.Color(
//							trueColor.getRed(), 
//							trueColor.getBlue(), 
//							trueColor.getGreen()
//						));
//				}
//			}
//		});
//
//		newLabel("'False' Color");
//		Button colorButtonFalse = new Button(parent, SWT.PUSH);
//		final ColorDialog colorFalse = new ColorDialog(parent.getShell());
//	
//		colorButtonFalse.addSelectionListener(new SelectionListener() {
//			public void widgetDefaultSelected(SelectionEvent e) {}
//
//			public void widgetSelected(SelectionEvent e) {
//				RGB rgb = colorFalse.open();
//				if (rgb != null) {
//					Color falseColor = new Color(parent.getShell().getDisplay(), rgb);
//					option.setFalseColor(new java.awt.Color(
//							falseColor.getRed(), 
//							falseColor.getBlue(), 
//							falseColor.getGreen()
//						));
//				}
//			}
//		});
//		
//		
//		newLabel("display style");
//		Combo style = new Combo(parent, SWT.READ_ONLY);
//		style.add("checkbox", BooleanOption.CHECKBOX);
//		style.add("yes / no", BooleanOption.YES_NO);
//		style.add("numeric", BooleanOption.NUMBER);
//		style.add("true / false", BooleanOption.TRUE_FALSE);
//		style.select(option.getStyle());
//	}

	
	private void buildTextOption(final TextOption option, String title) {
		
		Group group = new Group(parent, SWT.BORDER);
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 2;
		group.setLayout(gLayout);
		GridData gData = new GridData(SWT.FILL, SWT.FILL, true, true);
		group.setLayoutData(gData);
		group.setText(title);
		
		if (option == null) {
			WorkspaceUtil.log(
					"A TextOption is null",
					new Exception(),
					IStatus.ERROR
				);
				return;
		}
		newLabel(group, "bold");
		Button bold = new Button(group, SWT.CHECK);
		bold.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.setBold(((Button)e.widget).getSelection());
			}
		});
		bold.setSelection(option.isBold());
		
		newLabel(group, "underline");
		Button underline = new Button(group, SWT.CHECK);
		underline.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.setUnderline(((Button)e.widget).getSelection());
			}
		});
		underline.setSelection(option.isUnderline());
			
		
		newLabel(group, "Font family");
		Combo font = new Combo(group, SWT.READ_ONLY);
		for (FontFamily family : FontFamily.VALUES) {
			font.add(family.getLiteral(), family.getValue());
		}
		font.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.setFontFamily(FontFamily.get(((Combo)e.widget).getSelectionIndex()));
			}
		});
		font.select(option.getFontFamily().getValue());

		
		newLabel(group, "Font size");
		Combo fontSize = new Combo(group, SWT.READ_ONLY);
		int i2 = 0;
		for (int i = 8; i <= 36; i++) {
			i2++;
			fontSize.add(String.valueOf(i));
		}

		fontSize.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.setFontSize(((Combo)e.widget).getSelectionIndex() + 8);
			}
		});
		fontSize.select(option.getFontSize() - 8);
	}
	

	
	private void buildLayoutOptions(final LayoutOptions option) {
		Text coverpage = new Text(parent, SWT.MULTI | SWT.BORDER);
		coverpage.setLayoutData((new GridData(GridData.FILL_HORIZONTAL)));
		coverpage.addModifyListener(new ModifyListener(){
			public void modifyText(ModifyEvent e) {
				option.setCoverText((((Text)e.widget).getText()));
			}
		});
		coverpage.setText(option.getCoverText());
		
		
		buildTextOption(option.getCoverTextTextOption(), "cover page");
		
		newLabel(parent, "Page numbering style");
		Combo pageNumberingStyle = new Combo(parent, SWT.READ_ONLY);
		for (PageNumberingStyle style : PageNumberingStyle.VALUES) {
			pageNumberingStyle.add(style.getLiteral(), style.getValue());
		}
		pageNumberingStyle.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option. setPageNumberingStyle(PageNumberingStyle.get(((Combo)e.widget).getSelectionIndex()));
			}
		});
		
		newLabel(parent, "hide incomingDocumentReferences");
		Button hideIncomingDocumentReferences = new Button(parent, SWT.CHECK);
		hideIncomingDocumentReferences.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.setHideIncomingDocumentReferences(((Button)e.widget).getSelection());
			}
		});
		hideIncomingDocumentReferences.setSelection(option.isHideIncomingDocumentReferences());
		
		
		newLabel(parent, "hide annotations");
		Button hideAnnotations = new Button(parent, SWT.CHECK);
		hideAnnotations.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.setHideAnnotations(((Button)e.widget).getSelection());
			}
		});
		hideAnnotations.setSelection(option.isHideAnnotations());
		
		newLabel(parent, "hide section image");
		Button hideSectionImage = new Button(parent, SWT.CHECK);
		hideSectionImage.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.setHideModelElementImages(((Button)e.widget).getSelection());
			}
		});
		hideSectionImage.setSelection(option.isHideModelElementImages());
		
		newLabel(parent, "hide attachements");
		Button hideAttachements = new Button(parent, SWT.CHECK);
		hideAttachements.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				option.setHideAttachments(((Button)e.widget).getSelection());
			}
		});
		hideAttachements.setSelection(option.isHideAttachments());

		

		buildTextOption(option.getDefaultTextOption(), "default text option");
		
		

		buildTextOption(option.getSectionTextOption(), "section text option");
		

		buildTextOption(option.getModelElementTextOption(), "ModelElement text option");
	}

	
	private void buildReferenceOption(final ReferenceOption option) {
		buildTextOption(option.getTextOption(), "");
	}

	
	private void buildStringAttributeOption(StringAttributeOption option) {
		buildTextOption(option.getTextOption(true), "");	
	}
	

	
	
	private void newLabel(Composite parent, String text) {
		new Label(parent, SWT.LEFT).setText(text);
	}

}

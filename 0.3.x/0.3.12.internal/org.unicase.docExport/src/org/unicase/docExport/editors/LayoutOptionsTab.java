/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.core.runtime.Path;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.options.AppendixStyle;
import org.unicase.docExport.exportModel.renderers.options.HeaderStyle;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.PageCitationStyle;
import org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle;

/**
 * @author Sebastian Hoecht
 */
public class LayoutOptionsTab extends TemplateEditorTab {

	private CTabFolder subTabFolder;

	private Composite generalOptions;
	private Composite coverPageOptions;
	private Composite sectionOptions;
	private Composite headerAndFooterOptions;
	private Composite logoOptions;

	private LayoutOptions layoutOptions;

	/**
	 * @param parent the parent SWT composite
	 * @param style the SWT style
	 * @param tabFolder the tabItem is contained
	 * @param template the Template containing some LayoutOptions
	 */
	public LayoutOptionsTab(Composite parent, int style, CTabFolder tabFolder, Template template) {
		super(parent, style, tabFolder, template);

		this.layoutOptions = template.getLayoutOptions();

		setContainerTab(new Composite(parent, SWT.FILL));
		GridLayout gLayout = new GridLayout();
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		getContainerTab().setLayout(gLayout);
		getContainerTab().setLayoutData(gData);

		subTabFolder = new CTabFolder(getContainerTab(), SWT.NONE | SWT.BORDER);
		GridLayout layout = new GridLayout();
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.grabExcessHorizontalSpace = true;
		subTabFolder.setLayout(layout);
		subTabFolder.setLayoutData(layoutData);

		generalOptions = createTab("General");
		coverPageOptions = createTab("Coverpage");
		sectionOptions = createTab("Sections");
		headerAndFooterOptions = createTab("Header & Footer");
		logoOptions = createTab("Logo");

		buildGeneralOptions(generalOptions);
		buildCoverPageOptions(coverPageOptions);
		buildSectionOptions(sectionOptions);
		buildHeaderAndFooterOptions(headerAndFooterOptions);
		buildLogoOptions(logoOptions, template);

		// factory.buildOptionsFormular(generalOptions, template.getLayoutOptions());

		generalOptions.setFocus();

		layoutAndPack();
	}

	private void buildHeaderAndFooterOptions(Composite parent) {

		new Label(parent, SWT.NONE).setText("Header text");
		Text header = new Text(parent, SWT.MULTI | SWT.BORDER);
		header.setLayoutData((new GridData(GridData.FILL_HORIZONTAL)));
		header.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				layoutOptions.setHeaderText((((Text) e.widget).getText()));
			}
		});
		header.setText(layoutOptions.getHeaderText());

		new Label(parent, SWT.NONE).setText("Footer text");
		Text footer = new Text(parent, SWT.MULTI | SWT.BORDER);
		footer.setLayoutData((new GridData(GridData.FILL_HORIZONTAL)));
		footer.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				layoutOptions.setFooterText((((Text) e.widget).getText()));
			}
		});
		footer.setText(layoutOptions.getFooterText());

		Composite container = AttributeOptionFactory.createContainer(parent);

		Button button = AttributeOptionFactory.createBooleanCheckbox(container, "footer: show document title",
			layoutOptions.isFooterShowDocumentTitle());
		button.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				layoutOptions.setFooterShowDocumentTitle(((Button) e.widget).getSelection());
			}
		});
		button.setSelection(layoutOptions.isFooterShowDocumentTitle());

		Combo headerStyle = AttributeOptionFactory.createComboBox(container, "Header style", HeaderStyle.VALUES,
			layoutOptions.getHeaderStyle().getValue());
		headerStyle.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				layoutOptions.setHeaderStyle(HeaderStyle.get(((Combo) e.widget).getSelectionIndex()));
			}
		});
		headerStyle.select(layoutOptions.getHeaderStyle().getValue());

		Combo pageCitationStyle = AttributeOptionFactory.createComboBox(container, "Page numbering",
			PageCitationStyle.VALUES, layoutOptions.getPageCitationStyle().getValue());
		pageCitationStyle.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				layoutOptions.setPageCitationStyle(PageCitationStyle.get(((Combo) e.widget).getSelectionIndex()));
			}
		});
		pageCitationStyle.select(layoutOptions.getPageCitationStyle().getValue());

		AttributeOptionFactory.buildTextOption(parent, layoutOptions.getHeaderTextOption(), "Header text option");
		AttributeOptionFactory.buildTextOption(parent, layoutOptions.getFooterTextOption(), "Footer text option");
	}

	private void buildGeneralOptions(Composite parent) {
		Composite container = AttributeOptionFactory.createContainer(parent);

		Combo appendix = AttributeOptionFactory.createComboBox(container, "Appendix", AppendixStyle.VALUES,
			layoutOptions.getAppendixStyle().getValue());
		appendix.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				layoutOptions.setAppendixStyle(AppendixStyle.get(((Combo) e.widget).getSelectionIndex()));
			}
		});
		appendix.select(layoutOptions.getAppendixStyle().getValue());

		Button hideAnnotations = AttributeOptionFactory.createBooleanCheckbox(container, "hide annotations",
			layoutOptions.isHideAnnotations());
		hideAnnotations.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				layoutOptions.setHideAnnotations(((Button) e.widget).getSelection());
			}
		});
		hideAnnotations.setSelection(layoutOptions.isHideAnnotations());

		Button hideAttachments = AttributeOptionFactory.createBooleanCheckbox(container, "hide attachments",
			layoutOptions.isHideAttachments());
		hideAttachments.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				layoutOptions.setHideAttachments(((Button) e.widget).getSelection());
			}
		});
		hideAttachments.setSelection(layoutOptions.isHideAttachments());

		Button hideReferences = AttributeOptionFactory.createBooleanCheckbox(container,
			"hide incoming document references", layoutOptions.isHideIncomingDocumentReferences());
		hideReferences.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				layoutOptions.setHideIncomingDocumentReferences(((Button) e.widget).getSelection());
			}
		});
		hideReferences.setSelection(layoutOptions.isHideIncomingDocumentReferences());

		Button showModelElementType = AttributeOptionFactory.createBooleanCheckbox(container,
			"show Model Element type", layoutOptions.isHideIncomingDocumentReferences());
		showModelElementType.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				layoutOptions.setShowModelElementTypeInSectionTitle(((Button) e.widget).getSelection());
			}
		});
		showModelElementType.setSelection(layoutOptions.isShowModelElementTypeInSectionTitle());

		AttributeOptionFactory.buildTextOption(parent, layoutOptions.getDefaultTextOption(), "Default text option");
	}

	private void buildCoverPageOptions(Composite parent) {
		Composite container = AttributeOptionFactory.createContainer(parent);

		Button hideTOC = AttributeOptionFactory.createBooleanCheckbox(container, "hide table of contents",
			layoutOptions.isHideTableOfContents());
		hideTOC.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				layoutOptions.setHideTableOfContents(((Button) e.widget).getSelection());
			}
		});
		hideTOC.setSelection(layoutOptions.isHideTableOfContents());

		Button hideHeaderAndFooter = AttributeOptionFactory.createBooleanCheckbox(container, "hide header and footer",
			layoutOptions.isHideHeaderAndFooterOnCoverPage());
		hideHeaderAndFooter.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				layoutOptions.setHideHeaderAndFooterOnCoverPage(((Button) e.widget).getSelection());
			}
		});
		hideHeaderAndFooter.setSelection(layoutOptions.isHideHeaderAndFooterOnCoverPage());

		Button showLogo = AttributeOptionFactory.createBooleanCheckbox(container, "show logo", layoutOptions
			.isLogoOnCoverPage());
		showLogo.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				layoutOptions.setLogoOnCoverPage(((Button) e.widget).getSelection());
			}
		});
		showLogo.setSelection(layoutOptions.isLogoOnCoverPage());

		AttributeOptionFactory.buildTextOption(parent, layoutOptions.getDocumentTitleTextOption(), "Document title");
		AttributeOptionFactory.buildTextOption(parent, layoutOptions.getTableOfContentsTextOption(),
			"Table of contents");
	}

	private void buildLogoOptions(Composite parent, final Template template) {
		((GridLayout) logoOptions.getLayout()).numColumns = 2;
		Button selectImage = new Button(logoOptions, SWT.PUSH);
		selectImage.setText("select logo");

		final Browser browser = new Browser(logoOptions, SWT.NONE);
		browser.setSize(400, 400);

		if (layoutOptions.getLogoImage() != null && !layoutOptions.getLogoImage().equals("")) {
			browser.setText("<img src=\"" + TemplateRegistry.TEMPLATE_IMAGE_FOLDER + layoutOptions.getLogoImage()
				+ "\" />");
		}

		selectImage.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), SWT.OPEN);
				dialog.setText("select a logo image");
				dialog.setFilterExtensions(new String[] { "*.*", "*.jpg", "*.gif", "*.png", "*.svg" });
				String image = dialog.open();
				if (image != null) {
					Path imagePath = new Path(image);
					File imageFile = new File(image);
					File targetFile = new File(TemplateRegistry.TEMPLATE_IMAGE_FOLDER + template.getName() + "."
						+ imagePath.getFileExtension());
					File imageFolder = new File(TemplateRegistry.TEMPLATE_IMAGE_FOLDER);
					imageFolder.mkdirs();
					copyFile(imageFile, targetFile);
					layoutOptions.setLogoImage(template.getName() + "." + imagePath.getFileExtension());

					browser.setText("<img src=\"" + TemplateRegistry.TEMPLATE_IMAGE_FOLDER
						+ layoutOptions.getLogoImage() + "\" />");
				}
			}
		});

		new Label(logoOptions, SWT.NONE).setText("width");
		Text width = new Text(logoOptions, SWT.BORDER);
		width.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		new Label(logoOptions, SWT.None).setText("height");
		Text height = new Text(logoOptions, SWT.BORDER);
		height.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		width.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				template.getLayoutOptions().setLogoWidth(Integer.valueOf(((Text) e.widget).getText()));
			}
		});

		height.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				template.getLayoutOptions().setLogoHeight(Integer.parseInt(((Text) e.widget).getText()));
			}
		});
		width.setText(String.valueOf(template.getLayoutOptions().getLogoWidth()));
		height.setText(String.valueOf(template.getLayoutOptions().getLogoHeight()));
		width.setSize(width.computeSize(100, SWT.DEFAULT));
		width.getParent().pack(true);
		width.getParent().layout(true, true);

		layoutAndPack();
	}

	private void buildSectionOptions(Composite parent) {
		Composite container = AttributeOptionFactory.createContainer(sectionOptions);

		Combo sectionStyle = AttributeOptionFactory.createComboBox(container, "section style",
			SectionNumberingStyle.VALUES, layoutOptions.getSectionOption().getSectionNumberingStyle().getValue());

		sectionStyle.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				layoutOptions.getSectionOption().setSectionNumberingStyle(
					SectionNumberingStyle.get(((Combo) e.widget).getSelectionIndex()));
			}
		});
		sectionStyle.select(layoutOptions.getSectionOption().getSectionNumberingStyle().getValue());

		new Label(container, SWT.NONE).setText("font size step");
		Combo fontSizeStep = new Combo(container, SWT.READ_ONLY);
		for (int i = 0; i < 5; i++) {
			fontSizeStep.add(String.valueOf(i), i);
		}
		fontSizeStep.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				layoutOptions.setSectionFontSizeDecreaseStep(((Combo) e.widget).getSelectionIndex());
			}
		});
		fontSizeStep.select(layoutOptions.getSectionFontSizeDecreaseStep());

		AttributeOptionFactory.buildTextOption(parent, layoutOptions.getSectionTextOption(), "Section text options");
		AttributeOptionFactory.buildTextOption(parent, layoutOptions.getModelElementTextOption(),
			"Model Element text options");

	}

	private Composite createTab(String text) {
		CTabItem tabItem1 = new CTabItem(subTabFolder, SWT.BOTTOM);
		tabItem1.setText(text);
		Composite composite = new Composite(subTabFolder, SWT.FILL);
		GridLayout layout1 = new GridLayout();
		GridData data1 = new GridData(GridData.FILL_HORIZONTAL);
		data1.grabExcessHorizontalSpace = true;
		composite.setLayout(layout1);
		composite.setLayoutData(data1);
		tabItem1.setControl(composite);

		return composite;
	}

	/**
	 * Java File handling is bad...
	 * 
	 * @param in File which shall be copied
	 * @param out target file
	 */
	public static void copyFile(File in, File out) {
		try {
			FileInputStream fis = new FileInputStream(in);
			FileOutputStream fos = new FileOutputStream(out);
			try {
				byte[] buf = new byte[1024];
				int i = 0;
				while ((i = fis.read(buf)) != -1) {
					fos.write(buf, 0, i);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fis.close();
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

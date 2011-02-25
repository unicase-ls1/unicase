/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors.tabItems;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.docExport.editors.TemplateEditor;
import org.unicase.docExport.editors.TemplateEditorTabItem;
import org.unicase.docExport.editors.options.TOptionHelper;
import org.unicase.docExport.editors.options.TTextoption;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.options.HeaderStyle;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.PageCitationStyle;

/**
 * A TemplateEditor TabItem containing some SWT Elements for editing the header and footer options of a template.
 * 
 * @author Sebastian Hoecht
 */
public class LayoutOptionsHeaderAndFooterTabItem extends TemplateEditorTabItem {

	/**
	 * @param parent SWT Composite parent
	 * @param template the Template containing the options
	 * @param editor the TemplateEditor
	 */
	public LayoutOptionsHeaderAndFooterTabItem(CTabFolder parent, Template template, final TemplateEditor editor) {
		super(parent, template, editor);

		setText("Header and footer");

		final LayoutOptions layoutOptions = template.getLayoutOptions();

		new Label(getContainer(), SWT.NONE).setText("Header text");
		Text header = new Text(getContainer(), SWT.MULTI | SWT.BORDER);
		header.setLayoutData((new GridData(GridData.FILL_HORIZONTAL)));
		header.setLayoutData((new GridData(GridData.FILL_HORIZONTAL)));
		header.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				layoutOptions.setHeaderText((((Text) e.widget).getText()));
				editor.testDirty();
			}
		});
		header.setText(layoutOptions.getHeaderText());

		new Label(getContainer(), SWT.NONE).setText("Footer text");
		Text footer = new Text(getContainer(), SWT.MULTI | SWT.BORDER);
		footer.setLayoutData((new GridData(GridData.FILL_HORIZONTAL)));
		footer.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				layoutOptions.setFooterText((((Text) e.widget).getText()));
				editor.testDirty();
			}
		});
		footer.setText(layoutOptions.getFooterText());

		Composite container = createTwoColumnComposite();

		Button button = TOptionHelper.createBooleanCheckbox(container, "Show document title in the footer",
			layoutOptions.isFooterShowDocumentTitle());
		button.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				layoutOptions.setFooterShowDocumentTitle(((Button) e.widget).getSelection());
				editor.testDirty();
			}
		});

		Combo headerStyle = TOptionHelper.createComboBox(container, "Header style", HeaderStyle.VALUES, layoutOptions
			.getHeaderStyle().getValue());
		headerStyle.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				layoutOptions.setHeaderStyle(HeaderStyle.get(((Combo) e.widget).getSelectionIndex()));
				editor.testDirty();
			}
		});

		Combo pageCitationStyle = TOptionHelper.createComboBox(container, "Page numbering", PageCitationStyle.VALUES,
			layoutOptions.getPageCitationStyle().getValue());
		pageCitationStyle.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				layoutOptions.setPageCitationStyle(PageCitationStyle.get(((Combo) e.widget).getSelectionIndex()));
				editor.testDirty();
			}
		});

		new TTextoption(getContainer(), editor, "Header text option", layoutOptions.getHeaderTextOption());
		new TTextoption(getContainer(), editor, "Footer text option", layoutOptions.getFooterTextOption());

		layoutAndPackAll();
	}

}
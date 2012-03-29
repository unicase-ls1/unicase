/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors.tabItems;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.unicase.docExport.editors.TemplateEditor;
import org.unicase.docExport.editors.TemplateEditorTabItem;
import org.unicase.docExport.editors.options.TOptionHelper;
import org.unicase.docExport.editors.options.TTextoption;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;

/**
 * A TemplateEditor TabItem containing some SWT Elements for editing the cover page options of a template.
 * 
 * @author Sebastian Hoecht
 */
public class LayoutOptionsCoverpageTabItem extends TemplateEditorTabItem {

	/**
	 * @param parent SWT Composite parent
	 * @param template the Template containing the options
	 * @param editor the TemplateEditor
	 */
	public LayoutOptionsCoverpageTabItem(CTabFolder parent, Template template, TemplateEditor editor) {
		super(parent, template, editor);

		setText("Coverpage");

		final LayoutOptions layoutOptions = template.getLayoutOptions();

		Composite container = createTwoColumnComposite();

		Button hideTOC = TOptionHelper.createBooleanCheckbox(container, "Hide table of contents", layoutOptions
			.isHideTableOfContents());
		hideTOC.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				layoutOptions.setHideTableOfContents(((Button) e.widget).getSelection());
				getEditor().testDirty();
			}
		});

		Button hideHeaderAndFooter = TOptionHelper.createBooleanCheckbox(container, "Hide header and footer",
			layoutOptions.isHideHeaderAndFooterOnCoverPage());
		hideHeaderAndFooter.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				layoutOptions.setHideHeaderAndFooterOnCoverPage(((Button) e.widget).getSelection());
				getEditor().testDirty();
			}
		});

		Button showLogo = TOptionHelper
			.createBooleanCheckbox(container, "Show logo", layoutOptions.isLogoOnCoverPage());
		showLogo.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				layoutOptions.setLogoOnCoverPage(((Button) e.widget).getSelection());
				getEditor().testDirty();
			}
		});

		new TTextoption(getContainer(), editor, "Document title", layoutOptions.getDocumentTitleTextOption());
		new TTextoption(getContainer(), editor, "Table of contents", layoutOptions.getTableOfContentsTextOption());

		layoutAndPackAll();
	}

}

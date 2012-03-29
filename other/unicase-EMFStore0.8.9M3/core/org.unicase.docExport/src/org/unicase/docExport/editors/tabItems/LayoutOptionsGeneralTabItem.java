/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors.tabItems;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.unicase.docExport.editors.TemplateEditor;
import org.unicase.docExport.editors.TemplateEditorTabItem;
import org.unicase.docExport.editors.options.TOptionHelper;
import org.unicase.docExport.editors.options.TTextoption;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.options.AppendixStyle;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;

/**
 * A TemplateEditor TabItem containing some SWT Elements for editing general layout options of a template.
 * 
 * @author Sebastian Hoecht
 */
public class LayoutOptionsGeneralTabItem extends TemplateEditorTabItem {

	/**
	 * @param parent SWT Composite parent
	 * @param template the Template containing the options
	 * @param editor the TemplateEditor
	 */
	public LayoutOptionsGeneralTabItem(CTabFolder parent, Template template, TemplateEditor editor) {
		super(parent, template, editor);

		final LayoutOptions layoutOptions = template.getLayoutOptions();

		setText("Layout");

		Composite container = createTwoColumnComposite();

		Combo appendix = TOptionHelper.createComboBox(container, "Appendix", AppendixStyle.VALUES, layoutOptions
			.getAppendixStyle().getValue());
		appendix.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				layoutOptions.setAppendixStyle(AppendixStyle.get(((Combo) e.widget).getSelectionIndex()));
				getEditor().testDirty();
			}
		});

		Button hideAnnotations = TOptionHelper.createBooleanCheckbox(container, "Hide annotations", layoutOptions
			.isHideAnnotations());
		hideAnnotations.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				layoutOptions.setHideAnnotations(((Button) e.widget).getSelection());
				getEditor().testDirty();
			}
		});

		Button hideAttachments = TOptionHelper.createBooleanCheckbox(container, "Hide attachments", layoutOptions
			.isHideAttachments());
		hideAttachments.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				layoutOptions.setHideAttachments(((Button) e.widget).getSelection());
				getEditor().testDirty();
			}
		});

		Button hideReferences = TOptionHelper.createBooleanCheckbox(container, "Hide incoming document references",
			layoutOptions.isHideIncomingDocumentReferences());
		hideReferences.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				layoutOptions.setHideIncomingDocumentReferences(((Button) e.widget).getSelection());
				getEditor().testDirty();
			}
		});

		Button showModelElementType = TOptionHelper.createBooleanCheckbox(container, "Show Model Element type",
			layoutOptions.isHideIncomingDocumentReferences());
		showModelElementType.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				layoutOptions.setShowModelElementTypeInSectionTitle(((Button) e.widget).getSelection());
				getEditor().testDirty();
			}
		});

		new TTextoption(getContainer(), editor, "Default text option", template.getLayoutOptions()
			.getDefaultTextOption());

		layoutAndPackAll();
	}

}
/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors.tabItems;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.unicase.docExport.editors.TemplateEditor;
import org.unicase.docExport.editors.TemplateEditorTabItem;
import org.unicase.docExport.editors.options.TOptionHelper;
import org.unicase.docExport.editors.options.TTextoption;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle;

/**
 * A TemplateEditor TabItem containing some SWT Elements for editing the section options of a template.
 * 
 * @author Sebastian Hoecht
 */
public class LayoutOptionsSectionTabItem extends TemplateEditorTabItem {

	/**
	 * @param parent SWT Composite parent
	 * @param template the Template containing the options
	 * @param editor the TemplateEditor
	 */
	public LayoutOptionsSectionTabItem(CTabFolder parent, Template template, TemplateEditor editor) {
		super(parent, template, editor);

		final LayoutOptions layoutOptions = template.getLayoutOptions();

		setText("Sections");

		Composite container = createTwoColumnComposite();

		Combo sectionStyle = TOptionHelper.createComboBox(container, "Section style", SectionNumberingStyle.VALUES,
			layoutOptions.getSectionOption().getSectionNumberingStyle().getValue());

		sectionStyle.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				layoutOptions.getSectionOption().setSectionNumberingStyle(
					SectionNumberingStyle.get(((Combo) e.widget).getSelectionIndex()));
				getEditor().testDirty();
			}
		});

		new Label(container, SWT.NONE).setText("Font size step");
		Combo fontSizeStep = new Combo(container, SWT.READ_ONLY);
		for (int i = 0; i < 5; i++) {
			fontSizeStep.add(String.valueOf(i), i);
		}
		fontSizeStep.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				layoutOptions.setSectionFontSizeDecreaseStep(((Combo) e.widget).getSelectionIndex());
				getEditor().testDirty();
			}
		});
		fontSizeStep.select(layoutOptions.getSectionFontSizeDecreaseStep());

		new TTextoption(getContainer(), editor, "Section text options", layoutOptions.getSectionTextOption());
		new TTextoption(getContainer(), editor, "ModelElement options", layoutOptions.getModelElementTextOption());

		layoutAndPackAll();
	}

}
/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors.options;

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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.docExport.editors.TemplateEditor;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;
import org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.StringAttributeOption;

/**
 * @author Sebastian Hoecht
 */
public class TAttributeOption extends Composite {

	/**
	 * @param parent SWT Composite parent
	 * @param option the AttributeOption of an AttributeRenderer
	 * @param editor the editor for dirty checking
	 */
	public TAttributeOption(Composite parent, final AttributeOption option, final TemplateEditor editor) {
		super(parent, SWT.NONE);

		GridLayout gLayout2 = new GridLayout();
		setLayout(gLayout2);
		GridData gData2 = new GridData(GridData.FILL_BOTH);
		setLayoutData(gData2);

		Composite container = new Composite(this, SWT.NONE);
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 2;
		container.setLayout(gLayout);
		GridData gData = new GridData(GridData.FILL_BOTH);
		container.setLayoutData(gData);

		// alternative text for the attribute
		new Label(container, SWT.LEFT).setText("Attribute text");
		Text attributeText = new Text(container, SWT.MULTI | SWT.BORDER);
		attributeText.setLayoutData((new GridData(GridData.FILL_HORIZONTAL)));
		attributeText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.setAttributeText((((Text) e.widget).getText()));
				editor.testDirty();
			}
		});
		attributeText.setText(option.getAttributeText());

		// order number for the attribute
		new Label(container, SWT.LEFT).setText("Order number");
		Combo orderNumber = new Combo(container, SWT.READ_ONLY);
		for (int i = -10; i <= 10; i++) {
			orderNumber.add(String.valueOf(i), i + 10);
		}

		orderNumber.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.setOrderNumber(((Combo) e.widget).getSelectionIndex() - 10);
				editor.testDirty();
			}
		});
		orderNumber.select(option.getOrderNumber() + 10);

		// hide attribute
		Button button2 = new Button(container, SWT.CHECK);
		button2.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				option.setHide(((Button) e.widget).getSelection());
				editor.testDirty();
			}
		});
		button2.setSelection(option.isHide());
		new Label(container, SWT.LEFT).setText("hide");

		if (option instanceof StringAttributeOption) {
			new TStringAttributeOption(this, (StringAttributeOption) option, editor);
		} else if (option instanceof MultiReferenceAttributeOption) {
			new TMultiReferenceAttributeOption(this, (MultiReferenceAttributeOption) option, editor);
		} else if (option instanceof SingleReferenceAttributeOption) {
			new TSingleReferenceAttributeOption(this, (SingleReferenceAttributeOption) option, editor);
		}
	}

}

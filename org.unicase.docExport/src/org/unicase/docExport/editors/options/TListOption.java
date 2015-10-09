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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.unicase.docExport.editors.TemplateEditor;
import org.unicase.docExport.exportModel.renderers.options.ListOption;
import org.unicase.docExport.exportModel.renderers.options.ListStyle;

/**
 * @author Sebastian Hoecht
 */
public class TListOption extends Composite {

	/**
	 * @param parent SWT Composite parent
	 * @param option a ListOption
	 * @param editor the editor for dirty checking
	 */
	public TListOption(Composite parent, final ListOption option, final TemplateEditor editor) {

		super(parent, SWT.NONE);

		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 2;
		setLayout(gLayout);
		GridData gData = new GridData(SWT.FILL, SWT.FILL, true, true);
		setLayoutData(gData);

		Combo listStyle = TOptionHelper.createComboBox(this, "List style", ListStyle.VALUES, option.getListStyle()
			.getValue());

		listStyle.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				option.setListStyle(ListStyle.get(((Combo) e.widget).getSelectionIndex()));
			}
		});
		listStyle.select(option.getListStyle().getValue());
	}

}

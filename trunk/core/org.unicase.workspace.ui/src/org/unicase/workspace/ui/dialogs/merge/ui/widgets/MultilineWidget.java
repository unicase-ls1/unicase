/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.ui.widgets;

import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.options.MergeTextOption;
import org.unicase.workspace.ui.dialogs.merge.ui.DecisionBox;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionConfig;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;

/**
 * Widget. TODO REDO
 * 
 * @author wesendon
 */
public class MultilineWidget extends Composite {

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            parent
	 * @param decisionBox
	 *            decisionBox
	 * @param option
	 *            option
	 */
	public MultilineWidget(Composite parent, final DecisionBox decisionBox,
			final ConflictOption option) {
		super(parent, SWT.NONE);
		setLayout(new TableWrapLayout());
		setBackground(parent.getBackground());

		Composite column = new Composite(this, SWT.NONE);
		column.setLayout(new TableWrapLayout());
		column.setBackground(getBackground());

		FontRegistry fontRegistry = DecisionUtil.getFontRegistry();

		Composite titleComposite = new Composite(column, SWT.NONE);
		titleComposite.setBackground(getBackground());
		titleComposite.setLayout(new FillLayout());
		titleComposite
				.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

		String title;
		switch (option.getType()) {
		case MyOperation:
			title = "My Change";
			break;
		case TheirOperation:
			title = "Change on Repository";
			break;
		case Custom:
			title = option.getOptionLabel();
			break;
		default:
			title = "";
			break;
		}

		Link titl = new Link(titleComposite, SWT.NONE);
		titl.setText(title);
		titl.setBackground(getBackground());
		titl.setFont(fontRegistry.get("titleLabel"));
		// GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING)
		// .grab(true, true).applyTo(titl);

		final Text myAttribute = new Text(column, SWT.MULTI | SWT.WRAP);
		myAttribute.setText(option.getFullOptionLabel());
		myAttribute.setBackground(getBackground());
		boolean isEditable = option.getDetailProvider().endsWith(
				DecisionConfig.EDITABLE);
		myAttribute.setEditable(isEditable);
		if (isEditable && option instanceof MergeTextOption) {
			myAttribute.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					String newText = myAttribute.getText();
					String oldText = ((MergeTextOption) option).getMergedText();
					if (newText != null && !newText.equals(oldText)) {
						((MergeTextOption) option).setMergedText(newText);
						decisionBox.setSolution(option);
					}
				}
			});
		}
	}

}

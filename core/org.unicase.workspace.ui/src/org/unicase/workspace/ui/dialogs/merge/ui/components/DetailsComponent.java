/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.ui.components;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.ui.DecisionBox;
import org.unicase.workspace.ui.dialogs.merge.ui.widgets.MergeTextWidget;
import org.unicase.workspace.ui.dialogs.merge.ui.widgets.OtherInvolvedWidget;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionConfig;

/**
 * Uses widgets to display details if needed for the decision box.
 * 
 * @author wesendon
 */
public class DetailsComponent extends Section {

	/**
	 * Default constructor.
	 * 
	 * @param decisionBox
	 *            parent
	 * @param conflict
	 *            conflict
	 */
	public DetailsComponent(final DecisionBox decisionBox, Conflict conflict) {
		super(decisionBox, Section.TWISTIE);
		setText("Details");
		setLayout(new FillLayout());
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		layoutData.horizontalSpan = 2;
		setLayoutData(layoutData);
		setBackground(decisionBox.getBackground());
		// section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		int columns = 1;

		//
		// for (ConflictOption option : conflict.getOptions()) {
		// if (option.isDetailsProvider()) {
		// columns++;
		// }
		// }

		Composite client = new Composite(this, SWT.NONE);
		TableWrapLayout layout = new TableWrapLayout();
		layout.numColumns = columns;
		layout.makeColumnsEqualWidth = true;
		layout.topMargin = 0;
		layout.bottomMargin = 0;
		layout.rightMargin = 0;
		layout.leftMargin = 0;
		client.setLayout(layout);
		client.setBackground(this.getBackground());

		MergeTextWidget multiWidget = null;
		for (ConflictOption option : conflict.getOptions()) {
			if (!option.isDetailsProvider()) {
				continue;
			}
			if (option.getDetailProvider().startsWith(
					DecisionConfig.WIDGET_MULTILINE)) {
				if (multiWidget == null) {
					multiWidget = new MergeTextWidget(decisionBox, this);
				}
				multiWidget.addOption(option);
			} else if (option.getDetailProvider().startsWith(
					DecisionConfig.WIDGET_OTHERINVOLVED)) {
				new OtherInvolvedWidget(client, decisionBox
						.getDecisionManager(), option);
			}
		}

		if (multiWidget != null) {
			multiWidget.createContent(client);
		}

		setClient(client);
		addExpansionListener(new IExpansionListener() {

			// hack: assuming initial size
			private Rectangle bounds = new Rectangle(0, 0, 0, 20);

			public void expansionStateChanged(ExpansionEvent e) {
				int height = bounds.height;
				bounds.height = getBounds().height;
				decisionBox.layoutPage(bounds.height - height);
			}

			public void expansionStateChanging(ExpansionEvent e) {
				// decisionBox.layoutPage();
			}
		});
	}
}

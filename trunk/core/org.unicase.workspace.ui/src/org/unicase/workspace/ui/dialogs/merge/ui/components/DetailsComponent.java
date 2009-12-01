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
import org.unicase.workspace.ui.dialogs.merge.ui.widgets.MultilineWidget;
import org.unicase.workspace.ui.dialogs.merge.ui.widgets.OtherInvolvedWidget;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionConfig;

public class DetailsComponent extends Section {

	public DetailsComponent(final DecisionBox decisionBox, Conflict conflict) {
		super(decisionBox, Section.TWISTIE);
		setText("Details");
		setLayout(new FillLayout());
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		layoutData.horizontalSpan = 2;
		setLayoutData(layoutData);
		setBackground(decisionBox.getBackground());
		// section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		int columns = 0;
		for (ConflictOption option : conflict.getOptions()) {
			if (option.isDetailsProvider()) {
				columns++;
			}
		}

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

		for (ConflictOption option : conflict.getOptions()) {
			if (!option.isDetailsProvider()) {
				continue;
			}
			if (option.getDetailProvider().startsWith(
					DecisionConfig.WIDGET_MULTILINE)) {
				new MultilineWidget(client, decisionBox, option);
			} else if (option.getDetailProvider().startsWith(
					DecisionConfig.WIDGET_OTHERINVOLVED)) {
				new OtherInvolvedWidget(client, decisionBox
						.getDecisionManager(), option);
			}
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

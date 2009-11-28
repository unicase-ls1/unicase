package org.unicase.workspace.ui.dialogs.merge.ui.components;

import org.eclipse.swt.SWT;
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

	public DetailsComponent(final DecisionBox parent, Conflict conflict) {
		super(parent, Section.TWISTIE);
		setText("Details");
		setLayout(new FillLayout());
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		layoutData.horizontalSpan = 2;
		setLayoutData(layoutData);
		addExpansionListener(new IExpansionListener() {
			public void expansionStateChanged(ExpansionEvent e) {
				parent.layoutPage();
			}

			public void expansionStateChanging(ExpansionEvent e) {
				parent.layoutPage();
			}
		});
		setBackground(parent.getBackground());
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
				new MultilineWidget(client, parent, option);
			} else if (option.getDetailProvider().startsWith(
					DecisionConfig.WIDGET_OTHERINVOLVED)) {
				new OtherInvolvedWidget(client, parent.getDecisionManager(),
						option);
			}
		}

		setClient(client);
	}
}

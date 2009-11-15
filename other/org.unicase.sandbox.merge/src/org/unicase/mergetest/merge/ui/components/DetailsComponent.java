package org.unicase.mergetest.merge.ui.components;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.ui.DecisionBox;
import org.unicase.mergetest.merge.ui.widgets.MultilineCompareWidget;

public class DetailsComponent extends Section {

	public DetailsComponent(
			final DecisionBox parent,
			Conflict conflict) {
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

		Composite client = new Composite(this, SWT.NONE);
		TableWrapLayout layout = new TableWrapLayout();
		layout.topMargin=0;
		layout.bottomMargin=0;
		layout.rightMargin=0;
		layout.leftMargin=0;
		client.setLayout(layout);
		client.setBackground(getBackground());
		
		new MultilineCompareWidget(client, conflict);
		
		setClient(client);
	}
}

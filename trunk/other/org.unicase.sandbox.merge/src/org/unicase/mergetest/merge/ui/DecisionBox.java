package org.unicase.mergetest.merge.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.ConflictOption;
import org.unicase.mergetest.merge.ui.components.ContextComponent;
import org.unicase.mergetest.merge.ui.components.DescriptionComponent;
import org.unicase.mergetest.merge.ui.components.OptionComponent;
import org.unicase.mergetest.merge.ui.widgets.MultilineCompareWidget;

public class DecisionBox extends Composite {

	private final Conflict<? extends AbstractOperation,? extends AbstractOperation> conflict;

	public DecisionBox(Composite parent, Conflict<? extends AbstractOperation, ? extends AbstractOperation> conflict) {
		super(parent, SWT.BORDER);
		this.conflict = conflict;
		
		GridLayout decisionLayout = new GridLayout(2, true);
		this.setLayout(decisionLayout);
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	
//		setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
		
		new ContextComponent(this,conflict);
		new OptionComponent(this,conflict);
		new DescriptionComponent(this, conflict);
	}
	
	private void layoutPage() {
		getParent().getParent().getParent().layout();
	}
}

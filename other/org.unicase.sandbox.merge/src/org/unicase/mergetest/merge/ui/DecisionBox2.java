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
import org.unicase.mergetest.merge.MultilineCompareWidget;
import org.unicase.mergetest.merge.conflicts.Conflict;
import org.unicase.mergetest.merge.conflicts.ConflictOption;

public class DecisionBox2 extends Composite {

	private final Conflict<? extends AbstractOperation,? extends AbstractOperation> conflict;

	public DecisionBox2(Composite parent, Conflict<? extends AbstractOperation, ? extends AbstractOperation> conflict) {
		super(parent, SWT.BORDER);
		this.conflict = conflict;
		
		GridLayout decisionLayout = new GridLayout(2, true);
		this.setLayout(decisionLayout);
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	
//		setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
		
		new ContextComponent(this,conflict);
		new OptionComponent(this,conflict);
		
		Text description = new Text(this, SWT.NONE);
		description.setLayoutData(new GridData(GridData.FILL_BOTH));
		description.setEditable(false);
		description.setCapture(false);
		description.setText("Hier ist die Description");
	}
	
	private void layoutPage() {
		getParent().getParent().getParent().layout();
	}
}

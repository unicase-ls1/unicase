package org.unicase.mergetest.merge;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;

public class DecisionBox extends Composite {

	public DecisionBox(Composite parent, Conflict conflict) {
		super(parent, SWT.BORDER);
		GridLayout gridLayout2 = new GridLayout(4, false);
		this.setLayout(gridLayout2);
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		Link link = new Link(this, SWT.LEFT);
		link.setText("ModelElement '"+conflict.getName()+"'\n"+conflict.getConflictDescription());
		link.setEnabled(true);
		Text optionDescription = new Text(this, SWT.NONE);
		optionDescription.setEditable(false);
		optionDescription.setText(conflict.getOptionDescription()
				+ " :");
		optionDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				true, true));
		
		for (String option : conflict.getOptions()) {
			Button optionButton = new Button(this, SWT.NONE);
			optionButton.setText(option);
		}
	}

}

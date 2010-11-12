package org.unicase.iterationplanner.ui.wizard.input;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public abstract class AbstractInputPage extends WizardPage {

	
	
	protected AbstractInputPage(String pageName) {
		super(pageName);
	}

	public void createControl(Composite parent) {
		parent.setLayout(new GridLayout());
		parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_BLUE));
		
		Button button = new Button(composite, SWT.PUSH);
		button.setLayoutData(new GridData());
		setControl(composite);
	}

}

/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.questionnaire.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.unicase.workspace.Configuration;

/**
 * @author liya
 */
public class ChooseUserPage extends WizardPage implements Listener {

	private static final String DIR = Configuration.getWorkspaceDirectory();
	private static final String PAGE_TITLE = "User";
	private static final String PAGE_DESCRIPTION = "Please give your user number";
	private Text userNumber;
	private Text commitNumber;
	private Button operationBased;
	private Button stateBased;

	protected ChooseUserPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		if (isTextNonEmpty(userNumber)) {
			setPageComplete(false);
			((QuestionnaireWizard) getWizard()).setCanFinish(true);
			((QuestionnaireWizard) getWizard()).setUser(Integer.valueOf(userNumber.getText()));
		}
		getWizard().getContainer().updateButtons();
	}

	private static boolean isTextNonEmpty(Text t) {
		String s = t.getText();
		if ((s != null) && (s.trim().length() > 0)) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		GridData gd;
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout();
		int ncol = 4;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		new Label(composite, SWT.NONE).setText("User Number:");
		userNumber = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		userNumber.setLayoutData(gd);
		userNumber.setFocus();
		userNumber.addListener(SWT.KeyUp, this);

		// new Label (composite, SWT.NONE).setText("Commit Number:");
		// commitNumber = new Text(composite, SWT.BORDER);
		// gd = new GridData(GridData.FILL_HORIZONTAL);
		// commitNumber.setLayoutData(gd);
		// commitNumber.setFocus();
		// commitNumber.addListener(SWT.FocusOut, this);
		//		
		// operationBased = new Button(composite, SWT.RADIO);
		// operationBased.setText("Operation Based");
		// operationBased.setLayoutData(gd);
		// operationBased.addListener(SWT.Selection, this);
		//		
		// stateBased = new Button(composite, SWT.RADIO);
		// stateBased.setText("State Based");
		// stateBased.setLayoutData(gd);
		// stateBased.addListener(SWT.Selection, this);

		setControl(composite);
		setPageComplete(false);

	}
}

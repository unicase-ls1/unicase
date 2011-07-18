/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.linkrecommendation.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * @author henning femmer
 */
public class WelcomePage extends WizardPage {

	private static final String TITLE = "Welcome";
	private static final String DESCRIPTION = "Welcome to the Link Recovery wizard.";
	private String projectName;

	/**
	 * The Constructor.
	 * 
	 * @param projectName the project name
	 */
	protected WelcomePage(String projectName) {
		super(TITLE);
		this.setTitle(TITLE);
		this.setDescription(DESCRIPTION);
		this.projectName = projectName;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gl = new GridLayout();
		int ncol = 1;
		gl.numColumns = ncol;
		composite.setLayout(gl);
		new Label(composite, SWT.NONE).setText("Welcome.");
		new Label(composite, SWT.NONE).setText("You decided to recover traceability links from the project:");
		new Label(composite, SWT.NONE).setText(projectName);

		setControl(composite);
	}

}

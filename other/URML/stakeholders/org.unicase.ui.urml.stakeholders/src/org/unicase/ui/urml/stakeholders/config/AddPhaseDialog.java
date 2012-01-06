/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.config;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.model.urml.Phase;

/**
 * Dialog for adding new development phase to the active project.
 * @author kterzieva
 *
 */
public class AddPhaseDialog extends TitleAreaDialog {

	private String dialogName, dialogMessage;
	private Text phaseName;
	private Composite composite;
	private Phase developmentPhase;
	private String selectedText;
	
	/**
	 * The construct.
	 * @param parentShell the shell
	 * @param phase the development phase to be added
	 * @param dialogName the name of the dialog
	 * @param dialogMessage the message
	 */
	public AddPhaseDialog(Shell parentShell, Phase phase, String dialogName,
			String dialogMessage) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.developmentPhase = phase;
		this.dialogName = dialogName;
		this.dialogMessage = dialogMessage;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		setTitleAndMessage(dialogName, dialogMessage);
		// Create composite
		Composite wrap = (Composite) super.createDialogArea(parent);
		composite = new Composite(wrap, SWT.NONE);
		// Layout stuff
		GridLayout gridLayout = new GridLayout(1, true);
		composite.setLayout(gridLayout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		composite.setFont(parent.getFont());
		createNameLabel();
		return composite;
	}

	private void setTitleAndMessage(String dialogName, String dialogMessage) {
		setTitle(dialogName);
		setMessage(dialogMessage);
	}

	@Override
	protected void configureShell(Shell parent) {
		super.configureShell(parent);
	}

	private void createNameLabel() {
		phaseName = new Text(composite, SWT.BORDER);
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = SWT.FILL;
		phaseName.setLayoutData(gridData);
		phaseName.setText(developmentPhase.getName());
	}

	@Override
	protected Button createButton(Composite parent, int id, String label,
			boolean defaultButton) {
		if (id == IDialogConstants.OK_ID) {
			label = "Save";
		}
		Button saveButton = super.createButton(parent, id, label, defaultButton);
		return saveButton;
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == Window.OK) {
			selectedText = phaseName.getText();
		}
		super.buttonPressed(buttonId);
	}

	/**
	 * Gets the entered name of the new development phase.
	 * @return selectedText
	 */
	public String getSelectedName() {
		return selectedText;
	}
}

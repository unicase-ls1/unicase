/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.wizards;

import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * Wizard page of the create change package wizard in which a name, short
 * description, and long description of a change package are chosen.
 * 
 * @author jfinis
 * 
 */
public class ChooseNameAndDescriptionPage extends WizardPage {

	private static final String ERROR_MESSAGE = "Choose a name, short and long description for your change package. They will be used in the created branch, commit and model elements.";
	private Composite composite;
	private Text nameInput;
	private Text shortDescInput;
	private Text longDescInput;
	private boolean validInput = true;

	/**
	 * Retrieves the chosen name.
	 * 
	 * @return chosen name
	 */
	public String getChosenName() {
		return nameInput.getText();
	}

	/**
	 * Retrieves the chosen short description.
	 * 
	 * @return chosen short description
	 */
	public String getChosenShortDescription() {
		return shortDescInput.getText();
	}

	/**
	 * Retrieves the chosen long description.
	 * 
	 * @return chosen long description
	 */
	public String getChosenLongDescription() {
		return longDescInput.getText();
	}

	/**
	 * Default constructor.
	 * 
	 * @param pageName page name
	 * @param title title
	 * @param titleImage title image
	 */
	protected ChooseNameAndDescriptionPage(String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).margins(10, 10).spacing(5, 5).applyTo(composite);
		setControl(composite);

		// Layout datas
		GridDataFactory fillAll = GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true);
		GridDataFactory fillOneColLayout = GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false);
		GridDataFactory notFillOneColLayout = GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(false, false);
		int textStyleBits = SWT.BORDER;
		int descriptionStyleBits = SWT.NONE;

		// Listeners
		ModifyListener updateListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				updateFields();

			}
		};

		// First line
		Label label = new Label(composite, descriptionStyleBits);
		label.setText("Name:");
		notFillOneColLayout.applyTo(label);
		nameInput = new Text(composite, textStyleBits);
		fillOneColLayout.applyTo(nameInput);
		nameInput.addModifyListener(updateListener);

		// Second line
		label = new Label(composite, descriptionStyleBits);
		label.setText("Short Description:");
		notFillOneColLayout.applyTo(label);
		shortDescInput = new Text(composite, textStyleBits);
		fillOneColLayout.applyTo(shortDescInput);
		shortDescInput.addModifyListener(updateListener);

		// Third line
		label = new Label(composite, descriptionStyleBits);
		label.setText("Long Description:");
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).applyTo(label);
		longDescInput = new Text(composite, textStyleBits | SWT.MULTI);
		fillAll.applyTo(longDescInput);
		longDescInput.addModifyListener(updateListener);

		// Finally update all fields
		updateFields();
	}

	private static final Pattern EMPTY_PATTERN = Pattern.compile("\\s*");

	private boolean isEmpty(Text input) {
		return EMPTY_PATTERN.matcher(input.getText()).matches();
	}

	/**
	 * Updates the fields and the finishable property of the dialog.
	 */
	private void updateFields() {
		if (isEmpty(nameInput) || isEmpty(shortDescInput) || isEmpty(longDescInput)) {
			setMessage(ERROR_MESSAGE, DialogPage.ERROR);
			if (validInput) {
				validInput = false;
				((CreateChangePackageWizard) getWizard()).setFinishable(false);
			}
		} else {

			setMessage("", DialogPage.NONE);
			if (!validInput) {
				validInput = true;
				((CreateChangePackageWizard) getWizard()).setFinishable(true);
			}

		}
	}

}

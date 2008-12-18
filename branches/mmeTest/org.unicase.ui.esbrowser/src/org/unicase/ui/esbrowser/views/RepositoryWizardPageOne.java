/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.esbrowser.views;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.unicase.workspace.ServerInfo;

/**
 * The main page of the wizard.
 * 
 * @author shterev
 * 
 */
public class RepositoryWizardPageOne extends WizardPage {

	private Text name;
	private Text displayName;
	private Text url;
	private Spinner port;

	/**
	 * Default constructor.
	 * 
	 * @param workbench
	 *            the current workbench
	 * @param selection
	 *            the current selection
	 */
	public RepositoryWizardPageOne(IWorkbench workbench,
			IStructuredSelection selection) {
		super("Main");
		setTitle("Server Details");
		setDescription("Select the details for the new repository");
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		RepositoryWizard wizard = (RepositoryWizard) getWizard();
		ServerInfo serverInfo = wizard.getServerInfo();

		GridData gd;
		Composite composite = new Composite(parent, SWT.NULL);

		GridLayout gl = new GridLayout();
		int ncol = 2;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		new Label(composite, SWT.NONE).setText("Display name:");
		displayName = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol - 1;
		displayName.setLayoutData(gd);

		new Label(composite, SWT.NONE).setText("Name:");
		name = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol - 1;
		name.setLayoutData(gd);

		new Label(composite, SWT.NONE).setText("URL:");
		url = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol - 1;
		url.setLayoutData(gd);

		new Label(composite, SWT.NONE).setText("Port:");
		port = new Spinner(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol - 1;
		port.setLayoutData(gd);
		port.setValues(1099, 1, 999999, 0, 1, 10);
		if (serverInfo.getUrl() != null) {
			displayName.setText(serverInfo.getDisplayName());
			name.setText(serverInfo.getName());
			url.setText(serverInfo.getUrl());
			port.setSelection(serverInfo.getPort());
		}
		setControl(composite);
	}

	/**
	 * @return if the input on the current page is valid.
	 */
	@Override
	public boolean canFlipToNextPage() {
		if (getErrorMessage() != null) {
			return false;
		}
		if (isTextNonEmpty(name) && isTextNonEmpty(displayName)
				&& isTextNonEmpty(url)) {
			saveDataToModel();
			return true;
		}
		return false;
	}

	/**
	 * Saves the uses choices from this page to the model. Called on exit of the
	 * page
	 */
	private void saveDataToModel() {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				RepositoryWizard wizard = (RepositoryWizard) getWizard();
				ServerInfo serverInfo = wizard.getServerInfo();
				serverInfo.setDisplayName(displayName.getText());
				serverInfo.setName(name.getText());
				serverInfo.setUrl(url.getText());
				serverInfo.setPort(port.getSelection());
			}
		});
	}

	private static boolean isTextNonEmpty(Text t) {
		String s = t.getText();
		if ((s != null) && (s.trim().length() > 0)) {
			return true;
		}
		return false;
	}

}


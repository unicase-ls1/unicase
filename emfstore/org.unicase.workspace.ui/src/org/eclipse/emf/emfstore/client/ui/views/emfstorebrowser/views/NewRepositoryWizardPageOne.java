/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.views;

import java.util.ArrayList;

import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.connectionmanager.KeyStoreManager;
import org.eclipse.emf.emfstore.client.model.exceptions.CertificateStoreException;
import org.eclipse.emf.emfstore.client.model.util.UnicaseCommand;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;

/**
 * The main page of the wizard.
 * 
 * @author shterev
 */
public class NewRepositoryWizardPageOne extends WizardPage {

	private static final int DEFAULT_PORT = 8080;
	private Text name;
	private Text url;
	private Spinner port;
	private Text cert;

	/**
	 * Default constructor.
	 * 
	 * @param workbench
	 *            the current workbench
	 * @param selection
	 *            the current selection
	 */
	public NewRepositoryWizardPageOne(IWorkbench workbench,
			IStructuredSelection selection) {
		super("Main");
		setTitle("Server Details");
		setDescription("Select the details for the new repository");
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		NewRepositoryWizard wizard = (NewRepositoryWizard) getWizard();
		ServerInfo serverInfo = wizard.getServerInfo();

		GridData gd;
		Composite composite = new Composite(parent, SWT.NULL);

		GridLayout gl = new GridLayout();
		int ncol = 2;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		// Server Name
		new Label(composite, SWT.NONE).setText("Name:");
		name = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol - 1;
		name.setLayoutData(gd);
		// name.addModifyListener(new ModifyListener() {
		// public void modifyText(ModifyEvent e) {
		// if (name.getText().equalsIgnoreCase("sysiphus")) {
		// new NewRepositoryWizardPageTwentyThree(getShell());
		// }
		// }
		// });

		// Server URL
		new Label(composite, SWT.NONE).setText("URL:");
		url = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol - 1;
		url.setLayoutData(gd);

		// Server Port
		new Label(composite, SWT.NONE).setText("Port:");
		port = new Spinner(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol - 1;
		port.setLayoutData(gd);
		port.setValues(DEFAULT_PORT, 1, 999999, 0, 1, 10);
		setControl(composite);

		// Certificate
		new Label(composite, SWT.NONE).setText("Certificate:");
		cert = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol - 1;
		cert.setLayoutData(gd);
		cert.setEditable(false);
		cert
				.setBackground(Display.getCurrent().getSystemColor(
						SWT.COLOR_WHITE));

		// Choose Certificate, Opens Dialogue
		new Label(composite, SWT.NONE).setText("");
		Button button = new Button(composite, SWT.NONE);
		button.setText("Select certificate...");
		button.addSelectionListener(new SelectionDialogListener());

		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalSpan = ncol - 1;
		button.setLayoutData(gd);

		if (serverInfo.getUrl() != null) {
			name.setText(serverInfo.getName());
			url.setText(serverInfo.getUrl());
			port.setSelection(serverInfo.getPort());
			if (serverInfo.getCertificateAlias() != null) {
				try {
					if (KeyStoreManager.getInstance().contains(
							serverInfo.getCertificateAlias())) {
						cert.setText(serverInfo.getCertificateAlias());
					} else {
						cert.setText("");
					}
				} catch (CertificateStoreException e1) {
					cert.setText("");
				}
			}
		}
	}

	/**
	 * @return if the input on the current page is valid.
	 */
	@Override
	public boolean canFlipToNextPage() {
		if (getErrorMessage() != null) {
			return false;
		}
		if (isTextNonEmpty(name) && isTextNonEmpty(url) && isTextNonEmpty(cert)) {
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
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				NewRepositoryWizard wizard = (NewRepositoryWizard) getWizard();
				ServerInfo serverInfo = wizard.getServerInfo();
				serverInfo.setName(name.getText());
				serverInfo.setUrl(url.getText());
				serverInfo.setPort(port.getSelection());
				serverInfo.setCertificateAlias(cert.getText());
			}
		}.run();
	}

	/**
	 * Returns true if Text is not empty, i.e. not null/only space characters.
	 * 
	 * @param t
	 * @return boolean
	 */
	private static boolean isTextNonEmpty(Text t) {
		String s = t.getText();
		if ((s != null) && (s.trim().length() > 0)) {
			return true;
		}
		return false;
	}

	/**
	 * Listener for the selection dialog.
	 * 
	 * @author C
	 */
	class SelectionDialogListener implements SelectionListener {

		/**
		 * @param e
		 *            selection event
		 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do
		}

		/**
		 * @param e
		 *            selection event
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetSelected(SelectionEvent e) {
			CertificateSelectionDialog csd = new CertificateSelectionDialog(
					Display.getCurrent().getActiveShell(), new LabelProvider() {
						@Override
						public String getText(Object element) {
							if (element instanceof String) {
								return element.toString();
							} else {
								return "";
							}
						}
					});
			ArrayList<String> certificates;
			try {
				certificates = KeyStoreManager.getInstance().getCertificates();
				csd.setElements(certificates.toArray());
			} catch (CertificateStoreException e1) {
				csd.setErrorMessage(e1.getMessage());
			}
			csd.setBlockOnOpen(true);
			csd.setTitle("Certificate Selection Dialogue");
			csd.open();
			if (csd.getReturnCode() == Window.OK) {
				cert.setText(csd.getCertificateAlias());
			}
		}
	}
}
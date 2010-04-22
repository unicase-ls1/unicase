/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.ui.tabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionListener;

import config.ConfigEntity;
import org.unicase.rap.config.IValidator;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.updater.ProjectUpdaterManager;
import org.unicase.rap.config.EMFServerSettingsConfigEntity;

/**
 * EMFServer settings tab.
 * 
 * @author Edgar Müller, Fatih Ulusoy
 */
public class EMFServerSettingsTab extends ConfigurationTab {

	private EMFServerSettingsConfigEntity cfgEntity;
	
	private Text emfServerUrlTextField;
	private Spinner emfServerPortField;
	private Text emfServerUserNameTextField;
	private Text emfServerUserPasswordTextField;	
	private Text emfServerUserPasswordConfirmationTextField;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createConfigurationTab(Composite parent) {

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.makeColumnsEqualWidth = true;
		parent.setLayout(gridLayout);

		Label label = new Label(parent, SWT.NONE);
		label.setText("EMF Server URL:");

		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;

		emfServerUrlTextField = new Text(parent, SWT.BORDER);
		emfServerUrlTextField.setLayoutData(gridData);
		
		label = new Label(parent, SWT.NONE);
		label.setText("EMF Server Port:");

		emfServerPortField = new Spinner(parent, SWT.BORDER);
		emfServerPortField.setValues(443, 1, 999999, 0, 1, 10);
		emfServerPortField.setLayoutData(gridData);
		
		label = new Label(parent, SWT.NONE);
		label.setText("Web client user-name:");

		emfServerUserNameTextField = new Text(parent, SWT.BORDER);
		emfServerUserNameTextField.setLayoutData(gridData);

		label = new Label(parent, SWT.NONE);
		label.setText("Web client password:");

		emfServerUserPasswordTextField = new Text(parent, SWT.BORDER | SWT.PASSWORD);
		emfServerUserPasswordTextField.setLayoutData(gridData);

		label = new Label(parent, SWT.NONE);
		label.setText("Password confirmation:");
		emfServerUserPasswordConfirmationTextField = new Text(parent, SWT.BORDER | SWT.PASSWORD);
		emfServerUserPasswordConfirmationTextField.setLayoutData(gridData);
	
		final Label messageLabel = new Label(parent, SWT.NONE);
		messageLabel.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		
		final Button activateButton = new Button(parent, SWT.NONE);
		gridData.grabExcessHorizontalSpace = true;
		// gridData.grabExcessVerticalSpace = true;
		activateButton.setLayoutData(gridData);
		
		if(ProjectUpdaterManager.isRunning()){
			activateButton.setText("Stop Project Updater");
			messageLabel.setText("Updater is running.");
			
		}else {
			activateButton.setText("Start Project Updater");
			messageLabel.setText("Updater was stopped.");
		}
		
		activateButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
			
				if(ProjectUpdaterManager.isRunning()) {
					ProjectUpdaterManager.stop();
					MessageDialog.openInformation(Display.getDefault().getActiveShell(),
						"Updater stopped", "Updater stopped successful.");
					activateButton.setText("Start Project Updater");
					messageLabel.setText("Updater was stopped.");
				} else {
					// before updater runs, saves config entity.
					saveConfigEntity();
					ProjectUpdaterManager mng = ProjectUpdaterManager.getInstance();
					Thread updaterThread = new Thread(mng);
					updaterThread.start();
					MessageDialog.openInformation(Display.getDefault().getActiveShell(),
						"Updater started", "Updater started successful.");
					activateButton.setText("Stop Project Updater");
					messageLabel.setText("Updater is running.");
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		addValidator(new IValidator() {

			public boolean validate() {
				return emfServerUserPasswordTextField.getText().equals(
					emfServerUserPasswordConfirmationTextField.getText());
			}

			public String getValidationErrorMessage() {
				return "The passwords you've provided do not match.";
			}
		});

		loadSettings();

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConfigEntity getConfigEntity() {
		cfgEntity = new EMFServerSettingsConfigEntity();
		cfgEntity.setEmfServerUrl(emfServerUrlTextField.getText());
		cfgEntity.setEmfServerPort(emfServerPortField.getSelection());
		cfgEntity.setEmfServerUserName(emfServerUserNameTextField.getText());
		cfgEntity.setEmfServerUserPassword(emfServerUserPasswordTextField.getText());
		return cfgEntity;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void loadSettings() {
		EMFServerSettingsConfigEntity configEntity = new EMFServerSettingsConfigEntity();
		ConfigEntity entity = ConfigEntityStore.loadConigEntity(configEntity, configEntity.eClass());

		if (entity != null) {
			emfServerUrlTextField.setText((String) entity.getProperties().get(
				EMFServerSettingsConfigEntity.Keys.EMF_SERVER_URL));

			emfServerPortField.setValues((Integer) entity.getProperties().get(
				EMFServerSettingsConfigEntity.Keys.EMF_SERVER_PORT), 1, 999999, 0, 1, 10);

			emfServerUserNameTextField.setText((String) entity.getProperties().get(
				EMFServerSettingsConfigEntity.Keys.EMF_SERVER_USER_NAME));

			String password = (String) entity.getProperties().get(
				EMFServerSettingsConfigEntity.Keys.EMF_SERVER_USER_PASSWORD);

			emfServerUserPasswordTextField.setText(password);
			emfServerUserPasswordConfirmationTextField.setText(password);
		}
	}

}



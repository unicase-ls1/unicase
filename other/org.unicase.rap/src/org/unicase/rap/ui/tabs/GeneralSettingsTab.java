/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.ui.tabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import config.ConfigEntity;
import org.unicase.rap.config.IValidator;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.GeneralSettingsConfigEntity;

/**
 * General settings tab.
 * 
 * @author Edgar M�ller, Fatih Ulusoy
 */
public class GeneralSettingsTab extends ConfigurationTab {
	
	private GeneralSettingsConfigEntity cfgEntity;
	
	private Text adminUserNameTextField;
	private Text passwordTextField;
	private Text passwordConfirmationTextField;

	/**
	 * {@inheritDoc}
	 */
	public void createConfigurationTab(Composite parent) {

		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    gridLayout.makeColumnsEqualWidth = true;
	    parent.setLayout(gridLayout);
			
		Label l = new Label(parent, SWT.NONE); 
		l.setText("Admin user name:");
		
		GridData d = new GridData();
		d.horizontalAlignment = GridData.FILL;

		adminUserNameTextField = new Text(parent, SWT.BORDER);
		adminUserNameTextField.setLayoutData(d);
	
		l = new Label(parent, SWT.NONE);
		l.setText("Admin password");
		
		passwordTextField = new Text(parent, SWT.BORDER | SWT.PASSWORD);
		passwordTextField.setLayoutData(d);
		
		l = new Label(parent, SWT.NONE);
		l.setText("Admin password confirmation");
		passwordConfirmationTextField = new Text(parent, SWT.BORDER | SWT.PASSWORD);
		passwordConfirmationTextField.setLayoutData(d);
		
		addValidator(new IValidator() {
			
			public boolean validate() {
				return passwordTextField.getText().equals(passwordConfirmationTextField.getText());
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
		cfgEntity = new GeneralSettingsConfigEntity();
		cfgEntity.setAdminPassword(passwordTextField.getText());
		cfgEntity.setAdminUsername(adminUserNameTextField.getText());
		return cfgEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void loadSettings() {
		
		 GeneralSettingsConfigEntity configEntity = new GeneralSettingsConfigEntity();
		 ConfigEntity entity = ConfigEntityStore.loadConigEntity(configEntity, configEntity.eClass());
		 
		 if (entity != null) {
			 adminUserNameTextField.setText((String) entity.getProperties()
					 .get(GeneralSettingsConfigEntity.Keys.ADMIN_USER_NAME_KEY));

			 String password = (String) entity.getProperties().get(
					 GeneralSettingsConfigEntity.Keys.ADMIN_PASSWORD_KEY);

			 passwordTextField.setText(password);
			 passwordConfirmationTextField.setText(password);
		 }
	}
	
}



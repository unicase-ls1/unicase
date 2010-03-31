package org.unicase.rap.ui.tabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import config.ConfigEntity;
import org.unicase.rap.config.IValidator;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.EMFServerSettingsConfigEntity;

/**
 * 
 * 
 * @author fxulusoy
 *
 */
public class EMFServerSettingsTab extends ConfigurationTab {

	private EMFServerSettingsConfigEntity cfgEntity;
	
	private Text emfServerUrlTextField;
	private Spinner emfServerPortField;
	private Text emfServerUserNameTextField;
	private Text emfServerUserPasswordTextField;	
	private Text emfServerUserPasswordConfirmationTextField;
	
	@Override
	public ConfigEntity getConfigEntity() {
		cfgEntity = new EMFServerSettingsConfigEntity();
		cfgEntity.setEmfServerUrl(emfServerUrlTextField.getText());
		cfgEntity.setEmfServerPort(emfServerPortField.getSelection());
		cfgEntity.setEmfServerUserName(emfServerUserNameTextField.getText());
		cfgEntity.setEmfServerUserPassword(emfServerUserPasswordTextField.getText());
		return cfgEntity;
	}

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

}



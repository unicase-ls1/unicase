package org.unicase.rap.ui.tabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.rap.config.AbstractConfigEntity;
import org.unicase.rap.config.GeneralSettingsConfigEntity;
import org.unicase.rap.config.IValidator;
import org.unicase.rap.ui.views.ConfigurationTabView;

public class GeneralSettingsTab extends ConfigurationTabView {

	private GeneralSettingsConfigEntity cfgEntity;
	
	private Text adminUserNameTextField;
	private Text passwordTextField;
	private Text passwordConfirmationTextField;

	protected void createTab(Composite parent) {
		
		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    gridLayout.makeColumnsEqualWidth = true;
	    parent.setLayout(gridLayout);
			
		Label l = new Label(parent, SWT.NONE); 
		l.setText("Admin user name:");
		
		GridData d = new GridData();
		d.horizontalAlignment = GridData.FILL;

		final Text t = new Text(parent, SWT.BORDER);
		t.setLayoutData(d);
	
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
	}

	@Override
	public AbstractConfigEntity getConfigEntity() {
		cfgEntity = new GeneralSettingsConfigEntity("general");
		cfgEntity.setAdminPassword(passwordTextField.getText());
		cfgEntity.setAdminUsername(adminUserNameTextField.getText());
		return cfgEntity;
	}

}

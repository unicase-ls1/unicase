package org.unicase.rap.ui.tabs;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.rap.config.AbstractConfigEntity;
import org.unicase.rap.config.GeneralSettingsConfigEntity;
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
		final Text t = new Text(parent, SWT.BORDER);
	
		l = new Label(parent, SWT.NONE);
		l.setText("Admin password");
		passwordTextField = new Text(parent, SWT.BORDER | SWT.PASSWORD);
		
		l = new Label(parent, SWT.NONE);
		l.setText("Admin password confirmation");
		passwordConfirmationTextField = new Text(parent, SWT.BORDER | SWT.PASSWORD);
		
		Button saveButton = new Button(parent, SWT.NONE); 
		saveButton.setText("Save settings");
		saveButton.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				// TODO: check whether passwords match
				if (!passwordTextField.getText().equals(passwordConfirmationTextField.getText())) {
					MessageDialog.openError(Display.getDefault().getActiveShell(),
							"Passwords don't match", 
							"The passwords you've provided do not match.");
				} 
			}
			
			public void widgetDefaultSelected(SelectionEvent e) { }
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

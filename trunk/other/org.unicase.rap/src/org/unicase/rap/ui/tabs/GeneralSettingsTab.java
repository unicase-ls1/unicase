package org.unicase.rap.ui.tabs;

import java.io.File;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.GeneralSettingsConfigEntity;
import org.unicase.rap.ui.views.ConfigurationTabView;

public class GeneralSettingsTab extends ConfigurationTabView{

	private Text passwordText;
	private Text passwordTextRepeated;

	@Override
	protected void createTab() {
		
		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    gridLayout.makeColumnsEqualWidth = true;
		getComposite().setLayout(gridLayout);
			
		Label l = new Label(getComposite(), SWT.NONE); 
		l.setText("Admin user name:");
		final Text t = new Text(getComposite(), SWT.BORDER);
	
		l = new Label(getComposite(), SWT.NONE);
		l.setText("Admin password");
		passwordText = new Text(getComposite(), SWT.BORDER | SWT.PASSWORD);
		
		l = new Label(getComposite(), SWT.NONE);
		l.setText("Admin password confirmation");
		passwordTextRepeated = new Text(getComposite(), SWT.BORDER | SWT.PASSWORD);
		
		Button saveButton = new Button(getComposite(), SWT.NONE); 
		saveButton.setText("Save settings");
		saveButton.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				// TODO: check whether passwords match
				if (!passwordText.getText().equals(passwordTextRepeated.getText())) {
					MessageDialog.openError(Display.getDefault().getActiveShell(),
							"Passwords don't match", 
							"The passwords you've provided do not match.");
				} else {
					GeneralSettingsConfigEntity generalSettings = new GeneralSettingsConfigEntity();
					generalSettings.setAdminPassword(passwordText.getText());
					generalSettings.setAdminUsername(t.getText());
					String filename = new File(System.getProperty("user.home")).getAbsolutePath() 
						+ File.separatorChar + generalSettings.getId();
					
					ConfigEntityStore.getInstance().saveEntity(generalSettings, filename);
					
					MessageDialog.openInformation(Display.getDefault().getActiveShell(),
							"Settings saved", "The settings were successfully saved.");
				}
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}

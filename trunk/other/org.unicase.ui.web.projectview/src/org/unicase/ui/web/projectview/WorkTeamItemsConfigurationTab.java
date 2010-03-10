package org.unicase.ui.web.projectview;



import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.ui.web.config.ConfigEntityStore;
import org.unicase.ui.web.views.ConfigurationTabView;

public class WorkTeamItemsConfigurationTab extends ConfigurationTabView {
	
	private Text passwordText;
	private Text passwordTextRepeated;

	@Override
	protected void createTab() {
		
		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    gridLayout.makeColumnsEqualWidth = true;
		getComposite().setLayout(gridLayout);
		
		Button saveButton = new Button(getComposite(), SWT.NONE); 
		saveButton.setText("Save settings");
		saveButton.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				// TODO: check whether passwords match
				if (passwordText.getText() != passwordTextRepeated.getText()) {
					MessageDialog.openError(Display.getDefault().getActiveShell(),
							"Password don't match", 
							"The passwords you've provided do not match.");
				}
				
				ConfigEntityStore.getInstance().saveSettings();
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Label l = new Label(getComposite(), SWT.NONE); 
		l.setText("Admin user name:");
		Text t = new Text(getComposite(), SWT.BORDER);
	
		l = new Label(getComposite(), SWT.NONE);
		l.setText("Admin password");
		passwordText = new Text(getComposite(), SWT.BORDER | SWT.PASSWORD);
		
		l = new Label(getComposite(), SWT.NONE);
		l.setText("Admin password confirmation");
		passwordTextRepeated = new Text(getComposite(), SWT.BORDER | SWT.PASSWORD);
	}

	
}

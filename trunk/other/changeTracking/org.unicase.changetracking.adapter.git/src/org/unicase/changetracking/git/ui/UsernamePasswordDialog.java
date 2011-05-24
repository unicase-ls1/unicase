/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.ui;


import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Dialog for entering a user name, password,
 * and for choosing to save these values.
 * 
 * @author gex
 *
 */
public class UsernamePasswordDialog extends Dialog {
  private static final int RESET_ID = IDialogConstants.NO_TO_ALL_ID + 1;

  private Text usernameField;

  private Text passwordField;

private Button saveButton;

private String username;

private String password;

private boolean wantSave;

private String startUsername;

private String startPassword;

private String uri;

  public UsernamePasswordDialog(Shell parentShell, String startUsername, String startPassword, String uri) {
    super(parentShell);
    setBlockOnOpen(true);
    this.uri = uri;
    this.startUsername = startUsername;
    this.startPassword = startPassword;
  }
  


  protected Control createDialogArea(Composite parent) {
	 parent.getShell().setText("Choose Auth-Information");
	 Composite comp = (Composite) super.createDialogArea(parent);

    GridLayout layout = (GridLayout) comp.getLayout();
    layout.numColumns = 2;
    
    Label caption = new Label(parent, SWT.NONE);
    caption.setText("Choose your authentication settings for\n" + uri);
    GridData data = new GridData(GridData.FILL_HORIZONTAL);
    data.horizontalSpan = 2;
    caption.setLayoutData(data);

    Label usernameLabel = new Label(comp, SWT.RIGHT);
    usernameLabel.setText("Username: ");

    usernameField = new Text(comp, SWT.SINGLE);
    data = new GridData(GridData.FILL_HORIZONTAL);
    usernameField.setLayoutData(data);
    usernameField.setText(startUsername);

    Label passwordLabel = new Label(comp, SWT.RIGHT);
    passwordLabel.setText("Password: ");

    passwordField = new Text(comp, SWT.SINGLE | SWT.PASSWORD);
    data = new GridData(GridData.FILL_HORIZONTAL);
    passwordField.setLayoutData(data);
    passwordField.setText(startPassword);

    saveButton = new Button(comp, SWT.CHECK);
    saveButton.setText("Remember settings");
    data = new GridData(GridData.FILL_HORIZONTAL);
    data.horizontalSpan = 2;
    saveButton.setLayoutData(data);

    return comp;
  }

  protected void createButtonsForButtonBar(Composite parent) {
    super.createButtonsForButtonBar(parent);
    createButton(parent, RESET_ID, "Reset All", false);
    
  }
  
  @Override
	public boolean close() {
	  	username = usernameField.getText();
	  	password = passwordField.getText();
	  	wantSave = saveButton.getSelection();
		return super.close();
	}
  
  
  
  public String getUsername(){
	  return username;
  }
  
  public String getPassword(){
	  return password;
  }
  
  public boolean wantSave(){
	  return wantSave;
  }

  protected void buttonPressed(int buttonId) {
    if (buttonId == RESET_ID) {
      usernameField.setText("");
      passwordField.setText("");
    } else {
      super.buttonPressed(buttonId);
    }
  }
}

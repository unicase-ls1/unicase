/*******************************************************************************
 * Copyright (c) 2007, 2008 OnPositive Technologies (http://www.onpositive.com/) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     OnPositive Technologies (http://www.onpositive.com/) - initial API and implementation
 *******************************************************************************/
package com.onpositive.richtexteditor.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


/**
 * @author 32kda
 * Simple dialog for requesting single line from user.
 */
public class NameDialog extends Dialog
{
	String resString = null, labelName = "Name", dialogTitle = "Here should be dialog title";
	Text nameText;
	
	protected NameDialog(Shell parentShell)
	{
		super(parentShell);
	}
	
	/**
	 * Dialogs a single text line dialog
	 * @param labelText Text of dialog label
	 * @param dialogTitle Text of dialog title
	 * @param parentShell Parent shell of dialog
	 * @param initialString Initial string for input field (for rename dialogs etc)
	 * @return User's input, if user pressed "OK", null otherwise
	 */
	public static String openNameDialog(String labelText, String dialogTitle, Shell parentShell, String initialString)
	{
		NameDialog nameDialog = new NameDialog(parentShell);
		nameDialog.labelName = labelText;
		nameDialog.dialogTitle = dialogTitle;
		nameDialog.create();
		nameDialog.getButton(Dialog.OK).setEnabled(false);
		if (initialString != null) nameDialog.nameText.setText(initialString);
		nameDialog.open();
		return nameDialog.resString;
	}

	protected Control createDialogArea(Composite parent)
	{
		getShell().setText(dialogTitle);
		Composite composite = new Composite(parent, SWT.NONE);
		
		GridLayout layout = new GridLayout(4, true);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		
	    Label nameLabel = new Label(composite, SWT.NULL);
	    nameLabel.setText(labelName);

	    nameText = new Text(composite, SWT.SINGLE | SWT.BORDER);
	    GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
	    gridData.horizontalSpan = 3;
	    nameText.setLayoutData(gridData);
	    ModifyListener listener = new ModifyListener(){
			
			public void modifyText(ModifyEvent e) {
				validate();
			}
	    };
	    nameText.addModifyListener(listener);
	    return composite;
	}
	
	/** (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#create() 
	 */
	public void create()
	{
		super.create();

	}
	
	
	protected void okPressed()
	{
		resString = nameText.getText();
		super.okPressed();
	}
	
	protected void validate()
	{
		String name = nameText.getText().trim();
		if (name.length()==0)
		{
			getButton(Dialog.OK).setEnabled(false);
			return;
		}
		getButton(Dialog.OK).setEnabled(true);
	}
}

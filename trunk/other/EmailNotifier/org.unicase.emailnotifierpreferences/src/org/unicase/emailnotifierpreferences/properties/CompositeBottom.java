package org.unicase.emailnotifierpreferences.properties;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class CompositeBottom extends Composite {

	private Button notificationServiceCheck;
	private Text emailText;
	
	CompositeBottom(Composite c, String s, Boolean b) {
		super(c, SWT.NONE);
		// Composite compositeBottom = new Composite(root, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(this);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(false, false).span(1, 1).applyTo(this);
		this.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_YELLOW));

		Label notiService = new Label(this, SWT.PUSH);
		notiService.setText("Activate E-Mail Notification Service ");
		notificationServiceCheck = new Button(this, SWT.CHECK | SWT.LEFT);
		Label emailAddress = new Label(this, SWT.PUSH);
		emailAddress.setText(s);
		emailText = new Text(this, SWT.SINGLE);
		emailText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		emailText.setVisible(!b);
	}

	public void activate(Boolean b){
		notificationServiceCheck.setSelection(b);
	}
	
	public Boolean getActivation(){
		return notificationServiceCheck.getSelection();
	}
	
	public String getEmail(){
		return emailText.getText();
	}
}

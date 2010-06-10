package org.unicase.emailnotifierpreferences.properties;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.model.emailnotificationgroup.NotificationGroup;
import org.unicase.model.emailnotificationgroup.impl.EmailnotificationgroupFactoryImpl;

public class CompositeBottom extends Composite {

	private Button notificationServiceCheck;
	private Text emailText;

	CompositeBottom(Composite c, String s, final Boolean existEmail, Boolean existUser) {
		super(c, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).applyTo(this);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).grab(false, false).applyTo(this);
		this.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_YELLOW));

		Composite top = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(top);
		Label notiService = new Label(top, SWT.PUSH);
		String activationText = "";
		if (existUser) {
			activationText = "Activate E-Mail Notification Service ";
		} else {
			activationText = "EMail Notifier Service cannot be turned on";
		}
		notiService.setText(activationText);
		notificationServiceCheck = new Button(top, SWT.CHECK | SWT.LEFT);
		notificationServiceCheck.setVisible(existUser);

		// Label emailAddress = new Label(this, SWT.PUSH);
		// emailAddress.setText(s);
		// emailText = new Text(this, SWT.SINGLE | SWT.BORDER);
		// GridDataFactory.fillDefaults().grab(false, false).hint(150, SWT.DEFAULT).applyTo(emailText);
		// emailText.setVisible(!existEmail);

		notificationServiceCheck.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				boolean selected = notificationServiceCheck.getSelection();
				if (selected == true) {
					if (existEmail) {
						InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(), "Add E-Mail address",
							"Enter 1-14 characters", "", null);
						if (dlg.open() == Window.OK) {

						}
					}
				}
			}
		});
	}

	public void activate(Boolean b) {
		notificationServiceCheck.setSelection(b);
	}

	public Boolean getActivation() {
		return notificationServiceCheck.getSelection();
	}

	public String getEmail() {
		return emailText.getText();
	}
}

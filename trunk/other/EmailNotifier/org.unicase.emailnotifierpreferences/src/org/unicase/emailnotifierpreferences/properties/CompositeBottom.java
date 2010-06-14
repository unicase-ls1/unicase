package org.unicase.emailnotifierpreferences.properties;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.emailnotifierpreferences.Activator;
import org.unicase.model.organization.User;

public class CompositeBottom extends Composite {

	private Button notificationServiceCheck;
	private User user;
	private boolean existEmail;
	private Composite main;
	private Composite compositeActivation;
	private Composite compositeEmail;

	CompositeBottom(Composite c, boolean existEmail, User user) {
		super(c, SWT.NONE);
		this.user = user;
		this.existEmail = existEmail;
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).applyTo(this);
		GridDataFactory.fillDefaults().applyTo(this);
		
		main = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).applyTo(main);
		compositeActivation();
		compositeEmail();
	}

	public void activate(Boolean b) {
		notificationServiceCheck.setSelection(b);
	}

	public Boolean getActivation() {
		return notificationServiceCheck.getSelection();
	}

	public void setExistEmail(Boolean b) {
		this.existEmail = b;
	}

	private Composite compositeActivation() {
		compositeActivation = new Composite(main, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(compositeActivation);
		GridDataFactory.fillDefaults().grab(false, true).applyTo(compositeActivation);
		Label notiService = new Label(compositeActivation, SWT.PUSH);
		notiService.setText("Activate Email Notification:");
		if (existEmail) {
			notificationServiceCheck = new Button(compositeActivation, SWT.CHECK | SWT.LEFT);
		} else {
			Label emailnotset = new Label(compositeActivation, SWT.PUSH);
			emailnotset.setText("Service cannto be activated. Please set an Email address first!");
		}
		return compositeActivation;
	}

	private Composite compositeEmail() {
		compositeEmail = new Composite(main, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(compositeEmail);
		GridDataFactory.fillDefaults().grab(false, true).applyTo(compositeEmail);
		if (existEmail) {
			Label email = new Label(compositeEmail, SWT.PUSH);
			email.setText("Notifications will be send to the following email address \"" + user.getEmail() + "\"");
			ImageHyperlink editButton = new ImageHyperlink(compositeEmail, SWT.TOP);
			editButton.setImage(Activator.getImageDescriptor("icons/email_edit.png").createImage());
			editButton.setToolTipText("Edit email address");

			editButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseUp(MouseEvent e) {
					InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(), "Edit email address",
						"Edit email address", user.getEmail(), null);
					if (dlg.open() == Window.OK) {
						try {
							user.setEmail(dlg.getValue());
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						compositeEmail.dispose();
						compositeEmail();
						main.layout();
					}
				}
			});
		} else {
			Label emailnotset = new Label(compositeEmail, SWT.PUSH);
			emailnotset.setText("No email address set!");
			ImageHyperlink addButton = new ImageHyperlink(compositeEmail, SWT.TOP);
			addButton.setImage(Activator.getImageDescriptor("icons/email_add.png").createImage());
			addButton.setToolTipText("Add an email address");

			addButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseUp(MouseEvent e) {
					InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(), "Add email address",
						"Add email address", "", null);
					if (dlg.open() == Window.OK) {
						try {
							user.setEmail(dlg.getValue());
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						setExistEmail(true);
						compositeActivation.dispose();
						compositeEmail.dispose();
						compositeActivation();
						compositeEmail();
						main.layout();
					}
				}
			});
		}
		return compositeEmail;
	}
}

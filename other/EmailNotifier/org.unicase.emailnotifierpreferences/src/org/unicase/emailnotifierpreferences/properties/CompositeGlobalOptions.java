/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.emailnotifierpreferences.Activator;
import org.unicase.model.organization.User;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * A Class for the EMail Notifier Service. The Constructor creates a Composite holding the options for the email address
 * and the activation of the service.
 * 
 * @author fuesescc
 */
public class CompositeGlobalOptions extends Composite {

	private Button notificationServiceCheck;
	private User user;
	private boolean existEmail;
	private Group main;
	private Composite compositeActivation;
	private Composite compositeEmail;

	/**
	 * The Constructor creates a Composite holding the options for the email address and the activation of the service.
	 * 
	 * @param c The parent composite.
	 * @param existEmail Boolean value that indicates whether the user has an email address set or not.
	 * @param user The user that is currently logged in and associated with the currently selected project.
	 */
	public CompositeGlobalOptions(Composite c, boolean existEmail, User user) {
		super(c, SWT.NONE);
		this.user = user;
		setExistEmail(existEmail);
		GridLayoutFactory.fillDefaults().applyTo(this);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(this);

		main = new Group(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().extendedMargins(0, 0, 5, 5).applyTo(main);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(main);
		main.setText("Global options for EMail Notifier");
		compositeActivation();
		compositeEmail();
	}

	private Composite compositeActivation() {
		compositeActivation = new Composite(main, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(compositeActivation);
		GridDataFactory.fillDefaults().grab(false, true).applyTo(compositeActivation);
		Label notiService = new Label(compositeActivation, SWT.PUSH);
		notiService.setText("Activate Email Notification:");
		if (existEmail) {
			notificationServiceCheck = new Button(compositeActivation, SWT.CHECK | SWT.LEFT);
		} else {
			Label emailnotset = new Label(compositeActivation, SWT.PUSH);
			emailnotset.setText("Service cannot be activated. Please set an Email address first!");
		}
		return compositeActivation;
	}

	private Composite compositeEmail() {
		compositeEmail = new Composite(main, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(compositeEmail);
		GridDataFactory.fillDefaults().grab(true, true).hint(SWT.DEFAULT, 20).applyTo(compositeEmail);
		if (existEmail) {
			Label email = new Label(compositeEmail, SWT.PUSH);
			email.setText("Notifications will be send to \"" + user.getEmail() + "\"");

			ImageHyperlink editButton = new ImageHyperlink(compositeEmail, SWT.TOP);
			editButton.setImage(Activator.getImageDescriptor("icons/email_edit.png").createImage());
			editButton.setToolTipText("Edit email address");

			editButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseUp(MouseEvent e) {
					String userEmail = new UnicaseCommandWithResult<String>() {
						@Override
						protected String doRun() {
							String s = user.getEmail();
							return s;
						}
					}.run();
					final InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(),
						"Edit email address", "Edit email address", userEmail, new EmailInputValidator());
					if (dlg.open() == Window.OK) {
						new UnicaseCommand() {
							@Override
							protected void doRun() {
								user.setEmail(dlg.getValue());
							}
						}.run();
						disposeCompositeEmail();
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
					final InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(), "Add email address",
						"Add email address", "", new EmailInputValidator());
					if (dlg.open() == Window.OK) {
						new UnicaseCommand() {
							@Override
							protected void doRun() {
								user.setEmail(dlg.getValue());
							}
						}.run();
						setExistEmail(true);
						disposeCompositeActivation();
						disposeCompositeEmail();
						compositeActivation();
						compositeEmail();
						main.layout();
					}
				}
			});
		}
		return compositeEmail;
	}

	private void disposeCompositeActivation() {
		if (compositeActivation != null) {
			compositeActivation.dispose();
		}
	}

	private void disposeCompositeEmail() {
		if (compositeEmail != null) {
			compositeEmail.dispose();
		}
	}

	/**
	 * Check the Activation checkbox.
	 * 
	 * @param b Boolean value that represents the status of the activation of the service.
	 */
	public void activate(Boolean b) {
		notificationServiceCheck.setSelection(b);
	}

	/**
	 * Get the selection of the Activation checkbox.
	 * 
	 * @return A boolean value that represents the status of the activation of the service.
	 */
	public Boolean getActivation() {
		return notificationServiceCheck.getSelection();
	}

	private void setExistEmail(Boolean b) {
		this.existEmail = b;
	}
}

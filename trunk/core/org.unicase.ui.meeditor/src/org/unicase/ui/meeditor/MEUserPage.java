/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;

/**
 * The read-only editor page for users.
 * 
 * @author shterev
 */
public class MEUserPage extends FormPage {

	private User user;
	private FormToolkit toolkit;

	private ScrolledForm form;
	private Composite top;
	private EditingDomain editingDomain;
	private Image image;
	private Text nameText;
	private Image scaledImage;

	/**
	 * Default constructor.
	 * 
	 * @param editor the {@link MEEditor}
	 * @param id the {@link FormPage#id}
	 * @param title the title
	 * @param editingDomain the editingDomain
	 * @param user the user
	 */
	public MEUserPage(MEEditor editor, String id, String title, EditingDomain editingDomain, User user) {
		super(editor, id, title);
		this.editingDomain = editingDomain;
		this.user = user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);

		toolkit = this.getEditor().getToolkit();
		form = managedForm.getForm();
		toolkit.decorateFormHeading(form.getForm());
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(form.getBody());
		form.setImage(Activator.getImageDescriptor("icons/comments.png").createImage());
		form.setText(getEditor().getTitle() + ": Discussion");
		form.getBody().setBackgroundMode(SWT.INHERIT_FORCE);
		form.getBody().setBackground(new Color(Display.getCurrent(), 225, 225, 225));
		top = new Composite(form.getBody(), SWT.NONE);
		GridLayoutFactory.fillDefaults().spacing(0, 0).numColumns(2).applyTo(top);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, true).applyTo(top);

		ImageHyperlink imageWidget = new ImageHyperlink(top, SWT.TOP);
		image = Activator.getImageDescriptor("icons/guest_thumb.png").createImage();
		int height = image.getBounds().height;
		int width = image.getBounds().width;
		double ratio = 150.0 / height;
		ImageData scaled = image.getImageData().scaledTo((int) (width * ratio), 150);
		scaledImage = new Image(Display.getCurrent(), scaled);
		imageWidget.setImage(scaledImage);
		GridDataFactory.fillDefaults().hint(-1, 150).applyTo(imageWidget);

		Composite personalData = new Composite(top, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(personalData);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(personalData);

		Label nameLabel = new Label(personalData, SWT.WRAP);
		nameLabel.setText("Username");
		nameText = new Text(personalData, SWT.WRAP);
		nameText.setText(user.getName());
		nameText.setEditable(false);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(nameText);

		Label firstNameLabel = new Label(personalData, SWT.WRAP);
		firstNameLabel.setText("Name");
		Text firstNameText = new Text(personalData, SWT.WRAP);
		firstNameText.setText(user.getFirstName() != null ? user.getFirstName() : "");
		firstNameText.setEditable(false);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(firstNameText);

		Label lastNameLabel = new Label(personalData, SWT.WRAP);
		lastNameLabel.setText("Surname");
		Text lastNameText = new Text(personalData, SWT.WRAP);
		lastNameText.setText(user.getLastName() != null ? user.getLastName() : "");
		lastNameText.setEditable(false);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(lastNameText);

		Label emailLabel = new Label(personalData, SWT.WRAP);
		emailLabel.setText("E-Mail");
		MEEmailControl emailControl = new MEEmailControl(OrganizationPackage.eINSTANCE.getUser_Email(), this
			.getEditor().getToolkit(), user, editingDomain);
		emailControl.createControl(personalData, SWT.READ_ONLY);

		form.pack();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		super.dispose();
		image.dispose();
		scaledImage.dispose();
	}

}
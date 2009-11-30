/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.meeditor.Activator;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.meeditor.mecontrols.METextControl;

/**
 * @author hamid Control for an email attribute. Includes a button to send an email.
 */
public class MEEmailControl extends AbstractMEControl {
	private METextControl meAreaControl;

	/**
	 * Default constructor.
	 * 
	 * @param attribute The mail attribute
	 * @param toolkit The swt toolkit
	 * @param modelElement The user
	 * @param editingDomain the edititng domain
	 */
	@Override
	public int init(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement,
		EditingDomain editingDomain, FormToolkit toolkit) {
		super.init(itemPropertyDescriptor, modelElement, editingDomain, toolkit);

		EStructuralFeature structuralFeature = (EStructuralFeature) itemPropertyDescriptor.getFeature(modelElement);
		if (structuralFeature.getName().equalsIgnoreCase("email")) {
			meAreaControl = new METextControl();
			meAreaControl.init(itemPropertyDescriptor, modelElement, editingDomain, toolkit);
			return 2;
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Control createControl(Composite parent, int style) {
		Composite composite = getToolkit().createComposite(parent, style);
		GridLayout gridLayout = new GridLayout(2, false);
		composite.setLayout(gridLayout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(composite);
		final Text txtEmail = (Text) meAreaControl.createControl(composite, style);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(txtEmail);
		final Action mail = new Action("Send email", SWT.PUSH) {

			@Override
			public void run() {
				String email = txtEmail.getText();
				Program.launch("mailto:" + email);
			}

		};
		Button button = new Button(composite, SWT.PUSH);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mail.run();
			}

		});
		button.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		button.setImage(Activator.getImageDescriptor("icons/mail.png").createImage());

		return parent;
	}

}

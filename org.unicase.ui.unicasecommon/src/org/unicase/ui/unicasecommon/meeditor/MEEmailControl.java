/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.ui.unicasecommon.meeditor.mecontrols.AbstractUnicaseMEControl;

/**
 * @author hamid Control for an email attribute. Includes a button to send an email.
 */
public class MEEmailControl extends AbstractUnicaseMEControl {
	private METextControl meAreaControl;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Control createControl(Composite parent, int style) {

		final EObject modelElement = getModelElement();
		Composite composite = getToolkit().createComposite(parent, style);
		GridLayout gridLayout = new GridLayout(2, false);
		composite.setLayout(gridLayout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(composite);
		meAreaControl = new METextControl();
		final Composite txtEmail = (Composite) meAreaControl.createControl(composite, style,
			getItemPropertyDescriptor(), modelElement, UnicaseActionHelper.getContext(modelElement), getToolkit());
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(txtEmail);
		final Action mail = new Action("Send email", SWT.PUSH) {

			@Override
			public void run() {

				EStructuralFeature feature = (EStructuralFeature) getItemPropertyDescriptor().getFeature(modelElement);
				String email = (String) modelElement.eGet(feature);
				ExtProgramFactoryFacade.useEmail("mailto:" + email);
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.AbstractMEControl#canRender(org.eclipse.emf.edit.provider.IItemPropertyDescriptor,
	 *      org.unicase.metamodel.ModelElement)
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		EStructuralFeature structuralFeature = (EStructuralFeature) itemPropertyDescriptor.getFeature(modelElement);
		if (structuralFeature.getName().equalsIgnoreCase("email")) {
			return 2;
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}

}

/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Spinner;
import org.unicase.ui.meeditor.Activator;

/**
 * Standard widgets to edit a double attribute.
 * 
 * @author helming
 */
public class MEDoubleControl extends AbstractMEControl {

	private EAttribute attribute;

	private Spinner spinner;

	private static final int PRIORITY = 1;

	/**
	 * {@inheritDoc}
	 * 
	 * @return A spinner for the double value.
	 */
	@Override
	public Control createControl(Composite parent, int style) {
		Object feature = getItemPropertyDescriptor().getFeature(getModelElement());
		this.attribute = (EAttribute) feature;
		int digits = 2; // default value
		EAnnotation annotation = attribute.getEAnnotation("org.unicase.ui.meeditor");
		if (annotation != null) {
			String digitsSetting = annotation.getDetails().get("digits");
			if (digitsSetting != null) {
				try {
					digits = Integer.parseInt(digitsSetting);
				} catch (NumberFormatException nfe) {
					Activator.logException(new IllegalArgumentException(
						"model element annotation 'digits' must be an integer"));
				}
			}
		}
		spinner = new Spinner(parent, style);
		spinner.setDigits(3);
		spinner.setDigits(digits);
		spinner.setMinimum(-1000);
		spinner.setMaximum(1000);
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeSelection(spinner), model, null, null);

		return spinner;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.AbstractMEControl#canRender(org.eclipse.emf.edit.provider.IItemPropertyDescriptor,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EAttribute && ((EAttribute) feature).getEType().getInstanceClass().equals(double.class)) {

			return PRIORITY;
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}

}

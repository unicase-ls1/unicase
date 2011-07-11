/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.editor.mecontrols;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.editor.Activator;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Spinner;

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
		EAnnotation annotation = attribute.getEAnnotation("org.eclipse.emf.ecp.editor");
		if (annotation != null) {
			String digitsSetting = annotation.getDetails().get("digits");
			if (digitsSetting != null) {
				try {
					digits = Integer.parseInt(digitsSetting);
				} catch (NumberFormatException nfe) {
					Activator.logException(new IllegalArgumentException(
						"Model element annotation 'digits' must be an integer"));
				}
			}
		}
		spinner = new Spinner(parent, style);
		spinner.setDigits(digits);
		spinner.setMinimum(-1000);
		spinner.setMaximum(1000);
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		DoubleSpinnerObservable spinnerObservable = new DoubleSpinnerObservable(spinner);
		dbc.bindValue(spinnerObservable, model, null, null);
		spinner.setSelection((int)(((Double) getModelElement().eGet(attribute)) * Math.pow(10, spinner.getDigits())));
		return spinner;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl#canRender(org.eclipse.emf.edit.provider.IItemPropertyDescriptor,
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

private class DoubleSpinnerObservable extends AbstractObservableValue {

	private double value;
	private Spinner spinner;
	private boolean currentlyUpdatingFlag;


	public DoubleSpinnerObservable(Spinner spinner){
		this.spinner = spinner;
		value = spinner.getSelection() / Math.pow(10, spinner.getDigits());
		spinner.addModifyListener(widgetListener);
	}
	
	private ModifyListener widgetListener = new ModifyListener() {
		
		public void modifyText(ModifyEvent e) {
			if (!currentlyUpdatingFlag) {
				double newValue = spinner.getSelection() / Math.pow(10, spinner.getDigits());
				fireValueChange(Diffs.createValueDiff(value, newValue));
				value = newValue;
			}
		}
	};
	
	@Override
	public synchronized void dispose() {
		spinner.removeModifyListener(widgetListener);
		super.dispose();
	}
	
	public Object getValueType() {
		return Double.class;
	}

	@Override
	protected Object doGetValue() {
		if (!spinner.isDisposed()) {
			return spinner.getSelection() * Math.pow(10, spinner.getDigits());
		}
		return null;
	}
	
	@Override
	protected void doSetValue(Object value) {
		if (value == null) {
			spinner.setSelection(0);
		} else if (value instanceof Double && !spinner.isDisposed()) {
			double oldVal;
			double newVal;
			try {
				currentlyUpdatingFlag = true;
				oldVal = spinner.getSelection() / Math.pow(10, spinner.getDigits());
				newVal = (Integer) value * Math.pow(10, spinner.getDigits());
				value = newVal;
				fireValueChange(Diffs.createValueDiff(oldVal, newVal));
			} finally {
				currentlyUpdatingFlag = false;
			}
		}
		
	}
}
}

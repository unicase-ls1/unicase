/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.metamodel.ModelElement;

/**
 * Standard widgets to edit a integer attribute.
 * 
 * @author helming
 */
public class MEIntControl extends AbstractMEControl implements MEControl {

	private EAttribute attribute;

	private Spinner spinner;

	private static final int PRIORITY = 1;

	/**
	 * Standard Constructor.
	 */
	public MEIntControl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int init(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement,
		EditingDomain editingDomain, FormToolkit toolkit) {
		init(itemPropertyDescriptor, modelElement, editingDomain, toolkit);

		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EAttribute && ((EAttribute) feature).getEType().getInstanceClass().equals(Integer.class)) {
			this.attribute = (EAttribute) feature;
			return PRIORITY;
		}
		return MEControl.DO_NOT_RENDER;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return A spinner for the int value.
	 */
	public Control createControl(Composite parent, int style) {
		spinner = new Spinner(parent, style);
		spinner.setMinimum(-1000);
		spinner.setMaximum(1000);
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeSelection(spinner), model, null, null);

		return spinner;
	}

}

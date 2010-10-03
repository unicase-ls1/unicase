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
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.unicase.metamodel.ModelElement;

/**
 * Standard widgets to edit a single line text attribute.
 * 
 * @author helming
 */
public class METextControl extends AbstractMEControl {

	private Text text;

	private EAttribute attribute;

	private static final int PRIORITY = 1;

	/**
	 * {@inheritDoc}
	 * 
	 * @return A Text Control.
	 */
	@Override
	public Control createControl(Composite parent, int style) {
		Object feature = getItemPropertyDescriptor().getFeature(getModelElement());
		this.attribute = (EAttribute) feature;
		text = getToolkit().createText(parent, new String(), style | SWT.SINGLE);
		if (!getItemPropertyDescriptor().canSetProperty(getModelElement())) {
			text.setEditable(false);
		}
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeText(text, SWT.FocusOut), model, null, null);
		return text;
	}

	/**
	 * . This sets the keyboard focus in Text control.
	 */
	public void setFocus() {
		this.text.setFocus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void applyCustomLayoutData() {
		GridDataFactory.fillDefaults().grab(true, false).hint(250, 16).align(SWT.FILL, SWT.TOP).applyTo(text);
	}

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement) {
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EAttribute && ((EAttribute) feature).getEType().getInstanceClass().equals(String.class)) {
			return PRIORITY;
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}

}

/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.editor.mecontrols;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

/**
 * This is the standard Control to edit boolean values.
 * 
 * @author shterev
 */
public class MEEnumControl extends AbstractMEControl implements IValidatableControl{

	private EAttribute attribute;

	private Combo combo;

	private static final int PRIORITY = 1;
	
	private Composite composite;
	
	private Label labelWidgetImage;  //Label for diagnostic image


	/**
	 * returns a check button without Label. {@inheritDoc}
	 * 
	 * @return Control
	 */
	@Override
	public Control createControl(Composite parent, int style) {		
		Object feature = getItemPropertyDescriptor().getFeature(getModelElement());
		this.attribute = (EAttribute) feature;
		composite = getToolkit().createComposite(parent, style);
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(2, 0).applyTo(composite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(composite);
		
		labelWidgetImage = getToolkit().createLabel(composite, "    ");
		labelWidgetImage.setBackground(parent.getBackground());

		combo = new Combo(composite, style | SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EList<EEnumLiteral> list = ((EEnum) attribute.getEType()).getELiterals();
		for (EEnumLiteral literal : list) {
			combo.add(literal.getLiteral());
		}
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeSelection(combo), model, null, null);
		return composite;
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
		if (feature instanceof EAttribute
			&& (EEnum.class).isAssignableFrom(((EAttribute) feature).getEType().getClass())) {

			return PRIORITY;
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}
	
	/**.
	 * {@inheritDoc}}
	 * */
	public void handleValidation(Diagnostic diagnostic) {
		if (diagnostic.getSeverity() == Diagnostic.ERROR || diagnostic.getSeverity() == Diagnostic.WARNING) {
			Image image = org.eclipse.emf.ecp.editor.Activator.getImageDescriptor("icons/validation_error.png").createImage();
			this.labelWidgetImage.setImage(image);
			this.labelWidgetImage.setToolTipText(diagnostic.getMessage());
		}
	}
	
	/**.
	 * {@inheritDoc}}
	 * */
	public void resetValidation() {
		this.labelWidgetImage.setImage(null);
		this.labelWidgetImage.setToolTipText("");
	}

}

/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * This is the standard Control to edit boolean values.
 * 
 * @author shterev
 * 
 */
public class MEEnumControl extends AbstractMEControl implements MEControl {

	private EAttribute attribute;

	private Combo combo;

	/**
	 * Standard Constructor. {@inheritDoc}
	 * 
	 * @param attribute
	 *            the boolean attribute
	 * @param toolkit
	 *            see {@link AbstractMEControl}
	 * @param modelElement
	 *            see {@link AbstractMEControl}
	 * @param editingDomain
	 *            see {@link AbstractMEControl}
	 */
	public MEEnumControl(EAttribute attribute, FormToolkit toolkit, EObject modelElement, EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
		this.attribute = attribute;
	}

	/**
	 * returns a check button without Label. {@inheritDoc}
	 * 
	 * @return Control
	 */
	public Control createControl(Composite parent, int style) {
		combo = new Combo(parent, style | SWT.DROP_DOWN | SWT.READ_ONLY);
		IObservableValue model = EMFEditObservables.observeValue(editingDomain, modelElement, attribute);
		EList<EEnumLiteral> list = ((EEnum)attribute.getEType()).getELiterals();
		for (EEnumLiteral literal : list){
			combo.add(literal.getLiteral());
		}
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeSelection(combo), model, null, null);
		return combo;
	}

}

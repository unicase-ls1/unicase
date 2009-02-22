/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.TableWrapData;

/**
 * Standard widgets to edit a single line text attribute.
 * 
 * @author helming
 * 
 */
public class METextControl extends AbstractMEControl implements MEControl {

	private Text text;

	private EAttribute attribute;

	/**
	 * Default Constructor.
	 * 
	 * @param attribute
	 *            the attribute which is shown in the Text Control
	 * @param toolkit
	 *            see {@link AbstractMEControl}
	 * @param modelElement
	 *            see {@link AbstractMEControl}
	 * @param editingDomain
	 *            see {@link AbstractMEControl}
	 */
	public METextControl(EAttribute attribute, FormToolkit toolkit,
			EObject modelElement, EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
		this.attribute = attribute;
	}

	/**
	 * {@inheritDoc}
	 * @return A Text Control. {@inheritDoc}
	 */
	public Control createControl(Composite parent, int style) {
		text = getToolkit().createText(parent, new String(), style | SWT.SINGLE);
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(),
				getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeText(text, SWT.FocusOut), model,
				null, null);
		TableWrapData layoutData = new TableWrapData(TableWrapData.FILL_GRAB);
		text.setLayoutData(layoutData);
		return text;
	}
	
	/**.
	 * This sets the keyboard focus in Text control.
	 */
	public void setFocus(){
		this.text.setFocus();
	}

}

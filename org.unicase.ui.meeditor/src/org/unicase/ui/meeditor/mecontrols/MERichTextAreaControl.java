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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.ui.meeditor.specialswtwidgets.RichTextArea;
import org.unicase.ui.meeditor.specialswtwidgets.RichTextAreaObserver;

/**
 * special HTML editor widget
 * 
 * @author Sebastian Höcht
 * 
 */
public class MERichTextAreaControl extends AbstractMEControl implements MEControl {

	private RichTextArea richTextArea;
	//private Text richTextArea;
	
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
	public MERichTextAreaControl(EAttribute attribute, FormToolkit toolkit, EObject modelElement, EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
		this.attribute = attribute;
	}

	/** 
	 * {@inheritDoc}
	 * 
	 * @return A Text Control. {@inheritDoc}
	 */
	public Control createControl(Composite parent, int style) {
		richTextArea = new RichTextArea(parent);
		richTextArea.setText("test MERichTextAreaControl");
		
		getToolkit().adapt(richTextArea);
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(new RichTextAreaObserver(richTextArea), model, null, null);
		//dbc.bindValue(SWTObservables.observeText(richTextArea, SWT.FocusOut), model, null, null);
		return richTextArea;
	}

	/**
	 * . This sets the keyboard focus in Text control.
	 */
	public void setFocus() {
		this.richTextArea.setFocus();
	}
		
}

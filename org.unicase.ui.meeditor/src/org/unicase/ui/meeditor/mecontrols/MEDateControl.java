/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor.mecontrols;

import java.util.Date;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
//import org.eclipse.nebula.widgets.cdatetime.CDT;
//import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Standard widgets to edit a date attribute.
 * 
 * @author shterev
 */
public class MEDateControl extends AbstractMEControl implements MEControl, SelectionListener {

	private EAttribute attribute;
//	private CDateTime widget;

	/**
	 * default constructor.
	 * 
	 * @param attribute
	 *            the date attribute
	 * @param toolkit
	 *            see {@link AbstractMEControl}
	 * @param modelElement
	 *            see {@link AbstractMEControl}
	 * @param editingDomain
	 *            see {@link AbstractMEControl}
	 */
	public MEDateControl(EAttribute attribute, FormToolkit toolkit,
			EObject modelElement, EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
		this.attribute = attribute;
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(Composite parent, int style) {
		Composite composite = toolkit.createComposite(parent);
		composite.setLayout(new GridLayout(2, false));

//		widget = new CDateTime(composite, CDT.BORDER | CDT.DROP_DOWN | CDT.COMPACT);
//		widget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
//		widget.setFormat(CDT.DATE_MEDIUM);
//		Date newDate = (Date)modelElement.eGet(attribute);
//		if(newDate!=null){
//			widget.setSelection(newDate);
//		}

// 		TODO AS: Implement with databindings
//		IObservableValue model = EMFEditObservables.observeValue(editingDomain,	modelElement, attribute);
//		IObservableValue target = new DateObservableValue(date);
//		EMFDataBindingContext dbc = new EMFDataBindingContext();
//		dbc.bindValue(target, model, null, null);

//		widget.addSelectionListener(this);
//		widget.addCalendarListener(this);
		return composite;

	}
	
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * {@inheritDoc}
	 */
	public void widgetSelected(SelectionEvent e) {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(modelElement);
		domain.getCommandStack().execute(new RecordingCommand(domain){
			@Override
			protected void doExecute() {
//				if(widget.getText().equals(" ")){
//					modelElement.eSet(attribute, null);
//				}else{
//					modelElement.eSet(attribute, widget.getSelection());
//				}
			}
		});
	}

}

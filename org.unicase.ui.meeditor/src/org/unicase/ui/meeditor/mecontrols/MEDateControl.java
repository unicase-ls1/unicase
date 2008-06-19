/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor.mecontrols;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.nebula.widgets.calendarcombo.CalendarCombo;
import org.eclipse.nebula.widgets.calendarcombo.ICalendarListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Standard widgets to edit a date attribute.
 * 
 * @author shterev
 */
public class MEDateControl extends AbstractMEControl implements MEControl, ICalendarListener {

	private EAttribute attribute;
	private CalendarCombo widget;

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

		widget = new CalendarCombo(composite, SWT.READ_ONLY);
		Date newDate = (Date)modelElement.eGet(attribute);
		if(newDate!=null){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(newDate);
			widget.setDate(calendar);
		}

// 		TODO AS: Implement with databindings
//		IObservableValue model = EMFEditObservables.observeValue(editingDomain,	modelElement, attribute);
//		IObservableValue target = new DateObservableValue(date);
//		EMFDataBindingContext dbc = new EMFDataBindingContext();
//		dbc.bindValue(target, model, null, null);
		widget.addCalendarListener(this);
		return composite;

	}

	/**
	 * Perform if the widget's date changed.
	 * @param date the new date 
	 */
	public void dateChanged(Calendar date) {
	final Calendar newDate = date;
	TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(modelElement);
	domain.getCommandStack().execute(new RecordingCommand(domain){
		protected void doExecute() {
			if(widget.getCombo().getText().equals(" ")){
				modelElement.eSet(attribute, null);
			}else{
				modelElement.eSet(attribute, newDate.getTime());
			}
		}
		});
	}
	
	/**
	 * Perform if the widget's date ranges changed.
	 * @param start the new start date 
	 * @param end the new end date 
	 */
	public void dateRangeChanged(Calendar start, Calendar end) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Perform when the widget is closed.
	 */
	public void popupClosed() {
		// TODO Auto-generated method stub
		
	}

}
